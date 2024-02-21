package com.mysite.sbb.repository;


import com.mysite.sbb.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question,Long> {

    Question findBySubject(String subject);
    Question findBySubjectAndContent(String subject, String content);

}
