package com.coding.quizapp.service;

import com.coding.quizapp.model.Question;
import com.coding.quizapp.dao.QuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<List<Question>> getAllQuestions() {
        try {
            return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.OK);

    }

    public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {
        try {
            return new ResponseEntity<>(questionDao.findByCategory(category),HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.OK);

    }

    public ResponseEntity<String> addQuestion(Question question) {

        questionDao.save(question);
        return new ResponseEntity<>("SUCCESSFULLY ADDED",HttpStatus.CREATED);
    }

    public ResponseEntity<String> deleteQuestion(Question question) {
        questionDao.delete(question);
        return new ResponseEntity<>("SUCCESSFULLY DELETED",HttpStatus.OK);
    }

    public ResponseEntity<String> updateQuestion(Question question) {
        questionDao.save(question);
        return new ResponseEntity<>("SUCCESSFULLY UPDATED",HttpStatus.OK);
    }
}
