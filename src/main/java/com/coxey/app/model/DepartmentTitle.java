package com.coxey.app.model;

public enum DepartmentTitle {
    DEVELOPERS("Разработка"),
    ANALYSTS("Аналитики"),
    DEVOPSES("Девопсеры");

    private final String value;

    DepartmentTitle(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
