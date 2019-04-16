package customer.supu.po;

import java.util.ArrayList;
import java.util.List;

public class CoachGoodatExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public CoachGoodatExample() {
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

        public Criteria andCoachidIsNull() {
            addCriterion("coachId is null");
            return (Criteria) this;
        }

        public Criteria andCoachidIsNotNull() {
            addCriterion("coachId is not null");
            return (Criteria) this;
        }

        public Criteria andCoachidEqualTo(Integer value) {
            addCriterion("coachId =", value, "coachid");
            return (Criteria) this;
        }

        public Criteria andCoachidNotEqualTo(Integer value) {
            addCriterion("coachId <>", value, "coachid");
            return (Criteria) this;
        }

        public Criteria andCoachidGreaterThan(Integer value) {
            addCriterion("coachId >", value, "coachid");
            return (Criteria) this;
        }

        public Criteria andCoachidGreaterThanOrEqualTo(Integer value) {
            addCriterion("coachId >=", value, "coachid");
            return (Criteria) this;
        }

        public Criteria andCoachidLessThan(Integer value) {
            addCriterion("coachId <", value, "coachid");
            return (Criteria) this;
        }

        public Criteria andCoachidLessThanOrEqualTo(Integer value) {
            addCriterion("coachId <=", value, "coachid");
            return (Criteria) this;
        }

        public Criteria andCoachidIn(List<Integer> values) {
            addCriterion("coachId in", values, "coachid");
            return (Criteria) this;
        }

        public Criteria andCoachidNotIn(List<Integer> values) {
            addCriterion("coachId not in", values, "coachid");
            return (Criteria) this;
        }

        public Criteria andCoachidBetween(Integer value1, Integer value2) {
            addCriterion("coachId between", value1, value2, "coachid");
            return (Criteria) this;
        }

        public Criteria andCoachidNotBetween(Integer value1, Integer value2) {
            addCriterion("coachId not between", value1, value2, "coachid");
            return (Criteria) this;
        }

        public Criteria andGooatidIsNull() {
            addCriterion("gooatId is null");
            return (Criteria) this;
        }

        public Criteria andGooatidIsNotNull() {
            addCriterion("gooatId is not null");
            return (Criteria) this;
        }

        public Criteria andGooatidEqualTo(Integer value) {
            addCriterion("gooatId =", value, "gooatid");
            return (Criteria) this;
        }

        public Criteria andGooatidNotEqualTo(Integer value) {
            addCriterion("gooatId <>", value, "gooatid");
            return (Criteria) this;
        }

        public Criteria andGooatidGreaterThan(Integer value) {
            addCriterion("gooatId >", value, "gooatid");
            return (Criteria) this;
        }

        public Criteria andGooatidGreaterThanOrEqualTo(Integer value) {
            addCriterion("gooatId >=", value, "gooatid");
            return (Criteria) this;
        }

        public Criteria andGooatidLessThan(Integer value) {
            addCriterion("gooatId <", value, "gooatid");
            return (Criteria) this;
        }

        public Criteria andGooatidLessThanOrEqualTo(Integer value) {
            addCriterion("gooatId <=", value, "gooatid");
            return (Criteria) this;
        }

        public Criteria andGooatidIn(List<Integer> values) {
            addCriterion("gooatId in", values, "gooatid");
            return (Criteria) this;
        }

        public Criteria andGooatidNotIn(List<Integer> values) {
            addCriterion("gooatId not in", values, "gooatid");
            return (Criteria) this;
        }

        public Criteria andGooatidBetween(Integer value1, Integer value2) {
            addCriterion("gooatId between", value1, value2, "gooatid");
            return (Criteria) this;
        }

        public Criteria andGooatidNotBetween(Integer value1, Integer value2) {
            addCriterion("gooatId not between", value1, value2, "gooatid");
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