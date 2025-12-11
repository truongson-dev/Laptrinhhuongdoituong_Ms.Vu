package Bai4;

import java.util.Scanner;

public class Main {

	// HÀM NHẬP SỐ NGUYÊN CÓ KIỂM TRA LỖI
	public static int nhapSoNguyen(Scanner sc, String message) {
		while (true) {
			try {
				System.out.print(message);
				String input = sc.nextLine();

				// Kiểm tra: chỉ cho phép nhập số
				if (!input.matches("\\d+")) {
					System.out.println("LỖI: Vui lòng chỉ nhập số nguyên dương!");
					continue;
				}

				return Integer.parseInt(input);
			} catch (Exception e) {
				System.out.println("LỖI: Nhập sai kiểu dữ liệu, vui lòng nhập lại!");
			}
		}
	}

	// HÀM NHẬP CHUỖI HỢP LỆ (không ký tự đặc biệt)
	public static String nhapChuoi(Scanner sc, String message) {
		while (true) {
			System.out.print(message);
			String input = sc.nextLine();

			// Không cho ký tự đặc biệt
			if (!input.matches("[a-zA-Z0-9À-ỹ ]+")) {
				System.out.println("LỖI: Không được dùng ký tự đặc biệt!");
				continue;
			}

			return input;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// NHẬP THÔNG TIN KHÁCH HÀNG
		String hoTen = nhapChuoi(sc, "Nhập họ tên khách hàng: ");
		String soNha = nhapChuoi(sc, "Nhập số nhà: ");
		String maCongTo = nhapChuoi(sc, "Nhập mã công tơ: ");

		KhachHang kh = new KhachHang(hoTen, soNha, maCongTo);

		// NHẬP CHỈ SỐ ĐIỆN VỚI KIỂM TRA
		int chiSoCu = nhapSoNguyen(sc, "Nhập chỉ số cũ: ");
		int chiSoMoi;

		while (true) {
			chiSoMoi = nhapSoNguyen(sc, "Nhập chỉ số mới: ");
			if (chiSoMoi < chiSoCu) {
				System.out.println("LỖI: Chỉ số mới phải lớn hơn chỉ số cũ!");
			} else {
				break;
			}
		}

		BienLai bl = new BienLai(chiSoCu, chiSoMoi, kh);

		bl.displayBill();

		sc.close();
	}
}