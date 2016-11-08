package exam_01_aggregation;

/*DTO를 만들수 있는 Class : Database를 근간으로 해서 생성*/
public class BookEntity {
	
	private String bisbn;
	private String btitle;
	private String bauthor;
	private String bprice;
	
/**/
	public BookEntity(){
		
	}

	public String getBisbn() {
		return bisbn;
	}

	public void setBisbn(String bisbn) {
		this.bisbn = bisbn;
	}

	public String getBtitle() {
		return btitle;
	}

	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}

	public String getBauthor() {
		return bauthor;
	}

	public void setBauthor(String bauthor) {
		this.bauthor = bauthor;
	}

	public String getBprice() {
		return bprice;
	}

	public void setBprice(String bprice) {
		this.bprice = bprice;
	}
	
}
