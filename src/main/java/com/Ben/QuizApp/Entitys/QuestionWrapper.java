package com.Ben.QuizApp.Entitys;

import lombok.Data;

@Data
public class QuestionWrapper {
    private Integer id;
    private String option_1;
    private String option_2;
    private String option_3;
    private String question;

    public QuestionWrapper(Integer id, String option1, String option2, String option3, String question) {
        this.id = id;
        this.option_1 = option1;
        this.option_2 = option2;
        this.option_3 = option3;
        this.question = question;
    }
}
