package it.unimib.disco.asia.backend.controller;


import it.unimib.disco.asia.backend.model.customevent.CustomEventLogicBaseUnit;
import it.unimib.disco.asia.backend.service.CustomEventsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomEvents {

    @Autowired
    private CustomEventsService customEventsService;

    @RequestMapping(value = "customevents/match", produces = "application/json")
    public String matchCustomEvents(@RequestBody List<List<CustomEventLogicBaseUnit>> lstLogic) {


        return customEventsService.retrieveIds(lstLogic).toString();

    }

    @RequestMapping(value = "customevents/select", produces = "application/json")
    public String queryCustomEvents(@RequestParam String ids,
                                    @RequestParam String propIds) {
        String[] eventIds = ids.split(",");
        String[] propertyIDs = propIds.split(",");

        return customEventsService.findByIds(eventIds, propertyIDs).toString();

    }

}
