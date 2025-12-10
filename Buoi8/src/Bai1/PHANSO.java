package Bai1;

import java.util.Scanner;

public class PHANSO {

    private int tuso;
    private int mauso;

    // Scanner dùng chung toàn bộ lớp
    private static final Scanner in = new Scanner(System.in);

    // Hàm dựng rỗng
    public PHANSO() {}

    // Hàm dựng có tham số
    public PHANSO(int ts, int ms) {
        this.tuso = ts;
        this.mauso = ms;
    }

    // Getter – Setter
    public int getTS() { return tuso; }
    public int getMS() { return mauso; }

    public void setTS(int ts) { this.tuso = ts; }
    public void setMS(int ms) { this.mauso = ms; }

    // Hàm nhập số nguyên AN TOÀN (có rào lỗi)
    public int nhapsonguyen() {
        while (true) {
            String s = in.nextLine().trim();
            try {
                return Integer.parseInt(s);
            } catch (NumberFormatException e) {
                System.out.print("❌ Sai định dạng! Vui lòng nhập số nguyên: ");
            }
        }
    }

    // UCLN
    public int UCLN(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        if (b == 0) return a;
        return UCLN(b, a % b);
    }

    // Rút gọn phân số + chuẩn hóa dấu
    public void RGPS() {
        int u = UCLN(tuso, mauso);
        tuso /= u;
        mauso /= u;

        // chuẩn hóa: mẫu luôn dương
        if (mauso < 0) {
            tuso = -tuso;
            mauso = -mauso;
        }
    }

    // Nhập phân số (có rào lỗi mẫu ≠ 0)
    public void nhapPS() {
        System.out.print("Nhập tử: ");
        this.tuso = nhapsonguyen();

        do {
            System.out.print("Nhập mẫu (≠ 0): ");
            this.mauso = nhapsonguyen();
            if (mauso == 0) {
                System.out.println("❌ Lỗi! Mẫu không thể bằng 0.");
            }
        } while (this.mauso == 0);
    }

    // Xuất phân số
    public void xuatPS() {
        System.out.println(tuso + "/" + mauso);
    }

    // Cộng
    public PHANSO cong(PHANSO b) {
        PHANSO kq = new PHANSO();
        kq.tuso = this.tuso * b.mauso + b.tuso * this.mauso;
        kq.mauso = this.mauso * b.mauso;
        kq.RGPS();
        return kq;
    }

    // Trừ
    public PHANSO tru(PHANSO b) {
        PHANSO kq = new PHANSO();
        kq.tuso = this.tuso * b.mauso - b.tuso * this.mauso;
        kq.mauso = this.mauso * b.mauso;
        kq.RGPS();
        return kq;
    }

    // Nhân
    public PHANSO nhan(PHANSO b) {
        PHANSO kq = new PHANSO(this.tuso * b.tuso, this.mauso * b.mauso);
        kq.RGPS();
        return kq;
    }

    // Chia
    public PHANSO chia(PHANSO b) {
        PHANSO kq = new PHANSO(this.tuso * b.mauso, this.mauso * b.tuso);
        kq.RGPS();
        return kq;
    }
}
