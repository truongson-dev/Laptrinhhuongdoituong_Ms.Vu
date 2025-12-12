package QLSV;

public abstract class SinhVien {
	protected String maSV;
	protected String hoTen;
	protected String gioiTinh;
	protected String ngaySinh;

	public SinhVien() {
	}

	public void nhapThongTin() {
		System.out.println("--- NHẬP THÔNG TIN CHUNG ---");
		// Dùng KiemTraDauVao để nhập liệu an toàn
		this.maSV = KiemTraDauVao.nhapChuoi("Nhập Mã Sinh Viên: ");
		this.hoTen = KiemTraDauVao.nhapTen("Nhập Họ và Tên: ");
		this.gioiTinh = KiemTraDauVao.nhapGioiTinh("Nhập Giới Tính (Nam/Nữ): ");
		this.ngaySinh = KiemTraDauVao.nhapNgaySinh("Nhập Ngày Sinh (dd/mm/yyyy): ");
	}

	public void xuatThongTin() {
		// Định dạng in thẳng hàng
		System.out.printf("MSV: %-10s | Tên: %-22s | GT: %-5s | NS: %-12s", maSV, hoTen, gioiTinh, ngaySinh);
	}

	public String getMaSV() {
		return maSV;
	}

	public String getHoTen() {
		return hoTen;
	}

	// Phương thức trừu tượng buộc lớp con phải xử lý
	public abstract boolean kiemTraNhanThuong();
}