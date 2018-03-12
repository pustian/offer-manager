/**
 * Copyright (C), 2016-2017, 上海友米互联网科技有限公司
 */
package tian.pusen.offer.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import tian.pusen.offer.web.interceptor.ElapseHandlerInterceptor;
import tian.pusen.offer.web.interceptor.SwapAreaHandlerInterceptor;


/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * Date: 2017年8月29日 上午11:11:56
 *
 * @author tianpusen
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Configuration
public class WebApplicationConfig extends WebMvcConfigurerAdapter {
    @Autowired
    ElapseHandlerInterceptor elapseHandlerInterceptor;
    @Autowired
    SwapAreaHandlerInterceptor swapAreaHandlerInterceptor;

    // 默认拦截器
    // HandlerInterceptorAdapter
    // AbstractHandlerMapping
    // UserRoleAuthorizationInterceptor
    // LocaleChangeInterceptor
    // ThemeChangeInterceptor
    /// registry.addInterceptor可以通过此方法添加拦截器, 可以是spring提供的或者自己添加的
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 添加自定义记录日志的拦截器
        registry.addInterceptor(elapseHandlerInterceptor);
        registry.addInterceptor(swapAreaHandlerInterceptor);
    }

}
