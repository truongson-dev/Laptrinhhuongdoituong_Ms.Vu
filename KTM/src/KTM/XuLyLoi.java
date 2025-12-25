package KTM;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.regex.Pattern;

/**
 * Lớp xử lý lỗi và validation chung cho toàn hệ thống Áp dụng nguyên tắc Single
 * Responsibility Principle (SRP)
 */
public class XuLyLoi {

	// ============== CONSTANTS - THÔNG BÁO LỖI ==============
	public static class ThongBao {
		// Lỗi nhập liệu
		public static final String SO_NGUYEN = "✗ Lỗi: Vui lòng nhập số nguyên hợp lệ!";
		public static final String SO_DUONG = "✗ Số phải lớn hơn 0!";
		public static final String SO_KHONG_AM = "✗ Số không được âm!";
		public static final String TRONG = "✗ Không được để trống!";
		public static final String CHON_MENU = "✗ Lựa chọn không hợp lệ!";

		// Lỗi định dạng
		public static final String NGAY = "✗ Ngày không hợp lệ! Định dạng: dd/mm/yyyy";
		public static final String EMAIL = "✗ Email không hợp lệ!";
		public static final String SDT = "✗ Số điện thoại không hợp lệ!";

		// Lỗi nghiệp vụ
		public static final String MA_TRUNG = "⚠ Mã đã tồn tại!";
		public static final String KHONG_TIM_THAY = "✗ Không tìm thấy dữ liệu!";
		public static final String DANH_SACH_TRONG = "✗ Danh sách trống!";

		// Thành công
		public static final String THANH_CONG = "✓ Thao tác thành công!";
		public static final String DA_LUU = "✓ Dữ liệu đã được lưu!";
	}

	// ============== VALIDATION METHODS ==============

	/**
	 * Nhập số nguyên với validation và range
	 */
	public static int nhapSoNguyen(Scanner sc, String prompt, int min, int max) {
		while (true) {
			try {
				System.out.print(prompt);
				String input = sc.nextLine().trim();

				// Kiểm tra trống
				if (input.isEmpty()) {
					System.out.println(ThongBao.TRONG);
					continue;
				}

				int value = Integer.parseInt(input);

				// Kiểm tra range
				if (value < min) {
					System.out.println("✗ Giá trị tối thiểu là " + min);
					continue;
				}

				if (value > max) {
					System.out.println("✗ Giá trị tối đa là " + max);
					continue;
				}

				return value;

			} catch (NumberFormatException e) {
				System.out.println(ThongBao.SO_NGUYEN);
			}
		}
	}

	/**
	 * Nhập số nguyên dương
	 */
	public static int nhapSoDuong(Scanner sc, String prompt) {
		return nhapSoNguyen(sc, prompt, 1, Integer.MAX_VALUE);
	}

	/**
	 * Nhập số nguyên không âm
	 */
	public static int nhapSoKhongAm(Scanner sc, String prompt) {
		return nhapSoNguyen(sc, prompt, 0, Integer.MAX_VALUE);
	}

	/**
	 * Nhập chuỗi không trống
	 */
	public static String nhapChuoiKhongTrong(Scanner sc, String prompt) {
		while (true) {
			System.out.print(prompt);
			String input = sc.nextLine().trim();

			if (!input.isEmpty()) {
				return input;
			}

			System.out.println(ThongBao.TRONG);
		}
	}

	/**
	 * Nhập chuỗi với độ dài tối thiểu
	 */
	public static String nhapChuoi(Scanner sc, String prompt, int minLength) {
		while (true) {
			String input = nhapChuoiKhongTrong(sc, prompt);

			if (input.length() >= minLength) {
				return input;
			}

			System.out.println("✗ Độ dài tối thiểu là " + minLength + " ký tự");
		}
	}

	/**
	 * Nhập lựa chọn menu
	 */
	public static int nhapLuaChonMenu(Scanner sc, int soChucNang) {
		return nhapSoNguyen(sc, "➤ Chọn chức năng (0-" + soChucNang + "): ", 0, soChucNang);
	}

	// ============== FORMAT VALIDATION ==============

