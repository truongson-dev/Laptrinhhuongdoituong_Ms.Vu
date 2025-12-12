package QLSV;

public class Main {
	public static void main(String[] args) {
		QuanLySinhVien qlsv = new QuanLySinhVien();
		int chon;

		do {
			System.out.println("\n===========================================");
			System.out.println("    HỆ THỐNG QUẢN LÝ SINH VIÊN ĐHCN        ");
			System.out.println("===========================================");
			System.out.println("1. Nhập sinh viên mới");
			System.out.println("2. Xuất danh sách sinh viên");
			System.out.println("3. Sắp xếp theo Mã SV (từng hệ)");
			System.out.println("4. Thống kê số lượng");
			System.out.println("5. Tìm kiếm theo Tên");
			System.out.println("6. In danh sách Khen thưởng");
			System.out.println("7. Thoát chương trình");
			System.out.println("-------------------------------------------");

			chon = KiemTraDauVao.nhapSoNguyen("Mời bạn chọn chức năng (1-7): ", 1, 7);

			switch (chon) {
			case 1:
				qlsv.nhapMoi();
				break;
			case 2:
				qlsv.xuatDanhSach();
				break;
			case 3:
				qlsv.sapXepTheoMa();
				break;
			case 4:
				qlsv.thongKe();
				break;
			case 5:
				qlsv.timKiem();
				break;
			case 6:
				qlsv.inDSNhanThuong();
				break;
			case 7:
				System.out.println("Đã thoát chương trình. Hẹn gặp lại!");
				break;
			}
		} while (chon != 7);
	}
}