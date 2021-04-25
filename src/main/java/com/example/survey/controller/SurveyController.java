package com.example.survey.controller;

import com.example.survey.domain.Survey;
import com.example.survey.domain.User;
import com.example.survey.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("survey")
public class SurveyController {

    private final SurveyService surveyService;

    @Autowired
    public SurveyController(SurveyService surveyService) {
        this.surveyService = surveyService;
    }

    @GetMapping
    public ResponseEntity<List<Survey>> list() {
        return new ResponseEntity<>(surveyService.returnList(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Survey> getOne(@PathVariable("id") Survey survey) {
        return new ResponseEntity<>(survey, HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public ResponseEntity<Survey> create(@RequestBody Survey survey, @AuthenticationPrincipal User user) throws IOException {
        return new ResponseEntity<>(surveyService.create(survey, user), HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping("{id}")
    public ResponseEntity<Survey> update(@PathVariable("id") Survey surveyFromDb, @RequestBody Survey survey) throws IOException {
        return new ResponseEntity<>(surveyService.update(surveyFromDb, survey), HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("{id}")
    public ResponseEntity<Survey> delete(@PathVariable("id") Survey survey) {
        surveyService.delete(survey);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

