package KTM;

import java.util.Scanner;

/**
 * Lớp đại diện cho Phòng kiểm kê
 */
public class PhongKiemKe {
	// ============== ATTRIBUTES ==============
	private String maPhong;
	private String tenPhong;
	private String truongPhong;
	private String diaChi;
	private String soDienThoaiPhong;

	// ============== CONSTRUCTORS ==============

	public PhongKiemKe() {
		this.maPhong = "";
		this.tenPhong = "";
		this.truongPhong = "";
		this.diaChi = "";
		this.soDienThoaiPhong = "";
	}

	public PhongKiemKe(String maPhong, String tenPhong, String truongPhong) {
		this.maPhong = maPhong;
		this.tenPhong = tenPhong;
		this.truongPhong = truongPhong;
		this.diaChi = "";
		this.soDienThoaiPhong = "";
	}

	// ============== GETTERS & SETTERS ==============

	public String getMaPhong() {
		return maPhong;
	}

	public void setMaPhong(String maPhong) {
		this.maPhong = maPhong;
	}

	public String getTenPhong() {
		return tenPhong;
	}

	public void setTenPhong(String tenPhong) {
		this.tenPhong = tenPhong;
	}

	public String getTruongPhong() {
		return truongPhong;
	}

	public void setTruongPhong(String truongPhong) {
		this.truongPhong = truongPhong;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getSoDienThoaiPhong() {
		return soDienThoaiPhong;
	}

	public void setSoDienThoaiPhong(String soDienThoaiPhong) {
		this.soDienThoaiPhong = soDienThoaiPhong;
	}

	// ============== BUSINESS METHODS ==============

	/**
	 * Nhập thông tin phòng
	 */
	public void nhapThongTin(Scanner sc) {
		XuLyLoi.hienThiTieuDe("THÔNG TIN PHÒNG KIỂM KÊ");

		this.maPhong = XuLyLoi.nhapChuoi(sc, "➤ Mã phòng: ", 2);
		this.tenPhong = XuLyLoi.nhapChuoi(sc, "➤ Tên phòng: ", 5);
		this.truongPhong = XuLyLoi.nhapChuoi(sc, "➤ Trưởng phòng: ", 3);

		// Thông tin bổ sung (không bắt buộc)
		System.out.print("➤ Địa chỉ phòng (Enter để bỏ qua): ");
		this.diaChi = sc.nextLine().trim();

		System.out.print("➤ Số điện thoại phòng (Enter để bỏ qua): ");
		this.soDienThoaiPhong = sc.nextLine().trim();
	}

	/**
	 * Nhập thông tin đơn giản (cho mẫu đề bài)
	 */
	public void nhapThongTinDonGian(Scanner sc) {
		System.out.println("\n--- Thông tin phòng ---");
		this.tenPhong = XuLyLoi.nhapChuoiKhongTrong(sc, "Tên phòng: ");
		this.maPhong = XuLyLoi.nhapChuoiKhongTrong(sc, "Mã phòng: ");
		this.truongPhong = XuLyLoi.nhapChuoiKhongTrong(sc, "Trưởng phòng: ");
	}

	/**
	 * Hiển thị thông tin phòng
	 */
	public void hienThiThongTin() {
		System.out.println("\nTHÔNG TIN PHÒNG:");
		System.out.println("  Mã phòng: " + maPhong);
		System.out.println("  Tên phòng: " + tenPhong);
		System.out.println("  Trưởng phòng: " + truongPhong);

		if (!diaChi.isEmpty()) {
			System.out.println("  Địa chỉ: " + diaChi);
		}

		if (!soDienThoaiPhong.isEmpty()) {
			System.out.println("  Điện thoại: " + soDienThoaiPhong);
		}
	}

	/**
	 * Xuất thông tin ngắn gọn
	 */
	public String xuatThongTinNgan() {
		return tenPhong + " (" + maPhong + ")";
	}

	// ============== VALIDATION METHODS ==============

	/**
	 * Kiểm tra thông tin phòng có hợp lệ không
	 */
	public boolean isValid() {
		return !maPhong.trim().isEmpty() && !tenPhong.trim().isEmpty() && !truongPhong.trim().isEmpty();
	}

	// ============== OVERRIDE METHODS ==============

	@Override
	public String toString() {
		return String.format("Phòng: %s - %s - Trưởng phòng: %s", maPhong, tenPhong, truongPhong);
	}
}