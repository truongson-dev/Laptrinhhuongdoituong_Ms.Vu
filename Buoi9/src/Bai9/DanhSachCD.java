package Bai9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DanhSachCD {
	private List<CD> danhSach;

	public DanhSachCD() {
		danhSach = new ArrayList<>();
	}

	// Phương thức thêm CD - SỬA LẠI
	public boolean themCD(CD cd) {
		// Kiểm tra trùng mã CD
		for (CD item : danhSach) {
			if (item.getMaCD() == cd.getMaCD()) { // Sửa: kiểm tra mã CD, không phải tựa CD
				System.out.println("Mã CD " + cd.getMaCD() + " đã tồn tại! Không thể thêm.");
				return false;
			}
		}

		// Kiểm tra số bài hát và giá thành hợp lệ
		if (cd.getSoBH() <= 0) {
			System.out.println("Số bài hát phải lớn hơn 0!");
			return false;
		}

		if (cd.getGiaThanh() <= 0) {
			System.out.println("Giá thành phải lớn hơn 0!");
			return false;
		}

		danhSach.add(cd);
		System.out.println("Thêm CD thành công!");
		return true;
	}

	// Số lượng CD
	public int soLuongCD() {
		return danhSach.size();
	}

	// Tổng giá thành
	public double tongGiaThanh() {
		double tong = 0;
		for (CD cd : danhSach) {
			tong += cd.getGiaThanh();
		}
		return tong;
	}

	// Sắp xếp giảm dần theo giá thành
	public void sapXepGiamTheoGiaThanh() {
		Collections.sort(danhSach, new Comparator<CD>() {
			@Override
			public int compare(CD cd1, CD cd2) {
				return Double.compare(cd2.getGiaThanh(), cd1.getGiaThanh());
			}
		});
		System.out.println("Đã sắp xếp giảm dần theo giá thành!");
	}

	// Sắp xếp tăng dần theo tựa CD
	public void sapXepTangTheoTuaCD() {
		Collections.sort(danhSach, new Comparator<CD>() {
			@Override
			public int compare(CD cd1, CD cd2) {
				return cd1.getTuaCD().compareToIgnoreCase(cd2.getTuaCD());
			}
		});
		System.out.println("Đã sắp xếp tăng dần theo tựa CD!");
	}

	// Xuất toàn bộ danh sách
	public void xuatDanhSach() {
		if (danhSach.isEmpty()) {
			System.out.println("Danh sách CD trống!");
			return;
		}

		System.out.println("════════════════════════════════════════════════════════════════════════════════════════");
		System.out.printf("%-10s %-20s %-20s %-10s %-15s\n", "Mã CD", "Tựa CD", "Ca sĩ", "Số bài", "Giá thành");
		System.out.println("════════════════════════════════════════════════════════════════════════════════════════");

		for (CD cd : danhSach) {
			System.out.println(cd.toString());
		}

		System.out.println("════════════════════════════════════════════════════════════════════════════════════════");
		System.out.println("Tổng số CD: " + soLuongCD());
		System.out.println("Tổng giá thành: " + String.format("%.2f", tongGiaThanh()));
		System.out
				.println("════════════════════════════════════════════════════════════════════════════════════════\n");
	}
}