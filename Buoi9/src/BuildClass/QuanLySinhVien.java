package BuildClass;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class QuanLySinhVien {
	private List<Student> danhSachSinhVien;
	private Scanner scanner;

	// Constructor
	public QuanLySinhVien() {
		danhSachSinhVien = new ArrayList<>();
		scanner = new Scanner(System.in);
	}

	// 1. Nhập danh sách sinh viên
	public void nhapDanhSachSinhVien() {
		System.out.println("\n═══════════════════════════════════");
		System.out.println("     NHẬP DANH SÁCH SINH VIÊN     ");
		System.out.println("═══════════════════════════════════");

		System.out.print("Nhập số lượng sinh viên: ");
		int soLuong = 0;

		try {
			soLuong = Integer.parseInt(scanner.nextLine());
			if (soLuong <= 0) {
				System.out.println("Số lượng phải lớn hơn 0!");
				return;
			}
		} catch (NumberFormatException e) {
			System.out.println("Vui lòng nhập số hợp lệ!");
			return;
		}

		for (int i = 0; i < soLuong; i++) {
			System.out.println("\n» Sinh viên thứ " + (i + 1) + ":");
			System.out.print("  • Mã sinh viên: ");
			String maSV = scanner.nextLine();

			System.out.print("  • Họ tên: ");
			String tenSV = scanner.nextLine();

			double diem = -1;
			while (diem < 0 || diem > 10) {
				System.out.print("  • Điểm trung bình (0-10): ");
				try {
					diem = Double.parseDouble(scanner.nextLine());
					if (diem < 0 || diem > 10) {
						System.out.println("  ⚠ Điểm phải từ 0 đến 10!");
					}
				} catch (NumberFormatException e) {
					System.out.println("  ⚠ Vui lòng nhập số hợp lệ!");
					diem = -1;
				}
			}

			Student sv = new Student(maSV, tenSV, diem);
			danhSachSinhVien.add(sv);
		}

		System.out.println("\n✓ Đã nhập thành công " + soLuong + " sinh viên!");
	}

	// 2. Xem danh sách sinh viên
	public void xemDanhSachSinhVien() {
		if (danhSachSinhVien.isEmpty()) {
			System.out.println("\n⚠ Danh sách sinh viên trống!");
			return;
		}

		System.out.println("\n══════════════════════════════════════════════════════════");
		System.out.println("                    DANH SÁCH SINH VIÊN                   ");
		System.out.println("══════════════════════════════════════════════════════════");
		System.out.printf("%-12s %-25s %-12s\n", "MÃ SV", "HỌ TÊN", "ĐIỂM TB");
		System.out.println("──────────────────────────────────────────────────────────");

		int stt = 1;
		for (Student sv : danhSachSinhVien) {
			System.out.printf("%-3d ", stt++);
			sv.hienThiThongTin();
		}

		System.out.println("══════════════════════════════════════════════════════════");
		System.out.println("Tổng số: " + danhSachSinhVien.size() + " sinh viên");
	}

	// 3. Sắp xếp theo điểm trung bình tăng dần
	public void sapXepTheoDiemTB() {
		if (danhSachSinhVien.isEmpty()) {
			System.out.println("\n⚠ Danh sách sinh viên trống!");
			return;
		}

		// Sử dụng SortByDiemTB để sắp xếp
		Collections.sort(danhSachSinhVien, new SortByDiem());

		System.out.println("\n══════════════════════════════════════════════════════════════");
		System.out.println("   DANH SÁCH SINH VIÊN SẮP XẾP THEO ĐIỂM TB (TĂNG DẦN)   ");
		System.out.println("══════════════════════════════════════════════════════════════");
		System.out.printf("%-12s %-25s %-12s\n", "MÃ SV", "HỌ TÊN", "ĐIỂM TB");
		System.out.println("──────────────────────────────────────────────────────────────");

		int stt = 1;
		for (Student sv : danhSachSinhVien) {
			System.out.printf("%-3d ", stt++);
			sv.hienThiThongTin();
		}

		System.out.println("══════════════════════════════════════════════════════════════");

		// Hiển thị thông tin thống kê
		thongKeDiem();
	}

	// Thống kê điểm
	private void thongKeDiem() {
		if (danhSachSinhVien.isEmpty()) {
			return;
		}

		double tongDiem = 0;
		double diemCaoNhat = danhSachSinhVien.get(danhSachSinhVien.size() - 1).getDiemTB();
		double diemThapNhat = danhSachSinhVien.get(0).getDiemTB();

		for (Student sv : danhSachSinhVien) {
			tongDiem += sv.getDiemTB();
		}

		double diemTrungBinh = tongDiem / danhSachSinhVien.size();

		System.out.println("\n📊 THỐNG KÊ ĐIỂM:");
		System.out.println("  • Điểm cao nhất: " + diemCaoNhat);
		System.out.println("  • Điểm thấp nhất: " + diemThapNhat);
		System.out.printf("  • Điểm trung bình: %.2f\n", diemTrungBinh);
	}

	// 4. Tìm kiếm sinh viên theo tên
	public void timKiemTheoTen() {
		if (danhSachSinhVien.isEmpty()) {
			System.out.println("\n⚠ Danh sách sinh viên trống!");
			return;
		}

		System.out.println("\n═══════════════════════════════════");
		System.out.println("     TÌM KIẾM SINH VIÊN THEO TÊN    ");
		System.out.println("═══════════════════════════════════");
		System.out.print("Nhập tên cần tìm: ");
		String tenCanTim = scanner.nextLine().toLowerCase().trim();

		List<Student> ketQuaTimKiem = new ArrayList<>();

		for (Student sv : danhSachSinhVien) {
			if (sv.getName().toLowerCase().contains(tenCanTim)) {
				ketQuaTimKiem.add(sv);
			}
		}

		if (ketQuaTimKiem.isEmpty()) {
			System.out.println("\n❌ Không tìm thấy sinh viên nào có tên chứa: '" + tenCanTim + "'");
		} else {
			System.out.println("\n══════════════════════════════════════════════════════════");
			System.out.println("       KẾT QUẢ TÌM KIẾM: '" + tenCanTim + "'");
			System.out.println("══════════════════════════════════════════════════════════");
			System.out.printf("%-12s %-25s %-12s\n", "MÃ SV", "HỌ TÊN", "ĐIỂM TB");
			System.out.println("──────────────────────────────────────────────────────────");

			int stt = 1;
			for (Student sv : ketQuaTimKiem) {
				System.out.printf("%-3d ", stt++);
				sv.hienThiThongTin();
			}

			System.out.println("══════════════════════════════════════════════════════════");
			System.out.println("Tìm thấy: " + ketQuaTimKiem.size() + " sinh viên");
		}
	}

	// Thêm sinh viên mới (chức năng bổ sung)
	public void themSinhVienMoi() {
		System.out.println("\n═══════════════════════════════════");
		System.out.println("       THÊM SINH VIÊN MỚI         ");
		System.out.println("═══════════════════════════════════");

		System.out.print("• Mã sinh viên: ");
		String maSV = scanner.nextLine();

		System.out.print("• Họ tên: ");
		String tenSV = scanner.nextLine();

		double diem = -1;
		while (diem < 0 || diem > 10) {
			System.out.print("• Điểm trung bình (0-10): ");
			try {
				diem = Double.parseDouble(scanner.nextLine());
				if (diem < 0 || diem > 10) {
					System.out.println("⚠ Điểm phải từ 0 đến 10!");
				}
			} catch (NumberFormatException e) {
				System.out.println("⚠ Vui lòng nhập số hợp lệ!");
				diem = -1;
			}
		}

		Student sv = new Student(maSV, tenSV, diem);
		danhSachSinhVien.add(sv);

		System.out.println("\n✓ Đã thêm sinh viên thành công!");
	}

	// Xóa toàn bộ danh sách
	public void xoaDanhSach() {
		if (danhSachSinhVien.isEmpty()) {
			System.out.println("\n⚠ Danh sách đã trống!");
			return;
		}

		System.out.print("\n⚠ Bạn có chắc muốn xóa toàn bộ danh sách? (y/n): ");
		String xacNhan = scanner.nextLine().toLowerCase();

		if (xacNhan.equals("y") || xacNhan.equals("yes")) {
			danhSachSinhVien.clear();
			System.out.println("✓ Đã xóa toàn bộ danh sách sinh viên!");
		} else {
			System.out.println("✓ Đã hủy thao tác xóa.");
		}
	}

	// Lấy số lượng sinh viên
	public int laySoLuongSinhVien() {
		return danhSachSinhVien.size();
	}

	// Đóng scanner
	public void dongScanner() {
		if (scanner != null) {
			scanner.close();
		}
	}
}