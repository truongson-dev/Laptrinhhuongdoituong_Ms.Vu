package Quanlynhanvien;

// 	Khai báo định nghĩa lớp con Employee thừa kế lớp cha Person
public class Employee extends Person {
	// Khai báo thuộc tính riêng
	protected String MaNV;
	protected Double hesoluong;

	// Khai báo hàm dựng không tham số
	public Employee() {
		super();
	}

	// Khai báo hàm dựng có tham số
	public Employee(String ht, int Tuoi, String mnv, double hsl) {
		super(ht, Tuoi); // Thừa kế của lớp cha Person
		this.MaNV = mnv;
		this.hesoluong = hsl;
	}

	// Hàm tính lương nhưng chưa tính để overide ở lớp con
	public double Tinhluong() {
		return 0;
	}

	// overide lại hàm toString dùng in ra dòng dữ liệu
	@Override // làm gọn hàm xuất của mình
	public String toString() {
		return String.format("%s|%s|%d|%.2f", MaNV, Hoten, Tuoi, Tinhluong());
	}

	// Getter và Setter
	public String getMaNV() {
		return MaNV;
	}

	public void setMaNV(String maNV) {
		MaNV = maNV;
	}

	public Double getHesoluong() {
		return hesoluong;
	}

	public void setHesoluong(Double hesoluong) {
		this.hesoluong = hesoluong;
	}
}