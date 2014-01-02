package com.arapov.pr.domain;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Recipient Document.
 *
 * @author Artem Arapov
 * Date: 16.12.13
 * Time: 18:32
 */
@Document(collection = "recipient")
public class RecipientDocument {

    @Id
    private String id;

    private String firstName;

    private String lastName;

    private String city;

    @Indexed(unique = true)
    private String email;

    private final Date postedDate = new Date();

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public Date getPostedDate() {
        return postedDate;
    }
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append(this.id).append(this.firstName).append(this.lastName).append(this.city).append(this.email);

        return builder.toString();
    }
}
