package tian.pusen.offer.web.vo.offer;

import tian.pusen.offer.web.vo.entity.ReqEntity;
import tian.pusen.offer.web.vo.order.OrderReq;

import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 * Date: 2017/12/8 22:53
 *
 * @author tianpusen
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class OfferReq implements ReqEntity{
    /**     * 报价号     */
    private String offerId;
    /**     * 客户编号     */
    private String customerId;
    /**     * 总定价     */
    private String price;
    /**     * 币种     */
    private String currency;
    /**     * 运费     */
    private String carriagePrice;
    /**     * 运费币种     */
    private String carriageCurrency;
    /**     * 其他关费等     */
    private String fee;
    /**     * 其他费币种     */
    private String feeCurrency;
    /**     * 订单状态 0:进行中，1：已完成，2:逾期，3：部分逾期，9：其他     */
    private String status;
    /**     * 备注     */
    private String remark;

    private List<OrderReq> orderReqList;

    public String getOfferId() {
        return offerId;
    }

    public void setOfferId(String offerId) {
        this.offerId = offerId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
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

    public String getCarriagePrice() {
        return carriagePrice;
    }

    public void setCarriagePrice(String carriagePrice) {
        this.carriagePrice = carriagePrice;
    }

    public String getCarriageCurrency() {
        return carriageCurrency;
    }

    public void setCarriageCurrency(String carriageCurrency) {
        this.carriageCurrency = carriageCurrency;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public String getFeeCurrency() {
        return feeCurrency;
    }

    public void setFeeCurrency(String feeCurrency) {
        this.feeCurrency = feeCurrency;
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

    public List<OrderReq> getOrderReqList() {
        return orderReqList;
    }

    public void setOrderReqList(List<OrderReq> orderReqList) {
        this.orderReqList = orderReqList;
    }

    @Override
    public String toString() {
        return "OfferReq{" +
                "offerId='" + offerId + '\'' +
                ", customerId='" + customerId + '\'' +
                ", price='" + price + '\'' +
                ", currency='" + currency + '\'' +
                ", carriagePrice='" + carriagePrice + '\'' +
                ", carriageCurrency='" + carriageCurrency + '\'' +
                ", fee='" + fee + '\'' +
                ", feeCurrency='" + feeCurrency + '\'' +
                ", status='" + status + '\'' +
                ", remark='" + remark + '\'' +
                ", orderReqList='" + orderReqList + '\'' +
                '}';
    }
}
