package QuanLyCanBoTruong;

import java.util.Scanner;

public class Utility {

    static Scanner nhap = new Scanner(System.in);

    public static int nhapInt() {
        int i = 0;
        while (true) {
            try {
                i = Integer.parseInt(nhap.nextLine());
                if (i < 0) {
                    throw new NumberFormatException();
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Da Xay ra ngoai le, can nhap vao so duong");
            }
        }
        return i;
    }

    public static float nhapFloat() {
        float i = 0;
        while (true) {
            try {

                i = Float.parseFloat(nhap.nextLine());
                if (i < 0) {
                    throw new NumberFormatException();
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Da Xay ra ngoai le, can nhap vao so duong");
            }
        }
        return i;
    }

    public static String nhapString() {
        return nhap.nextLine();
    }

}
