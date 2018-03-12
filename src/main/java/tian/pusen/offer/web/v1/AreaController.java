package tian.pusen.offer.web.v1;

import io.swagger.annotations.ApiOperation;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tian.pusen.offer.entity.AreaCode;
import tian.pusen.offer.service.IAreaCodeService;
import tian.pusen.offer.web.vo.Response;
import tian.pusen.offer.web.vo.areacode.AreaCodeResp;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tianpusen on 2017/9/3.
 */
@RestController
@RequestMapping("/v1/area")
public class AreaController {

    @Autowired
    IAreaCodeService areaCodeService;

    @ApiOperation(value="根据省份编码获取省份名称", notes="根据省份编码{2位}获取省份名称")
    @GetMapping("/{province}/{city}/{district}")
    public Response<AreaCodeResp> getAreaCode(
            @PathVariable("province")String province,
            @PathVariable("city")String city,
            @PathVariable("district")String district) {
        Response<AreaCodeResp> response = new Response<AreaCodeResp>();
        AreaCode areaCode = areaCodeService.getAreaCode(province, city, district);
        AreaCodeResp areaCodeResp = composeAreaCodeResp(areaCode);
        response.setRespBody(areaCodeResp);
        return response;
    }
    private static AreaCodeResp composeAreaCodeResp(AreaCode areaCode) {
        AreaCodeResp areaCodeResp = null;
        if(areaCode != null ) {
            try {
                BeanUtils.copyProperties(areaCodeResp, areaCode);
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        return areaCodeResp;
    }

    @ApiOperation(value="获取所有省份信息", notes="获取所有省份信息")
    @GetMapping("/provinces/")
    public List<AreaCodeResp> getProvinceList() {
        List<AreaCode> areaCodeList= areaCodeService.getAreaCodeList(null, null);
        List<AreaCodeResp> areaCodeRespList = composeAreaCodeResp(areaCodeList);

        return areaCodeRespList;
    }
    @ApiOperation(value="获取该省份下市信息", notes="获取该省份下市信息")
    @GetMapping("/cities/{province}")
    public List<AreaCodeResp> getProvinceList(@PathVariable("province")String province) {
        List<AreaCode> areaCodeList= areaCodeService.getAreaCodeList(province, null);
        List<AreaCodeResp> areaCodeRespList = composeAreaCodeResp(areaCodeList);

        return areaCodeRespList;
    }
    @ApiOperation(value="获取省市下区信息", notes="获取省市下区信息")
    @GetMapping("/districts/{province}/{city}")
    public List<AreaCodeResp> getProvinceList(@PathVariable("province")String province,
            @PathVariable("city")String city) {
        List<AreaCode> areaCodeList= areaCodeService.getAreaCodeList(province, city);
        List<AreaCodeResp> areaCodeRespList = composeAreaCodeResp(areaCodeList);

        return areaCodeRespList;
    }
    private static List<AreaCodeResp> composeAreaCodeResp(List<AreaCode> areaCodeList) {
        List<AreaCodeResp> areaCodeRespList = new ArrayList<>();
        if(areaCodeList != null && areaCodeList.size() > 0) {
            for (AreaCode areaCode:areaCodeList) {
                AreaCodeResp areaCodeResp = new AreaCodeResp();
                try {
                    BeanUtils.copyProperties(areaCodeResp, areaCode);
                } catch (IllegalAccessException |InvocationTargetException e) {
                    e.printStackTrace();
                }
                areaCodeRespList.add(areaCodeResp);
            }
        }
        return areaCodeRespList;
    }

//    @ApiIgnore
    @ApiOperation(value="根据地区描述模糊获取地区信息", notes="根据地区描述模糊获取地区信息")
    @GetMapping("/{description}")
    public List<AreaCodeResp> getAreaByDescription(@PathVariable("description")String description) {
        List<AreaCodeResp> areaCodeRespList = null;
        return areaCodeRespList;
    }
}
