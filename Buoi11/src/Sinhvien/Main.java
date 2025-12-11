package Sinhvien;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Xuly xuLy = new Xuly();
		int choice;

		do {
			System.out.println("\n========== QUẢN LÝ SINH VIÊN - GIÁO VIÊN ==========");
			System.out.println("1. Nhập danh sách");
			System.out.println("2. Xuất danh sách (ngắn gọn)");
			System.out.println("3. Xuất danh sách (chi tiết)");
			System.out.println("4. Tìm kiếm theo tên");
			System.out.println("5. Xóa theo vị trí");
			System.out.println("6. Thống kê");
			System.out.println("7. Sắp xếp theo tên (tăng dần)");
			System.out.println("8. Sắp xếp theo tuổi (giảm dần)");
			System.out.println("0. Thoát");
			System.out.print("Chọn chức năng: ");

			try {
				choice = Integer.parseInt(scanner.nextLine());

				switch (choice) {
				case 1:
					xuLy.nhapDanhSach();
					break;
				case 2:
					xuLy.xuatDanhSach();
					break;
				case 3:
					xuLy.xuatChiTiet();
					break;
				case 4:
					xuLy.timKiemTheoTen();
					break;
				case 5:
					xuLy.xoaTheoViTri();
					break;
				case 6:
					xuLy.thongKe();
					break;
				case 7:
					System.out.println("\nChức năng đang phát triển...");
					break;
				case 8:
					System.out.println("\nChức năng đang phát triển...");
					break;
				case 0:
					System.out.println("\nCảm ơn đã sử dụng chương trình!");
					break;
				default:
					System.out.println("\nChức năng không hợp lệ! Vui lòng chọn lại.");
				}
			} catch (NumberFormatException e) {
				System.out.println("\nVui lòng nhập số hợp lệ!");
				choice = -1;
			}

		} while (choice != 0);

		scanner.close();
	}
}