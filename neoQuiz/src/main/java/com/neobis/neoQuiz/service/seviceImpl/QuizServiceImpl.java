package com.neobis.neoQuiz.service.seviceImpl;

import com.neobis.neoQuiz.entity.Quiz;
import com.neobis.neoQuiz.repository.QuizRepo;
import com.neobis.neoQuiz.service.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QuizServiceImpl implements QuizService {

    private final QuizRepo quizRepo;
    @Override
    public List<Quiz> getAllQuizzes() {
        try {
            return quizRepo.findAll();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }
    @Override
    public Quiz getQuizById(Long quizId) {
        return quizRepo.findById(quizId).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Quiz with id " + quizId + " not found"));
    }
    @Override
    public Quiz getQuizByTitle(String quizTitle) {
        return Optional.ofNullable(quizRepo.findByTitle(quizTitle)).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Quiz with title " + quizTitle + " not found"));
    }
}
