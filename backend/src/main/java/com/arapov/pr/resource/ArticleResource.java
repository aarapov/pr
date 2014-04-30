package com.arapov.pr.resource;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

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

    private static final Logger LOG = LoggerFactory.getLogger(ArticleResource.class);

    @Autowired
    private ArticleService service;

    @Autowired
    private ServletContext servletContext;

    @Value("/img/default.png")
    private ClassPathResource defaultImage;

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
    @RequestMapping(value = "/save", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseBody
    public void saveArticle(@RequestBody ArticleDocument document, @RequestParam("upload") MultipartFile upload) {
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
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ArticleDocument getArticle(@PathVariable("id") final String id) {
        return service.getArticle(id);
    }

    @RequestMapping(value = "/{id}/image", method = RequestMethod.GET)
    @ResponseBody
    public void getArticleImage(@PathVariable("id") final String id, HttpServletResponse response) throws IOException {
        LOG.info("Reading image");

        String filePath = String.format("/WEB-INF/img/%s.jpg", id);
        InputStream iStream = servletContext.getResourceAsStream(filePath);

        if (iStream == null) {
            iStream = defaultImage.getInputStream();
        }

        response.setContentType("image/jpeg");
        response.setHeader("Content-Disposition", "filename=\"default.jpg\"");
        IOUtils.copy(iStream, response.getOutputStream());
    }
}
