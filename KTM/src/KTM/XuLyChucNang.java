package KTM;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Lớp xử lý các chức năng chính của chương trình
 */
public class XuLyChucNang {
	// ============== ATTRIBUTES ==============
	private ArrayList<PhieuKiemKe> danhSachPhieu;
	private Scanner scanner;
	private static final int SO_CHUC_NANG = 8;

	// ============== CONSTRUCTORS ==============

	public XuLyChucNang() {
		this.danhSachPhieu = new ArrayList<>();
		this.scanner = new Scanner(System.in);
	}

	// ============== CORE FUNCTIONALITIES ==============

	/**
	 * A. Thêm danh sách các đối tượng từ bàn phím
	 */
	public void themPhieuKiemKe() {
		XuLyLoi.hienThiTieuDe("THÊM PHIẾU KIỂM KÊ MỚI");

		try {
			PhieuKiemKe phieuMoi = new PhieuKiemKe();

			// Chọn phương thức nhập
			System.out.println("Chọn phương thức nhập:");
			System.out.println("1. Nhập đầy đủ thông tin");
			System.out.println("2. Nhập theo mẫu đề bài");

			int luaChon = XuLyLoi.nhapSoNguyen(scanner, "Lựa chọn (1-2): ", 1, 2);

			if (luaChon == 1) {
				phieuMoi.nhapThongTinDayDu(scanner);
			} else {
				phieuMoi.nhapThongTinTheoMau(scanner);
			}

			// Kiểm tra trùng mã phiếu
			if (timPhieuTheoMa(phieuMoi.getMaPhieu()) != null) {
				System.out.println("\n⚠ Cảnh báo: Mã phiếu '" + phieuMoi.getMaPhieu() + "' đã tồn tại!");

				boolean tiepTuc = XuLyLoi.xacNhan(scanner, "Bạn có muốn tiếp tục thêm?");
				if (!tiepTuc) {
					System.out.println("Đã hủy thêm phiếu.");
					return;
				}
			}

			// Kiểm tra tính hợp lệ
			if (!phieuMoi.isValid()) {
				System.out.println("✗ Phiếu không hợp lệ! Vui lòng kiểm tra lại thông tin.");
				return;
			}

			// Thêm vào danh sách
			danhSachPhieu.add(phieuMoi);
			System.out.println("\n" + XuLyLoi.ThongBao.THANH_CONG);
			System.out.println("Đã thêm phiếu mã: " + phieuMoi.getMaPhieu());

		} catch (Exception e) {
			System.out.println("✗ Lỗi khi thêm phiếu: " + e.getMessage());
		}
	}

	/**
	 * B. Tìm và xuất báo cáo thông tin theo mẫu phiếu
	 */
	public void xuatBaoCao() {
		XuLyLoi.hienThiTieuDe("XUẤT BÁO CÁO PHIẾU KIỂM KÊ");

		if (XuLyLoi.kiemTraDanhSachTrong(danhSachPhieu)) {
			System.out.println(XuLyLoi.ThongBao.DANH_SACH_TRONG);
			return;
		}

		System.out.println("Chọn chế độ xuất báo cáo:");
		System.out.println("1. Xuất phiếu theo mã");
		System.out.println("2. Xuất tất cả phiếu");
		System.out.println("3. Xuất phiếu chi tiết (có thống kê)");

		int luaChon = XuLyLoi.nhapSoNguyen(scanner, "Lựa chọn (1-3): ", 1, 3);

		switch (luaChon) {
		case 1:
			xuatPhieuTheoMa();
			break;
		case 2:
			xuatTatCaPhieu();
			break;
		case 3:
			xuatPhieuChiTiet();
			break;
		}
	}

	/**
	 * Xuất phiếu theo mã
	 */
	private void xuatPhieuTheoMa() {
		System.out.print("➤ Nhập mã phiếu cần xuất: ");
		String maPhieu = scanner.nextLine().trim();

		PhieuKiemKe phieu = timPhieuTheoMa(maPhieu);

		if (phieu != null) {
			phieu.xuatPhieuTheoMau();
		} else {
			System.out.println(XuLyLoi.ThongBao.KHONG_TIM_THAY);
			goiYMaTuongTu(maPhieu);
		}
	}

