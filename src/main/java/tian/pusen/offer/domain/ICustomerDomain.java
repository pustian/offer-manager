package tian.pusen.offer.domain;

import tian.pusen.offer.entity.Customer;
import tian.pusen.offer.web.vo.customer.CustomerReq;
import tian.pusen.offer.web.vo.customer.CustomerResp;
import tian.pusen.offer.web.vo.page.PageReq;
import tian.pusen.offer.web.vo.page.PageResp;

import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 * Date: 2017/12/3 12:32
 *
 * @author tianpusen
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface ICustomerDomain {
    boolean insertCustomer(CustomerReq customerReq);
    boolean updateCustomer(CustomerReq customerReq);
    CustomerResp getCustomerByCustomerId(String customerId);
    CustomerResp getCustomerByName(String name);
    //    PageResp<CustomerResp> getCustomers(PageReq<CustomerReq> customerReqPageReq);
    List<String> getNameList(String partName);
    boolean deleteCustomer(String customerId);
}
