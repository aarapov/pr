package com.arapov.pr.domain;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Article Document.
 * 
 * @author Artem Arapov
 *
 */
@Document(collection = "articles")
public class ArticleDocument {

    @Id
    private String id;

    private String caption;

    private String content;

    private final Date postedDate = new Date();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPostedDate() {
        return postedDate;
    }
}
