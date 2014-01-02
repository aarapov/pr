package com.arapov.pr.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arapov.pr.domain.RecipientDocument;
import com.arapov.pr.repositories.RecipientRepository;

/**
 * Business logic service for {@link RecipientDocument}.
 * 
 * @author Artem Arapov
 *
 */
@Service
public class RecipientService {

    @Autowired
    private RecipientRepository repository;

    public void saveRecipient(RecipientDocument document) {
        repository.save(document);
    }

    public List<RecipientDocument> getAllRecipients() {
        return repository.findAll();
    }
}
