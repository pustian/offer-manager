package tian.pusen.offer.mapper;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.junit4.SpringRunner;
import tian.pusen.offer.entity.AreaCode;

import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 * Date: 2017/12/5 22:35
 *
 * @author tianpusen
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Profile("dev")
@RunWith(SpringRunner.class)
@SpringBootTest
public class AreaCodeMapperTest {
    @Autowired
    AreaCodeMapper areaCodeMapper;
    @Test
    public void test() {
        String desc = "大";
        List<AreaCode> areaCodeList = areaCodeMapper.getByDescription(desc);
        Assert.assertTrue(areaCodeList != null && areaCodeList.size() > 0);
        for(AreaCode areaCode: areaCodeList) {
            System.out.println(areaCode.getDescription());
            Assert.assertTrue(areaCode.getDescription().contains(desc));
        }
    }

}
