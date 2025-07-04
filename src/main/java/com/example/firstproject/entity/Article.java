package	com.example.firstproject.entity;

import jakarta.persistence.*;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity				// 엔티티	선언
@Getter
@Setter
public	class	Article	{
    @Id				// 엔티티의	대푯값	지정
    @GeneratedValue(strategy = GenerationType.IDENTITY)	// 자동	생성	기능	추가(숫자가	자동으로	매겨짐)
    private	Long	id;
    @Column			// title	필드	선언,	DB	테이블의	title	열과	연결됨
    private	String	title;
    @Column		// content	필드	선언,	DB	테이블의	cotent	열과	연결됨
    private	String	content;
    public void patch(Article article) {
        if (article.title != null)
            this.title = article.title;
        if (article.content != null)
            this.content = article.content;
    }
    /*
    public Long getId() {
        return id;
    }

    //	Article	생성자	추가
    public	Article(Long	id,	String	title,	String	content)	{ // dto/ArticleForm에 쓰기 위해 생성자 형식 확인
        this.id	=	id;
        this.title	=	title;
        this.content	=	content;
    }
    //	toString()	메서드	추가
    @Override
    public	String	toString()	{
        return	"Article{"	+
                "id="	+	id	+
                ",	title='"	+	title	+	'\''	+
                ",	content='"	+	content	+	'\''	+
                '}';
    }
     */

}