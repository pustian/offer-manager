package tian.pusen.offer.web.vo.areacode;

import com.baomidou.mybatisplus.annotations.TableField;
import tian.pusen.offer.web.vo.entity.RespEntity;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 * Date: 2017/12/5 12:32
 *
 * @author tianpusen
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public final class AreaCodeResp implements RespEntity {
    /*** 省     */
    private String province;
    /*** 市     */
    private String city;
    /*** 区县     */
    private String district;
    /*** 数据是否删除 0：使用中，1:删除     */
    @TableField("is_deleted")
    private String isDeleted;
    private String description;

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "AreaCodeResp{" +
                "province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", district='" + district + '\'' +
                ", isDeleted=" + isDeleted +
                ", description='" + description + '\'' +
                '}';
    }
}
