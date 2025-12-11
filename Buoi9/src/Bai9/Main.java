package Bai9;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		DanhSachCD danhSachCD = new DanhSachCD();
		int choice;

		do {
			hienThiMenu();
			System.out.print("Nhap lua chon cua ban: ");

			try {
				choice = Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Vui long nhap so!");
				System.out.println("Nhan Enter de tiep tuc...");
				scanner.nextLine();
				choice = 0;
				continue;
			}

			switch (choice) {
			case 1:
				themCD(scanner, danhSachCD);
				break;
			case 2:
				danhSachCD.xuatDanhSach();
				break;
			case 3:
				System.out.println("\n=====================================");
				System.out.println("So luong CD co trong danh sach: " + danhSachCD.soLuongCD());
				System.out.println("=====================================\n");
				break;
			case 4:
				System.out.println("\n=====================================");
				System.out.println("Tong gia thanh cua cac CD: " + String.format("%.2f", danhSachCD.tongGiaThanh()));
				System.out.println("=====================================\n");
				break;
			case 5:
				danhSachCD.sapXepGiamTheoGiaThanh();
				break;
			case 6:
				danhSachCD.sapXepTangTheoTuaCD();
				break;
			case 7:
				System.out.println("\n=====================================");
				System.out.println("Cam on ban da su dung chuong trinh!");
				System.out.println("=====================================\n");
				break;
			default:
				System.out.println("\n=====================================");
				System.out.println("Lua chon khong hop le! Vui long chon tu 1-7.");
				System.out.println("=====================================\n");
			}

			if (choice != 7) {
				System.out.println("Nhan Enter de tiep tuc...");
				scanner.nextLine();
			}

		} while (choice != 7);

		scanner.close();
	}

	private static void hienThiMenu() {
		System.out.println("\n╔══════════════════════════════════════╗");
		System.out.println("║    CHUONG TRINH QUAN LY ALBUM CD     ║");
		System.out.println("╠══════════════════════════════════════╣");
		System.out.println("║ 1. Them CD                           ║");
		System.out.println("║ 2. Xuat danh sach CD                 ║");
		System.out.println("║ 3. So luong CD                       ║");
		System.out.println("║ 4. Tong gia thanh                    ║");
		System.out.println("║ 5. Sap xep giam dan theo gia         ║");
		System.out.println("║ 6. Sap xep tang dan theo tua CD      ║");
		System.out.println("║ 7. Thoat                             ║");
		System.out.println("╚══════════════════════════════════════╝");
	}

	private static void themCD(Scanner scanner, DanhSachCD danhSachCD) {
		System.out.println("\n=====================================");
		System.out.println("THEM CD MOI");
		System.out.println("=====================================");

		// Nhập mã CD
		int maCD = 0;
		boolean nhapMaCD = false;
		while (!nhapMaCD) {
			System.out.print("Nhap ma CD (so nguyen): ");
			try {
				maCD = Integer.parseInt(scanner.nextLine());
				nhapMaCD = true;
			} catch (NumberFormatException e) {
				System.out.println("Ma CD phai la so nguyen!");
			}
		}

		// Nhập tựa CD
		System.out.print("Nhap tua CD: ");
		String tuaCD = scanner.nextLine();

		// Nhập tên ca sĩ
		System.out.print("Nhap ten ca si: ");
		String caSy = scanner.nextLine();

		// Nhập số bài hát
		int soBH = 0;
		boolean nhapSoBH = false;
		while (!nhapSoBH) {
			System.out.print("Nhap so bai hat (>0): ");
			try {
				soBH = Integer.parseInt(scanner.nextLine());
				if (soBH > 0) {
					nhapSoBH = true;
				} else {
					System.out.println("So bai hat phai lon hon 0!");
				}
			} catch (NumberFormatException e) {
				System.out.println("So bai hat phai la so nguyen!");
			}
		}

		// Nhập giá thành
		double giaThanh = 0;
		boolean nhapGiaThanh = false;
		while (!nhapGiaThanh) {
			System.out.print("Nhap gia thanh (>0): ");
			try {
				giaThanh = Double.parseDouble(scanner.nextLine());
				if (giaThanh > 0) {
					nhapGiaThanh = true;
				} else {
					System.out.println("Gia thanh phai lon hon 0!");
				}
			} catch (NumberFormatException e) {
				System.out.println("Gia thanh phai la so!");
			}
		}

		// Tạo đối tượng CD với dữ liệu đã nhập - ĐÂY LÀ PHẦN BẠN THIẾU
		CD cd = new CD(maCD, tuaCD, caSy, soBH, giaThanh);

		// Thêm CD vào danh sách
		if (danhSachCD.themCD(cd)) {
			System.out.println("Đã thêm CD thành công!");
		} else {
			System.out.println("Thêm CD thất bại!");
		}

		System.out.println("=====================================\n");
	}
}