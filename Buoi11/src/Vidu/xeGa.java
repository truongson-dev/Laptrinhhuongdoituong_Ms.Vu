package Vidu;

import java.util.Scanner;

// khai báo định nghĩa lớp con xeGa thừa kế từ lớp xeMay
public class xeGa extends xeMay {
	// khai báo thuộc tính riêng
	private String nhaSX, model;

	// các hàm set/get
	public String getNSX() {
		return this.nhaSX;
	}

	public String getmodel() {
		return this.model;
	}

	// Khai báo hàm dựng không có tham số
	public xeGa() {
		super();
	}

	// Khai báo hàm dựng có tham số
	public xeGa(String nsx, String md, double cpsx) {
		super(cpsx); // thừa kế hàm dựng có tham số của lớp cha
		this.nhaSX = nsx;
		this.model = md;
	}

	// Khai báo định nghĩa giá bán (ghi đè phương thức của lớp cha)
	@Override
	public double tinhGiaBan() {
		return 4 * this.chiPhiSX;
	}

	// Định nghĩa hàm nhập
	@Override
	public void NhapThongtin() {
		try (Scanner sn = new Scanner(System.in)) {
			System.out.print("Nhập nhà sản xuất: ");
			this.nhaSX = sn.nextLine();

			System.out.print("Nhập model: ");
			this.model = sn.nextLine();
		}

		// Gọi phương thức nhập của lớp cha
		super.NhapThongtin();
	}
}