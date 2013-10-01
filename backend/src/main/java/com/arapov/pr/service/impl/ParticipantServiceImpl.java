package com.arapov.pr.service.impl;

import com.arapov.pr.dao.ParticipantDao;
import com.arapov.pr.domain.Participant;
import com.arapov.pr.service.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: tema
 * Date: 04.09.13
 * Time: 17:37
 * To change this template use File | Settings | File Templates.
 */
@Service
@Transactional
public class ParticipantServiceImpl implements ParticipantService {
    @Autowired
    private ParticipantDao dao;

    @Override
    public List<Participant> getAllParticipants() {
        return dao.findAll();
    }

    @Override
    public void createParticipant(Participant entity) {
        entity.setCreatedDate(new Date());
        dao.save(entity);
    }
}
