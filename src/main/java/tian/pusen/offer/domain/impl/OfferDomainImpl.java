package tian.pusen.offer.domain.impl;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tian.pusen.offer.domain.IOfferDomain;
import tian.pusen.offer.domain.IOrderDomain;
import tian.pusen.offer.entity.CustomerOffer;
import tian.pusen.offer.entity.CustomerOrder;
import tian.pusen.offer.service.ICustomerOfferService;
import tian.pusen.offer.service.ICustomerOrderService;
import tian.pusen.offer.web.vo.offer.OfferReq;
import tian.pusen.offer.web.vo.offer.OfferResp;
import tian.pusen.offer.web.vo.order.OrderReq;
import tian.pusen.offer.web.vo.order.OrderResp;
import tian.pusen.offer.web.vo.page.PageReq;
import tian.pusen.offer.web.vo.page.PageResp;

import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 * Date: 2017/12/8 22:48
 *
 * @author tianpusen
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service
public class OfferDomainImpl implements IOfferDomain {
    private static final Logger logger = LoggerFactory.getLogger(OfferDomainImpl.class);
    @Autowired
    ICustomerOfferService offerService;
    @Autowired
    IOrderDomain orderDomain;

    @Transactional
    @Override
    public boolean insertOffer(OfferReq offerReq) {
        boolean bool = false;
        // offer insert
        if(offerReq != null) {
            CustomerOffer customerOffer = composeOffer(offerReq);
            String offerId = UUID.randomUUID().toString().replace("-", "");
            customerOffer.setOfferId(offerId);
            customerOffer.setGmtCreate(new Date());
            customerOffer.setGmtModified(new Date());
            bool = offerService.insert(customerOffer);
            logger.debug("The offer {} inserted.", customerOffer);
            // order insert
            if(bool ) {
                for(OrderReq orderReq: offerReq.getOrderReqList()) {
                    boolean orderBool = orderDomain.insertOrder(orderReq);
                    bool &= orderBool;
                    if(! orderBool ) {
                        throw new RuntimeException("Order insert Exception. Rollback");
                    }
                    logger.debug("The order {} inserted.", orderReq);
                }
            }
        }
        return bool ;
    }

    @Override
    public boolean updateOffer(OfferReq offerReq) {
        boolean bool = false;
        CustomerOffer customerOffer = composeOffer(offerReq);
        String offerId = customerOffer.getOfferId();
        if(customerOffer != null && StringUtils.isNotBlank(offerId)) {
            customerOffer.setGmtModified(new Date());
            bool = offerService.updateByOfferId(customerOffer, offerId);
        }
        logger.debug("Update customer offer-{} with {}, the result:{}",customerOffer, offerId, bool);

        return bool;
    }
    private final static CustomerOffer composeOffer(OfferReq offerReq) {
        CustomerOffer customerOffer = null;
        if(offerReq != null) {
            customerOffer = new CustomerOffer();
            try {
                BeanUtils.copyProperties(customerOffer, offerReq);
            } catch (IllegalAccessException  | InvocationTargetException e) {
                logger.error("赋值时异常", e);
            }
            logger.debug("The customer offer will be assigned {}", customerOffer);
        }
        return customerOffer;
    }

    @Override
    public OfferResp getOfferByOfferId(String offerId) {
        OfferResp offerResp = null;
        if (StringUtils.isNotBlank(offerId)) {
            offerResp = new OfferResp();
            CustomerOffer customerOffer = offerService.selectOneByOfferId(offerId);
            offerResp = composeOfferResp(customerOffer);

            OrderReq customerOrder = new OrderReq();
            customerOrder.setOfferId(offerId);
            PageReq<OrderReq> orderReqPageReq = new PageReq<>();
            orderReqPageReq.setT(customerOrder);
            PageResp<OrderResp> orderRespPageResp = orderDomain.getOrderByOfferId(orderReqPageReq);
            offerResp.setOrderRespPageResp(orderRespPageResp);
        }
        return offerResp;
    }
    private final static OfferResp composeOfferResp(CustomerOffer customerOffer) {
        OfferResp  offerResp = null;
        if(offerResp != null) {
            offerResp  = new OfferResp ();
            SimpleDateFormat sdf  = new SimpleDateFormat("yyyyMMddHHmmss");
            try {
                BeanUtils.copyProperties(customerOffer, offerResp);
                String gmtCreate = sdf.format(customerOffer.getGmtCreate());
                offerResp.setGmtCreate(gmtCreate);
                String gmtModified = sdf.format(customerOffer.getGmtModified());
                offerResp.setGmtModified(gmtModified);
            } catch (IllegalAccessException  | InvocationTargetException e) {
                logger.error("赋值时异常", e);
            }
            logger.debug("The offer resp will be assigned {}", offerResp);
        }
        return offerResp;
    }

//    @Override
//    public OfferResp getOfferByCustomerId(String customerId) {
//        return null;
//    }


    @Override
    public boolean deleteOffer(String offerId) {
        boolean bool = false;
        if (StringUtils.isNotBlank(offerId)) {
            bool = offerService.deleteByOfferId(offerId);
        }
        logger.debug("Update customer offer status with {} to delete it logically. Result:{} ", offerId, bool);
        return bool;
    }
}
