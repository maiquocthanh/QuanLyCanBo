package CanBoTruong;

import QuanLyCanBoTruong.Utility;

 public class GiangVien extends LopNguoi implements ILuong {

    private String khoa;
    private String trinhDo;
    private float soTietDay;

    public String getKhoa() {
        return khoa;
    }

    public void setKhoa(String khoa) {
        this.khoa = khoa;
    }

    public String getTrinhDo() {
        return trinhDo;
    }

    public void setTrinhDo(String trinhDo) {
        this.trinhDo = trinhDo;
    }

    public float getSoTietDay() {
        return soTietDay;
    }

    public void setSoTietDay(float soTietDay) {
        this.soTietDay = soTietDay;
    }

    public GiangVien() {

    }

    public GiangVien(String hoTen, float heSoLuong, String khoa, String trinhDo, float soTietDay) {
        super(hoTen, heSoLuong);
        this.khoa = khoa;
        this.trinhDo = trinhDo;
        this.soTietDay = soTietDay;

    }

    @Override
    public void nhapThongTin() {
        System.out.print("Nhap ho va ten: ");
        this.setHoTen(Utility.nhapString());
        System.out.print("Nhap he so luong: ");
        this.setHeSoLuong(Utility.nhapFloat());
        System.out.print("Nhap trinh do : ");
        this.setTrinhDo(Utility.nhapString());
        System.out.print("Nhap khoa : ");
        this.setKhoa(Utility.nhapString());
        System.out.print("Nhap so tiet day trong thang : ");
        this.setSoTietDay(Utility.nhapFloat());

    }

    @Override
    public void hienThi() {
        System.out.printf("%-20s%-10s%-10s\t%-10.1f%-10.1f%-10d%-10.1f\n", this.getHoTen(), this.getKhoa(), this.getTrinhDo(), this.getHeSoLuong(), this.getSoTietDay(), this.tinhPhuCap(), this.tinhLuong());

    }

    @Override
    public int tinhPhuCap() {
        int phuCap = 0;
        if (this.trinhDo.equalsIgnoreCase("Tien si")) {
            phuCap = 1000;
        }
        if (this.trinhDo.equalsIgnoreCase("Thac si")) {
            phuCap = 500;
        }
        if (this.trinhDo.equalsIgnoreCase("Cu nhan")) {
            phuCap = 300;
        }

        return phuCap;
    }

    @Override
    public float tinhLuong() {
        return this.getHeSoLuong() * 730 + this.tinhPhuCap() + this.getSoTietDay() * 45;
    }

}
