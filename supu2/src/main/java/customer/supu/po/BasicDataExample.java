package customer.supu.po;

import java.util.ArrayList;
import java.util.List;

public class BasicDataExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public BasicDataExample() {
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

        public Criteria andBasicdataidIsNull() {
            addCriterion("BasicDataId is null");
            return (Criteria) this;
        }

        public Criteria andBasicdataidIsNotNull() {
            addCriterion("BasicDataId is not null");
            return (Criteria) this;
        }

        public Criteria andBasicdataidEqualTo(Integer value) {
            addCriterion("BasicDataId =", value, "basicdataid");
            return (Criteria) this;
        }

        public Criteria andBasicdataidNotEqualTo(Integer value) {
            addCriterion("BasicDataId <>", value, "basicdataid");
            return (Criteria) this;
        }

        public Criteria andBasicdataidGreaterThan(Integer value) {
            addCriterion("BasicDataId >", value, "basicdataid");
            return (Criteria) this;
        }

        public Criteria andBasicdataidGreaterThanOrEqualTo(Integer value) {
            addCriterion("BasicDataId >=", value, "basicdataid");
            return (Criteria) this;
        }

        public Criteria andBasicdataidLessThan(Integer value) {
            addCriterion("BasicDataId <", value, "basicdataid");
            return (Criteria) this;
        }

        public Criteria andBasicdataidLessThanOrEqualTo(Integer value) {
            addCriterion("BasicDataId <=", value, "basicdataid");
            return (Criteria) this;
        }

        public Criteria andBasicdataidIn(List<Integer> values) {
            addCriterion("BasicDataId in", values, "basicdataid");
            return (Criteria) this;
        }

        public Criteria andBasicdataidNotIn(List<Integer> values) {
            addCriterion("BasicDataId not in", values, "basicdataid");
            return (Criteria) this;
        }

        public Criteria andBasicdataidBetween(Integer value1, Integer value2) {
            addCriterion("BasicDataId between", value1, value2, "basicdataid");
            return (Criteria) this;
        }

        public Criteria andBasicdataidNotBetween(Integer value1, Integer value2) {
            addCriterion("BasicDataId not between", value1, value2, "basicdataid");
            return (Criteria) this;
        }

        public Criteria andBasictypeIsNull() {
            addCriterion("BasicType is null");
            return (Criteria) this;
        }

        public Criteria andBasictypeIsNotNull() {
            addCriterion("BasicType is not null");
            return (Criteria) this;
        }

        public Criteria andBasictypeEqualTo(String value) {
            addCriterion("BasicType =", value, "basictype");
            return (Criteria) this;
        }

        public Criteria andBasictypeNotEqualTo(String value) {
            addCriterion("BasicType <>", value, "basictype");
            return (Criteria) this;
        }

        public Criteria andBasictypeGreaterThan(String value) {
            addCriterion("BasicType >", value, "basictype");
            return (Criteria) this;
        }

        public Criteria andBasictypeGreaterThanOrEqualTo(String value) {
            addCriterion("BasicType >=", value, "basictype");
            return (Criteria) this;
        }

        public Criteria andBasictypeLessThan(String value) {
            addCriterion("BasicType <", value, "basictype");
            return (Criteria) this;
        }

        public Criteria andBasictypeLessThanOrEqualTo(String value) {
            addCriterion("BasicType <=", value, "basictype");
            return (Criteria) this;
        }

        public Criteria andBasictypeLike(String value) {
            addCriterion("BasicType like", value, "basictype");
            return (Criteria) this;
        }

        public Criteria andBasictypeNotLike(String value) {
            addCriterion("BasicType not like", value, "basictype");
            return (Criteria) this;
        }

        public Criteria andBasictypeIn(List<String> values) {
            addCriterion("BasicType in", values, "basictype");
            return (Criteria) this;
        }

        public Criteria andBasictypeNotIn(List<String> values) {
            addCriterion("BasicType not in", values, "basictype");
            return (Criteria) this;
        }

        public Criteria andBasictypeBetween(String value1, String value2) {
            addCriterion("BasicType between", value1, value2, "basictype");
            return (Criteria) this;
        }

