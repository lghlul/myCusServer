package customer.supu.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class CourseExcGroupExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public CourseExcGroupExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andPeopleIsNull() {
            addCriterion("people is null");
            return (Criteria) this;
        }

        public Criteria andPeopleIsNotNull() {
            addCriterion("people is not null");
            return (Criteria) this;
        }

        public Criteria andPeopleEqualTo(Integer value) {
            addCriterion("people =", value, "people");
            return (Criteria) this;
        }

        public Criteria andPeopleNotEqualTo(Integer value) {
            addCriterion("people <>", value, "people");
            return (Criteria) this;
        }

        public Criteria andPeopleGreaterThan(Integer value) {
            addCriterion("people >", value, "people");
            return (Criteria) this;
        }

        public Criteria andPeopleGreaterThanOrEqualTo(Integer value) {
            addCriterion("people >=", value, "people");
            return (Criteria) this;
        }

        public Criteria andPeopleLessThan(Integer value) {
            addCriterion("people <", value, "people");
            return (Criteria) this;
        }

        public Criteria andPeopleLessThanOrEqualTo(Integer value) {
            addCriterion("people <=", value, "people");
            return (Criteria) this;
        }

        public Criteria andPeopleIn(List<Integer> values) {
            addCriterion("people in", values, "people");
            return (Criteria) this;
        }

        public Criteria andPeopleNotIn(List<Integer> values) {
            addCriterion("people not in", values, "people");
            return (Criteria) this;
        }

        public Criteria andPeopleBetween(Integer value1, Integer value2) {
            addCriterion("people between", value1, value2, "people");
            return (Criteria) this;
        }

        public Criteria andPeopleNotBetween(Integer value1, Integer value2) {
            addCriterion("people not between", value1, value2, "people");
            return (Criteria) this;
        }

        public Criteria andMaxpeopleIsNull() {
            addCriterion("maxPeople is null");
            return (Criteria) this;
        }

        public Criteria andMaxpeopleIsNotNull() {
            addCriterion("maxPeople is not null");
            return (Criteria) this;
        }

        public Criteria andMaxpeopleEqualTo(Integer value) {
            addCriterion("maxPeople =", value, "maxpeople");
            return (Criteria) this;
        }

        public Criteria andMaxpeopleNotEqualTo(Integer value) {
            addCriterion("maxPeople <>", value, "maxpeople");
            return (Criteria) this;
        }

        public Criteria andMaxpeopleGreaterThan(Integer value) {
            addCriterion("maxPeople >", value, "maxpeople");
            return (Criteria) this;
        }

        public Criteria andMaxpeopleGreaterThanOrEqualTo(Integer value) {
            addCriterion("maxPeople >=", value, "maxpeople");
            return (Criteria) this;
        }

        public Criteria andMaxpeopleLessThan(Integer value) {
            addCriterion("maxPeople <", value, "maxpeople");
            return (Criteria) this;
        }

        public Criteria andMaxpeopleLessThanOrEqualTo(Integer value) {
            addCriterion("maxPeople <=", value, "maxpeople");
            return (Criteria) this;
        }

        public Criteria andMaxpeopleIn(List<Integer> values) {
            addCriterion("maxPeople in", values, "maxpeople");
            return (Criteria) this;
        }

        public Criteria andMaxpeopleNotIn(List<Integer> values) {
            addCriterion("maxPeople not in", values, "maxpeople");
            return (Criteria) this;
        }

        public Criteria andMaxpeopleBetween(Integer value1, Integer value2) {
            addCriterion("maxPeople between", value1, value2, "maxpeople");
            return (Criteria) this;
        }

        public Criteria andMaxpeopleNotBetween(Integer value1, Integer value2) {
            addCriterion("maxPeople not between", value1, value2, "maxpeople");
            return (Criteria) this;
        }

        public Criteria andCoursedesIsNull() {
            addCriterion("courseDes is null");
            return (Criteria) this;
        }

        public Criteria andCoursedesIsNotNull() {
            addCriterion("courseDes is not null");
            return (Criteria) this;
        }

        public Criteria andCoursedesEqualTo(String value) {
            addCriterion("courseDes =", value, "coursedes");
            return (Criteria) this;
        }

        public Criteria andCoursedesNotEqualTo(String value) {
            addCriterion("courseDes <>", value, "coursedes");
            return (Criteria) this;
        }

        public Criteria andCoursedesGreaterThan(String value) {
            addCriterion("courseDes >", value, "coursedes");
            return (Criteria) this;
        }

        public Criteria andCoursedesGreaterThanOrEqualTo(String value) {
            addCriterion("courseDes >=", value, "coursedes");
            return (Criteria) this;
        }

        public Criteria andCoursedesLessThan(String value) {
            addCriterion("courseDes <", value, "coursedes");
            return (Criteria) this;
        }

        public Criteria andCoursedesLessThanOrEqualTo(String value) {
            addCriterion("courseDes <=", value, "coursedes");
            return (Criteria) this;
        }

        public Criteria andCoursedesLike(String value) {
            addCriterion("courseDes like", value, "coursedes");
            return (Criteria) this;
        }

        public Criteria andCoursedesNotLike(String value) {
            addCriterion("courseDes not like", value, "coursedes");
            return (Criteria) this;
        }

        public Criteria andCoursedesIn(List<String> values) {
            addCriterion("courseDes in", values, "coursedes");
            return (Criteria) this;
        }

        public Criteria andCoursedesNotIn(List<String> values) {
            addCriterion("courseDes not in", values, "coursedes");
            return (Criteria) this;
        }

        public Criteria andCoursedesBetween(String value1, String value2) {
            addCriterion("courseDes between", value1, value2, "coursedes");
            return (Criteria) this;
        }

        public Criteria andCoursedesNotBetween(String value1, String value2) {
            addCriterion("courseDes not between", value1, value2, "coursedes");
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

        public Criteria andCoursetimetypeIsNull() {
            addCriterion("courseTimeType is null");
            return (Criteria) this;
        }

        public Criteria andCoursetimetypeIsNotNull() {
            addCriterion("courseTimeType is not null");
            return (Criteria) this;
        }

        public Criteria andCoursetimetypeEqualTo(Integer value) {
            addCriterion("courseTimeType =", value, "coursetimetype");
            return (Criteria) this;
        }

        public Criteria andCoursetimetypeNotEqualTo(Integer value) {
            addCriterion("courseTimeType <>", value, "coursetimetype");
            return (Criteria) this;
        }

        public Criteria andCoursetimetypeGreaterThan(Integer value) {
            addCriterion("courseTimeType >", value, "coursetimetype");
            return (Criteria) this;
        }

        public Criteria andCoursetimetypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("courseTimeType >=", value, "coursetimetype");
            return (Criteria) this;
        }

        public Criteria andCoursetimetypeLessThan(Integer value) {
            addCriterion("courseTimeType <", value, "coursetimetype");
            return (Criteria) this;
        }

        public Criteria andCoursetimetypeLessThanOrEqualTo(Integer value) {
            addCriterion("courseTimeType <=", value, "coursetimetype");
            return (Criteria) this;
        }

        public Criteria andCoursetimetypeIn(List<Integer> values) {
            addCriterion("courseTimeType in", values, "coursetimetype");
            return (Criteria) this;
        }

        public Criteria andCoursetimetypeNotIn(List<Integer> values) {
            addCriterion("courseTimeType not in", values, "coursetimetype");
            return (Criteria) this;
        }

        public Criteria andCoursetimetypeBetween(Integer value1, Integer value2) {
            addCriterion("courseTimeType between", value1, value2, "coursetimetype");
            return (Criteria) this;
        }

        public Criteria andCoursetimetypeNotBetween(Integer value1, Integer value2) {
            addCriterion("courseTimeType not between", value1, value2, "coursetimetype");
            return (Criteria) this;
        }

        public Criteria andStarthourIsNull() {
            addCriterion("startHour is null");
            return (Criteria) this;
        }

        public Criteria andStarthourIsNotNull() {
            addCriterion("startHour is not null");
            return (Criteria) this;
        }

        public Criteria andStarthourEqualTo(String value) {
            addCriterion("startHour =", value, "starthour");
            return (Criteria) this;
        }

        public Criteria andStarthourNotEqualTo(String value) {
            addCriterion("startHour <>", value, "starthour");
            return (Criteria) this;
        }

        public Criteria andStarthourGreaterThan(String value) {
            addCriterion("startHour >", value, "starthour");
            return (Criteria) this;
        }

        public Criteria andStarthourGreaterThanOrEqualTo(String value) {
            addCriterion("startHour >=", value, "starthour");
            return (Criteria) this;
        }

        public Criteria andStarthourLessThan(String value) {
            addCriterion("startHour <", value, "starthour");
            return (Criteria) this;
        }

        public Criteria andStarthourLessThanOrEqualTo(String value) {
            addCriterion("startHour <=", value, "starthour");
            return (Criteria) this;
        }

        public Criteria andStarthourLike(String value) {
            addCriterion("startHour like", value, "starthour");
            return (Criteria) this;
        }

        public Criteria andStarthourNotLike(String value) {
            addCriterion("startHour not like", value, "starthour");
            return (Criteria) this;
        }

        public Criteria andStarthourIn(List<String> values) {
            addCriterion("startHour in", values, "starthour");
            return (Criteria) this;
        }

        public Criteria andStarthourNotIn(List<String> values) {
            addCriterion("startHour not in", values, "starthour");
            return (Criteria) this;
        }

        public Criteria andStarthourBetween(String value1, String value2) {
            addCriterion("startHour between", value1, value2, "starthour");
            return (Criteria) this;
        }

        public Criteria andStarthourNotBetween(String value1, String value2) {
            addCriterion("startHour not between", value1, value2, "starthour");
            return (Criteria) this;
        }

        public Criteria andStartminIsNull() {
            addCriterion("startMin is null");
            return (Criteria) this;
        }

        public Criteria andStartminIsNotNull() {
            addCriterion("startMin is not null");
            return (Criteria) this;
        }

        public Criteria andStartminEqualTo(String value) {
            addCriterion("startMin =", value, "startmin");
            return (Criteria) this;
        }

        public Criteria andStartminNotEqualTo(String value) {
            addCriterion("startMin <>", value, "startmin");
            return (Criteria) this;
        }

        public Criteria andStartminGreaterThan(String value) {
            addCriterion("startMin >", value, "startmin");
            return (Criteria) this;
        }

        public Criteria andStartminGreaterThanOrEqualTo(String value) {
            addCriterion("startMin >=", value, "startmin");
            return (Criteria) this;
        }

        public Criteria andStartminLessThan(String value) {
            addCriterion("startMin <", value, "startmin");
            return (Criteria) this;
        }

        public Criteria andStartminLessThanOrEqualTo(String value) {
            addCriterion("startMin <=", value, "startmin");
            return (Criteria) this;
        }

        public Criteria andStartminLike(String value) {
            addCriterion("startMin like", value, "startmin");
            return (Criteria) this;
        }

        public Criteria andStartminNotLike(String value) {
            addCriterion("startMin not like", value, "startmin");
            return (Criteria) this;
        }

        public Criteria andStartminIn(List<String> values) {
            addCriterion("startMin in", values, "startmin");
            return (Criteria) this;
        }

        public Criteria andStartminNotIn(List<String> values) {
            addCriterion("startMin not in", values, "startmin");
            return (Criteria) this;
        }

        public Criteria andStartminBetween(String value1, String value2) {
            addCriterion("startMin between", value1, value2, "startmin");
            return (Criteria) this;
        }

        public Criteria andStartminNotBetween(String value1, String value2) {
            addCriterion("startMin not between", value1, value2, "startmin");
            return (Criteria) this;
        }

        public Criteria andEndhourIsNull() {
            addCriterion("endHour is null");
            return (Criteria) this;
        }

        public Criteria andEndhourIsNotNull() {
            addCriterion("endHour is not null");
            return (Criteria) this;
        }

        public Criteria andEndhourEqualTo(String value) {
            addCriterion("endHour =", value, "endhour");
            return (Criteria) this;
        }

        public Criteria andEndhourNotEqualTo(String value) {
            addCriterion("endHour <>", value, "endhour");
            return (Criteria) this;
        }

        public Criteria andEndhourGreaterThan(String value) {
            addCriterion("endHour >", value, "endhour");
            return (Criteria) this;
        }

        public Criteria andEndhourGreaterThanOrEqualTo(String value) {
            addCriterion("endHour >=", value, "endhour");
            return (Criteria) this;
        }

        public Criteria andEndhourLessThan(String value) {
            addCriterion("endHour <", value, "endhour");
            return (Criteria) this;
        }

        public Criteria andEndhourLessThanOrEqualTo(String value) {
            addCriterion("endHour <=", value, "endhour");
            return (Criteria) this;
        }

        public Criteria andEndhourLike(String value) {
            addCriterion("endHour like", value, "endhour");
            return (Criteria) this;
        }

        public Criteria andEndhourNotLike(String value) {
            addCriterion("endHour not like", value, "endhour");
            return (Criteria) this;
        }

        public Criteria andEndhourIn(List<String> values) {
            addCriterion("endHour in", values, "endhour");
            return (Criteria) this;
        }

        public Criteria andEndhourNotIn(List<String> values) {
            addCriterion("endHour not in", values, "endhour");
            return (Criteria) this;
        }

        public Criteria andEndhourBetween(String value1, String value2) {
            addCriterion("endHour between", value1, value2, "endhour");
            return (Criteria) this;
        }

        public Criteria andEndhourNotBetween(String value1, String value2) {
            addCriterion("endHour not between", value1, value2, "endhour");
            return (Criteria) this;
        }

        public Criteria andEndminIsNull() {
            addCriterion("endMin is null");
            return (Criteria) this;
        }

        public Criteria andEndminIsNotNull() {
            addCriterion("endMin is not null");
            return (Criteria) this;
        }

        public Criteria andEndminEqualTo(String value) {
            addCriterion("endMin =", value, "endmin");
            return (Criteria) this;
        }

        public Criteria andEndminNotEqualTo(String value) {
            addCriterion("endMin <>", value, "endmin");
            return (Criteria) this;
        }

        public Criteria andEndminGreaterThan(String value) {
            addCriterion("endMin >", value, "endmin");
            return (Criteria) this;
        }

        public Criteria andEndminGreaterThanOrEqualTo(String value) {
            addCriterion("endMin >=", value, "endmin");
            return (Criteria) this;
        }

        public Criteria andEndminLessThan(String value) {
            addCriterion("endMin <", value, "endmin");
            return (Criteria) this;
        }

        public Criteria andEndminLessThanOrEqualTo(String value) {
            addCriterion("endMin <=", value, "endmin");
            return (Criteria) this;
        }

        public Criteria andEndminLike(String value) {
            addCriterion("endMin like", value, "endmin");
            return (Criteria) this;
        }

        public Criteria andEndminNotLike(String value) {
            addCriterion("endMin not like", value, "endmin");
            return (Criteria) this;
        }

        public Criteria andEndminIn(List<String> values) {
            addCriterion("endMin in", values, "endmin");
            return (Criteria) this;
        }

        public Criteria andEndminNotIn(List<String> values) {
            addCriterion("endMin not in", values, "endmin");
            return (Criteria) this;
        }

        public Criteria andEndminBetween(String value1, String value2) {
            addCriterion("endMin between", value1, value2, "endmin");
            return (Criteria) this;
        }

        public Criteria andEndminNotBetween(String value1, String value2) {
            addCriterion("endMin not between", value1, value2, "endmin");
            return (Criteria) this;
        }

        public Criteria andCourseexpstartIsNull() {
            addCriterion("courseExpStart is null");
            return (Criteria) this;
        }

        public Criteria andCourseexpstartIsNotNull() {
            addCriterion("courseExpStart is not null");
            return (Criteria) this;
        }

        public Criteria andCourseexpstartEqualTo(Date value) {
            addCriterionForJDBCDate("courseExpStart =", value, "courseexpstart");
            return (Criteria) this;
        }

        public Criteria andCourseexpstartNotEqualTo(Date value) {
            addCriterionForJDBCDate("courseExpStart <>", value, "courseexpstart");
            return (Criteria) this;
        }

        public Criteria andCourseexpstartGreaterThan(Date value) {
            addCriterionForJDBCDate("courseExpStart >", value, "courseexpstart");
            return (Criteria) this;
        }

        public Criteria andCourseexpstartGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("courseExpStart >=", value, "courseexpstart");
            return (Criteria) this;
        }

        public Criteria andCourseexpstartLessThan(Date value) {
            addCriterionForJDBCDate("courseExpStart <", value, "courseexpstart");
            return (Criteria) this;
        }

        public Criteria andCourseexpstartLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("courseExpStart <=", value, "courseexpstart");
            return (Criteria) this;
        }

        public Criteria andCourseexpstartIn(List<Date> values) {
            addCriterionForJDBCDate("courseExpStart in", values, "courseexpstart");
            return (Criteria) this;
        }

        public Criteria andCourseexpstartNotIn(List<Date> values) {
            addCriterionForJDBCDate("courseExpStart not in", values, "courseexpstart");
            return (Criteria) this;
        }

        public Criteria andCourseexpstartBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("courseExpStart between", value1, value2, "courseexpstart");
            return (Criteria) this;
        }

        public Criteria andCourseexpstartNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("courseExpStart not between", value1, value2, "courseexpstart");
            return (Criteria) this;
        }

        public Criteria andStartdateIsNull() {
            addCriterion("startDate is null");
            return (Criteria) this;
        }

        public Criteria andStartdateIsNotNull() {
            addCriterion("startDate is not null");
            return (Criteria) this;
        }

        public Criteria andStartdateEqualTo(Date value) {
            addCriterionForJDBCDate("startDate =", value, "startdate");
            return (Criteria) this;
        }

        public Criteria andStartdateNotEqualTo(Date value) {
            addCriterionForJDBCDate("startDate <>", value, "startdate");
            return (Criteria) this;
        }

        public Criteria andStartdateGreaterThan(Date value) {
            addCriterionForJDBCDate("startDate >", value, "startdate");
            return (Criteria) this;
        }

        public Criteria andStartdateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("startDate >=", value, "startdate");
            return (Criteria) this;
        }

        public Criteria andStartdateLessThan(Date value) {
            addCriterionForJDBCDate("startDate <", value, "startdate");
            return (Criteria) this;
        }

        public Criteria andStartdateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("startDate <=", value, "startdate");
            return (Criteria) this;
        }

        public Criteria andStartdateIn(List<Date> values) {
            addCriterionForJDBCDate("startDate in", values, "startdate");
            return (Criteria) this;
        }

        public Criteria andStartdateNotIn(List<Date> values) {
            addCriterionForJDBCDate("startDate not in", values, "startdate");
            return (Criteria) this;
        }

        public Criteria andStartdateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("startDate between", value1, value2, "startdate");
            return (Criteria) this;
        }

        public Criteria andStartdateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("startDate not between", value1, value2, "startdate");
            return (Criteria) this;
        }

        public Criteria andEnddateIsNull() {
            addCriterion("endDate is null");
            return (Criteria) this;
        }

        public Criteria andEnddateIsNotNull() {
            addCriterion("endDate is not null");
            return (Criteria) this;
        }

        public Criteria andEnddateEqualTo(Date value) {
            addCriterionForJDBCDate("endDate =", value, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateNotEqualTo(Date value) {
            addCriterionForJDBCDate("endDate <>", value, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateGreaterThan(Date value) {
            addCriterionForJDBCDate("endDate >", value, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("endDate >=", value, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateLessThan(Date value) {
            addCriterionForJDBCDate("endDate <", value, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("endDate <=", value, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateIn(List<Date> values) {
            addCriterionForJDBCDate("endDate in", values, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateNotIn(List<Date> values) {
            addCriterionForJDBCDate("endDate not in", values, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("endDate between", value1, value2, "enddate");
            return (Criteria) this;
        }

        public Criteria andEnddateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("endDate not between", value1, value2, "enddate");
            return (Criteria) this;
        }

        public Criteria andWeekIsNull() {
            addCriterion("week is null");
            return (Criteria) this;
        }

        public Criteria andWeekIsNotNull() {
            addCriterion("week is not null");
            return (Criteria) this;
        }

        public Criteria andWeekEqualTo(String value) {
            addCriterion("week =", value, "week");
            return (Criteria) this;
        }

        public Criteria andWeekNotEqualTo(String value) {
            addCriterion("week <>", value, "week");
            return (Criteria) this;
        }

        public Criteria andWeekGreaterThan(String value) {
            addCriterion("week >", value, "week");
            return (Criteria) this;
        }

        public Criteria andWeekGreaterThanOrEqualTo(String value) {
            addCriterion("week >=", value, "week");
            return (Criteria) this;
        }

        public Criteria andWeekLessThan(String value) {
            addCriterion("week <", value, "week");
            return (Criteria) this;
        }

        public Criteria andWeekLessThanOrEqualTo(String value) {
            addCriterion("week <=", value, "week");
            return (Criteria) this;
        }

        public Criteria andWeekLike(String value) {
            addCriterion("week like", value, "week");
            return (Criteria) this;
        }

        public Criteria andWeekNotLike(String value) {
            addCriterion("week not like", value, "week");
            return (Criteria) this;
        }

        public Criteria andWeekIn(List<String> values) {
            addCriterion("week in", values, "week");
            return (Criteria) this;
        }

        public Criteria andWeekNotIn(List<String> values) {
            addCriterion("week not in", values, "week");
            return (Criteria) this;
        }

        public Criteria andWeekBetween(String value1, String value2) {
            addCriterion("week between", value1, value2, "week");
            return (Criteria) this;
        }

        public Criteria andWeekNotBetween(String value1, String value2) {
            addCriterion("week not between", value1, value2, "week");
            return (Criteria) this;
        }

        public Criteria andStartmonthIsNull() {
            addCriterion("startMonth is null");
            return (Criteria) this;
        }

        public Criteria andStartmonthIsNotNull() {
            addCriterion("startMonth is not null");
            return (Criteria) this;
        }

        public Criteria andStartmonthEqualTo(String value) {
            addCriterion("startMonth =", value, "startmonth");
            return (Criteria) this;
        }

        public Criteria andStartmonthNotEqualTo(String value) {
            addCriterion("startMonth <>", value, "startmonth");
            return (Criteria) this;
        }

        public Criteria andStartmonthGreaterThan(String value) {
            addCriterion("startMonth >", value, "startmonth");
            return (Criteria) this;
        }

        public Criteria andStartmonthGreaterThanOrEqualTo(String value) {
            addCriterion("startMonth >=", value, "startmonth");
            return (Criteria) this;
        }

        public Criteria andStartmonthLessThan(String value) {
            addCriterion("startMonth <", value, "startmonth");
            return (Criteria) this;
        }

        public Criteria andStartmonthLessThanOrEqualTo(String value) {
            addCriterion("startMonth <=", value, "startmonth");
            return (Criteria) this;
        }

        public Criteria andStartmonthLike(String value) {
            addCriterion("startMonth like", value, "startmonth");
            return (Criteria) this;
        }

        public Criteria andStartmonthNotLike(String value) {
            addCriterion("startMonth not like", value, "startmonth");
            return (Criteria) this;
        }

        public Criteria andStartmonthIn(List<String> values) {
            addCriterion("startMonth in", values, "startmonth");
            return (Criteria) this;
        }

        public Criteria andStartmonthNotIn(List<String> values) {
            addCriterion("startMonth not in", values, "startmonth");
            return (Criteria) this;
        }

        public Criteria andStartmonthBetween(String value1, String value2) {
            addCriterion("startMonth between", value1, value2, "startmonth");
            return (Criteria) this;
        }

        public Criteria andStartmonthNotBetween(String value1, String value2) {
            addCriterion("startMonth not between", value1, value2, "startmonth");
            return (Criteria) this;
        }

        public Criteria andEndmonthIsNull() {
            addCriterion("endMonth is null");
            return (Criteria) this;
        }

        public Criteria andEndmonthIsNotNull() {
            addCriterion("endMonth is not null");
            return (Criteria) this;
        }

        public Criteria andEndmonthEqualTo(String value) {
            addCriterion("endMonth =", value, "endmonth");
            return (Criteria) this;
        }

        public Criteria andEndmonthNotEqualTo(String value) {
            addCriterion("endMonth <>", value, "endmonth");
            return (Criteria) this;
        }

        public Criteria andEndmonthGreaterThan(String value) {
            addCriterion("endMonth >", value, "endmonth");
            return (Criteria) this;
        }

        public Criteria andEndmonthGreaterThanOrEqualTo(String value) {
            addCriterion("endMonth >=", value, "endmonth");
            return (Criteria) this;
        }

        public Criteria andEndmonthLessThan(String value) {
            addCriterion("endMonth <", value, "endmonth");
            return (Criteria) this;
        }

        public Criteria andEndmonthLessThanOrEqualTo(String value) {
            addCriterion("endMonth <=", value, "endmonth");
            return (Criteria) this;
        }

        public Criteria andEndmonthLike(String value) {
            addCriterion("endMonth like", value, "endmonth");
            return (Criteria) this;
        }

        public Criteria andEndmonthNotLike(String value) {
            addCriterion("endMonth not like", value, "endmonth");
            return (Criteria) this;
        }

        public Criteria andEndmonthIn(List<String> values) {
            addCriterion("endMonth in", values, "endmonth");
            return (Criteria) this;
        }

        public Criteria andEndmonthNotIn(List<String> values) {
            addCriterion("endMonth not in", values, "endmonth");
            return (Criteria) this;
        }

        public Criteria andEndmonthBetween(String value1, String value2) {
            addCriterion("endMonth between", value1, value2, "endmonth");
            return (Criteria) this;
        }

        public Criteria andEndmonthNotBetween(String value1, String value2) {
            addCriterion("endMonth not between", value1, value2, "endmonth");
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

        public Criteria andCoursetabIsNull() {
            addCriterion("courseTab is null");
            return (Criteria) this;
        }

        public Criteria andCoursetabIsNotNull() {
            addCriterion("courseTab is not null");
            return (Criteria) this;
        }

        public Criteria andCoursetabEqualTo(Integer value) {
            addCriterion("courseTab =", value, "coursetab");
            return (Criteria) this;
        }

        public Criteria andCoursetabNotEqualTo(Integer value) {
            addCriterion("courseTab <>", value, "coursetab");
            return (Criteria) this;
        }

        public Criteria andCoursetabGreaterThan(Integer value) {
            addCriterion("courseTab >", value, "coursetab");
            return (Criteria) this;
        }

        public Criteria andCoursetabGreaterThanOrEqualTo(Integer value) {
            addCriterion("courseTab >=", value, "coursetab");
            return (Criteria) this;
        }

        public Criteria andCoursetabLessThan(Integer value) {
            addCriterion("courseTab <", value, "coursetab");
            return (Criteria) this;
        }

        public Criteria andCoursetabLessThanOrEqualTo(Integer value) {
            addCriterion("courseTab <=", value, "coursetab");
            return (Criteria) this;
        }

        public Criteria andCoursetabIn(List<Integer> values) {
            addCriterion("courseTab in", values, "coursetab");
            return (Criteria) this;
        }

        public Criteria andCoursetabNotIn(List<Integer> values) {
            addCriterion("courseTab not in", values, "coursetab");
            return (Criteria) this;
        }

        public Criteria andCoursetabBetween(Integer value1, Integer value2) {
            addCriterion("courseTab between", value1, value2, "coursetab");
            return (Criteria) this;
        }

        public Criteria andCoursetabNotBetween(Integer value1, Integer value2) {
            addCriterion("courseTab not between", value1, value2, "coursetab");
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

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Integer value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Integer value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Integer value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Integer value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Integer value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Integer> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Integer> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Integer value1, Integer value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("type not between", value1, value2, "type");
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