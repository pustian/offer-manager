package tian.pusen.offer.web.vo.customer;

import tian.pusen.offer.web.vo.entity.ReqEntity;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 * Date: 2017/12/3 12:26
 *
 * @author tianpusen
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public final class CustomerReq implements ReqEntity {
    private static final long serialVersionUID = 1L;

    /*** 客户编号  */
    private String customerId;
    /*** 公司名     */
    private String name;
    /*** 简称     */
    private String shortName;
    /*** 公司英文名     */
    private String nameEn;
    /*** 所在省     */
    private String province;
    /*** 所在市     */
    private String city;
    /*** 所在区县     */
    private String district;
    /*** 所在街道     */
    private String street;
    /*** 电话     */
    private String phone;
    /*** 传真     */
    private String fax;
    /*** 邮箱     */
    private String mail;
    /*** 联系人姓名     */
    private String linkman;
    /*** 公司卡号     */
    private String account;
    private String isDeleted;
    private String level;
    /*** 备注信息     */
    private String remark;

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

    public String getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "CustomerReq{" +
                "customerId='" + customerId + '\'' +
                ", name='" + name + '\'' +
                ", shortName='" + shortName + '\'' +
                ", nameEn='" + nameEn + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", district='" + district + '\'' +
                ", street='" + street + '\'' +
                ", phone='" + phone + '\'' +
                ", fax='" + fax + '\'' +
                ", mail='" + mail + '\'' +
                ", linkman='" + linkman + '\'' +
                ", account='" + account + '\'' +
                ", isDeleted='" + isDeleted + '\'' +
                ", level='" + level + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
