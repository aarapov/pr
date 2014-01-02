package com.arapov.pr.repositories;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.arapov.pr.AbstractIntegrationTest;
import com.arapov.pr.domain.RecipientDocument;

/**
 * Test cases for {@link RecipientRepository}.
 *
 * @author Artem Arapov
 * Date: 16.12.13
 * Time: 19:01
 */
public class RecipientRepositoryTestIT extends AbstractIntegrationTest {
    @Autowired
    private RecipientRepository sut;

    @Test
    public void testFindAll() {
        List<RecipientDocument> actualList = sut.findAll();
        Assert.assertNotNull(actualList);
    }

    @Test
    public void testSave() {
        RecipientDocument expectedDocument = createRecipient();

        sut.save(expectedDocument);
    }

    @Test
    public void testFindByFirstName() {
        List<RecipientDocument> actualList = sut.findByFirstName("sana");
        Assert.assertNotNull(actualList);
        Assert.assertFalse(actualList.isEmpty());
    }

    @Test
    public void testFindByEmail() {
        RecipientDocument actual = sut.findByEmail("a@a.com");
        Assert.assertNotNull(actual);
    }

    private RecipientDocument createRecipient() {
        RecipientDocument document = new RecipientDocument();
        document.setFirstName("First Name: " + Math.random());
        document.setLastName("Last Name: " + Math.random());
        document.setCity("City: " + Math.random());
        document.setEmail("Email: " + Math.random());

        return document;
    }
}
