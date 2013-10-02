package com.arapov.pr.resource;

import com.arapov.pr.domain.Accommodation;
import com.arapov.pr.domain.Participant;
import com.arapov.pr.service.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: tema
 * Date: 04.09.13
 * Time: 17:34
 * To change this template use File | Settings | File Templates.
 */
@Controller
@Transactional(readOnly = true)
@RequestMapping("/participants")
public class ParticipantsResource {
    @Autowired
    private ParticipantService service;

    @RequestMapping(method = RequestMethod.GET, value = "/accommodation")
    @ResponseBody
    public List<Accommodation> getAccommodationTypes() {
        return Arrays.asList(Accommodation.values());
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Participant> getAllParticipants() {
        return service.getAllParticipants();
    }

    @Transactional(readOnly = false, rollbackFor = Exception.class)
    @RequestMapping(method = RequestMethod.POST)
    public void createParticipant(@RequestBody Participant entity) {
        service.createParticipant(entity);
    }
}
