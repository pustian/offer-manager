package tian.pusen.offer.domain;

import tian.pusen.offer.web.vo.order.OrderReq;
import tian.pusen.offer.web.vo.order.OrderResp;
import tian.pusen.offer.web.vo.page.PageReq;
import tian.pusen.offer.web.vo.page.PageResp;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 * Date: 2017/12/9 15:23
 *
 * @author tianpusen
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface IOrderDomain {
    boolean insertOrder(OrderReq orderReq);
    boolean updateOrder(OrderReq orderReq);
    OrderResp getOrderByOrderId(String orderId);
    PageResp<OrderResp> getOrderByOfferId(PageReq<OrderReq> orderReqPageReq);
    boolean deleteOrder(String orderId);
}
