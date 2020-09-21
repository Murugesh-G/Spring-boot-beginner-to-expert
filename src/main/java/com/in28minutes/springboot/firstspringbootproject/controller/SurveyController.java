package com.in28minutes.springboot.firstspringbootproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.springboot.firstspringbootproject.Question;
import com.in28minutes.springboot.firstspringbootproject.SurveyService;

@RestController
public class SurveyController {


    @Autowired
    private SurveyService surveyService;

    @GetMapping("/surveys/{surveyId}/questions")
    public List<Question> retrieveQuestionsFromSurvey(@PathVariable String surveyId){
        return surveyService.retrieveQuestions(surveyId);
    }



}
