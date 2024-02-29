package com.mysite.sbb;

import com.mysite.sbb.answer.Answer;
import com.mysite.sbb.question.Question;
import com.mysite.sbb.repository.AnswerRepository;
import com.mysite.sbb.repository.QuestionRepository;
import com.mysite.sbb.service.QuestionService;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;


@SpringBootTest
class SbbApplicationTests {

	@Autowired
	QuestionService questionService;

	@Test
	void testJPA() {
		for (int i = 1 ; i<=300 ; i++){
			String subject = String.format("테스트 데이터입니다:[%03d]", i);
			String content = "내용무";
			questionService.create(subject,content);
		}
	}

}
