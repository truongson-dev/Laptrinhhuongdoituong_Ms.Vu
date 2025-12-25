package KTM;

import java.util.Scanner;

/**
 * Lớp đại diện cho Tài sản Mỗi tài sản có: tên, số lượng, tình trạng
 */
public class TaiSan {
	// ============== CONSTANTS ==============
	public static final String TINH_TRANG_TOT = "Tốt";
	public static final String TINH_TRANG_HONG = "Hỏng";
	public static final String TINH_TRANG_HET_KHAU_HAO = "Hết khấu hao";

	// ============== ATTRIBUTES ==============
	private String tenTaiSan;
	private int soLuong;
	private String tinhTrang;

	// ============== CONSTRUCTORS ==============

	/**
	 * Constructor mặc định
	 */
	public TaiSan() {
		this.tenTaiSan = "";
		this.soLuong = 0;
		this.tinhTrang = TINH_TRANG_TOT;
	}

	/**
	 * Constructor đầy đủ tham số
	 */
	public TaiSan(String tenTaiSan, int soLuong, String tinhTrang) {
		this.tenTaiSan = tenTaiSan;
		this.soLuong = soLuong;
		this.tinhTrang = (tinhTrang != null) ? tinhTrang : TINH_TRANG_TOT;
	}

	/**
	 * Constructor sao chép
	 */
	public TaiSan(TaiSan other) {
		if (other != null) {
			this.tenTaiSan = other.tenTaiSan;
			this.soLuong = other.soLuong;
			this.tinhTrang = other.tinhTrang;
		}
	}

	// ============== GETTERS & SETTERS ==============

	public String getTenTaiSan() {
		return tenTaiSan;
	}

	public void setTenTaiSan(String tenTaiSan) {
		if (tenTaiSan != null && !tenTaiSan.trim().isEmpty()) {
			this.tenTaiSan = tenTaiSan.trim();
		}
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		if (soLuong >= 0) {
			this.soLuong = soLuong;
		} else {
			throw new IllegalArgumentException("Số lượng không được âm");
		}
	}

	public String getTinhTrang() {
		return tinhTrang;
	}

	public void setTinhTrang(String tinhTrang) {
		if (tinhTrang != null && !tinhTrang.trim().isEmpty()) {
			this.tinhTrang = tinhTrang.trim();
		}
	}

	// ============== BUSINESS METHODS ==============

	/**
	 * Nhập thông tin tài sản từ bàn phím
	 */
	public void nhapThongTin(Scanner sc) {
		XuLyLoi.hienThiTieuDe("NHẬP THÔNG TIN TÀI SẢN");

		// Nhập tên tài sản
		this.tenTaiSan = XuLyLoi.nhapChuoi(sc, "➤ Tên tài sản: ", 2);

		// Nhập số lượng
		this.soLuong = XuLyLoi.nhapSoKhongAm(sc, "➤ Số lượng: ");

		// Nhập tình trạng
		nhapTinhTrang(sc);
	}

	/**
	 * Nhập tình trạng với lựa chọn
	 */
	private void nhapTinhTrang(Scanner sc) {
		System.out.println("\n➤ Chọn tình trạng:");
		System.out.println("  1. Tốt");
		System.out.println("  2. Hỏng");
		System.out.println("  3. Hết khấu hao");
		System.out.println("  4. Khác (nhập tùy chỉnh)");

		int luaChon = XuLyLoi.nhapSoNguyen(sc, "Lựa chọn (1-4): ", 1, 4);

		switch (luaChon) {
		case 1:
			this.tinhTrang = TINH_TRANG_TOT;
			break;
		case 2:
			this.tinhTrang = TINH_TRANG_HONG;
			break;
		case 3:
			this.tinhTrang = TINH_TRANG_HET_KHAU_HAO;
			break;
		case 4:
			this.tinhTrang = XuLyLoi.nhapChuoiKhongTrong(sc, "➤ Nhập tình trạng: ");
			break;
		}
	}

	/**
	 * Hiển thị thông tin tài sản
	 */
	public void hienThiThongTin() {
		System.out.printf("  %-25s %-10d %-20s\n", XuLyLoi.catChuoi(tenTaiSan, 25), soLuong,
				XuLyLoi.catChuoi(tinhTrang, 20));
	}

	/**
	 * Xuất thông tin theo định dạng bảng
	 */
	public void xuatDinhDangBang() {
		System.out.printf("│ %-25s │ %-10d │ %-20s │\n", XuLyLoi.catChuoi(tenTaiSan, 25), soLuong,
				XuLyLoi.catChuoi(tinhTrang, 20));
	}

	/**
	 * Kiểm tra tài sản có đang trong tình trạng tốt không
	 */
	public boolean isTinhTrangTot() {
		return TINH_TRANG_TOT.equalsIgnoreCase(this.tinhTrang);
	}

	/**
	 * Kiểm tra tài sản có cần sửa chữa không
	 */
	public boolean canSuaChua() {
		return TINH_TRANG_HONG.equalsIgnoreCase(this.tinhTrang);
	}

	/**
	 * Kiểm tra tài sản có hết khấu hao không
	 */
	public boolean isHetKhauHao() {
		return TINH_TRANG_HET_KHAU_HAO.equalsIgnoreCase(this.tinhTrang);
	}

	// ============== OVERRIDE METHODS ==============

	@Override
	public String toString() {
		return String.format("Tài sản: %s | SL: %d | Tình trạng: %s", tenTaiSan, soLuong, tinhTrang);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}

		TaiSan taiSan = (TaiSan) obj;
		return soLuong == taiSan.soLuong && tenTaiSan.equalsIgnoreCase(taiSan.tenTaiSan)
				&& tinhTrang.equalsIgnoreCase(taiSan.tinhTrang);
	}

	@Override
	public int hashCode() {
		int result = tenTaiSan.hashCode();
		result = 31 * result + soLuong;
		result = 31 * result + tinhTrang.hashCode();
		return result;
	}
}