package tian.pusen.offer.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import java.math.BigDecimal;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;


/**
 * <p>
 * 订单信息
 * </p>
 *
 * @author 田圃森
 * @since 2017-12-09
 */
@TableName("customer_order")
public class CustomerOrder extends Model<CustomerOrder> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
	private Long id;
    /**
     * 订单编号
     */
	@TableField("order_id")
	private String orderId;
    /**
     * 产品号
     */
	@TableField("product_id")
	private String productId;
    /**
     * 报价号
     */
	@TableField("offer_id")
	private String offerId;
    /**
     * 订单价以元为单位
     */
	private BigDecimal price;
    /**
     * 币种
     */
	private String currency;
    /**
     * 订单数量
     */
	private Integer quantity;
    /**
     * 从买方考量的订单履行的时间，以天为单位
     */
	@TableField("lead_time")
	private Integer leadTime;
    /**
     * 从卖方的角度来考虑，以天为单位
     */
	@TableField("delivery_time")
	private Integer deliveryTime;
    /**
     * 备注
     */
	private String remark;
    /**
     * 数据是否删除 0：使用中，1:删除
     */
	@TableField("is_deleted")
	private Integer isDeleted;
    /**
     * 创建时间 yyyymmdd hh24miss
     */
	@TableField("gmt_create")
	private Date gmtCreate;
    /**
     * 更新时间 yyyymmdd hh24miss
     */
	@TableField("gmt_modified")
	private Date gmtModified;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getLeadTime() {
		return leadTime;
	}

	public void setLeadTime(Integer leadTime) {
		this.leadTime = leadTime;
	}

	public Integer getDeliveryTime() {
		return deliveryTime;
	}

	public void setDeliveryTime(Integer deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Date getGmtCreate() {
		return gmtCreate;
	}

	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	public Date getGmtModified() {
		return gmtModified;
	}

	public void setGmtModified(Date gmtModified) {
		this.gmtModified = gmtModified;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
