package customer.supu.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CommentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public CommentExample() {
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

    public void setLimitStart(Integer limitStart) {
        this.limitStart=limitStart;
    }

    public Integer getLimitStart() {
        return limitStart;
    }

    public void setLimitEnd(Integer limitEnd) {
        this.limitEnd=limitEnd;
    }

    public Integer getLimitEnd() {
        return limitEnd;
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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andAppraisercodeIsNull() {
            addCriterion("appraiserCode is null");
            return (Criteria) this;
        }

        public Criteria andAppraisercodeIsNotNull() {
            addCriterion("appraiserCode is not null");
            return (Criteria) this;
        }

        public Criteria andAppraisercodeEqualTo(String value) {
            addCriterion("appraiserCode =", value, "appraisercode");
            return (Criteria) this;
        }

        public Criteria andAppraisercodeNotEqualTo(String value) {
            addCriterion("appraiserCode <>", value, "appraisercode");
            return (Criteria) this;
        }

        public Criteria andAppraisercodeGreaterThan(String value) {
            addCriterion("appraiserCode >", value, "appraisercode");
            return (Criteria) this;
        }

        public Criteria andAppraisercodeGreaterThanOrEqualTo(String value) {
            addCriterion("appraiserCode >=", value, "appraisercode");
            return (Criteria) this;
        }

        public Criteria andAppraisercodeLessThan(String value) {
            addCriterion("appraiserCode <", value, "appraisercode");
            return (Criteria) this;
        }

        public Criteria andAppraisercodeLessThanOrEqualTo(String value) {
            addCriterion("appraiserCode <=", value, "appraisercode");
            return (Criteria) this;
        }

        public Criteria andAppraisercodeLike(String value) {
            addCriterion("appraiserCode like", value, "appraisercode");
            return (Criteria) this;
        }

        public Criteria andAppraisercodeNotLike(String value) {
            addCriterion("appraiserCode not like", value, "appraisercode");
            return (Criteria) this;
        }

        public Criteria andAppraisercodeIn(List<String> values) {
            addCriterion("appraiserCode in", values, "appraisercode");
            return (Criteria) this;
        }

        public Criteria andAppraisercodeNotIn(List<String> values) {
            addCriterion("appraiserCode not in", values, "appraisercode");
            return (Criteria) this;
        }

        public Criteria andAppraisercodeBetween(String value1, String value2) {
            addCriterion("appraiserCode between", value1, value2, "appraisercode");
            return (Criteria) this;
        }

        public Criteria andAppraisercodeNotBetween(String value1, String value2) {
            addCriterion("appraiserCode not between", value1, value2, "appraisercode");
            return (Criteria) this;
        }

        public Criteria andStoresIsNull() {
            addCriterion("stores is null");
            return (Criteria) this;
        }

        public Criteria andStoresIsNotNull() {
            addCriterion("stores is not null");
            return (Criteria) this;
        }

        public Criteria andStoresEqualTo(String value) {
            addCriterion("stores =", value, "stores");
            return (Criteria) this;
        }

        public Criteria andStoresNotEqualTo(String value) {
            addCriterion("stores <>", value, "stores");
            return (Criteria) this;
        }

        public Criteria andStoresGreaterThan(String value) {
            addCriterion("stores >", value, "stores");
            return (Criteria) this;
        }

        public Criteria andStoresGreaterThanOrEqualTo(String value) {
            addCriterion("stores >=", value, "stores");
            return (Criteria) this;
        }

        public Criteria andStoresLessThan(String value) {
            addCriterion("stores <", value, "stores");
            return (Criteria) this;
        }

        public Criteria andStoresLessThanOrEqualTo(String value) {
            addCriterion("stores <=", value, "stores");
            return (Criteria) this;
        }

        public Criteria andStoresLike(String value) {
            addCriterion("stores like", value, "stores");
            return (Criteria) this;
        }

        public Criteria andStoresNotLike(String value) {
            addCriterion("stores not like", value, "stores");
            return (Criteria) this;
        }

        public Criteria andStoresIn(List<String> values) {
            addCriterion("stores in", values, "stores");
            return (Criteria) this;
        }

        public Criteria andStoresNotIn(List<String> values) {
            addCriterion("stores not in", values, "stores");
            return (Criteria) this;
        }

        public Criteria andStoresBetween(String value1, String value2) {
            addCriterion("stores between", value1, value2, "stores");
            return (Criteria) this;
        }

        public Criteria andStoresNotBetween(String value1, String value2) {
            addCriterion("stores not between", value1, value2, "stores");
            return (Criteria) this;
        }

        public Criteria andCoachsIsNull() {
            addCriterion("coachs is null");
            return (Criteria) this;
        }

        public Criteria andCoachsIsNotNull() {
            addCriterion("coachs is not null");
            return (Criteria) this;
        }

        public Criteria andCoachsEqualTo(String value) {
            addCriterion("coachs =", value, "coachs");
            return (Criteria) this;
        }

        public Criteria andCoachsNotEqualTo(String value) {
            addCriterion("coachs <>", value, "coachs");
            return (Criteria) this;
        }

        public Criteria andCoachsGreaterThan(String value) {
            addCriterion("coachs >", value, "coachs");
            return (Criteria) this;
        }

        public Criteria andCoachsGreaterThanOrEqualTo(String value) {
            addCriterion("coachs >=", value, "coachs");
            return (Criteria) this;
        }

        public Criteria andCoachsLessThan(String value) {
            addCriterion("coachs <", value, "coachs");
            return (Criteria) this;
        }

        public Criteria andCoachsLessThanOrEqualTo(String value) {
            addCriterion("coachs <=", value, "coachs");
            return (Criteria) this;
        }

        public Criteria andCoachsLike(String value) {
            addCriterion("coachs like", value, "coachs");
            return (Criteria) this;
        }

        public Criteria andCoachsNotLike(String value) {
            addCriterion("coachs not like", value, "coachs");
            return (Criteria) this;
        }

        public Criteria andCoachsIn(List<String> values) {
            addCriterion("coachs in", values, "coachs");
            return (Criteria) this;
        }

        public Criteria andCoachsNotIn(List<String> values) {
            addCriterion("coachs not in", values, "coachs");
            return (Criteria) this;
        }

        public Criteria andCoachsBetween(String value1, String value2) {
            addCriterion("coachs between", value1, value2, "coachs");
            return (Criteria) this;
        }

        public Criteria andCoachsNotBetween(String value1, String value2) {
            addCriterion("coachs not between", value1, value2, "coachs");
            return (Criteria) this;
        }

        public Criteria andCoursetypeIsNull() {
            addCriterion("courseType is null");
            return (Criteria) this;
        }

        public Criteria andCoursetypeIsNotNull() {
            addCriterion("courseType is not null");
            return (Criteria) this;
        }

        public Criteria andCoursetypeEqualTo(String value) {
            addCriterion("courseType =", value, "coursetype");
            return (Criteria) this;
        }

        public Criteria andCoursetypeNotEqualTo(String value) {
            addCriterion("courseType <>", value, "coursetype");
            return (Criteria) this;
        }

        public Criteria andCoursetypeGreaterThan(String value) {
            addCriterion("courseType >", value, "coursetype");
            return (Criteria) this;
        }

        public Criteria andCoursetypeGreaterThanOrEqualTo(String value) {
            addCriterion("courseType >=", value, "coursetype");
            return (Criteria) this;
        }

        public Criteria andCoursetypeLessThan(String value) {
            addCriterion("courseType <", value, "coursetype");
            return (Criteria) this;
        }

        public Criteria andCoursetypeLessThanOrEqualTo(String value) {
            addCriterion("courseType <=", value, "coursetype");
            return (Criteria) this;
        }

        public Criteria andCoursetypeLike(String value) {
            addCriterion("courseType like", value, "coursetype");
            return (Criteria) this;
        }

        public Criteria andCoursetypeNotLike(String value) {
            addCriterion("courseType not like", value, "coursetype");
            return (Criteria) this;
        }

        public Criteria andCoursetypeIn(List<String> values) {
            addCriterion("courseType in", values, "coursetype");
            return (Criteria) this;
        }

        public Criteria andCoursetypeNotIn(List<String> values) {
            addCriterion("courseType not in", values, "coursetype");
            return (Criteria) this;
        }

        public Criteria andCoursetypeBetween(String value1, String value2) {
            addCriterion("courseType between", value1, value2, "coursetype");
            return (Criteria) this;
        }

        public Criteria andCoursetypeNotBetween(String value1, String value2) {
            addCriterion("courseType not between", value1, value2, "coursetype");
            return (Criteria) this;
        }

        public Criteria andStartlevelIsNull() {
            addCriterion("startlevel is null");
            return (Criteria) this;
        }

        public Criteria andStartlevelIsNotNull() {
            addCriterion("startlevel is not null");
            return (Criteria) this;
        }

        public Criteria andStartlevelEqualTo(Integer value) {
            addCriterion("startlevel =", value, "startlevel");
            return (Criteria) this;
        }

        public Criteria andStartlevelNotEqualTo(Integer value) {
            addCriterion("startlevel <>", value, "startlevel");
            return (Criteria) this;
        }

        public Criteria andStartlevelGreaterThan(Integer value) {
            addCriterion("startlevel >", value, "startlevel");
            return (Criteria) this;
        }

        public Criteria andStartlevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("startlevel >=", value, "startlevel");
            return (Criteria) this;
        }

        public Criteria andStartlevelLessThan(Integer value) {
            addCriterion("startlevel <", value, "startlevel");
            return (Criteria) this;
        }

        public Criteria andStartlevelLessThanOrEqualTo(Integer value) {
            addCriterion("startlevel <=", value, "startlevel");
            return (Criteria) this;
        }

        public Criteria andStartlevelIn(List<Integer> values) {
            addCriterion("startlevel in", values, "startlevel");
            return (Criteria) this;
        }

        public Criteria andStartlevelNotIn(List<Integer> values) {
            addCriterion("startlevel not in", values, "startlevel");
            return (Criteria) this;
        }

        public Criteria andStartlevelBetween(Integer value1, Integer value2) {
            addCriterion("startlevel between", value1, value2, "startlevel");
            return (Criteria) this;
        }

        public Criteria andStartlevelNotBetween(Integer value1, Integer value2) {
            addCriterion("startlevel not between", value1, value2, "startlevel");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andAddtimeIsNull() {
            addCriterion("addTime is null");
            return (Criteria) this;
        }

        public Criteria andAddtimeIsNotNull() {
            addCriterion("addTime is not null");
            return (Criteria) this;
        }

        public Criteria andAddtimeEqualTo(Date value) {
            addCriterion("addTime =", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeNotEqualTo(Date value) {
            addCriterion("addTime <>", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeGreaterThan(Date value) {
            addCriterion("addTime >", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("addTime >=", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeLessThan(Date value) {
            addCriterion("addTime <", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeLessThanOrEqualTo(Date value) {
            addCriterion("addTime <=", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeIn(List<Date> values) {
            addCriterion("addTime in", values, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeNotIn(List<Date> values) {
            addCriterion("addTime not in", values, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeBetween(Date value1, Date value2) {
            addCriterion("addTime between", value1, value2, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeNotBetween(Date value1, Date value2) {
            addCriterion("addTime not between", value1, value2, "addtime");
            return (Criteria) this;
        }

        public Criteria andAudittimeIsNull() {
            addCriterion("auditTime is null");
            return (Criteria) this;
        }

        public Criteria andAudittimeIsNotNull() {
            addCriterion("auditTime is not null");
            return (Criteria) this;
        }

        public Criteria andAudittimeEqualTo(Date value) {
            addCriterion("auditTime =", value, "audittime");
            return (Criteria) this;
        }

        public Criteria andAudittimeNotEqualTo(Date value) {
            addCriterion("auditTime <>", value, "audittime");
            return (Criteria) this;
        }

        public Criteria andAudittimeGreaterThan(Date value) {
            addCriterion("auditTime >", value, "audittime");
            return (Criteria) this;
        }

        public Criteria andAudittimeGreaterThanOrEqualTo(Date value) {
            addCriterion("auditTime >=", value, "audittime");
            return (Criteria) this;
        }

        public Criteria andAudittimeLessThan(Date value) {
            addCriterion("auditTime <", value, "audittime");
            return (Criteria) this;
        }

        public Criteria andAudittimeLessThanOrEqualTo(Date value) {
            addCriterion("auditTime <=", value, "audittime");
            return (Criteria) this;
        }

        public Criteria andAudittimeIn(List<Date> values) {
            addCriterion("auditTime in", values, "audittime");
            return (Criteria) this;
        }

        public Criteria andAudittimeNotIn(List<Date> values) {
            addCriterion("auditTime not in", values, "audittime");
            return (Criteria) this;
        }

        public Criteria andAudittimeBetween(Date value1, Date value2) {
            addCriterion("auditTime between", value1, value2, "audittime");
            return (Criteria) this;
        }

        public Criteria andAudittimeNotBetween(Date value1, Date value2) {
            addCriterion("auditTime not between", value1, value2, "audittime");
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