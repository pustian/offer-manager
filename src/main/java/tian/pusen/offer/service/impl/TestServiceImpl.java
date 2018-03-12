package tian.pusen.offer.service.impl;

import tian.pusen.offer.entity.Test;
import tian.pusen.offer.mapper.TestMapper;
import tian.pusen.offer.service.ITestService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 田圃森
 * @since 2017-12-02
 */
@Service
public class TestServiceImpl extends ServiceImpl<TestMapper, Test> implements ITestService {
	
}
