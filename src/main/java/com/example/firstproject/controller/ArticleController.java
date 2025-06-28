package	com.example.firstproject.controller;

import	org.springframework.stereotype.Controller;
import	org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import com.example.firstproject.repository.ArticleRepository; // 뒤에 인터페이스 만들면 자동 임포트
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;

@Slf4j // logging annotation
@Controller
public	class	ArticleController {
    // 추가
    @Autowired // 스프링 부트가 미리 생성해 놓은 repository 객체 주입(DI)
    private ArticleRepository articleRepository; // 객체 선언

    @GetMapping("/articles/new")
    public String newArticleForm() {
        return "articles/new";
    }

    @PostMapping("/articles/create")
    public String createArticle(ArticleForm form) {
        log.info(form.toString());
        // System.out.print(form.toString());
        // 1. DTO를 엔티티로 변환
        Article article = form.toEntity();
        log.info(article.toString());
        // System.out.pringln(aritcle.toString()); // 확인 출력
        // 추가
        // 2. 리퍼지터리로 엔티티를 DB에 저장
        Article saved = articleRepository.save(article); // article entity 저장해 saved 객체에 반환
        log.info(saved.toString());
        // System.out.println(saved.toString()); // 확인 출력
        return "redirect:/articles/" + saved.getId();
    }

    @GetMapping("/articles/{id}") // 데이터 조회 요청 접수
    public String show(@PathVariable Long id, Model model) { // 매개 변수로 id 받아오기
        log.info("id = " + id);
        // 1. id 조회해 DB에서 해당 데이터 가져오기
        Article articleEntity = articleRepository.findById(id).orElse(null);
        // 2. 가져온 데이터를 모델에 등록하기
        model.addAttribute("article", articleEntity); // (String name, Object value)
        // 3. 뷰 페이지 반환하기
        return "articles/show";
    }

    @GetMapping("/articles")
    public String index(Model model) {
        // 1. 모든 Article 데이터 가져오기
        List<Article> articleEntityList = articleRepository.findAll();
        // 2. 가져온 Article 묶음을 모델에 등록하기
        model.addAttribute("articleList", articleEntityList); // 등록
        // 3. 사용자에게 보여 줄 뷰 페이지 설정하기
        return "articles/index";
    }

    @GetMapping("/articles/{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        // 수정할 데이터 가져오기
        Article articleEntity = articleRepository.findById(id).orElse(null);
        // 모델에 데이터 등록하기
        model.addAttribute("article", articleEntity);
        // 뷰 페이지 설정하기
        return "articles/edit";
    }

    @GetMapping("/articles/{id}/delete") // 8.2.2 추가
    public String delete(@PathVariable Long id, RedirectAttributes rttr) {
        log.info("삭제 요청이 들어왔습니다!!");
        // 1. 삭제할 대상 가져오기
        Article target = articleRepository.findById(id).orElse(null);
        log.info(target.toString());
        // 2. 대상 엔티티 삭제하기
        if (target != null) {
            articleRepository.delete(target);
            rttr.addFlashAttribute("msg", "삭제됐습니다!"); // (key 문자열, 값)
        }
        // 3. 결과 페이지로 리다이렉트하기
        return "redirect:/articles";
    }
}