package tian.pusen.offer.mapper;

import org.apache.ibatis.annotations.Select;
import tian.pusen.offer.entity.CompanyProduct;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
  * 产品信息 Mapper 接口
 * </p>
 *
 * @author 田圃森
 * @since 2017-12-02
 */
public interface CompanyProductMapper extends BaseMapper<CompanyProduct> {
    @Select("SELECT name FROM company_product WHERE name LIKE concat(concat('%',#{partName}),'%') ORDER BY name")
    public List<String> getNameList(String partName);
}