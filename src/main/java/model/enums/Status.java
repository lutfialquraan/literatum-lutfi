package model.enums;

public enum Status {


    UNPROCESSED(0), PROCESSING(1), PROCESSED(2);

    private final int value;


    Status (int value) {
        this.value=value;
    }

    public int getValue() {
        return value;
    }


}
