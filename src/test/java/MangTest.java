import org.example.entity.Mang;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MangTest {
    Mang entity=new Mang();
    @Test
    public void MangTestBienMin(){
        int mongMuon=1006;
        int thucTe=entity.tinhTong(new int[] {1,2,3,1000});
        Assertions.assertEquals(mongMuon,thucTe);
    }
    @Test
    public void MangTestBienMinCong1(){
        int mongMuon=1007;
        int thucTe=entity.tinhTong(new int[] {2,2,3,1000});
        Assertions.assertEquals(mongMuon,thucTe);
    }
    @Test
    public void MangTestBienMax(){
        int mongMuon=1003;
        int thucTe=entity.tinhTong(new int[] {1,2,1000});
        Assertions.assertEquals(mongMuon,thucTe);
    }
    @Test
    public void MangTestBienMaxTru1(){
        int mongMuon=1005;
        int thucTe=entity.tinhTong(new int[] {1,2,3,999});
        Assertions.assertEquals(mongMuon,thucTe);
    }
    @Test
    public void MangTestBienMaxCong1(){
        Assertions.assertThrows(IllegalArgumentException.class,
                ()->entity.tinhTong(new int[] {1,2,3,1001}));
    }
    @Test
    public void MangTestBienMinTru1(){
        Assertions.assertThrows(IllegalArgumentException.class,
                ()->entity.tinhTong(new int[] {0,1,2,3,1000}));
    }

}
