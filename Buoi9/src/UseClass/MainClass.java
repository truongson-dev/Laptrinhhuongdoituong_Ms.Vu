package UseClass;

import java.util.Scanner;

import BuildClass.QuanLySinhVien;

public class MainClass {
	public static void main(String[] args) {
		QuanLySinhVien ql = new QuanLySinhVien();
		Scanner scanner = new Scanner(System.in);
		int luaChon;

		do {
			hienThiMenu();
			System.out.print("\n┌─[Nhập lựa chọn của bạn (0-6)]\n└─> ");

			try {
				luaChon = Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("\n⚠ Lỗi: Vui lòng nhập số từ 0 đến 6!");
				luaChon = -1;
			}

			xuLyLuaChon(ql, luaChon);

			if (luaChon != 0) {
				System.out.print("\n↵ Nhấn Enter để tiếp tục...");
				scanner.nextLine();
			}

		} while (luaChon != 0);

		// Đóng scanner
		ql.dongScanner();
		scanner.close();

		System.out.println("\n═══════════════════════════════════════════");
		System.out.println("     CẢM ƠN ĐÃ SỬ DỤNG CHƯƠNG TRÌNH!     ");
		System.out.println("═══════════════════════════════════════════");
	}

	private static void hienThiMenu() {
		System.out.println("\n╔══════════════════════════════════════════════╗");
		System.out.println("║    HỆ THỐNG QUẢN LÝ SINH VIÊN - MAIN MENU    ║");
		System.out.println("╠══════════════════════════════════════════════╣");
		System.out.println("║   1. Nhập danh sách sinh viên          	   ║");
		System.out.println("║   2. Xem danh sách sinh viên           	   ║");
		System.out.println("║   3. Sắp xếp theo điểm TB (tăng dần)   	   ║");
		System.out.println("║   4. Tìm kiếm sinh viên theo tên       	   ║");
		System.out.println("║   5. Thêm sinh viên mới                	   ║");
		System.out.println("║   6. Xóa toàn bộ danh sách             	   ║");
		System.out.println("║   0. Thoát chương trình                	   ║");
		System.out.println("╚══════════════════════════════════════════════╝");
	}

	private static void xuLyLuaChon(QuanLySinhVien ql, int luaChon) {
		switch (luaChon) {
		case 1:
			ql.nhapDanhSachSinhVien();
			break;

		case 2:
			ql.xemDanhSachSinhVien();
			break;

		case 3:
			ql.sapXepTheoDiemTB();
			break;

		case 4:
			ql.timKiemTheoTen();
			break;

		case 5:
			ql.themSinhVienMoi();
			break;

		case 6:
			ql.xoaDanhSach();
			break;

		case 0:
			System.out.println("\nĐang thoát chương trình...");
			break;

		default:
			if (luaChon != -1) {
				System.out.println("\n⚠ Lựa chọn không hợp lệ! Vui lòng chọn từ 0 đến 6.");
			}
			break;
		}
	}
}