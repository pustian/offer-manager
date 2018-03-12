package tian.pusen.offer.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import tian.pusen.offer.entity.CustomerOffer;
import tian.pusen.offer.mapper.CustomerOfferMapper;
import tian.pusen.offer.service.ICustomerOfferService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * <p>
 * 报价信息 服务实现类
 * </p>
 *
 * @author 田圃森
 * @since 2017-12-02
 */
@Service
public class CustomerOfferServiceImpl extends ServiceImpl<CustomerOfferMapper, CustomerOffer> implements ICustomerOfferService {

    @Override
    public CustomerOffer selectOneByOfferId(String offerId) {
        EntityWrapper<CustomerOffer> ew = new EntityWrapper<>();
        ew.eq("offer_id", offerId);
        CustomerOffer customerOffer = selectOne(ew);
        return customerOffer;
    }

    @Override
    public boolean updateByOfferId(CustomerOffer customerOffer, String offerId) {
        EntityWrapper<CustomerOffer> ew = new EntityWrapper<>();
        ew.eq("offer_id", offerId);
        boolean bool = update(customerOffer, ew);
        return bool ;
    }

    @Override
    public boolean deleteByOfferId(String offerId) {
        EntityWrapper<CustomerOffer> ew = new EntityWrapper<>();
        ew.eq("offer_id", offerId);
        CustomerOffer customerOffer = new CustomerOffer();
        customerOffer.setStatus("0");
        customerOffer.setGmtModified(new Date());
        boolean bool = update(customerOffer, ew);
        return bool ;
    }
}
