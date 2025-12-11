package BuildClass;

public class Student {
	private String id;
	private String name;
	private double diemTB;

	// Constructor mặc định
	public Student() {
		this.id = "";
		this.name = "";
		this.diemTB = 0.0;
	}

	// Constructor có tham số
	public Student(String id, String name, double diemTB) {
		this.id = id;
		this.name = name;
		this.diemTB = diemTB;
	}

	// Getter và Setter
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getDiemTB() {
		return diemTB;
	}

	public void setDiemTB(double diemTB) {
		if (diemTB >= 0 && diemTB <= 10) {
			this.diemTB = diemTB;
		} else {
			System.out.println("Lỗi: Điểm trung bình phải từ 0 đến 10!");
			this.diemTB = 0.0;
		}
	}

	// Phương thức hiển thị thông tin
	public void hienThiThongTin1() {
		System.out.printf("%-10s %-25s %-10.2f\n", id, name, diemTB);
	}

	@Override
	public String toString() {
		return String.format("%-10s %-25s %-10.2f", id, name, diemTB);
	}

	public void hienThiThongTin() {
		// TODO Auto-generated method stub

	}
}