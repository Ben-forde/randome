package com.Ben.QuizApp.service;

import com.Ben.QuizApp.Dao.QuestionDAO;
import com.Ben.QuizApp.Dao.QuizDao;
import com.Ben.QuizApp.Entitys.Question;
import com.Ben.QuizApp.Entitys.QuestionWrapper;
import com.Ben.QuizApp.Entitys.Quiz;
import com.Ben.QuizApp.Entitys.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    @Autowired
    QuestionDAO questionDAO;
    @Autowired
    QuizDao quizDao;


    public ResponseEntity<String> createQuiz(String category, int numQ, String title){
        List<Question> questions = questionDAO.findRandomQuestionByCat(category, numQ);

        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizDao.save(quiz);
        return new ResponseEntity<>("success", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
              Optional<Quiz> quiz = quizDao.findById(id);
              List<Question> questionsFromDB = quiz.get().getQuestions();
              List<QuestionWrapper> questionsForUser = new ArrayList<>();
              for(Question q: questionsFromDB){
                  QuestionWrapper qw = new QuestionWrapper(q.getId(),q.getOption_1(),q.getOption_2(),q.getOption_3(),q.getQuestion());
                  questionsForUser.add(qw);
              }

              return new ResponseEntity<>(questionsForUser, HttpStatus.OK);

    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
        Quiz quiz = quizDao.findById(id).get();
        List<Question> questions= quiz.getQuestions();
        int right = 0;
        int i = 0;
        for(Response response: responses){
            if(response.getResponse().equals(questions.get(i).getCorrectQuestion()))
                right++;
            i++;

        }
        return new ResponseEntity<>(right, HttpStatus.OK);

    }
}
