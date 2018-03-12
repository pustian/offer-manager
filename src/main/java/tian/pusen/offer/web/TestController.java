package tian.pusen.offer.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tian.pusen.offer.entity.Test;
import tian.pusen.offer.service.ITestService;

import java.util.Date;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * Date: 2017年8月29日 上午11:08:01
 *
 * @author tianpusen
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@RestController
public class TestController {
    private final static Logger logger = LoggerFactory.getLogger(TestController.class);
    @Autowired
    ITestService testService;

    @Value("${wang.pingchuan.welcome}")
    private String welcome;

//    @ApiIgnore
    @RequestMapping(value="/test", method= RequestMethod.GET)
    public String test(@RequestParam(value="name", defaultValue="World")String name) {
        boolean bool = false;
        Test test = new Test();
        test.setGmtCreate(new Date());
        test.setGmtModified(new Date(0L) );
        bool = testService.insert(test);
        logger.info("hello:[{}]. Insert new record into the table test of the database:{}", name, bool);
        return welcome+" ["+name+"]. Database insert check: " + bool;
    }
}
