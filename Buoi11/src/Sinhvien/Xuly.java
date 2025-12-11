package Sinhvien;

import java.util.ArrayList;
import java.util.Scanner;

public class Xuly {
	private ArrayList<Connguoi> danhSach;
	private Scanner scanner;

	// Constructor
	public Xuly() {
		danhSach = new ArrayList<>();
		scanner = new Scanner(System.in);
	}

	// Phương thức nhập danh sách
	public void nhapDanhSach() {
		System.out.println("\n=== NHẬP DANH SÁCH ===");
		System.out.print("Nhập số lượng người: ");
		int n = 0;

		while (true) {
			try {
				n = Integer.parseInt(scanner.nextLine());
				if (n > 0) {
					break;
				} else {
					System.out.print("Số lượng phải lớn hơn 0! Nhập lại: ");
				}
			} catch (NumberFormatException e) {
				System.out.print("Vui lòng nhập số nguyên hợp lệ! Nhập lại: ");
			}
		}

		for (int i = 0; i < n; i++) {
			System.out.println("\nNhập thông tin người thứ " + (i + 1) + ":");
			System.out.println("1. Sinh viên");
			System.out.println("2. Giáo viên");
			System.out.print("Chọn loại (1/2): ");

			int choice = 0;
			while (true) {
				try {
					choice = Integer.parseInt(scanner.nextLine());
					if (choice == 1 || choice == 2) {
						break;
					} else {
						System.out.print("Vui lòng chọn 1 hoặc 2! Nhập lại: ");
					}
				} catch (NumberFormatException e) {
					System.out.print("Vui lòng nhập số hợp lệ! Nhập lại: ");
				}
			}

			if (choice == 1) {
				Sinhvien sv = new Sinhvien();
				sv.nhapThongTin();
				danhSach.add(sv);
			} else {
				Giaovien gv = new Giaovien();
				gv.nhapThongTin();
				danhSach.add(gv);
			}
		}
		System.out.println("\nĐã nhập xong " + n + " người!");
	}

	// Phương thức xuất danh sách
	public void xuatDanhSach() {
		if (danhSach.isEmpty()) {
			System.out.println("\nDanh sách rỗng!");
			return;
		}

		System.out.println("\n=== XUẤT TOÀN BỘ DANH SÁCH ===");

		// Xuất sinh viên
		boolean coSinhvien = false;
		for (Connguoi Connguoi : danhSach) {
			if (Connguoi instanceof Sinhvien) {
				if (!coSinhvien) {
					Sinhvien.xuatTieuDe();
					coSinhvien = true;
				}
				((Sinhvien) Connguoi).xuatThongTinNgan();
			}
		}

		// Xuất giáo viên
		boolean coGiaovien = false;
		for (Connguoi Connguoi : danhSach) {
			if (Connguoi instanceof Giaovien) {
				if (!coGiaovien) {
					Giaovien.xuatTieuDe();
					coGiaovien = true;
				}
				((Giaovien) Connguoi).xuatThongTinNgan();
			}
		}

		System.out.println("\nTổng số người: " + danhSach.size());
		System.out.println("Số sinh viên: " + demSinhvien());
		System.out.println("Số giáo viên: " + demGiaovien());
	}

	// Phương thức xuất chi tiết từng người
	public void xuatChiTiet() {
		if (danhSach.isEmpty()) {
			System.out.println("\nDanh sách rỗng!");
			return;
		}

		System.out.println("\n=== XUẤT CHI TIẾT DANH SÁCH ===");
		for (int i = 0; i < danhSach.size(); i++) {
			System.out.println("\nNgười thứ " + (i + 1) + ":");
			if (danhSach.get(i) instanceof Sinhvien) {
				((Sinhvien) danhSach.get(i)).xuatThongTin();
			} else {
				((Giaovien) danhSach.get(i)).xuatThongTin();
			}
		}
	}

	// Phương thức đếm số sinh viên
	public int demSinhvien() {
		int count = 0;
		for (Connguoi Connguoi : danhSach) {
			if (Connguoi instanceof Sinhvien) {
				count++;
			}
		}
		return count;
	}

	// Phương thức đếm số giáo viên
	public int demGiaovien() {
		int count = 0;
		for (Connguoi Connguoi : danhSach) {
			if (Connguoi instanceof Giaovien) {
				count++;
			}
		}
		return count;
	}

