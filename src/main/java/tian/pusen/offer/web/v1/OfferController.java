package tian.pusen.offer.web.v1;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tian.pusen.offer.domain.IOfferDomain;
import tian.pusen.offer.web.vo.DefaultRespEntity;
import tian.pusen.offer.web.vo.Request;
import tian.pusen.offer.web.vo.Response;
import tian.pusen.offer.web.vo.offer.OfferReq;
import tian.pusen.offer.web.vo.offer.OfferResp;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 * Date: 2017/12/3 12:16
 *
 * @author tianpusen
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@RestController
@RequestMapping("/v1/offer")
public class OfferController {
    @Autowired
    IOfferDomain offerDomain;

    @ApiOperation(value="新增报价信息", notes="新增报价信息")
    @PostMapping("/")
    public Response<DefaultRespEntity> insertOffer(@RequestBody Request<OfferReq> request) {
        OfferReq offerReq = request.getReqBody();

        Response<DefaultRespEntity> response = new Response<DefaultRespEntity>();
        DefaultRespEntity defaultRespEntity = new DefaultRespEntity();
        boolean bool = offerDomain.insertOffer(offerReq);
        defaultRespEntity.setIsSuccess(""+bool);
        response.setRespBody(defaultRespEntity);

        return response;
    }

    @ApiOperation(value="根据offerId更新报价信息", notes="根据offerId更新报价信息")
    @PatchMapping("/")
    public Response<DefaultRespEntity> updateOffer(@RequestBody Request<OfferReq> request) {
        OfferReq offerReq = request.getReqBody();

        Response<DefaultRespEntity> response = new Response<DefaultRespEntity>();
        DefaultRespEntity defaultRespEntity = new DefaultRespEntity();
        boolean bool = offerDomain.updateOffer(offerReq);
        defaultRespEntity.setIsSuccess(""+bool);
        response.setRespBody(defaultRespEntity);

        return response;
    }

    @ApiOperation(value="根据报价编号查询报价信息", notes="根据报价编号查询报价信息")
    @GetMapping("/{offerId}")
    public Response<OfferResp> getOffer(@PathVariable("offerId")String offerId) {
        Response<OfferResp> response = new Response<OfferResp>();
        OfferResp offerResp = offerDomain.getOfferByOfferId(offerId);
        response.setRespBody(offerResp);
        return response;
    }

    @ApiOperation(value="根据订单编号offerId逻辑删除数据", notes="根据订单编号offerId逻辑删除数据")
    @DeleteMapping("/{offerId}")
    public Response<DefaultRespEntity> deleteOffer(@PathVariable("offerId")String offerId) {
        Response<DefaultRespEntity> response = new Response<DefaultRespEntity>();
        DefaultRespEntity defaultRespEntity = new DefaultRespEntity();
        boolean bool = offerDomain.deleteOffer(offerId);
        defaultRespEntity.setIsSuccess(""+bool);
        response.setRespBody(defaultRespEntity);

        return response;
    }

}
