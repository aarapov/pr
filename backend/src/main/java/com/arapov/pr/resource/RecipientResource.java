package com.arapov.pr.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.arapov.pr.domain.RecipientDocument;
import com.arapov.pr.services.RecipientService;

/**
 * RESTful service for {@link RecipientDocument}.
 * 
 * @author Artem Arapov
 *
 */
@Controller
@RequestMapping("/recipients")
public class RecipientResource {

    @Autowired
    private RecipientService service;

    /**
     * Save specified {@link RecipientDocument}.
     * 
     * @param document - Not <code>null</code>.
     */
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public void saveRecipient(@RequestBody RecipientDocument document) {
        service.saveRecipient(document);
    }

    /**
     * Get all Recipients.
     * 
     * @return {@link List} of {@link RecipientDocument}.
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public List<RecipientDocument> getAllRecipients() {
        return service.getAllRecipients();
    }
}
