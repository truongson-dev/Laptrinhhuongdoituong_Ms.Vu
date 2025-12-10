package Quanlynhanvien;

import java.util.ArrayList;
import java.util.Scanner;

public class Xuly {
	Scanner sc = new Scanner(System.in);
	// Khai báo mảng động ArrayList để lưu trữ danh sách nhân viên
	ArrayList<Employee> danhSachNV = new ArrayList<Employee>();

	// 1. Hàm nhập nhân viên
	public void Nhapnhanvien() {
		sc.nextLine(); // Đọc bỏ dòng thừa sau nextInt()

		// Khai báo các biến tương ứng với thuộc tính lớp
		String hoten, mnv;
		int tuoi;
		int sogiolam;
		double hsluong;
		double luongcb, dongia;

		System.out.println("\n=== NHẬP THÔNG TIN NHÂN VIÊN ===");
		System.out.println("1. Nhập FullTime");
		System.out.println("2. Nhập PartTime");
		System.out.print("Chọn loại nhân viên: ");
		int chon = sc.nextInt();
		sc.nextLine(); // Đọc bỏ dòng thừa

		// Nhập thông tin chung (Person, Employee)
		System.out.print("Nhập họ tên: ");
		hoten = sc.nextLine();

		System.out.print("Nhập mã nhân viên: ");
		mnv = sc.nextLine();

		System.out.print("Nhập tuổi: ");
		tuoi = sc.nextInt();

		System.out.print("Nhập hệ số lương: ");
		hsluong = sc.nextDouble();

		// Kiểm tra lựa chọn để nhập thuộc tính riêng
		if (chon == 1) { // Nhập cho Fulltime có tính lương cơ bản
			System.out.print("Nhập lương cơ bản: ");
			luongcb = sc.nextDouble();

			// Khởi tạo biến đối tượng FullTimeEmployee
			FullTimeEmployee nvft = new FullTimeEmployee(hoten, tuoi, mnv, hsluong, luongcb);

			// Add vô danh sách nhân viên
			danhSachNV.add(nvft);
			System.out.println("Đã thêm nhân viên FullTime thành công!");

		} else if (chon == 2) { // Nhập cho parttime có tính Sogiolam, Dongia_Gio
			System.out.print("Nhập số giờ làm: ");
			sogiolam = sc.nextInt();

			System.out.print("Nhập đơn giá giờ: ");
			dongia = sc.nextDouble();

			// Khởi tạo biến đối tượng PartTimeEmployee
			PartTimeEmployee nvpt = new PartTimeEmployee(hoten, tuoi, mnv, hsluong, sogiolam, dongia);

			// Add vô danh sách nhân viên
			danhSachNV.add(nvpt);
			System.out.println("Đã thêm nhân viên PartTime thành công!");
		} else {
			System.out.println("Lựa chọn không hợp lệ");
		}
	}

	// 2. Hàm xuất thông tin toàn bộ nhân viên
	public void XuatNhanvien() {
		if (danhSachNV.isEmpty()) {
			System.out.println("\nDanh sách nhân viên trống!");
			return;
		}

		System.out.println("\n=== DANH SÁCH TOÀN BỘ NHÂN VIÊN ===");
		System.out.println("═══════════════════════════════════════════════════════════════════════════");
		System.out.printf("%-5s %-10s %-20s %-6s %-15s %-12s\n", "STT", "Mã NV", "Họ tên", "Tuổi", "Lương", "Loại");
		System.out.println("═══════════════════════════════════════════════════════════════════════════");

		for (int i = 0; i < danhSachNV.size(); i++) {
			Employee nv = danhSachNV.get(i);
			String loai = (nv instanceof FullTimeEmployee) ? "FullTime" : "PartTime";
			System.out.printf("%-5d %-10s %-20s %-6d %-15.0f %-12s\n", i + 1, nv.getMaNV(), nv.getHoten(), nv.getTuoi(),
					nv.Tinhluong(), loai);
		}
		System.out.println("═══════════════════════════════════════════════════════════════════════════");
	}