	/**
	 * Xuất tất cả phiếu
	 */
	private void xuatTatCaPhieu() {
		System.out.println("\nDANH SÁCH TẤT CẢ PHIẾU KIỂM KÊ");
		System.out.println("=".repeat(110));
		System.out.printf("│ %-10s │ %-12s │ %-20s │ %-15s │ %-8s │ %-10s │\n", "Mã phiếu", "Ngày KK", "Nhân viên",
				"Phòng", "Số loại", "Tổng SL");
		System.out.println("=".repeat(110));

		for (PhieuKiemKe phieu : danhSachPhieu) {
			phieu.xuatThongTinNgan();
		}

		System.out.println("=".repeat(110));

		// Thống kê tổng
		int tongPhieu = danhSachPhieu.size();
		int tongLoaiTaiSan = 0;
		int tongSoLuong = 0;

		for (PhieuKiemKe phieu : danhSachPhieu) {
			tongLoaiTaiSan += phieu.getDanhSachTaiSan().size();
			tongSoLuong += phieu.tongSoLuongTaiSan();
		}

		System.out.printf("\nTỔNG HỢP: %d phiếu | %d loại tài sản | %d tổng số lượng\n", tongPhieu, tongLoaiTaiSan,
				tongSoLuong);
	}

	/**
	 * Xuất phiếu chi tiết
	 */
	private void xuatPhieuChiTiet() {
		System.out.print("➤ Nhập mã phiếu cần xem chi tiết: ");
		String maPhieu = scanner.nextLine().trim();

		PhieuKiemKe phieu = timPhieuTheoMa(maPhieu);

		if (phieu != null) {
			phieu.xuatPhieuChiTiet();
		} else {
			System.out.println(XuLyLoi.ThongBao.KHONG_TIM_THAY);
		}
	}

	/**
	 * C. Tìm kiếm phiếu
	 */
	public void timKiemPhieu() {
		XuLyLoi.hienThiTieuDe("TÌM KIẾM PHIẾU KIỂM KÊ");

		if (XuLyLoi.kiemTraDanhSachTrong(danhSachPhieu)) {
			System.out.println(XuLyLoi.ThongBao.DANH_SACH_TRONG);
			return;
		}

		System.out.println("Chọn tiêu chí tìm kiếm:");
		System.out.println("1. Theo mã phiếu");
		System.out.println("2. Theo tên nhân viên");
		System.out.println("3. Theo tên phòng");
		System.out.println("4. Theo ngày kiểm kê");
		System.out.println("5. Theo tên tài sản");

		int luaChon = XuLyLoi.nhapSoNguyen(scanner, "Lựa chọn (1-5): ", 1, 5);

		switch (luaChon) {
		case 1:
			timTheoMaPhieu();
			break;
		case 2:
			timTheoTenNhanVien();
			break;
		case 3:
			timTheoTenPhong();
			break;
		case 4:
			timTheoNgay();
			break;
		case 5:
			timTheoTenTaiSan();
			break;
		}
	}

	/**
	 * Tìm theo mã phiếu
	 */
	private void timTheoMaPhieu() {
		System.out.print("➤ Nhập mã phiếu: ");
		String maPhieu = scanner.nextLine().trim();

		PhieuKiemKe phieu = timPhieuTheoMa(maPhieu);

		if (phieu != null) {
			System.out.println("\n✓ Tìm thấy phiếu:");
			phieu.xuatPhieuTheoMau();
		} else {
			System.out.println(XuLyLoi.ThongBao.KHONG_TIM_THAY);
			goiYMaTuongTu(maPhieu);
		}
	}

	/**
	 * Tìm theo tên nhân viên
	 */
	private void timTheoTenNhanVien() {
		System.out.print("➤ Nhập tên nhân viên: ");
		String tenNV = scanner.nextLine().trim().toLowerCase();

		ArrayList<PhieuKiemKe> ketQua = new ArrayList<>();

		for (PhieuKiemKe phieu : danhSachPhieu) {
			if (phieu.getNhanVien().getTenNhanVien().toLowerCase().contains(tenNV)) {
				ketQua.add(phieu);
			}
		}

		hienThiKetQuaTimKiem(ketQua, "nhân viên '" + tenNV + "'");
	}

