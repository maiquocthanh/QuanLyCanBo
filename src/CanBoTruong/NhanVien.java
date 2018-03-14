package CanBoTruong;

import QuanLyCanBoTruong.Utility;

public class NhanVien extends LopNguoi implements ILuong {

    private String phongBan;
    private String chucVu;
    private float soNgayCong;

    public String getPhongBan() {
        return phongBan;
    }

    public void setPhongBan(String phongBan) {
        this.phongBan = phongBan;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public float getSoNgayCong() {
        return soNgayCong;
    }

    public void setSoNgayCong(float soNgayCong) {
        this.soNgayCong = soNgayCong;
    }

    public NhanVien() {

    }

    public NhanVien(String hoTen, float heSoLuong, String phongBan, String chucVu, float soNgayCong) {
        super(hoTen, heSoLuong);
        this.phongBan = phongBan;
        this.chucVu = chucVu;
        this.soNgayCong = soNgayCong;
    }

    @Override
    public void nhapThongTin() {
        System.out.print("Nhap ho va ten: ");
        this.setHoTen(Utility.nhapString());
        System.out.print("Nhap he so luong: ");
        this.setHeSoLuong(Utility.nhapFloat());
        System.out.print("Nhap trinh do : ");
        this.setChucVu(Utility.nhapString());
        System.out.print("Nhap phong ban : ");
        this.setPhongBan(Utility.nhapString());
        System.out.print("Nhap so ngay cong trong thang : ");
        this.setSoNgayCong(Utility.nhapFloat());

    }

    @Override
    public void hienThi() {
        System.out.printf("%-20s%-10s%-10s\t%-10.1f%-10.1f%-10d%-10.1f\n",
                this.getHoTen(), this.getPhongBan(), this.getChucVu(), 
                this.getHeSoLuong(), soNgayCong, this.tinhPhuCap(), this.tinhLuong());

    }

    @Override
    public int tinhPhuCap() {
        int phuCap = 0;
        if (this.chucVu.equalsIgnoreCase("Truong phong")) {
            phuCap = 2000;
        }
        if (this.chucVu.equalsIgnoreCase("Pho phong")) {
            phuCap = 1000;
        }
        if (this.chucVu.equalsIgnoreCase("Nhan vien")) {
            phuCap = 500;
        }

        return phuCap;
    }

    @Override
    public float tinhLuong() {
        return this.getHeSoLuong() * 730 + this.tinhPhuCap() + this.getSoNgayCong() * 30;
    }

}
