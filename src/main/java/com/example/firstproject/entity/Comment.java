package com.example.firstproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity  // class field 바탕으로 DB에 테이블 생성
@Getter  // 필드 값 조회 getter 메서드 자동 생성
@ToString
@AllArgsConstructor  // 모든 필드를 매개변수로 갖는 생성자 자동 생성
@NoArgsConstructor  // 매개변수가 아예 없는 기본 생성자 자동 생성
public class Comment {
    @Id  // primary key 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // DB가 자동으로 1씩 증가
    private Long id;
    @ManyToOne  // Comment:Article
    @JoinColumn(name = "article_id")  // 왜래키 생성, Article entity의 pk와 mapping
    private Article article;
    @Column
    private String nickname;
    @Column
    private String body;

}
