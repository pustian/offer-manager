package tian.pusen.offer.web.vo.order;

import com.baomidou.mybatisplus.annotations.TableField;
import org.springframework.beans.factory.annotation.Autowired;
import tian.pusen.offer.web.vo.entity.ReqEntity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 * Date: 2017/12/9 15:25
 *
 * @author tianpusen
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class OrderReq implements ReqEntity {
    /*** 订单编号     */
    private String orderId;
    /*** 产品号     */
    private String productId;
    /*** 报价号     */
    private String offerId;
    /*** 订单价以元为单位     */
    private String price;
    /*** 币种     */
    private String currency;
    /*** 订单数量     */
    private String quantity;
    /*** 从买方考量的订单履行的时间，以天为单位    1,2 */
    private String leadTime;
    /*** 从卖方的角度来考虑，以天为单位     */
    private String deliveryTime;
    /*** 备注     */
    private String remark;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getOfferId() {
        return offerId;
    }

    public void setOfferId(String offerId) {
        this.offerId = offerId;
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

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getLeadTime() {
        return leadTime;
    }

    public void setLeadTime(String leadTime) {
        this.leadTime = leadTime;
    }

    public String getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "OrderReq{" +
                "orderId='" + orderId + '\'' +
                ", productId='" + productId + '\'' +
                ", offerId='" + offerId + '\'' +
                ", price='" + price + '\'' +
                ", currency='" + currency + '\'' +
                ", quantity='" + quantity + '\'' +
                ", leadTime='" + leadTime + '\'' +
                ", deliveryTime='" + deliveryTime + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
