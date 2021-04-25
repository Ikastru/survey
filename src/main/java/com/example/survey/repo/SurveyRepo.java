package com.example.survey.repo;

import com.example.survey.domain.Survey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurveyRepo extends JpaRepository<Survey, Long> {

}
