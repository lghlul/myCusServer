package customer.supu.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StoreExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public StoreExample() {
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

        public Criteria andStorenameIsNull() {
            addCriterion("storeName is null");
            return (Criteria) this;
        }

        public Criteria andStorenameIsNotNull() {
            addCriterion("storeName is not null");
            return (Criteria) this;
        }

        public Criteria andStorenameEqualTo(String value) {
            addCriterion("storeName =", value, "storename");
            return (Criteria) this;
        }

        public Criteria andStorenameNotEqualTo(String value) {
            addCriterion("storeName <>", value, "storename");
            return (Criteria) this;
        }

        public Criteria andStorenameGreaterThan(String value) {
            addCriterion("storeName >", value, "storename");
            return (Criteria) this;
        }

        public Criteria andStorenameGreaterThanOrEqualTo(String value) {
            addCriterion("storeName >=", value, "storename");
            return (Criteria) this;
        }

        public Criteria andStorenameLessThan(String value) {
            addCriterion("storeName <", value, "storename");
            return (Criteria) this;
        }

        public Criteria andStorenameLessThanOrEqualTo(String value) {
            addCriterion("storeName <=", value, "storename");
            return (Criteria) this;
        }

        public Criteria andStorenameLike(String value) {
            addCriterion("storeName like", value, "storename");
            return (Criteria) this;
        }

        public Criteria andStorenameNotLike(String value) {
            addCriterion("storeName not like", value, "storename");
            return (Criteria) this;
        }

        public Criteria andStorenameIn(List<String> values) {
            addCriterion("storeName in", values, "storename");
            return (Criteria) this;
        }

        public Criteria andStorenameNotIn(List<String> values) {
            addCriterion("storeName not in", values, "storename");
            return (Criteria) this;
        }

        public Criteria andStorenameBetween(String value1, String value2) {
            addCriterion("storeName between", value1, value2, "storename");
            return (Criteria) this;
        }

        public Criteria andStorenameNotBetween(String value1, String value2) {
            addCriterion("storeName not between", value1, value2, "storename");
            return (Criteria) this;
        }

        public Criteria andStoreimgIsNull() {
            addCriterion("storeImg is null");
            return (Criteria) this;
        }

        public Criteria andStoreimgIsNotNull() {
            addCriterion("storeImg is not null");
            return (Criteria) this;
        }

        public Criteria andStoreimgEqualTo(String value) {
            addCriterion("storeImg =", value, "storeimg");
            return (Criteria) this;
        }

        public Criteria andStoreimgNotEqualTo(String value) {
            addCriterion("storeImg <>", value, "storeimg");
            return (Criteria) this;
        }

        public Criteria andStoreimgGreaterThan(String value) {
            addCriterion("storeImg >", value, "storeimg");
            return (Criteria) this;
        }

        public Criteria andStoreimgGreaterThanOrEqualTo(String value) {
            addCriterion("storeImg >=", value, "storeimg");
            return (Criteria) this;
        }

        public Criteria andStoreimgLessThan(String value) {
            addCriterion("storeImg <", value, "storeimg");
            return (Criteria) this;
        }

        public Criteria andStoreimgLessThanOrEqualTo(String value) {
            addCriterion("storeImg <=", value, "storeimg");
            return (Criteria) this;
        }

        public Criteria andStoreimgLike(String value) {
            addCriterion("storeImg like", value, "storeimg");
            return (Criteria) this;
        }

        public Criteria andStoreimgNotLike(String value) {
            addCriterion("storeImg not like", value, "storeimg");
            return (Criteria) this;
        }

        public Criteria andStoreimgIn(List<String> values) {
            addCriterion("storeImg in", values, "storeimg");
            return (Criteria) this;
        }

        public Criteria andStoreimgNotIn(List<String> values) {
            addCriterion("storeImg not in", values, "storeimg");
            return (Criteria) this;
        }

        public Criteria andStoreimgBetween(String value1, String value2) {
            addCriterion("storeImg between", value1, value2, "storeimg");
            return (Criteria) this;
        }

        public Criteria andStoreimgNotBetween(String value1, String value2) {
            addCriterion("storeImg not between", value1, value2, "storeimg");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNull() {
            addCriterion("province is null");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNotNull() {
            addCriterion("province is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceEqualTo(String value) {
            addCriterion("province =", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotEqualTo(String value) {
            addCriterion("province <>", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThan(String value) {
            addCriterion("province >", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("province >=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThan(String value) {
            addCriterion("province <", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThanOrEqualTo(String value) {
            addCriterion("province <=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLike(String value) {
            addCriterion("province like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotLike(String value) {
            addCriterion("province not like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceIn(List<String> values) {
            addCriterion("province in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotIn(List<String> values) {
            addCriterion("province not in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceBetween(String value1, String value2) {
            addCriterion("province between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotBetween(String value1, String value2) {
            addCriterion("province not between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andCityIsNull() {
            addCriterion("city is null");
            return (Criteria) this;
        }

        public Criteria andCityIsNotNull() {
            addCriterion("city is not null");
            return (Criteria) this;
        }

        public Criteria andCityEqualTo(String value) {
            addCriterion("city =", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotEqualTo(String value) {
            addCriterion("city <>", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThan(String value) {
            addCriterion("city >", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThanOrEqualTo(String value) {
            addCriterion("city >=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThan(String value) {
            addCriterion("city <", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThanOrEqualTo(String value) {
            addCriterion("city <=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLike(String value) {
            addCriterion("city like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotLike(String value) {
            addCriterion("city not like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityIn(List<String> values) {
            addCriterion("city in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotIn(List<String> values) {
            addCriterion("city not in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityBetween(String value1, String value2) {
            addCriterion("city between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotBetween(String value1, String value2) {
            addCriterion("city not between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andRegionIsNull() {
            addCriterion("region is null");
            return (Criteria) this;
        }

        public Criteria andRegionIsNotNull() {
            addCriterion("region is not null");
            return (Criteria) this;
        }

        public Criteria andRegionEqualTo(String value) {
            addCriterion("region =", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionNotEqualTo(String value) {
            addCriterion("region <>", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionGreaterThan(String value) {
            addCriterion("region >", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionGreaterThanOrEqualTo(String value) {
            addCriterion("region >=", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionLessThan(String value) {
            addCriterion("region <", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionLessThanOrEqualTo(String value) {
            addCriterion("region <=", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionLike(String value) {
            addCriterion("region like", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionNotLike(String value) {
            addCriterion("region not like", value, "region");
            return (Criteria) this;
        }

        public Criteria andRegionIn(List<String> values) {
            addCriterion("region in", values, "region");
            return (Criteria) this;
        }

        public Criteria andRegionNotIn(List<String> values) {
            addCriterion("region not in", values, "region");
            return (Criteria) this;
        }

        public Criteria andRegionBetween(String value1, String value2) {
            addCriterion("region between", value1, value2, "region");
            return (Criteria) this;
        }

        public Criteria andRegionNotBetween(String value1, String value2) {
            addCriterion("region not between", value1, value2, "region");
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