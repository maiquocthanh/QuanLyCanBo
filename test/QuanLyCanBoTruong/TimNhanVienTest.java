package QuanLyCanBoTruong;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import CanBoTruong.NhanVien;
import java.util.ArrayList;

public class TimNhanVienTest {

    /**
     * Test of timNhanVien method, of class QuanLyCanBo.
     */
    @Test
    public void testTimNhanVien() {
        System.out.println("Test timNhanVien");
        NhanVien nv = new NhanVien();
        NhanVien[] danhSachNV = new NhanVien[3];

        nv.setHoTen("Thanh");
        nv.setPhongBan("CNTT");
        danhSachNV[0] = nv;
        nv = new NhanVien();
        nv.setHoTen("Thanh");
        nv.setPhongBan("CNTT");
        danhSachNV[1] = nv;
        nv = new NhanVien();
        nv.setHoTen("Hai");
        nv.setPhongBan("CNTT");
        danhSachNV[2] = nv;
        String tenNV = "Thanh";
        String tenPB = "CNTT";

        ArrayList<NhanVien> kq = QuanLyCanBo.timnhanvien(danhSachNV, tenNV, tenPB);
        assertEquals(kq.size(), 2);

    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

}
