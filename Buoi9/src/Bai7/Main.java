package Bai7;

import java.text.SimpleDateFormat;
import java.util.Date;

// Class Main để chạy chương trình
public class Main {
	public static void main(String[] args) {
		try {
			// Tạo đối tượng SimpleDateFormat để parse ngày
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

			System.out.println("=== KIỂM TRA THỰC PHẨM ===\n");

			// Tạo thực phẩm 1: Constructor đầy đủ tham số
			System.out.println("1. Thực phẩm 1:");
			ThucPham tp1 = new ThucPham("TP001", "Sữa tươi Vinamilk", 25000, dateFormat.parse("15/10/2023"),
					dateFormat.parse("15/11/2023"));
			System.out.println(tp1.toString());
			System.out.println();

			// Tạo thực phẩm 2: Constructor chỉ với mã hàng
			System.out.println("2. Thực phẩm 2 (chỉ mã hàng):");
			ThucPham tp2 = new ThucPham("TP002");
			tp2.setTenHang("Bánh mì tươi");
			tp2.setDonGia(15000);
			tp2.setNSX(dateFormat.parse("01/11/2023"));
			tp2.setHSD(dateFormat.parse("05/11/2023"));
			System.out.println(tp2.toString());
			System.out.println();

			// Tạo thực phẩm 3: Kiểm tra ràng buộc dữ liệu không hợp lệ
			System.out.println("3. Thực phẩm 3 (dữ liệu không hợp lệ):");
			ThucPham tp3 = new ThucPham("", // Mã hàng rỗng -> gán mặc định
					"", // Tên hàng rỗng -> gán mặc định
					-5000, // Đơn giá âm -> gán mặc định
					dateFormat.parse("20/11/2023"), dateFormat.parse("10/11/2023") // HSD trước NSX -> gán mặc định
			);
			System.out.println(tp3.toString());
			System.out.println();

			// Tạo thực phẩm 4: Kiểm tra với ngày hiện tại
			System.out.println("4. Thực phẩm 4 (hạn sử dụng trong tương lai):");
			Date futureDate = new Date(System.currentTimeMillis() + 10L * 24 * 60 * 60 * 1000); // 10 ngày sau
			ThucPham tp4 = new ThucPham("TP004", "Nước ngọt CocaCola", 12000, new Date(), futureDate);
			System.out.println(tp4.toString());

		} catch (Exception e) {
			System.out.println("Lỗi: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
