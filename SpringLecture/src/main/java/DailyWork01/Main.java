package DailyWork01;

import java.util.ArrayList;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		String config = "classpath:DW_applicationCtx.xml";
		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(config);
		
		BookService service = ctx.getBean("bookservice", BookService.class);
		
		ArrayList<BookEntity> list = service.getListByKeyword();
		
		for(BookEntity entity : list){
//			System.out.println(entity.getBtitle() + " : " + entity.getBauthor() + " : " + entity.getCtext());
			System.out.println(entity.getBtitle() + " : " + entity.getBauthor());
			entity.getCtext();
		}
		ctx.close();
	}

}
