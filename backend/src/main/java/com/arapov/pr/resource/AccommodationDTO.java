package com.arapov.pr.resource;

import com.arapov.pr.domain.Accommodation;

/**
 * DTO to transfer {@link Accommodation} object.
 *
 * @author: Artem Arapov
 * Date: 03.10.13
 * Time: 21:31
 */
public class AccommodationDTO {
    private String key;

    private String value;

    public AccommodationDTO(){}

    public AccommodationDTO(String key, String value){
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
