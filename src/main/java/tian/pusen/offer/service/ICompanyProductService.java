package tian.pusen.offer.service;

import tian.pusen.offer.entity.CompanyProduct;
import com.baomidou.mybatisplus.service.IService;
import tian.pusen.offer.entity.Customer;

import java.util.List;

/**
 * <p>
 * 产品信息 服务类
 * </p>
 *
 * @author 田圃森
 * @since 2017-12-02
 */
public interface ICompanyProductService extends IService<CompanyProduct> {
    CompanyProduct selectOneByProductId(String productId);
    CompanyProduct selectOneByName(String name); // name 有唯一索引
    boolean updateByProductId(CompanyProduct product, String productId);
    boolean deleteByProductId(String productId);
    List<String> getNameList(String partName);
}
