package com.neobis.neoQuiz.service;

import com.neobis.neoQuiz.entity.Article;

import java.util.List;
import java.util.Optional;

public interface ArticleService {
    List<Article> getAllArticles();

    Article getArticleById(Long articleId);

    Article getArticleByTitle(String title);
}
