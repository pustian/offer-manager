package tian.pusen.offer.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import tian.pusen.offer.entity.Customer;
import tian.pusen.offer.mapper.CustomerMapper;
import tian.pusen.offer.service.ICustomerService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 客户信息 服务实现类
 * </p>
 *
 * @author 田圃森
 * @since 2017-12-02
 */
@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements ICustomerService {

    @Override
    public Customer selectOneByCustomerId(String customerId) {
        Customer whereCustomerId = new Customer();
        whereCustomerId.setCustomerId(customerId);
        EntityWrapper<Customer> clause = new EntityWrapper<Customer>();
        clause.setEntity(whereCustomerId);
        Customer customer = selectOne(clause);
        return customer;
    }
    @Override
    public Customer selectOneByName(String name) {
        EntityWrapper<Customer> clause = new EntityWrapper<Customer>();
//        clause.where("name={0}", name);
        clause.eq("name", name);
        Customer customer = selectOne(clause);
        return customer;
    }
    @Override
    public boolean updateByCustomerId(Customer customer, String customerId) {
        Customer whereCustomerId = new Customer();
        whereCustomerId.setCustomerId(customerId);
        EntityWrapper<Customer> clause = new EntityWrapper<Customer>();
        clause.setEntity(whereCustomerId);
        boolean bool = update(customer, clause);
        return bool;
    }
    @Override
    public boolean deleteByCustomerId(String customerId) {
        Customer whereCustomerId = new Customer();
        whereCustomerId.setCustomerId(customerId);
        EntityWrapper<Customer> clause = new EntityWrapper<Customer>();
        clause.setEntity(whereCustomerId);
        Customer updateCustomer = new Customer();
        updateCustomer.setIsDeleted(1);
        updateCustomer.setGmtModified(new Date());
        boolean bool = update(updateCustomer, clause);
        return bool;
    }

    @Autowired
    CustomerMapper customerMapper;
    @Override
    public List<String> getNameList(String partName) {
        return customerMapper.getNameList(partName);
    }
}
