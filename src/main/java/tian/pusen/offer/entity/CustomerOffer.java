package tian.pusen.offer.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import java.math.BigDecimal;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;


/**
 * <p>
 * 报价信息
 * </p>
 *
 * @author 田圃森
 * @since 2017-12-09
 */
@TableName("customer_offer")
public class CustomerOffer extends Model<CustomerOffer> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
	private Long id;
    /**
     * 报价号
     */
	@TableField("offer_id")
	private String offerId;
    /**
     * 客户编号
     */
	@TableField("customer_id")
	private String customerId;
    /**
     * 总定价
     */
	private BigDecimal price;
    /**
     * 币种
     */
	private String currency;
    /**
     * 运费
     */
	@TableField("carriage_price")
	private BigDecimal carriagePrice;
    /**
     * 运费币种
     */
	@TableField("carriage_currency")
	private String carriageCurrency;
    /**
     * 其他关费等
     */
	private BigDecimal fee;
    /**
     * 其他费币种
     */
	@TableField("fee_currency")
	private String feeCurrency;
    /**
     * 订单状态 0:进行中，1：已完成，2:逾期，3：部分逾期，9：其他
     */
	private String status;
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

	public BigDecimal getCarriagePrice() {
		return carriagePrice;
	}

	public void setCarriagePrice(BigDecimal carriagePrice) {
		this.carriagePrice = carriagePrice;
	}

	public String getCarriageCurrency() {
		return carriageCurrency;
	}

	public void setCarriageCurrency(String carriageCurrency) {
		this.carriageCurrency = carriageCurrency;
	}

	public BigDecimal getFee() {
		return fee;
	}

	public void setFee(BigDecimal fee) {
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