	// 3. Xuất nhân viên FullTime
	public void XuatNhanvienFullTime() {
		System.out.println("\n=== DANH SÁCH NHÂN VIÊN FULLTIME ===");
		boolean found = false;

		for (int i = 0; i < danhSachNV.size(); i++) {
			Employee nv = danhSachNV.get(i);
			if (nv instanceof FullTimeEmployee) {
				if (!found) {
					System.out.println(
							"═══════════════════════════════════════════════════════════════════════════════════════════════════════════");
					System.out.printf("%-5s %-10s %-20s %-6s %-15s %-12s %-12s\n", "STT", "Mã NV", "Họ tên", "Tuổi",
							"Lương CB", "Hệ số", "Tổng lương");
					System.out.println(
							"═══════════════════════════════════════════════════════════════════════════════════════════════════════════");
					found = true;
				}

				FullTimeEmployee ft = (FullTimeEmployee) nv;
				System.out.printf("%-5d %-10s %-20s %-6d %-15.0f %-12.2f %-12.0f\n", i + 1, ft.getMaNV(), ft.getHoten(),
						ft.getTuoi(), ft.getLuongcoban(), ft.getHesoluong(), ft.Tinhluong());
			}
		}

		if (!found) {
			System.out.println("Không có nhân viên FullTime trong danh sách!");
		} else {
			System.out.println(
					"═══════════════════════════════════════════════════════════════════════════════════════════════════════════");
		}
	}

	// 4. Xuất nhân viên PartTime
	public void XuatNhanvienPartTime() {
		System.out.println("\n=== DANH SÁCH NHÂN VIÊN PARTTIME ===");
		boolean found = false;

		for (int i = 0; i < danhSachNV.size(); i++) {
			Employee nv = danhSachNV.get(i);
			if (nv instanceof PartTimeEmployee) {
				if (!found) {
					System.out.println(
							"═══════════════════════════════════════════════════════════════════════════════════════════════════════════");
					System.out.printf("%-5s %-10s %-20s %-6s %-10s %-12s %-12s %-12s\n", "STT", "Mã NV", "Họ tên",
							"Tuổi", "Số giờ", "Đơn giá", "Hệ số", "Tổng lương");
					System.out.println(
							"═══════════════════════════════════════════════════════════════════════════════════════════════════════════");
					found = true;
				}

				PartTimeEmployee pt = (PartTimeEmployee) nv;
				System.out.printf("%-5d %-10s %-20s %-6d %-10d %-12.0f %-12.2f %-12.0f\n", i + 1, pt.getMaNV(),
						pt.getHoten(), pt.getTuoi(), pt.getSoGioLam(), pt.getDonGiaGio(), pt.getHesoluong(),
						pt.Tinhluong());
			}
		}

		if (!found) {
			System.out.println("Không có nhân viên PartTime trong danh sách!");
		} else {
			System.out.println(
					"═══════════════════════════════════════════════════════════════════════════════════════════════════════════");
		}
	}

	// 5. Tìm nhân viên có lương cao nhất
	public void TimNhanVienLuongCaoNhat() {
		if (danhSachNV.isEmpty()) {
			System.out.println("\nDanh sách nhân viên trống!");
			return;
		}

		Employee nvCaoNhat = danhSachNV.get(0);
		double maxLuong = nvCaoNhat.Tinhluong();

		// Duyệt qua danh sách để tìm lương cao nhất
		for (Employee nv : danhSachNV) {
			if (nv.Tinhluong() > maxLuong) {
				maxLuong = nv.Tinhluong();
				nvCaoNhat = nv;
			}
		}

		System.out.println("\n=== NHÂN VIÊN CÓ LƯƠNG CAO NHẤT ===");
		System.out.println("══════════════════════════════════════════════════════════════");

		String loai = (nvCaoNhat instanceof FullTimeEmployee) ? "FullTime" : "PartTime";
		System.out.println("Mã NV: " + nvCaoNhat.getMaNV());
		System.out.println("Họ tên: " + nvCaoNhat.getHoten());
		System.out.println("Tuổi: " + nvCaoNhat.getTuoi());
		System.out.println("Loại: " + loai);
		System.out.printf("Lương: %.0f VND\n", nvCaoNhat.Tinhluong());

		// Hiển thị thêm thông tin chi tiết
		if (nvCaoNhat instanceof FullTimeEmployee) {
			FullTimeEmployee ft = (FullTimeEmployee) nvCaoNhat;
			System.out.printf("Hệ số lương: %.2f\n", ft.getHesoluong());
			System.out.printf("Lương cơ bản: %.0f VND\n", ft.getLuongcoban());
		} else if (nvCaoNhat instanceof PartTimeEmployee) {
			PartTimeEmployee pt = (PartTimeEmployee) nvCaoNhat;
			System.out.println("Số giờ làm: " + pt.getSoGioLam());
			System.out.printf("Đơn giá giờ: %.0f VND\n", pt.getDonGiaGio());
		}
		System.out.println("══════════════════════════════════════════════════════════════");
	}

