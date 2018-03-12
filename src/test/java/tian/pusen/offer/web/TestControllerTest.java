package tian.pusen.offer.web;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.servlet.http.HttpServletResponse;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 * Date: 2017/12/3 11:47
 *
 * @author tianpusen
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Profile("dev")
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestControllerTest {
    private MockMvc mockMvc;
    @Autowired
    TestController testController;

    @Before
    public void setup(){
        //MockMvcBuilders使用构建MockMvc对象   （项目拦截器有效）
        // mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
        //单个类  拦截器无效
        mockMvc = MockMvcBuilders.standaloneSetup(testController).build();
    }

    @Test
    public void test() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/test");
        MvcResult mvcResult = mockMvc.perform(request).andReturn();
        int status = mvcResult.getResponse().getStatus();
        String responseContext = mvcResult.getResponse().getContentAsString();
        Assert.assertTrue("正常访问", HttpStatus.valueOf(status) == HttpStatus.OK);
//        Assert.assertTrue("访问异常", HttpStatus.valueOf(status) != HttpStatus.OK);
        System.out.println(status);
        System.out.println(responseContext);
    }
//                .contentType(MediaType.)
//        //1. get 以下user列表，应该为空》
//        //1、构建一个get请求.
//        request = MockMvcRequestBuilders.get("/test");
//        mvc.perform(request)
//                .andExpect(status().isOk())
//                .andExpect(content().string("[]"))
//        ;
//        System.out.println("UserControllerTest.testUserController().get");
//
//        // 2、post提交一个user
//        request = MockMvcRequestBuilders.post("/users")
//                .param("id","1")
//                .param("name","林峰")
//                .param("age","20")
//        ;
//        mvc.perform(request).andExpect(status().isOk()).andExpect(content().string("success"));
//        // 3、get获取user列表，应该有刚才插入的数据
//        request = MockMvcRequestBuilders.get("/users");
//        mvc.perform(request).andExpect(status().isOk()).andExpect(content().string("[{\"id\":1,\"name\":\"林峰\",\"age\":20}]"));
//
//        // 4、put修改id为1的user
//        request = MockMvcRequestBuilders.put("/users/1").param("name", "林则徐")
//                .param("age", "30");
//        mvc.perform(request).andExpect(content().string("success"));

}
