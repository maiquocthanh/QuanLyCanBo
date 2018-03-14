package QuanLyCanBoTruong;

import java.util.ArrayList;
import CanBoTruong.GiangVien;
import CanBoTruong.NhanVien;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Comparator;

public class QuanLyCanBo implements Comparator<GiangVien> {

    private static NhanVien[] danhSachNV = null;
    private static ArrayList<GiangVien> danhSachGV = new ArrayList<>();

    public static void nhapThongTinNhanVien() {
        System.out.println("........NHAP THONG TIN CHO NHAN VIEN HANH CHINH........");
        int n;
        System.out.print("Nhap so luong nhan vien: ");
        n = Utility.nhapInt();
        danhSachNV = new NhanVien[n];
        for (int i = 0; i < danhSachNV.length; i++) {
            danhSachNV[i] = new NhanVien();
            System.out.println("Nhap thong tin cho giang vien thu: " + (i + 1));
            danhSachNV[i].nhapThongTin();
        }

    }

    public static void hienThiNhanVien() {
        System.out.printf("%-20s%-10s%-10s\t%-10s%-10s%-10s%-10s\n", "Ho va Ten", "PhongBan", "ChucVu", "HeSL", "NgayCong", "PhuCap", "Luong(USD)");
        System.out.println("-----------------------------------------------------------------------------------");
        for (int i = 0; i < danhSachNV.length; i++) {
            danhSachNV[i].hienThi();
        }
        System.out.println("");

    }

    public static void ghiNhanVien() {
        try {
            File file = new File("DanhsachNhanVien.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            PrintWriter pw = new PrintWriter(file);
            pw.println("---------------------------DANH SACH CAC CAN BO NHAN VIEN ----------------------------");
            pw.println();
            pw.println(String.format("%-20s%-10s%-10s\t%-10s%-10s%-10s%-10s", "Ho va Ten", "PhongBan", "ChucVu", "HeSL", "NgayCong", "PhuCap", "Luong(USD)"));
            pw.println("---------------------------------------------------------------------------------------");
            for (int i = 0; i < danhSachNV.length; i++) {
                NhanVien nhanVien = danhSachNV[i];
                pw.println(String.format("%-20s%-10s%-10s\t%-10.1f%-10.1f%-10d%-10.1f", danhSachNV[i].getHoTen(), danhSachNV[i].getPhongBan(), danhSachNV[i].getChucVu(), danhSachNV[i].getHeSoLuong(), danhSachNV[i].getSoNgayCong(), danhSachNV[i].tinhPhuCap(), danhSachNV[i].tinhLuong()));
            }
            pw.close();
            System.out.println("Da xong viec ghi danh sach nhan vien ra file text");
        } catch (IOException ex) {
            System.out.println("Da xay ra ngoai le khi ghi file: ");

        }
    }

    public static void timNhanVien() {
        String tenNV;
        String tenPB;
        int dem = 0;
        System.out.print("Nhap ten nhan vien can tim kiem :");
        tenNV = Utility.nhapString();
        System.out.print("Nhap nhan can tim theo phong :");
        tenPB = Utility.nhapString();
        ArrayList<NhanVien> kq = timnhanvien(danhSachNV, tenNV, tenPB);
        for (int i = 0; i < kq.size(); i++) {
            System.out.println("--------------------------NHAN VIEN CAN TIM NHU DUOI------------------------------");
            System.out.printf("%-20s%-10s%-10s\t%-10s%-10s%-10s%-10s\n", "Ho va Ten", "PhongBan", "ChucVu", "HeSL", "NgayCong", "PhuCap", "Luong(USD)");
            System.out.println("-----------------------------------------------------------------------------------");
            kq.get(i).hienThi();
            dem++;

        }
        if (dem == 0) {
            System.out.println("Khong tim thay nhan vien nao theo yeu cau tim kiem");
        }
        System.out.println("");
    }

    public static ArrayList<NhanVien> timnhanvien(NhanVien[] danhSachNV, String tenNV, String tenPB) {
        ArrayList<NhanVien> result = new ArrayList<NhanVien>();
        for (int i = 0; i < danhSachNV.length; i++) {
            if (tenNV.equalsIgnoreCase(danhSachNV[i].getHoTen()) && tenPB.equalsIgnoreCase(danhSachNV[i].getPhongBan())) {
                result.add(danhSachNV[i]);
            }
        }
        return result;
    }

    public static void nhapThongTinGiangVien() {
        System.out.println("........NHAP THONG TIN CHO GIANG VIEN........");
        int[] array;
        int n;
        System.out.print("Nhap so luong giang vien: ");
        n = Utility.nhapInt();
        array = new int[n];
        for (int i = 0; i < array.length; i++) {
            System.out.println("Moi Nhap thong tin cho giang vien thu " + (i + 1) + " :");
            GiangVien gv = new GiangVien();
            gv.nhapThongTin();
            danhSachGV.add(gv);

        }
    }

    @Override
    public int compare(GiangVien o1, GiangVien o2) {
        return o1.getTen().compareToIgnoreCase(o2.getTen());
    }

    public static void hienThiGiangVien() {
        System.out.println("----------------DANH SACH CAC GIANG VIEN TRONG TRUONG SAP XEP THEO TEN --------------");
        System.out.printf("%-20s%-10s%-10s\t%-10s%-10s%-10s%-10s\n", "Ho va Ten", "Khoa", "TrinhDo", "HeSL", "GioDay", "PhuCap", "Luong(USD)");
        System.out.println("-------------------------------------------------------------------------------------");
        Collections.sort(danhSachGV, new QuanLyCanBo());
        for (int i = 0; i < danhSachGV.size(); i++) {
            danhSachGV.get(i).hienThi();
        }
        System.out.println("");
    }

    public static void main(String[] args) {

        int luaChon;
        do {
            System.out.println(" __________________________________MENU_______________________________________");
            System.out.println("| 1. Nhap thong tin cho cac giang vien trong truong...........................| ");
            System.out.println("| 2. Nhap thong tin cho cac nhan vien hanh chinh trong truong.................| ");
            System.out.println("| 3. Tim kiem nhan vien theo ten va phong ban va in ra man hinh...............| ");
            System.out.println("| 4. Xuat ra danh sach toan bo giang vien va sap xep theo thu tu theo ten ....| ");
            System.out.println("| 5. Ghi danh sach can bo Nhan vien ra file dang text.........................| ");
            System.out.println("| 6. Thoat chuong trinh ......................................................| ");
            System.out.println("|_____________________________________________________________________________|");
            System.out.print("Xin moi ban nhap lua chon: ");
            luaChon = Utility.nhapInt();
            System.out.println("");
            switch (luaChon) {
                case 1:
                    nhapThongTinGiangVien();

                    break;
                case 2:
                    nhapThongTinNhanVien();

                    break;
                case 3:

                    timNhanVien();

                    break;
                case 4:
                    hienThiGiangVien();
                    break;
                case 5:
                    ghiNhanVien();
                    break;
                case 6:
                    System.out.println("----------SEE YOU AGAIN!----------");
                    break;
            }
        } while (luaChon != 6);

    }

}
