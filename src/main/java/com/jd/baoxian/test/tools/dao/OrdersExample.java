package com.jd.baoxian.test.tools.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrdersExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrdersExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("Id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("Id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("Id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("Id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("Id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("Id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("Id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("Id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("Id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("Id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("Id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("Id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andOrderidIsNull() {
            addCriterion("OrderId is null");
            return (Criteria) this;
        }

        public Criteria andOrderidIsNotNull() {
            addCriterion("OrderId is not null");
            return (Criteria) this;
        }

        public Criteria andOrderidEqualTo(String value) {
            addCriterion("OrderId =", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidNotEqualTo(String value) {
            addCriterion("OrderId <>", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidGreaterThan(String value) {
            addCriterion("OrderId >", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidGreaterThanOrEqualTo(String value) {
            addCriterion("OrderId >=", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidLessThan(String value) {
            addCriterion("OrderId <", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidLessThanOrEqualTo(String value) {
            addCriterion("OrderId <=", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidLike(String value) {
            addCriterion("OrderId like", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidNotLike(String value) {
            addCriterion("OrderId not like", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidIn(List<String> values) {
            addCriterion("OrderId in", values, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidNotIn(List<String> values) {
            addCriterion("OrderId not in", values, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidBetween(String value1, String value2) {
            addCriterion("OrderId between", value1, value2, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidNotBetween(String value1, String value2) {
            addCriterion("OrderId not between", value1, value2, "orderid");
            return (Criteria) this;
        }

        public Criteria andPinIsNull() {
            addCriterion("Pin is null");
            return (Criteria) this;
        }

        public Criteria andPinIsNotNull() {
            addCriterion("Pin is not null");
            return (Criteria) this;
        }

        public Criteria andPinEqualTo(String value) {
            addCriterion("Pin =", value, "pin");
            return (Criteria) this;
        }

        public Criteria andPinNotEqualTo(String value) {
            addCriterion("Pin <>", value, "pin");
            return (Criteria) this;
        }

        public Criteria andPinGreaterThan(String value) {
            addCriterion("Pin >", value, "pin");
            return (Criteria) this;
        }

        public Criteria andPinGreaterThanOrEqualTo(String value) {
            addCriterion("Pin >=", value, "pin");
            return (Criteria) this;
        }

        public Criteria andPinLessThan(String value) {
            addCriterion("Pin <", value, "pin");
            return (Criteria) this;
        }

        public Criteria andPinLessThanOrEqualTo(String value) {
            addCriterion("Pin <=", value, "pin");
            return (Criteria) this;
        }

        public Criteria andPinLike(String value) {
            addCriterion("Pin like", value, "pin");
            return (Criteria) this;
        }

        public Criteria andPinNotLike(String value) {
            addCriterion("Pin not like", value, "pin");
            return (Criteria) this;
        }

        public Criteria andPinIn(List<String> values) {
            addCriterion("Pin in", values, "pin");
            return (Criteria) this;
        }

        public Criteria andPinNotIn(List<String> values) {
            addCriterion("Pin not in", values, "pin");
            return (Criteria) this;
        }

        public Criteria andPinBetween(String value1, String value2) {
            addCriterion("Pin between", value1, value2, "pin");
            return (Criteria) this;
        }

        public Criteria andPinNotBetween(String value1, String value2) {
            addCriterion("Pin not between", value1, value2, "pin");
            return (Criteria) this;
        }

        public Criteria andCustomernameIsNull() {
            addCriterion("CustomerName is null");
            return (Criteria) this;
        }

        public Criteria andCustomernameIsNotNull() {
            addCriterion("CustomerName is not null");
            return (Criteria) this;
        }

        public Criteria andCustomernameEqualTo(String value) {
            addCriterion("CustomerName =", value, "customername");
            return (Criteria) this;
        }

        public Criteria andCustomernameNotEqualTo(String value) {
            addCriterion("CustomerName <>", value, "customername");
            return (Criteria) this;
        }

        public Criteria andCustomernameGreaterThan(String value) {
            addCriterion("CustomerName >", value, "customername");
            return (Criteria) this;
        }

        public Criteria andCustomernameGreaterThanOrEqualTo(String value) {
            addCriterion("CustomerName >=", value, "customername");
            return (Criteria) this;
        }

        public Criteria andCustomernameLessThan(String value) {
            addCriterion("CustomerName <", value, "customername");
            return (Criteria) this;
        }

        public Criteria andCustomernameLessThanOrEqualTo(String value) {
            addCriterion("CustomerName <=", value, "customername");
            return (Criteria) this;
        }

        public Criteria andCustomernameLike(String value) {
            addCriterion("CustomerName like", value, "customername");
            return (Criteria) this;
        }

        public Criteria andCustomernameNotLike(String value) {
            addCriterion("CustomerName not like", value, "customername");
            return (Criteria) this;
        }

        public Criteria andCustomernameIn(List<String> values) {
            addCriterion("CustomerName in", values, "customername");
            return (Criteria) this;
        }

        public Criteria andCustomernameNotIn(List<String> values) {
            addCriterion("CustomerName not in", values, "customername");
            return (Criteria) this;
        }

        public Criteria andCustomernameBetween(String value1, String value2) {
            addCriterion("CustomerName between", value1, value2, "customername");
            return (Criteria) this;
        }

        public Criteria andCustomernameNotBetween(String value1, String value2) {
            addCriterion("CustomerName not between", value1, value2, "customername");
            return (Criteria) this;
        }

        public Criteria andPaytypeIsNull() {
            addCriterion("PayType is null");
            return (Criteria) this;
        }

        public Criteria andPaytypeIsNotNull() {
            addCriterion("PayType is not null");
            return (Criteria) this;
        }

        public Criteria andPaytypeEqualTo(Short value) {
            addCriterion("PayType =", value, "paytype");
            return (Criteria) this;
        }

        public Criteria andPaytypeNotEqualTo(Short value) {
            addCriterion("PayType <>", value, "paytype");
            return (Criteria) this;
        }

        public Criteria andPaytypeGreaterThan(Short value) {
            addCriterion("PayType >", value, "paytype");
            return (Criteria) this;
        }

        public Criteria andPaytypeGreaterThanOrEqualTo(Short value) {
            addCriterion("PayType >=", value, "paytype");
            return (Criteria) this;
        }

        public Criteria andPaytypeLessThan(Short value) {
            addCriterion("PayType <", value, "paytype");
            return (Criteria) this;
        }

        public Criteria andPaytypeLessThanOrEqualTo(Short value) {
            addCriterion("PayType <=", value, "paytype");
            return (Criteria) this;
        }

        public Criteria andPaytypeIn(List<Short> values) {
            addCriterion("PayType in", values, "paytype");
            return (Criteria) this;
        }

        public Criteria andPaytypeNotIn(List<Short> values) {
            addCriterion("PayType not in", values, "paytype");
            return (Criteria) this;
        }

        public Criteria andPaytypeBetween(Short value1, Short value2) {
            addCriterion("PayType between", value1, value2, "paytype");
            return (Criteria) this;
        }

        public Criteria andPaytypeNotBetween(Short value1, Short value2) {
            addCriterion("PayType not between", value1, value2, "paytype");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNull() {
            addCriterion("Province is null");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNotNull() {
            addCriterion("Province is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceEqualTo(String value) {
            addCriterion("Province =", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotEqualTo(String value) {
            addCriterion("Province <>", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThan(String value) {
            addCriterion("Province >", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("Province >=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThan(String value) {
            addCriterion("Province <", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThanOrEqualTo(String value) {
            addCriterion("Province <=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLike(String value) {
            addCriterion("Province like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotLike(String value) {
            addCriterion("Province not like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceIn(List<String> values) {
            addCriterion("Province in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotIn(List<String> values) {
            addCriterion("Province not in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceBetween(String value1, String value2) {
            addCriterion("Province between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotBetween(String value1, String value2) {
            addCriterion("Province not between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andCityIsNull() {
            addCriterion("City is null");
            return (Criteria) this;
        }

        public Criteria andCityIsNotNull() {
            addCriterion("City is not null");
            return (Criteria) this;
        }

        public Criteria andCityEqualTo(String value) {
            addCriterion("City =", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotEqualTo(String value) {
            addCriterion("City <>", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThan(String value) {
            addCriterion("City >", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThanOrEqualTo(String value) {
            addCriterion("City >=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThan(String value) {
            addCriterion("City <", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThanOrEqualTo(String value) {
            addCriterion("City <=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLike(String value) {
            addCriterion("City like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotLike(String value) {
            addCriterion("City not like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityIn(List<String> values) {
            addCriterion("City in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotIn(List<String> values) {
            addCriterion("City not in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityBetween(String value1, String value2) {
            addCriterion("City between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotBetween(String value1, String value2) {
            addCriterion("City not between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andCountyIsNull() {
            addCriterion("County is null");
            return (Criteria) this;
        }

        public Criteria andCountyIsNotNull() {
            addCriterion("County is not null");
            return (Criteria) this;
        }

        public Criteria andCountyEqualTo(String value) {
            addCriterion("County =", value, "county");
            return (Criteria) this;
        }

        public Criteria andCountyNotEqualTo(String value) {
            addCriterion("County <>", value, "county");
            return (Criteria) this;
        }

        public Criteria andCountyGreaterThan(String value) {
            addCriterion("County >", value, "county");
            return (Criteria) this;
        }

        public Criteria andCountyGreaterThanOrEqualTo(String value) {
            addCriterion("County >=", value, "county");
            return (Criteria) this;
        }

        public Criteria andCountyLessThan(String value) {
            addCriterion("County <", value, "county");
            return (Criteria) this;
        }

        public Criteria andCountyLessThanOrEqualTo(String value) {
            addCriterion("County <=", value, "county");
            return (Criteria) this;
        }

        public Criteria andCountyLike(String value) {
            addCriterion("County like", value, "county");
            return (Criteria) this;
        }

        public Criteria andCountyNotLike(String value) {
            addCriterion("County not like", value, "county");
            return (Criteria) this;
        }

        public Criteria andCountyIn(List<String> values) {
            addCriterion("County in", values, "county");
            return (Criteria) this;
        }

        public Criteria andCountyNotIn(List<String> values) {
            addCriterion("County not in", values, "county");
            return (Criteria) this;
        }

        public Criteria andCountyBetween(String value1, String value2) {
            addCriterion("County between", value1, value2, "county");
            return (Criteria) this;
        }

        public Criteria andCountyNotBetween(String value1, String value2) {
            addCriterion("County not between", value1, value2, "county");
            return (Criteria) this;
        }

        public Criteria andAdressIsNull() {
            addCriterion("Adress is null");
            return (Criteria) this;
        }

        public Criteria andAdressIsNotNull() {
            addCriterion("Adress is not null");
            return (Criteria) this;
        }

        public Criteria andAdressEqualTo(String value) {
            addCriterion("Adress =", value, "adress");
            return (Criteria) this;
        }

        public Criteria andAdressNotEqualTo(String value) {
            addCriterion("Adress <>", value, "adress");
            return (Criteria) this;
        }

        public Criteria andAdressGreaterThan(String value) {
            addCriterion("Adress >", value, "adress");
            return (Criteria) this;
        }

        public Criteria andAdressGreaterThanOrEqualTo(String value) {
            addCriterion("Adress >=", value, "adress");
            return (Criteria) this;
        }

        public Criteria andAdressLessThan(String value) {
            addCriterion("Adress <", value, "adress");
            return (Criteria) this;
        }

        public Criteria andAdressLessThanOrEqualTo(String value) {
            addCriterion("Adress <=", value, "adress");
            return (Criteria) this;
        }

        public Criteria andAdressLike(String value) {
            addCriterion("Adress like", value, "adress");
            return (Criteria) this;
        }

        public Criteria andAdressNotLike(String value) {
            addCriterion("Adress not like", value, "adress");
            return (Criteria) this;
        }

        public Criteria andAdressIn(List<String> values) {
            addCriterion("Adress in", values, "adress");
            return (Criteria) this;
        }

        public Criteria andAdressNotIn(List<String> values) {
            addCriterion("Adress not in", values, "adress");
            return (Criteria) this;
        }

        public Criteria andAdressBetween(String value1, String value2) {
            addCriterion("Adress between", value1, value2, "adress");
            return (Criteria) this;
        }

        public Criteria andAdressNotBetween(String value1, String value2) {
            addCriterion("Adress not between", value1, value2, "adress");
            return (Criteria) this;
        }

        public Criteria andZipIsNull() {
            addCriterion("Zip is null");
            return (Criteria) this;
        }

        public Criteria andZipIsNotNull() {
            addCriterion("Zip is not null");
            return (Criteria) this;
        }

        public Criteria andZipEqualTo(String value) {
            addCriterion("Zip =", value, "zip");
            return (Criteria) this;
        }

        public Criteria andZipNotEqualTo(String value) {
            addCriterion("Zip <>", value, "zip");
            return (Criteria) this;
        }

        public Criteria andZipGreaterThan(String value) {
            addCriterion("Zip >", value, "zip");
            return (Criteria) this;
        }

        public Criteria andZipGreaterThanOrEqualTo(String value) {
            addCriterion("Zip >=", value, "zip");
            return (Criteria) this;
        }

        public Criteria andZipLessThan(String value) {
            addCriterion("Zip <", value, "zip");
            return (Criteria) this;
        }

        public Criteria andZipLessThanOrEqualTo(String value) {
            addCriterion("Zip <=", value, "zip");
            return (Criteria) this;
        }

        public Criteria andZipLike(String value) {
            addCriterion("Zip like", value, "zip");
            return (Criteria) this;
        }

        public Criteria andZipNotLike(String value) {
            addCriterion("Zip not like", value, "zip");
            return (Criteria) this;
        }

        public Criteria andZipIn(List<String> values) {
            addCriterion("Zip in", values, "zip");
            return (Criteria) this;
        }

        public Criteria andZipNotIn(List<String> values) {
            addCriterion("Zip not in", values, "zip");
            return (Criteria) this;
        }

        public Criteria andZipBetween(String value1, String value2) {
            addCriterion("Zip between", value1, value2, "zip");
            return (Criteria) this;
        }

        public Criteria andZipNotBetween(String value1, String value2) {
            addCriterion("Zip not between", value1, value2, "zip");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("Phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("Phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("Phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("Phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("Phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("Phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("Phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("Phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("Phone like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("Phone not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("Phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("Phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("Phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("Phone not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("Email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("Email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("Email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("Email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("Email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("Email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("Email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("Email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("Email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("Email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("Email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("Email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("Email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("Email not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andSourcetypeIsNull() {
            addCriterion("SourceType is null");
            return (Criteria) this;
        }

        public Criteria andSourcetypeIsNotNull() {
            addCriterion("SourceType is not null");
            return (Criteria) this;
        }

        public Criteria andSourcetypeEqualTo(String value) {
            addCriterion("SourceType =", value, "sourcetype");
            return (Criteria) this;
        }

        public Criteria andSourcetypeNotEqualTo(String value) {
            addCriterion("SourceType <>", value, "sourcetype");
            return (Criteria) this;
        }

        public Criteria andSourcetypeGreaterThan(String value) {
            addCriterion("SourceType >", value, "sourcetype");
            return (Criteria) this;
        }

        public Criteria andSourcetypeGreaterThanOrEqualTo(String value) {
            addCriterion("SourceType >=", value, "sourcetype");
            return (Criteria) this;
        }

        public Criteria andSourcetypeLessThan(String value) {
            addCriterion("SourceType <", value, "sourcetype");
            return (Criteria) this;
        }

        public Criteria andSourcetypeLessThanOrEqualTo(String value) {
            addCriterion("SourceType <=", value, "sourcetype");
            return (Criteria) this;
        }

        public Criteria andSourcetypeLike(String value) {
            addCriterion("SourceType like", value, "sourcetype");
            return (Criteria) this;
        }

        public Criteria andSourcetypeNotLike(String value) {
            addCriterion("SourceType not like", value, "sourcetype");
            return (Criteria) this;
        }

        public Criteria andSourcetypeIn(List<String> values) {
            addCriterion("SourceType in", values, "sourcetype");
            return (Criteria) this;
        }

        public Criteria andSourcetypeNotIn(List<String> values) {
            addCriterion("SourceType not in", values, "sourcetype");
            return (Criteria) this;
        }

        public Criteria andSourcetypeBetween(String value1, String value2) {
            addCriterion("SourceType between", value1, value2, "sourcetype");
            return (Criteria) this;
        }

        public Criteria andSourcetypeNotBetween(String value1, String value2) {
            addCriterion("SourceType not between", value1, value2, "sourcetype");
            return (Criteria) this;
        }

        public Criteria andDeliverytypeIsNull() {
            addCriterion("DeliveryType is null");
            return (Criteria) this;
        }

        public Criteria andDeliverytypeIsNotNull() {
            addCriterion("DeliveryType is not null");
            return (Criteria) this;
        }

        public Criteria andDeliverytypeEqualTo(Short value) {
            addCriterion("DeliveryType =", value, "deliverytype");
            return (Criteria) this;
        }

        public Criteria andDeliverytypeNotEqualTo(Short value) {
            addCriterion("DeliveryType <>", value, "deliverytype");
            return (Criteria) this;
        }

        public Criteria andDeliverytypeGreaterThan(Short value) {
            addCriterion("DeliveryType >", value, "deliverytype");
            return (Criteria) this;
        }

        public Criteria andDeliverytypeGreaterThanOrEqualTo(Short value) {
            addCriterion("DeliveryType >=", value, "deliverytype");
            return (Criteria) this;
        }

        public Criteria andDeliverytypeLessThan(Short value) {
            addCriterion("DeliveryType <", value, "deliverytype");
            return (Criteria) this;
        }

        public Criteria andDeliverytypeLessThanOrEqualTo(Short value) {
            addCriterion("DeliveryType <=", value, "deliverytype");
            return (Criteria) this;
        }

        public Criteria andDeliverytypeIn(List<Short> values) {
            addCriterion("DeliveryType in", values, "deliverytype");
            return (Criteria) this;
        }

        public Criteria andDeliverytypeNotIn(List<Short> values) {
            addCriterion("DeliveryType not in", values, "deliverytype");
            return (Criteria) this;
        }

        public Criteria andDeliverytypeBetween(Short value1, Short value2) {
            addCriterion("DeliveryType between", value1, value2, "deliverytype");
            return (Criteria) this;
        }

        public Criteria andDeliverytypeNotBetween(Short value1, Short value2) {
            addCriterion("DeliveryType not between", value1, value2, "deliverytype");
            return (Criteria) this;
        }

        public Criteria andOrdertypeIsNull() {
            addCriterion("OrderType is null");
            return (Criteria) this;
        }

        public Criteria andOrdertypeIsNotNull() {
            addCriterion("OrderType is not null");
            return (Criteria) this;
        }

        public Criteria andOrdertypeEqualTo(Long value) {
            addCriterion("OrderType =", value, "ordertype");
            return (Criteria) this;
        }

        public Criteria andOrdertypeNotEqualTo(Long value) {
            addCriterion("OrderType <>", value, "ordertype");
            return (Criteria) this;
        }

        public Criteria andOrdertypeGreaterThan(Long value) {
            addCriterion("OrderType >", value, "ordertype");
            return (Criteria) this;
        }

        public Criteria andOrdertypeGreaterThanOrEqualTo(Long value) {
            addCriterion("OrderType >=", value, "ordertype");
            return (Criteria) this;
        }

        public Criteria andOrdertypeLessThan(Long value) {
            addCriterion("OrderType <", value, "ordertype");
            return (Criteria) this;
        }

        public Criteria andOrdertypeLessThanOrEqualTo(Long value) {
            addCriterion("OrderType <=", value, "ordertype");
            return (Criteria) this;
        }

        public Criteria andOrdertypeIn(List<Long> values) {
            addCriterion("OrderType in", values, "ordertype");
            return (Criteria) this;
        }

        public Criteria andOrdertypeNotIn(List<Long> values) {
            addCriterion("OrderType not in", values, "ordertype");
            return (Criteria) this;
        }

        public Criteria andOrdertypeBetween(Long value1, Long value2) {
            addCriterion("OrderType between", value1, value2, "ordertype");
            return (Criteria) this;
        }

        public Criteria andOrdertypeNotBetween(Long value1, Long value2) {
            addCriterion("OrderType not between", value1, value2, "ordertype");
            return (Criteria) this;
        }

        public Criteria andOperatoripIsNull() {
            addCriterion("operatorip is null");
            return (Criteria) this;
        }

        public Criteria andOperatoripIsNotNull() {
            addCriterion("operatorip is not null");
            return (Criteria) this;
        }

        public Criteria andOperatoripEqualTo(String value) {
            addCriterion("operatorip =", value, "operatorip");
            return (Criteria) this;
        }

        public Criteria andOperatoripNotEqualTo(String value) {
            addCriterion("operatorip <>", value, "operatorip");
            return (Criteria) this;
        }

        public Criteria andOperatoripGreaterThan(String value) {
            addCriterion("operatorip >", value, "operatorip");
            return (Criteria) this;
        }

        public Criteria andOperatoripGreaterThanOrEqualTo(String value) {
            addCriterion("operatorip >=", value, "operatorip");
            return (Criteria) this;
        }

        public Criteria andOperatoripLessThan(String value) {
            addCriterion("operatorip <", value, "operatorip");
            return (Criteria) this;
        }

        public Criteria andOperatoripLessThanOrEqualTo(String value) {
            addCriterion("operatorip <=", value, "operatorip");
            return (Criteria) this;
        }

        public Criteria andOperatoripLike(String value) {
            addCriterion("operatorip like", value, "operatorip");
            return (Criteria) this;
        }

        public Criteria andOperatoripNotLike(String value) {
            addCriterion("operatorip not like", value, "operatorip");
            return (Criteria) this;
        }

        public Criteria andOperatoripIn(List<String> values) {
            addCriterion("operatorip in", values, "operatorip");
            return (Criteria) this;
        }

        public Criteria andOperatoripNotIn(List<String> values) {
            addCriterion("operatorip not in", values, "operatorip");
            return (Criteria) this;
        }

        public Criteria andOperatoripBetween(String value1, String value2) {
            addCriterion("operatorip between", value1, value2, "operatorip");
            return (Criteria) this;
        }

        public Criteria andOperatoripNotBetween(String value1, String value2) {
            addCriterion("operatorip not between", value1, value2, "operatorip");
            return (Criteria) this;
        }

        public Criteria andTotalpriceIsNull() {
            addCriterion("TotalPrice is null");
            return (Criteria) this;
        }

        public Criteria andTotalpriceIsNotNull() {
            addCriterion("TotalPrice is not null");
            return (Criteria) this;
        }

        public Criteria andTotalpriceEqualTo(BigDecimal value) {
            addCriterion("TotalPrice =", value, "totalprice");
            return (Criteria) this;
        }

        public Criteria andTotalpriceNotEqualTo(BigDecimal value) {
            addCriterion("TotalPrice <>", value, "totalprice");
            return (Criteria) this;
        }

        public Criteria andTotalpriceGreaterThan(BigDecimal value) {
            addCriterion("TotalPrice >", value, "totalprice");
            return (Criteria) this;
        }

        public Criteria andTotalpriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("TotalPrice >=", value, "totalprice");
            return (Criteria) this;
        }

        public Criteria andTotalpriceLessThan(BigDecimal value) {
            addCriterion("TotalPrice <", value, "totalprice");
            return (Criteria) this;
        }

        public Criteria andTotalpriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("TotalPrice <=", value, "totalprice");
            return (Criteria) this;
        }

        public Criteria andTotalpriceIn(List<BigDecimal> values) {
            addCriterion("TotalPrice in", values, "totalprice");
            return (Criteria) this;
        }

        public Criteria andTotalpriceNotIn(List<BigDecimal> values) {
            addCriterion("TotalPrice not in", values, "totalprice");
            return (Criteria) this;
        }

        public Criteria andTotalpriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TotalPrice between", value1, value2, "totalprice");
            return (Criteria) this;
        }

        public Criteria andTotalpriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TotalPrice not between", value1, value2, "totalprice");
            return (Criteria) this;
        }

        public Criteria andDicountIsNull() {
            addCriterion("Dicount is null");
            return (Criteria) this;
        }

        public Criteria andDicountIsNotNull() {
            addCriterion("Dicount is not null");
            return (Criteria) this;
        }

        public Criteria andDicountEqualTo(BigDecimal value) {
            addCriterion("Dicount =", value, "dicount");
            return (Criteria) this;
        }

        public Criteria andDicountNotEqualTo(BigDecimal value) {
            addCriterion("Dicount <>", value, "dicount");
            return (Criteria) this;
        }

        public Criteria andDicountGreaterThan(BigDecimal value) {
            addCriterion("Dicount >", value, "dicount");
            return (Criteria) this;
        }

        public Criteria andDicountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("Dicount >=", value, "dicount");
            return (Criteria) this;
        }

        public Criteria andDicountLessThan(BigDecimal value) {
            addCriterion("Dicount <", value, "dicount");
            return (Criteria) this;
        }

        public Criteria andDicountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("Dicount <=", value, "dicount");
            return (Criteria) this;
        }

        public Criteria andDicountIn(List<BigDecimal> values) {
            addCriterion("Dicount in", values, "dicount");
            return (Criteria) this;
        }

        public Criteria andDicountNotIn(List<BigDecimal> values) {
            addCriterion("Dicount not in", values, "dicount");
            return (Criteria) this;
        }

        public Criteria andDicountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("Dicount between", value1, value2, "dicount");
            return (Criteria) this;
        }

        public Criteria andDicountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("Dicount not between", value1, value2, "dicount");
            return (Criteria) this;
        }

        public Criteria andPostageIsNull() {
            addCriterion("Postage is null");
            return (Criteria) this;
        }

        public Criteria andPostageIsNotNull() {
            addCriterion("Postage is not null");
            return (Criteria) this;
        }

        public Criteria andPostageEqualTo(BigDecimal value) {
            addCriterion("Postage =", value, "postage");
            return (Criteria) this;
        }

        public Criteria andPostageNotEqualTo(BigDecimal value) {
            addCriterion("Postage <>", value, "postage");
            return (Criteria) this;
        }

        public Criteria andPostageGreaterThan(BigDecimal value) {
            addCriterion("Postage >", value, "postage");
            return (Criteria) this;
        }

        public Criteria andPostageGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("Postage >=", value, "postage");
            return (Criteria) this;
        }

        public Criteria andPostageLessThan(BigDecimal value) {
            addCriterion("Postage <", value, "postage");
            return (Criteria) this;
        }

        public Criteria andPostageLessThanOrEqualTo(BigDecimal value) {
            addCriterion("Postage <=", value, "postage");
            return (Criteria) this;
        }

        public Criteria andPostageIn(List<BigDecimal> values) {
            addCriterion("Postage in", values, "postage");
            return (Criteria) this;
        }

        public Criteria andPostageNotIn(List<BigDecimal> values) {
            addCriterion("Postage not in", values, "postage");
            return (Criteria) this;
        }

        public Criteria andPostageBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("Postage between", value1, value2, "postage");
            return (Criteria) this;
        }

        public Criteria andPostageNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("Postage not between", value1, value2, "postage");
            return (Criteria) this;
        }

        public Criteria andPartnerenumIsNull() {
            addCriterion("PartnerEnum is null");
            return (Criteria) this;
        }

        public Criteria andPartnerenumIsNotNull() {
            addCriterion("PartnerEnum is not null");
            return (Criteria) this;
        }

        public Criteria andPartnerenumEqualTo(String value) {
            addCriterion("PartnerEnum =", value, "partnerenum");
            return (Criteria) this;
        }

        public Criteria andPartnerenumNotEqualTo(String value) {
            addCriterion("PartnerEnum <>", value, "partnerenum");
            return (Criteria) this;
        }

        public Criteria andPartnerenumGreaterThan(String value) {
            addCriterion("PartnerEnum >", value, "partnerenum");
            return (Criteria) this;
        }

        public Criteria andPartnerenumGreaterThanOrEqualTo(String value) {
            addCriterion("PartnerEnum >=", value, "partnerenum");
            return (Criteria) this;
        }

        public Criteria andPartnerenumLessThan(String value) {
            addCriterion("PartnerEnum <", value, "partnerenum");
            return (Criteria) this;
        }

        public Criteria andPartnerenumLessThanOrEqualTo(String value) {
            addCriterion("PartnerEnum <=", value, "partnerenum");
            return (Criteria) this;
        }

        public Criteria andPartnerenumLike(String value) {
            addCriterion("PartnerEnum like", value, "partnerenum");
            return (Criteria) this;
        }

        public Criteria andPartnerenumNotLike(String value) {
            addCriterion("PartnerEnum not like", value, "partnerenum");
            return (Criteria) this;
        }

        public Criteria andPartnerenumIn(List<String> values) {
            addCriterion("PartnerEnum in", values, "partnerenum");
            return (Criteria) this;
        }

        public Criteria andPartnerenumNotIn(List<String> values) {
            addCriterion("PartnerEnum not in", values, "partnerenum");
            return (Criteria) this;
        }

        public Criteria andPartnerenumBetween(String value1, String value2) {
            addCriterion("PartnerEnum between", value1, value2, "partnerenum");
            return (Criteria) this;
        }

        public Criteria andPartnerenumNotBetween(String value1, String value2) {
            addCriterion("PartnerEnum not between", value1, value2, "partnerenum");
            return (Criteria) this;
        }

        public Criteria andCreatedateIsNull() {
            addCriterion("CreateDate is null");
            return (Criteria) this;
        }

        public Criteria andCreatedateIsNotNull() {
            addCriterion("CreateDate is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedateEqualTo(Date value) {
            addCriterion("CreateDate =", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotEqualTo(Date value) {
            addCriterion("CreateDate <>", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateGreaterThan(Date value) {
            addCriterion("CreateDate >", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateGreaterThanOrEqualTo(Date value) {
            addCriterion("CreateDate >=", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateLessThan(Date value) {
            addCriterion("CreateDate <", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateLessThanOrEqualTo(Date value) {
            addCriterion("CreateDate <=", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateIn(List<Date> values) {
            addCriterion("CreateDate in", values, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotIn(List<Date> values) {
            addCriterion("CreateDate not in", values, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateBetween(Date value1, Date value2) {
            addCriterion("CreateDate between", value1, value2, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotBetween(Date value1, Date value2) {
            addCriterion("CreateDate not between", value1, value2, "createdate");
            return (Criteria) this;
        }

        public Criteria andPaytimeIsNull() {
            addCriterion("PayTime is null");
            return (Criteria) this;
        }

        public Criteria andPaytimeIsNotNull() {
            addCriterion("PayTime is not null");
            return (Criteria) this;
        }

        public Criteria andPaytimeEqualTo(Date value) {
            addCriterion("PayTime =", value, "paytime");
            return (Criteria) this;
        }

        public Criteria andPaytimeNotEqualTo(Date value) {
            addCriterion("PayTime <>", value, "paytime");
            return (Criteria) this;
        }

        public Criteria andPaytimeGreaterThan(Date value) {
            addCriterion("PayTime >", value, "paytime");
            return (Criteria) this;
        }

        public Criteria andPaytimeGreaterThanOrEqualTo(Date value) {
            addCriterion("PayTime >=", value, "paytime");
            return (Criteria) this;
        }

        public Criteria andPaytimeLessThan(Date value) {
            addCriterion("PayTime <", value, "paytime");
            return (Criteria) this;
        }

        public Criteria andPaytimeLessThanOrEqualTo(Date value) {
            addCriterion("PayTime <=", value, "paytime");
            return (Criteria) this;
        }

        public Criteria andPaytimeIn(List<Date> values) {
            addCriterion("PayTime in", values, "paytime");
            return (Criteria) this;
        }

        public Criteria andPaytimeNotIn(List<Date> values) {
            addCriterion("PayTime not in", values, "paytime");
            return (Criteria) this;
        }

        public Criteria andPaytimeBetween(Date value1, Date value2) {
            addCriterion("PayTime between", value1, value2, "paytime");
            return (Criteria) this;
        }

        public Criteria andPaytimeNotBetween(Date value1, Date value2) {
            addCriterion("PayTime not between", value1, value2, "paytime");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("Status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("Status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Short value) {
            addCriterion("Status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Short value) {
            addCriterion("Status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Short value) {
            addCriterion("Status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Short value) {
            addCriterion("Status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Short value) {
            addCriterion("Status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Short value) {
            addCriterion("Status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Short> values) {
            addCriterion("Status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Short> values) {
            addCriterion("Status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Short value1, Short value2) {
            addCriterion("Status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Short value1, Short value2) {
            addCriterion("Status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andPayidIsNull() {
            addCriterion("PayId is null");
            return (Criteria) this;
        }

        public Criteria andPayidIsNotNull() {
            addCriterion("PayId is not null");
            return (Criteria) this;
        }

        public Criteria andPayidEqualTo(String value) {
            addCriterion("PayId =", value, "payid");
            return (Criteria) this;
        }

        public Criteria andPayidNotEqualTo(String value) {
            addCriterion("PayId <>", value, "payid");
            return (Criteria) this;
        }

        public Criteria andPayidGreaterThan(String value) {
            addCriterion("PayId >", value, "payid");
            return (Criteria) this;
        }

        public Criteria andPayidGreaterThanOrEqualTo(String value) {
            addCriterion("PayId >=", value, "payid");
            return (Criteria) this;
        }

        public Criteria andPayidLessThan(String value) {
            addCriterion("PayId <", value, "payid");
            return (Criteria) this;
        }

        public Criteria andPayidLessThanOrEqualTo(String value) {
            addCriterion("PayId <=", value, "payid");
            return (Criteria) this;
        }

        public Criteria andPayidLike(String value) {
            addCriterion("PayId like", value, "payid");
            return (Criteria) this;
        }

        public Criteria andPayidNotLike(String value) {
            addCriterion("PayId not like", value, "payid");
            return (Criteria) this;
        }

        public Criteria andPayidIn(List<String> values) {
            addCriterion("PayId in", values, "payid");
            return (Criteria) this;
        }

        public Criteria andPayidNotIn(List<String> values) {
            addCriterion("PayId not in", values, "payid");
            return (Criteria) this;
        }

        public Criteria andPayidBetween(String value1, String value2) {
            addCriterion("PayId between", value1, value2, "payid");
            return (Criteria) this;
        }

        public Criteria andPayidNotBetween(String value1, String value2) {
            addCriterion("PayId not between", value1, value2, "payid");
            return (Criteria) this;
        }

        public Criteria andPayenumIsNull() {
            addCriterion("PayEnum is null");
            return (Criteria) this;
        }

        public Criteria andPayenumIsNotNull() {
            addCriterion("PayEnum is not null");
            return (Criteria) this;
        }

        public Criteria andPayenumEqualTo(Long value) {
            addCriterion("PayEnum =", value, "payenum");
            return (Criteria) this;
        }

        public Criteria andPayenumNotEqualTo(Long value) {
            addCriterion("PayEnum <>", value, "payenum");
            return (Criteria) this;
        }

        public Criteria andPayenumGreaterThan(Long value) {
            addCriterion("PayEnum >", value, "payenum");
            return (Criteria) this;
        }

        public Criteria andPayenumGreaterThanOrEqualTo(Long value) {
            addCriterion("PayEnum >=", value, "payenum");
            return (Criteria) this;
        }

        public Criteria andPayenumLessThan(Long value) {
            addCriterion("PayEnum <", value, "payenum");
            return (Criteria) this;
        }

        public Criteria andPayenumLessThanOrEqualTo(Long value) {
            addCriterion("PayEnum <=", value, "payenum");
            return (Criteria) this;
        }

        public Criteria andPayenumIn(List<Long> values) {
            addCriterion("PayEnum in", values, "payenum");
            return (Criteria) this;
        }

        public Criteria andPayenumNotIn(List<Long> values) {
            addCriterion("PayEnum not in", values, "payenum");
            return (Criteria) this;
        }

        public Criteria andPayenumBetween(Long value1, Long value2) {
            addCriterion("PayEnum between", value1, value2, "payenum");
            return (Criteria) this;
        }

        public Criteria andPayenumNotBetween(Long value1, Long value2) {
            addCriterion("PayEnum not between", value1, value2, "payenum");
            return (Criteria) this;
        }

        public Criteria andCompletedateIsNull() {
            addCriterion("CompleteDate is null");
            return (Criteria) this;
        }

        public Criteria andCompletedateIsNotNull() {
            addCriterion("CompleteDate is not null");
            return (Criteria) this;
        }

        public Criteria andCompletedateEqualTo(Date value) {
            addCriterion("CompleteDate =", value, "completedate");
            return (Criteria) this;
        }

        public Criteria andCompletedateNotEqualTo(Date value) {
            addCriterion("CompleteDate <>", value, "completedate");
            return (Criteria) this;
        }

        public Criteria andCompletedateGreaterThan(Date value) {
            addCriterion("CompleteDate >", value, "completedate");
            return (Criteria) this;
        }

        public Criteria andCompletedateGreaterThanOrEqualTo(Date value) {
            addCriterion("CompleteDate >=", value, "completedate");
            return (Criteria) this;
        }

        public Criteria andCompletedateLessThan(Date value) {
            addCriterion("CompleteDate <", value, "completedate");
            return (Criteria) this;
        }

        public Criteria andCompletedateLessThanOrEqualTo(Date value) {
            addCriterion("CompleteDate <=", value, "completedate");
            return (Criteria) this;
        }

        public Criteria andCompletedateIn(List<Date> values) {
            addCriterion("CompleteDate in", values, "completedate");
            return (Criteria) this;
        }

        public Criteria andCompletedateNotIn(List<Date> values) {
            addCriterion("CompleteDate not in", values, "completedate");
            return (Criteria) this;
        }

        public Criteria andCompletedateBetween(Date value1, Date value2) {
            addCriterion("CompleteDate between", value1, value2, "completedate");
            return (Criteria) this;
        }

        public Criteria andCompletedateNotBetween(Date value1, Date value2) {
            addCriterion("CompleteDate not between", value1, value2, "completedate");
            return (Criteria) this;
        }

        public Criteria andInsbegindateIsNull() {
            addCriterion("InsBeginDate is null");
            return (Criteria) this;
        }

        public Criteria andInsbegindateIsNotNull() {
            addCriterion("InsBeginDate is not null");
            return (Criteria) this;
        }

        public Criteria andInsbegindateEqualTo(Date value) {
            addCriterion("InsBeginDate =", value, "insbegindate");
            return (Criteria) this;
        }

        public Criteria andInsbegindateNotEqualTo(Date value) {
            addCriterion("InsBeginDate <>", value, "insbegindate");
            return (Criteria) this;
        }

        public Criteria andInsbegindateGreaterThan(Date value) {
            addCriterion("InsBeginDate >", value, "insbegindate");
            return (Criteria) this;
        }

        public Criteria andInsbegindateGreaterThanOrEqualTo(Date value) {
            addCriterion("InsBeginDate >=", value, "insbegindate");
            return (Criteria) this;
        }

        public Criteria andInsbegindateLessThan(Date value) {
            addCriterion("InsBeginDate <", value, "insbegindate");
            return (Criteria) this;
        }

        public Criteria andInsbegindateLessThanOrEqualTo(Date value) {
            addCriterion("InsBeginDate <=", value, "insbegindate");
            return (Criteria) this;
        }

        public Criteria andInsbegindateIn(List<Date> values) {
            addCriterion("InsBeginDate in", values, "insbegindate");
            return (Criteria) this;
        }

        public Criteria andInsbegindateNotIn(List<Date> values) {
            addCriterion("InsBeginDate not in", values, "insbegindate");
            return (Criteria) this;
        }

        public Criteria andInsbegindateBetween(Date value1, Date value2) {
            addCriterion("InsBeginDate between", value1, value2, "insbegindate");
            return (Criteria) this;
        }

        public Criteria andInsbegindateNotBetween(Date value1, Date value2) {
            addCriterion("InsBeginDate not between", value1, value2, "insbegindate");
            return (Criteria) this;
        }

        public Criteria andInsenddateIsNull() {
            addCriterion("InsEndDate is null");
            return (Criteria) this;
        }

        public Criteria andInsenddateIsNotNull() {
            addCriterion("InsEndDate is not null");
            return (Criteria) this;
        }

        public Criteria andInsenddateEqualTo(Date value) {
            addCriterion("InsEndDate =", value, "insenddate");
            return (Criteria) this;
        }

        public Criteria andInsenddateNotEqualTo(Date value) {
            addCriterion("InsEndDate <>", value, "insenddate");
            return (Criteria) this;
        }

        public Criteria andInsenddateGreaterThan(Date value) {
            addCriterion("InsEndDate >", value, "insenddate");
            return (Criteria) this;
        }

        public Criteria andInsenddateGreaterThanOrEqualTo(Date value) {
            addCriterion("InsEndDate >=", value, "insenddate");
            return (Criteria) this;
        }

        public Criteria andInsenddateLessThan(Date value) {
            addCriterion("InsEndDate <", value, "insenddate");
            return (Criteria) this;
        }

        public Criteria andInsenddateLessThanOrEqualTo(Date value) {
            addCriterion("InsEndDate <=", value, "insenddate");
            return (Criteria) this;
        }

        public Criteria andInsenddateIn(List<Date> values) {
            addCriterion("InsEndDate in", values, "insenddate");
            return (Criteria) this;
        }

        public Criteria andInsenddateNotIn(List<Date> values) {
            addCriterion("InsEndDate not in", values, "insenddate");
            return (Criteria) this;
        }

        public Criteria andInsenddateBetween(Date value1, Date value2) {
            addCriterion("InsEndDate between", value1, value2, "insenddate");
            return (Criteria) this;
        }

        public Criteria andInsenddateNotBetween(Date value1, Date value2) {
            addCriterion("InsEndDate not between", value1, value2, "insenddate");
            return (Criteria) this;
        }

        public Criteria andInsuranceperiodIsNull() {
            addCriterion("InsurancePeriod is null");
            return (Criteria) this;
        }

        public Criteria andInsuranceperiodIsNotNull() {
            addCriterion("InsurancePeriod is not null");
            return (Criteria) this;
        }

        public Criteria andInsuranceperiodEqualTo(String value) {
            addCriterion("InsurancePeriod =", value, "insuranceperiod");
            return (Criteria) this;
        }

        public Criteria andInsuranceperiodNotEqualTo(String value) {
            addCriterion("InsurancePeriod <>", value, "insuranceperiod");
            return (Criteria) this;
        }

        public Criteria andInsuranceperiodGreaterThan(String value) {
            addCriterion("InsurancePeriod >", value, "insuranceperiod");
            return (Criteria) this;
        }

        public Criteria andInsuranceperiodGreaterThanOrEqualTo(String value) {
            addCriterion("InsurancePeriod >=", value, "insuranceperiod");
            return (Criteria) this;
        }

        public Criteria andInsuranceperiodLessThan(String value) {
            addCriterion("InsurancePeriod <", value, "insuranceperiod");
            return (Criteria) this;
        }

        public Criteria andInsuranceperiodLessThanOrEqualTo(String value) {
            addCriterion("InsurancePeriod <=", value, "insuranceperiod");
            return (Criteria) this;
        }

        public Criteria andInsuranceperiodLike(String value) {
            addCriterion("InsurancePeriod like", value, "insuranceperiod");
            return (Criteria) this;
        }

        public Criteria andInsuranceperiodNotLike(String value) {
            addCriterion("InsurancePeriod not like", value, "insuranceperiod");
            return (Criteria) this;
        }

        public Criteria andInsuranceperiodIn(List<String> values) {
            addCriterion("InsurancePeriod in", values, "insuranceperiod");
            return (Criteria) this;
        }

        public Criteria andInsuranceperiodNotIn(List<String> values) {
            addCriterion("InsurancePeriod not in", values, "insuranceperiod");
            return (Criteria) this;
        }

        public Criteria andInsuranceperiodBetween(String value1, String value2) {
            addCriterion("InsurancePeriod between", value1, value2, "insuranceperiod");
            return (Criteria) this;
        }

        public Criteria andInsuranceperiodNotBetween(String value1, String value2) {
            addCriterion("InsurancePeriod not between", value1, value2, "insuranceperiod");
            return (Criteria) this;
        }

        public Criteria andInsuranceperiodtypeIsNull() {
            addCriterion("InsurancePeriodType is null");
            return (Criteria) this;
        }

        public Criteria andInsuranceperiodtypeIsNotNull() {
            addCriterion("InsurancePeriodType is not null");
            return (Criteria) this;
        }

        public Criteria andInsuranceperiodtypeEqualTo(String value) {
            addCriterion("InsurancePeriodType =", value, "insuranceperiodtype");
            return (Criteria) this;
        }

        public Criteria andInsuranceperiodtypeNotEqualTo(String value) {
            addCriterion("InsurancePeriodType <>", value, "insuranceperiodtype");
            return (Criteria) this;
        }

        public Criteria andInsuranceperiodtypeGreaterThan(String value) {
            addCriterion("InsurancePeriodType >", value, "insuranceperiodtype");
            return (Criteria) this;
        }

        public Criteria andInsuranceperiodtypeGreaterThanOrEqualTo(String value) {
            addCriterion("InsurancePeriodType >=", value, "insuranceperiodtype");
            return (Criteria) this;
        }

        public Criteria andInsuranceperiodtypeLessThan(String value) {
            addCriterion("InsurancePeriodType <", value, "insuranceperiodtype");
            return (Criteria) this;
        }

        public Criteria andInsuranceperiodtypeLessThanOrEqualTo(String value) {
            addCriterion("InsurancePeriodType <=", value, "insuranceperiodtype");
            return (Criteria) this;
        }

        public Criteria andInsuranceperiodtypeLike(String value) {
            addCriterion("InsurancePeriodType like", value, "insuranceperiodtype");
            return (Criteria) this;
        }

        public Criteria andInsuranceperiodtypeNotLike(String value) {
            addCriterion("InsurancePeriodType not like", value, "insuranceperiodtype");
            return (Criteria) this;
        }

        public Criteria andInsuranceperiodtypeIn(List<String> values) {
            addCriterion("InsurancePeriodType in", values, "insuranceperiodtype");
            return (Criteria) this;
        }

        public Criteria andInsuranceperiodtypeNotIn(List<String> values) {
            addCriterion("InsurancePeriodType not in", values, "insuranceperiodtype");
            return (Criteria) this;
        }

        public Criteria andInsuranceperiodtypeBetween(String value1, String value2) {
            addCriterion("InsurancePeriodType between", value1, value2, "insuranceperiodtype");
            return (Criteria) this;
        }

        public Criteria andInsuranceperiodtypeNotBetween(String value1, String value2) {
            addCriterion("InsurancePeriodType not between", value1, value2, "insuranceperiodtype");
            return (Criteria) this;
        }

        public Criteria andLastupdatedateIsNull() {
            addCriterion("LastUpdateDate is null");
            return (Criteria) this;
        }

        public Criteria andLastupdatedateIsNotNull() {
            addCriterion("LastUpdateDate is not null");
            return (Criteria) this;
        }

        public Criteria andLastupdatedateEqualTo(Date value) {
            addCriterion("LastUpdateDate =", value, "lastupdatedate");
            return (Criteria) this;
        }

        public Criteria andLastupdatedateNotEqualTo(Date value) {
            addCriterion("LastUpdateDate <>", value, "lastupdatedate");
            return (Criteria) this;
        }

        public Criteria andLastupdatedateGreaterThan(Date value) {
            addCriterion("LastUpdateDate >", value, "lastupdatedate");
            return (Criteria) this;
        }

        public Criteria andLastupdatedateGreaterThanOrEqualTo(Date value) {
            addCriterion("LastUpdateDate >=", value, "lastupdatedate");
            return (Criteria) this;
        }

        public Criteria andLastupdatedateLessThan(Date value) {
            addCriterion("LastUpdateDate <", value, "lastupdatedate");
            return (Criteria) this;
        }

        public Criteria andLastupdatedateLessThanOrEqualTo(Date value) {
            addCriterion("LastUpdateDate <=", value, "lastupdatedate");
            return (Criteria) this;
        }

        public Criteria andLastupdatedateIn(List<Date> values) {
            addCriterion("LastUpdateDate in", values, "lastupdatedate");
            return (Criteria) this;
        }

        public Criteria andLastupdatedateNotIn(List<Date> values) {
            addCriterion("LastUpdateDate not in", values, "lastupdatedate");
            return (Criteria) this;
        }

        public Criteria andLastupdatedateBetween(Date value1, Date value2) {
            addCriterion("LastUpdateDate between", value1, value2, "lastupdatedate");
            return (Criteria) this;
        }

        public Criteria andLastupdatedateNotBetween(Date value1, Date value2) {
            addCriterion("LastUpdateDate not between", value1, value2, "lastupdatedate");
            return (Criteria) this;
        }

        public Criteria andYnIsNull() {
            addCriterion("Yn is null");
            return (Criteria) this;
        }

        public Criteria andYnIsNotNull() {
            addCriterion("Yn is not null");
            return (Criteria) this;
        }

        public Criteria andYnEqualTo(Short value) {
            addCriterion("Yn =", value, "yn");
            return (Criteria) this;
        }

        public Criteria andYnNotEqualTo(Short value) {
            addCriterion("Yn <>", value, "yn");
            return (Criteria) this;
        }

        public Criteria andYnGreaterThan(Short value) {
            addCriterion("Yn >", value, "yn");
            return (Criteria) this;
        }

        public Criteria andYnGreaterThanOrEqualTo(Short value) {
            addCriterion("Yn >=", value, "yn");
            return (Criteria) this;
        }

        public Criteria andYnLessThan(Short value) {
            addCriterion("Yn <", value, "yn");
            return (Criteria) this;
        }

        public Criteria andYnLessThanOrEqualTo(Short value) {
            addCriterion("Yn <=", value, "yn");
            return (Criteria) this;
        }

        public Criteria andYnIn(List<Short> values) {
            addCriterion("Yn in", values, "yn");
            return (Criteria) this;
        }

        public Criteria andYnNotIn(List<Short> values) {
            addCriterion("Yn not in", values, "yn");
            return (Criteria) this;
        }

        public Criteria andYnBetween(Short value1, Short value2) {
            addCriterion("Yn between", value1, value2, "yn");
            return (Criteria) this;
        }

        public Criteria andYnNotBetween(Short value1, Short value2) {
            addCriterion("Yn not between", value1, value2, "yn");
            return (Criteria) this;
        }

        public Criteria andVersionIsNull() {
            addCriterion("Version is null");
            return (Criteria) this;
        }

        public Criteria andVersionIsNotNull() {
            addCriterion("Version is not null");
            return (Criteria) this;
        }

        public Criteria andVersionEqualTo(Short value) {
            addCriterion("Version =", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotEqualTo(Short value) {
            addCriterion("Version <>", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThan(Short value) {
            addCriterion("Version >", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThanOrEqualTo(Short value) {
            addCriterion("Version >=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThan(Short value) {
            addCriterion("Version <", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThanOrEqualTo(Short value) {
            addCriterion("Version <=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionIn(List<Short> values) {
            addCriterion("Version in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotIn(List<Short> values) {
            addCriterion("Version not in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionBetween(Short value1, Short value2) {
            addCriterion("Version between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotBetween(Short value1, Short value2) {
            addCriterion("Version not between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andSkuidIsNull() {
            addCriterion("SkuId is null");
            return (Criteria) this;
        }

        public Criteria andSkuidIsNotNull() {
            addCriterion("SkuId is not null");
            return (Criteria) this;
        }

        public Criteria andSkuidEqualTo(String value) {
            addCriterion("SkuId =", value, "skuid");
            return (Criteria) this;
        }

        public Criteria andSkuidNotEqualTo(String value) {
            addCriterion("SkuId <>", value, "skuid");
            return (Criteria) this;
        }

        public Criteria andSkuidGreaterThan(String value) {
            addCriterion("SkuId >", value, "skuid");
            return (Criteria) this;
        }

        public Criteria andSkuidGreaterThanOrEqualTo(String value) {
            addCriterion("SkuId >=", value, "skuid");
            return (Criteria) this;
        }

        public Criteria andSkuidLessThan(String value) {
            addCriterion("SkuId <", value, "skuid");
            return (Criteria) this;
        }

        public Criteria andSkuidLessThanOrEqualTo(String value) {
            addCriterion("SkuId <=", value, "skuid");
            return (Criteria) this;
        }

        public Criteria andSkuidLike(String value) {
            addCriterion("SkuId like", value, "skuid");
            return (Criteria) this;
        }

        public Criteria andSkuidNotLike(String value) {
            addCriterion("SkuId not like", value, "skuid");
            return (Criteria) this;
        }

        public Criteria andSkuidIn(List<String> values) {
            addCriterion("SkuId in", values, "skuid");
            return (Criteria) this;
        }

        public Criteria andSkuidNotIn(List<String> values) {
            addCriterion("SkuId not in", values, "skuid");
            return (Criteria) this;
        }

        public Criteria andSkuidBetween(String value1, String value2) {
            addCriterion("SkuId between", value1, value2, "skuid");
            return (Criteria) this;
        }

        public Criteria andSkuidNotBetween(String value1, String value2) {
            addCriterion("SkuId not between", value1, value2, "skuid");
            return (Criteria) this;
        }

        public Criteria andSkunameIsNull() {
            addCriterion("SkuName is null");
            return (Criteria) this;
        }

        public Criteria andSkunameIsNotNull() {
            addCriterion("SkuName is not null");
            return (Criteria) this;
        }

        public Criteria andSkunameEqualTo(String value) {
            addCriterion("SkuName =", value, "skuname");
            return (Criteria) this;
        }

        public Criteria andSkunameNotEqualTo(String value) {
            addCriterion("SkuName <>", value, "skuname");
            return (Criteria) this;
        }

        public Criteria andSkunameGreaterThan(String value) {
            addCriterion("SkuName >", value, "skuname");
            return (Criteria) this;
        }

        public Criteria andSkunameGreaterThanOrEqualTo(String value) {
            addCriterion("SkuName >=", value, "skuname");
            return (Criteria) this;
        }

        public Criteria andSkunameLessThan(String value) {
            addCriterion("SkuName <", value, "skuname");
            return (Criteria) this;
        }

        public Criteria andSkunameLessThanOrEqualTo(String value) {
            addCriterion("SkuName <=", value, "skuname");
            return (Criteria) this;
        }

        public Criteria andSkunameLike(String value) {
            addCriterion("SkuName like", value, "skuname");
            return (Criteria) this;
        }

        public Criteria andSkunameNotLike(String value) {
            addCriterion("SkuName not like", value, "skuname");
            return (Criteria) this;
        }

        public Criteria andSkunameIn(List<String> values) {
            addCriterion("SkuName in", values, "skuname");
            return (Criteria) this;
        }

        public Criteria andSkunameNotIn(List<String> values) {
            addCriterion("SkuName not in", values, "skuname");
            return (Criteria) this;
        }

        public Criteria andSkunameBetween(String value1, String value2) {
            addCriterion("SkuName between", value1, value2, "skuname");
            return (Criteria) this;
        }

        public Criteria andSkunameNotBetween(String value1, String value2) {
            addCriterion("SkuName not between", value1, value2, "skuname");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("Remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("Remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("Remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("Remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("Remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("Remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("Remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("Remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("Remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("Remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("Remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("Remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("Remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("Remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andExt1IsNull() {
            addCriterion("Ext1 is null");
            return (Criteria) this;
        }

        public Criteria andExt1IsNotNull() {
            addCriterion("Ext1 is not null");
            return (Criteria) this;
        }

        public Criteria andExt1EqualTo(String value) {
            addCriterion("Ext1 =", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1NotEqualTo(String value) {
            addCriterion("Ext1 <>", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1GreaterThan(String value) {
            addCriterion("Ext1 >", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1GreaterThanOrEqualTo(String value) {
            addCriterion("Ext1 >=", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1LessThan(String value) {
            addCriterion("Ext1 <", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1LessThanOrEqualTo(String value) {
            addCriterion("Ext1 <=", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1Like(String value) {
            addCriterion("Ext1 like", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1NotLike(String value) {
            addCriterion("Ext1 not like", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1In(List<String> values) {
            addCriterion("Ext1 in", values, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1NotIn(List<String> values) {
            addCriterion("Ext1 not in", values, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1Between(String value1, String value2) {
            addCriterion("Ext1 between", value1, value2, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1NotBetween(String value1, String value2) {
            addCriterion("Ext1 not between", value1, value2, "ext1");
            return (Criteria) this;
        }

        public Criteria andInsureddigestIsNull() {
            addCriterion("InsuredDigest is null");
            return (Criteria) this;
        }

        public Criteria andInsureddigestIsNotNull() {
            addCriterion("InsuredDigest is not null");
            return (Criteria) this;
        }

        public Criteria andInsureddigestEqualTo(String value) {
            addCriterion("InsuredDigest =", value, "insureddigest");
            return (Criteria) this;
        }

        public Criteria andInsureddigestNotEqualTo(String value) {
            addCriterion("InsuredDigest <>", value, "insureddigest");
            return (Criteria) this;
        }

        public Criteria andInsureddigestGreaterThan(String value) {
            addCriterion("InsuredDigest >", value, "insureddigest");
            return (Criteria) this;
        }

        public Criteria andInsureddigestGreaterThanOrEqualTo(String value) {
            addCriterion("InsuredDigest >=", value, "insureddigest");
            return (Criteria) this;
        }

        public Criteria andInsureddigestLessThan(String value) {
            addCriterion("InsuredDigest <", value, "insureddigest");
            return (Criteria) this;
        }

        public Criteria andInsureddigestLessThanOrEqualTo(String value) {
            addCriterion("InsuredDigest <=", value, "insureddigest");
            return (Criteria) this;
        }

        public Criteria andInsureddigestLike(String value) {
            addCriterion("InsuredDigest like", value, "insureddigest");
            return (Criteria) this;
        }

        public Criteria andInsureddigestNotLike(String value) {
            addCriterion("InsuredDigest not like", value, "insureddigest");
            return (Criteria) this;
        }

        public Criteria andInsureddigestIn(List<String> values) {
            addCriterion("InsuredDigest in", values, "insureddigest");
            return (Criteria) this;
        }

        public Criteria andInsureddigestNotIn(List<String> values) {
            addCriterion("InsuredDigest not in", values, "insureddigest");
            return (Criteria) this;
        }

        public Criteria andInsureddigestBetween(String value1, String value2) {
            addCriterion("InsuredDigest between", value1, value2, "insureddigest");
            return (Criteria) this;
        }

        public Criteria andInsureddigestNotBetween(String value1, String value2) {
            addCriterion("InsuredDigest not between", value1, value2, "insureddigest");
            return (Criteria) this;
        }

        public Criteria andPaycardnoIsNull() {
            addCriterion("payCardNo is null");
            return (Criteria) this;
        }

        public Criteria andPaycardnoIsNotNull() {
            addCriterion("payCardNo is not null");
            return (Criteria) this;
        }

        public Criteria andPaycardnoEqualTo(String value) {
            addCriterion("payCardNo =", value, "paycardno");
            return (Criteria) this;
        }

        public Criteria andPaycardnoNotEqualTo(String value) {
            addCriterion("payCardNo <>", value, "paycardno");
            return (Criteria) this;
        }

        public Criteria andPaycardnoGreaterThan(String value) {
            addCriterion("payCardNo >", value, "paycardno");
            return (Criteria) this;
        }

        public Criteria andPaycardnoGreaterThanOrEqualTo(String value) {
            addCriterion("payCardNo >=", value, "paycardno");
            return (Criteria) this;
        }

        public Criteria andPaycardnoLessThan(String value) {
            addCriterion("payCardNo <", value, "paycardno");
            return (Criteria) this;
        }

        public Criteria andPaycardnoLessThanOrEqualTo(String value) {
            addCriterion("payCardNo <=", value, "paycardno");
            return (Criteria) this;
        }

        public Criteria andPaycardnoLike(String value) {
            addCriterion("payCardNo like", value, "paycardno");
            return (Criteria) this;
        }

        public Criteria andPaycardnoNotLike(String value) {
            addCriterion("payCardNo not like", value, "paycardno");
            return (Criteria) this;
        }

        public Criteria andPaycardnoIn(List<String> values) {
            addCriterion("payCardNo in", values, "paycardno");
            return (Criteria) this;
        }

        public Criteria andPaycardnoNotIn(List<String> values) {
            addCriterion("payCardNo not in", values, "paycardno");
            return (Criteria) this;
        }

        public Criteria andPaycardnoBetween(String value1, String value2) {
            addCriterion("payCardNo between", value1, value2, "paycardno");
            return (Criteria) this;
        }

        public Criteria andPaycardnoNotBetween(String value1, String value2) {
            addCriterion("payCardNo not between", value1, value2, "paycardno");
            return (Criteria) this;
        }

        public Criteria andPaybanknoIsNull() {
            addCriterion("payBankNo is null");
            return (Criteria) this;
        }

        public Criteria andPaybanknoIsNotNull() {
            addCriterion("payBankNo is not null");
            return (Criteria) this;
        }

        public Criteria andPaybanknoEqualTo(String value) {
            addCriterion("payBankNo =", value, "paybankno");
            return (Criteria) this;
        }

        public Criteria andPaybanknoNotEqualTo(String value) {
            addCriterion("payBankNo <>", value, "paybankno");
            return (Criteria) this;
        }

        public Criteria andPaybanknoGreaterThan(String value) {
            addCriterion("payBankNo >", value, "paybankno");
            return (Criteria) this;
        }

        public Criteria andPaybanknoGreaterThanOrEqualTo(String value) {
            addCriterion("payBankNo >=", value, "paybankno");
            return (Criteria) this;
        }

        public Criteria andPaybanknoLessThan(String value) {
            addCriterion("payBankNo <", value, "paybankno");
            return (Criteria) this;
        }

        public Criteria andPaybanknoLessThanOrEqualTo(String value) {
            addCriterion("payBankNo <=", value, "paybankno");
            return (Criteria) this;
        }

        public Criteria andPaybanknoLike(String value) {
            addCriterion("payBankNo like", value, "paybankno");
            return (Criteria) this;
        }

        public Criteria andPaybanknoNotLike(String value) {
            addCriterion("payBankNo not like", value, "paybankno");
            return (Criteria) this;
        }

        public Criteria andPaybanknoIn(List<String> values) {
            addCriterion("payBankNo in", values, "paybankno");
            return (Criteria) this;
        }

        public Criteria andPaybanknoNotIn(List<String> values) {
            addCriterion("payBankNo not in", values, "paybankno");
            return (Criteria) this;
        }

        public Criteria andPaybanknoBetween(String value1, String value2) {
            addCriterion("payBankNo between", value1, value2, "paybankno");
            return (Criteria) this;
        }

        public Criteria andPaybanknoNotBetween(String value1, String value2) {
            addCriterion("payBankNo not between", value1, value2, "paybankno");
            return (Criteria) this;
        }

        public Criteria andPaycardidIsNull() {
            addCriterion("payCardId is null");
            return (Criteria) this;
        }

        public Criteria andPaycardidIsNotNull() {
            addCriterion("payCardId is not null");
            return (Criteria) this;
        }

        public Criteria andPaycardidEqualTo(String value) {
            addCriterion("payCardId =", value, "paycardid");
            return (Criteria) this;
        }

        public Criteria andPaycardidNotEqualTo(String value) {
            addCriterion("payCardId <>", value, "paycardid");
            return (Criteria) this;
        }

        public Criteria andPaycardidGreaterThan(String value) {
            addCriterion("payCardId >", value, "paycardid");
            return (Criteria) this;
        }

        public Criteria andPaycardidGreaterThanOrEqualTo(String value) {
            addCriterion("payCardId >=", value, "paycardid");
            return (Criteria) this;
        }

        public Criteria andPaycardidLessThan(String value) {
            addCriterion("payCardId <", value, "paycardid");
            return (Criteria) this;
        }

        public Criteria andPaycardidLessThanOrEqualTo(String value) {
            addCriterion("payCardId <=", value, "paycardid");
            return (Criteria) this;
        }

        public Criteria andPaycardidLike(String value) {
            addCriterion("payCardId like", value, "paycardid");
            return (Criteria) this;
        }

        public Criteria andPaycardidNotLike(String value) {
            addCriterion("payCardId not like", value, "paycardid");
            return (Criteria) this;
        }

        public Criteria andPaycardidIn(List<String> values) {
            addCriterion("payCardId in", values, "paycardid");
            return (Criteria) this;
        }

        public Criteria andPaycardidNotIn(List<String> values) {
            addCriterion("payCardId not in", values, "paycardid");
            return (Criteria) this;
        }

        public Criteria andPaycardidBetween(String value1, String value2) {
            addCriterion("payCardId between", value1, value2, "paycardid");
            return (Criteria) this;
        }

        public Criteria andPaycardidNotBetween(String value1, String value2) {
            addCriterion("payCardId not between", value1, value2, "paycardid");
            return (Criteria) this;
        }

        public Criteria andBuyplanIsNull() {
            addCriterion("buyPlan is null");
            return (Criteria) this;
        }

        public Criteria andBuyplanIsNotNull() {
            addCriterion("buyPlan is not null");
            return (Criteria) this;
        }

        public Criteria andBuyplanEqualTo(String value) {
            addCriterion("buyPlan =", value, "buyplan");
            return (Criteria) this;
        }

        public Criteria andBuyplanNotEqualTo(String value) {
            addCriterion("buyPlan <>", value, "buyplan");
            return (Criteria) this;
        }

        public Criteria andBuyplanGreaterThan(String value) {
            addCriterion("buyPlan >", value, "buyplan");
            return (Criteria) this;
        }

        public Criteria andBuyplanGreaterThanOrEqualTo(String value) {
            addCriterion("buyPlan >=", value, "buyplan");
            return (Criteria) this;
        }

        public Criteria andBuyplanLessThan(String value) {
            addCriterion("buyPlan <", value, "buyplan");
            return (Criteria) this;
        }

        public Criteria andBuyplanLessThanOrEqualTo(String value) {
            addCriterion("buyPlan <=", value, "buyplan");
            return (Criteria) this;
        }

        public Criteria andBuyplanLike(String value) {
            addCriterion("buyPlan like", value, "buyplan");
            return (Criteria) this;
        }

        public Criteria andBuyplanNotLike(String value) {
            addCriterion("buyPlan not like", value, "buyplan");
            return (Criteria) this;
        }

        public Criteria andBuyplanIn(List<String> values) {
            addCriterion("buyPlan in", values, "buyplan");
            return (Criteria) this;
        }

        public Criteria andBuyplanNotIn(List<String> values) {
            addCriterion("buyPlan not in", values, "buyplan");
            return (Criteria) this;
        }

        public Criteria andBuyplanBetween(String value1, String value2) {
            addCriterion("buyPlan between", value1, value2, "buyplan");
            return (Criteria) this;
        }

        public Criteria andBuyplanNotBetween(String value1, String value2) {
            addCriterion("buyPlan not between", value1, value2, "buyplan");
            return (Criteria) this;
        }

        public Criteria andForcebegindateIsNull() {
            addCriterion("forceBeginDate is null");
            return (Criteria) this;
        }

        public Criteria andForcebegindateIsNotNull() {
            addCriterion("forceBeginDate is not null");
            return (Criteria) this;
        }

        public Criteria andForcebegindateEqualTo(Date value) {
            addCriterion("forceBeginDate =", value, "forcebegindate");
            return (Criteria) this;
        }

        public Criteria andForcebegindateNotEqualTo(Date value) {
            addCriterion("forceBeginDate <>", value, "forcebegindate");
            return (Criteria) this;
        }

        public Criteria andForcebegindateGreaterThan(Date value) {
            addCriterion("forceBeginDate >", value, "forcebegindate");
            return (Criteria) this;
        }

        public Criteria andForcebegindateGreaterThanOrEqualTo(Date value) {
            addCriterion("forceBeginDate >=", value, "forcebegindate");
            return (Criteria) this;
        }

        public Criteria andForcebegindateLessThan(Date value) {
            addCriterion("forceBeginDate <", value, "forcebegindate");
            return (Criteria) this;
        }

        public Criteria andForcebegindateLessThanOrEqualTo(Date value) {
            addCriterion("forceBeginDate <=", value, "forcebegindate");
            return (Criteria) this;
        }

        public Criteria andForcebegindateIn(List<Date> values) {
            addCriterion("forceBeginDate in", values, "forcebegindate");
            return (Criteria) this;
        }

        public Criteria andForcebegindateNotIn(List<Date> values) {
            addCriterion("forceBeginDate not in", values, "forcebegindate");
            return (Criteria) this;
        }

        public Criteria andForcebegindateBetween(Date value1, Date value2) {
            addCriterion("forceBeginDate between", value1, value2, "forcebegindate");
            return (Criteria) this;
        }

        public Criteria andForcebegindateNotBetween(Date value1, Date value2) {
            addCriterion("forceBeginDate not between", value1, value2, "forcebegindate");
            return (Criteria) this;
        }

        public Criteria andForceenddateIsNull() {
            addCriterion("forceEndDate is null");
            return (Criteria) this;
        }

        public Criteria andForceenddateIsNotNull() {
            addCriterion("forceEndDate is not null");
            return (Criteria) this;
        }

        public Criteria andForceenddateEqualTo(Date value) {
            addCriterion("forceEndDate =", value, "forceenddate");
            return (Criteria) this;
        }

        public Criteria andForceenddateNotEqualTo(Date value) {
            addCriterion("forceEndDate <>", value, "forceenddate");
            return (Criteria) this;
        }

        public Criteria andForceenddateGreaterThan(Date value) {
            addCriterion("forceEndDate >", value, "forceenddate");
            return (Criteria) this;
        }

        public Criteria andForceenddateGreaterThanOrEqualTo(Date value) {
            addCriterion("forceEndDate >=", value, "forceenddate");
            return (Criteria) this;
        }

        public Criteria andForceenddateLessThan(Date value) {
            addCriterion("forceEndDate <", value, "forceenddate");
            return (Criteria) this;
        }

        public Criteria andForceenddateLessThanOrEqualTo(Date value) {
            addCriterion("forceEndDate <=", value, "forceenddate");
            return (Criteria) this;
        }

        public Criteria andForceenddateIn(List<Date> values) {
            addCriterion("forceEndDate in", values, "forceenddate");
            return (Criteria) this;
        }

        public Criteria andForceenddateNotIn(List<Date> values) {
            addCriterion("forceEndDate not in", values, "forceenddate");
            return (Criteria) this;
        }

        public Criteria andForceenddateBetween(Date value1, Date value2) {
            addCriterion("forceEndDate between", value1, value2, "forceenddate");
            return (Criteria) this;
        }

        public Criteria andForceenddateNotBetween(Date value1, Date value2) {
            addCriterion("forceEndDate not between", value1, value2, "forceenddate");
            return (Criteria) this;
        }

        public Criteria andBusinesscodeIsNull() {
            addCriterion("businessCode is null");
            return (Criteria) this;
        }

        public Criteria andBusinesscodeIsNotNull() {
            addCriterion("businessCode is not null");
            return (Criteria) this;
        }

        public Criteria andBusinesscodeEqualTo(String value) {
            addCriterion("businessCode =", value, "businesscode");
            return (Criteria) this;
        }

        public Criteria andBusinesscodeNotEqualTo(String value) {
            addCriterion("businessCode <>", value, "businesscode");
            return (Criteria) this;
        }

        public Criteria andBusinesscodeGreaterThan(String value) {
            addCriterion("businessCode >", value, "businesscode");
            return (Criteria) this;
        }

        public Criteria andBusinesscodeGreaterThanOrEqualTo(String value) {
            addCriterion("businessCode >=", value, "businesscode");
            return (Criteria) this;
        }

        public Criteria andBusinesscodeLessThan(String value) {
            addCriterion("businessCode <", value, "businesscode");
            return (Criteria) this;
        }

        public Criteria andBusinesscodeLessThanOrEqualTo(String value) {
            addCriterion("businessCode <=", value, "businesscode");
            return (Criteria) this;
        }

        public Criteria andBusinesscodeLike(String value) {
            addCriterion("businessCode like", value, "businesscode");
            return (Criteria) this;
        }

        public Criteria andBusinesscodeNotLike(String value) {
            addCriterion("businessCode not like", value, "businesscode");
            return (Criteria) this;
        }

        public Criteria andBusinesscodeIn(List<String> values) {
            addCriterion("businessCode in", values, "businesscode");
            return (Criteria) this;
        }

        public Criteria andBusinesscodeNotIn(List<String> values) {
            addCriterion("businessCode not in", values, "businesscode");
            return (Criteria) this;
        }

        public Criteria andBusinesscodeBetween(String value1, String value2) {
            addCriterion("businessCode between", value1, value2, "businesscode");
            return (Criteria) this;
        }

        public Criteria andBusinesscodeNotBetween(String value1, String value2) {
            addCriterion("businessCode not between", value1, value2, "businesscode");
            return (Criteria) this;
        }

        public Criteria andComorderidIsNull() {
            addCriterion("comOrderId is null");
            return (Criteria) this;
        }

        public Criteria andComorderidIsNotNull() {
            addCriterion("comOrderId is not null");
            return (Criteria) this;
        }

        public Criteria andComorderidEqualTo(String value) {
            addCriterion("comOrderId =", value, "comorderid");
            return (Criteria) this;
        }

        public Criteria andComorderidNotEqualTo(String value) {
            addCriterion("comOrderId <>", value, "comorderid");
            return (Criteria) this;
        }

        public Criteria andComorderidGreaterThan(String value) {
            addCriterion("comOrderId >", value, "comorderid");
            return (Criteria) this;
        }

        public Criteria andComorderidGreaterThanOrEqualTo(String value) {
            addCriterion("comOrderId >=", value, "comorderid");
            return (Criteria) this;
        }

        public Criteria andComorderidLessThan(String value) {
            addCriterion("comOrderId <", value, "comorderid");
            return (Criteria) this;
        }

        public Criteria andComorderidLessThanOrEqualTo(String value) {
            addCriterion("comOrderId <=", value, "comorderid");
            return (Criteria) this;
        }

        public Criteria andComorderidLike(String value) {
            addCriterion("comOrderId like", value, "comorderid");
            return (Criteria) this;
        }

        public Criteria andComorderidNotLike(String value) {
            addCriterion("comOrderId not like", value, "comorderid");
            return (Criteria) this;
        }

        public Criteria andComorderidIn(List<String> values) {
            addCriterion("comOrderId in", values, "comorderid");
            return (Criteria) this;
        }

        public Criteria andComorderidNotIn(List<String> values) {
            addCriterion("comOrderId not in", values, "comorderid");
            return (Criteria) this;
        }

        public Criteria andComorderidBetween(String value1, String value2) {
            addCriterion("comOrderId between", value1, value2, "comorderid");
            return (Criteria) this;
        }

        public Criteria andComorderidNotBetween(String value1, String value2) {
            addCriterion("comOrderId not between", value1, value2, "comorderid");
            return (Criteria) this;
        }

        public Criteria andErrorinfoIsNull() {
            addCriterion("errorInfo is null");
            return (Criteria) this;
        }

        public Criteria andErrorinfoIsNotNull() {
            addCriterion("errorInfo is not null");
            return (Criteria) this;
        }

        public Criteria andErrorinfoEqualTo(String value) {
            addCriterion("errorInfo =", value, "errorinfo");
            return (Criteria) this;
        }

        public Criteria andErrorinfoNotEqualTo(String value) {
            addCriterion("errorInfo <>", value, "errorinfo");
            return (Criteria) this;
        }

        public Criteria andErrorinfoGreaterThan(String value) {
            addCriterion("errorInfo >", value, "errorinfo");
            return (Criteria) this;
        }

        public Criteria andErrorinfoGreaterThanOrEqualTo(String value) {
            addCriterion("errorInfo >=", value, "errorinfo");
            return (Criteria) this;
        }

        public Criteria andErrorinfoLessThan(String value) {
            addCriterion("errorInfo <", value, "errorinfo");
            return (Criteria) this;
        }

        public Criteria andErrorinfoLessThanOrEqualTo(String value) {
            addCriterion("errorInfo <=", value, "errorinfo");
            return (Criteria) this;
        }

        public Criteria andErrorinfoLike(String value) {
            addCriterion("errorInfo like", value, "errorinfo");
            return (Criteria) this;
        }

        public Criteria andErrorinfoNotLike(String value) {
            addCriterion("errorInfo not like", value, "errorinfo");
            return (Criteria) this;
        }

        public Criteria andErrorinfoIn(List<String> values) {
            addCriterion("errorInfo in", values, "errorinfo");
            return (Criteria) this;
        }

        public Criteria andErrorinfoNotIn(List<String> values) {
            addCriterion("errorInfo not in", values, "errorinfo");
            return (Criteria) this;
        }

        public Criteria andErrorinfoBetween(String value1, String value2) {
            addCriterion("errorInfo between", value1, value2, "errorinfo");
            return (Criteria) this;
        }

        public Criteria andErrorinfoNotBetween(String value1, String value2) {
            addCriterion("errorInfo not between", value1, value2, "errorinfo");
            return (Criteria) this;
        }

        public Criteria andActivitytypeIsNull() {
            addCriterion("ActivityType is null");
            return (Criteria) this;
        }

        public Criteria andActivitytypeIsNotNull() {
            addCriterion("ActivityType is not null");
            return (Criteria) this;
        }

        public Criteria andActivitytypeEqualTo(String value) {
            addCriterion("ActivityType =", value, "activitytype");
            return (Criteria) this;
        }

        public Criteria andActivitytypeNotEqualTo(String value) {
            addCriterion("ActivityType <>", value, "activitytype");
            return (Criteria) this;
        }

        public Criteria andActivitytypeGreaterThan(String value) {
            addCriterion("ActivityType >", value, "activitytype");
            return (Criteria) this;
        }

        public Criteria andActivitytypeGreaterThanOrEqualTo(String value) {
            addCriterion("ActivityType >=", value, "activitytype");
            return (Criteria) this;
        }

        public Criteria andActivitytypeLessThan(String value) {
            addCriterion("ActivityType <", value, "activitytype");
            return (Criteria) this;
        }

        public Criteria andActivitytypeLessThanOrEqualTo(String value) {
            addCriterion("ActivityType <=", value, "activitytype");
            return (Criteria) this;
        }

        public Criteria andActivitytypeLike(String value) {
            addCriterion("ActivityType like", value, "activitytype");
            return (Criteria) this;
        }

        public Criteria andActivitytypeNotLike(String value) {
            addCriterion("ActivityType not like", value, "activitytype");
            return (Criteria) this;
        }

        public Criteria andActivitytypeIn(List<String> values) {
            addCriterion("ActivityType in", values, "activitytype");
            return (Criteria) this;
        }

        public Criteria andActivitytypeNotIn(List<String> values) {
            addCriterion("ActivityType not in", values, "activitytype");
            return (Criteria) this;
        }

        public Criteria andActivitytypeBetween(String value1, String value2) {
            addCriterion("ActivityType between", value1, value2, "activitytype");
            return (Criteria) this;
        }

        public Criteria andActivitytypeNotBetween(String value1, String value2) {
            addCriterion("ActivityType not between", value1, value2, "activitytype");
            return (Criteria) this;
        }

        public Criteria andKeyvalueIsNull() {
            addCriterion("keyValue is null");
            return (Criteria) this;
        }

        public Criteria andKeyvalueIsNotNull() {
            addCriterion("keyValue is not null");
            return (Criteria) this;
        }

        public Criteria andKeyvalueEqualTo(String value) {
            addCriterion("keyValue =", value, "keyvalue");
            return (Criteria) this;
        }

        public Criteria andKeyvalueNotEqualTo(String value) {
            addCriterion("keyValue <>", value, "keyvalue");
            return (Criteria) this;
        }

        public Criteria andKeyvalueGreaterThan(String value) {
            addCriterion("keyValue >", value, "keyvalue");
            return (Criteria) this;
        }

        public Criteria andKeyvalueGreaterThanOrEqualTo(String value) {
            addCriterion("keyValue >=", value, "keyvalue");
            return (Criteria) this;
        }

        public Criteria andKeyvalueLessThan(String value) {
            addCriterion("keyValue <", value, "keyvalue");
            return (Criteria) this;
        }

        public Criteria andKeyvalueLessThanOrEqualTo(String value) {
            addCriterion("keyValue <=", value, "keyvalue");
            return (Criteria) this;
        }

        public Criteria andKeyvalueLike(String value) {
            addCriterion("keyValue like", value, "keyvalue");
            return (Criteria) this;
        }

        public Criteria andKeyvalueNotLike(String value) {
            addCriterion("keyValue not like", value, "keyvalue");
            return (Criteria) this;
        }

        public Criteria andKeyvalueIn(List<String> values) {
            addCriterion("keyValue in", values, "keyvalue");
            return (Criteria) this;
        }

        public Criteria andKeyvalueNotIn(List<String> values) {
            addCriterion("keyValue not in", values, "keyvalue");
            return (Criteria) this;
        }

        public Criteria andKeyvalueBetween(String value1, String value2) {
            addCriterion("keyValue between", value1, value2, "keyvalue");
            return (Criteria) this;
        }

        public Criteria andKeyvalueNotBetween(String value1, String value2) {
            addCriterion("keyValue not between", value1, value2, "keyvalue");
            return (Criteria) this;
        }

        public Criteria andWithdrawmoneyIsNull() {
            addCriterion("withDrawMoney is null");
            return (Criteria) this;
        }

        public Criteria andWithdrawmoneyIsNotNull() {
            addCriterion("withDrawMoney is not null");
            return (Criteria) this;
        }

        public Criteria andWithdrawmoneyEqualTo(BigDecimal value) {
            addCriterion("withDrawMoney =", value, "withdrawmoney");
            return (Criteria) this;
        }

        public Criteria andWithdrawmoneyNotEqualTo(BigDecimal value) {
            addCriterion("withDrawMoney <>", value, "withdrawmoney");
            return (Criteria) this;
        }

        public Criteria andWithdrawmoneyGreaterThan(BigDecimal value) {
            addCriterion("withDrawMoney >", value, "withdrawmoney");
            return (Criteria) this;
        }

        public Criteria andWithdrawmoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("withDrawMoney >=", value, "withdrawmoney");
            return (Criteria) this;
        }

        public Criteria andWithdrawmoneyLessThan(BigDecimal value) {
            addCriterion("withDrawMoney <", value, "withdrawmoney");
            return (Criteria) this;
        }

        public Criteria andWithdrawmoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("withDrawMoney <=", value, "withdrawmoney");
            return (Criteria) this;
        }

        public Criteria andWithdrawmoneyIn(List<BigDecimal> values) {
            addCriterion("withDrawMoney in", values, "withdrawmoney");
            return (Criteria) this;
        }

        public Criteria andWithdrawmoneyNotIn(List<BigDecimal> values) {
            addCriterion("withDrawMoney not in", values, "withdrawmoney");
            return (Criteria) this;
        }

        public Criteria andWithdrawmoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("withDrawMoney between", value1, value2, "withdrawmoney");
            return (Criteria) this;
        }

        public Criteria andWithdrawmoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("withDrawMoney not between", value1, value2, "withdrawmoney");
            return (Criteria) this;
        }

        public Criteria andChannelcodeIsNull() {
            addCriterion("channelCode is null");
            return (Criteria) this;
        }

        public Criteria andChannelcodeIsNotNull() {
            addCriterion("channelCode is not null");
            return (Criteria) this;
        }

        public Criteria andChannelcodeEqualTo(String value) {
            addCriterion("channelCode =", value, "channelcode");
            return (Criteria) this;
        }

        public Criteria andChannelcodeNotEqualTo(String value) {
            addCriterion("channelCode <>", value, "channelcode");
            return (Criteria) this;
        }

        public Criteria andChannelcodeGreaterThan(String value) {
            addCriterion("channelCode >", value, "channelcode");
            return (Criteria) this;
        }

        public Criteria andChannelcodeGreaterThanOrEqualTo(String value) {
            addCriterion("channelCode >=", value, "channelcode");
            return (Criteria) this;
        }

        public Criteria andChannelcodeLessThan(String value) {
            addCriterion("channelCode <", value, "channelcode");
            return (Criteria) this;
        }

        public Criteria andChannelcodeLessThanOrEqualTo(String value) {
            addCriterion("channelCode <=", value, "channelcode");
            return (Criteria) this;
        }

        public Criteria andChannelcodeLike(String value) {
            addCriterion("channelCode like", value, "channelcode");
            return (Criteria) this;
        }

        public Criteria andChannelcodeNotLike(String value) {
            addCriterion("channelCode not like", value, "channelcode");
            return (Criteria) this;
        }

        public Criteria andChannelcodeIn(List<String> values) {
            addCriterion("channelCode in", values, "channelcode");
            return (Criteria) this;
        }

        public Criteria andChannelcodeNotIn(List<String> values) {
            addCriterion("channelCode not in", values, "channelcode");
            return (Criteria) this;
        }

        public Criteria andChannelcodeBetween(String value1, String value2) {
            addCriterion("channelCode between", value1, value2, "channelcode");
            return (Criteria) this;
        }

        public Criteria andChannelcodeNotBetween(String value1, String value2) {
            addCriterion("channelCode not between", value1, value2, "channelcode");
            return (Criteria) this;
        }

        public Criteria andThirdorderidIsNull() {
            addCriterion("thirdOrderId is null");
            return (Criteria) this;
        }

        public Criteria andThirdorderidIsNotNull() {
            addCriterion("thirdOrderId is not null");
            return (Criteria) this;
        }

        public Criteria andThirdorderidEqualTo(String value) {
            addCriterion("thirdOrderId =", value, "thirdorderid");
            return (Criteria) this;
        }

        public Criteria andThirdorderidNotEqualTo(String value) {
            addCriterion("thirdOrderId <>", value, "thirdorderid");
            return (Criteria) this;
        }

        public Criteria andThirdorderidGreaterThan(String value) {
            addCriterion("thirdOrderId >", value, "thirdorderid");
            return (Criteria) this;
        }

        public Criteria andThirdorderidGreaterThanOrEqualTo(String value) {
            addCriterion("thirdOrderId >=", value, "thirdorderid");
            return (Criteria) this;
        }

        public Criteria andThirdorderidLessThan(String value) {
            addCriterion("thirdOrderId <", value, "thirdorderid");
            return (Criteria) this;
        }

        public Criteria andThirdorderidLessThanOrEqualTo(String value) {
            addCriterion("thirdOrderId <=", value, "thirdorderid");
            return (Criteria) this;
        }

        public Criteria andThirdorderidLike(String value) {
            addCriterion("thirdOrderId like", value, "thirdorderid");
            return (Criteria) this;
        }

        public Criteria andThirdorderidNotLike(String value) {
            addCriterion("thirdOrderId not like", value, "thirdorderid");
            return (Criteria) this;
        }

        public Criteria andThirdorderidIn(List<String> values) {
            addCriterion("thirdOrderId in", values, "thirdorderid");
            return (Criteria) this;
        }

        public Criteria andThirdorderidNotIn(List<String> values) {
            addCriterion("thirdOrderId not in", values, "thirdorderid");
            return (Criteria) this;
        }

        public Criteria andThirdorderidBetween(String value1, String value2) {
            addCriterion("thirdOrderId between", value1, value2, "thirdorderid");
            return (Criteria) this;
        }

        public Criteria andThirdorderidNotBetween(String value1, String value2) {
            addCriterion("thirdOrderId not between", value1, value2, "thirdorderid");
            return (Criteria) this;
        }

        public Criteria andAgentflagIsNull() {
            addCriterion("AGENTFLAG is null");
            return (Criteria) this;
        }

        public Criteria andAgentflagIsNotNull() {
            addCriterion("AGENTFLAG is not null");
            return (Criteria) this;
        }

        public Criteria andAgentflagEqualTo(Integer value) {
            addCriterion("AGENTFLAG =", value, "agentflag");
            return (Criteria) this;
        }

        public Criteria andAgentflagNotEqualTo(Integer value) {
            addCriterion("AGENTFLAG <>", value, "agentflag");
            return (Criteria) this;
        }

        public Criteria andAgentflagGreaterThan(Integer value) {
            addCriterion("AGENTFLAG >", value, "agentflag");
            return (Criteria) this;
        }

        public Criteria andAgentflagGreaterThanOrEqualTo(Integer value) {
            addCriterion("AGENTFLAG >=", value, "agentflag");
            return (Criteria) this;
        }

        public Criteria andAgentflagLessThan(Integer value) {
            addCriterion("AGENTFLAG <", value, "agentflag");
            return (Criteria) this;
        }

        public Criteria andAgentflagLessThanOrEqualTo(Integer value) {
            addCriterion("AGENTFLAG <=", value, "agentflag");
            return (Criteria) this;
        }

        public Criteria andAgentflagIn(List<Integer> values) {
            addCriterion("AGENTFLAG in", values, "agentflag");
            return (Criteria) this;
        }

        public Criteria andAgentflagNotIn(List<Integer> values) {
            addCriterion("AGENTFLAG not in", values, "agentflag");
            return (Criteria) this;
        }

        public Criteria andAgentflagBetween(Integer value1, Integer value2) {
            addCriterion("AGENTFLAG between", value1, value2, "agentflag");
            return (Criteria) this;
        }

        public Criteria andAgentflagNotBetween(Integer value1, Integer value2) {
            addCriterion("AGENTFLAG not between", value1, value2, "agentflag");
            return (Criteria) this;
        }

        public Criteria andResourceplaceIsNull() {
            addCriterion("resourcePlace is null");
            return (Criteria) this;
        }

        public Criteria andResourceplaceIsNotNull() {
            addCriterion("resourcePlace is not null");
            return (Criteria) this;
        }

        public Criteria andResourceplaceEqualTo(String value) {
            addCriterion("resourcePlace =", value, "resourceplace");
            return (Criteria) this;
        }

        public Criteria andResourceplaceNotEqualTo(String value) {
            addCriterion("resourcePlace <>", value, "resourceplace");
            return (Criteria) this;
        }

        public Criteria andResourceplaceGreaterThan(String value) {
            addCriterion("resourcePlace >", value, "resourceplace");
            return (Criteria) this;
        }

        public Criteria andResourceplaceGreaterThanOrEqualTo(String value) {
            addCriterion("resourcePlace >=", value, "resourceplace");
            return (Criteria) this;
        }

        public Criteria andResourceplaceLessThan(String value) {
            addCriterion("resourcePlace <", value, "resourceplace");
            return (Criteria) this;
        }

        public Criteria andResourceplaceLessThanOrEqualTo(String value) {
            addCriterion("resourcePlace <=", value, "resourceplace");
            return (Criteria) this;
        }

        public Criteria andResourceplaceLike(String value) {
            addCriterion("resourcePlace like", value, "resourceplace");
            return (Criteria) this;
        }

        public Criteria andResourceplaceNotLike(String value) {
            addCriterion("resourcePlace not like", value, "resourceplace");
            return (Criteria) this;
        }

        public Criteria andResourceplaceIn(List<String> values) {
            addCriterion("resourcePlace in", values, "resourceplace");
            return (Criteria) this;
        }

        public Criteria andResourceplaceNotIn(List<String> values) {
            addCriterion("resourcePlace not in", values, "resourceplace");
            return (Criteria) this;
        }

        public Criteria andResourceplaceBetween(String value1, String value2) {
            addCriterion("resourcePlace between", value1, value2, "resourceplace");
            return (Criteria) this;
        }

        public Criteria andResourceplaceNotBetween(String value1, String value2) {
            addCriterion("resourcePlace not between", value1, value2, "resourceplace");
            return (Criteria) this;
        }

        public Criteria andRePurchaseOrderIdIsNull() {
            addCriterion("re_purchase_order_id is null");
            return (Criteria) this;
        }

        public Criteria andRePurchaseOrderIdIsNotNull() {
            addCriterion("re_purchase_order_id is not null");
            return (Criteria) this;
        }

        public Criteria andRePurchaseOrderIdEqualTo(String value) {
            addCriterion("re_purchase_order_id =", value, "rePurchaseOrderId");
            return (Criteria) this;
        }

        public Criteria andRePurchaseOrderIdNotEqualTo(String value) {
            addCriterion("re_purchase_order_id <>", value, "rePurchaseOrderId");
            return (Criteria) this;
        }

        public Criteria andRePurchaseOrderIdGreaterThan(String value) {
            addCriterion("re_purchase_order_id >", value, "rePurchaseOrderId");
            return (Criteria) this;
        }

        public Criteria andRePurchaseOrderIdGreaterThanOrEqualTo(String value) {
            addCriterion("re_purchase_order_id >=", value, "rePurchaseOrderId");
            return (Criteria) this;
        }

        public Criteria andRePurchaseOrderIdLessThan(String value) {
            addCriterion("re_purchase_order_id <", value, "rePurchaseOrderId");
            return (Criteria) this;
        }

        public Criteria andRePurchaseOrderIdLessThanOrEqualTo(String value) {
            addCriterion("re_purchase_order_id <=", value, "rePurchaseOrderId");
            return (Criteria) this;
        }

        public Criteria andRePurchaseOrderIdLike(String value) {
            addCriterion("re_purchase_order_id like", value, "rePurchaseOrderId");
            return (Criteria) this;
        }

        public Criteria andRePurchaseOrderIdNotLike(String value) {
            addCriterion("re_purchase_order_id not like", value, "rePurchaseOrderId");
            return (Criteria) this;
        }

        public Criteria andRePurchaseOrderIdIn(List<String> values) {
            addCriterion("re_purchase_order_id in", values, "rePurchaseOrderId");
            return (Criteria) this;
        }

        public Criteria andRePurchaseOrderIdNotIn(List<String> values) {
            addCriterion("re_purchase_order_id not in", values, "rePurchaseOrderId");
            return (Criteria) this;
        }

        public Criteria andRePurchaseOrderIdBetween(String value1, String value2) {
            addCriterion("re_purchase_order_id between", value1, value2, "rePurchaseOrderId");
            return (Criteria) this;
        }

        public Criteria andRePurchaseOrderIdNotBetween(String value1, String value2) {
            addCriterion("re_purchase_order_id not between", value1, value2, "rePurchaseOrderId");
            return (Criteria) this;
        }

        public Criteria andRePurchaseOrderToIsNull() {
            addCriterion("re_purchase_order_to is null");
            return (Criteria) this;
        }

        public Criteria andRePurchaseOrderToIsNotNull() {
            addCriterion("re_purchase_order_to is not null");
            return (Criteria) this;
        }

        public Criteria andRePurchaseOrderToEqualTo(String value) {
            addCriterion("re_purchase_order_to =", value, "rePurchaseOrderTo");
            return (Criteria) this;
        }

        public Criteria andRePurchaseOrderToNotEqualTo(String value) {
            addCriterion("re_purchase_order_to <>", value, "rePurchaseOrderTo");
            return (Criteria) this;
        }

        public Criteria andRePurchaseOrderToGreaterThan(String value) {
            addCriterion("re_purchase_order_to >", value, "rePurchaseOrderTo");
            return (Criteria) this;
        }

        public Criteria andRePurchaseOrderToGreaterThanOrEqualTo(String value) {
            addCriterion("re_purchase_order_to >=", value, "rePurchaseOrderTo");
            return (Criteria) this;
        }

        public Criteria andRePurchaseOrderToLessThan(String value) {
            addCriterion("re_purchase_order_to <", value, "rePurchaseOrderTo");
            return (Criteria) this;
        }

        public Criteria andRePurchaseOrderToLessThanOrEqualTo(String value) {
            addCriterion("re_purchase_order_to <=", value, "rePurchaseOrderTo");
            return (Criteria) this;
        }

        public Criteria andRePurchaseOrderToLike(String value) {
            addCriterion("re_purchase_order_to like", value, "rePurchaseOrderTo");
            return (Criteria) this;
        }

        public Criteria andRePurchaseOrderToNotLike(String value) {
            addCriterion("re_purchase_order_to not like", value, "rePurchaseOrderTo");
            return (Criteria) this;
        }

        public Criteria andRePurchaseOrderToIn(List<String> values) {
            addCriterion("re_purchase_order_to in", values, "rePurchaseOrderTo");
            return (Criteria) this;
        }

        public Criteria andRePurchaseOrderToNotIn(List<String> values) {
            addCriterion("re_purchase_order_to not in", values, "rePurchaseOrderTo");
            return (Criteria) this;
        }

        public Criteria andRePurchaseOrderToBetween(String value1, String value2) {
            addCriterion("re_purchase_order_to between", value1, value2, "rePurchaseOrderTo");
            return (Criteria) this;
        }

        public Criteria andRePurchaseOrderToNotBetween(String value1, String value2) {
            addCriterion("re_purchase_order_to not between", value1, value2, "rePurchaseOrderTo");
            return (Criteria) this;
        }

        public Criteria andSourceNotifyIsNull() {
            addCriterion("source_notify is null");
            return (Criteria) this;
        }

        public Criteria andSourceNotifyIsNotNull() {
            addCriterion("source_notify is not null");
            return (Criteria) this;
        }

        public Criteria andSourceNotifyEqualTo(String value) {
            addCriterion("source_notify =", value, "sourceNotify");
            return (Criteria) this;
        }

        public Criteria andSourceNotifyNotEqualTo(String value) {
            addCriterion("source_notify <>", value, "sourceNotify");
            return (Criteria) this;
        }

        public Criteria andSourceNotifyGreaterThan(String value) {
            addCriterion("source_notify >", value, "sourceNotify");
            return (Criteria) this;
        }

        public Criteria andSourceNotifyGreaterThanOrEqualTo(String value) {
            addCriterion("source_notify >=", value, "sourceNotify");
            return (Criteria) this;
        }

        public Criteria andSourceNotifyLessThan(String value) {
            addCriterion("source_notify <", value, "sourceNotify");
            return (Criteria) this;
        }

        public Criteria andSourceNotifyLessThanOrEqualTo(String value) {
            addCriterion("source_notify <=", value, "sourceNotify");
            return (Criteria) this;
        }

        public Criteria andSourceNotifyLike(String value) {
            addCriterion("source_notify like", value, "sourceNotify");
            return (Criteria) this;
        }

        public Criteria andSourceNotifyNotLike(String value) {
            addCriterion("source_notify not like", value, "sourceNotify");
            return (Criteria) this;
        }

        public Criteria andSourceNotifyIn(List<String> values) {
            addCriterion("source_notify in", values, "sourceNotify");
            return (Criteria) this;
        }

        public Criteria andSourceNotifyNotIn(List<String> values) {
            addCriterion("source_notify not in", values, "sourceNotify");
            return (Criteria) this;
        }

        public Criteria andSourceNotifyBetween(String value1, String value2) {
            addCriterion("source_notify between", value1, value2, "sourceNotify");
            return (Criteria) this;
        }

        public Criteria andSourceNotifyNotBetween(String value1, String value2) {
            addCriterion("source_notify not between", value1, value2, "sourceNotify");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagIsNull() {
            addCriterion("delete_flag is null");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagIsNotNull() {
            addCriterion("delete_flag is not null");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagEqualTo(Short value) {
            addCriterion("delete_flag =", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagNotEqualTo(Short value) {
            addCriterion("delete_flag <>", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagGreaterThan(Short value) {
            addCriterion("delete_flag >", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagGreaterThanOrEqualTo(Short value) {
            addCriterion("delete_flag >=", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagLessThan(Short value) {
            addCriterion("delete_flag <", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagLessThanOrEqualTo(Short value) {
            addCriterion("delete_flag <=", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagIn(List<Short> values) {
            addCriterion("delete_flag in", values, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagNotIn(List<Short> values) {
            addCriterion("delete_flag not in", values, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagBetween(Short value1, Short value2) {
            addCriterion("delete_flag between", value1, value2, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagNotBetween(Short value1, Short value2) {
            addCriterion("delete_flag not between", value1, value2, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andPartnerpayidIsNull() {
            addCriterion("partnerPayId is null");
            return (Criteria) this;
        }

        public Criteria andPartnerpayidIsNotNull() {
            addCriterion("partnerPayId is not null");
            return (Criteria) this;
        }

        public Criteria andPartnerpayidEqualTo(String value) {
            addCriterion("partnerPayId =", value, "partnerpayid");
            return (Criteria) this;
        }

        public Criteria andPartnerpayidNotEqualTo(String value) {
            addCriterion("partnerPayId <>", value, "partnerpayid");
            return (Criteria) this;
        }

        public Criteria andPartnerpayidGreaterThan(String value) {
            addCriterion("partnerPayId >", value, "partnerpayid");
            return (Criteria) this;
        }

        public Criteria andPartnerpayidGreaterThanOrEqualTo(String value) {
            addCriterion("partnerPayId >=", value, "partnerpayid");
            return (Criteria) this;
        }

        public Criteria andPartnerpayidLessThan(String value) {
            addCriterion("partnerPayId <", value, "partnerpayid");
            return (Criteria) this;
        }

        public Criteria andPartnerpayidLessThanOrEqualTo(String value) {
            addCriterion("partnerPayId <=", value, "partnerpayid");
            return (Criteria) this;
        }

        public Criteria andPartnerpayidLike(String value) {
            addCriterion("partnerPayId like", value, "partnerpayid");
            return (Criteria) this;
        }

        public Criteria andPartnerpayidNotLike(String value) {
            addCriterion("partnerPayId not like", value, "partnerpayid");
            return (Criteria) this;
        }

        public Criteria andPartnerpayidIn(List<String> values) {
            addCriterion("partnerPayId in", values, "partnerpayid");
            return (Criteria) this;
        }

        public Criteria andPartnerpayidNotIn(List<String> values) {
            addCriterion("partnerPayId not in", values, "partnerpayid");
            return (Criteria) this;
        }

        public Criteria andPartnerpayidBetween(String value1, String value2) {
            addCriterion("partnerPayId between", value1, value2, "partnerpayid");
            return (Criteria) this;
        }

        public Criteria andPartnerpayidNotBetween(String value1, String value2) {
            addCriterion("partnerPayId not between", value1, value2, "partnerpayid");
            return (Criteria) this;
        }

        public Criteria andAttributetypeIsNull() {
            addCriterion("attributeType is null");
            return (Criteria) this;
        }

        public Criteria andAttributetypeIsNotNull() {
            addCriterion("attributeType is not null");
            return (Criteria) this;
        }

        public Criteria andAttributetypeEqualTo(String value) {
            addCriterion("attributeType =", value, "attributetype");
            return (Criteria) this;
        }

        public Criteria andAttributetypeNotEqualTo(String value) {
            addCriterion("attributeType <>", value, "attributetype");
            return (Criteria) this;
        }

        public Criteria andAttributetypeGreaterThan(String value) {
            addCriterion("attributeType >", value, "attributetype");
            return (Criteria) this;
        }

        public Criteria andAttributetypeGreaterThanOrEqualTo(String value) {
            addCriterion("attributeType >=", value, "attributetype");
            return (Criteria) this;
        }

        public Criteria andAttributetypeLessThan(String value) {
            addCriterion("attributeType <", value, "attributetype");
            return (Criteria) this;
        }

        public Criteria andAttributetypeLessThanOrEqualTo(String value) {
            addCriterion("attributeType <=", value, "attributetype");
            return (Criteria) this;
        }

        public Criteria andAttributetypeLike(String value) {
            addCriterion("attributeType like", value, "attributetype");
            return (Criteria) this;
        }

        public Criteria andAttributetypeNotLike(String value) {
            addCriterion("attributeType not like", value, "attributetype");
            return (Criteria) this;
        }

        public Criteria andAttributetypeIn(List<String> values) {
            addCriterion("attributeType in", values, "attributetype");
            return (Criteria) this;
        }

        public Criteria andAttributetypeNotIn(List<String> values) {
            addCriterion("attributeType not in", values, "attributetype");
            return (Criteria) this;
        }

        public Criteria andAttributetypeBetween(String value1, String value2) {
            addCriterion("attributeType between", value1, value2, "attributetype");
            return (Criteria) this;
        }

        public Criteria andAttributetypeNotBetween(String value1, String value2) {
            addCriterion("attributeType not between", value1, value2, "attributetype");
            return (Criteria) this;
        }

        public Criteria andUuidIsNull() {
            addCriterion("uuid is null");
            return (Criteria) this;
        }

        public Criteria andUuidIsNotNull() {
            addCriterion("uuid is not null");
            return (Criteria) this;
        }

        public Criteria andUuidEqualTo(String value) {
            addCriterion("uuid =", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotEqualTo(String value) {
            addCriterion("uuid <>", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidGreaterThan(String value) {
            addCriterion("uuid >", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidGreaterThanOrEqualTo(String value) {
            addCriterion("uuid >=", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLessThan(String value) {
            addCriterion("uuid <", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLessThanOrEqualTo(String value) {
            addCriterion("uuid <=", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLike(String value) {
            addCriterion("uuid like", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotLike(String value) {
            addCriterion("uuid not like", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidIn(List<String> values) {
            addCriterion("uuid in", values, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotIn(List<String> values) {
            addCriterion("uuid not in", values, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidBetween(String value1, String value2) {
            addCriterion("uuid between", value1, value2, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotBetween(String value1, String value2) {
            addCriterion("uuid not between", value1, value2, "uuid");
            return (Criteria) this;
        }

        public Criteria andGroupflagIsNull() {
            addCriterion("groupFlag is null");
            return (Criteria) this;
        }

        public Criteria andGroupflagIsNotNull() {
            addCriterion("groupFlag is not null");
            return (Criteria) this;
        }

        public Criteria andGroupflagEqualTo(Short value) {
            addCriterion("groupFlag =", value, "groupflag");
            return (Criteria) this;
        }

        public Criteria andGroupflagNotEqualTo(Short value) {
            addCriterion("groupFlag <>", value, "groupflag");
            return (Criteria) this;
        }

        public Criteria andGroupflagGreaterThan(Short value) {
            addCriterion("groupFlag >", value, "groupflag");
            return (Criteria) this;
        }

        public Criteria andGroupflagGreaterThanOrEqualTo(Short value) {
            addCriterion("groupFlag >=", value, "groupflag");
            return (Criteria) this;
        }

        public Criteria andGroupflagLessThan(Short value) {
            addCriterion("groupFlag <", value, "groupflag");
            return (Criteria) this;
        }

        public Criteria andGroupflagLessThanOrEqualTo(Short value) {
            addCriterion("groupFlag <=", value, "groupflag");
            return (Criteria) this;
        }

        public Criteria andGroupflagIn(List<Short> values) {
            addCriterion("groupFlag in", values, "groupflag");
            return (Criteria) this;
        }

        public Criteria andGroupflagNotIn(List<Short> values) {
            addCriterion("groupFlag not in", values, "groupflag");
            return (Criteria) this;
        }

        public Criteria andGroupflagBetween(Short value1, Short value2) {
            addCriterion("groupFlag between", value1, value2, "groupflag");
            return (Criteria) this;
        }

        public Criteria andGroupflagNotBetween(Short value1, Short value2) {
            addCriterion("groupFlag not between", value1, value2, "groupflag");
            return (Criteria) this;
        }

        public Criteria andErpidIsNull() {
            addCriterion("erpId is null");
            return (Criteria) this;
        }

        public Criteria andErpidIsNotNull() {
            addCriterion("erpId is not null");
            return (Criteria) this;
        }

        public Criteria andErpidEqualTo(String value) {
            addCriterion("erpId =", value, "erpid");
            return (Criteria) this;
        }

        public Criteria andErpidNotEqualTo(String value) {
            addCriterion("erpId <>", value, "erpid");
            return (Criteria) this;
        }

        public Criteria andErpidGreaterThan(String value) {
            addCriterion("erpId >", value, "erpid");
            return (Criteria) this;
        }

        public Criteria andErpidGreaterThanOrEqualTo(String value) {
            addCriterion("erpId >=", value, "erpid");
            return (Criteria) this;
        }

        public Criteria andErpidLessThan(String value) {
            addCriterion("erpId <", value, "erpid");
            return (Criteria) this;
        }

        public Criteria andErpidLessThanOrEqualTo(String value) {
            addCriterion("erpId <=", value, "erpid");
            return (Criteria) this;
        }

        public Criteria andErpidLike(String value) {
            addCriterion("erpId like", value, "erpid");
            return (Criteria) this;
        }

        public Criteria andErpidNotLike(String value) {
            addCriterion("erpId not like", value, "erpid");
            return (Criteria) this;
        }

        public Criteria andErpidIn(List<String> values) {
            addCriterion("erpId in", values, "erpid");
            return (Criteria) this;
        }

        public Criteria andErpidNotIn(List<String> values) {
            addCriterion("erpId not in", values, "erpid");
            return (Criteria) this;
        }

        public Criteria andErpidBetween(String value1, String value2) {
            addCriterion("erpId between", value1, value2, "erpid");
            return (Criteria) this;
        }

        public Criteria andErpidNotBetween(String value1, String value2) {
            addCriterion("erpId not between", value1, value2, "erpid");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}