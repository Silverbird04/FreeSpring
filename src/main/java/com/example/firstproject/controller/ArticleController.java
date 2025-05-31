package	com.example.firstproject.controller;

import	org.springframework.stereotype.Controller;
import	org.springframework.web.bind.annotation.GetMapping;
import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import com.example.firstproject.repository.ArticleRepository; // 뒤에 인터페이스 만들면 자동 임포트


@Slf4j // logging annotation
@Controller
public	class	ArticleController	{
    // 추가
    @Autowied // 스프링 부트가 미리 생성해 놓은 repository 객체 주입(DI)
    private ArticleRepository articleRepository; // 객체 선언

    @GetMapping("/articles/new")
    public	String	newArticleForm()
		return	"articles/new";
}
    @PostMapping("/articles/create")
    public String createArticle(ArticleForm form){
        log.info(form.toString());
        // System.out.print(form.toString());
        // 1. DTO를 엔티티로 변환
        Aritcle article = form.toEntity();
        log.info(article.toString());
        // System.out.pringln(aritcle.toString()); // 확인 출력
        // 추가
        // 2. 리퍼지터리로 엔티티를 DB에 저장
        Article saved = articleRepository.save(article); // article entity 저장해 saved 객체에 반환
        log.info(saved.toString());
        // System.out.println(saved.toString()); // 확인 출력
        return "";
    }

    @GetMapping("/articles/{id}") // 데이터 조회 요청 접수
    public String show(@PathVariable Long id, Model model){ // 매개 변수로 id 받아오기
        log.info("id = " + id);
        // 1. id 조회해 DB에서 해당 데이터 가져오기
        Article articleEntity = articleRepository.findById(id).orElse(null);
        // 2. 가져온 데이터를 모델에 등록하기
        model.addAtribute("article", articleEntity); // (String name, Object value)
        // 3. 뷰 페이지 반환하기
        return "articles/show";
    }

    @GetMapping("/articles")
    public String index(Model model){
        // 1. 모든 Article 데이터 가져오기
        List<Article> articleEntityList = articleRepository.findAll();
        // 2. 가져온 Article 묶음을 모델에 등록하기
        model.addAttribute("articleList", articleEntityList); // 등록
        // 3. 사용자에게 보여 줄 뷰 페이지 설정하기
        return "articles/index";
    }

}