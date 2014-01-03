package com.arapov.pr.domain;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Message Document.
 * 
 * @author Artem Arapov
 *
 */
@Document(collection = "messages")
public class MessageDocument {

    @Id
    private String id;

    private String name;

    private String subject;

    private String email;

    private String message;

    private final Date postedDate = new Date();


    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getPostedDate() {
        return postedDate;
    }
}
