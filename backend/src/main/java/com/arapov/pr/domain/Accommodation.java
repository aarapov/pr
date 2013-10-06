package com.arapov.pr.domain;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: tema
 * Date: 01.10.13
 * Time: 19:36
 * To change this template use File | Settings | File Templates.
 */
public enum Accommodation {
    KAZACKIY("Отель Казацкий"), SENATOR("Отель Сенатор"), SELF_ACCOMODATION("Мне не нужно проживание");

    private String description;

    private Accommodation(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }
}
