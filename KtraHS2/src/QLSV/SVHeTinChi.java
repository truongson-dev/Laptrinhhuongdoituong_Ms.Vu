package QLSV;

public class SVHeTinChi extends SinhVien {
	private int tinChi;
	private String tenDeTaiTN;
	private double diemDanhGia; // Thang 5
	private String xepLoai; // A, B, C, D (Tự động tính)

	@Override
	public void nhapThongTin() {
		super.nhapThongTin();
		System.out.println("--- THÔNG TIN RIÊNG (HỆ TÍN CHỈ) ---");

		this.tinChi = KiemTraDauVao.nhapSoNguyenDuong("Nhập số Tín chỉ tích lũy: ");
		this.tenDeTaiTN = KiemTraDauVao.nhapChuoi("Nhập tên Đề tài tốt nghiệp: ");

		// Rào lỗi: Điểm từ 0.0 đến 5.0
		this.diemDanhGia = KiemTraDauVao.nhapDiem("Nhập Điểm đánh giá (Thang 5): ", 0.0, 5.0);

		// Logic tự động xếp loại
		tuDongXepLoai();
		System.out.println("=> Hệ thống đã xếp loại: " + this.xepLoai);
	}

	private void tuDongXepLoai() {
		if (diemDanhGia >= 4.0) {
			xepLoai = "A";
		} else if (diemDanhGia >= 3.0) {
			xepLoai = "B";
		} else if (diemDanhGia >= 2.0) {
			xepLoai = "C";
		} else {
			xepLoai = "D";
		}
	}

	@Override
	public void xuatThongTin() {
		super.xuatThongTin();
		System.out.printf(" | Hệ: Tín Chỉ  | TC: %-4d | Điểm ĐG: %-5.2f | Loại: %-2s | Đề tài: %s\n", tinChi,
				diemDanhGia, xepLoai, tenDeTaiTN);
	}

	@Override
	public boolean kiemTraNhanThuong() {
//        [cite_start]// [cite: 13] Hệ đại học nhận thưởng nếu xếp loại A
		return "A".equals(xepLoai);
	}
}