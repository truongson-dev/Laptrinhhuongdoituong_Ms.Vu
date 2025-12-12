package QLSV;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class QuanLySinhVien {
	private List<SinhVien> dsSinhVien = new ArrayList<>();

	// Chức năng 1: Nhập
	public void nhapMoi() {
		System.out.println("\n--- CHỌN LOẠI SINH VIÊN ---");
		System.out.println("1. Sinh viên Hệ Niên Chế (Trung cấp/Cao đẳng)");
		System.out.println("2. Sinh viên Hệ Tín Chỉ (Đại học)");
		int chon = KiemTraDauVao.nhapSoNguyen("Bạn chọn (1 hoặc 2): ", 1, 2);

		SinhVien sv;
		if (chon == 1) {
			sv = new SVHeNienChe();
		} else {
			sv = new SVHeTinChi();
		}

		sv.nhapThongTin();
		dsSinhVien.add(sv);
		System.out.println(">> Đã thêm sinh viên vào danh sách!");
	}

	// Chức năng 2: Xuất
	public void xuatDanhSach() {
		if (dsSinhVien.isEmpty()) {
			System.out.println(">> Danh sách đang trống!");
			return;
		}
		System.out.println("\n-------------------- DANH SÁCH SINH VIÊN --------------------");
		for (SinhVien sv : dsSinhVien) {
			sv.xuatThongTin();
		}
		System.out.println("-------------------------------------------------------------");
	}

	// Chức năng 3: Sắp xếp theo mã (Riêng từng hệ)
	public void sapXepTheoMa() {
		if (dsSinhVien.isEmpty()) {
			return;
		}

		List<SinhVien> listNienChe = new ArrayList<>();
		List<SinhVien> listTinChi = new ArrayList<>();

		// Phân loại danh sách
		for (SinhVien sv : dsSinhVien) {
			if (sv instanceof SVHeNienChe) {
				listNienChe.add(sv);
			} else {
				listTinChi.add(sv);
			}
		}

		// Tạo bộ so sánh theo mã SV
		Comparator<SinhVien> comp = new Comparator<SinhVien>() {
			@Override
			public int compare(SinhVien s1, SinhVien s2) {
				return s1.getMaSV().compareToIgnoreCase(s2.getMaSV());
			}
		};

		Collections.sort(listNienChe, comp);
		Collections.sort(listTinChi, comp);

		System.out.println("\n--- DANH SÁCH HỆ NIÊN CHẾ (ĐÃ SẮP XẾP MÃ) ---");
		for (SinhVien sv : listNienChe) {
			sv.xuatThongTin();
		}

		System.out.println("\n--- DANH SÁCH HỆ TÍN CHỈ (ĐÃ SẮP XẾP MÃ) ---");
		for (SinhVien sv : listTinChi) {
			sv.xuatThongTin();
		}
	}

	// Chức năng 4: Thống kê
	public void thongKe() {
		int tong = dsSinhVien.size();
		int nienChe = 0;
		int tinChi = 0;

		for (SinhVien sv : dsSinhVien) {
			if (sv instanceof SVHeNienChe) {
				nienChe++;
			} else {
				tinChi++;
			}
		}

		System.out.println("\n--- BẢNG THỐNG KÊ ---");
		System.out.println("Tổng số sinh viên: " + tong);
		System.out.println("- Hệ Niên Chế: " + nienChe);
		System.out.println("- Hệ Tín Chỉ: " + tinChi);
	}

	// Chức năng 5: Tìm kiếm theo tên
	public void timKiem() {
		String tuKhoa = KiemTraDauVao.nhapChuoi("Nhập tên sinh viên cần tìm: ").toLowerCase();
		boolean thay = false;
		System.out.println("\n>> KẾT QUẢ TÌM KIẾM:");
		for (SinhVien sv : dsSinhVien) {
			if (sv.getHoTen().toLowerCase().contains(tuKhoa)) {
				sv.xuatThongTin();
				thay = true;
			}
		}
		if (!thay) {
			System.out.println("Không tìm thấy sinh viên nào có tên: " + tuKhoa);
		}
	}

	// Chức năng 6: In danh sách nhận thưởng
	public void inDSNhanThuong() {
		System.out.println("\n--- DANH SÁCH SINH VIÊN NHẬN THƯỞNG CUỐI KHÓA ---");
		System.out.println("(Điều kiện: Hệ Niên chế - Giỏi, Hệ Tín chỉ - A)");
		boolean coNguoi = false;
		for (SinhVien sv : dsSinhVien) {
			if (sv.kiemTraNhanThuong()) {
				sv.xuatThongTin();
				coNguoi = true;
			}
		}
		if (!coNguoi) {
			System.out.println(">> Rất tiếc, chưa có sinh viên nào đủ điều kiện.");
		}
	}
}