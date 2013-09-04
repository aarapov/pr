package com.arapov.pr.dao;

import com.arapov.pr.domain.Participant;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: tema
 * Date: 04.09.13
 * Time: 16:57
 * To change this template use File | Settings | File Templates.
 */
public interface ParticipantDao {
    void createParticipant(Participant entity);

    List<Participant> findAll();
}