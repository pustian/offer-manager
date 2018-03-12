package tian.pusen.offer.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import tian.pusen.offer.entity.CustomerOrder;
import tian.pusen.offer.mapper.CustomerOrderMapper;
import tian.pusen.offer.service.ICustomerOrderService;

import java.util.Date;

/**
 * <p>
 * 订单信息 服务实现类
 * </p>
 *
 * @author 田圃森
 * @since 2017-12-02
 */
@Service
public class CustomerOrderServiceImpl extends ServiceImpl<CustomerOrderMapper, CustomerOrder> implements ICustomerOrderService {

    @Override
    public CustomerOrder selectOneByOrderId(String orderId) {
        EntityWrapper<CustomerOrder> ew = new EntityWrapper<>();
        ew.eq("order_id",orderId);
        CustomerOrder customerOrder = selectOne(ew);
        return customerOrder;
    }

    @Override
    public boolean updateByOrderId(CustomerOrder customerOrder, String orderId) {
        CustomerOrder whereOrderId = new CustomerOrder ();
        whereOrderId.setOrderId(orderId);
        EntityWrapper<CustomerOrder> clause = new EntityWrapper<CustomerOrder>();
        clause.setEntity(whereOrderId);
        boolean bool = update(customerOrder, clause);
        return bool;
    }

    @Override
    public boolean deleteByOrderId(String orderId) {
        CustomerOrder whereOrderId = new CustomerOrder ();
        whereOrderId.setOrderId(orderId);
        EntityWrapper<CustomerOrder> clause = new EntityWrapper<CustomerOrder>();
        clause.setEntity(whereOrderId);
        CustomerOrder updateCustomerOrder = new CustomerOrder();
        updateCustomerOrder.setIsDeleted(1);
        updateCustomerOrder.setGmtModified(new Date());
        boolean bool = update(updateCustomerOrder, clause);
        return bool;
    }
}
