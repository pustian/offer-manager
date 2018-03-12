/**
 * Copyright (C), 2016-2017, 上海友米互联网科技有限公司
 */
package tian.pusen.offer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 * <p>
 * Date: 2017年8月29日 上午11:06:31
 *
 * @author tianpusen
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class SwapAreaUtils {
    private static final Logger logger = LoggerFactory.getLogger(SwapAreaUtils.class);

    public static ThreadLocal<Map<String, Object>> SWAP_AREA = new ThreadLocal<>();

    public static final String REQUEST_URI = "uri";
    public static final String REQUEST_IP = "requestIP";
    public static final String REQUEST_HEAD = "reqHeader";

    // 在SwapAreaHandlerInterceptor中初始化 和销毁
    public static void init() {
        logger.debug("Init swaparea to store request info");
        Map<String, Object> swapArea = SWAP_AREA.get();
        if (swapArea == null) {
            swapArea = new ConcurrentHashMap<String, Object>();
            SWAP_AREA.set(swapArea);
        }
    }

    public static void destory() {
        Map<String, Object> swapArea = SWAP_AREA.get();
        if (swapArea != null) {
            logger.debug("Destory SwapAreaUtils to store request info.{}", swapArea);
            swapArea.clear();
        }
    }

    public static void setValue(String key, Object value) {
        Map<String, Object> swapArea = SWAP_AREA.get();
        if (null == swapArea) {
            init();
            swapArea = SWAP_AREA.get();
        }
        swapArea.put(key, value);
    }

    public static Object getValue(String key) {
        Map<String, Object> map = SWAP_AREA.get();
        return map.get(key);
    }

    public static void setRequestUri(String uri) {
        Map<String, Object> swapArea = SWAP_AREA.get();
        if (null == swapArea) {
            init();
            swapArea = SWAP_AREA.get();
        }
        swapArea.put(REQUEST_URI, uri);
    }

    public static void setRequestIp(String requestIp) {
        Map<String, Object> swapArea = SWAP_AREA.get();
        if (null == swapArea) {
            init();
            swapArea = SWAP_AREA.get();
        }
        swapArea.put(REQUEST_IP, requestIp);
    }
//    public static void setReqHeader(ReqHeader reqHeader) {
//        Map<String, Object> swapArea = SWAP_AREA.get();
//        if(null == swapArea) {
//            init();
//            swapArea = SWAP_AREA.get();
//        }
//        swapArea.put(REQUEST_HEAD, reqHeader);
//    }

    public static String getRequestUri() {
        Map<String, Object> map = SWAP_AREA.get();
        return (String) map.get(REQUEST_URI);
    }

    public static String getRequsetIP() {
        Map<String, Object> map = SWAP_AREA.get();
        return (String) map.get(REQUEST_IP);
    }
//    public static ReqHeader getReqHeader() {
//        Map<String, Object> map = SWAP_AREA.get();
//        return (ReqHeader) map.get(REQUEST_HEAD);
//    }
}
