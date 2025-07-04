package	com.example.firstproject.controller;

import org.springframework.ui.Model;
// 컨트롤러 선언과	동시에	자동으로 임포트(@Controler)
import	org.springframework.stereotype.Controller;
// URL 연결 요청과 동시에 자동으로 임포트(@GetMapping)
import org.springframework.web.bind.annotation.GetMapping;

@Controller	// 컨트롤러	선언
public	class	FirstController	{

    @GetMapping("/hi") // URL 요청 접수
    public	String	niceToMeetYou(Model model)	{	// 메서드	작성
        model.addAttribute("username", "해찬");
        return	"greetings"; // greetings.mustache 파일 반환
    }

    @GetMapping("/bye") // URL 요청 접수
    public String seeYouNext(Model model){
        model.addAttribute("nickname", "유우시");
        return "goodbye";
    }
}