	// 6. Tính tổng lương công ty phải trả
	public void TinhTongLuong() {
		if (danhSachNV.isEmpty()) {
			System.out.println("\nDanh sách nhân viên trống!");
			return;
		}

		double tongLuong = 0;
		for (Employee nv : danhSachNV) {
			tongLuong += nv.Tinhluong();
		}

		System.out.println("\n=== TỔNG LƯƠNG CÔNG TY PHẢI TRẢ ===");
		System.out.printf("Tổng lương: %,.0f VND\n", tongLuong);
		System.out.printf("Trung bình lương: %,.0f VND/nhân viên\n", tongLuong / danhSachNV.size());
	}

	// 7. Thống kê số lượng nhân viên
	public void ThongKeSoLuong() {
		int soFullTime = 0;
		int soPartTime = 0;
		double tongLuongFT = 0;
		double tongLuongPT = 0;

		for (Employee nv : danhSachNV) {
			if (nv instanceof FullTimeEmployee) {
				soFullTime++;
				tongLuongFT += nv.Tinhluong();
			} else if (nv instanceof PartTimeEmployee) {
				soPartTime++;
				tongLuongPT += nv.Tinhluong();
			}
		}

		System.out.println("\n=== THỐNG KÊ SỐ LƯỢNG NHÂN VIÊN ===");
		System.out.println("══════════════════════════════════════════════════════════════");
		System.out.println("Tổng số nhân viên: " + danhSachNV.size());
		System.out.println("Số nhân viên FullTime: " + soFullTime);
		System.out.println("Số nhân viên PartTime: " + soPartTime);
		System.out.printf("Tổng lương FullTime: %,.0f VND\n", tongLuongFT);
		System.out.printf("Tổng lương PartTime: %,.0f VND\n", tongLuongPT);
		System.out.printf("Tổng lương toàn công ty: %,.0f VND\n", tongLuongFT + tongLuongPT);
		System.out.println("══════════════════════════════════════════════════════════════");
	}

	// 8. Tìm kiếm nhân viên theo mã
	public void TimKiemTheoMa() {
		sc.nextLine(); // Đọc bỏ dòng thừa
		System.out.print("\nNhập mã nhân viên cần tìm: ");
		String maNV = sc.nextLine();

		boolean found = false;
		for (Employee nv : danhSachNV) {
			if (nv.getMaNV().equalsIgnoreCase(maNV)) {
				System.out.println("\n=== THÔNG TIN NHÂN VIÊN ===");
				System.out.println("Mã NV: " + nv.getMaNV());
				System.out.println("Họ tên: " + nv.getHoten());
				System.out.println("Tuổi: " + nv.getTuoi());
				System.out.printf("Hệ số lương: %.2f\n", nv.getHesoluong());
				System.out.printf("Lương: %.0f VND\n", nv.Tinhluong());

				if (nv instanceof FullTimeEmployee) {
					FullTimeEmployee ft = (FullTimeEmployee) nv;
					System.out.println("Loại: FullTime");
					System.out.printf("Lương cơ bản: %.0f VND\n", ft.getLuongcoban());
				} else if (nv instanceof PartTimeEmployee) {
					PartTimeEmployee pt = (PartTimeEmployee) nv;
					System.out.println("Loại: PartTime");
					System.out.println("Số giờ làm: " + pt.getSoGioLam());
					System.out.printf("Đơn giá giờ: %.0f VND\n", pt.getDonGiaGio());
				}
				found = true;
				break;
			}
		}

		if (!found) {
			System.out.println("Không tìm thấy nhân viên với mã: " + maNV);
		}
	}

