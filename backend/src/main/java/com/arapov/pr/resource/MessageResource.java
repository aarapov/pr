package com.arapov.pr.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.arapov.pr.domain.MessageDocument;
import com.arapov.pr.services.MessageService;

/**
 * RESTful service for {@link MessageDocument}.
 * 
 * @author Artem Arapov
 *
 */
@Controller
@RequestMapping("/message")
public class MessageResource {

    @Autowired
    private MessageService service;

    /**
     * Save specified {@link MessageDocument}.
     * 
     * @param document - Not <code>null</code>.
     */
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public void saveMessage(@RequestBody MessageDocument document) {
        service.saveMessage(document);
    }
}
