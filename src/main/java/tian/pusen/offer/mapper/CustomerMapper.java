package tian.pusen.offer.mapper;

import org.apache.ibatis.annotations.Select;
import tian.pusen.offer.entity.Customer;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
  * 客户信息 Mapper 接口
 * </p>
 *
 * @author 田圃森
 * @since 2017-12-02
 */
public interface CustomerMapper extends BaseMapper<Customer> {
    @Select("SELECT name FROM customer WHERE name LIKE concat(concat('%',#{partName}),'%') ORDER BY name")
    public List<String> getNameList(String partName);
}