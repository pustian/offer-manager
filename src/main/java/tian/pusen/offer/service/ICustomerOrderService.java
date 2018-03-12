package tian.pusen.offer.service;

import com.baomidou.mybatisplus.service.IService;
import tian.pusen.offer.entity.CustomerOrder;

/**
 * <p>
 * 订单信息 服务类
 * </p>
 *
 * @author 田圃森
 * @since 2017-12-02
 */
public interface ICustomerOrderService extends IService<CustomerOrder> {
    CustomerOrder selectOneByOrderId(String orderId);
    boolean updateByOrderId(CustomerOrder customerOrder, String orderId);
    boolean deleteByOrderId(String orderId);
}
