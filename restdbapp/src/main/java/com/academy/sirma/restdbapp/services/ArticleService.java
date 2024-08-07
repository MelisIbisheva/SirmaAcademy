package com.academy.sirma.restdbapp.services;

import com.academy.sirma.restdbapp.models.Article;
import com.academy.sirma.restdbapp.repositories.ArticleRepository;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {
    private ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public void add(Article article){
        //TODO validate article  data
        articleRepository.saveArticle(article);
    }
}
