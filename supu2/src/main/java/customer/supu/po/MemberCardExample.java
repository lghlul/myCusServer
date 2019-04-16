package customer.supu.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MemberCardExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public MemberCardExample() {
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

        public Criteria andMembernameIsNull() {
            addCriterion("memberName is null");
            return (Criteria) this;
        }

        public Criteria andMembernameIsNotNull() {
            addCriterion("memberName is not null");
            return (Criteria) this;
        }

        public Criteria andMembernameEqualTo(String value) {
            addCriterion("memberName =", value, "membername");
            return (Criteria) this;
        }

        public Criteria andMembernameNotEqualTo(String value) {
            addCriterion("memberName <>", value, "membername");
            return (Criteria) this;
        }

        public Criteria andMembernameGreaterThan(String value) {
            addCriterion("memberName >", value, "membername");
            return (Criteria) this;
        }

        public Criteria andMembernameGreaterThanOrEqualTo(String value) {
            addCriterion("memberName >=", value, "membername");
            return (Criteria) this;
        }

        public Criteria andMembernameLessThan(String value) {
            addCriterion("memberName <", value, "membername");
            return (Criteria) this;
        }

        public Criteria andMembernameLessThanOrEqualTo(String value) {
            addCriterion("memberName <=", value, "membername");
            return (Criteria) this;
        }

        public Criteria andMembernameLike(String value) {
            addCriterion("memberName like", value, "membername");
            return (Criteria) this;
        }

        public Criteria andMembernameNotLike(String value) {
            addCriterion("memberName not like", value, "membername");
            return (Criteria) this;
        }

        public Criteria andMembernameIn(List<String> values) {
            addCriterion("memberName in", values, "membername");
            return (Criteria) this;
        }

        public Criteria andMembernameNotIn(List<String> values) {
            addCriterion("memberName not in", values, "membername");
            return (Criteria) this;
        }

        public Criteria andMembernameBetween(String value1, String value2) {
            addCriterion("memberName between", value1, value2, "membername");
            return (Criteria) this;
        }

        public Criteria andMembernameNotBetween(String value1, String value2) {
            addCriterion("memberName not between", value1, value2, "membername");
            return (Criteria) this;
        }

        public Criteria andProinfoIsNull() {
            addCriterion("proInfo is null");
            return (Criteria) this;
        }

        public Criteria andProinfoIsNotNull() {
            addCriterion("proInfo is not null");
            return (Criteria) this;
        }

        public Criteria andProinfoEqualTo(String value) {
            addCriterion("proInfo =", value, "proinfo");
            return (Criteria) this;
        }

        public Criteria andProinfoNotEqualTo(String value) {
            addCriterion("proInfo <>", value, "proinfo");
            return (Criteria) this;
        }

        public Criteria andProinfoGreaterThan(String value) {
            addCriterion("proInfo >", value, "proinfo");
            return (Criteria) this;
        }

        public Criteria andProinfoGreaterThanOrEqualTo(String value) {
            addCriterion("proInfo >=", value, "proinfo");
            return (Criteria) this;
        }

        public Criteria andProinfoLessThan(String value) {
            addCriterion("proInfo <", value, "proinfo");
            return (Criteria) this;
        }

        public Criteria andProinfoLessThanOrEqualTo(String value) {
            addCriterion("proInfo <=", value, "proinfo");
            return (Criteria) this;
        }

        public Criteria andProinfoLike(String value) {
            addCriterion("proInfo like", value, "proinfo");
            return (Criteria) this;
        }

        public Criteria andProinfoNotLike(String value) {
            addCriterion("proInfo not like", value, "proinfo");
            return (Criteria) this;
        }

        public Criteria andProinfoIn(List<String> values) {
            addCriterion("proInfo in", values, "proinfo");
            return (Criteria) this;
        }

        public Criteria andProinfoNotIn(List<String> values) {
            addCriterion("proInfo not in", values, "proinfo");
            return (Criteria) this;
        }

        public Criteria andProinfoBetween(String value1, String value2) {
            addCriterion("proInfo between", value1, value2, "proinfo");
            return (Criteria) this;
        }

        public Criteria andProinfoNotBetween(String value1, String value2) {
            addCriterion("proInfo not between", value1, value2, "proinfo");
            return (Criteria) this;
        }

        public Criteria andMcardimgIsNull() {
            addCriterion("mCardImg is null");
            return (Criteria) this;
        }

        public Criteria andMcardimgIsNotNull() {
            addCriterion("mCardImg is not null");
            return (Criteria) this;
        }

        public Criteria andMcardimgEqualTo(String value) {
            addCriterion("mCardImg =", value, "mcardimg");
            return (Criteria) this;
        }

        public Criteria andMcardimgNotEqualTo(String value) {
            addCriterion("mCardImg <>", value, "mcardimg");
            return (Criteria) this;
        }

        public Criteria andMcardimgGreaterThan(String value) {
            addCriterion("mCardImg >", value, "mcardimg");
            return (Criteria) this;
        }

        public Criteria andMcardimgGreaterThanOrEqualTo(String value) {
            addCriterion("mCardImg >=", value, "mcardimg");
            return (Criteria) this;
        }

        public Criteria andMcardimgLessThan(String value) {
            addCriterion("mCardImg <", value, "mcardimg");
            return (Criteria) this;
        }

        public Criteria andMcardimgLessThanOrEqualTo(String value) {
            addCriterion("mCardImg <=", value, "mcardimg");
            return (Criteria) this;
        }

        public Criteria andMcardimgLike(String value) {
            addCriterion("mCardImg like", value, "mcardimg");
            return (Criteria) this;
        }

        public Criteria andMcardimgNotLike(String value) {
            addCriterion("mCardImg not like", value, "mcardimg");
            return (Criteria) this;
        }

        public Criteria andMcardimgIn(List<String> values) {
            addCriterion("mCardImg in", values, "mcardimg");
            return (Criteria) this;
        }

        public Criteria andMcardimgNotIn(List<String> values) {
            addCriterion("mCardImg not in", values, "mcardimg");
            return (Criteria) this;
        }

        public Criteria andMcardimgBetween(String value1, String value2) {
            addCriterion("mCardImg between", value1, value2, "mcardimg");
            return (Criteria) this;
        }

        public Criteria andMcardimgNotBetween(String value1, String value2) {
            addCriterion("mCardImg not between", value1, value2, "mcardimg");
            return (Criteria) this;
        }

        public Criteria andCardtypeIsNull() {
            addCriterion("cardType is null");
            return (Criteria) this;
        }

        public Criteria andCardtypeIsNotNull() {
            addCriterion("cardType is not null");
            return (Criteria) this;
        }

        public Criteria andCardtypeEqualTo(Integer value) {
            addCriterion("cardType =", value, "cardtype");
            return (Criteria) this;
        }

        public Criteria andCardtypeNotEqualTo(Integer value) {
            addCriterion("cardType <>", value, "cardtype");
            return (Criteria) this;
        }

        public Criteria andCardtypeGreaterThan(Integer value) {
            addCriterion("cardType >", value, "cardtype");
            return (Criteria) this;
        }

        public Criteria andCardtypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("cardType >=", value, "cardtype");
            return (Criteria) this;
        }

        public Criteria andCardtypeLessThan(Integer value) {
            addCriterion("cardType <", value, "cardtype");
            return (Criteria) this;
        }

        public Criteria andCardtypeLessThanOrEqualTo(Integer value) {
            addCriterion("cardType <=", value, "cardtype");
            return (Criteria) this;
        }

        public Criteria andCardtypeIn(List<Integer> values) {
            addCriterion("cardType in", values, "cardtype");
            return (Criteria) this;
        }

        public Criteria andCardtypeNotIn(List<Integer> values) {
            addCriterion("cardType not in", values, "cardtype");
            return (Criteria) this;
        }

        public Criteria andCardtypeBetween(Integer value1, Integer value2) {
            addCriterion("cardType between", value1, value2, "cardtype");
            return (Criteria) this;
        }

        public Criteria andCardtypeNotBetween(Integer value1, Integer value2) {
            addCriterion("cardType not between", value1, value2, "cardtype");
            return (Criteria) this;
        }

        public Criteria andTimelongIsNull() {
            addCriterion("timeLong is null");
            return (Criteria) this;
        }

        public Criteria andTimelongIsNotNull() {
            addCriterion("timeLong is not null");
            return (Criteria) this;
        }

        public Criteria andTimelongEqualTo(Integer value) {
            addCriterion("timeLong =", value, "timelong");
            return (Criteria) this;
        }

        public Criteria andTimelongNotEqualTo(Integer value) {
            addCriterion("timeLong <>", value, "timelong");
            return (Criteria) this;
        }

        public Criteria andTimelongGreaterThan(Integer value) {
            addCriterion("timeLong >", value, "timelong");
            return (Criteria) this;
        }

        public Criteria andTimelongGreaterThanOrEqualTo(Integer value) {
            addCriterion("timeLong >=", value, "timelong");
            return (Criteria) this;
        }

        public Criteria andTimelongLessThan(Integer value) {
            addCriterion("timeLong <", value, "timelong");
            return (Criteria) this;
        }

        public Criteria andTimelongLessThanOrEqualTo(Integer value) {
            addCriterion("timeLong <=", value, "timelong");
            return (Criteria) this;
        }

        public Criteria andTimelongIn(List<Integer> values) {
            addCriterion("timeLong in", values, "timelong");
            return (Criteria) this;
        }

        public Criteria andTimelongNotIn(List<Integer> values) {
            addCriterion("timeLong not in", values, "timelong");
            return (Criteria) this;
        }

        public Criteria andTimelongBetween(Integer value1, Integer value2) {
            addCriterion("timeLong between", value1, value2, "timelong");
            return (Criteria) this;
        }

        public Criteria andTimelongNotBetween(Integer value1, Integer value2) {
            addCriterion("timeLong not between", value1, value2, "timelong");
            return (Criteria) this;
        }

        public Criteria andAmountmoneyIsNull() {
            addCriterion("amountMoney is null");
            return (Criteria) this;
        }

        public Criteria andAmountmoneyIsNotNull() {
            addCriterion("amountMoney is not null");
            return (Criteria) this;
        }

        public Criteria andAmountmoneyEqualTo(Double value) {
            addCriterion("amountMoney =", value, "amountmoney");
            return (Criteria) this;
        }

        public Criteria andAmountmoneyNotEqualTo(Double value) {
            addCriterion("amountMoney <>", value, "amountmoney");
            return (Criteria) this;
        }

        public Criteria andAmountmoneyGreaterThan(Double value) {
            addCriterion("amountMoney >", value, "amountmoney");
            return (Criteria) this;
        }

        public Criteria andAmountmoneyGreaterThanOrEqualTo(Double value) {
            addCriterion("amountMoney >=", value, "amountmoney");
            return (Criteria) this;
        }

        public Criteria andAmountmoneyLessThan(Double value) {
            addCriterion("amountMoney <", value, "amountmoney");
            return (Criteria) this;
        }

        public Criteria andAmountmoneyLessThanOrEqualTo(Double value) {
            addCriterion("amountMoney <=", value, "amountmoney");
            return (Criteria) this;
        }

        public Criteria andAmountmoneyIn(List<Double> values) {
            addCriterion("amountMoney in", values, "amountmoney");
            return (Criteria) this;
        }

        public Criteria andAmountmoneyNotIn(List<Double> values) {
            addCriterion("amountMoney not in", values, "amountmoney");
            return (Criteria) this;
        }

        public Criteria andAmountmoneyBetween(Double value1, Double value2) {
            addCriterion("amountMoney between", value1, value2, "amountmoney");
            return (Criteria) this;
        }

        public Criteria andAmountmoneyNotBetween(Double value1, Double value2) {
            addCriterion("amountMoney not between", value1, value2, "amountmoney");
            return (Criteria) this;
        }

        public Criteria andIsuseIsNull() {
            addCriterion("isuse is null");
            return (Criteria) this;
        }

        public Criteria andIsuseIsNotNull() {
            addCriterion("isuse is not null");
            return (Criteria) this;
        }

        public Criteria andIsuseEqualTo(Integer value) {
            addCriterion("isuse =", value, "isuse");
            return (Criteria) this;
        }

        public Criteria andIsuseNotEqualTo(Integer value) {
            addCriterion("isuse <>", value, "isuse");
            return (Criteria) this;
        }

        public Criteria andIsuseGreaterThan(Integer value) {
            addCriterion("isuse >", value, "isuse");
            return (Criteria) this;
        }

        public Criteria andIsuseGreaterThanOrEqualTo(Integer value) {
            addCriterion("isuse >=", value, "isuse");
            return (Criteria) this;
        }

        public Criteria andIsuseLessThan(Integer value) {
            addCriterion("isuse <", value, "isuse");
            return (Criteria) this;
        }

        public Criteria andIsuseLessThanOrEqualTo(Integer value) {
            addCriterion("isuse <=", value, "isuse");
            return (Criteria) this;
        }

        public Criteria andIsuseIn(List<Integer> values) {
            addCriterion("isuse in", values, "isuse");
            return (Criteria) this;
        }

        public Criteria andIsuseNotIn(List<Integer> values) {
            addCriterion("isuse not in", values, "isuse");
            return (Criteria) this;
        }

        public Criteria andIsuseBetween(Integer value1, Integer value2) {
            addCriterion("isuse between", value1, value2, "isuse");
            return (Criteria) this;
        }

        public Criteria andIsuseNotBetween(Integer value1, Integer value2) {
            addCriterion("isuse not between", value1, value2, "isuse");
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