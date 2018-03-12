package tian.pusen.offer.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.junit4.SpringRunner;
import tian.pusen.offer.entity.Customer;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 * Date: 2017/12/4 23:14
 *
 * @author tianpusen
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Profile("dev")
@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerServiceTest {
    @Autowired
    ICustomerService customerService;

    @Test
    public void selectOneByCustomerId() {
        String customerId = "string";
        Customer customer = customerService.selectOneByCustomerId(customerId);
        Assert.assertTrue(customer != null && customerId.equals(customer.getCustomerId()));
        System.out.println(customer);
    }

    @Test
    public void selectOneByNameTest0() {
        String name = "田圃森";
        Customer customer = customerService.selectOneByName(name);
        Assert.assertTrue(customer!= null && name.equals(customer.getName()));
        System.out.println(customer);
    }

    @Test
    public void selectOneByNameTest1() {
        String name = "田";
        Customer customer = customerService.selectOneByName(name);
        Assert.assertTrue(customer == null );
        System.out.println(customer);
    }

    @Test
    public void test() {
        String name = "abc";
        String customerId = "aaa";
        Customer condition = new Customer();
        condition.setName("ABC");
        condition.setCustomerId("AAA");
        condition.setNameEn("---");
        EntityWrapper<Customer> clause = new EntityWrapper<Customer>(condition);
//        clause.where("name={0}", name);
        clause.eq("name", name);
        clause.where("customer_id={0}", customerId);
        Customer customer = customerService.selectOne(clause);
        System.out.println("customer:"+customer);
        Assert.assertTrue(customer != null);
    }
}
