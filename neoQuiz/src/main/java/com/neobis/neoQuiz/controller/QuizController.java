package com.neobis.neoQuiz.controller;

import com.neobis.neoQuiz.entity.Quiz;
import com.neobis.neoQuiz.service.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/quiz")
@RequiredArgsConstructor
public class QuizController {

    private final QuizService quizService;

    @GetMapping("/quizList")
    public ResponseEntity<List<Quiz>> getAllQuizzes() {
        List<Quiz> quizzes = quizService.getAllQuizzes();
        return new ResponseEntity<>(quizzes, HttpStatus.OK);
    }
    @GetMapping("/{quizId}")
    public ResponseEntity<Quiz> getQuizById(@PathVariable Long quizId) {
        Quiz quiz = quizService.getQuizById(quizId);
        return new ResponseEntity<>(quiz, HttpStatus.OK);
    }
    @GetMapping("/{quizTitle}")
    public ResponseEntity<Quiz> getQuizByTitle(@PathVariable String quizTitle) {
        Quiz quiz = quizService.getQuizByTitle(quizTitle);
        return new ResponseEntity<>(quiz, HttpStatus.OK);
    }
}
