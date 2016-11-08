package exam_02_BookSearch_DI;

import java.util.ArrayList;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import exam_02_BookSearch_DI.BookService;

public class Main {

	public static void main(String[] args) {
		// 입력받은 keyword를 이용해서 책의 제목과 저자를 출력하는데 만약 Comment가 존재하면 같이 출력.
//		System.out.println("키워드를 입력하세요! ==> ");
//		Scanner s = new Scanner(System.in);
//		String keyword = s.nextLine();		//공백포함해서 한줄을 표준입력으로부터 받는다.
		
		//Config  파일에 대한 경로를 문자열로 지정
		String config = "classpath:applicationCtx.xml";
		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(config);
		
		BookService service = ctx.getBean("bookservice", BookService.class);
		
//		ArrayList<BookEntity> list = service.getListByKeyword(keyword);
		ArrayList<BookEntity> list = service.getListByKeyword();
		
		for(BookEntity entity : list){
			System.out.println(entity.getBtitle() + " : " + entity.getBauthor());
		}
		ctx.close();
//		s.close();
	}

}
