package com.example.firstproject.service;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test; // Test 패키지
import static org.junit.jupiter.api.Assertions.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ArticleServiceTest {
    @Autowired
    ArticleService articleService; // 객체 주입
    // index
    @Test // 테스트 코드임을 선언
    void index() {
        // 1. 예상 데이터
        Article a = new Article(1L, "기가기기", "1111"); // 객체 저장
        Article b = new Article(1L, "나나나나", "2222");
        Article c = new Article(1L, "다다다다", "3333");
        List<Article> expected = new ArrayList<Article>(Arrays.asList(a,b,c)); // 합치기
        // 2. 실제 데이터
        List<Article> articles = articleService.index();
        // 3. 비교 및 검증
        assertEquals(expected.toString(), articles.toString());
    }
    // show
    @Test
    void show_성공_존재하는 _id_입력() {
        // 1. 예상 데이터
        Long id = 1L;
        Article expected = new Article(id, "가가가가", "1111");
        // 2. 실제 데이터
        Article expected = articleService.show(id);
        // 3. 비교 및 검증
        assertEquals(expected.toString, article.toString());
    }
    @Test
    void show_실패_존재하지_않는_id_입력() {
        // 1. 예상 데이터
        Long id = -1L;
        Article expected = null;
        // 2. 실제 데이터
        Article article = articleService.show(id);
        // 3. 비교 및 검증
        assertEquals(expected, article); // toString() 불가
    }
    // create
    @Test
    @Transactional
    void create_성공_title과_content_만_있는_dto_입력() {
        // 1. 예상 데이터
        String title = "라라라라";
        String content = "4444";
        ArticleForm dto = new ArticleForm(null, title, content);
        Article expected = new Article(4L, title, content);
        // 2. 실제 데이터
        Article expected = articleService.create(dto);
        // 3. 비교 및 검증
        assertEquals(expected.toString, article.toString());
    }
    @Test
    @Transactional
    void create_실패_id_가_포함된_dto_입력() {
        // 1. 예상 데이터
        Long id = 4L;
        String title = "라라라라";
        String content = "4444";
        ArticleForm dto = new ArticleForm(id, title, content);
        Article expected = null;
        // 2. 실제 데이터
        Article expected = articleService.create(dto);
        // 3. 비교 및 검증
        assertEquals(expected, article);
    }
    /*
    // 셀프체크, 수정 필요
    // update
    @Test
    @Transactional
    void update_성공_존재하는_id와_title_content가_있는_dto_입력() {
        // 1. 예상 데이터
        Long id = 4L;
        String title = "라라라라";
        String content = "4444";
        ArticleForm dto = new ArticleForm(id, title, content);
        Article expected = new Article(id, title, content);
        // 2. 실제 데이터
        Article expected = articleService.create(dto);
        // 3. 비교 및 검증
        assertEquals(expected.toString, article.toString());
    }
    @Test
    @Transactional
    void update_성공_존재하는_id와_title만_있는_dto_입력() {
        // 1. 예상 데이터
        String title = "라라라라";
        String content = "4444";
        ArticleForm dto = new ArticleForm(null, title, content);
        Article expected = new Article(4L, title, content);
        // 2. 실제 데이터
        Article expected = articleService.create(dto);
        // 3. 비교 및 검증
        assertEquals(expected.toString, article.toString());
    }
    @Test
    @Transactional
    void update_실패_존재하지_않는_id의_dto_입력() {
        // 1. 예상 데이터
        Long id = 4L;
        String title = "라라라라";
        String content = "4444";
        ArticleForm dto = new ArticleForm(id, title, content);
        Article expected = null;
        // 2. 실제 데이터
        Article expected = articleService.create(dto);
        // 3. 비교 및 검증
        assertEquals(expected, article);
    }
    // delete
    @Test
    @Transactional
    void delete_성공_존재하는 _id_입력() {
        // 1. 예상 데이터
        Long id = 1L;
        Article expected = new Article(id, "가가가가", "1111");
        // 2. 실제 데이터
        Article expected = articleService.show(id);
        // 3. 비교 및 검증
        assertEquals(expected.toString, article.toString());
    }
    @Test
    @Transactional
    void delete_실패_존재하지_않는_id_입력() {
        // 1. 예상 데이터
        Long id = -1L;
        Article expected = null;
        // 2. 실제 데이터
        Article article = articleService.show(id);
        // 3. 비교 및 검증
        assertEquals(expected, article); // toString() 불가
    }
     */
}
