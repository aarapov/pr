package com.arapov.pr.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.arapov.pr.domain.ArticleDocument;
import com.arapov.pr.repositories.ArticleRepository;

/**
 * Business Logic layer for {@link ArticleDocument}.
 * 
 * @author Artem Arapov
 *
 */
@Service
public class ArticleService {

    private static final int PAGE_NUM = 0;
    private static final int PAGE_SIZE = 3;
    private static final Sort.Direction DIRECTION = Sort.Direction.DESC;

    @Autowired
    private ArticleRepository repository;

    /**
     * Returns all available {@link ArticleDocument}.
     * 
     * @return List of {@link ArticleDocument}.
     */
    public List<ArticleDocument> getAllArticles() {
        return repository.findAll();
    }

    /**
     * Returns Page of {@link ArticleDocument}.
     * 
     * @return Page of {@link ArticleDocument}.
     */
    public Page<ArticleDocument> getLastArticles() {
        Pageable pageRequest = new PageRequest(PAGE_NUM, PAGE_SIZE, DIRECTION);

        return repository.findAll(pageRequest);
    }

    /**
     * Returns {@link ArticleDocument} by specified <code>id</code>.
     * 
     * @param id - Not <code>null</code>.
     * @return Instance of {@link ArticleDocument}.
     */
    public ArticleDocument getArticle(String id) {
        return repository.findOne(id);
    }

    /**
     * Save specified {@link ArticleDocument}.
     * 
     * @param document - Not <code>null</code>.
     */
    public void saveArticle(ArticleDocument document) {
        repository.save(document);
    }
}
