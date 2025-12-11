package Sinhvien;

import java.util.Date;

public class Sinhvien extends Connguoi {
	// Thuộc tính riêng
	private String maSinhvien;
	private double diemRenLuyen;

	// Constructor mặc định
	public Sinhvien() {
		super(); // Gọi constructor của lớp cha
		this.maSinhvien = "";
		this.diemRenLuyen = 0.0;
	}

	// Constructor có tham số
	public Sinhvien(String hoTen, Date ngaySinh, String diaChi, String cccd, String maSinhvien, double diemRenLuyen) {
		super();
		this.maSinhvien = maSinhvien;
		this.diemRenLuyen = diemRenLuyen;
	}

	// Getter và Setter
	public String getMaSinhvien() {
		return maSinhvien;
	}

	public void setMaSinhvien(String maSinhvien) {
		this.maSinhvien = maSinhvien;
	}

	public double getDiemRenLuyen() {
		return diemRenLuyen;
	}

	public void setDiemRenLuyen(double diemRenLuyen) {
		this.diemRenLuyen = diemRenLuyen;
	}

	// Ghi đè phương thức nhập thông tin
	@Override
	public void nhapThongTin() {
		System.out.println("\n=== NHẬP THÔNG TIN SINH VIÊN ===");
		super.nhapThongTin(); // Gọi phương thức nhập của lớp cha

		System.out.print("Nhập mã sinh viên: ");
		this.maSinhvien = scanner.nextLine();

		while (true) {
			System.out.print("Nhập điểm rèn luyện (0-100): ");
			try {
				this.diemRenLuyen = Double.parseDouble(scanner.nextLine());
				if (diemRenLuyen >= 0 && diemRenLuyen <= 100) {
					break;
				} else {
					System.out.println("Điểm rèn luyện phải từ 0 đến 100!");
				}
			} catch (NumberFormatException e) {
				System.out.println("Vui lòng nhập số hợp lệ!");
			}
		}
	}

	// Ghi đè phương thức xuất thông tin
	@Override
	public void xuatThongTin() {
		System.out.println("\n=== THÔNG TIN SINH VIÊN ===");
		super.xuatThongTin(); // Gọi phương thức xuất của lớp cha
		System.out.println("Mã sinh viên: " + maSinhvien);
		System.out.println("Điểm rèn luyện: " + diemRenLuyen);
		System.out.println("Xếp loại rèn luyện: " + xepLoaiRenLuyen());
		System.out.println("Tuổi: " + tinhTuoi());
	}

	// Phương thức xếp loại rèn luyện
	public String xepLoaiRenLuyen() {
		if (diemRenLuyen >= 90) {
			return "Giỏi";
		} else if (diemRenLuyen >= 70) {
			return "Khá";
		} else if (diemRenLuyen >= 50) {
			return "Trung bình";
		} else {
			return "Yếu";
		}
	}

	// Phương thức xuất thông tin ngắn gọn
	public void xuatThongTinNgan() {
		System.out.printf("%-20s %-15s %-10s %-15s %-10.1f %-15s\n", hoTen, dateFormat.format(ngaySinh), cccd,
				maSinhvien, diemRenLuyen, xepLoaiRenLuyen());
	}

	// Phương thức xuất tiêu đề cho bảng
	public static void xuatTieuDe() {
		System.out.println("\n=== DANH SÁCH SINH VIÊN ===");
		System.out.printf("%-20s %-15s %-10s %-15s %-10s %-15s\n", "Họ tên", "Ngày sinh", "CCCD", "Mã SV", "Điểm RL",
				"Xếp loại");
		System.out.println("--------------------------------------------------------------------------------");
	}
}