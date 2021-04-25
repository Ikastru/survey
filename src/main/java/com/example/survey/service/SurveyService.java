package com.example.survey.service;

import com.example.survey.domain.Survey;
import com.example.survey.domain.User;
import com.example.survey.repo.SurveyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.regex.Pattern;

@Service
public class SurveyService {
    private static String URL_PATTERN = "https?:\\/\\/?[\\w\\d\\._\\-%\\/\\?=&#]+";
    private static String IMAGE_PATTERN = "\\.(jpeg|jpg|gif|png)$";

    private static Pattern URL_REGEX = Pattern.compile(URL_PATTERN, Pattern.CASE_INSENSITIVE);
    private static Pattern IMG_REGEX = Pattern.compile(IMAGE_PATTERN, Pattern.CASE_INSENSITIVE);

    private final SurveyRepo surveyRepo;

    @Autowired
    public SurveyService(SurveyRepo surveyRepo) {
        this.surveyRepo = surveyRepo;
    }

    public List<Survey> returnList(){
        return surveyRepo.findAll();
    }

    public void delete(Survey survey) {
        surveyRepo.delete(survey);
    }

    public Survey update(Survey surveyFromDb, Survey survey) throws IOException {
        surveyFromDb.setName(survey.getName());
        Survey updatedSurvey = surveyRepo.save(surveyFromDb);
        return updatedSurvey;
    }

    public Survey create(Survey survey, User user) throws IOException {
        survey.setCreationDate(LocalDateTime.now());
        survey.setAuthor(user);
        Survey updatedSurvey = surveyRepo.save(survey);

        return updatedSurvey;
    }

}
