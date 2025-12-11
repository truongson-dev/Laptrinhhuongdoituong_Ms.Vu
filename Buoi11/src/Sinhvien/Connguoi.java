package Sinhvien;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Connguoi {
	// Thuộc tính
	protected String hoTen;
	protected Date ngaySinh;
	protected String diaChi;
	protected String cccd;

	// Định dạng ngày tháng
	protected SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	protected Scanner scanner = new Scanner(System.in);

	// Constructor mặc định
	public Connguoi() {
		this.hoTen = "";
		this.ngaySinh = new Date();
		this.diaChi = "";
		this.cccd = "";
	}

	// Constructor có tham số
	public Connguoi(String hoTen, Date ngaySinh, String diaChi, String cccd) {
		this.hoTen = hoTen;
		this.ngaySinh = ngaySinh;
		this.diaChi = diaChi;
		this.cccd = cccd;
	}

	// Getter và Setter
	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getCccd() {
		return cccd;
	}

	public void setCccd(String cccd) {
		this.cccd = cccd;
	}

	// Phương thức nhập thông tin
	public void nhapThongTin() {
		System.out.print("Nhập họ tên: ");
		this.hoTen = scanner.nextLine();

		while (true) {
			System.out.print("Nhập ngày sinh (dd/MM/yyyy): ");
			String ngaySinhStr = scanner.nextLine();
			try {
				this.ngaySinh = dateFormat.parse(ngaySinhStr);
				break;
			} catch (ParseException e) {
				System.out.println("Định dạng ngày không hợp lệ! Vui lòng nhập lại.");
			}
		}

		System.out.print("Nhập địa chỉ: ");
		this.diaChi = scanner.nextLine();

		System.out.print("Nhập số CCCD: ");
		this.cccd = scanner.nextLine();
	}

	// Phương thức xuất thông tin
	public void xuatThongTin() {
		System.out.println("Họ tên: " + hoTen);
		System.out.println("Ngày sinh: " + dateFormat.format(ngaySinh));
		System.out.println("Địa chỉ: " + diaChi);
		System.out.println("CCCD: " + cccd);
	}

	// Phương thức tính tuổi
	public int tinhTuoi() {
		Date now = new Date();
		long diff = now.getTime() - ngaySinh.getTime();
		return (int) (diff / (1000L * 60 * 60 * 24 * 365));
	}
}