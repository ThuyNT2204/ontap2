import org.example.entity.SinhVien;
import org.example.service.SinhVienService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SinhVienTest {
    SinhVienService service;
    @BeforeEach
    public void setUp() {
        service = new SinhVienService();
    }
    @Test
    public void testSinhVienMin() {
        SinhVien sv = new SinhVien("PH1","THUY",22,9.5f,4,"PTPM");
        service.addSinhVien(sv);
        SinhVien sv1 = new SinhVien("PH1","THUY",22,0f,4,"PTPM");
        service.update(sv1);
        SinhVien result = service.getSinhVien("PH1");
        Assertions.assertEquals(0f,result.getDiemTrungBinh());
    }
    @Test
    public void testSinhVienMinCong1() {
        SinhVien sv = new SinhVien("PH1","THUY",22,9.5f,4,"PTPM");
        service.addSinhVien(sv);
        SinhVien sv1 = new SinhVien("PH1","THUY",22,1f,4,"PTPM");
        service.update(sv1);
        SinhVien result = service.getSinhVien("PH1");
        Assertions.assertEquals(1f,result.getDiemTrungBinh());
    }
    @Test
    public void testSinhVienMax() {
        SinhVien sv = new SinhVien("PH1","THUY",22,9.5f,4,"PTPM");
        service.addSinhVien(sv);
        SinhVien sv1 = new SinhVien("PH1","THUY",22,10f,4,"PTPM");
        service.update(sv1);
        SinhVien result = service.getSinhVien("PH1");
        Assertions.assertEquals(10f,result.getDiemTrungBinh());
    }
    @Test
    public void testSinhVienMaxTru1() {
        SinhVien sv = new SinhVien("PH1","THUY",22,9.5f,4,"PTPM");
        service.addSinhVien(sv);
        SinhVien sv1 = new SinhVien("PH1","THUY",22,9f,4,"PTPM");
        service.update(sv1);
        SinhVien result = service.getSinhVien("PH1");
        Assertions.assertEquals(9f,result.getDiemTrungBinh());
    }
    @Test
    public void testSinhVienMinTru1() {
        SinhVien sv = new SinhVien("PH1","THUY",22,-1f,4,"PTPM");
        Assertions.assertThrows(IllegalArgumentException.class, () -> service.update(sv));
    }
    @Test
    public void testSinhVienMaxCong1() {
        SinhVien sv = new SinhVien("PH1","THUY",22,11f,4,"PTPM");
        Assertions.assertThrows(IllegalArgumentException.class, () -> service.update(sv));
    }
}
