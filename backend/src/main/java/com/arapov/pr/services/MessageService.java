package com.arapov.pr.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arapov.pr.domain.MessageDocument;
import com.arapov.pr.repositories.MessageRepository;

/**
 * Business logic layer for {@link MessageDocument}.
 * 
 * @author Artem Arapov
 *
 */
@Service
public class MessageService {

    @Autowired
    private MessageRepository repository;

    /**
     * Save specified {@link MessageDocument}.
     * 
     * @param document - Not <code>null</code>.
     */
    public void saveMessage(MessageDocument document) {
        repository.save(document);
    }
}
