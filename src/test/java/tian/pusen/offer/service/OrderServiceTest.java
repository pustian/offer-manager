package tian.pusen.offer.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.junit4.SpringRunner;
import tian.pusen.offer.entity.CustomerOrder;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 * Date: 2017/12/9 20:58
 *
 * @author tianpusen
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Profile("dev")
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceTest {
    @Autowired
    ICustomerOrderService orderService;

    @Test
    public void test() {
        String offerId = "XXXX";
        CustomerOrder clauseObj = new CustomerOrder();
        clauseObj.setOfferId(offerId);
        EntityWrapper<CustomerOrder> clause = new EntityWrapper<>(clauseObj);
        int current = 0;
        int size  = 2;
        Page<CustomerOrder> pageClause = new Page<>(current, size, "id");
        Page<CustomerOrder> orderPage = orderService.selectPage(pageClause, clause);

    }

}
