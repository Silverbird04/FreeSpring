package com.example.firstproject.dto;

import lombok.AllArgsConstructor; // 자동 import
import lombok.ToString;

@AllArgsConstructor // ;new annotation
@ToString
public class ArticleForm {
    private String title;
    private String content;
    /*
    // 전송받은 제목과 내용을 필드에 저장하는 생성자 추가
    public ArticleForm(String title, String content) {
        this.title = title;
        this.content = content;
    }
     */

    public Article toEntity() {
        return new Article(null, title, content); // entity/Article.java 생성자 입력 양식에 맞게 작성
    }
}