        public Criteria andBasictypeNotBetween(String value1, String value2) {
            addCriterion("BasicType not between", value1, value2, "basictype");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andBasicvalueIsNull() {
            addCriterion("BasicValue is null");
            return (Criteria) this;
        }

        public Criteria andBasicvalueIsNotNull() {
            addCriterion("BasicValue is not null");
            return (Criteria) this;
        }

        public Criteria andBasicvalueEqualTo(String value) {
            addCriterion("BasicValue =", value, "basicvalue");
            return (Criteria) this;
        }

        public Criteria andBasicvalueNotEqualTo(String value) {
            addCriterion("BasicValue <>", value, "basicvalue");
            return (Criteria) this;
        }

        public Criteria andBasicvalueGreaterThan(String value) {
            addCriterion("BasicValue >", value, "basicvalue");
            return (Criteria) this;
        }

        public Criteria andBasicvalueGreaterThanOrEqualTo(String value) {
            addCriterion("BasicValue >=", value, "basicvalue");
            return (Criteria) this;
        }

        public Criteria andBasicvalueLessThan(String value) {
            addCriterion("BasicValue <", value, "basicvalue");
            return (Criteria) this;
        }

        public Criteria andBasicvalueLessThanOrEqualTo(String value) {
            addCriterion("BasicValue <=", value, "basicvalue");
            return (Criteria) this;
        }

        public Criteria andBasicvalueLike(String value) {
            addCriterion("BasicValue like", value, "basicvalue");
            return (Criteria) this;
        }

        public Criteria andBasicvalueNotLike(String value) {
            addCriterion("BasicValue not like", value, "basicvalue");
            return (Criteria) this;
        }

        public Criteria andBasicvalueIn(List<String> values) {
            addCriterion("BasicValue in", values, "basicvalue");
            return (Criteria) this;
        }

        public Criteria andBasicvalueNotIn(List<String> values) {
            addCriterion("BasicValue not in", values, "basicvalue");
            return (Criteria) this;
        }

        public Criteria andBasicvalueBetween(String value1, String value2) {
            addCriterion("BasicValue between", value1, value2, "basicvalue");
            return (Criteria) this;
        }

        public Criteria andBasicvalueNotBetween(String value1, String value2) {
            addCriterion("BasicValue not between", value1, value2, "basicvalue");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andFlagIsNull() {
            addCriterion("flag is null");
            return (Criteria) this;
        }

        public Criteria andFlagIsNotNull() {
            addCriterion("flag is not null");
            return (Criteria) this;
        }

        public Criteria andFlagEqualTo(Integer value) {
            addCriterion("flag =", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotEqualTo(Integer value) {
            addCriterion("flag <>", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagGreaterThan(Integer value) {
            addCriterion("flag >", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("flag >=", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLessThan(Integer value) {
            addCriterion("flag <", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLessThanOrEqualTo(Integer value) {
            addCriterion("flag <=", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagIn(List<Integer> values) {
            addCriterion("flag in", values, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotIn(List<Integer> values) {
            addCriterion("flag not in", values, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagBetween(Integer value1, Integer value2) {
            addCriterion("flag between", value1, value2, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("flag not between", value1, value2, "flag");
            return (Criteria) this;
        }

        public Criteria andVorderIsNull() {
            addCriterion("vorder is null");
            return (Criteria) this;
        }

        public Criteria andVorderIsNotNull() {
            addCriterion("vorder is not null");
            return (Criteria) this;
        }

        public Criteria andVorderEqualTo(Integer value) {
            addCriterion("vorder =", value, "vorder");
            return (Criteria) this;
        }

        public Criteria andVorderNotEqualTo(Integer value) {
            addCriterion("vorder <>", value, "vorder");
            return (Criteria) this;
        }

        public Criteria andVorderGreaterThan(Integer value) {
            addCriterion("vorder >", value, "vorder");
            return (Criteria) this;
        }

        public Criteria andVorderGreaterThanOrEqualTo(Integer value) {
            addCriterion("vorder >=", value, "vorder");
            return (Criteria) this;
        }

        public Criteria andVorderLessThan(Integer value) {
            addCriterion("vorder <", value, "vorder");
            return (Criteria) this;
        }

        public Criteria andVorderLessThanOrEqualTo(Integer value) {
            addCriterion("vorder <=", value, "vorder");
            return (Criteria) this;
        }

        public Criteria andVorderIn(List<Integer> values) {
            addCriterion("vorder in", values, "vorder");
            return (Criteria) this;
        }

        public Criteria andVorderNotIn(List<Integer> values) {
            addCriterion("vorder not in", values, "vorder");
            return (Criteria) this;
        }

        public Criteria andVorderBetween(Integer value1, Integer value2) {
            addCriterion("vorder between", value1, value2, "vorder");
            return (Criteria) this;
        }

        public Criteria andVorderNotBetween(Integer value1, Integer value2) {
            addCriterion("vorder not between", value1, value2, "vorder");
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