package Bai1;

public class CTC {
    public static void main(String[] args) {

        PHANSO ps1 = new PHANSO();
        System.out.println("Nhập phân số 1:");
        ps1.nhapPS();

        PHANSO ps2 = new PHANSO();
        System.out.println("Nhập phân số 2:");
        ps2.nhapPS();

        System.out.print("\nPhân số 1: ");
        ps1.xuatPS();
        System.out.print("Phân số 2: ");
        ps2.xuatPS();

        System.out.println("\n--- Kết quả ---");

        System.out.print("Cộng: ");
        ps1.cong(ps2).xuatPS();

        System.out.print("Trừ: ");
        ps1.tru(ps2).xuatPS();

        System.out.print("Nhân: ");
        ps1.nhan(ps2).xuatPS();

        System.out.print("Chia: ");
        ps1.chia(ps2).xuatPS();
    }
}
