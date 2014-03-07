import com.cl.xcf.util.IDCreater;
import org.junit.Test;

/**
 * CREATE BY INTELLIJ IDEA
 * user: chl
 * Date: 14-2-18 上午9:45
 */
public class IDCreaterTest {

    @Test
    public void test(){
        String id = new IDCreater().getAutoIncID("test_id");
        System.out.println("id:"+id);
    }
}
