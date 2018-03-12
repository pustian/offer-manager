package tian.pusen.offer.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import org.springframework.beans.BeanUtils;
import tian.pusen.offer.entity.AreaCode;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 * 地区代码 服务类
 * </p>
 *
 * @author 田圃森
 * @since 2017-12-02
 */
public interface IAreaCodeService extends IService<AreaCode> {
    // 返回省市区信息
    AreaCode getAreaCode(String province, String city, String district);
    /**
     * province 为 null 返回所有省
     * province 非null， city 为null 返回该省下所有市
     *                   city 非null 返回该省市下所有区
     * @param province
     * @param city
     * @return
     */
    List<AreaCode> getAreaCodeList(String province, String city);

    // 模糊查询
    List<AreaCode> getByDescritpion(String desc);
}
