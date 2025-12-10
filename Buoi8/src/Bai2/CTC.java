package Bai2;

public class CTC {
    public static void main(String[] args) {

        SoPhuc sp1 = new SoPhuc();
        SoPhuc sp2 = new SoPhuc();

        System.out.println("Nhập số phức 1:");
        sp1.nhapSP();

        System.out.println("Nhập số phức 2:");
        sp2.nhapSP();

        System.out.println("\n--- Kết quả ---");

        System.out.print("Số phức 1: "); sp1.xuatSP();
        System.out.print("Số phức 2: "); sp2.xuatSP();

        System.out.print("\nCộng: ");
        sp1.cong(sp2).xuatSP();

        System.out.print("Trừ: ");
        sp1.tru(sp2).xuatSP();

        System.out.print("Nhân: ");
        sp1.nhan(sp2).xuatSP();

        System.out.print("Chia: ");
        sp1.chia(sp2).xuatSP();
    }
}
