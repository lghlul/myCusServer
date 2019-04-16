package customer.supu.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class CoachExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public CoachExample() {
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

        public Criteria andNicknameIsNull() {
            addCriterion("nickName is null");
            return (Criteria) this;
        }

        public Criteria andNicknameIsNotNull() {
            addCriterion("nickName is not null");
            return (Criteria) this;
        }

        public Criteria andNicknameEqualTo(String value) {
            addCriterion("nickName =", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotEqualTo(String value) {
            addCriterion("nickName <>", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameGreaterThan(String value) {
            addCriterion("nickName >", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameGreaterThanOrEqualTo(String value) {
            addCriterion("nickName >=", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameLessThan(String value) {
            addCriterion("nickName <", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameLessThanOrEqualTo(String value) {
            addCriterion("nickName <=", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameLike(String value) {
            addCriterion("nickName like", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotLike(String value) {
            addCriterion("nickName not like", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameIn(List<String> values) {
            addCriterion("nickName in", values, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotIn(List<String> values) {
            addCriterion("nickName not in", values, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameBetween(String value1, String value2) {
            addCriterion("nickName between", value1, value2, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotBetween(String value1, String value2) {
            addCriterion("nickName not between", value1, value2, "nickname");
            return (Criteria) this;
        }

        public Criteria andCoachnameIsNull() {
            addCriterion("coachName is null");
            return (Criteria) this;
        }

        public Criteria andCoachnameIsNotNull() {
            addCriterion("coachName is not null");
            return (Criteria) this;
        }

        public Criteria andCoachnameEqualTo(String value) {
            addCriterion("coachName =", value, "coachname");
            return (Criteria) this;
        }

        public Criteria andCoachnameNotEqualTo(String value) {
            addCriterion("coachName <>", value, "coachname");
            return (Criteria) this;
        }

        public Criteria andCoachnameGreaterThan(String value) {
            addCriterion("coachName >", value, "coachname");
            return (Criteria) this;
        }

        public Criteria andCoachnameGreaterThanOrEqualTo(String value) {
            addCriterion("coachName >=", value, "coachname");
            return (Criteria) this;
        }

        public Criteria andCoachnameLessThan(String value) {
            addCriterion("coachName <", value, "coachname");
            return (Criteria) this;
        }

        public Criteria andCoachnameLessThanOrEqualTo(String value) {
            addCriterion("coachName <=", value, "coachname");
            return (Criteria) this;
        }

        public Criteria andCoachnameLike(String value) {
            addCriterion("coachName like", value, "coachname");
            return (Criteria) this;
        }

        public Criteria andCoachnameNotLike(String value) {
            addCriterion("coachName not like", value, "coachname");
            return (Criteria) this;
        }

        public Criteria andCoachnameIn(List<String> values) {
            addCriterion("coachName in", values, "coachname");
            return (Criteria) this;
        }

        public Criteria andCoachnameNotIn(List<String> values) {
            addCriterion("coachName not in", values, "coachname");
            return (Criteria) this;
        }

        public Criteria andCoachnameBetween(String value1, String value2) {
            addCriterion("coachName between", value1, value2, "coachname");
            return (Criteria) this;
        }

        public Criteria andCoachnameNotBetween(String value1, String value2) {
            addCriterion("coachName not between", value1, value2, "coachname");
            return (Criteria) this;
        }

        public Criteria andSexIsNull() {
            addCriterion("sex is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("sex is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(Integer value) {
            addCriterion("sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(Integer value) {
            addCriterion("sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(Integer value) {
            addCriterion("sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(Integer value) {
            addCriterion("sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(Integer value) {
            addCriterion("sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(Integer value) {
            addCriterion("sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<Integer> values) {
            addCriterion("sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<Integer> values) {
            addCriterion("sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(Integer value1, Integer value2) {
            addCriterion("sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(Integer value1, Integer value2) {
            addCriterion("sex not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNull() {
            addCriterion("birthday is null");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNotNull() {
            addCriterion("birthday is not null");
            return (Criteria) this;
        }

        public Criteria andBirthdayEqualTo(Date value) {
            addCriterionForJDBCDate("birthday =", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotEqualTo(Date value) {
            addCriterionForJDBCDate("birthday <>", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThan(Date value) {
            addCriterionForJDBCDate("birthday >", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("birthday >=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThan(Date value) {
            addCriterionForJDBCDate("birthday <", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("birthday <=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayIn(List<Date> values) {
            addCriterionForJDBCDate("birthday in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotIn(List<Date> values) {
            addCriterionForJDBCDate("birthday not in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("birthday between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("birthday not between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("email not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andPhonenumberIsNull() {
            addCriterion("phoneNumber is null");
            return (Criteria) this;
        }

        public Criteria andPhonenumberIsNotNull() {
            addCriterion("phoneNumber is not null");
            return (Criteria) this;
        }

        public Criteria andPhonenumberEqualTo(String value) {
            addCriterion("phoneNumber =", value, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberNotEqualTo(String value) {
            addCriterion("phoneNumber <>", value, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberGreaterThan(String value) {
            addCriterion("phoneNumber >", value, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberGreaterThanOrEqualTo(String value) {
            addCriterion("phoneNumber >=", value, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberLessThan(String value) {
            addCriterion("phoneNumber <", value, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberLessThanOrEqualTo(String value) {
            addCriterion("phoneNumber <=", value, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberLike(String value) {
            addCriterion("phoneNumber like", value, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberNotLike(String value) {
            addCriterion("phoneNumber not like", value, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberIn(List<String> values) {
            addCriterion("phoneNumber in", values, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberNotIn(List<String> values) {
            addCriterion("phoneNumber not in", values, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberBetween(String value1, String value2) {
            addCriterion("phoneNumber between", value1, value2, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andPhonenumberNotBetween(String value1, String value2) {
            addCriterion("phoneNumber not between", value1, value2, "phonenumber");
            return (Criteria) this;
        }

        public Criteria andIdnumberIsNull() {
            addCriterion("idNumber is null");
            return (Criteria) this;
        }

        public Criteria andIdnumberIsNotNull() {
            addCriterion("idNumber is not null");
            return (Criteria) this;
        }

        public Criteria andIdnumberEqualTo(String value) {
            addCriterion("idNumber =", value, "idnumber");
            return (Criteria) this;
        }

        public Criteria andIdnumberNotEqualTo(String value) {
            addCriterion("idNumber <>", value, "idnumber");
            return (Criteria) this;
        }

        public Criteria andIdnumberGreaterThan(String value) {
            addCriterion("idNumber >", value, "idnumber");
            return (Criteria) this;
        }

        public Criteria andIdnumberGreaterThanOrEqualTo(String value) {
            addCriterion("idNumber >=", value, "idnumber");
            return (Criteria) this;
        }

        public Criteria andIdnumberLessThan(String value) {
            addCriterion("idNumber <", value, "idnumber");
            return (Criteria) this;
        }

        public Criteria andIdnumberLessThanOrEqualTo(String value) {
            addCriterion("idNumber <=", value, "idnumber");
            return (Criteria) this;
        }

        public Criteria andIdnumberLike(String value) {
            addCriterion("idNumber like", value, "idnumber");
            return (Criteria) this;
        }

        public Criteria andIdnumberNotLike(String value) {
            addCriterion("idNumber not like", value, "idnumber");
            return (Criteria) this;
        }

        public Criteria andIdnumberIn(List<String> values) {
            addCriterion("idNumber in", values, "idnumber");
            return (Criteria) this;
        }

        public Criteria andIdnumberNotIn(List<String> values) {
            addCriterion("idNumber not in", values, "idnumber");
            return (Criteria) this;
        }

        public Criteria andIdnumberBetween(String value1, String value2) {
            addCriterion("idNumber between", value1, value2, "idnumber");
            return (Criteria) this;
        }

        public Criteria andIdnumberNotBetween(String value1, String value2) {
            addCriterion("idNumber not between", value1, value2, "idnumber");
            return (Criteria) this;
        }

        public Criteria andFrontidnumberIsNull() {
            addCriterion("frontIdNumber is null");
            return (Criteria) this;
        }

        public Criteria andFrontidnumberIsNotNull() {
            addCriterion("frontIdNumber is not null");
            return (Criteria) this;
        }

        public Criteria andFrontidnumberEqualTo(String value) {
            addCriterion("frontIdNumber =", value, "frontidnumber");
            return (Criteria) this;
        }

        public Criteria andFrontidnumberNotEqualTo(String value) {
            addCriterion("frontIdNumber <>", value, "frontidnumber");
            return (Criteria) this;
        }

        public Criteria andFrontidnumberGreaterThan(String value) {
            addCriterion("frontIdNumber >", value, "frontidnumber");
            return (Criteria) this;
        }

        public Criteria andFrontidnumberGreaterThanOrEqualTo(String value) {
            addCriterion("frontIdNumber >=", value, "frontidnumber");
            return (Criteria) this;
        }

        public Criteria andFrontidnumberLessThan(String value) {
            addCriterion("frontIdNumber <", value, "frontidnumber");
            return (Criteria) this;
        }

        public Criteria andFrontidnumberLessThanOrEqualTo(String value) {
            addCriterion("frontIdNumber <=", value, "frontidnumber");
            return (Criteria) this;
        }

        public Criteria andFrontidnumberLike(String value) {
            addCriterion("frontIdNumber like", value, "frontidnumber");
            return (Criteria) this;
        }

        public Criteria andFrontidnumberNotLike(String value) {
            addCriterion("frontIdNumber not like", value, "frontidnumber");
            return (Criteria) this;
        }

        public Criteria andFrontidnumberIn(List<String> values) {
            addCriterion("frontIdNumber in", values, "frontidnumber");
            return (Criteria) this;
        }

        public Criteria andFrontidnumberNotIn(List<String> values) {
            addCriterion("frontIdNumber not in", values, "frontidnumber");
            return (Criteria) this;
        }

        public Criteria andFrontidnumberBetween(String value1, String value2) {
            addCriterion("frontIdNumber between", value1, value2, "frontidnumber");
            return (Criteria) this;
        }

        public Criteria andFrontidnumberNotBetween(String value1, String value2) {
            addCriterion("frontIdNumber not between", value1, value2, "frontidnumber");
            return (Criteria) this;
        }

        public Criteria andReverseidnumberIsNull() {
            addCriterion("reverseIdNumber is null");
            return (Criteria) this;
        }

        public Criteria andReverseidnumberIsNotNull() {
            addCriterion("reverseIdNumber is not null");
            return (Criteria) this;
        }

        public Criteria andReverseidnumberEqualTo(String value) {
            addCriterion("reverseIdNumber =", value, "reverseidnumber");
            return (Criteria) this;
        }

        public Criteria andReverseidnumberNotEqualTo(String value) {
            addCriterion("reverseIdNumber <>", value, "reverseidnumber");
            return (Criteria) this;
        }

        public Criteria andReverseidnumberGreaterThan(String value) {
            addCriterion("reverseIdNumber >", value, "reverseidnumber");
            return (Criteria) this;
        }

        public Criteria andReverseidnumberGreaterThanOrEqualTo(String value) {
            addCriterion("reverseIdNumber >=", value, "reverseidnumber");
            return (Criteria) this;
        }

        public Criteria andReverseidnumberLessThan(String value) {
            addCriterion("reverseIdNumber <", value, "reverseidnumber");
            return (Criteria) this;
        }

        public Criteria andReverseidnumberLessThanOrEqualTo(String value) {
            addCriterion("reverseIdNumber <=", value, "reverseidnumber");
            return (Criteria) this;
        }

        public Criteria andReverseidnumberLike(String value) {
            addCriterion("reverseIdNumber like", value, "reverseidnumber");
            return (Criteria) this;
        }

        public Criteria andReverseidnumberNotLike(String value) {
            addCriterion("reverseIdNumber not like", value, "reverseidnumber");
            return (Criteria) this;
        }

        public Criteria andReverseidnumberIn(List<String> values) {
            addCriterion("reverseIdNumber in", values, "reverseidnumber");
            return (Criteria) this;
        }

        public Criteria andReverseidnumberNotIn(List<String> values) {
            addCriterion("reverseIdNumber not in", values, "reverseidnumber");
            return (Criteria) this;
        }

        public Criteria andReverseidnumberBetween(String value1, String value2) {
            addCriterion("reverseIdNumber between", value1, value2, "reverseidnumber");
            return (Criteria) this;
        }

        public Criteria andReverseidnumberNotBetween(String value1, String value2) {
            addCriterion("reverseIdNumber not between", value1, value2, "reverseidnumber");
            return (Criteria) this;
        }

        public Criteria andLocationIsNull() {
            addCriterion("location is null");
            return (Criteria) this;
        }

        public Criteria andLocationIsNotNull() {
            addCriterion("location is not null");
            return (Criteria) this;
        }

        public Criteria andLocationEqualTo(String value) {
            addCriterion("location =", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotEqualTo(String value) {
            addCriterion("location <>", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationGreaterThan(String value) {
            addCriterion("location >", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationGreaterThanOrEqualTo(String value) {
            addCriterion("location >=", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationLessThan(String value) {
            addCriterion("location <", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationLessThanOrEqualTo(String value) {
            addCriterion("location <=", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationLike(String value) {
            addCriterion("location like", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotLike(String value) {
            addCriterion("location not like", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationIn(List<String> values) {
            addCriterion("location in", values, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotIn(List<String> values) {
            addCriterion("location not in", values, "location");
            return (Criteria) this;
        }

        public Criteria andLocationBetween(String value1, String value2) {
            addCriterion("location between", value1, value2, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotBetween(String value1, String value2) {
            addCriterion("location not between", value1, value2, "location");
            return (Criteria) this;
        }

        public Criteria andServiceareaIsNull() {
            addCriterion("serviceArea is null");
            return (Criteria) this;
        }

        public Criteria andServiceareaIsNotNull() {
            addCriterion("serviceArea is not null");
            return (Criteria) this;
        }

        public Criteria andServiceareaEqualTo(String value) {
            addCriterion("serviceArea =", value, "servicearea");
            return (Criteria) this;
        }

        public Criteria andServiceareaNotEqualTo(String value) {
            addCriterion("serviceArea <>", value, "servicearea");
            return (Criteria) this;
        }

        public Criteria andServiceareaGreaterThan(String value) {
            addCriterion("serviceArea >", value, "servicearea");
            return (Criteria) this;
        }

        public Criteria andServiceareaGreaterThanOrEqualTo(String value) {
            addCriterion("serviceArea >=", value, "servicearea");
            return (Criteria) this;
        }

        public Criteria andServiceareaLessThan(String value) {
            addCriterion("serviceArea <", value, "servicearea");
            return (Criteria) this;
        }

        public Criteria andServiceareaLessThanOrEqualTo(String value) {
            addCriterion("serviceArea <=", value, "servicearea");
            return (Criteria) this;
        }

        public Criteria andServiceareaLike(String value) {
            addCriterion("serviceArea like", value, "servicearea");
            return (Criteria) this;
        }

        public Criteria andServiceareaNotLike(String value) {
            addCriterion("serviceArea not like", value, "servicearea");
            return (Criteria) this;
        }

        public Criteria andServiceareaIn(List<String> values) {
            addCriterion("serviceArea in", values, "servicearea");
            return (Criteria) this;
        }

        public Criteria andServiceareaNotIn(List<String> values) {
            addCriterion("serviceArea not in", values, "servicearea");
            return (Criteria) this;
        }

        public Criteria andServiceareaBetween(String value1, String value2) {
            addCriterion("serviceArea between", value1, value2, "servicearea");
            return (Criteria) this;
        }

        public Criteria andServiceareaNotBetween(String value1, String value2) {
            addCriterion("serviceArea not between", value1, value2, "servicearea");
            return (Criteria) this;
        }

        public Criteria andGraduatecollegesIsNull() {
            addCriterion("graduateColleges is null");
            return (Criteria) this;
        }

        public Criteria andGraduatecollegesIsNotNull() {
            addCriterion("graduateColleges is not null");
            return (Criteria) this;
        }

        public Criteria andGraduatecollegesEqualTo(String value) {
            addCriterion("graduateColleges =", value, "graduatecolleges");
            return (Criteria) this;
        }

        public Criteria andGraduatecollegesNotEqualTo(String value) {
            addCriterion("graduateColleges <>", value, "graduatecolleges");
            return (Criteria) this;
        }

        public Criteria andGraduatecollegesGreaterThan(String value) {
            addCriterion("graduateColleges >", value, "graduatecolleges");
            return (Criteria) this;
        }

        public Criteria andGraduatecollegesGreaterThanOrEqualTo(String value) {
            addCriterion("graduateColleges >=", value, "graduatecolleges");
            return (Criteria) this;
        }

        public Criteria andGraduatecollegesLessThan(String value) {
            addCriterion("graduateColleges <", value, "graduatecolleges");
            return (Criteria) this;
        }

        public Criteria andGraduatecollegesLessThanOrEqualTo(String value) {
            addCriterion("graduateColleges <=", value, "graduatecolleges");
            return (Criteria) this;
        }

        public Criteria andGraduatecollegesLike(String value) {
            addCriterion("graduateColleges like", value, "graduatecolleges");
            return (Criteria) this;
        }

        public Criteria andGraduatecollegesNotLike(String value) {
            addCriterion("graduateColleges not like", value, "graduatecolleges");
            return (Criteria) this;
        }

        public Criteria andGraduatecollegesIn(List<String> values) {
            addCriterion("graduateColleges in", values, "graduatecolleges");
            return (Criteria) this;
        }

        public Criteria andGraduatecollegesNotIn(List<String> values) {
            addCriterion("graduateColleges not in", values, "graduatecolleges");
            return (Criteria) this;
        }

        public Criteria andGraduatecollegesBetween(String value1, String value2) {
            addCriterion("graduateColleges between", value1, value2, "graduatecolleges");
            return (Criteria) this;
        }

        public Criteria andGraduatecollegesNotBetween(String value1, String value2) {
            addCriterion("graduateColleges not between", value1, value2, "graduatecolleges");
            return (Criteria) this;
        }

        public Criteria andEverworkedIsNull() {
            addCriterion("everWorked is null");
            return (Criteria) this;
        }

        public Criteria andEverworkedIsNotNull() {
            addCriterion("everWorked is not null");
            return (Criteria) this;
        }

        public Criteria andEverworkedEqualTo(String value) {
            addCriterion("everWorked =", value, "everworked");
            return (Criteria) this;
        }

        public Criteria andEverworkedNotEqualTo(String value) {
            addCriterion("everWorked <>", value, "everworked");
            return (Criteria) this;
        }

        public Criteria andEverworkedGreaterThan(String value) {
            addCriterion("everWorked >", value, "everworked");
            return (Criteria) this;
        }

        public Criteria andEverworkedGreaterThanOrEqualTo(String value) {
            addCriterion("everWorked >=", value, "everworked");
            return (Criteria) this;
        }

        public Criteria andEverworkedLessThan(String value) {
            addCriterion("everWorked <", value, "everworked");
            return (Criteria) this;
        }

        public Criteria andEverworkedLessThanOrEqualTo(String value) {
            addCriterion("everWorked <=", value, "everworked");
            return (Criteria) this;
        }

        public Criteria andEverworkedLike(String value) {
            addCriterion("everWorked like", value, "everworked");
            return (Criteria) this;
        }

        public Criteria andEverworkedNotLike(String value) {
            addCriterion("everWorked not like", value, "everworked");
            return (Criteria) this;
        }

        public Criteria andEverworkedIn(List<String> values) {
            addCriterion("everWorked in", values, "everworked");
            return (Criteria) this;
        }

        public Criteria andEverworkedNotIn(List<String> values) {
            addCriterion("everWorked not in", values, "everworked");
            return (Criteria) this;
        }

        public Criteria andEverworkedBetween(String value1, String value2) {
            addCriterion("everWorked between", value1, value2, "everworked");
            return (Criteria) this;
        }

        public Criteria andEverworkedNotBetween(String value1, String value2) {
            addCriterion("everWorked not between", value1, value2, "everworked");
            return (Criteria) this;
        }

        public Criteria andCoachlevelIsNull() {
            addCriterion("coachLevel is null");
            return (Criteria) this;
        }

        public Criteria andCoachlevelIsNotNull() {
            addCriterion("coachLevel is not null");
            return (Criteria) this;
        }

        public Criteria andCoachlevelEqualTo(Integer value) {
            addCriterion("coachLevel =", value, "coachlevel");
            return (Criteria) this;
        }

        public Criteria andCoachlevelNotEqualTo(Integer value) {
            addCriterion("coachLevel <>", value, "coachlevel");
            return (Criteria) this;
        }

        public Criteria andCoachlevelGreaterThan(Integer value) {
            addCriterion("coachLevel >", value, "coachlevel");
            return (Criteria) this;
        }

        public Criteria andCoachlevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("coachLevel >=", value, "coachlevel");
            return (Criteria) this;
        }

        public Criteria andCoachlevelLessThan(Integer value) {
            addCriterion("coachLevel <", value, "coachlevel");
            return (Criteria) this;
        }

        public Criteria andCoachlevelLessThanOrEqualTo(Integer value) {
            addCriterion("coachLevel <=", value, "coachlevel");
            return (Criteria) this;
        }

        public Criteria andCoachlevelIn(List<Integer> values) {
            addCriterion("coachLevel in", values, "coachlevel");
            return (Criteria) this;
        }

        public Criteria andCoachlevelNotIn(List<Integer> values) {
            addCriterion("coachLevel not in", values, "coachlevel");
            return (Criteria) this;
        }

        public Criteria andCoachlevelBetween(Integer value1, Integer value2) {
            addCriterion("coachLevel between", value1, value2, "coachlevel");
            return (Criteria) this;
        }

        public Criteria andCoachlevelNotBetween(Integer value1, Integer value2) {
            addCriterion("coachLevel not between", value1, value2, "coachlevel");
            return (Criteria) this;
        }

        public Criteria andTeachyearsIsNull() {
            addCriterion("teachYears is null");
            return (Criteria) this;
        }

        public Criteria andTeachyearsIsNotNull() {
            addCriterion("teachYears is not null");
            return (Criteria) this;
        }

        public Criteria andTeachyearsEqualTo(Double value) {
            addCriterion("teachYears =", value, "teachyears");
            return (Criteria) this;
        }

        public Criteria andTeachyearsNotEqualTo(Double value) {
            addCriterion("teachYears <>", value, "teachyears");
            return (Criteria) this;
        }

        public Criteria andTeachyearsGreaterThan(Double value) {
            addCriterion("teachYears >", value, "teachyears");
            return (Criteria) this;
        }

        public Criteria andTeachyearsGreaterThanOrEqualTo(Double value) {
            addCriterion("teachYears >=", value, "teachyears");
            return (Criteria) this;
        }

        public Criteria andTeachyearsLessThan(Double value) {
            addCriterion("teachYears <", value, "teachyears");
            return (Criteria) this;
        }

        public Criteria andTeachyearsLessThanOrEqualTo(Double value) {
            addCriterion("teachYears <=", value, "teachyears");
            return (Criteria) this;
        }

        public Criteria andTeachyearsIn(List<Double> values) {
            addCriterion("teachYears in", values, "teachyears");
            return (Criteria) this;
        }

        public Criteria andTeachyearsNotIn(List<Double> values) {
            addCriterion("teachYears not in", values, "teachyears");
            return (Criteria) this;
        }

        public Criteria andTeachyearsBetween(Double value1, Double value2) {
            addCriterion("teachYears between", value1, value2, "teachyears");
            return (Criteria) this;
        }

        public Criteria andTeachyearsNotBetween(Double value1, Double value2) {
            addCriterion("teachYears not between", value1, value2, "teachyears");
            return (Criteria) this;
        }

        public Criteria andHeadimgIsNull() {
            addCriterion("headImg is null");
            return (Criteria) this;
        }

        public Criteria andHeadimgIsNotNull() {
            addCriterion("headImg is not null");
            return (Criteria) this;
        }

        public Criteria andHeadimgEqualTo(String value) {
            addCriterion("headImg =", value, "headimg");
            return (Criteria) this;
        }

        public Criteria andHeadimgNotEqualTo(String value) {
            addCriterion("headImg <>", value, "headimg");
            return (Criteria) this;
        }

        public Criteria andHeadimgGreaterThan(String value) {
            addCriterion("headImg >", value, "headimg");
            return (Criteria) this;
        }

        public Criteria andHeadimgGreaterThanOrEqualTo(String value) {
            addCriterion("headImg >=", value, "headimg");
            return (Criteria) this;
        }

        public Criteria andHeadimgLessThan(String value) {
            addCriterion("headImg <", value, "headimg");
            return (Criteria) this;
        }

        public Criteria andHeadimgLessThanOrEqualTo(String value) {
            addCriterion("headImg <=", value, "headimg");
            return (Criteria) this;
        }

        public Criteria andHeadimgLike(String value) {
            addCriterion("headImg like", value, "headimg");
            return (Criteria) this;
        }

        public Criteria andHeadimgNotLike(String value) {
            addCriterion("headImg not like", value, "headimg");
            return (Criteria) this;
        }

        public Criteria andHeadimgIn(List<String> values) {
            addCriterion("headImg in", values, "headimg");
            return (Criteria) this;
        }

        public Criteria andHeadimgNotIn(List<String> values) {
            addCriterion("headImg not in", values, "headimg");
            return (Criteria) this;
        }

        public Criteria andHeadimgBetween(String value1, String value2) {
            addCriterion("headImg between", value1, value2, "headimg");
            return (Criteria) this;
        }

        public Criteria andHeadimgNotBetween(String value1, String value2) {
            addCriterion("headImg not between", value1, value2, "headimg");
            return (Criteria) this;
        }

        public Criteria andCoachimg1IsNull() {
            addCriterion("coachImg1 is null");
            return (Criteria) this;
        }

        public Criteria andCoachimg1IsNotNull() {
            addCriterion("coachImg1 is not null");
            return (Criteria) this;
        }

        public Criteria andCoachimg1EqualTo(String value) {
            addCriterion("coachImg1 =", value, "coachimg1");
            return (Criteria) this;
        }

        public Criteria andCoachimg1NotEqualTo(String value) {
            addCriterion("coachImg1 <>", value, "coachimg1");
            return (Criteria) this;
        }

        public Criteria andCoachimg1GreaterThan(String value) {
            addCriterion("coachImg1 >", value, "coachimg1");
            return (Criteria) this;
        }

        public Criteria andCoachimg1GreaterThanOrEqualTo(String value) {
            addCriterion("coachImg1 >=", value, "coachimg1");
            return (Criteria) this;
        }

        public Criteria andCoachimg1LessThan(String value) {
            addCriterion("coachImg1 <", value, "coachimg1");
            return (Criteria) this;
        }

        public Criteria andCoachimg1LessThanOrEqualTo(String value) {
            addCriterion("coachImg1 <=", value, "coachimg1");
            return (Criteria) this;
        }

        public Criteria andCoachimg1Like(String value) {
            addCriterion("coachImg1 like", value, "coachimg1");
            return (Criteria) this;
        }

        public Criteria andCoachimg1NotLike(String value) {
            addCriterion("coachImg1 not like", value, "coachimg1");
            return (Criteria) this;
        }

        public Criteria andCoachimg1In(List<String> values) {
            addCriterion("coachImg1 in", values, "coachimg1");
            return (Criteria) this;
        }

        public Criteria andCoachimg1NotIn(List<String> values) {
            addCriterion("coachImg1 not in", values, "coachimg1");
            return (Criteria) this;
        }

        public Criteria andCoachimg1Between(String value1, String value2) {
            addCriterion("coachImg1 between", value1, value2, "coachimg1");
            return (Criteria) this;
        }

        public Criteria andCoachimg1NotBetween(String value1, String value2) {
            addCriterion("coachImg1 not between", value1, value2, "coachimg1");
            return (Criteria) this;
        }

        public Criteria andCoachimg2IsNull() {
            addCriterion("coachImg2 is null");
            return (Criteria) this;
        }

        public Criteria andCoachimg2IsNotNull() {
            addCriterion("coachImg2 is not null");
            return (Criteria) this;
        }

        public Criteria andCoachimg2EqualTo(String value) {
            addCriterion("coachImg2 =", value, "coachimg2");
            return (Criteria) this;
        }

        public Criteria andCoachimg2NotEqualTo(String value) {
            addCriterion("coachImg2 <>", value, "coachimg2");
            return (Criteria) this;
        }

        public Criteria andCoachimg2GreaterThan(String value) {
            addCriterion("coachImg2 >", value, "coachimg2");
            return (Criteria) this;
        }

        public Criteria andCoachimg2GreaterThanOrEqualTo(String value) {
            addCriterion("coachImg2 >=", value, "coachimg2");
            return (Criteria) this;
        }

        public Criteria andCoachimg2LessThan(String value) {
            addCriterion("coachImg2 <", value, "coachimg2");
            return (Criteria) this;
        }

        public Criteria andCoachimg2LessThanOrEqualTo(String value) {
            addCriterion("coachImg2 <=", value, "coachimg2");
            return (Criteria) this;
        }

        public Criteria andCoachimg2Like(String value) {
            addCriterion("coachImg2 like", value, "coachimg2");
            return (Criteria) this;
        }

        public Criteria andCoachimg2NotLike(String value) {
            addCriterion("coachImg2 not like", value, "coachimg2");
            return (Criteria) this;
        }

        public Criteria andCoachimg2In(List<String> values) {
            addCriterion("coachImg2 in", values, "coachimg2");
            return (Criteria) this;
        }

        public Criteria andCoachimg2NotIn(List<String> values) {
            addCriterion("coachImg2 not in", values, "coachimg2");
            return (Criteria) this;
        }

        public Criteria andCoachimg2Between(String value1, String value2) {
            addCriterion("coachImg2 between", value1, value2, "coachimg2");
            return (Criteria) this;
        }

        public Criteria andCoachimg2NotBetween(String value1, String value2) {
            addCriterion("coachImg2 not between", value1, value2, "coachimg2");
            return (Criteria) this;
        }

        public Criteria andCoachimg3IsNull() {
            addCriterion("coachImg3 is null");
            return (Criteria) this;
        }

        public Criteria andCoachimg3IsNotNull() {
            addCriterion("coachImg3 is not null");
            return (Criteria) this;
        }

        public Criteria andCoachimg3EqualTo(String value) {
            addCriterion("coachImg3 =", value, "coachimg3");
            return (Criteria) this;
        }

        public Criteria andCoachimg3NotEqualTo(String value) {
            addCriterion("coachImg3 <>", value, "coachimg3");
            return (Criteria) this;
        }

        public Criteria andCoachimg3GreaterThan(String value) {
            addCriterion("coachImg3 >", value, "coachimg3");
            return (Criteria) this;
        }

        public Criteria andCoachimg3GreaterThanOrEqualTo(String value) {
            addCriterion("coachImg3 >=", value, "coachimg3");
            return (Criteria) this;
        }

        public Criteria andCoachimg3LessThan(String value) {
            addCriterion("coachImg3 <", value, "coachimg3");
            return (Criteria) this;
        }

        public Criteria andCoachimg3LessThanOrEqualTo(String value) {
            addCriterion("coachImg3 <=", value, "coachimg3");
            return (Criteria) this;
        }

        public Criteria andCoachimg3Like(String value) {
            addCriterion("coachImg3 like", value, "coachimg3");
            return (Criteria) this;
        }

        public Criteria andCoachimg3NotLike(String value) {
            addCriterion("coachImg3 not like", value, "coachimg3");
            return (Criteria) this;
        }

        public Criteria andCoachimg3In(List<String> values) {
            addCriterion("coachImg3 in", values, "coachimg3");
            return (Criteria) this;
        }

        public Criteria andCoachimg3NotIn(List<String> values) {
            addCriterion("coachImg3 not in", values, "coachimg3");
            return (Criteria) this;
        }

        public Criteria andCoachimg3Between(String value1, String value2) {
            addCriterion("coachImg3 between", value1, value2, "coachimg3");
            return (Criteria) this;
        }

        public Criteria andCoachimg3NotBetween(String value1, String value2) {
            addCriterion("coachImg3 not between", value1, value2, "coachimg3");
            return (Criteria) this;
        }

        public Criteria andCoachimg4IsNull() {
            addCriterion("coachImg4 is null");
            return (Criteria) this;
        }

        public Criteria andCoachimg4IsNotNull() {
            addCriterion("coachImg4 is not null");
            return (Criteria) this;
        }

        public Criteria andCoachimg4EqualTo(String value) {
            addCriterion("coachImg4 =", value, "coachimg4");
            return (Criteria) this;
        }

        public Criteria andCoachimg4NotEqualTo(String value) {
            addCriterion("coachImg4 <>", value, "coachimg4");
            return (Criteria) this;
        }

        public Criteria andCoachimg4GreaterThan(String value) {
            addCriterion("coachImg4 >", value, "coachimg4");
            return (Criteria) this;
        }

        public Criteria andCoachimg4GreaterThanOrEqualTo(String value) {
            addCriterion("coachImg4 >=", value, "coachimg4");
            return (Criteria) this;
        }

        public Criteria andCoachimg4LessThan(String value) {
            addCriterion("coachImg4 <", value, "coachimg4");
            return (Criteria) this;
        }

        public Criteria andCoachimg4LessThanOrEqualTo(String value) {
            addCriterion("coachImg4 <=", value, "coachimg4");
            return (Criteria) this;
        }

        public Criteria andCoachimg4Like(String value) {
            addCriterion("coachImg4 like", value, "coachimg4");
            return (Criteria) this;
        }

        public Criteria andCoachimg4NotLike(String value) {
            addCriterion("coachImg4 not like", value, "coachimg4");
            return (Criteria) this;
        }

        public Criteria andCoachimg4In(List<String> values) {
            addCriterion("coachImg4 in", values, "coachimg4");
            return (Criteria) this;
        }

        public Criteria andCoachimg4NotIn(List<String> values) {
            addCriterion("coachImg4 not in", values, "coachimg4");
            return (Criteria) this;
        }

        public Criteria andCoachimg4Between(String value1, String value2) {
            addCriterion("coachImg4 between", value1, value2, "coachimg4");
            return (Criteria) this;
        }

        public Criteria andCoachimg4NotBetween(String value1, String value2) {
            addCriterion("coachImg4 not between", value1, value2, "coachimg4");
            return (Criteria) this;
        }

        public Criteria andCoachimg5IsNull() {
            addCriterion("coachImg5 is null");
            return (Criteria) this;
        }

        public Criteria andCoachimg5IsNotNull() {
            addCriterion("coachImg5 is not null");
            return (Criteria) this;
        }

        public Criteria andCoachimg5EqualTo(String value) {
            addCriterion("coachImg5 =", value, "coachimg5");
            return (Criteria) this;
        }

        public Criteria andCoachimg5NotEqualTo(String value) {
            addCriterion("coachImg5 <>", value, "coachimg5");
            return (Criteria) this;
        }

        public Criteria andCoachimg5GreaterThan(String value) {
            addCriterion("coachImg5 >", value, "coachimg5");
            return (Criteria) this;
        }

        public Criteria andCoachimg5GreaterThanOrEqualTo(String value) {
            addCriterion("coachImg5 >=", value, "coachimg5");
            return (Criteria) this;
        }

        public Criteria andCoachimg5LessThan(String value) {
            addCriterion("coachImg5 <", value, "coachimg5");
            return (Criteria) this;
        }

        public Criteria andCoachimg5LessThanOrEqualTo(String value) {
            addCriterion("coachImg5 <=", value, "coachimg5");
            return (Criteria) this;
        }

        public Criteria andCoachimg5Like(String value) {
            addCriterion("coachImg5 like", value, "coachimg5");
            return (Criteria) this;
        }

        public Criteria andCoachimg5NotLike(String value) {
            addCriterion("coachImg5 not like", value, "coachimg5");
            return (Criteria) this;
        }

        public Criteria andCoachimg5In(List<String> values) {
            addCriterion("coachImg5 in", values, "coachimg5");
            return (Criteria) this;
        }

        public Criteria andCoachimg5NotIn(List<String> values) {
            addCriterion("coachImg5 not in", values, "coachimg5");
            return (Criteria) this;
        }

        public Criteria andCoachimg5Between(String value1, String value2) {
            addCriterion("coachImg5 between", value1, value2, "coachimg5");
            return (Criteria) this;
        }

        public Criteria andCoachimg5NotBetween(String value1, String value2) {
            addCriterion("coachImg5 not between", value1, value2, "coachimg5");
            return (Criteria) this;
        }

        public Criteria andIspopularIsNull() {
            addCriterion("isPopular is null");
            return (Criteria) this;
        }

        public Criteria andIspopularIsNotNull() {
            addCriterion("isPopular is not null");
            return (Criteria) this;
        }

        public Criteria andIspopularEqualTo(Integer value) {
            addCriterion("isPopular =", value, "ispopular");
            return (Criteria) this;
        }

        public Criteria andIspopularNotEqualTo(Integer value) {
            addCriterion("isPopular <>", value, "ispopular");
            return (Criteria) this;
        }

        public Criteria andIspopularGreaterThan(Integer value) {
            addCriterion("isPopular >", value, "ispopular");
            return (Criteria) this;
        }

        public Criteria andIspopularGreaterThanOrEqualTo(Integer value) {
            addCriterion("isPopular >=", value, "ispopular");
            return (Criteria) this;
        }

        public Criteria andIspopularLessThan(Integer value) {
            addCriterion("isPopular <", value, "ispopular");
            return (Criteria) this;
        }

        public Criteria andIspopularLessThanOrEqualTo(Integer value) {
            addCriterion("isPopular <=", value, "ispopular");
            return (Criteria) this;
        }

        public Criteria andIspopularIn(List<Integer> values) {
            addCriterion("isPopular in", values, "ispopular");
            return (Criteria) this;
        }

        public Criteria andIspopularNotIn(List<Integer> values) {
            addCriterion("isPopular not in", values, "ispopular");
            return (Criteria) this;
        }

        public Criteria andIspopularBetween(Integer value1, Integer value2) {
            addCriterion("isPopular between", value1, value2, "ispopular");
            return (Criteria) this;
        }

        public Criteria andIspopularNotBetween(Integer value1, Integer value2) {
            addCriterion("isPopular not between", value1, value2, "ispopular");
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