	/**
	 * Tìm theo tên phòng
	 */
	private void timTheoTenPhong() {
		System.out.print("➤ Nhập tên phòng: ");
		String tenPhong = scanner.nextLine().trim().toLowerCase();

		ArrayList<PhieuKiemKe> ketQua = new ArrayList<>();

		for (PhieuKiemKe phieu : danhSachPhieu) {
			if (phieu.getPhong().getTenPhong().toLowerCase().contains(tenPhong)) {
				ketQua.add(phieu);
			}
		}

		hienThiKetQuaTimKiem(ketQua, "phòng '" + tenPhong + "'");
	}

	/**
	 * Tìm theo ngày
	 */
	private void timTheoNgay() {
		System.out.print("➤ Nhập ngày (dd/mm/yyyy): ");
		String ngay = scanner.nextLine().trim();

		if (!XuLyLoi.kiemTraNgay(ngay)) {
			System.out.println(XuLyLoi.ThongBao.NGAY);
			return;
		}

		ArrayList<PhieuKiemKe> ketQua = new ArrayList<>();

		for (PhieuKiemKe phieu : danhSachPhieu) {
			if (phieu.getNgayKiemKe().equals(ngay)) {
				ketQua.add(phieu);
			}
		}

		hienThiKetQuaTimKiem(ketQua, "ngày '" + ngay + "'");
	}

	/**
	 * Tìm theo tên tài sản
	 */
	private void timTheoTenTaiSan() {
		System.out.print("➤ Nhập tên tài sản: ");
		String tenTS = scanner.nextLine().trim().toLowerCase();

		ArrayList<PhieuKiemKe> ketQua = new ArrayList<>();

		for (PhieuKiemKe phieu : danhSachPhieu) {
			for (TaiSan ts : phieu.getDanhSachTaiSan()) {
				if (ts.getTenTaiSan().toLowerCase().contains(tenTS)) {
					if (!ketQua.contains(phieu)) {
						ketQua.add(phieu);
					}
					break;
				}
			}
		}

		hienThiKetQuaTimKiem(ketQua, "tài sản '" + tenTS + "'");
	}

	/**
	 * Hiển thị kết quả tìm kiếm
	 */
	private void hienThiKetQuaTimKiem(ArrayList<PhieuKiemKe> ketQua, String tieuChi) {
		if (ketQua.isEmpty()) {
			System.out.println("\n✗ Không tìm thấy phiếu nào với " + tieuChi);
			return;
		}

		System.out.println("\n✓ Tìm thấy " + ketQua.size() + " phiếu với " + tieuChi + ":");
		System.out.println("=".repeat(110));
		System.out.printf("│ %-10s │ %-12s │ %-20s │ %-15s │ %-8s │ %-10s │\n", "Mã phiếu", "Ngày KK", "Nhân viên",
				"Phòng", "Số loại", "Tổng SL");
		System.out.println("=".repeat(110));

		for (PhieuKiemKe phieu : ketQua) {
			phieu.xuatThongTinNgan();
		}

		System.out.println("=".repeat(110));

		// Hỏi xem có muốn xem chi tiết không
		if (ketQua.size() == 1) {
			boolean xemChiTiet = XuLyLoi.xacNhan(scanner, "\nBạn có muốn xem chi tiết phiếu này?");
			if (xemChiTiet) {
				ketQua.get(0).xuatPhieuChiTiet();
			}
		}
	}

	/**
	 * Gợi ý mã tương tự
	 */
	private void goiYMaTuongTu(String maNhap) {
		if (maNhap.length() < 2) {
			return;
		}

		ArrayList<String> goiY = new ArrayList<>();
		for (PhieuKiemKe phieu : danhSachPhieu) {
			if (phieu.getMaPhieu().toLowerCase().contains(maNhap.toLowerCase())) {
				goiY.add(phieu.getMaPhieu());
			}
		}

		if (!goiY.isEmpty()) {
			System.out.println("Gợi ý các mã tương tự: " + String.join(", ", goiY));
		}
	}

