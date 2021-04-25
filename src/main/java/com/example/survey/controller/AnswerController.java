package com.example.survey.controller;

import com.example.survey.domain.Answer;
import com.example.survey.domain.User;
import com.example.survey.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("answer")
public class AnswerController {

    private final AnswerService answerService;

    @Autowired
    public AnswerController(AnswerService answerService) {
        this.answerService = answerService;
    }

    @PostMapping
    public Answer create(
            @RequestBody Answer answer,
            @AuthenticationPrincipal User user
    ) {
        return answerService.create(answer, user);
    }
}

