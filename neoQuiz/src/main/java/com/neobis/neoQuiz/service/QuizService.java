package com.neobis.neoQuiz.service;

import com.neobis.neoQuiz.entity.Quiz;

import java.util.List;

public interface QuizService {
    List<Quiz> getAllQuizzes();

    Quiz getQuizById(Long quizId);

    Quiz getQuizByTitle(String quizTitle);

}