	// Phương thức tìm kiếm theo tên
	public void timKiemTheoTen() {
		if (danhSach.isEmpty()) {
			System.out.println("\nDanh sách rỗng!");
			return;
		}

		System.out.print("\nNhập tên cần tìm: ");
		String ten = scanner.nextLine().toLowerCase();

		boolean found = false;
		System.out.println("\n=== KẾT QUẢ TÌM KIẾM ===");

		for (Connguoi Connguoi : danhSach) {
			if (Connguoi.getHoTen().toLowerCase().contains(ten)) {
				if (!found) {
					System.out.println("Tìm thấy người có tên chứa: " + ten);
				}
				if (Connguoi instanceof Sinhvien) {
					((Sinhvien) Connguoi).xuatThongTin();
				} else {
					((Giaovien) Connguoi).xuatThongTin();
				}
				found = true;
			}
		}

		if (!found) {
			System.out.println("Không tìm thấy người có tên: " + ten);
		}
	}

	// Phương thức xóa theo vị trí
	public void xoaTheoViTri() {
		if (danhSach.isEmpty()) {
			System.out.println("\nDanh sách rỗng!");
			return;
		}

		System.out.print("\nNhập vị trí cần xóa (1-" + danhSach.size() + "): ");
		try {
			int viTri = Integer.parseInt(scanner.nextLine()) - 1;

			if (viTri >= 0 && viTri < danhSach.size()) {
				System.out.println("Đã xóa người ở vị trí " + (viTri + 1) + ":");
				if (danhSach.get(viTri) instanceof Sinhvien) {
					System.out.println("Sinh viên: " + danhSach.get(viTri).getHoTen());
				} else {
					System.out.println("Giáo viên: " + danhSach.get(viTri).getHoTen());
				}
				danhSach.remove(viTri);
				System.out.println("Xóa thành công!");
			} else {
				System.out.println("Vị trí không hợp lệ!");
			}
		} catch (NumberFormatException e) {
			System.out.println("Vui lòng nhập số hợp lệ!");
		}
	}

	// Phương thức thống kê
	public void thongKe() {
		if (danhSach.isEmpty()) {
			System.out.println("\nDanh sách rỗng!");
			return;
		}

		System.out.println("\n=== THỐNG KÊ ===");
		System.out.println("Tổng số người: " + danhSach.size());
		System.out.println("Số sinh viên: " + demSinhvien());
		System.out.println("Số giáo viên: " + demGiaovien());

		// Thống kê xếp loại sinh viên
		if (demSinhvien() > 0) {
			System.out.println("\n=== THỐNG KÊ XẾP LOẠI SINH VIÊN ===");
			int gioi = 0, kha = 0, tb = 0, yeu = 0;

			for (Connguoi Connguoi : danhSach) {
				if (Connguoi instanceof Sinhvien) {
					Sinhvien sv = (Sinhvien) Connguoi;
					String xepLoai = sv.xepLoaiRenLuyen();
					switch (xepLoai) {
					case "Giỏi":
						gioi++;
						break;
					case "Khá":
						kha++;
						break;
					case "Trung bình":
						tb++;
						break;
					case "Yếu":
						yeu++;
						break;
					}
				}
			}

			System.out.println("Giỏi: " + gioi);
			System.out.println("Khá: " + kha);
			System.out.println("Trung bình: " + tb);
			System.out.println("Yếu: " + yeu);
		}

		// Thống kê xếp loại giáo viên
		if (demGiaovien() > 0) {
			System.out.println("\n=== THỐNG KÊ XẾP LOẠI GIÁO VIÊN ===");
			int a = 0, b = 0, c = 0, d = 0;

			for (Connguoi Connguoi : danhSach) {
				if (Connguoi instanceof Giaovien) {
					Giaovien gv = (Giaovien) Connguoi;
					String xepLoai = gv.xepLoaiThiDua();
					switch (xepLoai) {
					case "A":
						a++;
						break;
					case "B":
						b++;
						break;
					case "C":
						c++;
						break;
					case "D":
						d++;
						break;
					}
				}
			}

			System.out.println("Loại A: " + a);
			System.out.println("Loại B: " + b);
			System.out.println("Loại C: " + c);
			System.out.println("Loại D: " + d);
		}
	}
}