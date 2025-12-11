package Bai4;

//Lưu thông tin khách hàng sử dụng điện
public class KhachHang {
	private String hoTen;
	private String soNha;
	private String maCongTo;

	// Constructor khởi tạo dữ liệu
	public KhachHang(String hoTen, String soNha, String maCongTo) {
		this.hoTen = hoTen;
		this.soNha = soNha;
		this.maCongTo = maCongTo;
	}

	// Get methods (truy xuất thông tin)
	public String getHoTen() {
		return hoTen;
	}

	public String getSoNha() {
		return soNha;
	}

	public String getMaCongTo() {
		return maCongTo;
	}

	// Hàm xuất thông tin
	public void displayInfo() {
		System.out.println("\n--- THÔNG TIN KHÁCH HÀNG ---");
		System.out.println("Họ tên khách hàng : " + hoTen);
		System.out.println("Số nhà             : " + soNha);
		System.out.println("Mã công tơ         : " + maCongTo);
	}
}
