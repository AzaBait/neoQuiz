package com.neobis.neoQuiz.service.seviceImpl;

import com.neobis.neoQuiz.entity.Article;
import com.neobis.neoQuiz.repository.ArticleRepo;
import com.neobis.neoQuiz.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepo articleRepo;
    @Override
    public List<Article> getAllArticles() {
        try {
            return articleRepo.findAll();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }

    }
    @Override
    public Article getArticleById(Long articleId) {
        return articleRepo.findById(articleId).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Article with id " + articleId + " not found"));
    }
    @Override
    public Article getArticleByTitle(String title) {
        return Optional.ofNullable(articleRepo.findByTitle(title)).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Article with title " + title + " not found"));
    }
}
