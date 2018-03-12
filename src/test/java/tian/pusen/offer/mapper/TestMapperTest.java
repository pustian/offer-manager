package tian.pusen.offer.mapper;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.junit4.SpringRunner;
import tian.pusen.offer.mapper.TestMapper;

import java.util.Date;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 * Date: 2017/12/3 11:31
 *
 * @author tianpusen
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Profile("dev")
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestMapperTest {
    @Autowired
    TestMapper testMapper;
    @Test
    public void testInsert() {
        long currentTime = System.currentTimeMillis();
        tian.pusen.offer.entity.Test t = new tian.pusen.offer.entity.Test();
        t.setGmtCreate(new Date(currentTime));
        t.setGmtModified(new Date(currentTime));
        Integer integer = testMapper.insert(t);
        Assert.assertTrue(integer > 0 );
    }
}
