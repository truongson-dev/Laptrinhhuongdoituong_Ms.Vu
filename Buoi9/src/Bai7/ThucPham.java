package Bai7;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

class ThucPham {
	// Các thuộc tính
	private final String maHang; // Không cho phép sửa
	private String tenHang;
	private double donGia;
	private Date nSX; // Ngày sản xuất
	private Date hSD; // Ngày hết hạn

	// Định dạng
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	private static final DecimalFormat priceFormat = new DecimalFormat("#,##0");

	// Constructor đầy đủ tham số
	public ThucPham(String maHang, String tenHang, double donGia, Date nSX, Date hSD) {
		// Kiểm tra và gán mã hàng
		if (maHang == null || maHang.trim().isEmpty()) {
			this.maHang = "MH001"; // Giá trị mặc định
		} else {
			this.maHang = maHang;
		}

		// Gọi setter cho các thuộc tính còn lại để áp dụng ràng buộc
		setTenHang(tenHang);
		setDonGia(donGia);
		setNSX(nSX);
		setHSD(hSD);
	}

	// Constructor chỉ với mã hàng
	public ThucPham(String maHang) {
		// Kiểm tra và gán mã hàng
		if (maHang == null || maHang.trim().isEmpty()) {
			this.maHang = "MH001"; // Giá trị mặc định
		} else {
			this.maHang = maHang;
		}

		// Gán giá trị mặc định cho các thuộc tính khác
		this.tenHang = "Thực phẩm mới";
		this.donGia = 10000;
		this.nSX = new Date(); // Ngày hiện tại
		this.hSD = new Date(); // Ngày hiện tại
	}

	// Getter và Setter
	public String getMaHang() {
		return maHang;
	}

	// Mã hàng không có setter vì là final

	public String getTenHang() {
		return tenHang;
	}

	public void setTenHang(String tenHang) {
		if (tenHang == null || tenHang.trim().isEmpty()) {
			this.tenHang = "Thực phẩm mới"; // Giá trị mặc định
		} else {
			this.tenHang = tenHang;
		}
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) {
		if (donGia > 0) {
			this.donGia = donGia;
		} else {
			this.donGia = 10000; // Giá trị mặc định
		}
	}

	public Date getNSX() {
		return nSX;
	}

	public void setNSX(Date nSX) {
		if (nSX == null) {
			this.nSX = new Date(); // Giá trị mặc định là ngày hiện tại
		} else {
			this.nSX = nSX;
		}
	}

	public Date getHSD() {
		return hSD;
	}

	public void setHSD(Date hSD) {
		if (hSD == null) {
			this.hSD = new Date(); // Giá trị mặc định là ngày hiện tại
		} else if (hSD.after(this.nSX)) {
			this.hSD = hSD;
		} else {
			// Nếu ngày hết hạn không sau ngày sản xuất, đặt mặc định là 30 ngày sau NSX
			long time = this.nSX.getTime() + 30L * 24 * 60 * 60 * 1000;
			this.hSD = new Date(time);
		}
	}

	// Phương thức kiểm tra hàng đã hết hạn chưa
	public boolean daHetHan() {
		Date ngayHienTai = new Date();
		return ngayHienTai.after(hSD);
	}

	// Phương thức kiểm tra còn bao nhiêu ngày hết hạn
	public int soNgayConLai() {
		Date ngayHienTai = new Date();
		if (ngayHienTai.after(hSD)) {
			return 0; // Đã hết hạn
		}

		long diff = hSD.getTime() - ngayHienTai.getTime();
		return (int) (diff / (1000 * 60 * 60 * 24)); // Chuyển từ milliseconds sang ngày
	}

	// Phương thức toString
	@Override
	public String toString() {
		String trangThai = daHetHan() ? "ĐÃ HẾT HẠN" : "CÒN HẠN";
		String ngayConLai = "";

		if (!daHetHan()) {
			ngayConLai = " (Còn " + soNgayConLai() + " ngày)";
		}

		return "Thông tin thực phẩm:\n" + "Mã hàng: " + maHang + "\n" + "Tên hàng: " + tenHang + "\n" + "Đơn giá: "
				+ priceFormat.format(donGia) + " VNĐ\n" + "Ngày sản xuất: " + dateFormat.format(nSX) + "\n"
				+ "Ngày hết hạn: " + dateFormat.format(hSD) + "\n" + "Trạng thái: " + trangThai + ngayConLai;
	}

}
