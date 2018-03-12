package tian.pusen.offer.service;

import tian.pusen.offer.entity.CustomerOffer;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 报价信息 服务类
 * </p>
 *
 * @author 田圃森
 * @since 2017-12-02
 */
public interface ICustomerOfferService extends IService<CustomerOffer> {
    CustomerOffer selectOneByOfferId(String offerId);
    boolean updateByOfferId(CustomerOffer customerOffer, String offerId);
    boolean deleteByOfferId(String offerId);
}
