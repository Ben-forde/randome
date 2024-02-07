package com.Ben.QuizApp.Dao;

import com.Ben.QuizApp.Entitys.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDAO extends JpaRepository<Question, Integer> {
    List<Question> findByCatagory(String catagory);



    @Query(value = "SELECT * FROM question q WHERE q.catagory=:category ORDER BY RANDOM() LIMIT :numQ", nativeQuery = true)
    List<Question> findRandomQuestionByCat(String category, int numQ);

//kjoijoij
//some branch changes

    // You can add custom query methods here if needed

}