package QLSV;

public class SVHeNienChe extends SinhVien {
	private int nienChe; // 2 hoặc 3 năm
	private double diemThiTN; // Thang 10
	private String xepLoai; // Tự động tính

	@Override
	public void nhapThongTin() {
		super.nhapThongTin(); // Gọi nhập thông tin chung
		System.out.println("--- THÔNG TIN RIÊNG (HỆ NIÊN CHẾ) ---");

		// Rào lỗi: Chỉ nhập 2 hoặc 3
		this.nienChe = KiemTraDauVao.nhapSoNguyen("Nhập Niên chế (2 năm-Trung Cấp hoặc 3 năm-Cao Đẳng): ", 2, 3);

		// Rào lỗi: Điểm từ 0.0 đến 10.0
		this.diemThiTN = KiemTraDauVao.nhapDiem("Nhập Điểm thi tốt nghiệp (Thang 10): ", 0.0, 10.0);

		// Logic tự động xếp loại
		tuDongXepLoai();
		System.out.println("=> Hệ thống đã xếp loại: " + this.xepLoai);
	}

	private void tuDongXepLoai() {
		if (diemThiTN >= 8.0) {
			xepLoai = "Giỏi";
		} else if (diemThiTN >= 6.5) {
			xepLoai = "Khá";
		} else if (diemThiTN >= 5.0) {
			xepLoai = "TB";
		} else {
			xepLoai = "Yếu";
		}
	}

	@Override
	public void xuatThongTin() {
		super.xuatThongTin();
		System.out.printf(" | Hệ: Niên Chế | NC: %d năm | Điểm TN: %-5.2f | Loại: %s\n", nienChe, diemThiTN, xepLoai);
	}

	@Override
	public boolean kiemTraNhanThuong() {
//        [cite_start]// [cite: 13] Hệ niên chế nhận thưởng nếu xếp loại Giỏi
		return "Giỏi".equals(xepLoai);
	}
}