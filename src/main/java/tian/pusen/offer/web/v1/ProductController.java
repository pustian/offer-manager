package tian.pusen.offer.web.v1;

import com.sun.org.apache.regexp.internal.RE;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tian.pusen.offer.domain.IProductDomain;
import tian.pusen.offer.service.ICompanyProductService;
import tian.pusen.offer.web.vo.DefaultRespEntity;
import tian.pusen.offer.web.vo.Request;
import tian.pusen.offer.web.vo.Response;
import tian.pusen.offer.web.vo.customer.CustomerReq;
import tian.pusen.offer.web.vo.customer.CustomerResp;
import tian.pusen.offer.web.vo.product.ProductReq;
import tian.pusen.offer.web.vo.product.ProductResp;

import java.util.List;

/**
 * Created by tianpusen on 2017/9/3.
 */
@RestController
@RequestMapping("/v1/product")
public class ProductController {
    @Autowired
    IProductDomain productDomain;

    @ApiOperation(value="新增产品信息", notes="新增产品信息")
    @PostMapping("/")
    public Response<DefaultRespEntity> insertProduct(@RequestBody Request<ProductReq> request) {
        ProductReq productReq = request.getReqBody();

        Response<DefaultRespEntity> response = new Response<DefaultRespEntity>();
        DefaultRespEntity defaultRespEntity = new DefaultRespEntity();
        boolean  bool = productDomain.insertProduct(productReq);
        defaultRespEntity.setIsSuccess(""+bool);
        response.setRespBody(defaultRespEntity);

        return response;
    }

    @ApiOperation(value="根据ProductId更新产品信息", notes="根据ProductId更新产品信息")
    @PatchMapping("/")
    public Response<DefaultRespEntity> updateProduct(@RequestBody Request<ProductReq> request) {
        ProductReq productReq = request.getReqBody();

        Response<DefaultRespEntity> response = new Response<DefaultRespEntity>();
        DefaultRespEntity defaultRespEntity = new DefaultRespEntity();
        boolean  bool = productDomain.updateProduct(productReq);
        defaultRespEntity.setIsSuccess(""+bool);
        response.setRespBody(defaultRespEntity);

        return response;
    }

    @ApiOperation(value="根据产品编号查询产品信息", notes="根据产品编号查询产品信息")
    @GetMapping("/{productId}")
    public Response<ProductResp> getProduct(@PathVariable("productId")String productId) {
        Response<ProductResp> response = new Response<ProductResp>();
        ProductResp productResp = productDomain.getProductByProductId(productId);
        response.setRespBody(productResp);
        return response;
    }

    @ApiOperation(value="根据productId逻辑删除数据", notes="根据productId逻辑删除数据")
    @DeleteMapping("/{productId}")
    public Response<DefaultRespEntity> deleteProduct(@PathVariable("productId")String productId) {
        Response<DefaultRespEntity> response = new Response<DefaultRespEntity>();
        DefaultRespEntity defaultRespEntity = new DefaultRespEntity();
        boolean bool = productDomain.deleteProduct(productId);
        defaultRespEntity.setIsSuccess(""+bool);
        response.setRespBody(defaultRespEntity);

        return response;
    }

    @ApiOperation(value="根据产品名获取产品", notes="根据产品名获取产品")
    @GetMapping("/names/${name}")
//    public Response<CustomerResp> getByCustomerName(@RequestParam(value="name", defaultValue="田圃森")String name) {
    public Response<ProductResp> getByCustomerName(@PathVariable("name")String name) {
        Response<ProductResp> response = new Response<ProductResp>();
        ProductResp productResp = productDomain.getProductByName(name);
        response.setRespBody(productResp);
        return response;
    }

    @ApiOperation(value="根据部分产品名模糊查询产品名", notes="根据部分产品名模糊查询产品名")
    @GetMapping("/nameList/{partName}")
    public List<String> getNameList(@PathVariable("partName")String partName) {
        List<String> nameList = productDomain.getNameList(partName);
        return nameList;
    }
}
