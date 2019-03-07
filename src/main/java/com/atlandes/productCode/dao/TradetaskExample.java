package com.atlandes.productCode.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TradetaskExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TradetaskExample() {
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
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andBiznoIsNull() {
            addCriterion("bizNo is null");
            return (Criteria) this;
        }

        public Criteria andBiznoIsNotNull() {
            addCriterion("bizNo is not null");
            return (Criteria) this;
        }

        public Criteria andBiznoEqualTo(String value) {
            addCriterion("bizNo =", value, "bizno");
            return (Criteria) this;
        }

        public Criteria andBiznoNotEqualTo(String value) {
            addCriterion("bizNo <>", value, "bizno");
            return (Criteria) this;
        }

        public Criteria andBiznoGreaterThan(String value) {
            addCriterion("bizNo >", value, "bizno");
            return (Criteria) this;
        }

        public Criteria andBiznoGreaterThanOrEqualTo(String value) {
            addCriterion("bizNo >=", value, "bizno");
            return (Criteria) this;
        }

        public Criteria andBiznoLessThan(String value) {
            addCriterion("bizNo <", value, "bizno");
            return (Criteria) this;
        }

        public Criteria andBiznoLessThanOrEqualTo(String value) {
            addCriterion("bizNo <=", value, "bizno");
            return (Criteria) this;
        }

        public Criteria andBiznoLike(String value) {
            addCriterion("bizNo like", value, "bizno");
            return (Criteria) this;
        }

        public Criteria andBiznoNotLike(String value) {
            addCriterion("bizNo not like", value, "bizno");
            return (Criteria) this;
        }

        public Criteria andBiznoIn(List<String> values) {
            addCriterion("bizNo in", values, "bizno");
            return (Criteria) this;
        }

        public Criteria andBiznoNotIn(List<String> values) {
            addCriterion("bizNo not in", values, "bizno");
            return (Criteria) this;
        }

        public Criteria andBiznoBetween(String value1, String value2) {
            addCriterion("bizNo between", value1, value2, "bizno");
            return (Criteria) this;
        }

        public Criteria andBiznoNotBetween(String value1, String value2) {
            addCriterion("bizNo not between", value1, value2, "bizno");
            return (Criteria) this;
        }

        public Criteria andBiztypeIsNull() {
            addCriterion("bizType is null");
            return (Criteria) this;
        }

        public Criteria andBiztypeIsNotNull() {
            addCriterion("bizType is not null");
            return (Criteria) this;
        }

        public Criteria andBiztypeEqualTo(String value) {
            addCriterion("bizType =", value, "biztype");
            return (Criteria) this;
        }

        public Criteria andBiztypeNotEqualTo(String value) {
            addCriterion("bizType <>", value, "biztype");
            return (Criteria) this;
        }

        public Criteria andBiztypeGreaterThan(String value) {
            addCriterion("bizType >", value, "biztype");
            return (Criteria) this;
        }

        public Criteria andBiztypeGreaterThanOrEqualTo(String value) {
            addCriterion("bizType >=", value, "biztype");
            return (Criteria) this;
        }

        public Criteria andBiztypeLessThan(String value) {
            addCriterion("bizType <", value, "biztype");
            return (Criteria) this;
        }

        public Criteria andBiztypeLessThanOrEqualTo(String value) {
            addCriterion("bizType <=", value, "biztype");
            return (Criteria) this;
        }

        public Criteria andBiztypeLike(String value) {
            addCriterion("bizType like", value, "biztype");
            return (Criteria) this;
        }

        public Criteria andBiztypeNotLike(String value) {
            addCriterion("bizType not like", value, "biztype");
            return (Criteria) this;
        }

        public Criteria andBiztypeIn(List<String> values) {
            addCriterion("bizType in", values, "biztype");
            return (Criteria) this;
        }

        public Criteria andBiztypeNotIn(List<String> values) {
            addCriterion("bizType not in", values, "biztype");
            return (Criteria) this;
        }

        public Criteria andBiztypeBetween(String value1, String value2) {
            addCriterion("bizType between", value1, value2, "biztype");
            return (Criteria) this;
        }

        public Criteria andBiztypeNotBetween(String value1, String value2) {
            addCriterion("bizType not between", value1, value2, "biztype");
            return (Criteria) this;
        }

        public Criteria andOrderidIsNull() {
            addCriterion("orderId is null");
            return (Criteria) this;
        }

        public Criteria andOrderidIsNotNull() {
            addCriterion("orderId is not null");
            return (Criteria) this;
        }

        public Criteria andOrderidEqualTo(String value) {
            addCriterion("orderId =", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidNotEqualTo(String value) {
            addCriterion("orderId <>", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidGreaterThan(String value) {
            addCriterion("orderId >", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidGreaterThanOrEqualTo(String value) {
            addCriterion("orderId >=", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidLessThan(String value) {
            addCriterion("orderId <", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidLessThanOrEqualTo(String value) {
            addCriterion("orderId <=", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidLike(String value) {
            addCriterion("orderId like", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidNotLike(String value) {
            addCriterion("orderId not like", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidIn(List<String> values) {
            addCriterion("orderId in", values, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidNotIn(List<String> values) {
            addCriterion("orderId not in", values, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidBetween(String value1, String value2) {
            addCriterion("orderId between", value1, value2, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidNotBetween(String value1, String value2) {
            addCriterion("orderId not between", value1, value2, "orderid");
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

        public Criteria andTaskinfoIsNull() {
            addCriterion("taskInfo is null");
            return (Criteria) this;
        }

        public Criteria andTaskinfoIsNotNull() {
            addCriterion("taskInfo is not null");
            return (Criteria) this;
        }

        public Criteria andTaskinfoEqualTo(String value) {
            addCriterion("taskInfo =", value, "taskinfo");
            return (Criteria) this;
        }

        public Criteria andTaskinfoNotEqualTo(String value) {
            addCriterion("taskInfo <>", value, "taskinfo");
            return (Criteria) this;
        }

        public Criteria andTaskinfoGreaterThan(String value) {
            addCriterion("taskInfo >", value, "taskinfo");
            return (Criteria) this;
        }

        public Criteria andTaskinfoGreaterThanOrEqualTo(String value) {
            addCriterion("taskInfo >=", value, "taskinfo");
            return (Criteria) this;
        }

        public Criteria andTaskinfoLessThan(String value) {
            addCriterion("taskInfo <", value, "taskinfo");
            return (Criteria) this;
        }

        public Criteria andTaskinfoLessThanOrEqualTo(String value) {
            addCriterion("taskInfo <=", value, "taskinfo");
            return (Criteria) this;
        }

        public Criteria andTaskinfoLike(String value) {
            addCriterion("taskInfo like", value, "taskinfo");
            return (Criteria) this;
        }

        public Criteria andTaskinfoNotLike(String value) {
            addCriterion("taskInfo not like", value, "taskinfo");
            return (Criteria) this;
        }

        public Criteria andTaskinfoIn(List<String> values) {
            addCriterion("taskInfo in", values, "taskinfo");
            return (Criteria) this;
        }

        public Criteria andTaskinfoNotIn(List<String> values) {
            addCriterion("taskInfo not in", values, "taskinfo");
            return (Criteria) this;
        }

        public Criteria andTaskinfoBetween(String value1, String value2) {
            addCriterion("taskInfo between", value1, value2, "taskinfo");
            return (Criteria) this;
        }

        public Criteria andTaskinfoNotBetween(String value1, String value2) {
            addCriterion("taskInfo not between", value1, value2, "taskinfo");
            return (Criteria) this;
        }

        public Criteria andTaskstatusIsNull() {
            addCriterion("taskStatus is null");
            return (Criteria) this;
        }

        public Criteria andTaskstatusIsNotNull() {
            addCriterion("taskStatus is not null");
            return (Criteria) this;
        }

        public Criteria andTaskstatusEqualTo(Short value) {
            addCriterion("taskStatus =", value, "taskstatus");
            return (Criteria) this;
        }

        public Criteria andTaskstatusNotEqualTo(Short value) {
            addCriterion("taskStatus <>", value, "taskstatus");
            return (Criteria) this;
        }

        public Criteria andTaskstatusGreaterThan(Short value) {
            addCriterion("taskStatus >", value, "taskstatus");
            return (Criteria) this;
        }

        public Criteria andTaskstatusGreaterThanOrEqualTo(Short value) {
            addCriterion("taskStatus >=", value, "taskstatus");
            return (Criteria) this;
        }

        public Criteria andTaskstatusLessThan(Short value) {
            addCriterion("taskStatus <", value, "taskstatus");
            return (Criteria) this;
        }

        public Criteria andTaskstatusLessThanOrEqualTo(Short value) {
            addCriterion("taskStatus <=", value, "taskstatus");
            return (Criteria) this;
        }

        public Criteria andTaskstatusIn(List<Short> values) {
            addCriterion("taskStatus in", values, "taskstatus");
            return (Criteria) this;
        }

        public Criteria andTaskstatusNotIn(List<Short> values) {
            addCriterion("taskStatus not in", values, "taskstatus");
            return (Criteria) this;
        }

        public Criteria andTaskstatusBetween(Short value1, Short value2) {
            addCriterion("taskStatus between", value1, value2, "taskstatus");
            return (Criteria) this;
        }

        public Criteria andTaskstatusNotBetween(Short value1, Short value2) {
            addCriterion("taskStatus not between", value1, value2, "taskstatus");
            return (Criteria) this;
        }

        public Criteria andCreatedateIsNull() {
            addCriterion("createDate is null");
            return (Criteria) this;
        }

        public Criteria andCreatedateIsNotNull() {
            addCriterion("createDate is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedateEqualTo(Date value) {
            addCriterion("createDate =", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotEqualTo(Date value) {
            addCriterion("createDate <>", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateGreaterThan(Date value) {
            addCriterion("createDate >", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateGreaterThanOrEqualTo(Date value) {
            addCriterion("createDate >=", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateLessThan(Date value) {
            addCriterion("createDate <", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateLessThanOrEqualTo(Date value) {
            addCriterion("createDate <=", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateIn(List<Date> values) {
            addCriterion("createDate in", values, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotIn(List<Date> values) {
            addCriterion("createDate not in", values, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateBetween(Date value1, Date value2) {
            addCriterion("createDate between", value1, value2, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotBetween(Date value1, Date value2) {
            addCriterion("createDate not between", value1, value2, "createdate");
            return (Criteria) this;
        }

        public Criteria andLastupdatedateIsNull() {
            addCriterion("lastUpdateDate is null");
            return (Criteria) this;
        }

        public Criteria andLastupdatedateIsNotNull() {
            addCriterion("lastUpdateDate is not null");
            return (Criteria) this;
        }

        public Criteria andLastupdatedateEqualTo(Date value) {
            addCriterion("lastUpdateDate =", value, "lastupdatedate");
            return (Criteria) this;
        }

        public Criteria andLastupdatedateNotEqualTo(Date value) {
            addCriterion("lastUpdateDate <>", value, "lastupdatedate");
            return (Criteria) this;
        }

        public Criteria andLastupdatedateGreaterThan(Date value) {
            addCriterion("lastUpdateDate >", value, "lastupdatedate");
            return (Criteria) this;
        }

        public Criteria andLastupdatedateGreaterThanOrEqualTo(Date value) {
            addCriterion("lastUpdateDate >=", value, "lastupdatedate");
            return (Criteria) this;
        }

        public Criteria andLastupdatedateLessThan(Date value) {
            addCriterion("lastUpdateDate <", value, "lastupdatedate");
            return (Criteria) this;
        }

        public Criteria andLastupdatedateLessThanOrEqualTo(Date value) {
            addCriterion("lastUpdateDate <=", value, "lastupdatedate");
            return (Criteria) this;
        }

        public Criteria andLastupdatedateIn(List<Date> values) {
            addCriterion("lastUpdateDate in", values, "lastupdatedate");
            return (Criteria) this;
        }

        public Criteria andLastupdatedateNotIn(List<Date> values) {
            addCriterion("lastUpdateDate not in", values, "lastupdatedate");
            return (Criteria) this;
        }

        public Criteria andLastupdatedateBetween(Date value1, Date value2) {
            addCriterion("lastUpdateDate between", value1, value2, "lastupdatedate");
            return (Criteria) this;
        }

        public Criteria andLastupdatedateNotBetween(Date value1, Date value2) {
            addCriterion("lastUpdateDate not between", value1, value2, "lastupdatedate");
            return (Criteria) this;
        }

        public Criteria andRetrytimeIsNull() {
            addCriterion("retryTime is null");
            return (Criteria) this;
        }

        public Criteria andRetrytimeIsNotNull() {
            addCriterion("retryTime is not null");
            return (Criteria) this;
        }

        public Criteria andRetrytimeEqualTo(Short value) {
            addCriterion("retryTime =", value, "retrytime");
            return (Criteria) this;
        }

        public Criteria andRetrytimeNotEqualTo(Short value) {
            addCriterion("retryTime <>", value, "retrytime");
            return (Criteria) this;
        }

        public Criteria andRetrytimeGreaterThan(Short value) {
            addCriterion("retryTime >", value, "retrytime");
            return (Criteria) this;
        }

        public Criteria andRetrytimeGreaterThanOrEqualTo(Short value) {
            addCriterion("retryTime >=", value, "retrytime");
            return (Criteria) this;
        }

        public Criteria andRetrytimeLessThan(Short value) {
            addCriterion("retryTime <", value, "retrytime");
            return (Criteria) this;
        }

        public Criteria andRetrytimeLessThanOrEqualTo(Short value) {
            addCriterion("retryTime <=", value, "retrytime");
            return (Criteria) this;
        }

        public Criteria andRetrytimeIn(List<Short> values) {
            addCriterion("retryTime in", values, "retrytime");
            return (Criteria) this;
        }

        public Criteria andRetrytimeNotIn(List<Short> values) {
            addCriterion("retryTime not in", values, "retrytime");
            return (Criteria) this;
        }

        public Criteria andRetrytimeBetween(Short value1, Short value2) {
            addCriterion("retryTime between", value1, value2, "retrytime");
            return (Criteria) this;
        }

        public Criteria andRetrytimeNotBetween(Short value1, Short value2) {
            addCriterion("retryTime not between", value1, value2, "retrytime");
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