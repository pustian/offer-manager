package tian.pusen.offer.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import tian.pusen.offer.entity.CompanyProduct;
import tian.pusen.offer.mapper.CompanyProductMapper;
import tian.pusen.offer.mapper.CustomerMapper;
import tian.pusen.offer.service.ICompanyProductService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 产品信息 服务实现类
 * </p>
 *
 * @author 田圃森
 * @since 2017-12-02
 */
@Service
public class CompanyProductServiceImpl extends ServiceImpl<CompanyProductMapper, CompanyProduct> implements ICompanyProductService {
    @Override
    public CompanyProduct selectOneByProductId(String productId){
        CompanyProduct conditon = new CompanyProduct();
        conditon.setProductId(productId);
        EntityWrapper<CompanyProduct> ew = new EntityWrapper<>();
        ew.setEntity(conditon);
        CompanyProduct companyProduct = selectOne(ew);
        return companyProduct;
    }
    @Override
    public CompanyProduct selectOneByName(String name){
        EntityWrapper<CompanyProduct> ew = new EntityWrapper<>();
        ew.where("name={0}", name);
        CompanyProduct companyProduct = selectOne(ew);
        return companyProduct;
    }
    @Override
    public boolean updateByProductId(CompanyProduct product, String productId){
        CompanyProduct clause =  new CompanyProduct();
        EntityWrapper<CompanyProduct> ew = new EntityWrapper<>(clause);
        boolean bool = update(product, ew);
        return bool;
    }
    @Override
    public boolean deleteByProductId(String productId){
//        CompanyProduct clause =  new CompanyProduct();
//        EntityWrapper<CompanyProduct> ew = new EntityWrapper<>(clause);
//        CompanyProduct updatedProduct = new CompanyProduct();
//        updatedProduct.setGmtModified(new Date());
//        boolean bool = update(product, ew);
//        return bool;
        return true;
    }

    @Autowired
    CompanyProductMapper productMapper;
    @Override
    public List<String> getNameList(String partName){
        return productMapper.getNameList(partName);
    }
}
