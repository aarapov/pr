package com.arapov.pr.repositories;

import com.arapov.pr.domain.RecipientDocument;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Test cases for {@link RecipientRepository}.
 *
 * @author Artem Arapov
 * Date: 16.12.13
 * Time: 19:01
 */
@ContextConfiguration(locations = {"/spring/applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class RecipientRepositoryTestIT {
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

    private RecipientDocument createRecipient() {
        RecipientDocument document = new RecipientDocument();
        document.setFirstName("First Name: " + Math.random());
        document.setLastName("Last Name: " + Math.random());
        document.setCity("City: " + Math.random());
        document.setEmail("Email: " + Math.random());

        return document;
    }
}
