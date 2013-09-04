package com.arapov.pr.service;

import com.arapov.pr.domain.Participant;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: tema
 * Date: 04.09.13
 * Time: 17:36
 * To change this template use File | Settings | File Templates.
 */
public interface ParticipantService {
    List<Participant> getAllParticipants();

    void createParticipant(Participant entity);
}
