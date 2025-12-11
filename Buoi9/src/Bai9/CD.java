package Bai9;

public class CD {
	private int maCD;
	private String tuaCD;
	private String caSy;
	private int soBH;
	private double giaThanh;

	// Constructor mặc định
	public CD() {
		this.maCD = 0;
		this.tuaCD = "";
		this.caSy = "";
		this.soBH = 0;
		this.giaThanh = 0.0;
	}

	// Constructor có tham số
	public CD(int maCD, String tuaCD, String caSy, int soBH, double giaThanh) {
		this.maCD = maCD;
		this.tuaCD = tuaCD;
		this.caSy = caSy;
		this.soBH = soBH;
		this.giaThanh = giaThanh;
	}

	// Getter và Setter
	public int getMaCD() {
		return maCD;
	}

	public void setMaCD(int maCD) {
		this.maCD = maCD;
	}

	public String getTuaCD() {
		return tuaCD;
	}

	public void setTuaCD(String tuaCD) {
		this.tuaCD = tuaCD;
	}

	public String getCaSy() {
		return caSy;
	}

	public void setCaSy(String caSy) {
		this.caSy = caSy;
	}

	public int getSoBH() {
		return soBH;
	}

	public void setSoBH(int soBH) {
		if (soBH > 0) {
			this.soBH = soBH;
		}
	}

	public double getGiaThanh() {
		return giaThanh;
	}

	public void setGiaThanh(double giaThanh) {
		if (giaThanh > 0) {
			this.giaThanh = giaThanh;
		}
	}

	@Override
	public String toString() {
		return String.format("%-10d %-20s %-20s %-10d %-15.2f", maCD, tuaCD, caSy, soBH, giaThanh);
	}
}