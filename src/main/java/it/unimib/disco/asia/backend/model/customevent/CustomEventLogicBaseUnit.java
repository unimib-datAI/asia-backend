package it.unimib.disco.asia.backend.model.customevent;

public class CustomEventLogicBaseUnit {

    private String propertyID;
    private String operator;
    private String value;
    private boolean column;


    private CustomEventLogicBaseUnit(String propertyID) {
        this.propertyID = propertyID;
    }

    public CustomEventLogicBaseUnit() {
    }

    public String getPropertyID() {
        return propertyID;
    }

    public void setPropertyID(String propertyID) {
        this.propertyID = propertyID;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean isColumn() {
        return column;
    }

    public void setColumn(boolean column) {
        this.column = column;
    }
}
