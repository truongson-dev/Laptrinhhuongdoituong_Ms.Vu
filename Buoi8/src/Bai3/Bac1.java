package Bai3;

import java.util.Scanner;

public class Bac1 {

    private double a; // hệ số 1
    private double b; // hệ số 0

    // Scanner dùng chung (không bị đóng System.in)
    private static final Scanner sc = new Scanner(System.in);

    public Bac1() {}

    public Bac1(double a, double b) {
        this.a = a;
        this.b = b;
    }

    // Hàm nhập double có rào lỗi
    public double nhapDouble() {
        while (true) {
            String s = sc.nextLine().trim();
            try {
                return Double.parseDouble(s);
            } catch (NumberFormatException e) {
                System.out.print("❌ Sai định dạng! Nhập lại số thực: ");
            }
        }
    }

    // Nhập hệ số của phương trình
    public void nhapHeSo() {
        System.out.print("Nhập hệ số a: ");
        this.a = nhapDouble();

        System.out.print("Nhập hệ số b: ");
        this.b = nhapDouble();
    }

    // Giải phương trình bậc 1: ax + b = 0
    public void giaiPT() {
        if (a == 0 && b == 0) {
            System.out.println("Phương trình có vô số nghiệm.");
        } 
        else if (a == 0 && b != 0) {
            System.out.println("Phương trình vô nghiệm.");
        } 
        else {
            double x = -b / a;
            System.out.println("Phương trình có nghiệm duy nhất x = " + x);
        }
    }
}
