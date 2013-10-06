package com.arapov.pr.dao.Impl;

import com.arapov.pr.dao.ParticipantDao;
import com.arapov.pr.domain.ParticipantEntity;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: tema
 * Date: 04.09.13
 * Time: 16:58
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class ParticipantDaoImpl implements ParticipantDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(ParticipantEntity entity) {
        sessionFactory.getCurrentSession().save(entity);
    }

    @Override
    public List<ParticipantEntity> findAll() {
        return sessionFactory.getCurrentSession().createCriteria(ParticipantEntity.class).list();
    }
}
