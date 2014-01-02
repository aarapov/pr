package com.arapov.pr.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.arapov.pr.domain.RecipientDocument;

/**
 * Recipient Repository.
 *
 * @author Artem Arapov
 * Date: 16.12.13
 * Time: 18:40
 */
public interface RecipientRepository extends MongoRepository<RecipientDocument, String> {
    RecipientDocument findByEmail(String email);

    List<RecipientDocument> findByFirstName(String firstName);
}
