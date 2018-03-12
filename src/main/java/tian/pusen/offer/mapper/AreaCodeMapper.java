package tian.pusen.offer.mapper;

import org.apache.ibatis.annotations.Select;
import tian.pusen.offer.entity.AreaCode;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
  * 地区代码 Mapper 接口
 * </p>
 *
 * @author 田圃森
 * @since 2017-12-02
 */
public interface AreaCodeMapper extends BaseMapper<AreaCode> {
    @Select("SELECT * FROM area_code WHERE description LIKE concat(concat('%',#{partDesc}),'%') ORDER BY id")
    public List<AreaCode> getByDescription(String partDesc);
}