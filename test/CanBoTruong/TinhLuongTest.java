package CanBoTruong;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import QuanLyCanBoTruong.QuanLyCanBo;

public class TinhLuongTest {

    /**
     * Test of tinhLuong method, of class NhanVien.
     */
    @Test
    public void testTinhLuong() {
        System.out.println("Test tinhLuong");
        NhanVien nv = new NhanVien();
        nv.setChucVu("Pho Phong");
        nv.setHeSoLuong(1);
        nv.setSoNgayCong(1);
        float expResult = 1760.0F;
        float result = nv.tinhLuong();
        assertEquals(expResult, result, 0.0);

    }

    /**
     * Test of tinhPhuCap method, of class NhanVien.
     */
    @Test
    public void testTinhPhuCap() {
        System.out.println("Test tinhPhuCap");
        NhanVien nv = new NhanVien();
        nv.setChucVu("Pho Phong");
        int expResult = 1000;
        int result = nv.tinhPhuCap();
        assertEquals(expResult, result);

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
