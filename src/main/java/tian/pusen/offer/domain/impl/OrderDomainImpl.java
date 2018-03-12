package tian.pusen.offer.domain.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.CharUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tian.pusen.offer.domain.IOrderDomain;
import tian.pusen.offer.entity.Customer;
import tian.pusen.offer.entity.CustomerOrder;
import tian.pusen.offer.service.ICustomerOrderService;
import tian.pusen.offer.web.vo.order.OrderReq;
import tian.pusen.offer.web.vo.order.OrderResp;
import tian.pusen.offer.web.vo.page.PageReq;
import tian.pusen.offer.web.vo.page.PageResp;

import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 * Date: 2017/12/9 15:23
 *
 * @author tianpusen
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service
public class OrderDomainImpl implements IOrderDomain{
    private static final Logger logger = LoggerFactory.getLogger(OrderDomainImpl.class);
    @Autowired
    ICustomerOrderService orderService;

    @Override
    public boolean insertOrder(OrderReq orderReq) {
        boolean bool = false;
        CustomerOrder customerOrder = composeOrder(orderReq);
        if(customerOrder != null ) {
            String orderId = UUID.randomUUID().toString().replace("-", "");
            customerOrder.setOrderId(orderId);
            customerOrder.setGmtCreate(new Date());
            customerOrder.setGmtModified(new Date());
            bool = orderService.insert(customerOrder);
        }
        logger.debug("Inserted customerOrder-{}:{}",customerOrder, bool);
        return bool;
    }

    @Override
    public boolean updateOrder(OrderReq orderReq) {
        boolean bool = false;
        CustomerOrder customerOrder = composeOrder(orderReq);
        String orderId = orderReq.getOrderId();
        if(customerOrder != null && StringUtils.isNotBlank(orderId)) {
            customerOrder .setGmtModified(new Date());
            bool = orderService.updateByOrderId(customerOrder, orderId);
        }
        logger.debug("Update customer-{} with {}, the result:{}",customerOrder, orderReq, bool);
        return bool;
    }

    private final static CustomerOrder composeOrder(OrderReq orderReq) {
        CustomerOrder customerOrder = null;
        if(orderReq != null) {
            customerOrder = new CustomerOrder();
            try {
                BeanUtils.copyProperties(customerOrder, orderReq);
            } catch (InvocationTargetException | IllegalAccessException e) {
                logger.error("赋值时异常", e);
            }
            logger.debug("The customer order will be assigned {}", customerOrder);
        }
        return customerOrder;
    }
    @Override
    public OrderResp getOrderByOrderId(String orderId) {
        OrderResp orderResp = null;
        if(StringUtils.isNotBlank(orderId)) {
            CustomerOrder customerOrder = orderService.selectOneByOrderId(orderId);
            logger.debug("Get a customerOrder {} with orderId {}", customerOrder, orderId);
            orderResp = composeOrderResp(customerOrder);
        }
        logger.debug("Get a orderResp:{}", orderResp);
        return  orderResp;
    }

    private static final OrderResp composeOrderResp(CustomerOrder customerOrder) {
        SimpleDateFormat sdf  = new SimpleDateFormat("yyyyMMddHHmmss");
        OrderResp orderResp = null;
        if(customerOrder != null ) {
            orderResp = new OrderResp();
            try {
                BeanUtils.copyProperties(orderResp, customerOrder);
                String gmtCreate = sdf.format(customerOrder.getGmtCreate());
                orderResp.setGmtCreate(gmtCreate);
                String gmtModified = sdf.format(customerOrder.getGmtModified());
                orderResp.setGmtModified(gmtModified);
            } catch (IllegalAccessException  | InvocationTargetException e) {
                logger.error("赋值时异常", e);
            }
        }
        return orderResp;
    }

    @Override
    public PageResp<OrderResp> getOrderByOfferId(PageReq<OrderReq> orderReqPageReq) {
        PageResp<OrderResp> orderRespPageResp = null;
        if(orderReqPageReq!= null) {
            int currentPage = Integer.parseInt(orderReqPageReq.getPageIndex());
            int size = Integer.parseInt(orderReqPageReq.getPageSize() );
            OrderReq orderReq = orderReqPageReq.getT();
            CustomerOrder customerOrder = composeOrder(orderReq);
            Page<CustomerOrder> pageClause = new Page<CustomerOrder>();
            EntityWrapper<CustomerOrder> clause = new EntityWrapper<>(customerOrder);
            Page<CustomerOrder> pageResult = orderService.selectPage(pageClause, clause);
            orderRespPageResp = composePageOfferResp(pageResult);
        }
        return orderRespPageResp;
    }
    private final static PageResp<OrderResp> composePageOfferResp(Page<CustomerOrder> orderPage) {
        PageResp<OrderResp> orderRespPageResp = null;
        if(orderPage != null) {
            orderRespPageResp = new PageResp<>();
            orderRespPageResp.setPageIndex("" + orderPage.getCurrent());
            orderRespPageResp.setRecordTotal("" + orderPage.getTotal());
            List<CustomerOrder> customerOrderList = orderPage.getRecords();
            if(customerOrderList != null ) {
                orderRespPageResp.setPageSize("" + customerOrderList.size());
                orderRespPageResp.setPageTotal("" + (orderPage.getTotal() / orderPage.getSize() ) );
                List<OrderResp> orderRespList = new ArrayList<>();
                for(CustomerOrder customerOrder : customerOrderList) {
                    OrderResp orderResp = composeOrderResp(customerOrder);
                    orderRespList.add(orderResp);
                }
                orderRespPageResp.setRecords(orderRespList);
            }
        }
        return orderRespPageResp;
    }

    @Override
    public boolean deleteOrder(String orderId) {
        boolean bool = false;
        if (StringUtils.isNotBlank(orderId)) {
            bool = orderService.deleteByOrderId(orderId);
        }
        logger.debug("Update customerOrder status with {} to delete it logically. Result:{} ", orderId, bool);
        return bool;
    }
}
