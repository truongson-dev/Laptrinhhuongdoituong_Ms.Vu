package KTM;

import java.util.Scanner;

/**
 * Lớp đại diện cho Nhân viên kiểm kê
 */
public class NhanVienKiemKe {
	// ============== ATTRIBUTES ==============
	private String maNhanVien;
	private String tenNhanVien;
	private String chucVu;
	private String email;
	private String soDienThoai;

	// ============== CONSTRUCTORS ==============

	public NhanVienKiemKe() {
		this.maNhanVien = "";
		this.tenNhanVien = "";
		this.chucVu = "";
		this.email = "";
		this.soDienThoai = "";
	}

	public NhanVienKiemKe(String maNhanVien, String tenNhanVien, String chucVu) {
		this.maNhanVien = maNhanVien;
		this.tenNhanVien = tenNhanVien;
		this.chucVu = chucVu;
		this.email = "";
		this.soDienThoai = "";
	}

	public NhanVienKiemKe(String maNhanVien, String tenNhanVien, String chucVu, String email, String soDienThoai) {
		this.maNhanVien = maNhanVien;
		this.tenNhanVien = tenNhanVien;
		this.chucVu = chucVu;
		this.email = email;
		this.soDienThoai = soDienThoai;
	}

	// ============== GETTERS & SETTERS ==============

	public String getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}

	public String getTenNhanVien() {
		return tenNhanVien;
	}

	public void setTenNhanVien(String tenNhanVien) {
		this.tenNhanVien = tenNhanVien;
	}

	public String getChucVu() {
		return chucVu;
	}

	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		if (email == null || XuLyLoi.kiemTraEmail(email)) {
			this.email = email;
		} else {
			System.out.println(XuLyLoi.ThongBao.EMAIL);
		}
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		if (soDienThoai == null || XuLyLoi.kiemTraSDT(soDienThoai)) {
			this.soDienThoai = soDienThoai;
		} else {
			System.out.println(XuLyLoi.ThongBao.SDT);
		}
	}

	// ============== BUSINESS METHODS ==============

	/**
	 * Nhập thông tin nhân viên
	 */
	public void nhapThongTin(Scanner sc) {
		XuLyLoi.hienThiTieuDe("THÔNG TIN NHÂN VIÊN KIỂM KÊ");

		this.maNhanVien = XuLyLoi.nhapChuoi(sc, "➤ Mã nhân viên: ", 3);
		this.tenNhanVien = XuLyLoi.nhapChuoi(sc, "➤ Họ tên nhân viên: ", 5);
		this.chucVu = XuLyLoi.nhapChuoi(sc, "➤ Chức vụ: ", 3);

		// Nhập email (không bắt buộc)
		System.out.print("➤ Email (Enter để bỏ qua): ");
		String emailInput = sc.nextLine().trim();
		if (!emailInput.isEmpty()) {
			setEmail(emailInput);
		}

		// Nhập số điện thoại (không bắt buộc)
		System.out.print("➤ Số điện thoại (Enter để bỏ qua): ");
		String sdtInput = sc.nextLine().trim();
		if (!sdtInput.isEmpty()) {
			setSoDienThoai(sdtInput);
		}
	}

	/**
	 * Nhập thông tin đơn giản (cho mẫu đề bài)
	 */
	public void nhapThongTinDonGian(Scanner sc) {
		System.out.println("\n--- Thông tin nhân viên ---");
		this.tenNhanVien = XuLyLoi.nhapChuoiKhongTrong(sc, "Tên nhân viên: ");
		this.chucVu = XuLyLoi.nhapChuoiKhongTrong(sc, "Chức vụ: ");
	}

	/**
	 * Hiển thị thông tin nhân viên
	 */
	public void hienThiThongTin() {
		System.out.println("\nTHÔNG TIN NHÂN VIÊN:");
		System.out.println("  Mã NV: " + (maNhanVien.isEmpty() ? "Chưa có" : maNhanVien));
		System.out.println("  Họ tên: " + tenNhanVien);
		System.out.println("  Chức vụ: " + chucVu);

		if (!email.isEmpty()) {
			System.out.println("  Email: " + email);
		}

		if (!soDienThoai.isEmpty()) {
			System.out.println("  Điện thoại: " + soDienThoai);
		}
	}

	/**
	 * Xuất thông tin ngắn gọn
	 */
	public String xuatThongTinNgan() {
		return tenNhanVien + " - " + chucVu;
	}

	// ============== VALIDATION METHODS ==============

	/**
	 * Kiểm tra thông tin nhân viên có hợp lệ không
	 */
	public boolean isValid() {
		return !tenNhanVien.trim().isEmpty() && !chucVu.trim().isEmpty();
	}

	// ============== OVERRIDE METHODS ==============

	@Override
	public String toString() {
		return String.format("NV: %s - %s - %s", maNhanVien, tenNhanVien, chucVu);
	}
}