	/**
	 * Validate ngày theo định dạng dd/mm/yyyy
	 */
	public static boolean kiemTraNgay(String ngay) {
		if (ngay == null || ngay.isEmpty()) {
			return false;
		}

		// Regex cho định dạng dd/mm/yyyy
		String regex = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/(19|20)\\d{2}$";

		if (!Pattern.matches(regex, ngay)) {
			return false;
		}

		try {
			// Kiểm tra ngày thực tế
			String[] parts = ngay.split("/");
			int ngayInt = Integer.parseInt(parts[0]);
			int thangInt = Integer.parseInt(parts[1]);
			int namInt = Integer.parseInt(parts[2]);

			// Kiểm tra tháng 2
			if (thangInt == 2) {
				boolean namNhuan = (namInt % 4 == 0 && namInt % 100 != 0) || (namInt % 400 == 0);
				int maxNgay = namNhuan ? 29 : 28;
				return ngayInt <= maxNgay;
			}

			// Kiểm tra tháng có 30 ngày
			if (thangInt == 4 || thangInt == 6 || thangInt == 9 || thangInt == 11) {
				return ngayInt <= 30;
			}

			return ngayInt <= 31;

		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Nhập ngày với validation
	 */
	public static String nhapNgay(Scanner sc, String prompt) {
		while (true) {
			String ngay = nhapChuoi(sc, prompt, 8); // dd/mm/yyyy = 10 ký tự

			if (kiemTraNgay(ngay)) {
				return ngay;
			}

			System.out.println(ThongBao.NGAY);
			System.out.println("Ví dụ hợp lệ: 01/01/2024, 15/12/2023");
		}
	}

	/**
	 * Validate email
	 */
	public static boolean kiemTraEmail(String email) {
		if (email == null || email.isEmpty()) {
			return false;
		}

		String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
		return Pattern.matches(regex, email);
	}

	/**
	 * Validate số điện thoại Việt Nam
	 */
	public static boolean kiemTraSDT(String sdt) {
		if (sdt == null || sdt.isEmpty()) {
			return false;
		}

		// Số điện thoại 10-11 số, bắt đầu bằng 0
		String regex = "^0[0-9]{9,10}$";
		return Pattern.matches(regex, sdt);
	}

	// ============== BUSINESS VALIDATION ==============

	/**
	 * Kiểm tra mã có trùng trong danh sách
	 */
	public static <T> boolean kiemTraTrungMa(List<T> danhSach, Function<T, String> layMa, String maCanKiemTra) {
		if (danhSach == null || maCanKiemTra == null) {
			return false;
		}

		for (T item : danhSach) {
			String maHienTai = layMa.apply(item);
			if (maHienTai != null && maHienTai.equalsIgnoreCase(maCanKiemTra.trim())) {
				return true;
			}
		}

		return false;
	}

	/**
	 * Kiểm tra danh sách có trống không
	 */
	public static <T> boolean kiemTraDanhSachTrong(List<T> danhSach) {
		return danhSach == null || danhSach.isEmpty();
	}

	// ============== EXCEPTION HANDLING ==============

	/**
	 * Xử lý ngoại lệ chung với thông báo tùy chỉnh
	 */
	public static void xuLyNgoaiLe(Runnable action, String loiMacDinh) {
		try {
			action.run();
		} catch (NumberFormatException e) {
			System.out.println(ThongBao.SO_NGUYEN);
			System.out.println("Chi tiết: " + e.getMessage());
		} catch (InputMismatchException e) {
			System.out.println("✗ Lỗi: Kiểu dữ liệu không hợp lệ!");
		} catch (IllegalArgumentException e) {
			System.out.println("✗ Lỗi: " + e.getMessage());
		} catch (NullPointerException e) {
			System.out.println("✗ Lỗi: Dữ liệu không tồn tại!");
		} catch (IndexOutOfBoundsException e) {
			System.out.println("✗ Lỗi: Chỉ số vượt quá phạm vi!");
		} catch (Exception e) {
			System.out.println("✗ " + loiMacDinh);
			System.out.println("Chi tiết: " + e.getMessage());
			// Ghi log trong thực tế
			// Logger.getLogger(XuLyLoi.class.getName()).log(Level.SEVERE, null, e);
		}
	}

	/**
	 * Thực thi với retry khi lỗi
	 */
	public static boolean thucThiVoiRetry(Runnable action, int soLanThu, String loiMacDinh) {
		for (int i = 0; i < soLanThu; i++) {
			try {
				action.run();
				return true;
			} catch (Exception e) {
				System.out.println("Lần thử " + (i + 1) + " thất bại: " + e.getMessage());
				if (i < soLanThu - 1) {
					System.out.println("Thử lại...");
				}
			}
		}
		System.out.println("✗ " + loiMacDinh);
		return false;
	}

	// ============== USER INTERACTION ==============

	/**
	 * Hỏi xác nhận có/không
	 */
	public static boolean xacNhan(Scanner sc, String cauHoi) {
		while (true) {
			System.out.print(cauHoi + " (c/k): ");
			String traLoi = sc.nextLine().trim().toLowerCase();

			if (traLoi.equals("c") || traLoi.equals("y") || traLoi.equals("yes")) {
				return true;
			}

			if (traLoi.equals("k") || traLoi.equals("n") || traLoi.equals("no")) {
				return false;
			}

			System.out.println("✗ Vui lòng nhập 'c' để đồng ý hoặc 'k' để từ chối");
		}
	}

	/**
	 * Hiển thị thông báo và đợi nhấn Enter
	 */
	public static void doiNhapEnter(Scanner sc, String thongBao) {
		System.out.println(thongBao);
		System.out.print("Nhấn Enter để tiếp tục...");
		sc.nextLine();
	}

	/**
	 * Hiển thị tiêu đề section
	 */
	public static void hienThiTieuDe(String tieuDe) {
		System.out.println("\n" + "=".repeat(60));
		System.out.println("  " + tieuDe);
		System.out.println("=".repeat(60));
	}

	/**
	 * Hiển thị phân cách
	 */
	public static void hienThiPhanCach() {
		System.out.println("-".repeat(60));
	}

	// ============== UTILITY METHODS ==============

	/**
	 * Format số với dấu phân cách
	 */
	public static String formatSo(long so) {
		return String.format("%,d", so);
	}

	/**
	 * Cắt chuỗi nếu quá dài
	 */
	public static String catChuoi(String str, int maxLength) {
		if (str == null) {
			return "";
		}
		if (str.length() <= maxLength) {
			return str;
		}
		return str.substring(0, maxLength - 3) + "...";
	}

	/**
	 * Kiểm tra chuỗi chỉ chứa chữ cái và khoảng trắng
	 */
	public static boolean kiemTraChuoiChu(String str) {
		if (str == null) {
			return false;
		}
		return str.matches("^[a-zA-ZÀ-ỹ\\s]+$");
	}
}