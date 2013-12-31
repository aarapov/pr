package com.arapov.pr.resource;

/**
 * DTO to transfer  Accommodation object.
 *
 * @author Artem Arapov
 * Date: 03.10.13
 * Time: 21:31
 */
public class AccommodationDTO {
    private String key;

    private String value;

    /**
     * Default Constructor.
     */
    public AccommodationDTO() {
    }

    /**
     * Constructor.
     *
     * @param key - value for key field.
     * @param value - value.
     */
    public AccommodationDTO(String key, String value) {
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
