package com.arapov.pr.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.arapov.pr.domain.ArticleDocument;
import com.arapov.pr.services.ArticleService;

/**
 * RESTful service for {@link ArticleDocument}.
 * 
 * @author Artem Arapov
 *
 */

@Controller
@RequestMapping("/articles")
public class ArticleResource {

    @Autowired
    private ArticleService service;

    /**
     * Returns all existed articles.
     * 
     * @return {@link List} of {@link ArticleDocument}.
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public List<ArticleDocument> getAllArticles() {
        return service.getAllArticles();
    }

    /**
     * Save specified {@link ArticleDocument}.
     * 
     * @param document - Not <code>null</code>.
     */
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public void saveArticle(@RequestBody ArticleDocument document) {
        service.saveArticle(document);
    }

    /**
     * Returns Latest articles.
     * 
     * @return {@link List} of {@link ArticleDocument}.
     */
    @RequestMapping(value = "/latest", method = RequestMethod.GET)
    @ResponseBody
    public List<ArticleDocument> getLastArticles() {
        return service.getLastArticles().getContent();
    }

    /**
     * Returns article by specified id.
     * 
     * @param id - Not <code>null</code>
     * @return {@link ArticleDocument} if found, otherwise <code>null</code>.
     */
    public ArticleDocument getArticle(final String id) {
        return service.getArticle(id);
    }
}
