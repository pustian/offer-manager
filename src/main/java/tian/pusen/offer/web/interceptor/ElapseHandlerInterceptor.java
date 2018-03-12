/**
 * Copyright (C), 2016-2017, 上海友米互联网科技有限公司
 */
package tian.pusen.offer.web.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * Date: 2017年8月29日 上午11:11:13
 *
 * @author tianpusen
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Component
public class ElapseHandlerInterceptor implements HandlerInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(ElapseHandlerInterceptor.class);

    ThreadLocal<Long> startTime = new ThreadLocal<Long>();
    // 1. preHandle 方法会在请求处理前被调用。这个方法返回boolean值，如果返回true则继续往下执行，如果返回false则中断。
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        long start = System.currentTimeMillis();
        startTime.set(start);
        showParams(request);
        logger.debug("Request url:{} startTime:{}", request.getRequestURL(), start);
        return true;
    }

    // 2. postHandle 方法会在请求处理后，继续调用。preHandler返回true执行。所以此处必用在日志操作
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
    }

    // 3. afterCompletion 方法会在视图渲染之后调用。preHandler返回true/false都执行
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                Exception ex) throws Exception {
        long end = System.currentTimeMillis();
        long start = startTime.get();
        long elapse = end - start;
        logger.debug("Request url:{} endTime:{} elapse:{}", request.getRequestURL(), end, elapse);
    }

    private static void showParams(HttpServletRequest request) {
        logger.trace("---------- request paramters begin ----------");
        Map map = new HashMap();
        Enumeration paramNames = request.getParameterNames();
        while (paramNames.hasMoreElements()) {
            String paramName = (String) paramNames.nextElement();

            String[] paramValues = request.getParameterValues(paramName);
            if (paramValues.length == 1) {
                String paramValue = paramValues[0];
                if (paramValue.length() != 0) {
                    map.put(paramName, paramValue);
                }
            }
        }

        Set<Map.Entry<String, String>> set = map.entrySet();
        for (Map.Entry entry : set) {
            logger.trace(entry.getKey() + ":" + entry.getValue());
        }
        logger.trace("---------- request paramters end ----------");
    }
}
