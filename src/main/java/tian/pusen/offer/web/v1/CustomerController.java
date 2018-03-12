package tian.pusen.offer.web.v1;

import com.sun.org.apache.regexp.internal.RE;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tian.pusen.offer.domain.ICustomerDomain;
import tian.pusen.offer.web.vo.DefaultRespEntity;
import tian.pusen.offer.web.vo.Request;
import tian.pusen.offer.web.vo.Response;
import tian.pusen.offer.web.vo.customer.CustomerReq;
import tian.pusen.offer.web.vo.customer.CustomerResp;

import javax.websocket.server.PathParam;
import java.util.Arrays;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 * Date: 2017/12/3 12:19
 *
 * @author tianpusen
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@RestController
@RequestMapping("/v1/customer")
public class CustomerController {
    @Autowired
    ICustomerDomain customerDomain;

    @ApiOperation(value="新增客户信息", notes="新增客户信息")
    @PostMapping("/")
    public Response<DefaultRespEntity> insertCustomer(@RequestBody Request<CustomerReq> request) {
        CustomerReq customerReq = request.getReqBody();

        Response<DefaultRespEntity> response = new Response<DefaultRespEntity>();
        DefaultRespEntity defaultRespEntity = new DefaultRespEntity();
        boolean bool = customerDomain.insertCustomer(customerReq);
        defaultRespEntity.setIsSuccess(""+bool);
        response.setRespBody(defaultRespEntity);

        return response;
    }

    @ApiOperation(value="根据CustomerId更新客户信息", notes="根据CustomerId更新客户信息")
    @PatchMapping("/")
    public Response<DefaultRespEntity> updateCustomer(@RequestBody Request<CustomerReq> request) {
        CustomerReq customerReq = request.getReqBody();

        Response<DefaultRespEntity> response = new Response<DefaultRespEntity>();
        DefaultRespEntity defaultRespEntity = new DefaultRespEntity();
        boolean bool = customerDomain.updateCustomer(customerReq);
        defaultRespEntity.setIsSuccess(""+bool);
        response.setRespBody(defaultRespEntity);

        return response;
    }

    @ApiOperation(value="根据客户编号查询客户信息", notes="根据客户编号查询客户信息")
    @GetMapping("/{customerId}")
    public Response<CustomerResp> getCustomer(@PathVariable("customerId")String customerId) {
        Response<CustomerResp> response = new Response<CustomerResp>();
        CustomerResp customerResp = customerDomain.getCustomerByCustomerId(customerId);
        response.setRespBody(customerResp);
        return response;
    }

    @ApiOperation(value="根据customerId逻辑删除数据", notes="根据customerId逻辑删除数据")
    @DeleteMapping("/{customerId}")
    public Response<DefaultRespEntity> deleteCustomer(@PathVariable("customerId")String customerId) {
        Response<DefaultRespEntity> response = new Response<DefaultRespEntity>();
        DefaultRespEntity defaultRespEntity = new DefaultRespEntity();
        boolean bool = customerDomain.deleteCustomer(customerId);
        defaultRespEntity.setIsSuccess(""+bool);
        response.setRespBody(defaultRespEntity);

        return response;
    }

    @ApiOperation(value="根据客户姓名获取客户信息", notes="根据客户姓名获取客户信息")
    @GetMapping("/names/${name}")
//    public Response<CustomerResp> getByCustomerName(@RequestParam(value="name", defaultValue="田圃森")String name) {
    public Response<CustomerResp> getByCustomerName(@PathVariable("name")String name) {
        Response<CustomerResp> response = new Response<CustomerResp>();
        CustomerResp customerResp = customerDomain.getCustomerByName(name);
        response.setRespBody(customerResp);
        return response;
    }

    @ApiOperation(value="根据部分客户名模糊查询客户名", notes="根据部分客户名模糊查询客户名")
    @GetMapping("/nameList/{partName}")
    public List<String> getNameList(@PathVariable("partName")String partName) {
        List<String> nameList = customerDomain.getNameList(partName);
        return nameList;
    }
}
