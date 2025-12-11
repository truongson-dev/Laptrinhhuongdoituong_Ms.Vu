package Sinhvien;

import java.util.Date;

public class Giaovien extends Connguoi {
	// Thuộc tính riêng
	private String maGiaovien;
	private double diemThiDua;

	// Constructor mặc định
	public Giaovien() {
		super(); // Gọi constructor của lớp cha
		this.maGiaovien = "";
		this.diemThiDua = 0.0;
	}

	// Constructor có tham số
	public Giaovien(String hoTen, Date ngaySinh, String diaChi, String cccd, String maGiaovien, double diemThiDua) {
		super();
		this.maGiaovien = maGiaovien;
		this.diemThiDua = diemThiDua;
	}

	// Getter và Setter
	public String getMaGiaovien() {
		return maGiaovien;
	}

	public void setMaGiaovien(String maGiaovien) {
		this.maGiaovien = maGiaovien;
	}

	public double getDiemThiDua() {
		return diemThiDua;
	}

	public void setDiemThiDua(double diemThiDua) {
		this.diemThiDua = diemThiDua;
	}

	// Ghi đè phương thức nhập thông tin
	@Override
	public void nhapThongTin() {
		System.out.println("\n=== NHẬP THÔNG TIN GIÁO VIÊN ===");
		super.nhapThongTin(); // Gọi phương thức nhập của lớp cha

		System.out.print("Nhập mã giáo viên: ");
		this.maGiaovien = scanner.nextLine();

		while (true) {
			System.out.print("Nhập điểm thi đua (0-100): ");
			try {
				this.diemThiDua = Double.parseDouble(scanner.nextLine());
				if (diemThiDua >= 0 && diemThiDua <= 100) {
					break;
				} else {
					System.out.println("Điểm thi đua phải từ 0 đến 100!");
				}
			} catch (NumberFormatException e) {
				System.out.println("Vui lòng nhập số hợp lệ!");
			}
		}
	}

	// Ghi đè phương thức xuất thông tin
	@Override
	public void xuatThongTin() {
		System.out.println("\n=== THÔNG TIN GIÁO VIÊN ===");
		super.xuatThongTin(); // Gọi phương thức xuất của lớp cha
		System.out.println("Mã giáo viên: " + maGiaovien);
		System.out.println("Điểm thi đua: " + diemThiDua);
		System.out.println("Xếp loại thi đua: " + xepLoaiThiDua());
		System.out.println("Tuổi: " + tinhTuoi());
	}

	// Phương thức xếp loại thi đua
	public String xepLoaiThiDua() {
		if (diemThiDua >= 90) {
			return "A";
		} else if (diemThiDua >= 80) {
			return "B";
		} else if (diemThiDua >= 65) {
			return "C";
		} else {
			return "D";
		}
	}

	// Phương thức xuất thông tin ngắn gọn
	public void xuatThongTinNgan() {
		System.out.printf("%-20s %-15s %-10s %-15s %-10.1f %-15s\n", hoTen, dateFormat.format(ngaySinh), cccd,
				maGiaovien, diemThiDua, xepLoaiThiDua());
	}

	// Phương thức xuất tiêu đề cho bảng
	public static void xuatTieuDe() {
		System.out.println("\n=== DANH SÁCH GIÁO VIÊN ===");
		System.out.printf("%-20s %-15s %-10s %-15s %-10s %-15s\n", "Họ tên", "Ngày sinh", "CCCD", "Mã GV", "Điểm TĐ",
				"Xếp loại");
		System.out.println("--------------------------------------------------------------------------------");
	}
}