	// ============== STATISTICS FUNCTIONS ==============

	/**
	 * Thống kê tổng quan
	 */
	public void thongKeTongQuan() {
		XuLyLoi.hienThiTieuDe("THỐNG KÊ TỔNG QUAN");

		if (XuLyLoi.kiemTraDanhSachTrong(danhSachPhieu)) {
			System.out.println(XuLyLoi.ThongBao.DANH_SACH_TRONG);
			return;
		}

		// Tính toán các chỉ số
		int tongPhieu = danhSachPhieu.size();
		int tongLoaiTaiSan = 0;
		int tongSoLuong = 0;
		int taiSanTot = 0;
		int taiSanHong = 0;
		int taiSanHetKhauHao = 0;

		for (PhieuKiemKe phieu : danhSachPhieu) {
			tongLoaiTaiSan += phieu.getDanhSachTaiSan().size();
			tongSoLuong += phieu.tongSoLuongTaiSan();
			taiSanTot += phieu.tongSoLuongTheoTinhTrang("Tốt");
			taiSanHong += phieu.tongSoLuongTheoTinhTrang("Hỏng");
			taiSanHetKhauHao += phieu.tongSoLuongTheoTinhTrang("Hết khấu hao");
		}

		// Hiển thị thống kê
		System.out.println(" THỐNG KÊ TỔNG QUAN HỆ THỐNG");
		System.out.println("─".repeat(50));

		System.out.printf("• Số lượng phiếu kiểm kê: %d\n", tongPhieu);
		System.out.printf("• Tổng số loại tài sản: %d\n", tongLoaiTaiSan);
		System.out.printf("• Tổng số lượng tài sản: %d\n", tongSoLuong);
		System.out.printf("• Tài sản tốt: %d (%.1f%%)\n", taiSanTot, (double) taiSanTot / tongSoLuong * 100);
		System.out.printf("• Tài sản hỏng: %d (%.1f%%)\n", taiSanHong, (double) taiSanHong / tongSoLuong * 100);
		System.out.printf("• Hết khấu hao: %d (%.1f%%)\n", taiSanHetKhauHao,
				(double) taiSanHetKhauHao / tongSoLuong * 100);

		System.out.println("\n📈 PHÂN TÍCH CHẤT LƯỢNG TÀI SẢN");
		System.out.println("─".repeat(50));

		double tyLeTot = (double) taiSanTot / tongSoLuong * 100;
		if (tyLeTot >= 80) {
			System.out.println("✓ TỐT: Tỷ lệ tài sản tốt cao (" + String.format("%.1f", tyLeTot) + "%)");
		} else if (tyLeTot >= 60) {
			System.out.println("⚠ TRUNG BÌNH: Cần kiểm tra bảo trì (" + String.format("%.1f", tyLeTot) + "%)");
		} else {
			System.out.println("✗ KÉM: Cần đầu tư thay thế (" + String.format("%.1f", tyLeTot) + "%)");
		}

		// Thống kê theo phòng
		thongKeTheoPhong();
	}

	/**
	 * Thống kê theo phòng
	 */
	private void thongKeTheoPhong() {
		System.out.println("\n THỐNG KÊ THEO PHÒNG");
		System.out.println("─".repeat(60));
		System.out.printf("%-20s │ %-10s │ %-10s │ %-10s │\n", "Phòng", "Số phiếu", "Số TS", "Tỷ lệ tốt");
		System.out.println("─".repeat(60));

		// Nhóm theo phòng
		java.util.Map<String, int[]> thongKePhong = new java.util.HashMap<>();

		for (PhieuKiemKe phieu : danhSachPhieu) {
			String tenPhong = phieu.getPhong().getTenPhong();
			thongKePhong.putIfAbsent(tenPhong, new int[] { 0, 0, 0 });

			int[] data = thongKePhong.get(tenPhong);
			data[0]++; // Số phiếu
			data[1] += phieu.tongSoLuongTaiSan(); // Tổng số lượng
			data[2] += phieu.tongSoLuongTheoTinhTrang("Tốt"); // Tài sản tốt
		}

		// Hiển thị kết quả
		for (java.util.Map.Entry<String, int[]> entry : thongKePhong.entrySet()) {
			String phong = entry.getKey();
			int[] data = entry.getValue();
			double tyLeTot = data[1] > 0 ? (double) data[2] / data[1] * 100 : 0;

			System.out.printf("%-20s │ %-10d │ %-10d │ %-9.1f%% │\n", XuLyLoi.catChuoi(phong, 20), data[0], data[1],
					tyLeTot);
		}
		System.out.println("─".repeat(60));
	}

