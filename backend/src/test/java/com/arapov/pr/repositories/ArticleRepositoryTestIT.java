package com.arapov.pr.repositories;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.arapov.pr.AbstractIntegrationTest;
import com.arapov.pr.domain.ArticleDocument;

/**
 * Integration Tests for {@link ArticleRepository}.
 * 
 * @author Artem Arapov
 *
 */
public class ArticleRepositoryTestIT extends AbstractIntegrationTest {

    private static final int EXPECTED_PAGE_SIZE = 3;

    @Autowired
    private ArticleRepository sut;

    @Test
    public void testFindAllArticles() {
        List<ArticleDocument> actualList = sut.findAll();

        Assert.assertNotNull(actualList);
        Assert.assertFalse(actualList.isEmpty());
    }

    @Test
    public void testFindPageableArticles() {
        Pageable pageRequest = new PageRequest(0, EXPECTED_PAGE_SIZE);

        Page<ArticleDocument> actualPage = sut.findAll(pageRequest);
        Assert.assertNotNull(actualPage);
        Assert.assertTrue(actualPage.hasContent());
        Assert.assertEquals(EXPECTED_PAGE_SIZE, actualPage.getSize());
    }

    @Test
    public void testSaveArticle() {
        ArticleDocument expectedDocument = createRandomDocument();

        sut.save(expectedDocument);

        ArticleDocument actualDocument = sut.findOne(expectedDocument.getId());
        Assert.assertNotNull(actualDocument);
        Assert.assertEquals(expectedDocument.getCaption(), actualDocument.getCaption());
        Assert.assertEquals(expectedDocument.getContent(), actualDocument.getContent());
    }

    private ArticleDocument createRandomDocument() {
        ArticleDocument document = new ArticleDocument();

        document.setCaption("Caption: " + Math.random());
        document.setContent("Content: " + Math.random());

        return document;
    }
}
