package Demo;

public class Main {
	public static void inThongTin(Book a) {
		System.out.println("Tên sách là: "+a.getTieude());
		System.out.println("Giá bìa là: "+a.getGia());
	}
	public static void main(String[] args) {
		// khởi tạo lớp book use constructor có tham số
//		Book bk1 = new Book("toán",40);
//		bk1.InThongTin();
		
		//khởi tạo lớp book (biến đối tượng lớp book use đc toàn bộ thuộc tính và phương thức)
		// nếu bên kia khởi tạo lớp public static void main thì bên này k cần tạo
		//khởi tạo lớp book use constructor
		Book bk = new Book();
		
		bk.setTieude("Nam mô");
		bk.setGiaban(40);
		bk.inThongTin();
		
		inThongTin(bk);
	}
}