	/**
	 * Sắp xếp danh sách phiếu
	 */
	public void sapXepPhieu() {
		XuLyLoi.hienThiTieuDe("SẮP XẾP DANH SÁCH PHIẾU");

		if (XuLyLoi.kiemTraDanhSachTrong(danhSachPhieu)) {
			System.out.println(XuLyLoi.ThongBao.DANH_SACH_TRONG);
			return;
		}

		System.out.println("Chọn tiêu chí sắp xếp:");
		System.out.println("1. Theo mã phiếu (A-Z)");
		System.out.println("2. Theo ngày kiểm kê (mới nhất)");
		System.out.println("3. Theo số lượng tài sản (nhiều nhất)");
		System.out.println("4. Theo tỷ lệ tài sản tốt (cao nhất)");

		int luaChon = XuLyLoi.nhapSoNguyen(scanner, "Lựa chọn (1-4): ", 1, 4);

		ArrayList<PhieuKiemKe> danhSachSapXep = new ArrayList<>(danhSachPhieu);

		switch (luaChon) {
		case 1:
			danhSachSapXep.sort(Comparator.comparing(PhieuKiemKe::getMaPhieu));
			System.out.println("✓ Đã sắp xếp theo mã phiếu (A-Z)");
			break;
		case 2:
			danhSachSapXep.sort((p1, p2) -> {
				// Sắp xếp theo ngày (mới nhất trước)
				return p2.getNgayKiemKe().compareTo(p1.getNgayKiemKe());
			});
			System.out.println("✓ Đã sắp xếp theo ngày kiểm kê (mới nhất)");
			break;
		case 3:
			danhSachSapXep.sort((p1, p2) -> Integer.compare(p2.tongSoLuongTaiSan(), p1.tongSoLuongTaiSan()));
			System.out.println("✓ Đã sắp xếp theo số lượng tài sản (nhiều nhất)");
			break;
		case 4:
			danhSachSapXep.sort((p1, p2) -> Double.compare(p2.tyLeTaiSanTot(), p1.tyLeTaiSanTot()));
			System.out.println("✓ Đã sắp xếp theo tỷ lệ tài sản tốt (cao nhất)");
			break;
		}

		// Hiển thị kết quả
		System.out.println("\nDANH SÁCH SAU KHI SẮP XẾP:");
		System.out.println("=".repeat(110));
		System.out.printf("│ %-10s │ %-12s │ %-20s │ %-15s │ %-8s │ %-10s │ %-8s │\n", "Mã phiếu", "Ngày KK",
				"Nhân viên", "Phòng", "Số loại", "Tổng SL", "Tỷ lệ tốt");
		System.out.println("=".repeat(110));

		for (PhieuKiemKe phieu : danhSachSapXep) {
			System.out.printf("│ %-10s │ %-12s │ %-20s │ %-15s │ %-8d │ %-10d │ %-7.1f%% │\n", phieu.getMaPhieu(),
					phieu.getNgayKiemKe(), XuLyLoi.catChuoi(phieu.getNhanVien().getTenNhanVien(), 20),
					XuLyLoi.catChuoi(phieu.getPhong().getTenPhong(), 15), phieu.getDanhSachTaiSan().size(),
					phieu.tongSoLuongTaiSan(), phieu.tyLeTaiSanTot());
		}
		System.out.println("=".repeat(110));
	}