	// 9. Tìm kiếm nhân viên theo tên
	public void TimKiemTheoTen() {
		sc.nextLine(); // Đọc bỏ dòng thừa
		System.out.print("\nNhập tên nhân viên cần tìm: ");
		String tenNV = sc.nextLine();

		boolean found = false;
		System.out.println("\n=== KẾT QUẢ TÌM KIẾM ===");

		for (Employee nv : danhSachNV) {
			if (nv.getHoten().toLowerCase().contains(tenNV.toLowerCase())) {
				System.out.println("Mã NV: " + nv.getMaNV());
				System.out.println("Họ tên: " + nv.getHoten());
				System.out.println("Tuổi: " + nv.getTuoi());
				System.out.printf("Lương: %.0f VND\n", nv.Tinhluong());
				System.out.println("---");
				found = true;
			}
		}

		if (!found) {
			System.out.println("Không tìm thấy nhân viên với tên: " + tenNV);
		}
	}

	// 10. Xóa nhân viên theo mã
	public void XoaNhanVien() {
		sc.nextLine(); // Đọc bỏ dòng thừa
		System.out.print("\nNhập mã nhân viên cần xóa: ");
		String maNV = sc.nextLine();

		for (int i = 0; i < danhSachNV.size(); i++) {
			if (danhSachNV.get(i).getMaNV().equalsIgnoreCase(maNV)) {
				String tenNV = danhSachNV.get(i).getHoten();
				danhSachNV.remove(i);
				System.out.println("Đã xóa nhân viên [" + tenNV + "] với mã: " + maNV);
				return;
			}
		}

		System.out.println("Không tìm thấy nhân viên với mã: " + maNV);
	}

	// 11. Sắp xếp nhân viên theo lương giảm dần
	public void SapXepTheoLuongGiamDan() {
		if (danhSachNV.isEmpty()) {
			System.out.println("\nDanh sách nhân viên trống!");
			return;
		}

		// Sắp xếp bằng bubble sort
		for (int i = 0; i < danhSachNV.size() - 1; i++) {
			for (int j = 0; j < danhSachNV.size() - i - 1; j++) {
				if (danhSachNV.get(j).Tinhluong() < danhSachNV.get(j + 1).Tinhluong()) {
					// Hoán đổi vị trí
					Employee temp = danhSachNV.get(j);
					danhSachNV.set(j, danhSachNV.get(j + 1));
					danhSachNV.set(j + 1, temp);
				}
			}
		}

		System.out.println("Đã sắp xếp danh sách theo lương giảm dần!");
		System.out.println("Vui lòng chọn chức năng '2. Xuất toàn bộ danh sách nhân viên' để xem kết quả.");
	}

	// 12. Hiển thị menu
	public void HienThiMenu() {
		System.out.println("\n=== MENU QUẢN LÝ NHÂN VIÊN ===");
		System.out.println("1. Nhập nhân viên");
		System.out.println("2. Xuất toàn bộ danh sách nhân viên");
		System.out.println("3. Xuất danh sách nhân viên FullTime");
		System.out.println("4. Xuất danh sách nhân viên PartTime");
		System.out.println("5. Tìm nhân viên có lương cao nhất");
		System.out.println("6. Tính tổng lương công ty phải trả");
		System.out.println("7. Thống kê số lượng nhân viên");
		System.out.println("8. Tìm kiếm nhân viên theo mã");
		System.out.println("9. Tìm kiếm nhân viên theo tên");
		System.out.println("10. Xóa nhân viên theo mã");
		System.out.println("11. Sắp xếp nhân viên theo lương giảm dần");
		System.out.println("0. Thoát chương trình");
		System.out.print("Chọn chức năng: ");
	}
}