package com.arapov.pr;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mongeez.MongeezRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Abstract Integration Test class.
 * 
 * @author Artem Arapov
 *
 */
@ContextConfiguration(locations = {"/spring/testApplicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public abstract class AbstractIntegrationTest {

    @Autowired
    private MongeezRunner mongeezRunner;

    @Before
    public void setUp() {
        mongeezRunner.execute();
    }
}
