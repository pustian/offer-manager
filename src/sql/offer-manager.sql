-- create database pingchuan;

CREATE TABLE customer (
    id bigint unsigned NOT NULL AUTO_INCREMENT comment '主键' ,
    customer_id  char(32) NOT NULL comment '客户编号',
    name  varchar(128) NOT NULL comment '公司名',
    license_no varchar(32) comment '公司营业执照号',
    short_name varchar(32) NULL comment '简称',
    name_en varchar(128) comment '公司英文名',
    province char(2) comment '所在省',
    city char(2) comment '所在市',
    district char(2) comment '所在区县',
    street varchar(128) comment '所在街道',
    phone varchar(32) comment '电话',
    fax varchar(32) comment '传真',
    mail varchar(64) comment '邮箱',
    linkman varchar(8) comment '联系人姓名',
    account varchar(32) comment '公司结算账户',
    is_deleted tinyint unsigned default 0 comment '数据是否删除 0：使用中，1:删除',
    grade char(1) default 'C' comment '内部客户评级A最好，B, C, D, E最差',
    remark varchar(128) comment '备注信息',
    gmt_create  datetime not NULL comment '创建时间 yyyymmdd hh24miss',
    gmt_modified  datetime not NULL comment '更新时间 yyyymmdd hh24miss',
    PRIMARY KEY (id)
) engine=InnoDB DEFAULT charset=utf8;
CREATE UNIQUE INDEX uk_name ON customer(name);
CREATE UNIQUE INDEX uk_customer_id ON customer(customer_id);
ALTER TABLE customer comment '客户信息';

--- ALTER TABLE customer modify is_deleted  tinyint unsigned NOT NULL default 0;
--- ALTER TABLE customer modify level  char(1) NOT NULL default 'C';

CREATE TABLE company_product (
    id bigint unsigned NOT NULL AUTO_INCREMENT comment '主键' ,
    product_id char(32) NOT NULL comment '产品内部标识',
    name varchar(128) NOT NULL comment '产品名称',
    short_name varchar(32) NULL comment '产品简称',
    type varchar(32) NULL comment '产品类型',
    price decimal(18,4) comment '成本价以元为单位',
    currency char(3) comment '币种',
    remain int unsigned comment '存量',
    status char(1) comment '0：缺货 1：正常',
    is_deleted tinyint unsigned default 0 comment '数据是否删除 0：使用中，1:删除',
    remark varchar(128) comment '备注信息',
    gmt_create  datetime not NULL comment '创建时间 yyyymmdd hh24miss',
    gmt_modified  datetime not NULL comment '更新时间 yyyymmdd hh24miss',
    PRIMARY KEY (id)
) engine=InnoDB DEFAULT charset=utf8;
ALTER TABLE company_product comment '产品信息';
CREATE UNIQUE INDEX uk_name ON company_product(name);
CREATE UNIQUE INDEX uk_product_id ON company_product (product_id);

CREATE TABLE customer_order (
    id bigint unsigned NOT NULL AUTO_INCREMENT comment '主键' ,
    order_id char(32) NOT NULL comment '订单编号',
    product_id char(32) NOT NULL comment '产品号',
    offer_id char(32) NOT NULL comment '报价号',
    price decimal(18,4) comment '订单价以元为单位',
    currency char(3) comment '币种',
    quantity int unsigned comment '订单数量',
    lead_time int unsigned comment '从买方考量的订单履行的时间，以天为单位',
    delivery_time int unsigned comment '从卖方的角度来考虑，以天为单位',
    remark varchar(128) comment '备注',
    is_deleted tinyint unsigned default 0 comment '数据是否删除 0：使用中，1:删除',
    gmt_create  datetime not NULL comment '创建时间 yyyymmdd hh24miss',
    gmt_modified  datetime not NULL comment '更新时间 yyyymmdd hh24miss',
    PRIMARY KEY (id)
) engine=InnoDB DEFAULT charset=utf8;
ALTER TABLE customer_order comment '订单信息';
CREATE UNIQUE INDEX uk_order_id ON customer_order(order_id);
CREATE INDEX idx_product_id ON customer_order(product_id);
CREATE INDEX idx_offer_id ON customer_order(offer_id);

CREATE TABLE customer_offer (
    id  bigint unsigned NOT NULL AUTO_INCREMENT comment '主键',
    offer_id  char(32) NOT NULL comment '报价号',
    customer_id char(32) NOT NULL comment '客户编号',
    price  decimal(18,4) comment '总定价',
    currency char(3) comment '币种',
    carriage_price decimal(18,4) comment '运费',
    carriage_currency char(3) comment '运费币种',
    fee decimal(18,4) comment '其他关费等',
    fee_currency char(3) comment '其他费币种',
    status char(1) comment '订单状态 0:进行中，1：已完成，2:逾期，3：部分逾期，9：其他',
    remark varchar(80) comment '备注',
    is_deleted tinyint unsigned default 0 comment '数据是否删除 0：使用中，1:删除',
    gmt_create  datetime not NULL comment '创建时间 yyyymmdd hh24miss',
    gmt_modified  datetime not NULL comment '更新时间 yyyymmdd hh24miss',
    PRIMARY KEY (id)
) engine=InnoDB DEFAULT charset=utf8;
ALTER TABLE customer_offer comment '报价信息';
CREATE UNIQUE INDEX uk_offer_id ON customer_offer(offer_id);
CREATE INDEX idx_customer_id ON customer_offer(customer_id);