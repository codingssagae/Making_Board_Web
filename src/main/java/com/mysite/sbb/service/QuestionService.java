package com.mysite.sbb.service;


import com.mysite.sbb.DataNotFoundException;
import com.mysite.sbb.Question;
import com.mysite.sbb.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class QuestionService {

    private final QuestionRepository questionRepository;

    public List<Question> getList(){
        return questionRepository.findAll();
    }

    public Question getQuestion(Long id){
        Optional<Question> question = questionRepository.findById(id);
        if(question.isPresent()){
            return question.get();
        }else {
            throw new DataNotFoundException("question not found");
        }
    }

}
