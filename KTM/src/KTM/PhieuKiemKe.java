package KTM;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Lớp đại diện cho Phiếu kiểm kê tài sản
 */
public class PhieuKiemKe {
	// ============== ATTRIBUTES ==============
	private String maPhieu;
	private String ngayKiemKe;
	private NhanVienKiemKe nhanVien;
	private PhongKiemKe phong;
	private ArrayList<TaiSan> danhSachTaiSan;
	private String ghiChu;

	// ============== CONSTRUCTORS ==============

	public PhieuKiemKe() {
		this.maPhieu = "";
		this.ngayKiemKe = "";
		this.nhanVien = new NhanVienKiemKe();
		this.phong = new PhongKiemKe();
		this.danhSachTaiSan = new ArrayList<>();
		this.ghiChu = "";
	}

	public PhieuKiemKe(String maPhieu, String ngayKiemKe, NhanVienKiemKe nhanVien, PhongKiemKe phong) {
		this.maPhieu = maPhieu;
		this.ngayKiemKe = ngayKiemKe;
		this.nhanVien = nhanVien;
		this.phong = phong;
		this.danhSachTaiSan = new ArrayList<>();
		this.ghiChu = "";
	}

	// ============== GETTERS & SETTERS ==============

	public String getMaPhieu() {
		return maPhieu;
	}

	public void setMaPhieu(String maPhieu) {
		this.maPhieu = maPhieu;
	}

	public String getNgayKiemKe() {
		return ngayKiemKe;
	}

	public void setNgayKiemKe(String ngayKiemKe) {
		this.ngayKiemKe = ngayKiemKe;
	}

	public NhanVienKiemKe getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(NhanVienKiemKe nhanVien) {
		this.nhanVien = nhanVien;
	}

	public PhongKiemKe getPhong() {
		return phong;
	}

	public void setPhong(PhongKiemKe phong) {
		this.phong = phong;
	}

