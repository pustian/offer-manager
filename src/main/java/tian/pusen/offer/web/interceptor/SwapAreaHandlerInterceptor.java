/**
 * Copyright (C), 2016-2017, 上海友米互联网科技有限公司
 */
package tian.pusen.offer.web.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import tian.pusen.offer.SwapAreaUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * Date: 2017年8月29日 上午11:11:26
 *
 * @author tianpusen
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Component
public class SwapAreaHandlerInterceptor implements HandlerInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(SwapAreaHandlerInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        SwapAreaUtils.init();
//        getRequestURL方法返回客户端发出请求时的完整URL。
//        getRequestURI方法返回请求行中的资源名部分。
//        getQueryString 方法返回请求行中的参数部分。
//        getRemoteAddr方法返回发出请求的客户机的IP地址
//        getRemoteHost方法返回发出请求的客户机的完整主机名
//        getRemotePort方法返回客户机所使用的网络端口号
//        getLocalAddr方法返回WEB服务器的IP地址。
//        getParameter(name):获取指定名称的参数值。这是最为常用的方法之一。
//        getParameterValues（String name）:获取指定名称参数的所有值数组。它适用于一个参数名对应多个值的情况。如页面表单中的复选框，多选列表提交的值。
//        getParameterNames():返回一个包含请求消息中的所有参数名的Enumeration对象。通过遍历这个Enumeration对象，就可以获取请求消息中所有的参数名。
//        getParameterMap():返回一个保存了请求消息中的所有参数名和值的Map对象。
        String uri = request.getRequestURI();
        String requestIP = request.getRemoteAddr();
        SwapAreaUtils.setRequestUri(uri);
        SwapAreaUtils.setRequestIp(requestIP);
        logger.debug("init the SwapAreaUtils");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        SwapAreaUtils.destory();
    }
}
