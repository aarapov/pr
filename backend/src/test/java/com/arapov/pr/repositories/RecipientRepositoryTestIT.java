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
    private static final String EXPECTED_FIRST_NAME = "sana";
    
    private static final String EXPECTED_LAST_NAME = "arapova";
    
    private static final String EXPECTED_EMAIL = "a@a.com";
    
    @Autowired
    private RecipientRepository sut;

    @Test
    public void testFindAll() {
        List<RecipientDocument> actualList = sut.findAll();
        Assert.assertNotNull(actualList);
        Assert.assertFalse(actualList.isEmpty());
    }

    @Test
    public void testSave() {
        RecipientDocument expectedDocument = createRecipient();

        sut.save(expectedDocument);
    }

    @Test
    public void testFindByFirstName() {
        List<RecipientDocument> actualList = sut.findByFirstNameAndLastName(EXPECTED_FIRST_NAME, EXPECTED_LAST_NAME);
        Assert.assertNotNull(actualList);
        Assert.assertFalse(actualList.isEmpty());

        RecipientDocument actualDocument = actualList.get(0);
        Assert.assertNotNull(actualDocument);

        Assert.assertEquals(EXPECTED_FIRST_NAME, actualDocument.getFirstName());
        Assert.assertEquals(EXPECTED_LAST_NAME, actualDocument.getLastName());
    }

    @Test
    public void testFindByEmail() {
        RecipientDocument actual = sut.findByEmail(EXPECTED_EMAIL);
        Assert.assertNotNull(actual);

        Assert.assertEquals(EXPECTED_EMAIL, actual.getEmail());
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
