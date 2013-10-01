package com.arapov.pr.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: tema
 * Date: 04.09.13
 * Time: 16:35
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "PARTICIPANTS")
public class Participant implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "CITY")
    private String city;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PHONE")
    private String phone;

    @Column(name = "ACCOMMODATION")
    @Enumerated(EnumType.STRING)
    private Accommodation accommodation;

    @Column(name = "NEED_LUNCH")
    private Boolean needLunch;

    @Column(name = "NEED_COFFEE_BREAK")
    private Boolean needCoffeeBreak;

    @Column(name = "NOTES")
    private String notes;

    @Column(name = "CREATED_DATE")
    private Date createdDate;

    @Version
    @Column(name = "VERSION")
    private Long version = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Accommodation getAccommodation() {
        return accommodation;
    }

    public void setAccommodation(Accommodation accommodation) {
        this.accommodation = accommodation;
    }

    public Boolean getNeedLunch() {
        return needLunch;
    }

    public void setNeedLunch(Boolean needLunch) {
        this.needLunch = needLunch;
    }

    public Boolean getNeedCoffeeBreak() {
        return needCoffeeBreak;
    }

    public void setNeedCoffeeBreak(Boolean needCoffeeBreak) {
        this.needCoffeeBreak = needCoffeeBreak;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}
