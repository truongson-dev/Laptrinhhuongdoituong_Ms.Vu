package QLSV;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class KiemTraDauVao {
	private static Scanner scanner = new Scanner(System.in);

	/**
	 * Nhập chuỗi và không cho phép để trống
	 */
	public static String nhapChuoi(String thongBao) {
		String input;
		while (true) {
			System.out.print(thongBao);
			input = scanner.nextLine().trim();
			if (!input.isEmpty()) {
				return input;
			}
			System.err.println(">> Lỗi: Thông tin không được để trống. Vui lòng nhập lại!");
		}
	}

	/**
	 * Nhập họ tên (Chỉ chấp nhận chữ cái và khoảng trắng, chặn số và ký tự đặc
	 * biệt)
	 */
	public static String nhapTen(String thongBao) {
		String input;
		// Regex chấp nhận chữ cái tiếng Việt (unicode) và khoảng trắng
		String regex = "^[\\p{L}\\s]+$";
		while (true) {
			System.out.print(thongBao);
			input = scanner.nextLine().trim();
			if (Pattern.matches(regex, input)) {
				return chuanHoaTen(input);
			}
			System.err.println(">> Lỗi: Họ tên không hợp lệ (không được chứa số hoặc ký tự đặc biệt)!");
		}
	}

	// Hàm phụ trợ viết hoa chữ cái đầu (ví dụ: nguyen van a -> Nguyen Van A)
	private static String chuanHoaTen(String ten) {
		String[] tu = ten.split("\\s+");
		StringBuilder sb = new StringBuilder();
		for (String t : tu) {
			if (t.length() > 0) {
				sb.append(Character.toUpperCase(t.charAt(0))).append(t.substring(1).toLowerCase()).append(" ");
			}
		}
		return sb.toString().trim();
	}

	/**
	 * Nhập số nguyên trong khoảng cho phép (dùng cho Menu hoặc Niên chế)
	 */
	public static int nhapSoNguyen(String thongBao, int min, int max) {
		while (true) {
			try {
				System.out.print(thongBao);
				int so = Integer.parseInt(scanner.nextLine().trim());
				if (so >= min && so <= max) {
					return so;
				}
				System.err.println(">> Lỗi: Vui lòng nhập số trong khoảng [" + min + " - " + max + "]");
			} catch (NumberFormatException e) {
				System.err.println(">> Lỗi: Sai định dạng! Vui lòng nhập số nguyên.");
			}
		}
	}

	/**
	 * Nhập số nguyên dương (dùng cho Tín chỉ)
	 */
	public static int nhapSoNguyenDuong(String thongBao) {
		while (true) {
			try {
				System.out.print(thongBao);
				int so = Integer.parseInt(scanner.nextLine().trim());
				if (so > 0) {
					return so;
				}
				System.err.println(">> Lỗi: Vui lòng nhập số lớn hơn 0!");
			} catch (NumberFormatException e) {
				System.err.println(">> Lỗi: Sai định dạng! Vui lòng nhập số nguyên.");
			}
		}
	}

	/**
	 * Nhập điểm số thực (double) trong khoảng cho phép
	 */
	public static double nhapDiem(String thongBao, double min, double max) {
		while (true) {
			try {
				System.out.print(thongBao);
				double so = Double.parseDouble(scanner.nextLine().trim());
				if (so >= min && so <= max) {
					return so;
				}
				System.err.println(">> Lỗi: Điểm phải nằm trong khoảng [" + min + " - " + max + "]");
			} catch (NumberFormatException e) {
				System.err.println(">> Lỗi: Sai định dạng! Vui lòng nhập số thực (ví dụ: 7.5).");
			}
		}
	}

	/**
	 * Nhập Giới Tính và chỉ cho phép Nam/Nữ (case-insensitive)
	 */
	public static String nhapGioiTinh(String thongBao) {
		String input;
		while (true) {
			System.out.print(thongBao);
			input = scanner.nextLine().trim();
			// Kiểm tra và chuẩn hóa input
			if (input.equalsIgnoreCase("nam")) {
				return "Nam";
			} else if (input.equalsIgnoreCase("nữ")) {
				return "Nữ";
			}
			System.err.println(">> Lỗi: Giới tính chỉ được nhập 'Nam' hoặc 'Nữ'. Vui lòng nhập lại!");
		}
	}

	/** Kiểm tra Ngày Sinh (dd/mm/yyyy) hợp lệ và đúng định dạng */
	public static String nhapNgaySinh(String thongBao) {
		String input;
		// KHỞI TẠO FORMATTER BÊN TRONG HÀM để tránh lỗi NullPointerException khi Class
		// Load
		final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		while (true) {
			System.out.print(thongBao);
			input = scanner.nextLine().trim();

			if (input.isEmpty()) {
				System.err.println(">> Lỗi: Ngày sinh không được để trống.");
				continue;
			}

			try {
				// Sử dụng dateFormatter cục bộ
				LocalDate.parse(input, dateFormatter);
				return input;
			} catch (DateTimeParseException e) {
				// Bắt lỗi sai định dạng ngày
				System.err.println(
						">> Lỗi: Ngày sinh không hợp lệ hoặc sai định dạng. Vui lòng nhập lại theo dạng dd/mm/yyyy (ví dụ: 01/01/2000).");
			} catch (Exception e) {
				// Bắt các lỗi runtime khác và yêu cầu nhập lại
				System.err.println(
						">> Lỗi hệ thống: Đã xảy ra lỗi không mong muốn. Vui lòng nhập lại đúng định dạng dd/mm/yyyy.");
			}
		}
	}

}