package Bai4;

import java.util.Scanner;

public class Bac2 {

    private double a, b, c;  // hệ số 2, hệ số 1, hệ số 0

    // Scanner dùng chung
    private static final Scanner sc = new Scanner(System.in);

    public Bac2() {}

    public Bac2(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    // Nhập double có rào lỗi
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

    // Nhập hệ số
    public void nhapHeSo() {
        System.out.print("Nhập a: ");
        this.a = nhapDouble();

        System.out.print("Nhập b: ");
        this.b = nhapDouble();

        System.out.print("Nhập c: ");
        this.c = nhapDouble();
    }

    // Giải phương trình bậc 2
    public void giaiPT() {

        // TH: a = 0 -> phương trình bậc 1
        if (a == 0) {
            System.out.println("➡ Vì a = 0 → chuyển thành phương trình bậc 1: bx + c = 0");
            if (b == 0 && c == 0) {
                System.out.println("Phương trình có vô số nghiệm.");
            } else if (b == 0 && c != 0) {
                System.out.println("Phương trình vô nghiệm.");
            } else {
                System.out.println("Nghiệm x = " + (-c / b));
            }
            return;
        }

        // Tính delta
        double delta = b * b - 4 * a * c;

        if (delta < 0) {
            System.out.println("Phương trình vô nghiệm (Δ < 0).");
        }
        else if (delta == 0) {
            double x = -b / (2 * a);
            System.out.println("Phương trình có nghiệm kép x1 = x2 = " + x);
        }
        else {
            double x1 = (-b + Math.sqrt(delta)) / (2 * a);
            double x2 = (-b - Math.sqrt(delta)) / (2 * a);
            System.out.println("Phương trình có 2 nghiệm phân biệt:");
            System.out.println("x1 = " + x1);
            System.out.println("x2 = " + x2);
        }
    }
}
