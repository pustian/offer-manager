package tian.pusen.offer.mapper;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 * Date: 2017/12/5 22:32
 *
 * @author tianpusen
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Profile("dev")
@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerMapperTest {
    @Autowired
    CustomerMapper customerMapper;
    @Test
    public void test() {
        String partname = "田";
        List<String> nameList = customerMapper.getNameList(partname);
        Assert.assertTrue(nameList != null && nameList.size() > 0);
        for(String name: nameList) {
            System.out.println(name);
            Assert.assertTrue(name.contains(partname));
        }
    }
}
