package it.unimib.disco.asia.backend.service;

import com.arangodb.ArangoCursor;
import com.arangodb.model.AqlQueryOptions;
import com.arangodb.springframework.core.ArangoOperations;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.sisyphsu.dateparser.DateParserUtils;
import com.google.common.base.Strings;
import it.unimib.disco.asia.backend.model.customevent.CustomEventLogicBaseUnit;
import it.unimib.disco.asia.backend.repository.CustomEventRepository;
import org.apache.commons.collections.IteratorUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Lazy
public class CustomEventsService {


    private final CustomEventRepository customEventRepository;
    private final ArangoOperations template;
    private final ObjectMapper objectMapper;


    public CustomEventsService(ArangoOperations template, CustomEventRepository customEventRepository) {
        this.template = template;
        this.objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        this.customEventRepository = customEventRepository;
    }


    public List<String> retrieveIds(List<List<CustomEventLogicBaseUnit>> lstLogicUnit) {
        Pair<String, Map<String, Object>> pair = buildIdQuery(lstLogicUnit);
        ArangoCursor<String> returnedEvent =
                template.query(pair.getFirst(),
                        pair.getSecond(),
                        new AqlQueryOptions(), String.class);


        return IteratorUtils.toList(returnedEvent);
    }

    public List<String> findByIds(String[] eventIds, String[] propertyIDs) {

        String base = " for event in `CustomEvents`\n" + " FILTER  \n";
        StringBuilder stringBuilder = new StringBuilder(base);
        Map<String, Object> bindVars = new HashMap<>();
        stringBuilder.append("event._id IN @ids \n ");
        bindVars.put("ids", eventIds);
        stringBuilder.append("RETURN {\n");
        String baseValue = "@value";
        stringBuilder.append("\"id\": " + "event._id\n");

        for (int i = 0; i < propertyIDs.length; i++) {
            stringBuilder.append(",\n");
            stringBuilder.append("\"" + propertyIDs[i] + "\": " + "event." + propertyIDs[i]);
        }
        stringBuilder.append("\n}");

        System.out.println(stringBuilder.toString());

        ArangoCursor<String> returnedEvent =
                template.query(stringBuilder.toString(),
                        bindVars,
                        new AqlQueryOptions(), String.class);


        return IteratorUtils.toList(returnedEvent);

    }

    private Pair<String, Map<String, Object>> buildIdQuery(List<List<CustomEventLogicBaseUnit>> lstLogicUnit) {

        int genIndex = 0;

        String base = " for event in `CustomEvents`\n" + " FILTER  \n";
        StringBuilder stringBuilder = new StringBuilder(base);
        Map<String, Object> bindVars = new HashMap<>();


        for (int extI = 0; extI < lstLogicUnit.size(); extI++) {
            List<CustomEventLogicBaseUnit> lstUnits = lstLogicUnit.get(extI);

            if (extI != 0) stringBuilder.append("OR\n");
            genIndex = buildSubQuery(genIndex, stringBuilder, bindVars, lstUnits);

        }

        stringBuilder.append("RETURN event._id");

//        System.out.println(stringBuilder.toString());

        return Pair.of(stringBuilder.toString(), bindVars);
    }

    private int buildSubQuery(int genIndex,
                              StringBuilder stringBuilder,
                              Map<String, Object> bindVars,
                              List<CustomEventLogicBaseUnit> lstUnits) {
        stringBuilder.append("(\n ");
        for (int i = 0; i < lstUnits.size(); i++) {
            String value = lstUnits.get(i).getValue();
            if (i != 0) stringBuilder.append("AND\n ");
            if (NumberUtils.isParsable(value)) {
                genIndex = buildAlternativeNumericSubQuery(genIndex, stringBuilder, bindVars, lstUnits.get(i));
            } else if (checkBoolean(value)) {
                genIndex = buildAlternativeBooleanSubQuery(genIndex, stringBuilder, bindVars, lstUnits.get(i));
            } else if (checkDate(value)) {
                genIndex = buildAlternativeDateSubQuery(genIndex, stringBuilder, bindVars, lstUnits.get(i));
            } else {
                genIndex = buildGeneralSubQuery(genIndex, stringBuilder, bindVars,
                        lstUnits.get(i).getPropertyID(), lstUnits.get(i).getOperator(), lstUnits.get(i).getValue());
            }
        }
        stringBuilder.append(")\n ");
        return genIndex;
    }

    private boolean checkDate(String value) {

        try {
            Date date = DateParserUtils.parseDate(value);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    private int buildAlternativeDateSubQuery(int genIndex, StringBuilder stringBuilder, Map<String, Object> bindVars, CustomEventLogicBaseUnit unit) {
        stringBuilder.append("(\n ");
        genIndex = buildGeneralSubQuery(genIndex, stringBuilder, bindVars,
                unit.getPropertyID(), unit.getOperator(), unit.getValue());
        stringBuilder.append("OR\n");

        String date = DateParserUtils.parseDateTime(unit.getValue()).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        String value = "@value" + genIndex;
        bindVars.put("value" + genIndex, date);
        genIndex += 1;

        stringBuilder.append("DATE_TRUNC(event." + unit.getPropertyID() + ", \"day\")" + " " + unit.getOperator() + " " + value);
        stringBuilder.append(System.getProperty("line.separator")); //newline
        stringBuilder.append(")\n ");

        return genIndex;


    }

    private int buildAlternativeBooleanSubQuery(int genIndex, StringBuilder stringBuilder,
                                                Map<String, Object> bindVars,
                                                CustomEventLogicBaseUnit unit) {
        stringBuilder.append("(\n ");
        genIndex = buildGeneralSubQuery(genIndex, stringBuilder, bindVars,
                unit.getPropertyID(), unit.getOperator(), unit.getValue());
        stringBuilder.append("OR\n");
        genIndex = buildGeneralSubQuery(genIndex, stringBuilder, bindVars,
                unit.getPropertyID(), unit.getOperator(), Boolean.valueOf(unit.getValue().toLowerCase().trim()));
        stringBuilder.append(")\n ");
        return genIndex;
    }

    private int buildAlternativeNumericSubQuery(int genIndex,
                                                StringBuilder stringBuilder,
                                                Map<String, Object> bindVars,
                                                CustomEventLogicBaseUnit unit) {

        stringBuilder.append("(\n ");
        genIndex = buildGeneralSubQuery(genIndex, stringBuilder, bindVars,
                unit.getPropertyID(), unit.getOperator(), unit.getValue());
        stringBuilder.append("OR\n");
        genIndex = buildGeneralSubQuery(genIndex, stringBuilder, bindVars,
                unit.getPropertyID(), unit.getOperator(), Float.parseFloat(unit.getValue()));
        stringBuilder.append(")\n ");
        return genIndex;
    }

    private int buildGeneralSubQuery(int genIndex, StringBuilder stringBuilder,
                                     Map<String, Object> bindVars,
                                     String propertyID, String operator, Object objValue) {
        String value = "@value" + genIndex;
        bindVars.put("value" + genIndex, objValue);
        genIndex += 1;

        stringBuilder.append("event." + propertyID + " " + operator + " " + value);
        stringBuilder.append(System.getProperty("line.separator")); //newline
        return genIndex;
    }

    private boolean checkBoolean(String strToCheck) {
        if (Strings.isNullOrEmpty(strToCheck)) return false;
        String str = strToCheck.toLowerCase().trim();
        return str.equalsIgnoreCase("true") || str.equalsIgnoreCase("false");
    }


}
