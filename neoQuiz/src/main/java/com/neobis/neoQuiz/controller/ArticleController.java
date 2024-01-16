package com.neobis.neoQuiz.controller;

import com.neobis.neoQuiz.entity.Article;
import com.neobis.neoQuiz.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/article")
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;

    @GetMapping("/articleList")
    public ResponseEntity<List<Article>> getAllArticles() {
        List<Article> articles = articleService.getAllArticles();
        return new ResponseEntity<>(articles, HttpStatus.OK);
    }
    @GetMapping("/{articleId}")
    public ResponseEntity<Article> getArticleById(@PathVariable Long articleId) {
        Article article = articleService.getArticleById(articleId);
        return new ResponseEntity<>(article, HttpStatus.OK);
    }
    @GetMapping("/{articleTitle}")
    public ResponseEntity<Article> getArticleByTitle(@PathVariable String quizTitle) {
        Article article = articleService.getArticleByTitle(quizTitle);
        return new ResponseEntity<>(article, HttpStatus.OK);
    }
}
