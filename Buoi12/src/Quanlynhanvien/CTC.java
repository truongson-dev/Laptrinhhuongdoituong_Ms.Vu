package Quanlynhanvien;

import java.util.Scanner;

public class CTC {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Xuly quanLy = new Xuly();

		while (true) {
			System.out.println("\n=== QUẢN LÝ NHÂN VIÊN ===");
			System.out.println("1. Nhập nhân viên");
			System.out.println("2. Xuất toàn bộ danh sách nhân viên");
			System.out.println("3. Xuất danh sách nhân viên FullTime");
			System.out.println("4. Xuất danh sách nhân viên PartTime");
			System.out.println("5. Tìm nhân viên có lương cao nhất");
			System.out.println("6. Tính tổng lương công ty phải trả");
			System.out.println("7. Thống kê số lượng nhân viên");
			System.out.println("8. Tìm kiếm nhân viên theo mã");
			System.out.println("9. Tìm kiếm nhân viên theo tên");
			System.out.println("10. Xóa nhân viên");
			System.out.println("11. Sắp xếp nhân viên theo lương giảm dần");
			System.out.println("0. Thoát chương trình");
			System.out.print("Chọn chức năng: ");

			int chon;
			try {
				chon = Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Vui lòng nhập số!");
				continue;
			}

			switch (chon) {
			case 1:
				quanLy.Nhapnhanvien();
				break;

			case 2:
				quanLy.XuatNhanvien();
				break;

			case 3:
				quanLy.XuatNhanvienFullTime();
				break;

			case 4:
				quanLy.XuatNhanvienPartTime();
				break;

			case 5:
				quanLy.TimNhanVienLuongCaoNhat();
				break;

			case 6:
				quanLy.TinhTongLuong();
				break;

			case 7:
				quanLy.ThongKeSoLuong();
				break;

			case 8:
				quanLy.TimKiemTheoMa();
				break;

			case 9:
				quanLy.TimKiemTheoTen();
				break;

			case 10:
				quanLy.XoaNhanVien();
				break;

			case 11:
				quanLy.SapXepTheoLuongGiamDan();
				break;

			case 0:
				System.out.println("Cảm ơn đã sử dụng chương trình!");
				scanner.close();
				return;

			default:
				System.out.println("Chức năng không hợp lệ! Vui lòng chọn lại.");
			}
		}
	}
}