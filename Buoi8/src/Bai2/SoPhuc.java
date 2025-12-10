package Bai2;

import java.util.Scanner;

public class SoPhuc {

    private double thuc, ao;

    // Scanner dùng chung (không bị lỗi đóng System.in)
    private static final Scanner sc = new Scanner(System.in);

    // Hàm dựng rỗng
    public SoPhuc() {}

    // Hàm dựng có tham số
    public SoPhuc(double t, double a) {
        this.thuc = t;
        this.ao = a;
    }

    // Getter – Setter
    public double getThuc() { return thuc; }
    public double getAo() { return ao; }
    public void setThuc(double t) { this.thuc = t; }
    public void setAo(double a) { this.ao = a; }

    // Hàm nhập double có rào lỗi
    public double nhapDouble() {
        while (true) {
            String line = sc.nextLine().trim();
            try {
                return Double.parseDouble(line);
            } catch (NumberFormatException e) {
                System.out.print("❌ Sai! Nhập lại số thực (vd: 3.5 hoặc -2): ");
            }
        }
    }

    // Nhập số phức
    public void nhapSP() {
        System.out.print("Nhập phần thực: ");
        this.thuc = nhapDouble();

        System.out.print("Nhập phần ảo: ");
        this.ao = nhapDouble();
    }

    // Xuất số phức
    public void xuatSP() {
        if (ao >= 0)
            System.out.println(thuc + " + " + ao + "i");
        else
            System.out.println(thuc + " - " + (-ao) + "i");
    }

    // Cộng
    public SoPhuc cong(SoPhuc b) {
        return new SoPhuc(thuc + b.thuc, ao + b.ao);
    }

    // Trừ
    public SoPhuc tru(SoPhuc b) {
        return new SoPhuc(thuc - b.thuc, ao - b.ao);
    }

    // Nhân
    public SoPhuc nhan(SoPhuc b) {
        double t = thuc * b.thuc - ao * b.ao;
        double a = thuc * b.ao + ao * b.thuc;
        return new SoPhuc(t, a);
    }

    // Chia
    public SoPhuc chia(SoPhuc b) {
        double mau = b.thuc * b.thuc + b.ao * b.ao;
        double t = (thuc * b.thuc + ao * b.ao) / mau;
        double a = (ao * b.thuc - thuc * b.ao) / mau;
        return new SoPhuc(t, a);
    }
}
