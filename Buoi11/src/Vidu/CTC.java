package Vidu;

public class CTC {
	public static void main(String[] args) {
		// Khởi tạo lớp xe máy
		xeMay xm = new xeMay();

		// Nhập thông tin cho xe máy
		System.out.println("=== NHẬP THÔNG TIN XE MÁY ===");
		xm.NhapThongtin();

		// In chi phí sản xuất và giá bán
		System.out.println("\n=== THÔNG TIN XE MÁY ===");
		System.out.println("Chi phí sản xuất: " + xm.chiPhiSX);
		System.out.println("Giá bán: " + xm.tinhGiaBan());

		// Khởi tạo lớp xe ga bằng constructor có tham số
		xeGa xg = new xeGa("Honda", "Lead", 50000000);

		System.out.println("\n=== THÔNG TIN XE GA (KHỞI TẠO CÓ THAM SỐ) ===");
		System.out.println("Nhà sản xuất: " + xg.getNSX());
		System.out.println("Model: " + xg.getmodel());
		System.out.println("Chi phí sản xuất: " + xg.chiPhiSX);
		System.out.println("Giá bán: " + xg.tinhGiaBan());

		// Khởi tạo lớp xe ga bằng constructor không tham số và nhập thông tin
		xeGa xg2 = new xeGa();

		System.out.println("\n=== NHẬP THÔNG TIN XE GA THỨ 2 ===");
		xg2.NhapThongtin();

		System.out.println("\n=== THÔNG TIN XE GA THỨ 2 ===");
		System.out.println("Nhà sản xuất: " + xg2.getNSX());
		System.out.println("Model: " + xg2.getmodel());
		System.out.println("Chi phí sản xuất: " + xg2.chiPhiSX);
		System.out.println("Giá bán: " + xg2.tinhGiaBan());

		// So sánh giá bán giữa xe máy thường và xe ga
		System.out.println("\n=== SO SÁNH GIÁ BÁN ===");
		System.out.println("Xe máy thường - Giá bán: " + xm.tinhGiaBan());
		System.out.println("Xe ga " + xg.getNSX() + " " + xg.getmodel() + " - Giá bán: " + xg.tinhGiaBan());
		System.out.println("Xe ga " + xg2.getNSX() + " " + xg2.getmodel() + " - Giá bán: " + xg2.tinhGiaBan());
	}
}