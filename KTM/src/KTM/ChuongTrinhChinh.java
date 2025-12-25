package KTM;

/**
 * Lớp chương trình chính - Entry point của ứng dụng
 */
public class ChuongTrinhChinh {

	/**
	 * Phương thức main - điểm bắt đầu chương trình
	 */
	public static void main(String[] args) {

		// Khởi tạo đối tượng xử lý chức năng
		XuLyChucNang xuly = new XuLyChucNang();

		try {
			// Chạy menu chính
			xuly.menu();

		} catch (Exception e) {
			// Xử lý lỗi toàn cục
			System.out.println("\n❌ LỖI NGHIÊM TRỌNG!");
			System.out.println("Chi tiết: " + e.getMessage());
			System.out.println("\nChương trình bị dừng đột ngột.");
			e.printStackTrace();

		} finally {
			// Luôn thực thi dù có lỗi hay không
			ketThucChuongTrinh(xuly);
		}
	}

	/**
	 * Xử lý khi kết thúc chương trình
	 */
	private static void ketThucChuongTrinh(XuLyChucNang xuly) {
		System.out.println("\n" + "=".repeat(60));
		System.out.println("         KẾT THÚC CHƯƠNG TRÌNH");
		System.out.println("=".repeat(60));

		// Lưu dữ liệu trước khi thoát
		System.out.println("\n💾 Đang lưu dữ liệu cuối cùng...");
		try {
			xuly.luuDuLieu();
		} catch (Exception e) {
			System.out.println("⚠ Cảnh báo: Không thể lưu dữ liệu!");
		}

		// Hiển thị thông báo kết thúc
		System.out.println("\n" + "✨".repeat(25));
		System.out.println("   CẢM ƠN ĐÃ SỬ DỤNG CHƯƠNG TRÌNH!");
		System.out.println("   HẸN GẶP LẠI!");
		System.out.println("✨".repeat(25));

		// Đóng Scanner nếu có
		try {
			// Trong thực tế cần đóng Scanner nếu không dùng System.in
			// scanner.close(); // Không đóng System.in
		} catch (Exception e) {
			// Bỏ qua
		}
	}

	/**
	 * Phương thức hiển thị hướng dẫn sử dụng
	 */
	public static void hienThiHuongDan() {
		System.out.println("\n📖 HƯỚNG DẪN SỬ DỤNG:");
		System.out.println("─".repeat(40));
		System.out.println("1. Thêm phiếu: Nhập thông tin đầy đủ");
		System.out.println("2. Xuất báo cáo: Chọn định dạng xuất");
		System.out.println("3. Tìm kiếm: Theo nhiều tiêu chí");
		System.out.println("4. Thống kê: Xem tổng quan hệ thống");
		System.out.println("5. Sắp xếp: Theo nhiều tiêu chí");
		System.out.println("6. Xóa: Xóa phiếu theo mã");
		System.out.println("7. Tìm TS: Tìm tài sản trong tất cả phiếu");
		System.out.println("8. Mẫu: Xem dữ liệu mẫu từ đề bài");
		System.out.println("0. Thoát: Kết thúc chương trình");
		System.out.println("─".repeat(40));
	}
}