	public ArrayList<TaiSan> getDanhSachTaiSan() {
		return new ArrayList<>(danhSachTaiSan); // Trả về bản sao để bảo vệ dữ liệu
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	// ============== BUSINESS METHODS - QUẢN LÝ TÀI SẢN ==============

	/**
	 * Thêm tài sản vào phiếu
	 */
	public boolean themTaiSan(TaiSan taiSan) {
		if (taiSan != null && taiSan.getSoLuong() > 0) {
			danhSachTaiSan.add(new TaiSan(taiSan)); // Thêm bản sao
			return true;
		}
		return false;
	}

	/**
	 * Xóa tài sản theo chỉ số
	 */
	public boolean xoaTaiSan(int index) {
		if (index >= 0 && index < danhSachTaiSan.size()) {
			danhSachTaiSan.remove(index);
			return true;
		}
		return false;
	}

	/**
	 * Sửa thông tin tài sản
	 */
	public boolean suaTaiSan(int index, TaiSan taiSanMoi) {
		if (index >= 0 && index < danhSachTaiSan.size() && taiSanMoi != null) {
			danhSachTaiSan.set(index, new TaiSan(taiSanMoi));
			return true;
		}
		return false;
	}

	/**
	 * Tìm tài sản theo tên (tìm kiếm không phân biệt hoa thường)
	 */
	public ArrayList<TaiSan> timTaiSanTheoTen(String ten) {
		ArrayList<TaiSan> ketQua = new ArrayList<>();
		String tenTimKiem = ten.toLowerCase();

		for (TaiSan ts : danhSachTaiSan) {
			if (ts.getTenTaiSan().toLowerCase().contains(tenTimKiem)) {
				ketQua.add(new TaiSan(ts));
			}
		}

		return ketQua;
	}

	// ============== CALCULATION METHODS ==============

	/**
	 * Tính tổng số lượng tất cả tài sản
	 */
	public int tongSoLuongTaiSan() {
		int tong = 0;
		for (TaiSan ts : danhSachTaiSan) {
			tong += ts.getSoLuong();
		}
		return tong;
	}

	/**
	 * Tính tổng số lượng tài sản theo tình trạng
	 */
	public int tongSoLuongTheoTinhTrang(String tinhTrang) {
		int tong = 0;
		for (TaiSan ts : danhSachTaiSan) {
			if (ts.getTinhTrang().equalsIgnoreCase(tinhTrang)) {
				tong += ts.getSoLuong();
			}
		}
		return tong;
	}

	/**
	 * Đếm số loại tài sản
	 */
	public int demSoLoaiTaiSan() {
		return danhSachTaiSan.size();
	}

	/**
	 * Tính tỷ lệ tài sản tốt
	 */
	public double tyLeTaiSanTot() {
		if (danhSachTaiSan.isEmpty()) {
			return 0;
		}

		int soTaiSanTot = 0;
		for (TaiSan ts : danhSachTaiSan) {
			if (ts.isTinhTrangTot()) {
				soTaiSanTot += ts.getSoLuong();
			}
		}

		return (double) soTaiSanTot / tongSoLuongTaiSan() * 100;
	}

	// ============== INPUT/OUTPUT METHODS ==============

	/**
	 * Nhập thông tin phiếu kiểm kê đầy đủ
	 */
	public void nhapThongTinDayDu(Scanner sc) {
		XuLyLoi.hienThiTieuDe("NHẬP THÔNG TIN PHIẾU KIỂM KÊ");

		// Nhập thông tin cơ bản
		this.maPhieu = XuLyLoi.nhapChuoi(sc, "➤ Mã phiếu: ", 3);
		this.ngayKiemKe = XuLyLoi.nhapNgay(sc, "➤ Ngày kiểm kê (dd/mm/yyyy): ");

		// Nhập thông tin nhân viên
		XuLyLoi.hienThiPhanCach();
		this.nhanVien = new NhanVienKiemKe();
		this.nhanVien.nhapThongTin(sc);

		// Nhập thông tin phòng
		XuLyLoi.hienThiPhanCach();
		this.phong = new PhongKiemKe();
		this.phong.nhapThongTin(sc);

		// Nhập danh sách tài sản
		XuLyLoi.hienThiPhanCach();
		nhapDanhSachTaiSan(sc);

		// Nhập ghi chú (không bắt buộc)
		System.out.print("➤ Ghi chú (Enter để bỏ qua): ");
		this.ghiChu = sc.nextLine().trim();

		System.out.println("\n" + XuLyLoi.ThongBao.THANH_CONG);
	}

	/**
	 * Nhập thông tin phiếu theo mẫu đề bài
	 */
	public void nhapThongTinTheoMau(Scanner sc) {
		System.out.println("\n=== NHẬP PHIẾU KIỂM KÊ ===");

		this.maPhieu = XuLyLoi.nhapChuoiKhongTrong(sc, "Mã phiếu: ");
		this.ngayKiemKe = XuLyLoi.nhapNgay(sc, "Ngày kiểm kê: ");

		this.nhanVien = new NhanVienKiemKe();
		this.nhanVien.nhapThongTinDonGian(sc);

		this.phong = new PhongKiemKe();
		this.phong.nhapThongTinDonGian(sc);

		nhapDanhSachTaiSan(sc);
	}

	/**
	 * Nhập danh sách tài sản
	 */
	private void nhapDanhSachTaiSan(Scanner sc) {
		System.out.println("\n--- NHẬP DANH SÁCH TÀI SẢN ---");
		danhSachTaiSan.clear();

		int stt = 1;
		String tiepTuc;

		do {
			System.out.println("\n▸ Tài sản thứ " + stt + ":");
			TaiSan ts = new TaiSan();
			ts.nhapThongTin(sc);
			danhSachTaiSan.add(ts);
			stt++;

			System.out.print("\nTiếp tục thêm tài sản? (c/k): ");
			tiepTuc = sc.nextLine().trim();

		} while (tiepTuc.equalsIgnoreCase("c"));

		System.out.println("Đã thêm " + (stt - 1) + " tài sản vào phiếu.");
	}

	/**
	 * Xuất phiếu theo mẫu đề bài
	 */
	public void xuatPhieuTheoMau() {
		System.out.println("\n" + "=".repeat(70));
		System.out.println("                    PHIẾU KIỂM KÊ TÀI SẢN");
		System.out.println("=".repeat(70));

		System.out.println("Mã phiếu: " + maPhieu + "\t\tNgày kiểm kê: " + ngayKiemKe);
		System.out.println("Nhân viên kiểm kê: " + nhanVien.xuatThongTinNgan());
		System.out.println("Kiểm kê tại phòng: " + phong.xuatThongTinNgan());
		System.out.println("Trưởng phòng: " + phong.getTruongPhong());

		System.out.println("\n" + "-".repeat(70));
		System.out.printf("%-30s %-15s %-20s\n", "TÊN TÀI SẢN", "SỐ LƯỢNG", "TÌNH TRẠNG");
		System.out.println("-".repeat(70));

		for (TaiSan ts : danhSachTaiSan) {
			ts.hienThiThongTin();
		}

		System.out.println("-".repeat(70));
		System.out.println("Số tài sản đã kiểm kê: " + demSoLoaiTaiSan());
		System.out.println("Tổng số lượng: " + tongSoLuongTaiSan());

		if (!ghiChu.isEmpty()) {
			System.out.println("\nGhi chú: " + ghiChu);
		}

		System.out.println("=".repeat(70));
	}

	/**
	 * Xuất phiếu chi tiết với thống kê
	 */
	public void xuatPhieuChiTiet() {
		xuatPhieuTheoMau();

		// Thêm phần thống kê
		System.out.println("\n" + "─".repeat(50));
		System.out.println("THỐNG KÊ CHI TIẾT:");
		System.out.println("─".repeat(50));

		System.out.println("• Tổng số loại tài sản: " + demSoLoaiTaiSan());
		System.out.println("• Tổng số lượng: " + tongSoLuongTaiSan());
		System.out.printf("• Tài sản tốt: %d (%.1f%%)\n", tongSoLuongTheoTinhTrang("Tốt"), tyLeTaiSanTot());
		System.out.println("• Tài sản hỏng: " + tongSoLuongTheoTinhTrang("Hỏng"));
		System.out.println("• Hết khấu hao: " + tongSoLuongTheoTinhTrang("Hết khấu hao"));

		if (tyLeTaiSanTot() < 70) {
			System.out.println("\n⚠ CẢNH BÁO: Tỷ lệ tài sản tốt dưới 70%!");
		}
	}

	/**
	 * Xuất thông tin ngắn gọn (cho danh sách)
	 */
	public void xuatThongTinNgan() {
		System.out.printf("│ %-10s │ %-12s │ %-20s │ %-15s │ %-6d │ %-8d │\n", maPhieu, ngayKiemKe,
				XuLyLoi.catChuoi(nhanVien.getTenNhanVien(), 20), XuLyLoi.catChuoi(phong.getTenPhong(), 15),
				demSoLoaiTaiSan(), tongSoLuongTaiSan());
	}

	// ============== VALIDATION METHODS ==============

	/**
	 * Kiểm tra phiếu có hợp lệ không
	 */
	public boolean isValid() {
		return !maPhieu.trim().isEmpty() && XuLyLoi.kiemTraNgay(ngayKiemKe) && nhanVien.isValid() && phong.isValid()
				&& !danhSachTaiSan.isEmpty();
	}

	// ============== SEARCH METHODS ==============

	/**
	 * Tìm kiếm tài sản trong phiếu
	 */
	public void timKiemTaiSan(Scanner sc) {
		XuLyLoi.hienThiTieuDe("TÌM KIẾM TÀI SẢN TRONG PHIẾU " + maPhieu);

		System.out.print("➤ Nhập tên tài sản cần tìm: ");
		String tenTim = sc.nextLine().trim();

		if (tenTim.isEmpty()) {
			System.out.println(XuLyLoi.ThongBao.TRONG);
			return;
		}

		ArrayList<TaiSan> ketQua = timTaiSanTheoTen(tenTim);

		if (ketQua.isEmpty()) {
			System.out.println(XuLyLoi.ThongBao.KHONG_TIM_THAY);
		} else {
			System.out.println("\nTìm thấy " + ketQua.size() + " tài sản:");
			System.out.println("-".repeat(60));
			System.out.printf("%-5s %-25s %-10s %-20s\n", "STT", "Tên tài sản", "Số lượng", "Tình trạng");
			System.out.println("-".repeat(60));

			for (int i = 0; i < ketQua.size(); i++) {
				TaiSan ts = ketQua.get(i);
				System.out.printf("%-5d %-25s %-10d %-20s\n", i + 1, XuLyLoi.catChuoi(ts.getTenTaiSan(), 25),
						ts.getSoLuong(), ts.getTinhTrang());
			}
		}
	}

	// ============== OVERRIDE METHODS ==============

	@Override
	public String toString() {
		return String.format("Phiếu %s - Ngày %s - NV: %s - Phòng: %s - %d tài sản", maPhieu, ngayKiemKe,
				nhanVien.getTenNhanVien(), phong.getTenPhong(), danhSachTaiSan.size());
	}
}