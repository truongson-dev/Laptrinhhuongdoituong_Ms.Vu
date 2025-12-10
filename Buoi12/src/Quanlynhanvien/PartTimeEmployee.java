package Quanlynhanvien;

// Khai báo lớp con PartTimeEmployee thừa kế lớp Employee
public class PartTimeEmployee extends Employee {
	// Thuộc tính riêng
	private int soGioLam;
	private double donGiaGio;

	// Hàm dựng không có tham số
	public PartTimeEmployee() {
		super();
	}

	// Hàm dựng có tham số
	public PartTimeEmployee(String ht, int Tuoi, String mnv, double hsl, int sogio, double dongia) {
		super(ht, Tuoi, mnv, hsl); // Thừa kế hàm dựng lớp Employee
		this.soGioLam = sogio;
		this.donGiaGio = dongia;
	}

	// Override lại hàm tính lương của lớp cha Employee
	@Override
	public double Tinhluong() {
		return this.soGioLam * this.donGiaGio;
	}

	// Getter và Setter
	public int getSoGioLam() {
		return soGioLam;
	}

	public void setSoGioLam(int soGioLam) {
		this.soGioLam = soGioLam;
	}

	public double getDonGiaGio() {
		return donGiaGio;
	}

	public void setDonGiaGio(double donGiaGio) {
		this.donGiaGio = donGiaGio;
	}

	// Override lại hàm toString để hiển thị thêm thông tin
	@Override
	public String toString() {
		return String.format("%s|%s|%d|%.2f|Số giờ: %d|Đơn giá: %.2f", MaNV, Hoten, Tuoi, Tinhluong(), soGioLam,
				donGiaGio);
	}
}