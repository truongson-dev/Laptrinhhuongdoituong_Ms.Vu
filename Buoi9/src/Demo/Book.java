package Demo;

public class Book {
// Khai báo 2 thuộc tính
	private String Tieude;
	private int Giaban;

//	Khai báo 2 constructor có tham số 
	public Book(String td, int gia) {
		this.Tieude = td; this.Giaban = gia;}
//	 Khai báo 2 constructor không có tham số 
	public Book() {};

//	Khai bao phuong thuc get du lieu
	public String getTieude() {return this.Tieude;}
	public int getGia() {return this.Giaban;}
	
//	Khai bao phuong thuc set du lieu
	public void setTieude(String td) {this.Tieude = td;}
	public void setGiaban(int gb)
	{
		if (gb < 0) {System.out.println("Gia bia>0!");}
		else {this.Giaban = gb;}
	}

//	Khai thuc in thong tin sach
	public void inThongTin()
	{
		System.out.println("Ten sach:" + Tieude + ".");
		System.out.println("Gia: " + Giaban + ".");
	}

	
}
