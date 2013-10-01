package com.arapov.pr.dao.impl;

import com.arapov.pr.dao.ParticipantDao;
import com.arapov.pr.domain.Accommodation;
import com.arapov.pr.domain.Participant;
import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: tema
 * Date: 04.09.13
 * Time: 17:02
 * To change this template use File | Settings | File Templates.
 */
@Transactional
@TransactionConfiguration(defaultRollback = true)
@ContextConfiguration(locations = { "/spring/applicationContext.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class ParticipantDaoImplIT {

    @Autowired
    private ParticipantDao dao;

    @Test
    public void testFindAll() {
        List<Participant> actualResult = dao.findAll();

        Assert.assertNotNull(actualResult);
    }

    @Test
    public void testSave() {
        Participant expectedEntity = createParticipant();
        dao.save(expectedEntity);
    }

    private Participant createParticipant() {
        Participant entity = new Participant();
        entity.setFirstName("FirstName");
        entity.setLastName("LastName");
        entity.setCity("City");
        entity.setEmail("a@a.com");
        entity.setPhone("123456");
        entity.setAccommodation(Accommodation.SELF_ACCOMODATION);
        entity.setNeedCoffeeBreak(Boolean.TRUE);
        entity.setNeedLunch(Boolean.TRUE);
        entity.setNotes("Some notes");
        entity.setCreatedDate(new Date());

        return entity;
    }
}
