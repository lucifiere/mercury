package com.atlandes.productCode.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PolicyorderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PolicyorderExample() {
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

        public Criteria andPolicynoIsNull() {
            addCriterion("PolicyNo is null");
            return (Criteria) this;
        }

        public Criteria andPolicynoIsNotNull() {
            addCriterion("PolicyNo is not null");
            return (Criteria) this;
        }

        public Criteria andPolicynoEqualTo(String value) {
            addCriterion("PolicyNo =", value, "policyno");
            return (Criteria) this;
        }

        public Criteria andPolicynoNotEqualTo(String value) {
            addCriterion("PolicyNo <>", value, "policyno");
            return (Criteria) this;
        }

        public Criteria andPolicynoGreaterThan(String value) {
            addCriterion("PolicyNo >", value, "policyno");
            return (Criteria) this;
        }

        public Criteria andPolicynoGreaterThanOrEqualTo(String value) {
            addCriterion("PolicyNo >=", value, "policyno");
            return (Criteria) this;
        }

        public Criteria andPolicynoLessThan(String value) {
            addCriterion("PolicyNo <", value, "policyno");
            return (Criteria) this;
        }

        public Criteria andPolicynoLessThanOrEqualTo(String value) {
            addCriterion("PolicyNo <=", value, "policyno");
            return (Criteria) this;
        }

        public Criteria andPolicynoLike(String value) {
            addCriterion("PolicyNo like", value, "policyno");
            return (Criteria) this;
        }

        public Criteria andPolicynoNotLike(String value) {
            addCriterion("PolicyNo not like", value, "policyno");
            return (Criteria) this;
        }

        public Criteria andPolicynoIn(List<String> values) {
            addCriterion("PolicyNo in", values, "policyno");
            return (Criteria) this;
        }

        public Criteria andPolicynoNotIn(List<String> values) {
            addCriterion("PolicyNo not in", values, "policyno");
            return (Criteria) this;
        }

        public Criteria andPolicynoBetween(String value1, String value2) {
            addCriterion("PolicyNo between", value1, value2, "policyno");
            return (Criteria) this;
        }

        public Criteria andPolicynoNotBetween(String value1, String value2) {
            addCriterion("PolicyNo not between", value1, value2, "policyno");
            return (Criteria) this;
        }

        public Criteria andProposalnoIsNull() {
            addCriterion("ProposalNo is null");
            return (Criteria) this;
        }

        public Criteria andProposalnoIsNotNull() {
            addCriterion("ProposalNo is not null");
            return (Criteria) this;
        }

        public Criteria andProposalnoEqualTo(String value) {
            addCriterion("ProposalNo =", value, "proposalno");
            return (Criteria) this;
        }

        public Criteria andProposalnoNotEqualTo(String value) {
            addCriterion("ProposalNo <>", value, "proposalno");
            return (Criteria) this;
        }

        public Criteria andProposalnoGreaterThan(String value) {
            addCriterion("ProposalNo >", value, "proposalno");
            return (Criteria) this;
        }

        public Criteria andProposalnoGreaterThanOrEqualTo(String value) {
            addCriterion("ProposalNo >=", value, "proposalno");
            return (Criteria) this;
        }

        public Criteria andProposalnoLessThan(String value) {
            addCriterion("ProposalNo <", value, "proposalno");
            return (Criteria) this;
        }

        public Criteria andProposalnoLessThanOrEqualTo(String value) {
            addCriterion("ProposalNo <=", value, "proposalno");
            return (Criteria) this;
        }

        public Criteria andProposalnoLike(String value) {
            addCriterion("ProposalNo like", value, "proposalno");
            return (Criteria) this;
        }

        public Criteria andProposalnoNotLike(String value) {
            addCriterion("ProposalNo not like", value, "proposalno");
            return (Criteria) this;
        }

        public Criteria andProposalnoIn(List<String> values) {
            addCriterion("ProposalNo in", values, "proposalno");
            return (Criteria) this;
        }

        public Criteria andProposalnoNotIn(List<String> values) {
            addCriterion("ProposalNo not in", values, "proposalno");
            return (Criteria) this;
        }

        public Criteria andProposalnoBetween(String value1, String value2) {
            addCriterion("ProposalNo between", value1, value2, "proposalno");
            return (Criteria) this;
        }

        public Criteria andProposalnoNotBetween(String value1, String value2) {
            addCriterion("ProposalNo not between", value1, value2, "proposalno");
            return (Criteria) this;
        }

        public Criteria andUuidIsNull() {
            addCriterion("UUID is null");
            return (Criteria) this;
        }

        public Criteria andUuidIsNotNull() {
            addCriterion("UUID is not null");
            return (Criteria) this;
        }

        public Criteria andUuidEqualTo(String value) {
            addCriterion("UUID =", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotEqualTo(String value) {
            addCriterion("UUID <>", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidGreaterThan(String value) {
            addCriterion("UUID >", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidGreaterThanOrEqualTo(String value) {
            addCriterion("UUID >=", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLessThan(String value) {
            addCriterion("UUID <", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLessThanOrEqualTo(String value) {
            addCriterion("UUID <=", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLike(String value) {
            addCriterion("UUID like", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotLike(String value) {
            addCriterion("UUID not like", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidIn(List<String> values) {
            addCriterion("UUID in", values, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotIn(List<String> values) {
            addCriterion("UUID not in", values, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidBetween(String value1, String value2) {
            addCriterion("UUID between", value1, value2, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotBetween(String value1, String value2) {
            addCriterion("UUID not between", value1, value2, "uuid");
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

        public Criteria andPartnerproductcodeIsNull() {
            addCriterion("partnerProductCode is null");
            return (Criteria) this;
        }

        public Criteria andPartnerproductcodeIsNotNull() {
            addCriterion("partnerProductCode is not null");
            return (Criteria) this;
        }

        public Criteria andPartnerproductcodeEqualTo(String value) {
            addCriterion("partnerProductCode =", value, "partnerproductcode");
            return (Criteria) this;
        }

        public Criteria andPartnerproductcodeNotEqualTo(String value) {
            addCriterion("partnerProductCode <>", value, "partnerproductcode");
            return (Criteria) this;
        }

        public Criteria andPartnerproductcodeGreaterThan(String value) {
            addCriterion("partnerProductCode >", value, "partnerproductcode");
            return (Criteria) this;
        }

        public Criteria andPartnerproductcodeGreaterThanOrEqualTo(String value) {
            addCriterion("partnerProductCode >=", value, "partnerproductcode");
            return (Criteria) this;
        }

        public Criteria andPartnerproductcodeLessThan(String value) {
            addCriterion("partnerProductCode <", value, "partnerproductcode");
            return (Criteria) this;
        }

        public Criteria andPartnerproductcodeLessThanOrEqualTo(String value) {
            addCriterion("partnerProductCode <=", value, "partnerproductcode");
            return (Criteria) this;
        }

        public Criteria andPartnerproductcodeLike(String value) {
            addCriterion("partnerProductCode like", value, "partnerproductcode");
            return (Criteria) this;
        }

        public Criteria andPartnerproductcodeNotLike(String value) {
            addCriterion("partnerProductCode not like", value, "partnerproductcode");
            return (Criteria) this;
        }

        public Criteria andPartnerproductcodeIn(List<String> values) {
            addCriterion("partnerProductCode in", values, "partnerproductcode");
            return (Criteria) this;
        }

        public Criteria andPartnerproductcodeNotIn(List<String> values) {
            addCriterion("partnerProductCode not in", values, "partnerproductcode");
            return (Criteria) this;
        }

        public Criteria andPartnerproductcodeBetween(String value1, String value2) {
            addCriterion("partnerProductCode between", value1, value2, "partnerproductcode");
            return (Criteria) this;
        }

        public Criteria andPartnerproductcodeNotBetween(String value1, String value2) {
            addCriterion("partnerProductCode not between", value1, value2, "partnerproductcode");
            return (Criteria) this;
        }

        public Criteria andCustomermappingIsNull() {
            addCriterion("CustomerMapping is null");
            return (Criteria) this;
        }

        public Criteria andCustomermappingIsNotNull() {
            addCriterion("CustomerMapping is not null");
            return (Criteria) this;
        }

        public Criteria andCustomermappingEqualTo(String value) {
            addCriterion("CustomerMapping =", value, "customermapping");
            return (Criteria) this;
        }

        public Criteria andCustomermappingNotEqualTo(String value) {
            addCriterion("CustomerMapping <>", value, "customermapping");
            return (Criteria) this;
        }

        public Criteria andCustomermappingGreaterThan(String value) {
            addCriterion("CustomerMapping >", value, "customermapping");
            return (Criteria) this;
        }

        public Criteria andCustomermappingGreaterThanOrEqualTo(String value) {
            addCriterion("CustomerMapping >=", value, "customermapping");
            return (Criteria) this;
        }

        public Criteria andCustomermappingLessThan(String value) {
            addCriterion("CustomerMapping <", value, "customermapping");
            return (Criteria) this;
        }

        public Criteria andCustomermappingLessThanOrEqualTo(String value) {
            addCriterion("CustomerMapping <=", value, "customermapping");
            return (Criteria) this;
        }

        public Criteria andCustomermappingLike(String value) {
            addCriterion("CustomerMapping like", value, "customermapping");
            return (Criteria) this;
        }

        public Criteria andCustomermappingNotLike(String value) {
            addCriterion("CustomerMapping not like", value, "customermapping");
            return (Criteria) this;
        }

        public Criteria andCustomermappingIn(List<String> values) {
            addCriterion("CustomerMapping in", values, "customermapping");
            return (Criteria) this;
        }

        public Criteria andCustomermappingNotIn(List<String> values) {
            addCriterion("CustomerMapping not in", values, "customermapping");
            return (Criteria) this;
        }

        public Criteria andCustomermappingBetween(String value1, String value2) {
            addCriterion("CustomerMapping between", value1, value2, "customermapping");
            return (Criteria) this;
        }

        public Criteria andCustomermappingNotBetween(String value1, String value2) {
            addCriterion("CustomerMapping not between", value1, value2, "customermapping");
            return (Criteria) this;
        }

        public Criteria andPolicypriceIsNull() {
            addCriterion("PolicyPrice is null");
            return (Criteria) this;
        }

        public Criteria andPolicypriceIsNotNull() {
            addCriterion("PolicyPrice is not null");
            return (Criteria) this;
        }

        public Criteria andPolicypriceEqualTo(BigDecimal value) {
            addCriterion("PolicyPrice =", value, "policyprice");
            return (Criteria) this;
        }

        public Criteria andPolicypriceNotEqualTo(BigDecimal value) {
            addCriterion("PolicyPrice <>", value, "policyprice");
            return (Criteria) this;
        }

        public Criteria andPolicypriceGreaterThan(BigDecimal value) {
            addCriterion("PolicyPrice >", value, "policyprice");
            return (Criteria) this;
        }

        public Criteria andPolicypriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PolicyPrice >=", value, "policyprice");
            return (Criteria) this;
        }

        public Criteria andPolicypriceLessThan(BigDecimal value) {
            addCriterion("PolicyPrice <", value, "policyprice");
            return (Criteria) this;
        }

        public Criteria andPolicypriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("PolicyPrice <=", value, "policyprice");
            return (Criteria) this;
        }

        public Criteria andPolicypriceIn(List<BigDecimal> values) {
            addCriterion("PolicyPrice in", values, "policyprice");
            return (Criteria) this;
        }

        public Criteria andPolicypriceNotIn(List<BigDecimal> values) {
            addCriterion("PolicyPrice not in", values, "policyprice");
            return (Criteria) this;
        }

        public Criteria andPolicypriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PolicyPrice between", value1, value2, "policyprice");
            return (Criteria) this;
        }

        public Criteria andPolicypriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PolicyPrice not between", value1, value2, "policyprice");
            return (Criteria) this;
        }

        public Criteria andDownloadurlIsNull() {
            addCriterion("downloadurl is null");
            return (Criteria) this;
        }

        public Criteria andDownloadurlIsNotNull() {
            addCriterion("downloadurl is not null");
            return (Criteria) this;
        }

        public Criteria andDownloadurlEqualTo(String value) {
            addCriterion("downloadurl =", value, "downloadurl");
            return (Criteria) this;
        }

        public Criteria andDownloadurlNotEqualTo(String value) {
            addCriterion("downloadurl <>", value, "downloadurl");
            return (Criteria) this;
        }

        public Criteria andDownloadurlGreaterThan(String value) {
            addCriterion("downloadurl >", value, "downloadurl");
            return (Criteria) this;
        }

        public Criteria andDownloadurlGreaterThanOrEqualTo(String value) {
            addCriterion("downloadurl >=", value, "downloadurl");
            return (Criteria) this;
        }

        public Criteria andDownloadurlLessThan(String value) {
            addCriterion("downloadurl <", value, "downloadurl");
            return (Criteria) this;
        }

        public Criteria andDownloadurlLessThanOrEqualTo(String value) {
            addCriterion("downloadurl <=", value, "downloadurl");
            return (Criteria) this;
        }

        public Criteria andDownloadurlLike(String value) {
            addCriterion("downloadurl like", value, "downloadurl");
            return (Criteria) this;
        }

        public Criteria andDownloadurlNotLike(String value) {
            addCriterion("downloadurl not like", value, "downloadurl");
            return (Criteria) this;
        }

        public Criteria andDownloadurlIn(List<String> values) {
            addCriterion("downloadurl in", values, "downloadurl");
            return (Criteria) this;
        }

        public Criteria andDownloadurlNotIn(List<String> values) {
            addCriterion("downloadurl not in", values, "downloadurl");
            return (Criteria) this;
        }

        public Criteria andDownloadurlBetween(String value1, String value2) {
            addCriterion("downloadurl between", value1, value2, "downloadurl");
            return (Criteria) this;
        }

        public Criteria andDownloadurlNotBetween(String value1, String value2) {
            addCriterion("downloadurl not between", value1, value2, "downloadurl");
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

        public Criteria andInsquantityIsNull() {
            addCriterion("InsQuantity is null");
            return (Criteria) this;
        }

        public Criteria andInsquantityIsNotNull() {
            addCriterion("InsQuantity is not null");
            return (Criteria) this;
        }

        public Criteria andInsquantityEqualTo(Short value) {
            addCriterion("InsQuantity =", value, "insquantity");
            return (Criteria) this;
        }

        public Criteria andInsquantityNotEqualTo(Short value) {
            addCriterion("InsQuantity <>", value, "insquantity");
            return (Criteria) this;
        }

        public Criteria andInsquantityGreaterThan(Short value) {
            addCriterion("InsQuantity >", value, "insquantity");
            return (Criteria) this;
        }

        public Criteria andInsquantityGreaterThanOrEqualTo(Short value) {
            addCriterion("InsQuantity >=", value, "insquantity");
            return (Criteria) this;
        }

        public Criteria andInsquantityLessThan(Short value) {
            addCriterion("InsQuantity <", value, "insquantity");
            return (Criteria) this;
        }

        public Criteria andInsquantityLessThanOrEqualTo(Short value) {
            addCriterion("InsQuantity <=", value, "insquantity");
            return (Criteria) this;
        }

        public Criteria andInsquantityIn(List<Short> values) {
            addCriterion("InsQuantity in", values, "insquantity");
            return (Criteria) this;
        }

        public Criteria andInsquantityNotIn(List<Short> values) {
            addCriterion("InsQuantity not in", values, "insquantity");
            return (Criteria) this;
        }

        public Criteria andInsquantityBetween(Short value1, Short value2) {
            addCriterion("InsQuantity between", value1, value2, "insquantity");
            return (Criteria) this;
        }

        public Criteria andInsquantityNotBetween(Short value1, Short value2) {
            addCriterion("InsQuantity not between", value1, value2, "insquantity");
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

        public Criteria andProposaldateIsNull() {
            addCriterion("ProposalDate is null");
            return (Criteria) this;
        }

        public Criteria andProposaldateIsNotNull() {
            addCriterion("ProposalDate is not null");
            return (Criteria) this;
        }

        public Criteria andProposaldateEqualTo(Date value) {
            addCriterion("ProposalDate =", value, "proposaldate");
            return (Criteria) this;
        }

        public Criteria andProposaldateNotEqualTo(Date value) {
            addCriterion("ProposalDate <>", value, "proposaldate");
            return (Criteria) this;
        }

        public Criteria andProposaldateGreaterThan(Date value) {
            addCriterion("ProposalDate >", value, "proposaldate");
            return (Criteria) this;
        }

        public Criteria andProposaldateGreaterThanOrEqualTo(Date value) {
            addCriterion("ProposalDate >=", value, "proposaldate");
            return (Criteria) this;
        }

        public Criteria andProposaldateLessThan(Date value) {
            addCriterion("ProposalDate <", value, "proposaldate");
            return (Criteria) this;
        }

        public Criteria andProposaldateLessThanOrEqualTo(Date value) {
            addCriterion("ProposalDate <=", value, "proposaldate");
            return (Criteria) this;
        }

        public Criteria andProposaldateIn(List<Date> values) {
            addCriterion("ProposalDate in", values, "proposaldate");
            return (Criteria) this;
        }

        public Criteria andProposaldateNotIn(List<Date> values) {
            addCriterion("ProposalDate not in", values, "proposaldate");
            return (Criteria) this;
        }

        public Criteria andProposaldateBetween(Date value1, Date value2) {
            addCriterion("ProposalDate between", value1, value2, "proposaldate");
            return (Criteria) this;
        }

        public Criteria andProposaldateNotBetween(Date value1, Date value2) {
            addCriterion("ProposalDate not between", value1, value2, "proposaldate");
            return (Criteria) this;
        }

        public Criteria andPolicydateIsNull() {
            addCriterion("PolicyDate is null");
            return (Criteria) this;
        }

        public Criteria andPolicydateIsNotNull() {
            addCriterion("PolicyDate is not null");
            return (Criteria) this;
        }

        public Criteria andPolicydateEqualTo(Date value) {
            addCriterion("PolicyDate =", value, "policydate");
            return (Criteria) this;
        }

        public Criteria andPolicydateNotEqualTo(Date value) {
            addCriterion("PolicyDate <>", value, "policydate");
            return (Criteria) this;
        }

        public Criteria andPolicydateGreaterThan(Date value) {
            addCriterion("PolicyDate >", value, "policydate");
            return (Criteria) this;
        }

        public Criteria andPolicydateGreaterThanOrEqualTo(Date value) {
            addCriterion("PolicyDate >=", value, "policydate");
            return (Criteria) this;
        }

        public Criteria andPolicydateLessThan(Date value) {
            addCriterion("PolicyDate <", value, "policydate");
            return (Criteria) this;
        }

        public Criteria andPolicydateLessThanOrEqualTo(Date value) {
            addCriterion("PolicyDate <=", value, "policydate");
            return (Criteria) this;
        }

        public Criteria andPolicydateIn(List<Date> values) {
            addCriterion("PolicyDate in", values, "policydate");
            return (Criteria) this;
        }

        public Criteria andPolicydateNotIn(List<Date> values) {
            addCriterion("PolicyDate not in", values, "policydate");
            return (Criteria) this;
        }

        public Criteria andPolicydateBetween(Date value1, Date value2) {
            addCriterion("PolicyDate between", value1, value2, "policydate");
            return (Criteria) this;
        }

        public Criteria andPolicydateNotBetween(Date value1, Date value2) {
            addCriterion("PolicyDate not between", value1, value2, "policydate");
            return (Criteria) this;
        }

        public Criteria andCretedateIsNull() {
            addCriterion("CreteDate is null");
            return (Criteria) this;
        }

        public Criteria andCretedateIsNotNull() {
            addCriterion("CreteDate is not null");
            return (Criteria) this;
        }

        public Criteria andCretedateEqualTo(Date value) {
            addCriterion("CreteDate =", value, "cretedate");
            return (Criteria) this;
        }

        public Criteria andCretedateNotEqualTo(Date value) {
            addCriterion("CreteDate <>", value, "cretedate");
            return (Criteria) this;
        }

        public Criteria andCretedateGreaterThan(Date value) {
            addCriterion("CreteDate >", value, "cretedate");
            return (Criteria) this;
        }

        public Criteria andCretedateGreaterThanOrEqualTo(Date value) {
            addCriterion("CreteDate >=", value, "cretedate");
            return (Criteria) this;
        }

        public Criteria andCretedateLessThan(Date value) {
            addCriterion("CreteDate <", value, "cretedate");
            return (Criteria) this;
        }

        public Criteria andCretedateLessThanOrEqualTo(Date value) {
            addCriterion("CreteDate <=", value, "cretedate");
            return (Criteria) this;
        }

        public Criteria andCretedateIn(List<Date> values) {
            addCriterion("CreteDate in", values, "cretedate");
            return (Criteria) this;
        }

        public Criteria andCretedateNotIn(List<Date> values) {
            addCriterion("CreteDate not in", values, "cretedate");
            return (Criteria) this;
        }

        public Criteria andCretedateBetween(Date value1, Date value2) {
            addCriterion("CreteDate between", value1, value2, "cretedate");
            return (Criteria) this;
        }

        public Criteria andCretedateNotBetween(Date value1, Date value2) {
            addCriterion("CreteDate not between", value1, value2, "cretedate");
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

        public Criteria andPolicylimitpriceIsNull() {
            addCriterion("PolicyLimitPrice is null");
            return (Criteria) this;
        }

        public Criteria andPolicylimitpriceIsNotNull() {
            addCriterion("PolicyLimitPrice is not null");
            return (Criteria) this;
        }

        public Criteria andPolicylimitpriceEqualTo(Long value) {
            addCriterion("PolicyLimitPrice =", value, "policylimitprice");
            return (Criteria) this;
        }

        public Criteria andPolicylimitpriceNotEqualTo(Long value) {
            addCriterion("PolicyLimitPrice <>", value, "policylimitprice");
            return (Criteria) this;
        }

        public Criteria andPolicylimitpriceGreaterThan(Long value) {
            addCriterion("PolicyLimitPrice >", value, "policylimitprice");
            return (Criteria) this;
        }

        public Criteria andPolicylimitpriceGreaterThanOrEqualTo(Long value) {
            addCriterion("PolicyLimitPrice >=", value, "policylimitprice");
            return (Criteria) this;
        }

        public Criteria andPolicylimitpriceLessThan(Long value) {
            addCriterion("PolicyLimitPrice <", value, "policylimitprice");
            return (Criteria) this;
        }

        public Criteria andPolicylimitpriceLessThanOrEqualTo(Long value) {
            addCriterion("PolicyLimitPrice <=", value, "policylimitprice");
            return (Criteria) this;
        }

        public Criteria andPolicylimitpriceIn(List<Long> values) {
            addCriterion("PolicyLimitPrice in", values, "policylimitprice");
            return (Criteria) this;
        }

        public Criteria andPolicylimitpriceNotIn(List<Long> values) {
            addCriterion("PolicyLimitPrice not in", values, "policylimitprice");
            return (Criteria) this;
        }

        public Criteria andPolicylimitpriceBetween(Long value1, Long value2) {
            addCriterion("PolicyLimitPrice between", value1, value2, "policylimitprice");
            return (Criteria) this;
        }

        public Criteria andPolicylimitpriceNotBetween(Long value1, Long value2) {
            addCriterion("PolicyLimitPrice not between", value1, value2, "policylimitprice");
            return (Criteria) this;
        }

        public Criteria andPolicytypeIsNull() {
            addCriterion("PolicyType is null");
            return (Criteria) this;
        }

        public Criteria andPolicytypeIsNotNull() {
            addCriterion("PolicyType is not null");
            return (Criteria) this;
        }

        public Criteria andPolicytypeEqualTo(Short value) {
            addCriterion("PolicyType =", value, "policytype");
            return (Criteria) this;
        }

        public Criteria andPolicytypeNotEqualTo(Short value) {
            addCriterion("PolicyType <>", value, "policytype");
            return (Criteria) this;
        }

        public Criteria andPolicytypeGreaterThan(Short value) {
            addCriterion("PolicyType >", value, "policytype");
            return (Criteria) this;
        }

        public Criteria andPolicytypeGreaterThanOrEqualTo(Short value) {
            addCriterion("PolicyType >=", value, "policytype");
            return (Criteria) this;
        }

        public Criteria andPolicytypeLessThan(Short value) {
            addCriterion("PolicyType <", value, "policytype");
            return (Criteria) this;
        }

        public Criteria andPolicytypeLessThanOrEqualTo(Short value) {
            addCriterion("PolicyType <=", value, "policytype");
            return (Criteria) this;
        }

        public Criteria andPolicytypeIn(List<Short> values) {
            addCriterion("PolicyType in", values, "policytype");
            return (Criteria) this;
        }

        public Criteria andPolicytypeNotIn(List<Short> values) {
            addCriterion("PolicyType not in", values, "policytype");
            return (Criteria) this;
        }

        public Criteria andPolicytypeBetween(Short value1, Short value2) {
            addCriterion("PolicyType between", value1, value2, "policytype");
            return (Criteria) this;
        }

        public Criteria andPolicytypeNotBetween(Short value1, Short value2) {
            addCriterion("PolicyType not between", value1, value2, "policytype");
            return (Criteria) this;
        }

        public Criteria andPolicynumIsNull() {
            addCriterion("PolicyNum is null");
            return (Criteria) this;
        }

        public Criteria andPolicynumIsNotNull() {
            addCriterion("PolicyNum is not null");
            return (Criteria) this;
        }

        public Criteria andPolicynumEqualTo(Short value) {
            addCriterion("PolicyNum =", value, "policynum");
            return (Criteria) this;
        }

        public Criteria andPolicynumNotEqualTo(Short value) {
            addCriterion("PolicyNum <>", value, "policynum");
            return (Criteria) this;
        }

        public Criteria andPolicynumGreaterThan(Short value) {
            addCriterion("PolicyNum >", value, "policynum");
            return (Criteria) this;
        }

        public Criteria andPolicynumGreaterThanOrEqualTo(Short value) {
            addCriterion("PolicyNum >=", value, "policynum");
            return (Criteria) this;
        }

        public Criteria andPolicynumLessThan(Short value) {
            addCriterion("PolicyNum <", value, "policynum");
            return (Criteria) this;
        }

        public Criteria andPolicynumLessThanOrEqualTo(Short value) {
            addCriterion("PolicyNum <=", value, "policynum");
            return (Criteria) this;
        }

        public Criteria andPolicynumIn(List<Short> values) {
            addCriterion("PolicyNum in", values, "policynum");
            return (Criteria) this;
        }

        public Criteria andPolicynumNotIn(List<Short> values) {
            addCriterion("PolicyNum not in", values, "policynum");
            return (Criteria) this;
        }

        public Criteria andPolicynumBetween(Short value1, Short value2) {
            addCriterion("PolicyNum between", value1, value2, "policynum");
            return (Criteria) this;
        }

        public Criteria andPolicynumNotBetween(Short value1, Short value2) {
            addCriterion("PolicyNum not between", value1, value2, "policynum");
            return (Criteria) this;
        }

        public Criteria andYnIsNull() {
            addCriterion("YN is null");
            return (Criteria) this;
        }

        public Criteria andYnIsNotNull() {
            addCriterion("YN is not null");
            return (Criteria) this;
        }

        public Criteria andYnEqualTo(Short value) {
            addCriterion("YN =", value, "yn");
            return (Criteria) this;
        }

        public Criteria andYnNotEqualTo(Short value) {
            addCriterion("YN <>", value, "yn");
            return (Criteria) this;
        }

        public Criteria andYnGreaterThan(Short value) {
            addCriterion("YN >", value, "yn");
            return (Criteria) this;
        }

        public Criteria andYnGreaterThanOrEqualTo(Short value) {
            addCriterion("YN >=", value, "yn");
            return (Criteria) this;
        }

        public Criteria andYnLessThan(Short value) {
            addCriterion("YN <", value, "yn");
            return (Criteria) this;
        }

        public Criteria andYnLessThanOrEqualTo(Short value) {
            addCriterion("YN <=", value, "yn");
            return (Criteria) this;
        }

        public Criteria andYnIn(List<Short> values) {
            addCriterion("YN in", values, "yn");
            return (Criteria) this;
        }

        public Criteria andYnNotIn(List<Short> values) {
            addCriterion("YN not in", values, "yn");
            return (Criteria) this;
        }

        public Criteria andYnBetween(Short value1, Short value2) {
            addCriterion("YN between", value1, value2, "yn");
            return (Criteria) this;
        }

        public Criteria andYnNotBetween(Short value1, Short value2) {
            addCriterion("YN not between", value1, value2, "yn");
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