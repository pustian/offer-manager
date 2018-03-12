package tian.pusen.offer.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.junit4.SpringRunner;
import tian.pusen.offer.service.ITestService;

import java.util.Date;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 * Date: 2017/12/3 11:36
 *
 * @author tianpusen
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Profile("dev")
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestServiceTest {
    ITestService testService;
    @Autowired
    public void setTestService(ITestService testService) {
        this.testService = testService;
    }

    @Test
    public void testInsert() {
        long current = System.currentTimeMillis();
        tian.pusen.offer.entity.Test test = new tian.pusen.offer.entity.Test();
        test.setGmtCreate(new Date(current));
        test.setGmtModified(new Date(current));
        boolean insertBool = testService.insert(test);
        Assert.assertTrue(insertBool);
    }
}
