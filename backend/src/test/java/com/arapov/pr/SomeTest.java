package com.arapov.pr;

import com.arapov.pr.domain.RecipientDocument;
import com.arapov.pr.repositories.RecipientRepository;
import org.junit.Test;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author: Artem Arapov
 * Date: 08.12.13
 * Time: 20:41
 */
@ContextConfiguration(locations = {"/spring/applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class SomeTest {

    @Autowired
    private RecipientRepository sut;

    @Test
    public void testFindAll() {
        List<RecipientDocument> actualList = sut.findAll();
        Assert.assertNotNull(actualList);
    }
}
