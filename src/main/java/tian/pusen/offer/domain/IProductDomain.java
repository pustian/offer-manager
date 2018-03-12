package tian.pusen.offer.domain;

import tian.pusen.offer.web.vo.customer.CustomerReq;
import tian.pusen.offer.web.vo.customer.CustomerResp;
import tian.pusen.offer.web.vo.page.PageReq;
import tian.pusen.offer.web.vo.page.PageResp;
import tian.pusen.offer.web.vo.product.ProductReq;
import tian.pusen.offer.web.vo.product.ProductResp;

import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 * Date: 2017/12/5 23:13
 *
 * @author tianpusen
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface IProductDomain {
    boolean insertProduct(ProductReq productReq);
    boolean updateProduct (ProductReq productReq);
    ProductResp getProductByProductId(String productId);
    ProductResp getProductByName(String name);
    //    PageResp<ProductResp> getProducts(PageReq<ProductReq> productReqPageReq);
    boolean deleteProduct(String productId);
    List<String> getNameList(String partName);
}
