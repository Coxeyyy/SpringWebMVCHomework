package com.coxey.app.model;

public enum JobTitle {
    DEVELOPER("Разработчик"),
    ANALYST("Аналитик"),
    DEVOPS("Девопсер");

    private final String value;

    JobTitle(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
