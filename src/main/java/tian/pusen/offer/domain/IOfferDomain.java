package tian.pusen.offer.domain;

import tian.pusen.offer.web.vo.customer.CustomerReq;
import tian.pusen.offer.web.vo.customer.CustomerResp;
import tian.pusen.offer.web.vo.offer.OfferReq;
import tian.pusen.offer.web.vo.offer.OfferResp;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 * Date: 2017/12/8 22:48
 *
 * @author tianpusen
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface IOfferDomain {
    // 包含订单详情新增
    boolean insertOffer(OfferReq offerReq);
    // 只更新报价的信息
    boolean updateOffer(OfferReq offerReq);
    OfferResp getOfferByOfferId(String offerId);
//    OfferResp getOfferByCustomerId(String customerId);
    boolean deleteOffer(String offerId);
}
