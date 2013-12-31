package com.arapov.pr.repositories;

import com.arapov.pr.domain.RecipientDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Recipient Repository.
 *
 * @author Artem Arapov
 * Date: 16.12.13
 * Time: 18:40
 */
public interface RecipientRepository extends MongoRepository<RecipientDocument, String> {
}