	/**
	 * Xem dữ liệu mẫu từ đề bài
	 */
	public void xemDuLieuMau() {
		XuLyLoi.hienThiTieuDe("DỮ LIỆU MẪU TỪ ĐỀ BÀI");

		PhieuKiemKe phieuMau = timPhieuTheoMa("PH01");

		if (phieuMau != null) {
			System.out.println("Đây là dữ liệu mẫu từ đề bài (Phiếu PH01):\n");
			phieuMau.xuatPhieuTheoMau();
		} else {
			System.out.println("Không tìm thấy dữ liệu mẫu!");
		}
	}

	/**
	 * Tìm kiếm tài sản trong tất cả phiếu
	 */
	public void timKiemTaiSanToanHeThong() {
		XuLyLoi.hienThiTieuDe("TÌM KIẾM TÀI SẢN TOÀN HỆ THỐNG");

		System.out.print("➤ Nhập tên tài sản cần tìm: ");
		String tenTS = scanner.nextLine().trim().toLowerCase();

		if (tenTS.isEmpty()) {
			System.out.println(XuLyLoi.ThongBao.TRONG);
			return;
		}

		ArrayList<Object[]> ketQua = new ArrayList<>();

		// Tìm trong tất cả phiếu
		for (PhieuKiemKe phieu : danhSachPhieu) {
			for (TaiSan ts : phieu.getDanhSachTaiSan()) {
				if (ts.getTenTaiSan().toLowerCase().contains(tenTS)) {
					ketQua.add(new Object[] { phieu, ts });
				}
			}
		}

		// Hiển thị kết quả
		if (ketQua.isEmpty()) {
			System.out.println("\n✗ Không tìm thấy tài sản '" + tenTS + "' trong hệ thống");
			return;
		}

		System.out.println("\n✓ Tìm thấy " + ketQua.size() + " kết quả:");
		System.out.println("=".repeat(100));
		System.out.printf("%-5s │ %-10s │ %-20s │ %-15s │ %-20s │ %-8s │ %-10s │\n", "STT", "Mã phiếu", "Phòng",
				"Tên tài sản", "Tình trạng", "Số lượng", "Vị trí");
		System.out.println("=".repeat(100));

		int stt = 1;
		for (Object[] result : ketQua) {
			PhieuKiemKe phieu = (PhieuKiemKe) result[0];
			TaiSan ts = (TaiSan) result[1];

			System.out.printf("%-5d │ %-10s │ %-20s │ %-15s │ %-20s │ %-8d │ %-10s │\n", stt++, phieu.getMaPhieu(),
					XuLyLoi.catChuoi(phieu.getPhong().getTenPhong(), 20), XuLyLoi.catChuoi(ts.getTenTaiSan(), 15),
					XuLyLoi.catChuoi(ts.getTinhTrang(), 20), ts.getSoLuong(), "Phiếu " + phieu.getMaPhieu());
		}
		System.out.println("=".repeat(100));
	}

	// ============== UTILITY METHODS ==============

	/**
	 * Tìm phiếu theo mã
	 */
	public PhieuKiemKe timPhieuTheoMa(String maPhieu) {
		for (PhieuKiemKe phieu : danhSachPhieu) {
			if (phieu.getMaPhieu().equalsIgnoreCase(maPhieu.trim())) {
				return phieu;
			}
		}
		return null;
	}

	/**
	 * Kiểm tra xem mã phiếu đã tồn tại chưa
	 */
	public boolean kiemTraMaPhieuTonTai(String maPhieu) {
		return timPhieuTheoMa(maPhieu) != null;
	}

