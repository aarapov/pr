package com.arapov.pr.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.arapov.pr.domain.MessageDocument;

/**
 * Message Repository.
 * 
 * @author Artem Arapov
 *
 */
public interface MessageRepository extends MongoRepository<MessageDocument, String> {

}
