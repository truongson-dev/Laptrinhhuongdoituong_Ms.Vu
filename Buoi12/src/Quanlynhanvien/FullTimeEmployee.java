package Quanlynhanvien;

//Khai báo lớp con thừa kế lớp Employee
public class FullTimeEmployee extends Employee {
	// Thuộc tính riêng
	private double Luongcoban;

	// Hàm dựng không có tham số
	public FullTimeEmployee() {
		super();
	}

	// Hàm dựng có tham số
	public FullTimeEmployee(String ht, int Tuoi, String mnv, double hsl, double lcb) {
		super(ht, Tuoi, mnv, hsl); // Thừa kế hàm dựng lớp Emloyee
		this.Luongcoban = lcb;
	}

	// Overide lại hàm tính lương của lớp cha Employee
	@Override
	public double Tinhluong() {
		return this.Luongcoban * hesoluong;
	}

	// Getter và Setter
	public double getLuongcoban() {
		return Luongcoban;
	}

	public void setLuongcoban(double luongcoban) {
		Luongcoban = luongcoban;
	}

	// Override toString để hiển thị thêm thông tin
	@Override
	public String toString() {
		return String.format("%s|%s|%d|%.2f|Lương cơ bản: %.2f", MaNV, Hoten, Tuoi, Tinhluong(), Luongcoban);
	}
}