	/**
	 * Xóa phiếu kiểm kê
	 */
	public void xoaPhieuKiemKe() {
		XuLyLoi.hienThiTieuDe("XÓA PHIẾU KIỂM KÊ");

		if (XuLyLoi.kiemTraDanhSachTrong(danhSachPhieu)) {
			System.out.println(XuLyLoi.ThongBao.DANH_SACH_TRONG);
			return;
		}

		System.out.print("➤ Nhập mã phiếu cần xóa: ");
		String maPhieu = scanner.nextLine().trim();

		PhieuKiemKe phieu = timPhieuTheoMa(maPhieu);

		if (phieu == null) {
			System.out.println(XuLyLoi.ThongBao.KHONG_TIM_THAY);
			return;
		}

		// Hiển thị thông tin phiếu trước khi xóa
		System.out.println("\nTHÔNG TIN PHIẾU SẼ XÓA:");
		phieu.xuatPhieuTheoMau();

		// Xác nhận xóa
		boolean xacNhan = XuLyLoi.xacNhan(scanner, "Bạn có CHẮC CHẮN muốn xóa phiếu này?");

		if (xacNhan) {
			danhSachPhieu.remove(phieu);
			System.out.println("✓ Đã xóa phiếu mã: " + maPhieu);
		} else {
			System.out.println("Đã hủy thao tác xóa.");
		}
	}

	// ============== MENU MANAGEMENT ==============

	/**
	 * C. Xây dựng menu chính
	 */
	public void menu() {
		int luaChon;

		do {
			hienThiMenuChinh();
			luaChon = XuLyLoi.nhapLuaChonMenu(scanner, SO_CHUC_NANG);
			xuLyMenuChinh(luaChon);

		} while (luaChon != 0);
	}

	/**
	 * Hiển thị menu chính
	 */
	private void hienThiMenuChinh() {
		System.out.println("\n MENU CHÍNH:");
		System.out.println("   1. Thêm phiếu kiểm kê mới");
		System.out.println("   2. Xuất báo cáo phiếu kiểm kê");
		System.out.println("   3. Tìm kiếm phiếu kiểm kê");
		System.out.println("   4. Thống kê tổng quan");
		System.out.println("   5. Sắp xếp danh sách phiếu");
		System.out.println("   6. Xóa phiếu kiểm kê");
		System.out.println("   7. Tìm kiếm tài sản toàn hệ thống");
		System.out.println("   8. Xem dữ liệu mẫu từ đề bài");
		System.out.println("   0. Thoát chương trình");

		XuLyLoi.hienThiPhanCach();
		System.out.println("📌 Thông tin: Hiện có " + danhSachPhieu.size() + " phiếu trong hệ thống");
	}

	/**
	 * Xử lý lựa chọn menu
	 */
	private void xuLyMenuChinh(int luaChon) {
		try {
			switch (luaChon) {
			case 1:
				themPhieuKiemKe();
				break;
			case 2:
				xuatBaoCao();
				break;
			case 3:
				timKiemPhieu();
				break;
			case 4:
				thongKeTongQuan();
				break;
			case 5:
				sapXepPhieu();
				break;
			case 6:
				xoaPhieuKiemKe();
				break;
			case 7:
				timKiemTaiSanToanHeThong();
				break;
			case 8:
				xemDuLieuMau();
				break;
			case 0:
				System.out.println("\n👋 Cảm ơn bạn đã sử dụng chương trình!");
				System.out.println("   Chương trình kết thúc.");
				break;
			}

			if (luaChon != 0) {
				XuLyLoi.doiNhapEnter(scanner, "");
			}

		} catch (Exception e) {
			System.out.println("✗ Đã xảy ra lỗi: " + e.getMessage());
			e.printStackTrace();
		}
	}

	// ============== DATA PERSISTENCE (MOCK) ==============

	/**
	 * Lưu dữ liệu (mock - trong thực tế sẽ lưu vào file/DB)
	 */
	public void luuDuLieu() {
		System.out.println("\n💾 Đang lưu dữ liệu...");
		System.out.println("✓ Đã lưu " + danhSachPhieu.size() + " phiếu kiểm kê");
		System.out.println(XuLyLoi.ThongBao.DA_LUU);
	}

	/**
	 * Đọc dữ liệu (mock - trong thực tế sẽ đọc từ file/DB)
	 */
	public void docDuLieu() {
		System.out.println("\n📂 Đang tải dữ liệu...");
		System.out.println("✓ Đã tải " + danhSachPhieu.size() + " phiếu kiểm kê");
	}
}