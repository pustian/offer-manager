package tian.pusen.offer.domain.impl;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tian.pusen.offer.domain.ICustomerDomain;
import tian.pusen.offer.entity.Customer;
import tian.pusen.offer.service.ICustomerService;
import tian.pusen.offer.web.vo.customer.CustomerReq;
import tian.pusen.offer.web.vo.customer.CustomerResp;
import tian.pusen.offer.web.vo.page.PageReq;
import tian.pusen.offer.web.vo.page.PageResp;

import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 * Date: 2017/12/3 12:33
 *
 * @author tianpusen
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service
public class CustomerDomainImpl implements ICustomerDomain {
    private static final Logger logger = LoggerFactory.getLogger(CustomerDomainImpl.class);
    @Autowired
    ICustomerService customerService;

    @Override
    public boolean insertCustomer(CustomerReq customerReq) {
        Customer customer = composeCustomerByReq(customerReq);
        boolean bool = false;
        if(customer != null ) {
            String customerId = UUID.randomUUID().toString().replace("-", "");
            customer.setCustomerId(customerId);
            customer.setGmtCreate(new Date());
            customer.setGmtModified(new Date());
            bool = customerService.insert(customer);
        }
        logger.debug("Inserted customer-{}:{}",customer, bool);
        return bool;
    }

    @Override
    public boolean updateCustomer(CustomerReq customerReq) {
        boolean bool = false;
        Customer customer = composeCustomerByReq(customerReq);
        String customerId = customerReq.getCustomerId();
        if(customer != null && StringUtils.isNotBlank(customerId)) {
            customer.setGmtModified(new Date());
            bool = customerService.updateByCustomerId(customer, customerId);
        }
        logger.debug("Update customer-{} with {}, the result:{}",customer, customerId, bool);
        return bool;
    }
    private static Customer composeCustomerByReq(CustomerReq customerReq) {
        Customer customer = null;
        if(customerReq != null) {
            customer = new Customer();
            try {
                BeanUtils.copyProperties(customer, customerReq);
            } catch (IllegalAccessException  | InvocationTargetException e) {
                logger.error("赋值时异常", e);
            }
            logger.debug("The customer will be assigned {}", customer);
        }
        return customer;
    }

    @Override
    public CustomerResp getCustomerByCustomerId(String customerId) {
        CustomerResp customerResp = null;
        if(StringUtils.isNotBlank(customerId)) {
            Customer customer = customerService.selectOneByCustomerId(customerId);
            logger.debug("Get a customer{} with customerId {}", customer, customerId);
            customerResp = composeCustomerResp(customer);
        }
        logger.debug("Get a customerResp:{}", customerResp);
        return  customerResp;
    }
    @Override
    public CustomerResp getCustomerByName(String name) {
        CustomerResp customerResp = null;
        if(StringUtils.isNotBlank(name)) {
            Customer customer = customerService.selectOneByName(name);
            logger.debug("Get a customer{} with name {}", customer, name);
            customerResp = composeCustomerResp(customer);
        }
        logger.debug("Get a customerResp", customerResp);
        return  customerResp;
    }
    private static CustomerResp composeCustomerResp(Customer customer) {
        CustomerResp customerResp = null;
        if(customer != null ) {
            SimpleDateFormat sdf  = new SimpleDateFormat("yyyyMMddHHmmss");
            customerResp = new CustomerResp();
            try {
                BeanUtils.copyProperties(customerResp, customer);
                String gmtCreate = sdf.format(customer.getGmtCreate());
                customerResp.setGmtCreate(gmtCreate);
                String gmtModified = sdf.format(customer.getGmtModified());
                customerResp.setGmtModified(gmtModified);
            } catch (IllegalAccessException  | InvocationTargetException e) {
                logger.error("赋值时异常", e);
            }
        }
        return customerResp;
    }

//    @Override
//    PageResp<CustomerResp> getCustomers(PageReq<CustomerReq> customerReqPageReq) {
//        customerService.selectPage()
//    }

    @Override
    public boolean deleteCustomer(String customerId) {
        boolean bool = false;
        if (StringUtils.isNotBlank(customerId)) {
            bool = customerService.deleteByCustomerId(customerId);
        }
        logger.debug("Update customer status with {} to delete it logically. Result:{} ", customerId, bool);
        return bool;
    }

    @Override
    public List<String> getNameList(String partName) {
        return customerService.getNameList(partName);
    }
}
