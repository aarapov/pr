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

    /**
     * Find {@link RecipientDocument} by specified email.
     * 
     * @param email - Not <code>null</code> value.
     * @return {@link RecipientDocument} in success or <code>null</code> in other case.
     */
    RecipientDocument findByEmail(String email);

    /**
     * Find List of {@link RecipientDocument} by specified firstName and lastName.
     * 
     * @param firstName - Not <code>null</code> value.
     * @param lastName - Not <code>null</code> value.
     * @return {@link List} of entities in success or empty List in other case. 
     */
    List<RecipientDocument> findByFirstNameAndLastName(String firstName, String lastName);
}
