package tian.pusen.offer.service;

import tian.pusen.offer.entity.Customer;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 * 客户信息 服务类
 * </p>
 *
 * @author 田圃森
 * @since 2017-12-02
 */
public interface ICustomerService extends IService<Customer> {
    Customer selectOneByCustomerId(String customerId);
    Customer selectOneByName(String name); // name 有唯一索引
    boolean updateByCustomerId(Customer customer, String customerId);
    boolean deleteByCustomerId(String customerId);
    List<String> getNameList(String partName);
}
