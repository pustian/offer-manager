package tian.pusen.offer.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import tian.pusen.offer.entity.AreaCode;
import tian.pusen.offer.mapper.AreaCodeMapper;
import tian.pusen.offer.service.IAreaCodeService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 地区代码 服务实现类
 * </p>
 *
 * @author 田圃森
 * @since 2017-12-02
 */
@Service
public class AreaCodeServiceImpl extends ServiceImpl<AreaCodeMapper, AreaCode> implements IAreaCodeService {
    @Override
    public AreaCode getAreaCode(String province, String city, String district) {
        AreaCode clause = new AreaCode();
        clause.setProvince(province);
        if(StringUtils.isNotBlank(city)){
            clause.setCity(city);
        }
        if(StringUtils.isNotBlank(district)) {
            clause.setDistrict(district);
        }
        EntityWrapper<AreaCode> conditoin = new EntityWrapper<>(clause);
        AreaCode areaCode =  selectOne(conditoin);
        return  areaCode;
    }

    @Override
    public List<AreaCode> getAreaCodeList(String province, String city) {
        AreaCode clause = new AreaCode();

        EntityWrapper<AreaCode> conditoin = new EntityWrapper<>();
        if(StringUtils.isNotBlank(province) ) {
            clause.setProvince(province);
            conditoin.where("city != {0}", "00");
            if(StringUtils.isNotBlank(city)) {
                clause.setCity(city); //  where province= and city =  and district != '00'
                conditoin.where("district != {0}", "00");
            } else {
                clause.setDistrict("00");  // where province= and district='00' and city != '00'
            }
        } else {
            clause.setCity("00"); // where city='00' // 所有省
        }
        conditoin.setEntity(clause);

        List<AreaCode> areaCodeList =  selectList(conditoin);
        return  areaCodeList;
    }

    @Autowired
    AreaCodeMapper areaCodeMapper;
    @Override
    public List<AreaCode> getByDescritpion(String desc) {
        return areaCodeMapper.getByDescription(desc);
    }
}
