package DailyWork01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BookDAO {

	public ArrayList<BookEntity> selectAll(String keyword) {

		Connection con = null;
		PreparedStatement pstat = null;
		ResultSet rs = null;
		ArrayList<BookEntity> list = null;
		
		ResultSet rs2 = null;

		try {
/* 01. Driver Loarding. */
			Class.forName("com.mysql.jdbc.Driver");

/* 02. Database Access. */
			String url = "jdbc:mysql://localhost:3306/library";
			String id = "jQuery";
			String pw = "jQuery";
			con = DriverManager.getConnection(url, id, pw);

/* 03. PreparedStatement Create. (SQL을 가지고 있는!) */
			String sql = "select a.bisbn,a.btitle, a.bauthor, b.bisbn, b.ctext "
					+ "from book a inner join book_comment b on a.bisbn = b.bisbn " + "where btitle like ? group by a.bisbn";
			pstat = con.prepareStatement(sql);
			pstat.setString(1, "%" + keyword + "%");

/* 04. Query 실행. */
			rs = pstat.executeQuery();

/* 05. 결과 처리 : Database에서 가져온 데이터를 ArrayList<BookEntity>형태로 생성. */
			list = new ArrayList<BookEntity>();
/**/
			while (rs.next()) {
				BookEntity entity = new BookEntity();
				entity.setBisbn(rs.getString("a.bisbn"));
				entity.setBtitle(rs.getString("a.btitle"));
				entity.setBauthor(rs.getString("a.bauthor"));

				String sql2 = "select ctext from book_comment where bisbn = ?";

				pstat = con.prepareStatement(sql2);
				pstat.setString(1, rs.getString("a.bisbn"));

				rs2 = pstat.executeQuery();

				ArrayList<String> c = new ArrayList<String>();
				while (rs2.next()) {
					c.add(rs2.getString("ctext"));
				}

				entity.setCtext(c);

				list.add(entity);

				rs2.close();
			}
/**/
		} catch (Exception e) {
			System.out.println(e);
		} finally {

/* 06. 사용한 자원 해제 */
			try {
				rs.close();
				pstat.close();
				con.close();
			} catch (Exception e2) {
			}
		}
		return list;
	}

}
