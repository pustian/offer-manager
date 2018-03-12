package tian.pusen.offer.web;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import tian.pusen.offer.web.v1.CustomerController;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 * Date: 2017/12/5 23:06
 *
 * @author tianpusen
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Profile("dev")
@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerControllerTest {
    private MockMvc mockMvc;
    @Autowired
    CustomerController customerController;

    @Before
    public void setup(){
        //MockMvcBuilders使用构建MockMvc对象   （项目拦截器有效）
        // mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
        //单个类  拦截器无效
        mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();
    }


}
