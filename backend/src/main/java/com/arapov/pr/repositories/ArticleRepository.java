package com.arapov.pr.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.arapov.pr.domain.ArticleDocument;

/**
 * Article Repository.
 * 
 * @author Artem Arapov
 *
 */
public interface ArticleRepository extends MongoRepository<ArticleDocument, String> {

}
