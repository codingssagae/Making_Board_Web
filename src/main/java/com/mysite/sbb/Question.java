package com.mysite.sbb;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Question {

    @Id @GeneratedValue
    @Column(name = "QUESTION_ID")
    private Long id;

    @Column(length = 200)
    private String subject;

    @Column(columnDefinition = "TEXT") // 글자 제한 X
    private String content;

    private LocalDateTime createDate;

    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
    private List<Answer> answerList = new ArrayList<>();

}
