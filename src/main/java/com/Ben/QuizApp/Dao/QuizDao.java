package com.Ben.QuizApp.Dao;

import com.Ben.QuizApp.Entitys.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizDao extends JpaRepository<Quiz, Integer> {

}
