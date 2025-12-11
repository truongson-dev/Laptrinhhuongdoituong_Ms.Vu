package Vidu;

import java.util.Scanner;

public class xeMay {
	// khai báo thuộc tính
	protected double chiPhiSX;

	// viết hàm dựng không có tham số
	public xeMay() {
	}

	// viết hàm dựng có tham số
	public xeMay(double chiPhiSX) {
		this.chiPhiSX = chiPhiSX;
	}

	public double tinhGiaBan() {
		return 2 * this.chiPhiSX;
	}

	public void NhapThongtin() {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.print("Nhập chi phí sản xuất: ");
			this.chiPhiSX = sc.nextDouble();
			sc.nextLine(); // Đọc bỏ dòng new line còn lại
		}
	}
}