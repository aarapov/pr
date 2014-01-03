package com.arapov.pr.repositories;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.arapov.pr.AbstractIntegrationTest;
import com.arapov.pr.domain.MessageDocument;

/**
 * Integration Test for {@link MessageRepository}.
 * 
 * @author Artem Arapov
 *
 */
public class MessageRepositoryTestIT extends AbstractIntegrationTest {

    @Autowired
    private MessageRepository sut;

    @Test
    public void testSave() {
        MessageDocument expectedDoc = createRandomDocument();

        sut.save(expectedDoc);
        Assert.assertNotNull(expectedDoc.getId());
    }

    private MessageDocument createRandomDocument() {
        MessageDocument doc = new MessageDocument();

        doc.setName("Name: " + Math.random());
        doc.setSubject("Subject: " + Math.random());
        doc.setEmail("a@a.com");
        doc.setMessage("Message: " + Math.random());

        return doc;
    }
}
