import com.hs.bootmq.BootmqMain;
import com.hs.bootmq.config.QueueProduce;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;

/**
 * @Author: yc
 * @Description:
 * @Date: Create in 16:49 2020/12/23
 */
@SpringBootTest(classes = BootmqMain.class)
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class TestMq {
    @Resource
    private QueueProduce queueProduce;
    @Test
    public void testSend() throws Exception{
        queueProduce.produceMsg();
    }
}
