package tian.pusen.offer.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.junit4.SpringRunner;
import tian.pusen.offer.entity.AreaCode;

import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 * Date: 2017/12/5 22:41
 *
 * @author tianpusen
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Profile("dev")
@RunWith(SpringRunner.class)
@SpringBootTest
public class AreaCodeServiceTest {
    @Autowired
    IAreaCodeService areaCodeService;
    @Test
    public void getAreaCode(){
        String province = "61";
        String city = "05";
        String district = "25";
        AreaCode areaCode = areaCodeService.getAreaCode(province, city, district);
        Assert.assertTrue(areaCode != null );
        Assert.assertTrue(province.equals(areaCode.getProvince()));
        Assert.assertTrue(city.equals(areaCode.getCity()));
        Assert.assertTrue(district.equals(areaCode.getDistrict()));
    }
    @Test
    public void getAreaCodeList(){
        List<AreaCode> areaCodeList = areaCodeService.getAreaCodeList(null, null);
        Assert.assertTrue(areaCodeList != null && areaCodeList.size() > 0);
        System.out.println(areaCodeList.size());
    }
    @Test
    public void getAreaCodeListCities(){
        String province = "61";

        List<AreaCode> areaCodeList = areaCodeService.getAreaCodeList(province, null);
        Assert.assertTrue(areaCodeList != null && areaCodeList.size() > 0);
        System.out.println(areaCodeList.size());
    }
    @Test
    public void getAreaCodeListDistricts(){
        String province = "61";
        String city = "05";
        List<AreaCode> areaCodeList = areaCodeService.getAreaCodeList(province, city);
        Assert.assertTrue(areaCodeList != null && areaCodeList.size() > 0);
        System.out.println(areaCodeList.size());
    }
    @Test
    public void getByDescritpion() {
        String desc = "阳";
        List<AreaCode> areaCodeList = areaCodeService.getByDescritpion(desc);
        Assert.assertTrue(areaCodeList != null && areaCodeList.size() > 0);
        for(AreaCode areaCode: areaCodeList) {
            System.out.println(areaCode.getDescription());
            Assert.assertTrue(areaCode.getDescription().contains(desc));
        }
    }
}
