package tian.pusen.offer.web.v1;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tian.pusen.offer.domain.IOrderDomain;
import tian.pusen.offer.web.vo.DefaultRespEntity;
import tian.pusen.offer.web.vo.Request;
import tian.pusen.offer.web.vo.Response;
import tian.pusen.offer.web.vo.order.OrderReq;
import tian.pusen.offer.web.vo.order.OrderResp;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 * Date: 2017/12/9 15:22
 *
 * @author tianpusen
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@RestController
@RequestMapping("/v1/order")
public class OrderController {
    @Autowired
    IOrderDomain orderDomain;

    @ApiOperation(value="新增订单信息", notes="新增订单信息")
    @PostMapping("/")
    public Response<DefaultRespEntity> insertOrder(@RequestBody Request<OrderReq> request) {
        OrderReq orderReq = request.getReqBody();

        Response<DefaultRespEntity> response = new Response<DefaultRespEntity>();
        DefaultRespEntity defaultRespEntity = new DefaultRespEntity();
        boolean bool = orderDomain.insertOrder(orderReq);
        defaultRespEntity.setIsSuccess(""+bool);
        response.setRespBody(defaultRespEntity);

        return response;
    }

    @ApiOperation(value="根据orderId更新订单信息", notes="根据orderId更新订单信息")
    @PatchMapping("/")
    public Response<DefaultRespEntity> updateOrder(@RequestBody Request<OrderReq> request) {
        OrderReq orderReq = request.getReqBody();

        Response<DefaultRespEntity> response = new Response<DefaultRespEntity>();
        DefaultRespEntity defaultRespEntity = new DefaultRespEntity();
        boolean bool = orderDomain.updateOrder(orderReq);
        defaultRespEntity.setIsSuccess(""+bool);
        response.setRespBody(defaultRespEntity);

        return response;
    }

    @ApiOperation(value="根据订单编号查询订单信息", notes="根据订单编号查询订单信息")
    @GetMapping("/{orderId}")
    public Response<OrderResp> getOrder(@PathVariable("orderId")String orderId) {
        Response<OrderResp> response = new Response<OrderResp>();
        OrderResp orderResp = orderDomain.getOrderByOrderId(orderId);
        response.setRespBody(orderResp);
        return response;
    }

    @ApiOperation(value="根据订单编号orderId逻辑删除数据", notes="根据订单编号orderId逻辑删除数据")
    @DeleteMapping("/{orderId}")
    public Response<DefaultRespEntity> deleteOrder(@PathVariable("orderId")String orderId) {
        Response<DefaultRespEntity> response = new Response<DefaultRespEntity>();
        DefaultRespEntity defaultRespEntity = new DefaultRespEntity();
        boolean bool = orderDomain.deleteOrder(orderId);
        defaultRespEntity.setIsSuccess(""+bool);
        response.setRespBody(defaultRespEntity);

        return response;
    }
}
