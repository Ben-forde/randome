package com.Ben.QuizApp.controller;

import com.Ben.QuizApp.Entitys.Question;
import com.Ben.QuizApp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    QuestionService questionService;
    @GetMapping("allQuestions")
    public ResponseEntity<List<Question>> getAllQuestion(){
        return questionService.getAllQuestions();
    }

    @GetMapping("catagory/{catagory}")
    public List<Question> getQuestionByCategory(@PathVariable String catagory){
        return questionService.getQuestionsByCatagory(catagory);

    }
    @PostMapping("add")
    public String addQuestion(@RequestBody Question question){
        return questionService.addQuestion(question);
    }




}
