package com.mysite.sbb;

import com.mysite.sbb.repository.AnswerRepository;
import com.mysite.sbb.repository.QuestionRepository;
import jakarta.persistence.EntityManager;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@SpringBootTest
class SbbApplicationTests {

	@Autowired
	QuestionRepository questionRepository;

	@Autowired
	AnswerRepository answerRepository;

	@Autowired
	EntityManager em;

	@Test
	@Transactional
	@Rollback(value = false)
	void test() {
		Question q1 = new Question();
		q1.setSubject("이건희는 누구인가요?");
		q1.setContent("이건희에 대해서 알고 싶은디.");
		q1.setCreateDate(LocalDateTime.now());
		this.questionRepository.save(q1);  // 첫번째 질문 저장

		Question q2 = new Question();
		q2.setSubject("오늘 밥 뭐 먹을까요?");
		q2.setContent("제가 입이 고급집니다 참고좀.");
		q2.setCreateDate(LocalDateTime.now());
		this.questionRepository.save(q2);  // 두번째 질문 저장

		Optional<Question> findQ = questionRepository.findById(1L);
		Question q = findQ.get();

		q.setSubject("수정된 제목 입니다!"); // 수정
		questionRepository.save(q);
		questionRepository.delete(q); // 삭제

		Optional<Question> oq = questionRepository.findById(2L);
		Question q3 = oq.get();
		Answer a = new Answer();
		a.setContent("궁금하면 500원");
		a.setCreateDate(LocalDateTime.now());
		a.setQuestion(q3);
		answerRepository.save(a);
		questionRepository.save(q2);  // 두번째 질문 저장

		em.flush();
		em.clear();

		Optional<Question> byId = questionRepository.findById(2L);
		Question questiontmp = byId.get();
		String subject = questiontmp.getSubject();
		System.out.println("subject = " + subject);
		int size = questiontmp.getAnswerList().size();
		System.out.println("size = " + size);
		System.out.println(questiontmp.getAnswerList().get(0).getContent()); // 컬렉션 조회


	}

}
