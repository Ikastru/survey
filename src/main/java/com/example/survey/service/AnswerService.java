package com.example.survey.service;

import com.example.survey.domain.Answer;
import com.example.survey.domain.User;
import com.example.survey.repo.AnswerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnswerService {

    private final AnswerRepo answerRepo;

    @Autowired
    public AnswerService(AnswerRepo answerRepo) {
        this.answerRepo = answerRepo;
    }

    public Answer create(Answer answer, User user) {
        answer.setAuthor(user);
        Answer commentFromDb = answerRepo.save(answer);

        return commentFromDb;
    }
}

