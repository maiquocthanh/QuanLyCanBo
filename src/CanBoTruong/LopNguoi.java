package CanBoTruong;

public abstract class LopNguoi {

    private String hoTen;
    private float heSoLuong;

    public String getHoTen() {
        return hoTen;
    }

    public String getTen() {
        String[] arr = hoTen.split(" ");
        return arr[arr.length - 1];
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public float getHeSoLuong() {
        return heSoLuong;
    }

    public void setHeSoLuong(float heSoLuong) {
        this.heSoLuong = heSoLuong;
    }

    public LopNguoi() {

    }

    public LopNguoi(String hoTen, float heSoLuong) {
        this.hoTen = hoTen;
        this.heSoLuong = heSoLuong;
    }

    public abstract void nhapThongTin();

    public abstract void hienThi();

}
