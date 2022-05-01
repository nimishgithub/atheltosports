package com.me.athletosports.pojo;

public enum SportType {

    SQUASH(1),
    LAWN_TENNIS(2),
    TABLE_TENNIS(3),
    BADMINTON(4);

    private int value;

    SportType(int value) {
        this.value = value;
    }


    public int getValue() {
        return value;
    }

    public int capacity() {
        switch (this) {
            case SQUASH:
                return 12;
            case LAWN_TENNIS:
                return 6;
            case TABLE_TENNIS:
                return 8;
            case BADMINTON:
                return 10;
        }
        return 0;
    }

}