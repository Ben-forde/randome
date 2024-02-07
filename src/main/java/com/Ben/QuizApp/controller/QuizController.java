package com.Ben.QuizApp.controller;

import com.Ben.QuizApp.Entitys.Question;
import com.Ben.QuizApp.Entitys.QuestionWrapper;
import com.Ben.QuizApp.Entitys.Response;
import com.Ben.QuizApp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {
    @Autowired
    QuizService quizService;
    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String catagory,
                                             @RequestParam int numQ, @RequestParam String title){
        return quizService.createQuiz(catagory, numQ, title);

    }

    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestion(@PathVariable Integer id){
       return quizService.getQuizQuestions(id);

    }

    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> sumbmitQuiz(@PathVariable Integer id, @RequestBody List<Response> responses){
        return quizService.calculateResult(id, responses);
    }

}
