package tian.pusen.offer.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;


/**
 * <p>
 * 客户信息
 * </p>
 *
 * @author 田圃森
 * @since 2017-12-09
 */
@TableName("customer")
public class Customer extends Model<Customer> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
	private Long id;
    /**
     * 客户编号
     */
	@TableField("customer_id")
	private String customerId;
    /**
     * 公司名
     */
	private String name;
    /**
     * 公司营业执照号
     */
	@TableField("license_no")
	private String licenseNo;
    /**
     * 简称
     */
	@TableField("short_name")
	private String shortName;
    /**
     * 公司英文名
     */
	@TableField("name_en")
	private String nameEn;
    /**
     * 所在省
     */
	private String province;
    /**
     * 所在市
     */
	private String city;
    /**
     * 所在区县
     */
	private String district;
    /**
     * 所在街道
     */
	private String street;
    /**
     * 电话
     */
	private String phone;
    /**
     * 传真
     */
	private String fax;
    /**
     * 邮箱
     */
	private String mail;
    /**
     * 联系人姓名
     */
	private String linkman;
    /**
     * 公司结算账户
     */
	private String account;
    /**
     * 数据是否删除 0：使用中，1:删除
     */
	@TableField("is_deleted")
	private Integer isDeleted;
    /**
     * 内部客户评级A最好，B, C, D, E最差
     */
	private String grade;
    /**
     * 备注信息
     */
	private String remark;
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

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLicenseNo() {
		return licenseNo;
	}

	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getNameEn() {
		return nameEn;
	}

	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}

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

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getLinkman() {
		return linkman;
	}

	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public Integer getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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
