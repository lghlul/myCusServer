package customer.supu.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CoursePriCoachExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public CoursePriCoachExample() {
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

        public Criteria andCoursetypeIsNull() {
            addCriterion("courseType is null");
            return (Criteria) this;
        }

        public Criteria andCoursetypeIsNotNull() {
            addCriterion("courseType is not null");
            return (Criteria) this;
        }

        public Criteria andCoursetypeEqualTo(Integer value) {
            addCriterion("courseType =", value, "coursetype");
            return (Criteria) this;
        }

        public Criteria andCoursetypeNotEqualTo(Integer value) {
            addCriterion("courseType <>", value, "coursetype");
            return (Criteria) this;
        }

        public Criteria andCoursetypeGreaterThan(Integer value) {
            addCriterion("courseType >", value, "coursetype");
            return (Criteria) this;
        }

        public Criteria andCoursetypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("courseType >=", value, "coursetype");
            return (Criteria) this;
        }

        public Criteria andCoursetypeLessThan(Integer value) {
            addCriterion("courseType <", value, "coursetype");
            return (Criteria) this;
        }

        public Criteria andCoursetypeLessThanOrEqualTo(Integer value) {
            addCriterion("courseType <=", value, "coursetype");
            return (Criteria) this;
        }

        public Criteria andCoursetypeIn(List<Integer> values) {
            addCriterion("courseType in", values, "coursetype");
            return (Criteria) this;
        }

        public Criteria andCoursetypeNotIn(List<Integer> values) {
            addCriterion("courseType not in", values, "coursetype");
            return (Criteria) this;
        }

        public Criteria andCoursetypeBetween(Integer value1, Integer value2) {
            addCriterion("courseType between", value1, value2, "coursetype");
            return (Criteria) this;
        }

        public Criteria andCoursetypeNotBetween(Integer value1, Integer value2) {
            addCriterion("courseType not between", value1, value2, "coursetype");
            return (Criteria) this;
        }

        public Criteria andFitdemandIsNull() {
            addCriterion("fitDemand is null");
            return (Criteria) this;
        }

        public Criteria andFitdemandIsNotNull() {
            addCriterion("fitDemand is not null");
            return (Criteria) this;
        }

        public Criteria andFitdemandEqualTo(String value) {
            addCriterion("fitDemand =", value, "fitdemand");
            return (Criteria) this;
        }

        public Criteria andFitdemandNotEqualTo(String value) {
            addCriterion("fitDemand <>", value, "fitdemand");
            return (Criteria) this;
        }

        public Criteria andFitdemandGreaterThan(String value) {
            addCriterion("fitDemand >", value, "fitdemand");
            return (Criteria) this;
        }

        public Criteria andFitdemandGreaterThanOrEqualTo(String value) {
            addCriterion("fitDemand >=", value, "fitdemand");
            return (Criteria) this;
        }

        public Criteria andFitdemandLessThan(String value) {
            addCriterion("fitDemand <", value, "fitdemand");
            return (Criteria) this;
        }

        public Criteria andFitdemandLessThanOrEqualTo(String value) {
            addCriterion("fitDemand <=", value, "fitdemand");
            return (Criteria) this;
        }

        public Criteria andFitdemandLike(String value) {
            addCriterion("fitDemand like", value, "fitdemand");
            return (Criteria) this;
        }

        public Criteria andFitdemandNotLike(String value) {
            addCriterion("fitDemand not like", value, "fitdemand");
            return (Criteria) this;
        }

        public Criteria andFitdemandIn(List<String> values) {
            addCriterion("fitDemand in", values, "fitdemand");
            return (Criteria) this;
        }

        public Criteria andFitdemandNotIn(List<String> values) {
            addCriterion("fitDemand not in", values, "fitdemand");
            return (Criteria) this;
        }

        public Criteria andFitdemandBetween(String value1, String value2) {
            addCriterion("fitDemand between", value1, value2, "fitdemand");
            return (Criteria) this;
        }

        public Criteria andFitdemandNotBetween(String value1, String value2) {
            addCriterion("fitDemand not between", value1, value2, "fitdemand");
            return (Criteria) this;
        }

        public Criteria andCoursenameIsNull() {
            addCriterion("courseName is null");
            return (Criteria) this;
        }

        public Criteria andCoursenameIsNotNull() {
            addCriterion("courseName is not null");
            return (Criteria) this;
        }

        public Criteria andCoursenameEqualTo(String value) {
            addCriterion("courseName =", value, "coursename");
            return (Criteria) this;
        }

        public Criteria andCoursenameNotEqualTo(String value) {
            addCriterion("courseName <>", value, "coursename");
            return (Criteria) this;
        }

        public Criteria andCoursenameGreaterThan(String value) {
            addCriterion("courseName >", value, "coursename");
            return (Criteria) this;
        }

        public Criteria andCoursenameGreaterThanOrEqualTo(String value) {
            addCriterion("courseName >=", value, "coursename");
            return (Criteria) this;
        }

        public Criteria andCoursenameLessThan(String value) {
            addCriterion("courseName <", value, "coursename");
            return (Criteria) this;
        }

        public Criteria andCoursenameLessThanOrEqualTo(String value) {
            addCriterion("courseName <=", value, "coursename");
            return (Criteria) this;
        }

        public Criteria andCoursenameLike(String value) {
            addCriterion("courseName like", value, "coursename");
            return (Criteria) this;
        }

        public Criteria andCoursenameNotLike(String value) {
            addCriterion("courseName not like", value, "coursename");
            return (Criteria) this;
        }

        public Criteria andCoursenameIn(List<String> values) {
            addCriterion("courseName in", values, "coursename");
            return (Criteria) this;
        }

        public Criteria andCoursenameNotIn(List<String> values) {
            addCriterion("courseName not in", values, "coursename");
            return (Criteria) this;
        }

        public Criteria andCoursenameBetween(String value1, String value2) {
            addCriterion("courseName between", value1, value2, "coursename");
            return (Criteria) this;
        }

        public Criteria andCoursenameNotBetween(String value1, String value2) {
            addCriterion("courseName not between", value1, value2, "coursename");
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

        public Criteria andCourseamountIsNull() {
            addCriterion("courseAmount is null");
            return (Criteria) this;
        }

        public Criteria andCourseamountIsNotNull() {
            addCriterion("courseAmount is not null");
            return (Criteria) this;
        }

        public Criteria andCourseamountEqualTo(Double value) {
            addCriterion("courseAmount =", value, "courseamount");
            return (Criteria) this;
        }

        public Criteria andCourseamountNotEqualTo(Double value) {
            addCriterion("courseAmount <>", value, "courseamount");
            return (Criteria) this;
        }

        public Criteria andCourseamountGreaterThan(Double value) {
            addCriterion("courseAmount >", value, "courseamount");
            return (Criteria) this;
        }

        public Criteria andCourseamountGreaterThanOrEqualTo(Double value) {
            addCriterion("courseAmount >=", value, "courseamount");
            return (Criteria) this;
        }

        public Criteria andCourseamountLessThan(Double value) {
            addCriterion("courseAmount <", value, "courseamount");
            return (Criteria) this;
        }

        public Criteria andCourseamountLessThanOrEqualTo(Double value) {
            addCriterion("courseAmount <=", value, "courseamount");
            return (Criteria) this;
        }

        public Criteria andCourseamountIn(List<Double> values) {
            addCriterion("courseAmount in", values, "courseamount");
            return (Criteria) this;
        }

        public Criteria andCourseamountNotIn(List<Double> values) {
            addCriterion("courseAmount not in", values, "courseamount");
            return (Criteria) this;
        }

        public Criteria andCourseamountBetween(Double value1, Double value2) {
            addCriterion("courseAmount between", value1, value2, "courseamount");
            return (Criteria) this;
        }

        public Criteria andCourseamountNotBetween(Double value1, Double value2) {
            addCriterion("courseAmount not between", value1, value2, "courseamount");
            return (Criteria) this;
        }

        public Criteria andTotalhoursIsNull() {
            addCriterion("totalHours is null");
            return (Criteria) this;
        }

        public Criteria andTotalhoursIsNotNull() {
            addCriterion("totalHours is not null");
            return (Criteria) this;
        }

        public Criteria andTotalhoursEqualTo(Double value) {
            addCriterion("totalHours =", value, "totalhours");
            return (Criteria) this;
        }

        public Criteria andTotalhoursNotEqualTo(Double value) {
            addCriterion("totalHours <>", value, "totalhours");
            return (Criteria) this;
        }

        public Criteria andTotalhoursGreaterThan(Double value) {
            addCriterion("totalHours >", value, "totalhours");
            return (Criteria) this;
        }

        public Criteria andTotalhoursGreaterThanOrEqualTo(Double value) {
            addCriterion("totalHours >=", value, "totalhours");
            return (Criteria) this;
        }

        public Criteria andTotalhoursLessThan(Double value) {
            addCriterion("totalHours <", value, "totalhours");
            return (Criteria) this;
        }

        public Criteria andTotalhoursLessThanOrEqualTo(Double value) {
            addCriterion("totalHours <=", value, "totalhours");
            return (Criteria) this;
        }

        public Criteria andTotalhoursIn(List<Double> values) {
            addCriterion("totalHours in", values, "totalhours");
            return (Criteria) this;
        }

        public Criteria andTotalhoursNotIn(List<Double> values) {
            addCriterion("totalHours not in", values, "totalhours");
            return (Criteria) this;
        }

        public Criteria andTotalhoursBetween(Double value1, Double value2) {
            addCriterion("totalHours between", value1, value2, "totalhours");
            return (Criteria) this;
        }

        public Criteria andTotalhoursNotBetween(Double value1, Double value2) {
            addCriterion("totalHours not between", value1, value2, "totalhours");
            return (Criteria) this;
        }

        public Criteria andCourseimgIsNull() {
            addCriterion("courseImg is null");
            return (Criteria) this;
        }

        public Criteria andCourseimgIsNotNull() {
            addCriterion("courseImg is not null");
            return (Criteria) this;
        }

        public Criteria andCourseimgEqualTo(String value) {
            addCriterion("courseImg =", value, "courseimg");
            return (Criteria) this;
        }

        public Criteria andCourseimgNotEqualTo(String value) {
            addCriterion("courseImg <>", value, "courseimg");
            return (Criteria) this;
        }

        public Criteria andCourseimgGreaterThan(String value) {
            addCriterion("courseImg >", value, "courseimg");
            return (Criteria) this;
        }

        public Criteria andCourseimgGreaterThanOrEqualTo(String value) {
            addCriterion("courseImg >=", value, "courseimg");
            return (Criteria) this;
        }

        public Criteria andCourseimgLessThan(String value) {
            addCriterion("courseImg <", value, "courseimg");
            return (Criteria) this;
        }

        public Criteria andCourseimgLessThanOrEqualTo(String value) {
            addCriterion("courseImg <=", value, "courseimg");
            return (Criteria) this;
        }

        public Criteria andCourseimgLike(String value) {
            addCriterion("courseImg like", value, "courseimg");
            return (Criteria) this;
        }

        public Criteria andCourseimgNotLike(String value) {
            addCriterion("courseImg not like", value, "courseimg");
            return (Criteria) this;
        }

        public Criteria andCourseimgIn(List<String> values) {
            addCriterion("courseImg in", values, "courseimg");
            return (Criteria) this;
        }

        public Criteria andCourseimgNotIn(List<String> values) {
            addCriterion("courseImg not in", values, "courseimg");
            return (Criteria) this;
        }

        public Criteria andCourseimgBetween(String value1, String value2) {
            addCriterion("courseImg between", value1, value2, "courseimg");
            return (Criteria) this;
        }

        public Criteria andCourseimgNotBetween(String value1, String value2) {
            addCriterion("courseImg not between", value1, value2, "courseimg");
            return (Criteria) this;
        }

        public Criteria andCoursetitleIsNull() {
            addCriterion("courseTitle is null");
            return (Criteria) this;
        }

        public Criteria andCoursetitleIsNotNull() {
            addCriterion("courseTitle is not null");
            return (Criteria) this;
        }

        public Criteria andCoursetitleEqualTo(String value) {
            addCriterion("courseTitle =", value, "coursetitle");
            return (Criteria) this;
        }

        public Criteria andCoursetitleNotEqualTo(String value) {
            addCriterion("courseTitle <>", value, "coursetitle");
            return (Criteria) this;
        }

        public Criteria andCoursetitleGreaterThan(String value) {
            addCriterion("courseTitle >", value, "coursetitle");
            return (Criteria) this;
        }

        public Criteria andCoursetitleGreaterThanOrEqualTo(String value) {
            addCriterion("courseTitle >=", value, "coursetitle");
            return (Criteria) this;
        }

        public Criteria andCoursetitleLessThan(String value) {
            addCriterion("courseTitle <", value, "coursetitle");
            return (Criteria) this;
        }

        public Criteria andCoursetitleLessThanOrEqualTo(String value) {
            addCriterion("courseTitle <=", value, "coursetitle");
            return (Criteria) this;
        }

        public Criteria andCoursetitleLike(String value) {
            addCriterion("courseTitle like", value, "coursetitle");
            return (Criteria) this;
        }

        public Criteria andCoursetitleNotLike(String value) {
            addCriterion("courseTitle not like", value, "coursetitle");
            return (Criteria) this;
        }

        public Criteria andCoursetitleIn(List<String> values) {
            addCriterion("courseTitle in", values, "coursetitle");
            return (Criteria) this;
        }

        public Criteria andCoursetitleNotIn(List<String> values) {
            addCriterion("courseTitle not in", values, "coursetitle");
            return (Criteria) this;
        }

        public Criteria andCoursetitleBetween(String value1, String value2) {
            addCriterion("courseTitle between", value1, value2, "coursetitle");
            return (Criteria) this;
        }

        public Criteria andCoursetitleNotBetween(String value1, String value2) {
            addCriterion("courseTitle not between", value1, value2, "coursetitle");
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

        public Criteria andRealsetimeIsNull() {
            addCriterion("realseTime is null");
            return (Criteria) this;
        }

        public Criteria andRealsetimeIsNotNull() {
            addCriterion("realseTime is not null");
            return (Criteria) this;
        }

        public Criteria andRealsetimeEqualTo(Date value) {
            addCriterion("realseTime =", value, "realsetime");
            return (Criteria) this;
        }

        public Criteria andRealsetimeNotEqualTo(Date value) {
            addCriterion("realseTime <>", value, "realsetime");
            return (Criteria) this;
        }

        public Criteria andRealsetimeGreaterThan(Date value) {
            addCriterion("realseTime >", value, "realsetime");
            return (Criteria) this;
        }

        public Criteria andRealsetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("realseTime >=", value, "realsetime");
            return (Criteria) this;
        }

        public Criteria andRealsetimeLessThan(Date value) {
            addCriterion("realseTime <", value, "realsetime");
            return (Criteria) this;
        }

        public Criteria andRealsetimeLessThanOrEqualTo(Date value) {
            addCriterion("realseTime <=", value, "realsetime");
            return (Criteria) this;
        }

        public Criteria andRealsetimeIn(List<Date> values) {
            addCriterion("realseTime in", values, "realsetime");
            return (Criteria) this;
        }

        public Criteria andRealsetimeNotIn(List<Date> values) {
            addCriterion("realseTime not in", values, "realsetime");
            return (Criteria) this;
        }

        public Criteria andRealsetimeBetween(Date value1, Date value2) {
            addCriterion("realseTime between", value1, value2, "realsetime");
            return (Criteria) this;
        }

        public Criteria andRealsetimeNotBetween(Date value1, Date value2) {
            addCriterion("realseTime not between", value1, value2, "realsetime");
            return (Criteria) this;
        }

        public Criteria andRealsepeopleIsNull() {
            addCriterion("realsePeople is null");
            return (Criteria) this;
        }

        public Criteria andRealsepeopleIsNotNull() {
            addCriterion("realsePeople is not null");
            return (Criteria) this;
        }

        public Criteria andRealsepeopleEqualTo(String value) {
            addCriterion("realsePeople =", value, "realsepeople");
            return (Criteria) this;
        }

        public Criteria andRealsepeopleNotEqualTo(String value) {
            addCriterion("realsePeople <>", value, "realsepeople");
            return (Criteria) this;
        }

        public Criteria andRealsepeopleGreaterThan(String value) {
            addCriterion("realsePeople >", value, "realsepeople");
            return (Criteria) this;
        }

        public Criteria andRealsepeopleGreaterThanOrEqualTo(String value) {
            addCriterion("realsePeople >=", value, "realsepeople");
            return (Criteria) this;
        }

        public Criteria andRealsepeopleLessThan(String value) {
            addCriterion("realsePeople <", value, "realsepeople");
            return (Criteria) this;
        }

        public Criteria andRealsepeopleLessThanOrEqualTo(String value) {
            addCriterion("realsePeople <=", value, "realsepeople");
            return (Criteria) this;
        }

        public Criteria andRealsepeopleLike(String value) {
            addCriterion("realsePeople like", value, "realsepeople");
            return (Criteria) this;
        }

        public Criteria andRealsepeopleNotLike(String value) {
            addCriterion("realsePeople not like", value, "realsepeople");
            return (Criteria) this;
        }

        public Criteria andRealsepeopleIn(List<String> values) {
            addCriterion("realsePeople in", values, "realsepeople");
            return (Criteria) this;
        }

        public Criteria andRealsepeopleNotIn(List<String> values) {
            addCriterion("realsePeople not in", values, "realsepeople");
            return (Criteria) this;
        }

        public Criteria andRealsepeopleBetween(String value1, String value2) {
            addCriterion("realsePeople between", value1, value2, "realsepeople");
            return (Criteria) this;
        }

        public Criteria andRealsepeopleNotBetween(String value1, String value2) {
            addCriterion("realsePeople not between", value1, value2, "realsepeople");
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

        public Criteria andAddpeopleIsNull() {
            addCriterion("addPeople is null");
            return (Criteria) this;
        }

        public Criteria andAddpeopleIsNotNull() {
            addCriterion("addPeople is not null");
            return (Criteria) this;
        }

        public Criteria andAddpeopleEqualTo(String value) {
            addCriterion("addPeople =", value, "addpeople");
            return (Criteria) this;
        }

        public Criteria andAddpeopleNotEqualTo(String value) {
            addCriterion("addPeople <>", value, "addpeople");
            return (Criteria) this;
        }

        public Criteria andAddpeopleGreaterThan(String value) {
            addCriterion("addPeople >", value, "addpeople");
            return (Criteria) this;
        }

        public Criteria andAddpeopleGreaterThanOrEqualTo(String value) {
            addCriterion("addPeople >=", value, "addpeople");
            return (Criteria) this;
        }

        public Criteria andAddpeopleLessThan(String value) {
            addCriterion("addPeople <", value, "addpeople");
            return (Criteria) this;
        }

        public Criteria andAddpeopleLessThanOrEqualTo(String value) {
            addCriterion("addPeople <=", value, "addpeople");
            return (Criteria) this;
        }

        public Criteria andAddpeopleLike(String value) {
            addCriterion("addPeople like", value, "addpeople");
            return (Criteria) this;
        }

        public Criteria andAddpeopleNotLike(String value) {
            addCriterion("addPeople not like", value, "addpeople");
            return (Criteria) this;
        }

        public Criteria andAddpeopleIn(List<String> values) {
            addCriterion("addPeople in", values, "addpeople");
            return (Criteria) this;
        }

        public Criteria andAddpeopleNotIn(List<String> values) {
            addCriterion("addPeople not in", values, "addpeople");
            return (Criteria) this;
        }

        public Criteria andAddpeopleBetween(String value1, String value2) {
            addCriterion("addPeople between", value1, value2, "addpeople");
            return (Criteria) this;
        }

        public Criteria andAddpeopleNotBetween(String value1, String value2) {
            addCriterion("addPeople not between", value1, value2, "addpeople");
            return (Criteria) this;
        }

        public Criteria andIsexperienceIsNull() {
            addCriterion("isExperience is null");
            return (Criteria) this;
        }

        public Criteria andIsexperienceIsNotNull() {
            addCriterion("isExperience is not null");
            return (Criteria) this;
        }

        public Criteria andIsexperienceEqualTo(Integer value) {
            addCriterion("isExperience =", value, "isexperience");
            return (Criteria) this;
        }

        public Criteria andIsexperienceNotEqualTo(Integer value) {
            addCriterion("isExperience <>", value, "isexperience");
            return (Criteria) this;
        }

        public Criteria andIsexperienceGreaterThan(Integer value) {
            addCriterion("isExperience >", value, "isexperience");
            return (Criteria) this;
        }

        public Criteria andIsexperienceGreaterThanOrEqualTo(Integer value) {
            addCriterion("isExperience >=", value, "isexperience");
            return (Criteria) this;
        }

        public Criteria andIsexperienceLessThan(Integer value) {
            addCriterion("isExperience <", value, "isexperience");
            return (Criteria) this;
        }

        public Criteria andIsexperienceLessThanOrEqualTo(Integer value) {
            addCriterion("isExperience <=", value, "isexperience");
            return (Criteria) this;
        }

        public Criteria andIsexperienceIn(List<Integer> values) {
            addCriterion("isExperience in", values, "isexperience");
            return (Criteria) this;
        }

        public Criteria andIsexperienceNotIn(List<Integer> values) {
            addCriterion("isExperience not in", values, "isexperience");
            return (Criteria) this;
        }

        public Criteria andIsexperienceBetween(Integer value1, Integer value2) {
            addCriterion("isExperience between", value1, value2, "isexperience");
            return (Criteria) this;
        }

        public Criteria andIsexperienceNotBetween(Integer value1, Integer value2) {
            addCriterion("isExperience not between", value1, value2, "isexperience");
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