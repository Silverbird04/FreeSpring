package com.example.firstproject.dto;

import com.example.firstproject.entity.Article;
import lombok.AllArgsConstructor; // 자동 import
import lombok.ToString;

@AllArgsConstructor // ;new annotation
@ToString
public class ArticleForm {
    private Long id;
    private String title;
    private String content;

    public Article toEntity() {
        return new Article(id, title, content); // entity/Article.java 생성자 입력 양식에 맞게 작성
    }
}
