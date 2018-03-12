package tian.pusen.offer.domain.impl;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tian.pusen.offer.domain.IProductDomain;
import tian.pusen.offer.entity.CompanyProduct;
import tian.pusen.offer.entity.Customer;
import tian.pusen.offer.service.ICompanyProductService;
import tian.pusen.offer.service.ICustomerService;
import tian.pusen.offer.web.vo.product.ProductReq;
import tian.pusen.offer.web.vo.product.ProductResp;

import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 * Date: 2017/12/5 23:14
 *
 * @author tianpusen
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Service
public class ProductDomainImpl implements IProductDomain {
    private static final Logger logger = LoggerFactory.getLogger(ProductDomainImpl.class);
    @Autowired
    ICompanyProductService productService;

    @Override
    public boolean insertProduct(ProductReq productReq) {
        CompanyProduct companyProduct = composeCompanyProduct(productReq);
        boolean bool = false;
        if(companyProduct != null ) {
            String productId = UUID.randomUUID().toString().replace("-", "");
            companyProduct.setProductId(productId);
            companyProduct.setGmtCreate(new Date());
            companyProduct.setGmtModified(new Date());
            bool = productService.insert(companyProduct);
        }
        logger.debug("Inserted product-{}:{}",companyProduct, bool);
        return bool;
    }

    @Override
    public boolean updateProduct(ProductReq productReq) {
        CompanyProduct companyProduct = composeCompanyProduct(productReq);
        boolean bool = false;
        String productId = companyProduct.getProductId();
        if (companyProduct != null && StringUtils.isNotBlank(productId)) {
            companyProduct.setGmtModified(new Date());
            productService.updateByProductId(companyProduct, companyProduct.getProductId());
        }
        return bool;
    }
    private static CompanyProduct composeCompanyProduct(ProductReq productReq) {
        CompanyProduct companyProduct = null;
        if(companyProduct != null) {
            companyProduct = new CompanyProduct();
            try {
                BeanUtils.copyProperties(companyProduct, productReq);
            } catch (IllegalAccessException  | InvocationTargetException e) {
                logger.error("赋值时异常", e);
            }
            logger.debug("A new product will be inserted {}", companyProduct);
        }
        return companyProduct;
    }
    @Override
    public ProductResp getProductByProductId(String productId) {
        ProductResp productResp = null;
        if(StringUtils.isNotBlank(productId) ) {
            CompanyProduct companyProduct = productService.selectOneByProductId(productId);
            logger.debug("Get a product{} with productId {}", companyProduct, productId);
            productResp = composeProductResp(companyProduct);
        }
        logger.debug("Get a customerResp", productResp);
        return productResp;
    }
    @Override
    public ProductResp getProductByName(String name) {
        ProductResp productResp = null;
        if(StringUtils.isNotBlank(name) ) {
            CompanyProduct companyProduct = productService.selectOneByName(name);
            logger.debug("Get a product{} with name {}", companyProduct, name);
            productResp = composeProductResp(companyProduct);
        }
        logger.debug("Get a customerResp", productResp);
        return productResp;
    }
    private static ProductResp composeProductResp(CompanyProduct product) {
        ProductResp productResp = null;
        SimpleDateFormat sdf  = new SimpleDateFormat("yyyyMMddHHmmss");
        if(product != null) {
            productResp = new ProductResp();
            try {
                BeanUtils.copyProperties(productResp, product);
                String gmtCreate = sdf.format(product.getGmtCreate());
                productResp.setGmtCreate(gmtCreate);
                String gmtModified = sdf.format(product.getGmtModified());
                productResp.setGmtModified(gmtModified);
            } catch (IllegalAccessException  | InvocationTargetException e) {
                logger.error("赋值时异常", e);
            }
        }
        return productResp;
    }

//    PageResp<ProductResp> getProducts(PageReq<ProductReq> productReqPageReq);

    @Override
    public boolean deleteProduct(String productId) {
        boolean bool = false;
        if (StringUtils.isNotBlank(productId)) {
            bool = productService.deleteByProductId(productId);
        }
        logger.debug("Update customer status with {} to delete it logically. Result:{} ", productId, bool);
        return bool;
    }

    @Override
    public List<String> getNameList(String partName) {
        return productService.getNameList(partName);
    }
}
