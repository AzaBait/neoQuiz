package com.neobis.neoQuiz.repository;

import com.neobis.neoQuiz.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizRepo extends JpaRepository<Quiz, Long> {
    Quiz findByTitle(String quizTitle);

}
