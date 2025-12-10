package Quanlynhanvien;

// Khai báo định nghĩa lớp cha 
public class Person {
	protected String Hoten;
	protected int Tuoi;

	// hàm dựng không có tham số
	public Person() {
	}

	// hàm dựng có tham số
	public Person(String ht, int tuoi) {
		this.Hoten = ht;
		this.Tuoi = tuoi;
	}

	// Getter và Setter
	public String getHoten() {
		return Hoten;
	}

	public void setHoten(String hoten) {
		Hoten = hoten;
	}

	public int getTuoi() {
		return Tuoi;
	}

	public void setTuoi(int tuoi) {
		Tuoi = tuoi;
	}
}