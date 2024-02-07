package com.Ben.QuizApp.Entitys;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String catagory;
    private String difficulty;
    private String option_1;
    private String option_2;
    private String option_3;
    private String question;
    private String correctQuestion;




}