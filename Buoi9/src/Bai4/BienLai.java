package Bai4;

//Quản lý biên lai thu tiền điện
public class BienLai {
	private int chiSoCu;
	private int chiSoMoi;
	private KhachHang khachHang; // liên kết khóa ngoại
	private long soTienPhaiTra;

	// Constructor
	public BienLai(int chiSoCu, int chiSoMoi, KhachHang khachHang) {
		this.chiSoCu = chiSoCu;
		this.chiSoMoi = chiSoMoi;
		this.khachHang = khachHang;
		tinhTien(); // tính tiền tự động sau khi khởi tạo
	}

	// Hàm tính tiền điện
	private void tinhTien() {
		soTienPhaiTra = (chiSoMoi - chiSoCu) * 850000;
	}

	// Hàm xuất thông tin biên lai
	public void displayBill() {
		khachHang.displayInfo();
		System.out.println("\n--- THÔNG TIN BIÊN LAI ---");
		System.out.println("Chỉ số cũ          : " + chiSoCu);
		System.out.println("Chỉ số mới         : " + chiSoMoi);
		System.out.println("Tiền phải trả      : " + soTienPhaiTra + " VNĐ");
	}
}
