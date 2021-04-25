package com.example.survey.domain;

import javax.persistence.*;
import java.lang.reflect.Type;
import java.util.Set;

@Entity
@Table
public class Answer {
    @Id
    @GeneratedValue
    private Long id;

    private String text;

    @ElementCollection(targetClass = TypeAnswer.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "answer_type", joinColumns = @JoinColumn(name = "answer_id"))
    @Enumerated(EnumType.STRING)
    private Set<TypeAnswer> types;

    @ManyToOne
    @JoinColumn(name = "survey_id")
    private Survey survey;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false, updatable = false)
    private User author;

    public void setAuthor(User author) {
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Survey getSurvey() {
        return survey;
    }

    public void setSurvey(Survey survey) {
        this.survey = survey;
    }

    public User getAuthor() {
        return author;
    }

    public Set<TypeAnswer> getTypes() {
        return types;
    }

    public void setTypes(Set<TypeAnswer> types) {
        this.types = types;
    }
}
