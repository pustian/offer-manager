package tian.pusen.offer.web.vo.product;

import com.baomidou.mybatisplus.annotations.TableField;
import tian.pusen.offer.web.vo.entity.ReqEntity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 * Date: 2017/12/6 20:30
 *
 * @author tianpusen
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class ProductReq implements ReqEntity {
    private String productId;
    /*** 产品名称     */
    private String name;
    /*** 产品简称     */
    private String shortName;
    /*** 成本价以元为单位 */
    private String price;
    /*** 币种     */
    private String currency;
    /*** 存量     */
    private String remain;
    /*** 0：缺货 1：正常     */
    private String status;
    /*** 备注信息     */
    private String remark;
    /*** 创建时间 yyyymmdd hh24miss */
    private String gmtCreate;
    /*** 更新时间 yyyymmdd hh24miss     */
    private String gmtModified;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getRemain() {
        return remain;
    }

    public void setRemain(String remain) {
        this.remain = remain;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(String gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public String getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(String gmtModified) {
        this.gmtModified = gmtModified;
    }

    @Override
    public String toString() {
        return "ProductReq{" +
                "productId='" + productId + '\'' +
                ", name='" + name + '\'' +
                ", shortName='" + shortName + '\'' +
                ", price='" + price + '\'' +
                ", currency='" + currency + '\'' +
                ", remain='" + remain + '\'' +
                ", status='" + status + '\'' +
                ", remark='" + remark + '\'' +
                ", gmtCreate='" + gmtCreate + '\'' +
                ", gmtModified='" + gmtModified + '\'' +
                '}';
    }
}
