package Bai4;

import java.util.Scanner;

public class CTC {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
			int chon = -1;

			while (chon != 0) {
			    System.out.println("\n===== MENU PHƯƠNG TRÌNH BẬC 2 =====");
			    System.out.println("1. Giải phương trình bậc 2");
			    System.out.println("0. Thoát chương trình");
			    System.out.print("Chọn: ");

			    try {
			        chon = Integer.parseInt(sc.nextLine());
			    } catch (Exception e) {
			        System.out.println("Sai định dạng! Chỉ nhập số 0 hoặc 1.");
			        continue;
			    }

			    switch (chon) {
			        case 1: {
			            Bac2 pt = new Bac2();
			            System.out.println("Nhập phương trình dạng ax^2 + bx + c = 0");
			            pt.nhapHeSo();
			            System.out.println("\n--- KẾT QUẢ ---");
			            pt.giaiPT();
			            break;
			        }
			        case 0:
			            System.out.println("Thoát chương trình...");
			            break;

			        default:
			            System.out.println("Chỉ được chọn 0 hoặc 1!");
			    }
			}
		}
    }
}
