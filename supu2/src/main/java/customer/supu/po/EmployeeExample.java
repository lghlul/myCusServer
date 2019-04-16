package customer.supu.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EmployeeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public EmployeeExample() {
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

        public Criteria andEmployeeidIsNull() {
            addCriterion("EmployeeId is null");
            return (Criteria) this;
        }

        public Criteria andEmployeeidIsNotNull() {
            addCriterion("EmployeeId is not null");
            return (Criteria) this;
        }

        public Criteria andEmployeeidEqualTo(Integer value) {
            addCriterion("EmployeeId =", value, "employeeid");
            return (Criteria) this;
        }

        public Criteria andEmployeeidNotEqualTo(Integer value) {
            addCriterion("EmployeeId <>", value, "employeeid");
            return (Criteria) this;
        }

        public Criteria andEmployeeidGreaterThan(Integer value) {
            addCriterion("EmployeeId >", value, "employeeid");
            return (Criteria) this;
        }

        public Criteria andEmployeeidGreaterThanOrEqualTo(Integer value) {
            addCriterion("EmployeeId >=", value, "employeeid");
            return (Criteria) this;
        }

        public Criteria andEmployeeidLessThan(Integer value) {
            addCriterion("EmployeeId <", value, "employeeid");
            return (Criteria) this;
        }

        public Criteria andEmployeeidLessThanOrEqualTo(Integer value) {
            addCriterion("EmployeeId <=", value, "employeeid");
            return (Criteria) this;
        }

        public Criteria andEmployeeidIn(List<Integer> values) {
            addCriterion("EmployeeId in", values, "employeeid");
            return (Criteria) this;
        }

        public Criteria andEmployeeidNotIn(List<Integer> values) {
            addCriterion("EmployeeId not in", values, "employeeid");
            return (Criteria) this;
        }

        public Criteria andEmployeeidBetween(Integer value1, Integer value2) {
            addCriterion("EmployeeId between", value1, value2, "employeeid");
            return (Criteria) this;
        }

        public Criteria andEmployeeidNotBetween(Integer value1, Integer value2) {
            addCriterion("EmployeeId not between", value1, value2, "employeeid");
            return (Criteria) this;
        }

        public Criteria andEcodeIsNull() {
            addCriterion("eCode is null");
            return (Criteria) this;
        }

        public Criteria andEcodeIsNotNull() {
            addCriterion("eCode is not null");
            return (Criteria) this;
        }

        public Criteria andEcodeEqualTo(String value) {
            addCriterion("eCode =", value, "ecode");
            return (Criteria) this;
        }

        public Criteria andEcodeNotEqualTo(String value) {
            addCriterion("eCode <>", value, "ecode");
            return (Criteria) this;
        }

        public Criteria andEcodeGreaterThan(String value) {
            addCriterion("eCode >", value, "ecode");
            return (Criteria) this;
        }

        public Criteria andEcodeGreaterThanOrEqualTo(String value) {
            addCriterion("eCode >=", value, "ecode");
            return (Criteria) this;
        }

        public Criteria andEcodeLessThan(String value) {
            addCriterion("eCode <", value, "ecode");
            return (Criteria) this;
        }

        public Criteria andEcodeLessThanOrEqualTo(String value) {
            addCriterion("eCode <=", value, "ecode");
            return (Criteria) this;
        }

        public Criteria andEcodeLike(String value) {
            addCriterion("eCode like", value, "ecode");
            return (Criteria) this;
        }

        public Criteria andEcodeNotLike(String value) {
            addCriterion("eCode not like", value, "ecode");
            return (Criteria) this;
        }

        public Criteria andEcodeIn(List<String> values) {
            addCriterion("eCode in", values, "ecode");
            return (Criteria) this;
        }

        public Criteria andEcodeNotIn(List<String> values) {
            addCriterion("eCode not in", values, "ecode");
            return (Criteria) this;
        }

        public Criteria andEcodeBetween(String value1, String value2) {
            addCriterion("eCode between", value1, value2, "ecode");
            return (Criteria) this;
        }

        public Criteria andEcodeNotBetween(String value1, String value2) {
            addCriterion("eCode not between", value1, value2, "ecode");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNull() {
            addCriterion("userName is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("userName is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("userName =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("userName <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("userName >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("userName >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("userName <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("userName <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("userName like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("userName not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("userName in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("userName not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("userName between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("userName not between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andCnnameIsNull() {
            addCriterion("CnName is null");
            return (Criteria) this;
        }

        public Criteria andCnnameIsNotNull() {
            addCriterion("CnName is not null");
            return (Criteria) this;
        }

        public Criteria andCnnameEqualTo(String value) {
            addCriterion("CnName =", value, "cnname");
            return (Criteria) this;
        }

        public Criteria andCnnameNotEqualTo(String value) {
            addCriterion("CnName <>", value, "cnname");
            return (Criteria) this;
        }

        public Criteria andCnnameGreaterThan(String value) {
            addCriterion("CnName >", value, "cnname");
            return (Criteria) this;
        }

        public Criteria andCnnameGreaterThanOrEqualTo(String value) {
            addCriterion("CnName >=", value, "cnname");
            return (Criteria) this;
        }

        public Criteria andCnnameLessThan(String value) {
            addCriterion("CnName <", value, "cnname");
            return (Criteria) this;
        }

        public Criteria andCnnameLessThanOrEqualTo(String value) {
            addCriterion("CnName <=", value, "cnname");
            return (Criteria) this;
        }

        public Criteria andCnnameLike(String value) {
            addCriterion("CnName like", value, "cnname");
            return (Criteria) this;
        }

        public Criteria andCnnameNotLike(String value) {
            addCriterion("CnName not like", value, "cnname");
            return (Criteria) this;
        }

        public Criteria andCnnameIn(List<String> values) {
            addCriterion("CnName in", values, "cnname");
            return (Criteria) this;
        }

        public Criteria andCnnameNotIn(List<String> values) {
            addCriterion("CnName not in", values, "cnname");
            return (Criteria) this;
        }

        public Criteria andCnnameBetween(String value1, String value2) {
            addCriterion("CnName between", value1, value2, "cnname");
            return (Criteria) this;
        }

        public Criteria andCnnameNotBetween(String value1, String value2) {
            addCriterion("CnName not between", value1, value2, "cnname");
            return (Criteria) this;
        }

        public Criteria andGenderidIsNull() {
            addCriterion("GenderId is null");
            return (Criteria) this;
        }

        public Criteria andGenderidIsNotNull() {
            addCriterion("GenderId is not null");
            return (Criteria) this;
        }

        public Criteria andGenderidEqualTo(String value) {
            addCriterion("GenderId =", value, "genderid");
            return (Criteria) this;
        }

        public Criteria andGenderidNotEqualTo(String value) {
            addCriterion("GenderId <>", value, "genderid");
            return (Criteria) this;
        }

        public Criteria andGenderidGreaterThan(String value) {
            addCriterion("GenderId >", value, "genderid");
            return (Criteria) this;
        }

        public Criteria andGenderidGreaterThanOrEqualTo(String value) {
            addCriterion("GenderId >=", value, "genderid");
            return (Criteria) this;
        }

        public Criteria andGenderidLessThan(String value) {
            addCriterion("GenderId <", value, "genderid");
            return (Criteria) this;
        }

        public Criteria andGenderidLessThanOrEqualTo(String value) {
            addCriterion("GenderId <=", value, "genderid");
            return (Criteria) this;
        }

        public Criteria andGenderidLike(String value) {
            addCriterion("GenderId like", value, "genderid");
            return (Criteria) this;
        }

        public Criteria andGenderidNotLike(String value) {
            addCriterion("GenderId not like", value, "genderid");
            return (Criteria) this;
        }

        public Criteria andGenderidIn(List<String> values) {
            addCriterion("GenderId in", values, "genderid");
            return (Criteria) this;
        }

        public Criteria andGenderidNotIn(List<String> values) {
            addCriterion("GenderId not in", values, "genderid");
            return (Criteria) this;
        }

        public Criteria andGenderidBetween(String value1, String value2) {
            addCriterion("GenderId between", value1, value2, "genderid");
            return (Criteria) this;
        }

        public Criteria andGenderidNotBetween(String value1, String value2) {
            addCriterion("GenderId not between", value1, value2, "genderid");
            return (Criteria) this;
        }

        public Criteria andTelephoneIsNull() {
            addCriterion("Telephone is null");
            return (Criteria) this;
        }

        public Criteria andTelephoneIsNotNull() {
            addCriterion("Telephone is not null");
            return (Criteria) this;
        }

        public Criteria andTelephoneEqualTo(String value) {
            addCriterion("Telephone =", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotEqualTo(String value) {
            addCriterion("Telephone <>", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneGreaterThan(String value) {
            addCriterion("Telephone >", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneGreaterThanOrEqualTo(String value) {
            addCriterion("Telephone >=", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLessThan(String value) {
            addCriterion("Telephone <", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLessThanOrEqualTo(String value) {
            addCriterion("Telephone <=", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLike(String value) {
            addCriterion("Telephone like", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotLike(String value) {
            addCriterion("Telephone not like", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneIn(List<String> values) {
            addCriterion("Telephone in", values, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotIn(List<String> values) {
            addCriterion("Telephone not in", values, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneBetween(String value1, String value2) {
            addCriterion("Telephone between", value1, value2, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotBetween(String value1, String value2) {
            addCriterion("Telephone not between", value1, value2, "telephone");
            return (Criteria) this;
        }

        public Criteria andMobilephoneIsNull() {
            addCriterion("MobilePhone is null");
            return (Criteria) this;
        }

        public Criteria andMobilephoneIsNotNull() {
            addCriterion("MobilePhone is not null");
            return (Criteria) this;
        }

        public Criteria andMobilephoneEqualTo(String value) {
            addCriterion("MobilePhone =", value, "mobilephone");
            return (Criteria) this;
        }

        public Criteria andMobilephoneNotEqualTo(String value) {
            addCriterion("MobilePhone <>", value, "mobilephone");
            return (Criteria) this;
        }

        public Criteria andMobilephoneGreaterThan(String value) {
            addCriterion("MobilePhone >", value, "mobilephone");
            return (Criteria) this;
        }

        public Criteria andMobilephoneGreaterThanOrEqualTo(String value) {
            addCriterion("MobilePhone >=", value, "mobilephone");
            return (Criteria) this;
        }

        public Criteria andMobilephoneLessThan(String value) {
            addCriterion("MobilePhone <", value, "mobilephone");
            return (Criteria) this;
        }

        public Criteria andMobilephoneLessThanOrEqualTo(String value) {
            addCriterion("MobilePhone <=", value, "mobilephone");
            return (Criteria) this;
        }

        public Criteria andMobilephoneLike(String value) {
            addCriterion("MobilePhone like", value, "mobilephone");
            return (Criteria) this;
        }

        public Criteria andMobilephoneNotLike(String value) {
            addCriterion("MobilePhone not like", value, "mobilephone");
            return (Criteria) this;
        }

        public Criteria andMobilephoneIn(List<String> values) {
            addCriterion("MobilePhone in", values, "mobilephone");
            return (Criteria) this;
        }

        public Criteria andMobilephoneNotIn(List<String> values) {
            addCriterion("MobilePhone not in", values, "mobilephone");
            return (Criteria) this;
        }

        public Criteria andMobilephoneBetween(String value1, String value2) {
            addCriterion("MobilePhone between", value1, value2, "mobilephone");
            return (Criteria) this;
        }

        public Criteria andMobilephoneNotBetween(String value1, String value2) {
            addCriterion("MobilePhone not between", value1, value2, "mobilephone");
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

        public Criteria andPasswordIsNull() {
            addCriterion("Password is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("Password is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("Password =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("Password <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("Password >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("Password >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("Password <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("Password <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("Password like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("Password not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("Password in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("Password not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("Password between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("Password not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andIsprincipalIsNull() {
            addCriterion("IsPrincipal is null");
            return (Criteria) this;
        }

        public Criteria andIsprincipalIsNotNull() {
            addCriterion("IsPrincipal is not null");
            return (Criteria) this;
        }

        public Criteria andIsprincipalEqualTo(Boolean value) {
            addCriterion("IsPrincipal =", value, "isprincipal");
            return (Criteria) this;
        }

        public Criteria andIsprincipalNotEqualTo(Boolean value) {
            addCriterion("IsPrincipal <>", value, "isprincipal");
            return (Criteria) this;
        }

        public Criteria andIsprincipalGreaterThan(Boolean value) {
            addCriterion("IsPrincipal >", value, "isprincipal");
            return (Criteria) this;
        }

        public Criteria andIsprincipalGreaterThanOrEqualTo(Boolean value) {
            addCriterion("IsPrincipal >=", value, "isprincipal");
            return (Criteria) this;
        }

        public Criteria andIsprincipalLessThan(Boolean value) {
            addCriterion("IsPrincipal <", value, "isprincipal");
            return (Criteria) this;
        }

        public Criteria andIsprincipalLessThanOrEqualTo(Boolean value) {
            addCriterion("IsPrincipal <=", value, "isprincipal");
            return (Criteria) this;
        }

        public Criteria andIsprincipalIn(List<Boolean> values) {
            addCriterion("IsPrincipal in", values, "isprincipal");
            return (Criteria) this;
        }

        public Criteria andIsprincipalNotIn(List<Boolean> values) {
            addCriterion("IsPrincipal not in", values, "isprincipal");
            return (Criteria) this;
        }

        public Criteria andIsprincipalBetween(Boolean value1, Boolean value2) {
            addCriterion("IsPrincipal between", value1, value2, "isprincipal");
            return (Criteria) this;
        }

        public Criteria andIsprincipalNotBetween(Boolean value1, Boolean value2) {
            addCriterion("IsPrincipal not between", value1, value2, "isprincipal");
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

        public Criteria andOrgcodeIsNull() {
            addCriterion("orgCode is null");
            return (Criteria) this;
        }

        public Criteria andOrgcodeIsNotNull() {
            addCriterion("orgCode is not null");
            return (Criteria) this;
        }

        public Criteria andOrgcodeEqualTo(String value) {
            addCriterion("orgCode =", value, "orgcode");
            return (Criteria) this;
        }

        public Criteria andOrgcodeNotEqualTo(String value) {
            addCriterion("orgCode <>", value, "orgcode");
            return (Criteria) this;
        }

        public Criteria andOrgcodeGreaterThan(String value) {
            addCriterion("orgCode >", value, "orgcode");
            return (Criteria) this;
        }

        public Criteria andOrgcodeGreaterThanOrEqualTo(String value) {
            addCriterion("orgCode >=", value, "orgcode");
            return (Criteria) this;
        }

        public Criteria andOrgcodeLessThan(String value) {
            addCriterion("orgCode <", value, "orgcode");
            return (Criteria) this;
        }

        public Criteria andOrgcodeLessThanOrEqualTo(String value) {
            addCriterion("orgCode <=", value, "orgcode");
            return (Criteria) this;
        }

        public Criteria andOrgcodeLike(String value) {
            addCriterion("orgCode like", value, "orgcode");
            return (Criteria) this;
        }

        public Criteria andOrgcodeNotLike(String value) {
            addCriterion("orgCode not like", value, "orgcode");
            return (Criteria) this;
        }

        public Criteria andOrgcodeIn(List<String> values) {
            addCriterion("orgCode in", values, "orgcode");
            return (Criteria) this;
        }

        public Criteria andOrgcodeNotIn(List<String> values) {
            addCriterion("orgCode not in", values, "orgcode");
            return (Criteria) this;
        }

        public Criteria andOrgcodeBetween(String value1, String value2) {
            addCriterion("orgCode between", value1, value2, "orgcode");
            return (Criteria) this;
        }

        public Criteria andOrgcodeNotBetween(String value1, String value2) {
            addCriterion("orgCode not between", value1, value2, "orgcode");
            return (Criteria) this;
        }

        public Criteria andOrgnameIsNull() {
            addCriterion("orgName is null");
            return (Criteria) this;
        }

        public Criteria andOrgnameIsNotNull() {
            addCriterion("orgName is not null");
            return (Criteria) this;
        }

        public Criteria andOrgnameEqualTo(String value) {
            addCriterion("orgName =", value, "orgname");
            return (Criteria) this;
        }

        public Criteria andOrgnameNotEqualTo(String value) {
            addCriterion("orgName <>", value, "orgname");
            return (Criteria) this;
        }

        public Criteria andOrgnameGreaterThan(String value) {
            addCriterion("orgName >", value, "orgname");
            return (Criteria) this;
        }

        public Criteria andOrgnameGreaterThanOrEqualTo(String value) {
            addCriterion("orgName >=", value, "orgname");
            return (Criteria) this;
        }

        public Criteria andOrgnameLessThan(String value) {
            addCriterion("orgName <", value, "orgname");
            return (Criteria) this;
        }

        public Criteria andOrgnameLessThanOrEqualTo(String value) {
            addCriterion("orgName <=", value, "orgname");
            return (Criteria) this;
        }

        public Criteria andOrgnameLike(String value) {
            addCriterion("orgName like", value, "orgname");
            return (Criteria) this;
        }

        public Criteria andOrgnameNotLike(String value) {
            addCriterion("orgName not like", value, "orgname");
            return (Criteria) this;
        }

        public Criteria andOrgnameIn(List<String> values) {
            addCriterion("orgName in", values, "orgname");
            return (Criteria) this;
        }

        public Criteria andOrgnameNotIn(List<String> values) {
            addCriterion("orgName not in", values, "orgname");
            return (Criteria) this;
        }

        public Criteria andOrgnameBetween(String value1, String value2) {
            addCriterion("orgName between", value1, value2, "orgname");
            return (Criteria) this;
        }

        public Criteria andOrgnameNotBetween(String value1, String value2) {
            addCriterion("orgName not between", value1, value2, "orgname");
            return (Criteria) this;
        }

        public Criteria andCompanycodeIsNull() {
            addCriterion("companyCode is null");
            return (Criteria) this;
        }

        public Criteria andCompanycodeIsNotNull() {
            addCriterion("companyCode is not null");
            return (Criteria) this;
        }

        public Criteria andCompanycodeEqualTo(String value) {
            addCriterion("companyCode =", value, "companycode");
            return (Criteria) this;
        }

        public Criteria andCompanycodeNotEqualTo(String value) {
            addCriterion("companyCode <>", value, "companycode");
            return (Criteria) this;
        }

        public Criteria andCompanycodeGreaterThan(String value) {
            addCriterion("companyCode >", value, "companycode");
            return (Criteria) this;
        }

        public Criteria andCompanycodeGreaterThanOrEqualTo(String value) {
            addCriterion("companyCode >=", value, "companycode");
            return (Criteria) this;
        }

        public Criteria andCompanycodeLessThan(String value) {
            addCriterion("companyCode <", value, "companycode");
            return (Criteria) this;
        }

        public Criteria andCompanycodeLessThanOrEqualTo(String value) {
            addCriterion("companyCode <=", value, "companycode");
            return (Criteria) this;
        }

        public Criteria andCompanycodeLike(String value) {
            addCriterion("companyCode like", value, "companycode");
            return (Criteria) this;
        }

        public Criteria andCompanycodeNotLike(String value) {
            addCriterion("companyCode not like", value, "companycode");
            return (Criteria) this;
        }

        public Criteria andCompanycodeIn(List<String> values) {
            addCriterion("companyCode in", values, "companycode");
            return (Criteria) this;
        }

        public Criteria andCompanycodeNotIn(List<String> values) {
            addCriterion("companyCode not in", values, "companycode");
            return (Criteria) this;
        }

        public Criteria andCompanycodeBetween(String value1, String value2) {
            addCriterion("companyCode between", value1, value2, "companycode");
            return (Criteria) this;
        }

        public Criteria andCompanycodeNotBetween(String value1, String value2) {
            addCriterion("companyCode not between", value1, value2, "companycode");
            return (Criteria) this;
        }

        public Criteria andCompanynameIsNull() {
            addCriterion("companyName is null");
            return (Criteria) this;
        }

        public Criteria andCompanynameIsNotNull() {
            addCriterion("companyName is not null");
            return (Criteria) this;
        }

        public Criteria andCompanynameEqualTo(String value) {
            addCriterion("companyName =", value, "companyname");
            return (Criteria) this;
        }

        public Criteria andCompanynameNotEqualTo(String value) {
            addCriterion("companyName <>", value, "companyname");
            return (Criteria) this;
        }

        public Criteria andCompanynameGreaterThan(String value) {
            addCriterion("companyName >", value, "companyname");
            return (Criteria) this;
        }

        public Criteria andCompanynameGreaterThanOrEqualTo(String value) {
            addCriterion("companyName >=", value, "companyname");
            return (Criteria) this;
        }

        public Criteria andCompanynameLessThan(String value) {
            addCriterion("companyName <", value, "companyname");
            return (Criteria) this;
        }

        public Criteria andCompanynameLessThanOrEqualTo(String value) {
            addCriterion("companyName <=", value, "companyname");
            return (Criteria) this;
        }

        public Criteria andCompanynameLike(String value) {
            addCriterion("companyName like", value, "companyname");
            return (Criteria) this;
        }

        public Criteria andCompanynameNotLike(String value) {
            addCriterion("companyName not like", value, "companyname");
            return (Criteria) this;
        }

        public Criteria andCompanynameIn(List<String> values) {
            addCriterion("companyName in", values, "companyname");
            return (Criteria) this;
        }

        public Criteria andCompanynameNotIn(List<String> values) {
            addCriterion("companyName not in", values, "companyname");
            return (Criteria) this;
        }

        public Criteria andCompanynameBetween(String value1, String value2) {
            addCriterion("companyName between", value1, value2, "companyname");
            return (Criteria) this;
        }

        public Criteria andCompanynameNotBetween(String value1, String value2) {
            addCriterion("companyName not between", value1, value2, "companyname");
            return (Criteria) this;
        }

        public Criteria andJobcodeIsNull() {
            addCriterion("jobCode is null");
            return (Criteria) this;
        }

        public Criteria andJobcodeIsNotNull() {
            addCriterion("jobCode is not null");
            return (Criteria) this;
        }

        public Criteria andJobcodeEqualTo(String value) {
            addCriterion("jobCode =", value, "jobcode");
            return (Criteria) this;
        }

        public Criteria andJobcodeNotEqualTo(String value) {
            addCriterion("jobCode <>", value, "jobcode");
            return (Criteria) this;
        }

        public Criteria andJobcodeGreaterThan(String value) {
            addCriterion("jobCode >", value, "jobcode");
            return (Criteria) this;
        }

        public Criteria andJobcodeGreaterThanOrEqualTo(String value) {
            addCriterion("jobCode >=", value, "jobcode");
            return (Criteria) this;
        }

        public Criteria andJobcodeLessThan(String value) {
            addCriterion("jobCode <", value, "jobcode");
            return (Criteria) this;
        }

        public Criteria andJobcodeLessThanOrEqualTo(String value) {
            addCriterion("jobCode <=", value, "jobcode");
            return (Criteria) this;
        }

        public Criteria andJobcodeLike(String value) {
            addCriterion("jobCode like", value, "jobcode");
            return (Criteria) this;
        }

        public Criteria andJobcodeNotLike(String value) {
            addCriterion("jobCode not like", value, "jobcode");
            return (Criteria) this;
        }

        public Criteria andJobcodeIn(List<String> values) {
            addCriterion("jobCode in", values, "jobcode");
            return (Criteria) this;
        }

        public Criteria andJobcodeNotIn(List<String> values) {
            addCriterion("jobCode not in", values, "jobcode");
            return (Criteria) this;
        }

        public Criteria andJobcodeBetween(String value1, String value2) {
            addCriterion("jobCode between", value1, value2, "jobcode");
            return (Criteria) this;
        }

        public Criteria andJobcodeNotBetween(String value1, String value2) {
            addCriterion("jobCode not between", value1, value2, "jobcode");
            return (Criteria) this;
        }

        public Criteria andJobnameIsNull() {
            addCriterion("jobName is null");
            return (Criteria) this;
        }

        public Criteria andJobnameIsNotNull() {
            addCriterion("jobName is not null");
            return (Criteria) this;
        }

        public Criteria andJobnameEqualTo(String value) {
            addCriterion("jobName =", value, "jobname");
            return (Criteria) this;
        }

        public Criteria andJobnameNotEqualTo(String value) {
            addCriterion("jobName <>", value, "jobname");
            return (Criteria) this;
        }

        public Criteria andJobnameGreaterThan(String value) {
            addCriterion("jobName >", value, "jobname");
            return (Criteria) this;
        }

        public Criteria andJobnameGreaterThanOrEqualTo(String value) {
            addCriterion("jobName >=", value, "jobname");
            return (Criteria) this;
        }

        public Criteria andJobnameLessThan(String value) {
            addCriterion("jobName <", value, "jobname");
            return (Criteria) this;
        }

        public Criteria andJobnameLessThanOrEqualTo(String value) {
            addCriterion("jobName <=", value, "jobname");
            return (Criteria) this;
        }

        public Criteria andJobnameLike(String value) {
            addCriterion("jobName like", value, "jobname");
            return (Criteria) this;
        }

        public Criteria andJobnameNotLike(String value) {
            addCriterion("jobName not like", value, "jobname");
            return (Criteria) this;
        }

        public Criteria andJobnameIn(List<String> values) {
            addCriterion("jobName in", values, "jobname");
            return (Criteria) this;
        }

        public Criteria andJobnameNotIn(List<String> values) {
            addCriterion("jobName not in", values, "jobname");
            return (Criteria) this;
        }

        public Criteria andJobnameBetween(String value1, String value2) {
            addCriterion("jobName between", value1, value2, "jobname");
            return (Criteria) this;
        }

        public Criteria andJobnameNotBetween(String value1, String value2) {
            addCriterion("jobName not between", value1, value2, "jobname");
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

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andLastloginipIsNull() {
            addCriterion("lastloginip is null");
            return (Criteria) this;
        }

        public Criteria andLastloginipIsNotNull() {
            addCriterion("lastloginip is not null");
            return (Criteria) this;
        }

        public Criteria andLastloginipEqualTo(String value) {
            addCriterion("lastloginip =", value, "lastloginip");
            return (Criteria) this;
        }

        public Criteria andLastloginipNotEqualTo(String value) {
            addCriterion("lastloginip <>", value, "lastloginip");
            return (Criteria) this;
        }

        public Criteria andLastloginipGreaterThan(String value) {
            addCriterion("lastloginip >", value, "lastloginip");
            return (Criteria) this;
        }

        public Criteria andLastloginipGreaterThanOrEqualTo(String value) {
            addCriterion("lastloginip >=", value, "lastloginip");
            return (Criteria) this;
        }

        public Criteria andLastloginipLessThan(String value) {
            addCriterion("lastloginip <", value, "lastloginip");
            return (Criteria) this;
        }

        public Criteria andLastloginipLessThanOrEqualTo(String value) {
            addCriterion("lastloginip <=", value, "lastloginip");
            return (Criteria) this;
        }

        public Criteria andLastloginipLike(String value) {
            addCriterion("lastloginip like", value, "lastloginip");
            return (Criteria) this;
        }

        public Criteria andLastloginipNotLike(String value) {
            addCriterion("lastloginip not like", value, "lastloginip");
            return (Criteria) this;
        }

        public Criteria andLastloginipIn(List<String> values) {
            addCriterion("lastloginip in", values, "lastloginip");
            return (Criteria) this;
        }

        public Criteria andLastloginipNotIn(List<String> values) {
            addCriterion("lastloginip not in", values, "lastloginip");
            return (Criteria) this;
        }

        public Criteria andLastloginipBetween(String value1, String value2) {
            addCriterion("lastloginip between", value1, value2, "lastloginip");
            return (Criteria) this;
        }

        public Criteria andLastloginipNotBetween(String value1, String value2) {
            addCriterion("lastloginip not between", value1, value2, "lastloginip");
            return (Criteria) this;
        }

        public Criteria andLastlogindateIsNull() {
            addCriterion("lastLoginDate is null");
            return (Criteria) this;
        }

        public Criteria andLastlogindateIsNotNull() {
            addCriterion("lastLoginDate is not null");
            return (Criteria) this;
        }

        public Criteria andLastlogindateEqualTo(Date value) {
            addCriterion("lastLoginDate =", value, "lastlogindate");
            return (Criteria) this;
        }

        public Criteria andLastlogindateNotEqualTo(Date value) {
            addCriterion("lastLoginDate <>", value, "lastlogindate");
            return (Criteria) this;
        }

        public Criteria andLastlogindateGreaterThan(Date value) {
            addCriterion("lastLoginDate >", value, "lastlogindate");
            return (Criteria) this;
        }

        public Criteria andLastlogindateGreaterThanOrEqualTo(Date value) {
            addCriterion("lastLoginDate >=", value, "lastlogindate");
            return (Criteria) this;
        }

        public Criteria andLastlogindateLessThan(Date value) {
            addCriterion("lastLoginDate <", value, "lastlogindate");
            return (Criteria) this;
        }

        public Criteria andLastlogindateLessThanOrEqualTo(Date value) {
            addCriterion("lastLoginDate <=", value, "lastlogindate");
            return (Criteria) this;
        }

        public Criteria andLastlogindateIn(List<Date> values) {
            addCriterion("lastLoginDate in", values, "lastlogindate");
            return (Criteria) this;
        }

        public Criteria andLastlogindateNotIn(List<Date> values) {
            addCriterion("lastLoginDate not in", values, "lastlogindate");
            return (Criteria) this;
        }

        public Criteria andLastlogindateBetween(Date value1, Date value2) {
            addCriterion("lastLoginDate between", value1, value2, "lastlogindate");
            return (Criteria) this;
        }

        public Criteria andLastlogindateNotBetween(Date value1, Date value2) {
            addCriterion("lastLoginDate not between", value1, value2, "lastlogindate");
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

        public Criteria andLastmodifieddateIsNull() {
            addCriterion("LastModifiedDate is null");
            return (Criteria) this;
        }

        public Criteria andLastmodifieddateIsNotNull() {
            addCriterion("LastModifiedDate is not null");
            return (Criteria) this;
        }

        public Criteria andLastmodifieddateEqualTo(Date value) {
            addCriterion("LastModifiedDate =", value, "lastmodifieddate");
            return (Criteria) this;
        }

        public Criteria andLastmodifieddateNotEqualTo(Date value) {
            addCriterion("LastModifiedDate <>", value, "lastmodifieddate");
            return (Criteria) this;
        }

        public Criteria andLastmodifieddateGreaterThan(Date value) {
            addCriterion("LastModifiedDate >", value, "lastmodifieddate");
            return (Criteria) this;
        }

        public Criteria andLastmodifieddateGreaterThanOrEqualTo(Date value) {
            addCriterion("LastModifiedDate >=", value, "lastmodifieddate");
            return (Criteria) this;
        }

        public Criteria andLastmodifieddateLessThan(Date value) {
            addCriterion("LastModifiedDate <", value, "lastmodifieddate");
            return (Criteria) this;
        }

        public Criteria andLastmodifieddateLessThanOrEqualTo(Date value) {
            addCriterion("LastModifiedDate <=", value, "lastmodifieddate");
            return (Criteria) this;
        }

        public Criteria andLastmodifieddateIn(List<Date> values) {
            addCriterion("LastModifiedDate in", values, "lastmodifieddate");
            return (Criteria) this;
        }

        public Criteria andLastmodifieddateNotIn(List<Date> values) {
            addCriterion("LastModifiedDate not in", values, "lastmodifieddate");
            return (Criteria) this;
        }

        public Criteria andLastmodifieddateBetween(Date value1, Date value2) {
            addCriterion("LastModifiedDate between", value1, value2, "lastmodifieddate");
            return (Criteria) this;
        }

        public Criteria andLastmodifieddateNotBetween(Date value1, Date value2) {
            addCriterion("LastModifiedDate not between", value1, value2, "lastmodifieddate");
            return (Criteria) this;
        }

        public Criteria andCreatebyIsNull() {
            addCriterion("CreateBy is null");
            return (Criteria) this;
        }

        public Criteria andCreatebyIsNotNull() {
            addCriterion("CreateBy is not null");
            return (Criteria) this;
        }

        public Criteria andCreatebyEqualTo(String value) {
            addCriterion("CreateBy =", value, "createby");
            return (Criteria) this;
        }

        public Criteria andCreatebyNotEqualTo(String value) {
            addCriterion("CreateBy <>", value, "createby");
            return (Criteria) this;
        }

        public Criteria andCreatebyGreaterThan(String value) {
            addCriterion("CreateBy >", value, "createby");
            return (Criteria) this;
        }

        public Criteria andCreatebyGreaterThanOrEqualTo(String value) {
            addCriterion("CreateBy >=", value, "createby");
            return (Criteria) this;
        }

        public Criteria andCreatebyLessThan(String value) {
            addCriterion("CreateBy <", value, "createby");
            return (Criteria) this;
        }

        public Criteria andCreatebyLessThanOrEqualTo(String value) {
            addCriterion("CreateBy <=", value, "createby");
            return (Criteria) this;
        }

        public Criteria andCreatebyLike(String value) {
            addCriterion("CreateBy like", value, "createby");
            return (Criteria) this;
        }

        public Criteria andCreatebyNotLike(String value) {
            addCriterion("CreateBy not like", value, "createby");
            return (Criteria) this;
        }

        public Criteria andCreatebyIn(List<String> values) {
            addCriterion("CreateBy in", values, "createby");
            return (Criteria) this;
        }

        public Criteria andCreatebyNotIn(List<String> values) {
            addCriterion("CreateBy not in", values, "createby");
            return (Criteria) this;
        }

        public Criteria andCreatebyBetween(String value1, String value2) {
            addCriterion("CreateBy between", value1, value2, "createby");
            return (Criteria) this;
        }

        public Criteria andCreatebyNotBetween(String value1, String value2) {
            addCriterion("CreateBy not between", value1, value2, "createby");
            return (Criteria) this;
        }

        public Criteria andLastmodifiedbyIsNull() {
            addCriterion("LastModifiedBy is null");
            return (Criteria) this;
        }

        public Criteria andLastmodifiedbyIsNotNull() {
            addCriterion("LastModifiedBy is not null");
            return (Criteria) this;
        }

        public Criteria andLastmodifiedbyEqualTo(String value) {
            addCriterion("LastModifiedBy =", value, "lastmodifiedby");
            return (Criteria) this;
        }

        public Criteria andLastmodifiedbyNotEqualTo(String value) {
            addCriterion("LastModifiedBy <>", value, "lastmodifiedby");
            return (Criteria) this;
        }

        public Criteria andLastmodifiedbyGreaterThan(String value) {
            addCriterion("LastModifiedBy >", value, "lastmodifiedby");
            return (Criteria) this;
        }

        public Criteria andLastmodifiedbyGreaterThanOrEqualTo(String value) {
            addCriterion("LastModifiedBy >=", value, "lastmodifiedby");
            return (Criteria) this;
        }

        public Criteria andLastmodifiedbyLessThan(String value) {
            addCriterion("LastModifiedBy <", value, "lastmodifiedby");
            return (Criteria) this;
        }

        public Criteria andLastmodifiedbyLessThanOrEqualTo(String value) {
            addCriterion("LastModifiedBy <=", value, "lastmodifiedby");
            return (Criteria) this;
        }

        public Criteria andLastmodifiedbyLike(String value) {
            addCriterion("LastModifiedBy like", value, "lastmodifiedby");
            return (Criteria) this;
        }

        public Criteria andLastmodifiedbyNotLike(String value) {
            addCriterion("LastModifiedBy not like", value, "lastmodifiedby");
            return (Criteria) this;
        }

        public Criteria andLastmodifiedbyIn(List<String> values) {
            addCriterion("LastModifiedBy in", values, "lastmodifiedby");
            return (Criteria) this;
        }

        public Criteria andLastmodifiedbyNotIn(List<String> values) {
            addCriterion("LastModifiedBy not in", values, "lastmodifiedby");
            return (Criteria) this;
        }

        public Criteria andLastmodifiedbyBetween(String value1, String value2) {
            addCriterion("LastModifiedBy between", value1, value2, "lastmodifiedby");
            return (Criteria) this;
        }

        public Criteria andLastmodifiedbyNotBetween(String value1, String value2) {
            addCriterion("LastModifiedBy not between", value1, value2, "lastmodifiedby");
            return (Criteria) this;
        }

        public Criteria andFlagIsNull() {
            addCriterion("Flag is null");
            return (Criteria) this;
        }

        public Criteria andFlagIsNotNull() {
            addCriterion("Flag is not null");
            return (Criteria) this;
        }

        public Criteria andFlagEqualTo(Integer value) {
            addCriterion("Flag =", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotEqualTo(Integer value) {
            addCriterion("Flag <>", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagGreaterThan(Integer value) {
            addCriterion("Flag >", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("Flag >=", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLessThan(Integer value) {
            addCriterion("Flag <", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLessThanOrEqualTo(Integer value) {
            addCriterion("Flag <=", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagIn(List<Integer> values) {
            addCriterion("Flag in", values, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotIn(List<Integer> values) {
            addCriterion("Flag not in", values, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagBetween(Integer value1, Integer value2) {
            addCriterion("Flag between", value1, value2, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("Flag not between", value1, value2, "flag");
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

        public Criteria andQqIsNull() {
            addCriterion("qq is null");
            return (Criteria) this;
        }

        public Criteria andQqIsNotNull() {
            addCriterion("qq is not null");
            return (Criteria) this;
        }

        public Criteria andQqEqualTo(String value) {
            addCriterion("qq =", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqNotEqualTo(String value) {
            addCriterion("qq <>", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqGreaterThan(String value) {
            addCriterion("qq >", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqGreaterThanOrEqualTo(String value) {
            addCriterion("qq >=", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqLessThan(String value) {
            addCriterion("qq <", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqLessThanOrEqualTo(String value) {
            addCriterion("qq <=", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqLike(String value) {
            addCriterion("qq like", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqNotLike(String value) {
            addCriterion("qq not like", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqIn(List<String> values) {
            addCriterion("qq in", values, "qq");
            return (Criteria) this;
        }

        public Criteria andQqNotIn(List<String> values) {
            addCriterion("qq not in", values, "qq");
            return (Criteria) this;
        }

        public Criteria andQqBetween(String value1, String value2) {
            addCriterion("qq between", value1, value2, "qq");
            return (Criteria) this;
        }

        public Criteria andQqNotBetween(String value1, String value2) {
            addCriterion("qq not between", value1, value2, "qq");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andIdentityIsNull() {
            addCriterion("identity is null");
            return (Criteria) this;
        }

        public Criteria andIdentityIsNotNull() {
            addCriterion("identity is not null");
            return (Criteria) this;
        }

        public Criteria andIdentityEqualTo(String value) {
            addCriterion("identity =", value, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityNotEqualTo(String value) {
            addCriterion("identity <>", value, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityGreaterThan(String value) {
            addCriterion("identity >", value, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityGreaterThanOrEqualTo(String value) {
            addCriterion("identity >=", value, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityLessThan(String value) {
            addCriterion("identity <", value, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityLessThanOrEqualTo(String value) {
            addCriterion("identity <=", value, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityLike(String value) {
            addCriterion("identity like", value, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityNotLike(String value) {
            addCriterion("identity not like", value, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityIn(List<String> values) {
            addCriterion("identity in", values, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityNotIn(List<String> values) {
            addCriterion("identity not in", values, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityBetween(String value1, String value2) {
            addCriterion("identity between", value1, value2, "identity");
            return (Criteria) this;
        }

        public Criteria andIdentityNotBetween(String value1, String value2) {
            addCriterion("identity not between", value1, value2, "identity");
            return (Criteria) this;
        }

        public Criteria andSendsystemIsNull() {
            addCriterion("sendSystem is null");
            return (Criteria) this;
        }

        public Criteria andSendsystemIsNotNull() {
            addCriterion("sendSystem is not null");
            return (Criteria) this;
        }

        public Criteria andSendsystemEqualTo(String value) {
            addCriterion("sendSystem =", value, "sendsystem");
            return (Criteria) this;
        }

        public Criteria andSendsystemNotEqualTo(String value) {
            addCriterion("sendSystem <>", value, "sendsystem");
            return (Criteria) this;
        }

        public Criteria andSendsystemGreaterThan(String value) {
            addCriterion("sendSystem >", value, "sendsystem");
            return (Criteria) this;
        }

        public Criteria andSendsystemGreaterThanOrEqualTo(String value) {
            addCriterion("sendSystem >=", value, "sendsystem");
            return (Criteria) this;
        }

        public Criteria andSendsystemLessThan(String value) {
            addCriterion("sendSystem <", value, "sendsystem");
            return (Criteria) this;
        }

        public Criteria andSendsystemLessThanOrEqualTo(String value) {
            addCriterion("sendSystem <=", value, "sendsystem");
            return (Criteria) this;
        }

        public Criteria andSendsystemLike(String value) {
            addCriterion("sendSystem like", value, "sendsystem");
            return (Criteria) this;
        }

        public Criteria andSendsystemNotLike(String value) {
            addCriterion("sendSystem not like", value, "sendsystem");
            return (Criteria) this;
        }

        public Criteria andSendsystemIn(List<String> values) {
            addCriterion("sendSystem in", values, "sendsystem");
            return (Criteria) this;
        }

        public Criteria andSendsystemNotIn(List<String> values) {
            addCriterion("sendSystem not in", values, "sendsystem");
            return (Criteria) this;
        }

        public Criteria andSendsystemBetween(String value1, String value2) {
            addCriterion("sendSystem between", value1, value2, "sendsystem");
            return (Criteria) this;
        }

        public Criteria andSendsystemNotBetween(String value1, String value2) {
            addCriterion("sendSystem not between", value1, value2, "sendsystem");
            return (Criteria) this;
        }

        public Criteria andIsbackIsNull() {
            addCriterion("isback is null");
            return (Criteria) this;
        }

        public Criteria andIsbackIsNotNull() {
            addCriterion("isback is not null");
            return (Criteria) this;
        }

        public Criteria andIsbackEqualTo(Integer value) {
            addCriterion("isback =", value, "isback");
            return (Criteria) this;
        }

        public Criteria andIsbackNotEqualTo(Integer value) {
            addCriterion("isback <>", value, "isback");
            return (Criteria) this;
        }

        public Criteria andIsbackGreaterThan(Integer value) {
            addCriterion("isback >", value, "isback");
            return (Criteria) this;
        }

        public Criteria andIsbackGreaterThanOrEqualTo(Integer value) {
            addCriterion("isback >=", value, "isback");
            return (Criteria) this;
        }

        public Criteria andIsbackLessThan(Integer value) {
            addCriterion("isback <", value, "isback");
            return (Criteria) this;
        }

        public Criteria andIsbackLessThanOrEqualTo(Integer value) {
            addCriterion("isback <=", value, "isback");
            return (Criteria) this;
        }

        public Criteria andIsbackIn(List<Integer> values) {
            addCriterion("isback in", values, "isback");
            return (Criteria) this;
        }

        public Criteria andIsbackNotIn(List<Integer> values) {
            addCriterion("isback not in", values, "isback");
            return (Criteria) this;
        }

        public Criteria andIsbackBetween(Integer value1, Integer value2) {
            addCriterion("isback between", value1, value2, "isback");
            return (Criteria) this;
        }

        public Criteria andIsbackNotBetween(Integer value1, Integer value2) {
            addCriterion("isback not between", value1, value2, "isback");
            return (Criteria) this;
        }

        public Criteria andOpenidIsNull() {
            addCriterion("openId is null");
            return (Criteria) this;
        }

        public Criteria andOpenidIsNotNull() {
            addCriterion("openId is not null");
            return (Criteria) this;
        }

        public Criteria andOpenidEqualTo(String value) {
            addCriterion("openId =", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidNotEqualTo(String value) {
            addCriterion("openId <>", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidGreaterThan(String value) {
            addCriterion("openId >", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidGreaterThanOrEqualTo(String value) {
            addCriterion("openId >=", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidLessThan(String value) {
            addCriterion("openId <", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidLessThanOrEqualTo(String value) {
            addCriterion("openId <=", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidLike(String value) {
            addCriterion("openId like", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidNotLike(String value) {
            addCriterion("openId not like", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidIn(List<String> values) {
            addCriterion("openId in", values, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidNotIn(List<String> values) {
            addCriterion("openId not in", values, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidBetween(String value1, String value2) {
            addCriterion("openId between", value1, value2, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidNotBetween(String value1, String value2) {
            addCriterion("openId not between", value1, value2, "openid");
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