package com.arapov.pr.resource;

import com.arapov.pr.domain.Accommodation;
import com.arapov.pr.domain.ParticipantEntity;
import com.arapov.pr.service.ParticipantService;
import org.omg.CORBA.PERSIST_STORE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

/**
 * Resource for {@link com.arapov.pr.domain.ParticipantEntity} objects.
 *
 * @author Artem Arapov
 * Date: 04.09.13
 * Time: 17:34
 */
@Controller
@Transactional(readOnly = true)
@RequestMapping("/registration")
public class ParticipantsResource {
    @Autowired
    private ParticipantService service;

    @RequestMapping(method = RequestMethod.GET, value = "/accommodation")
    @ResponseBody
    public List<AccommodationDTO> getAccommodationTypes() {
        List<AccommodationDTO> result = new ArrayList<AccommodationDTO>();
        for (Accommodation item : Accommodation.values()) {
            result.add(new AccommodationDTO(item.name(), item.getDescription()));
        }
        return result;
    }

    @RequestMapping(value = "/participants", method = RequestMethod.GET)
    @ResponseBody
    public List<ParticipantEntity> getAllParticipants() {
        return service.getAllParticipants();
    }

    @Transactional(readOnly = false, rollbackFor = Exception.class)
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public void createParticipant(@RequestBody ParticipantEntity entity) throws Exception {
        ParticipantEntity decoded = decodeEntity(entity);
        service.createParticipant(decoded);
    }

    private ParticipantEntity decodeEntity(ParticipantEntity source) throws Exception {
        ParticipantEntity result = new ParticipantEntity();
        result.setFirstName(URLDecoder.decode(source.getFirstName(), "UTF-8"));
        result.setLastName(URLDecoder.decode(source.getLastName(), "UTF-8"));
        result.setCity(URLDecoder.decode(source.getCity(), "UTF-8"));
        result.setEmail(source.getEmail());
        result.setPhone(source.getPhone());
        result.setAccommodation(source.getAccommodation());
        result.setFriday(source.getFriday());
        result.setSaturday(source.getSaturday());
        result.setSunday(source.getSunday());
        result.setNeedLunch(source.getNeedLunch());
        result.setNeedCoffeeBreak(source.getNeedCoffeeBreak());
        result.setNotes(URLDecoder.decode(source.getNotes(), "UTF-8"));

        return result;
    }
}
