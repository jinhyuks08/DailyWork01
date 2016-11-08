package exam_01_composition;

import java.util.ArrayList;

public class BookService {

/*Business Logic을 처리하는 Method*/
	public ArrayList<BookEntity> getListByKeyword(String keyword) {
/*#01. 로직처리*/

		
/*#02. DB처리*/
		/*객체가 다른 객체를 사용할 떄의 관계 > 서비스객체가 자신의 Method내에서 다른 객체(DAO)를 생성해서 사용. >
		  Composition관계에 있다고 말하며 두개의 객체가 강하게 결합(tightly coupled) 할 수 밨에 없다. > 
		    클래스의 재사용과 유지보수에 불리하다. > 객체지향 프로그래밍과 상반되는 현상.*/
		BookDAO dao = new BookDAO();
		ArrayList<BookEntity> list = dao.selectAll(keyword);
		return list;
	}
}
