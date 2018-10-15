package com.wkb.robot.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RobotTaskExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected String limitClause;

    private static final long serialVersionUID = 1L;

    public RobotTaskExample() {
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

    public void setLimitClause(String limitClause) {
        this.limitClause=limitClause;
    }

    public String getLimitClause() {
        return limitClause;
    }

    protected abstract static class GeneratedCriteria implements Serializable {
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

        public Criteria andTaskNoIsNull() {
            addCriterion("task_no is null");
            return (Criteria) this;
        }

        public Criteria andTaskNoIsNotNull() {
            addCriterion("task_no is not null");
            return (Criteria) this;
        }

        public Criteria andTaskNoEqualTo(String value) {
            addCriterion("task_no =", value, "taskNo");
            return (Criteria) this;
        }

        public Criteria andTaskNoNotEqualTo(String value) {
            addCriterion("task_no <>", value, "taskNo");
            return (Criteria) this;
        }

        public Criteria andTaskNoGreaterThan(String value) {
            addCriterion("task_no >", value, "taskNo");
            return (Criteria) this;
        }

        public Criteria andTaskNoGreaterThanOrEqualTo(String value) {
            addCriterion("task_no >=", value, "taskNo");
            return (Criteria) this;
        }

        public Criteria andTaskNoLessThan(String value) {
            addCriterion("task_no <", value, "taskNo");
            return (Criteria) this;
        }

        public Criteria andTaskNoLessThanOrEqualTo(String value) {
            addCriterion("task_no <=", value, "taskNo");
            return (Criteria) this;
        }

        public Criteria andTaskNoLike(String value) {
            addCriterion("task_no like", value, "taskNo");
            return (Criteria) this;
        }

        public Criteria andTaskNoNotLike(String value) {
            addCriterion("task_no not like", value, "taskNo");
            return (Criteria) this;
        }

        public Criteria andTaskNoIn(List<String> values) {
            addCriterion("task_no in", values, "taskNo");
            return (Criteria) this;
        }

        public Criteria andTaskNoNotIn(List<String> values) {
            addCriterion("task_no not in", values, "taskNo");
            return (Criteria) this;
        }

        public Criteria andTaskNoBetween(String value1, String value2) {
            addCriterion("task_no between", value1, value2, "taskNo");
            return (Criteria) this;
        }

        public Criteria andTaskNoNotBetween(String value1, String value2) {
            addCriterion("task_no not between", value1, value2, "taskNo");
            return (Criteria) this;
        }

        public Criteria andComIdIsNull() {
            addCriterion("com_id is null");
            return (Criteria) this;
        }

        public Criteria andComIdIsNotNull() {
            addCriterion("com_id is not null");
            return (Criteria) this;
        }

        public Criteria andComIdEqualTo(String value) {
            addCriterion("com_id =", value, "comId");
            return (Criteria) this;
        }

        public Criteria andComIdNotEqualTo(String value) {
            addCriterion("com_id <>", value, "comId");
            return (Criteria) this;
        }

        public Criteria andComIdGreaterThan(String value) {
            addCriterion("com_id >", value, "comId");
            return (Criteria) this;
        }

        public Criteria andComIdGreaterThanOrEqualTo(String value) {
            addCriterion("com_id >=", value, "comId");
            return (Criteria) this;
        }

        public Criteria andComIdLessThan(String value) {
            addCriterion("com_id <", value, "comId");
            return (Criteria) this;
        }

        public Criteria andComIdLessThanOrEqualTo(String value) {
            addCriterion("com_id <=", value, "comId");
            return (Criteria) this;
        }

        public Criteria andComIdLike(String value) {
            addCriterion("com_id like", value, "comId");
            return (Criteria) this;
        }

        public Criteria andComIdNotLike(String value) {
            addCriterion("com_id not like", value, "comId");
            return (Criteria) this;
        }

        public Criteria andComIdIn(List<String> values) {
            addCriterion("com_id in", values, "comId");
            return (Criteria) this;
        }

        public Criteria andComIdNotIn(List<String> values) {
            addCriterion("com_id not in", values, "comId");
            return (Criteria) this;
        }

        public Criteria andComIdBetween(String value1, String value2) {
            addCriterion("com_id between", value1, value2, "comId");
            return (Criteria) this;
        }

        public Criteria andComIdNotBetween(String value1, String value2) {
            addCriterion("com_id not between", value1, value2, "comId");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNull() {
            addCriterion("user_name is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("user_name =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("user_name <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("user_name >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_name >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("user_name <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("user_name <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("user_name like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("user_name not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("user_name in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("user_name not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("user_name between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("user_name not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andOrgIdIsNull() {
            addCriterion("org_id is null");
            return (Criteria) this;
        }

        public Criteria andOrgIdIsNotNull() {
            addCriterion("org_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrgIdEqualTo(String value) {
            addCriterion("org_id =", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotEqualTo(String value) {
            addCriterion("org_id <>", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdGreaterThan(String value) {
            addCriterion("org_id >", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdGreaterThanOrEqualTo(String value) {
            addCriterion("org_id >=", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdLessThan(String value) {
            addCriterion("org_id <", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdLessThanOrEqualTo(String value) {
            addCriterion("org_id <=", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdLike(String value) {
            addCriterion("org_id like", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotLike(String value) {
            addCriterion("org_id not like", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdIn(List<String> values) {
            addCriterion("org_id in", values, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotIn(List<String> values) {
            addCriterion("org_id not in", values, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdBetween(String value1, String value2) {
            addCriterion("org_id between", value1, value2, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotBetween(String value1, String value2) {
            addCriterion("org_id not between", value1, value2, "orgId");
            return (Criteria) this;
        }

        public Criteria andQueueLevelIsNull() {
            addCriterion("queue_level is null");
            return (Criteria) this;
        }

        public Criteria andQueueLevelIsNotNull() {
            addCriterion("queue_level is not null");
            return (Criteria) this;
        }

        public Criteria andQueueLevelEqualTo(Integer value) {
            addCriterion("queue_level =", value, "queueLevel");
            return (Criteria) this;
        }

        public Criteria andQueueLevelNotEqualTo(Integer value) {
            addCriterion("queue_level <>", value, "queueLevel");
            return (Criteria) this;
        }

        public Criteria andQueueLevelGreaterThan(Integer value) {
            addCriterion("queue_level >", value, "queueLevel");
            return (Criteria) this;
        }

        public Criteria andQueueLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("queue_level >=", value, "queueLevel");
            return (Criteria) this;
        }

        public Criteria andQueueLevelLessThan(Integer value) {
            addCriterion("queue_level <", value, "queueLevel");
            return (Criteria) this;
        }

        public Criteria andQueueLevelLessThanOrEqualTo(Integer value) {
            addCriterion("queue_level <=", value, "queueLevel");
            return (Criteria) this;
        }

        public Criteria andQueueLevelIn(List<Integer> values) {
            addCriterion("queue_level in", values, "queueLevel");
            return (Criteria) this;
        }

        public Criteria andQueueLevelNotIn(List<Integer> values) {
            addCriterion("queue_level not in", values, "queueLevel");
            return (Criteria) this;
        }

        public Criteria andQueueLevelBetween(Integer value1, Integer value2) {
            addCriterion("queue_level between", value1, value2, "queueLevel");
            return (Criteria) this;
        }

        public Criteria andQueueLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("queue_level not between", value1, value2, "queueLevel");
            return (Criteria) this;
        }

        public Criteria andTaskTypeIsNull() {
            addCriterion("task_type is null");
            return (Criteria) this;
        }

        public Criteria andTaskTypeIsNotNull() {
            addCriterion("task_type is not null");
            return (Criteria) this;
        }

        public Criteria andTaskTypeEqualTo(String value) {
            addCriterion("task_type =", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNotEqualTo(String value) {
            addCriterion("task_type <>", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeGreaterThan(String value) {
            addCriterion("task_type >", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeGreaterThanOrEqualTo(String value) {
            addCriterion("task_type >=", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeLessThan(String value) {
            addCriterion("task_type <", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeLessThanOrEqualTo(String value) {
            addCriterion("task_type <=", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeLike(String value) {
            addCriterion("task_type like", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNotLike(String value) {
            addCriterion("task_type not like", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeIn(List<String> values) {
            addCriterion("task_type in", values, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNotIn(List<String> values) {
            addCriterion("task_type not in", values, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeBetween(String value1, String value2) {
            addCriterion("task_type between", value1, value2, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNotBetween(String value1, String value2) {
            addCriterion("task_type not between", value1, value2, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskProcessIsNull() {
            addCriterion("task_process is null");
            return (Criteria) this;
        }

        public Criteria andTaskProcessIsNotNull() {
            addCriterion("task_process is not null");
            return (Criteria) this;
        }

        public Criteria andTaskProcessEqualTo(String value) {
            addCriterion("task_process =", value, "taskProcess");
            return (Criteria) this;
        }

        public Criteria andTaskProcessNotEqualTo(String value) {
            addCriterion("task_process <>", value, "taskProcess");
            return (Criteria) this;
        }

        public Criteria andTaskProcessGreaterThan(String value) {
            addCriterion("task_process >", value, "taskProcess");
            return (Criteria) this;
        }

        public Criteria andTaskProcessGreaterThanOrEqualTo(String value) {
            addCriterion("task_process >=", value, "taskProcess");
            return (Criteria) this;
        }

        public Criteria andTaskProcessLessThan(String value) {
            addCriterion("task_process <", value, "taskProcess");
            return (Criteria) this;
        }

        public Criteria andTaskProcessLessThanOrEqualTo(String value) {
            addCriterion("task_process <=", value, "taskProcess");
            return (Criteria) this;
        }

        public Criteria andTaskProcessLike(String value) {
            addCriterion("task_process like", value, "taskProcess");
            return (Criteria) this;
        }

        public Criteria andTaskProcessNotLike(String value) {
            addCriterion("task_process not like", value, "taskProcess");
            return (Criteria) this;
        }

        public Criteria andTaskProcessIn(List<String> values) {
            addCriterion("task_process in", values, "taskProcess");
            return (Criteria) this;
        }

        public Criteria andTaskProcessNotIn(List<String> values) {
            addCriterion("task_process not in", values, "taskProcess");
            return (Criteria) this;
        }

        public Criteria andTaskProcessBetween(String value1, String value2) {
            addCriterion("task_process between", value1, value2, "taskProcess");
            return (Criteria) this;
        }

        public Criteria andTaskProcessNotBetween(String value1, String value2) {
            addCriterion("task_process not between", value1, value2, "taskProcess");
            return (Criteria) this;
        }

        public Criteria andTaskStatusIsNull() {
            addCriterion("task_status is null");
            return (Criteria) this;
        }

        public Criteria andTaskStatusIsNotNull() {
            addCriterion("task_status is not null");
            return (Criteria) this;
        }

        public Criteria andTaskStatusEqualTo(Integer value) {
            addCriterion("task_status =", value, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusNotEqualTo(Integer value) {
            addCriterion("task_status <>", value, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusGreaterThan(Integer value) {
            addCriterion("task_status >", value, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("task_status >=", value, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusLessThan(Integer value) {
            addCriterion("task_status <", value, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusLessThanOrEqualTo(Integer value) {
            addCriterion("task_status <=", value, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusIn(List<Integer> values) {
            addCriterion("task_status in", values, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusNotIn(List<Integer> values) {
            addCriterion("task_status not in", values, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusBetween(Integer value1, Integer value2) {
            addCriterion("task_status between", value1, value2, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("task_status not between", value1, value2, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskSourceIsNull() {
            addCriterion("task_source is null");
            return (Criteria) this;
        }

        public Criteria andTaskSourceIsNotNull() {
            addCriterion("task_source is not null");
            return (Criteria) this;
        }

        public Criteria andTaskSourceEqualTo(String value) {
            addCriterion("task_source =", value, "taskSource");
            return (Criteria) this;
        }

        public Criteria andTaskSourceNotEqualTo(String value) {
            addCriterion("task_source <>", value, "taskSource");
            return (Criteria) this;
        }

        public Criteria andTaskSourceGreaterThan(String value) {
            addCriterion("task_source >", value, "taskSource");
            return (Criteria) this;
        }

        public Criteria andTaskSourceGreaterThanOrEqualTo(String value) {
            addCriterion("task_source >=", value, "taskSource");
            return (Criteria) this;
        }

        public Criteria andTaskSourceLessThan(String value) {
            addCriterion("task_source <", value, "taskSource");
            return (Criteria) this;
        }

        public Criteria andTaskSourceLessThanOrEqualTo(String value) {
            addCriterion("task_source <=", value, "taskSource");
            return (Criteria) this;
        }

        public Criteria andTaskSourceLike(String value) {
            addCriterion("task_source like", value, "taskSource");
            return (Criteria) this;
        }

        public Criteria andTaskSourceNotLike(String value) {
            addCriterion("task_source not like", value, "taskSource");
            return (Criteria) this;
        }

        public Criteria andTaskSourceIn(List<String> values) {
            addCriterion("task_source in", values, "taskSource");
            return (Criteria) this;
        }

        public Criteria andTaskSourceNotIn(List<String> values) {
            addCriterion("task_source not in", values, "taskSource");
            return (Criteria) this;
        }

        public Criteria andTaskSourceBetween(String value1, String value2) {
            addCriterion("task_source between", value1, value2, "taskSource");
            return (Criteria) this;
        }

        public Criteria andTaskSourceNotBetween(String value1, String value2) {
            addCriterion("task_source not between", value1, value2, "taskSource");
            return (Criteria) this;
        }

        public Criteria andTaskReceiverIsNull() {
            addCriterion("task_receiver is null");
            return (Criteria) this;
        }

        public Criteria andTaskReceiverIsNotNull() {
            addCriterion("task_receiver is not null");
            return (Criteria) this;
        }

        public Criteria andTaskReceiverEqualTo(String value) {
            addCriterion("task_receiver =", value, "taskReceiver");
            return (Criteria) this;
        }

        public Criteria andTaskReceiverNotEqualTo(String value) {
            addCriterion("task_receiver <>", value, "taskReceiver");
            return (Criteria) this;
        }

        public Criteria andTaskReceiverGreaterThan(String value) {
            addCriterion("task_receiver >", value, "taskReceiver");
            return (Criteria) this;
        }

        public Criteria andTaskReceiverGreaterThanOrEqualTo(String value) {
            addCriterion("task_receiver >=", value, "taskReceiver");
            return (Criteria) this;
        }

        public Criteria andTaskReceiverLessThan(String value) {
            addCriterion("task_receiver <", value, "taskReceiver");
            return (Criteria) this;
        }

        public Criteria andTaskReceiverLessThanOrEqualTo(String value) {
            addCriterion("task_receiver <=", value, "taskReceiver");
            return (Criteria) this;
        }

        public Criteria andTaskReceiverLike(String value) {
            addCriterion("task_receiver like", value, "taskReceiver");
            return (Criteria) this;
        }

        public Criteria andTaskReceiverNotLike(String value) {
            addCriterion("task_receiver not like", value, "taskReceiver");
            return (Criteria) this;
        }

        public Criteria andTaskReceiverIn(List<String> values) {
            addCriterion("task_receiver in", values, "taskReceiver");
            return (Criteria) this;
        }

        public Criteria andTaskReceiverNotIn(List<String> values) {
            addCriterion("task_receiver not in", values, "taskReceiver");
            return (Criteria) this;
        }

        public Criteria andTaskReceiverBetween(String value1, String value2) {
            addCriterion("task_receiver between", value1, value2, "taskReceiver");
            return (Criteria) this;
        }

        public Criteria andTaskReceiverNotBetween(String value1, String value2) {
            addCriterion("task_receiver not between", value1, value2, "taskReceiver");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andComsumingTimeIsNull() {
            addCriterion("comsuming_time is null");
            return (Criteria) this;
        }

        public Criteria andComsumingTimeIsNotNull() {
            addCriterion("comsuming_time is not null");
            return (Criteria) this;
        }

        public Criteria andComsumingTimeEqualTo(Long value) {
            addCriterion("comsuming_time =", value, "comsumingTime");
            return (Criteria) this;
        }

        public Criteria andComsumingTimeNotEqualTo(Long value) {
            addCriterion("comsuming_time <>", value, "comsumingTime");
            return (Criteria) this;
        }

        public Criteria andComsumingTimeGreaterThan(Long value) {
            addCriterion("comsuming_time >", value, "comsumingTime");
            return (Criteria) this;
        }

        public Criteria andComsumingTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("comsuming_time >=", value, "comsumingTime");
            return (Criteria) this;
        }

        public Criteria andComsumingTimeLessThan(Long value) {
            addCriterion("comsuming_time <", value, "comsumingTime");
            return (Criteria) this;
        }

        public Criteria andComsumingTimeLessThanOrEqualTo(Long value) {
            addCriterion("comsuming_time <=", value, "comsumingTime");
            return (Criteria) this;
        }

        public Criteria andComsumingTimeIn(List<Long> values) {
            addCriterion("comsuming_time in", values, "comsumingTime");
            return (Criteria) this;
        }

        public Criteria andComsumingTimeNotIn(List<Long> values) {
            addCriterion("comsuming_time not in", values, "comsumingTime");
            return (Criteria) this;
        }

        public Criteria andComsumingTimeBetween(Long value1, Long value2) {
            addCriterion("comsuming_time between", value1, value2, "comsumingTime");
            return (Criteria) this;
        }

        public Criteria andComsumingTimeNotBetween(Long value1, Long value2) {
            addCriterion("comsuming_time not between", value1, value2, "comsumingTime");
            return (Criteria) this;
        }

        public Criteria andTaskInfoIsNull() {
            addCriterion("task_info is null");
            return (Criteria) this;
        }

        public Criteria andTaskInfoIsNotNull() {
            addCriterion("task_info is not null");
            return (Criteria) this;
        }

        public Criteria andTaskInfoEqualTo(String value) {
            addCriterion("task_info =", value, "taskInfo");
            return (Criteria) this;
        }

        public Criteria andTaskInfoNotEqualTo(String value) {
            addCriterion("task_info <>", value, "taskInfo");
            return (Criteria) this;
        }

        public Criteria andTaskInfoGreaterThan(String value) {
            addCriterion("task_info >", value, "taskInfo");
            return (Criteria) this;
        }

        public Criteria andTaskInfoGreaterThanOrEqualTo(String value) {
            addCriterion("task_info >=", value, "taskInfo");
            return (Criteria) this;
        }

        public Criteria andTaskInfoLessThan(String value) {
            addCriterion("task_info <", value, "taskInfo");
            return (Criteria) this;
        }

        public Criteria andTaskInfoLessThanOrEqualTo(String value) {
            addCriterion("task_info <=", value, "taskInfo");
            return (Criteria) this;
        }

        public Criteria andTaskInfoLike(String value) {
            addCriterion("task_info like", value, "taskInfo");
            return (Criteria) this;
        }

        public Criteria andTaskInfoNotLike(String value) {
            addCriterion("task_info not like", value, "taskInfo");
            return (Criteria) this;
        }

        public Criteria andTaskInfoIn(List<String> values) {
            addCriterion("task_info in", values, "taskInfo");
            return (Criteria) this;
        }

        public Criteria andTaskInfoNotIn(List<String> values) {
            addCriterion("task_info not in", values, "taskInfo");
            return (Criteria) this;
        }

        public Criteria andTaskInfoBetween(String value1, String value2) {
            addCriterion("task_info between", value1, value2, "taskInfo");
            return (Criteria) this;
        }

        public Criteria andTaskInfoNotBetween(String value1, String value2) {
            addCriterion("task_info not between", value1, value2, "taskInfo");
            return (Criteria) this;
        }

        public Criteria andResultInfoIsNull() {
            addCriterion("result_info is null");
            return (Criteria) this;
        }

        public Criteria andResultInfoIsNotNull() {
            addCriterion("result_info is not null");
            return (Criteria) this;
        }

        public Criteria andResultInfoEqualTo(String value) {
            addCriterion("result_info =", value, "resultInfo");
            return (Criteria) this;
        }

        public Criteria andResultInfoNotEqualTo(String value) {
            addCriterion("result_info <>", value, "resultInfo");
            return (Criteria) this;
        }

        public Criteria andResultInfoGreaterThan(String value) {
            addCriterion("result_info >", value, "resultInfo");
            return (Criteria) this;
        }

        public Criteria andResultInfoGreaterThanOrEqualTo(String value) {
            addCriterion("result_info >=", value, "resultInfo");
            return (Criteria) this;
        }

        public Criteria andResultInfoLessThan(String value) {
            addCriterion("result_info <", value, "resultInfo");
            return (Criteria) this;
        }

        public Criteria andResultInfoLessThanOrEqualTo(String value) {
            addCriterion("result_info <=", value, "resultInfo");
            return (Criteria) this;
        }

        public Criteria andResultInfoLike(String value) {
            addCriterion("result_info like", value, "resultInfo");
            return (Criteria) this;
        }

        public Criteria andResultInfoNotLike(String value) {
            addCriterion("result_info not like", value, "resultInfo");
            return (Criteria) this;
        }

        public Criteria andResultInfoIn(List<String> values) {
            addCriterion("result_info in", values, "resultInfo");
            return (Criteria) this;
        }

        public Criteria andResultInfoNotIn(List<String> values) {
            addCriterion("result_info not in", values, "resultInfo");
            return (Criteria) this;
        }

        public Criteria andResultInfoBetween(String value1, String value2) {
            addCriterion("result_info between", value1, value2, "resultInfo");
            return (Criteria) this;
        }

        public Criteria andResultInfoNotBetween(String value1, String value2) {
            addCriterion("result_info not between", value1, value2, "resultInfo");
            return (Criteria) this;
        }

        public Criteria andPlatInfoIsNull() {
            addCriterion("plat_info is null");
            return (Criteria) this;
        }

        public Criteria andPlatInfoIsNotNull() {
            addCriterion("plat_info is not null");
            return (Criteria) this;
        }

        public Criteria andPlatInfoEqualTo(String value) {
            addCriterion("plat_info =", value, "platInfo");
            return (Criteria) this;
        }

        public Criteria andPlatInfoNotEqualTo(String value) {
            addCriterion("plat_info <>", value, "platInfo");
            return (Criteria) this;
        }

        public Criteria andPlatInfoGreaterThan(String value) {
            addCriterion("plat_info >", value, "platInfo");
            return (Criteria) this;
        }

        public Criteria andPlatInfoGreaterThanOrEqualTo(String value) {
            addCriterion("plat_info >=", value, "platInfo");
            return (Criteria) this;
        }

        public Criteria andPlatInfoLessThan(String value) {
            addCriterion("plat_info <", value, "platInfo");
            return (Criteria) this;
        }

        public Criteria andPlatInfoLessThanOrEqualTo(String value) {
            addCriterion("plat_info <=", value, "platInfo");
            return (Criteria) this;
        }

        public Criteria andPlatInfoLike(String value) {
            addCriterion("plat_info like", value, "platInfo");
            return (Criteria) this;
        }

        public Criteria andPlatInfoNotLike(String value) {
            addCriterion("plat_info not like", value, "platInfo");
            return (Criteria) this;
        }

        public Criteria andPlatInfoIn(List<String> values) {
            addCriterion("plat_info in", values, "platInfo");
            return (Criteria) this;
        }

        public Criteria andPlatInfoNotIn(List<String> values) {
            addCriterion("plat_info not in", values, "platInfo");
            return (Criteria) this;
        }

        public Criteria andPlatInfoBetween(String value1, String value2) {
            addCriterion("plat_info between", value1, value2, "platInfo");
            return (Criteria) this;
        }

        public Criteria andPlatInfoNotBetween(String value1, String value2) {
            addCriterion("plat_info not between", value1, value2, "platInfo");
            return (Criteria) this;
        }

        public Criteria andErrorInfoIsNull() {
            addCriterion("error_info is null");
            return (Criteria) this;
        }

        public Criteria andErrorInfoIsNotNull() {
            addCriterion("error_info is not null");
            return (Criteria) this;
        }

        public Criteria andErrorInfoEqualTo(String value) {
            addCriterion("error_info =", value, "errorInfo");
            return (Criteria) this;
        }

        public Criteria andErrorInfoNotEqualTo(String value) {
            addCriterion("error_info <>", value, "errorInfo");
            return (Criteria) this;
        }

        public Criteria andErrorInfoGreaterThan(String value) {
            addCriterion("error_info >", value, "errorInfo");
            return (Criteria) this;
        }

        public Criteria andErrorInfoGreaterThanOrEqualTo(String value) {
            addCriterion("error_info >=", value, "errorInfo");
            return (Criteria) this;
        }

        public Criteria andErrorInfoLessThan(String value) {
            addCriterion("error_info <", value, "errorInfo");
            return (Criteria) this;
        }

        public Criteria andErrorInfoLessThanOrEqualTo(String value) {
            addCriterion("error_info <=", value, "errorInfo");
            return (Criteria) this;
        }

        public Criteria andErrorInfoLike(String value) {
            addCriterion("error_info like", value, "errorInfo");
            return (Criteria) this;
        }

        public Criteria andErrorInfoNotLike(String value) {
            addCriterion("error_info not like", value, "errorInfo");
            return (Criteria) this;
        }

        public Criteria andErrorInfoIn(List<String> values) {
            addCriterion("error_info in", values, "errorInfo");
            return (Criteria) this;
        }

        public Criteria andErrorInfoNotIn(List<String> values) {
            addCriterion("error_info not in", values, "errorInfo");
            return (Criteria) this;
        }

        public Criteria andErrorInfoBetween(String value1, String value2) {
            addCriterion("error_info between", value1, value2, "errorInfo");
            return (Criteria) this;
        }

        public Criteria andErrorInfoNotBetween(String value1, String value2) {
            addCriterion("error_info not between", value1, value2, "errorInfo");
            return (Criteria) this;
        }

        public Criteria andLicenseNoIsNull() {
            addCriterion("license_no is null");
            return (Criteria) this;
        }

        public Criteria andLicenseNoIsNotNull() {
            addCriterion("license_no is not null");
            return (Criteria) this;
        }

        public Criteria andLicenseNoEqualTo(String value) {
            addCriterion("license_no =", value, "licenseNo");
            return (Criteria) this;
        }

        public Criteria andLicenseNoNotEqualTo(String value) {
            addCriterion("license_no <>", value, "licenseNo");
            return (Criteria) this;
        }

        public Criteria andLicenseNoGreaterThan(String value) {
            addCriterion("license_no >", value, "licenseNo");
            return (Criteria) this;
        }

        public Criteria andLicenseNoGreaterThanOrEqualTo(String value) {
            addCriterion("license_no >=", value, "licenseNo");
            return (Criteria) this;
        }

        public Criteria andLicenseNoLessThan(String value) {
            addCriterion("license_no <", value, "licenseNo");
            return (Criteria) this;
        }

        public Criteria andLicenseNoLessThanOrEqualTo(String value) {
            addCriterion("license_no <=", value, "licenseNo");
            return (Criteria) this;
        }

        public Criteria andLicenseNoLike(String value) {
            addCriterion("license_no like", value, "licenseNo");
            return (Criteria) this;
        }

        public Criteria andLicenseNoNotLike(String value) {
            addCriterion("license_no not like", value, "licenseNo");
            return (Criteria) this;
        }

        public Criteria andLicenseNoIn(List<String> values) {
            addCriterion("license_no in", values, "licenseNo");
            return (Criteria) this;
        }

        public Criteria andLicenseNoNotIn(List<String> values) {
            addCriterion("license_no not in", values, "licenseNo");
            return (Criteria) this;
        }

        public Criteria andLicenseNoBetween(String value1, String value2) {
            addCriterion("license_no between", value1, value2, "licenseNo");
            return (Criteria) this;
        }

        public Criteria andLicenseNoNotBetween(String value1, String value2) {
            addCriterion("license_no not between", value1, value2, "licenseNo");
            return (Criteria) this;
        }

        public Criteria andEngineNoIsNull() {
            addCriterion("engine_no is null");
            return (Criteria) this;
        }

        public Criteria andEngineNoIsNotNull() {
            addCriterion("engine_no is not null");
            return (Criteria) this;
        }

        public Criteria andEngineNoEqualTo(String value) {
            addCriterion("engine_no =", value, "engineNo");
            return (Criteria) this;
        }

        public Criteria andEngineNoNotEqualTo(String value) {
            addCriterion("engine_no <>", value, "engineNo");
            return (Criteria) this;
        }

        public Criteria andEngineNoGreaterThan(String value) {
            addCriterion("engine_no >", value, "engineNo");
            return (Criteria) this;
        }

        public Criteria andEngineNoGreaterThanOrEqualTo(String value) {
            addCriterion("engine_no >=", value, "engineNo");
            return (Criteria) this;
        }

        public Criteria andEngineNoLessThan(String value) {
            addCriterion("engine_no <", value, "engineNo");
            return (Criteria) this;
        }

        public Criteria andEngineNoLessThanOrEqualTo(String value) {
            addCriterion("engine_no <=", value, "engineNo");
            return (Criteria) this;
        }

        public Criteria andEngineNoLike(String value) {
            addCriterion("engine_no like", value, "engineNo");
            return (Criteria) this;
        }

        public Criteria andEngineNoNotLike(String value) {
            addCriterion("engine_no not like", value, "engineNo");
            return (Criteria) this;
        }

        public Criteria andEngineNoIn(List<String> values) {
            addCriterion("engine_no in", values, "engineNo");
            return (Criteria) this;
        }

        public Criteria andEngineNoNotIn(List<String> values) {
            addCriterion("engine_no not in", values, "engineNo");
            return (Criteria) this;
        }

        public Criteria andEngineNoBetween(String value1, String value2) {
            addCriterion("engine_no between", value1, value2, "engineNo");
            return (Criteria) this;
        }

        public Criteria andEngineNoNotBetween(String value1, String value2) {
            addCriterion("engine_no not between", value1, value2, "engineNo");
            return (Criteria) this;
        }

        public Criteria andFrameNoIsNull() {
            addCriterion("frame_no is null");
            return (Criteria) this;
        }

        public Criteria andFrameNoIsNotNull() {
            addCriterion("frame_no is not null");
            return (Criteria) this;
        }

        public Criteria andFrameNoEqualTo(String value) {
            addCriterion("frame_no =", value, "frameNo");
            return (Criteria) this;
        }

        public Criteria andFrameNoNotEqualTo(String value) {
            addCriterion("frame_no <>", value, "frameNo");
            return (Criteria) this;
        }

        public Criteria andFrameNoGreaterThan(String value) {
            addCriterion("frame_no >", value, "frameNo");
            return (Criteria) this;
        }

        public Criteria andFrameNoGreaterThanOrEqualTo(String value) {
            addCriterion("frame_no >=", value, "frameNo");
            return (Criteria) this;
        }

        public Criteria andFrameNoLessThan(String value) {
            addCriterion("frame_no <", value, "frameNo");
            return (Criteria) this;
        }

        public Criteria andFrameNoLessThanOrEqualTo(String value) {
            addCriterion("frame_no <=", value, "frameNo");
            return (Criteria) this;
        }

        public Criteria andFrameNoLike(String value) {
            addCriterion("frame_no like", value, "frameNo");
            return (Criteria) this;
        }

        public Criteria andFrameNoNotLike(String value) {
            addCriterion("frame_no not like", value, "frameNo");
            return (Criteria) this;
        }

        public Criteria andFrameNoIn(List<String> values) {
            addCriterion("frame_no in", values, "frameNo");
            return (Criteria) this;
        }

        public Criteria andFrameNoNotIn(List<String> values) {
            addCriterion("frame_no not in", values, "frameNo");
            return (Criteria) this;
        }

        public Criteria andFrameNoBetween(String value1, String value2) {
            addCriterion("frame_no between", value1, value2, "frameNo");
            return (Criteria) this;
        }

        public Criteria andFrameNoNotBetween(String value1, String value2) {
            addCriterion("frame_no not between", value1, value2, "frameNo");
            return (Criteria) this;
        }

        public Criteria andVehicleNameIsNull() {
            addCriterion("vehicle_name is null");
            return (Criteria) this;
        }

        public Criteria andVehicleNameIsNotNull() {
            addCriterion("vehicle_name is not null");
            return (Criteria) this;
        }

        public Criteria andVehicleNameEqualTo(String value) {
            addCriterion("vehicle_name =", value, "vehicleName");
            return (Criteria) this;
        }

        public Criteria andVehicleNameNotEqualTo(String value) {
            addCriterion("vehicle_name <>", value, "vehicleName");
            return (Criteria) this;
        }

        public Criteria andVehicleNameGreaterThan(String value) {
            addCriterion("vehicle_name >", value, "vehicleName");
            return (Criteria) this;
        }

        public Criteria andVehicleNameGreaterThanOrEqualTo(String value) {
            addCriterion("vehicle_name >=", value, "vehicleName");
            return (Criteria) this;
        }

        public Criteria andVehicleNameLessThan(String value) {
            addCriterion("vehicle_name <", value, "vehicleName");
            return (Criteria) this;
        }

        public Criteria andVehicleNameLessThanOrEqualTo(String value) {
            addCriterion("vehicle_name <=", value, "vehicleName");
            return (Criteria) this;
        }

        public Criteria andVehicleNameLike(String value) {
            addCriterion("vehicle_name like", value, "vehicleName");
            return (Criteria) this;
        }

        public Criteria andVehicleNameNotLike(String value) {
            addCriterion("vehicle_name not like", value, "vehicleName");
            return (Criteria) this;
        }

        public Criteria andVehicleNameIn(List<String> values) {
            addCriterion("vehicle_name in", values, "vehicleName");
            return (Criteria) this;
        }

        public Criteria andVehicleNameNotIn(List<String> values) {
            addCriterion("vehicle_name not in", values, "vehicleName");
            return (Criteria) this;
        }

        public Criteria andVehicleNameBetween(String value1, String value2) {
            addCriterion("vehicle_name between", value1, value2, "vehicleName");
            return (Criteria) this;
        }

        public Criteria andVehicleNameNotBetween(String value1, String value2) {
            addCriterion("vehicle_name not between", value1, value2, "vehicleName");
            return (Criteria) this;
        }

        public Criteria andBizPolicyNoIsNull() {
            addCriterion("biz_policy_no is null");
            return (Criteria) this;
        }

        public Criteria andBizPolicyNoIsNotNull() {
            addCriterion("biz_policy_no is not null");
            return (Criteria) this;
        }

        public Criteria andBizPolicyNoEqualTo(String value) {
            addCriterion("biz_policy_no =", value, "bizPolicyNo");
            return (Criteria) this;
        }

        public Criteria andBizPolicyNoNotEqualTo(String value) {
            addCriterion("biz_policy_no <>", value, "bizPolicyNo");
            return (Criteria) this;
        }

        public Criteria andBizPolicyNoGreaterThan(String value) {
            addCriterion("biz_policy_no >", value, "bizPolicyNo");
            return (Criteria) this;
        }

        public Criteria andBizPolicyNoGreaterThanOrEqualTo(String value) {
            addCriterion("biz_policy_no >=", value, "bizPolicyNo");
            return (Criteria) this;
        }

        public Criteria andBizPolicyNoLessThan(String value) {
            addCriterion("biz_policy_no <", value, "bizPolicyNo");
            return (Criteria) this;
        }

        public Criteria andBizPolicyNoLessThanOrEqualTo(String value) {
            addCriterion("biz_policy_no <=", value, "bizPolicyNo");
            return (Criteria) this;
        }

        public Criteria andBizPolicyNoLike(String value) {
            addCriterion("biz_policy_no like", value, "bizPolicyNo");
            return (Criteria) this;
        }

        public Criteria andBizPolicyNoNotLike(String value) {
            addCriterion("biz_policy_no not like", value, "bizPolicyNo");
            return (Criteria) this;
        }

        public Criteria andBizPolicyNoIn(List<String> values) {
            addCriterion("biz_policy_no in", values, "bizPolicyNo");
            return (Criteria) this;
        }

        public Criteria andBizPolicyNoNotIn(List<String> values) {
            addCriterion("biz_policy_no not in", values, "bizPolicyNo");
            return (Criteria) this;
        }

        public Criteria andBizPolicyNoBetween(String value1, String value2) {
            addCriterion("biz_policy_no between", value1, value2, "bizPolicyNo");
            return (Criteria) this;
        }

        public Criteria andBizPolicyNoNotBetween(String value1, String value2) {
            addCriterion("biz_policy_no not between", value1, value2, "bizPolicyNo");
            return (Criteria) this;
        }

        public Criteria andEfcPolicyNoIsNull() {
            addCriterion("efc_policy_no is null");
            return (Criteria) this;
        }

        public Criteria andEfcPolicyNoIsNotNull() {
            addCriterion("efc_policy_no is not null");
            return (Criteria) this;
        }

        public Criteria andEfcPolicyNoEqualTo(String value) {
            addCriterion("efc_policy_no =", value, "efcPolicyNo");
            return (Criteria) this;
        }

        public Criteria andEfcPolicyNoNotEqualTo(String value) {
            addCriterion("efc_policy_no <>", value, "efcPolicyNo");
            return (Criteria) this;
        }

        public Criteria andEfcPolicyNoGreaterThan(String value) {
            addCriterion("efc_policy_no >", value, "efcPolicyNo");
            return (Criteria) this;
        }

        public Criteria andEfcPolicyNoGreaterThanOrEqualTo(String value) {
            addCriterion("efc_policy_no >=", value, "efcPolicyNo");
            return (Criteria) this;
        }

        public Criteria andEfcPolicyNoLessThan(String value) {
            addCriterion("efc_policy_no <", value, "efcPolicyNo");
            return (Criteria) this;
        }

        public Criteria andEfcPolicyNoLessThanOrEqualTo(String value) {
            addCriterion("efc_policy_no <=", value, "efcPolicyNo");
            return (Criteria) this;
        }

        public Criteria andEfcPolicyNoLike(String value) {
            addCriterion("efc_policy_no like", value, "efcPolicyNo");
            return (Criteria) this;
        }

        public Criteria andEfcPolicyNoNotLike(String value) {
            addCriterion("efc_policy_no not like", value, "efcPolicyNo");
            return (Criteria) this;
        }

        public Criteria andEfcPolicyNoIn(List<String> values) {
            addCriterion("efc_policy_no in", values, "efcPolicyNo");
            return (Criteria) this;
        }

        public Criteria andEfcPolicyNoNotIn(List<String> values) {
            addCriterion("efc_policy_no not in", values, "efcPolicyNo");
            return (Criteria) this;
        }

        public Criteria andEfcPolicyNoBetween(String value1, String value2) {
            addCriterion("efc_policy_no between", value1, value2, "efcPolicyNo");
            return (Criteria) this;
        }

        public Criteria andEfcPolicyNoNotBetween(String value1, String value2) {
            addCriterion("efc_policy_no not between", value1, value2, "efcPolicyNo");
            return (Criteria) this;
        }

        public Criteria andBizInsureUnderwritingIsNull() {
            addCriterion("biz_insure_underwriting is null");
            return (Criteria) this;
        }

        public Criteria andBizInsureUnderwritingIsNotNull() {
            addCriterion("biz_insure_underwriting is not null");
            return (Criteria) this;
        }

        public Criteria andBizInsureUnderwritingEqualTo(String value) {
            addCriterion("biz_insure_underwriting =", value, "bizInsureUnderwriting");
            return (Criteria) this;
        }

        public Criteria andBizInsureUnderwritingNotEqualTo(String value) {
            addCriterion("biz_insure_underwriting <>", value, "bizInsureUnderwriting");
            return (Criteria) this;
        }

        public Criteria andBizInsureUnderwritingGreaterThan(String value) {
            addCriterion("biz_insure_underwriting >", value, "bizInsureUnderwriting");
            return (Criteria) this;
        }

        public Criteria andBizInsureUnderwritingGreaterThanOrEqualTo(String value) {
            addCriterion("biz_insure_underwriting >=", value, "bizInsureUnderwriting");
            return (Criteria) this;
        }

        public Criteria andBizInsureUnderwritingLessThan(String value) {
            addCriterion("biz_insure_underwriting <", value, "bizInsureUnderwriting");
            return (Criteria) this;
        }

        public Criteria andBizInsureUnderwritingLessThanOrEqualTo(String value) {
            addCriterion("biz_insure_underwriting <=", value, "bizInsureUnderwriting");
            return (Criteria) this;
        }

        public Criteria andBizInsureUnderwritingLike(String value) {
            addCriterion("biz_insure_underwriting like", value, "bizInsureUnderwriting");
            return (Criteria) this;
        }

        public Criteria andBizInsureUnderwritingNotLike(String value) {
            addCriterion("biz_insure_underwriting not like", value, "bizInsureUnderwriting");
            return (Criteria) this;
        }

        public Criteria andBizInsureUnderwritingIn(List<String> values) {
            addCriterion("biz_insure_underwriting in", values, "bizInsureUnderwriting");
            return (Criteria) this;
        }

        public Criteria andBizInsureUnderwritingNotIn(List<String> values) {
            addCriterion("biz_insure_underwriting not in", values, "bizInsureUnderwriting");
            return (Criteria) this;
        }

        public Criteria andBizInsureUnderwritingBetween(String value1, String value2) {
            addCriterion("biz_insure_underwriting between", value1, value2, "bizInsureUnderwriting");
            return (Criteria) this;
        }

        public Criteria andBizInsureUnderwritingNotBetween(String value1, String value2) {
            addCriterion("biz_insure_underwriting not between", value1, value2, "bizInsureUnderwriting");
            return (Criteria) this;
        }

        public Criteria andEfcInsureUnderwritingIsNull() {
            addCriterion("efc_insure_underwriting is null");
            return (Criteria) this;
        }

        public Criteria andEfcInsureUnderwritingIsNotNull() {
            addCriterion("efc_insure_underwriting is not null");
            return (Criteria) this;
        }

        public Criteria andEfcInsureUnderwritingEqualTo(String value) {
            addCriterion("efc_insure_underwriting =", value, "efcInsureUnderwriting");
            return (Criteria) this;
        }

        public Criteria andEfcInsureUnderwritingNotEqualTo(String value) {
            addCriterion("efc_insure_underwriting <>", value, "efcInsureUnderwriting");
            return (Criteria) this;
        }

        public Criteria andEfcInsureUnderwritingGreaterThan(String value) {
            addCriterion("efc_insure_underwriting >", value, "efcInsureUnderwriting");
            return (Criteria) this;
        }

        public Criteria andEfcInsureUnderwritingGreaterThanOrEqualTo(String value) {
            addCriterion("efc_insure_underwriting >=", value, "efcInsureUnderwriting");
            return (Criteria) this;
        }

        public Criteria andEfcInsureUnderwritingLessThan(String value) {
            addCriterion("efc_insure_underwriting <", value, "efcInsureUnderwriting");
            return (Criteria) this;
        }

        public Criteria andEfcInsureUnderwritingLessThanOrEqualTo(String value) {
            addCriterion("efc_insure_underwriting <=", value, "efcInsureUnderwriting");
            return (Criteria) this;
        }

        public Criteria andEfcInsureUnderwritingLike(String value) {
            addCriterion("efc_insure_underwriting like", value, "efcInsureUnderwriting");
            return (Criteria) this;
        }

        public Criteria andEfcInsureUnderwritingNotLike(String value) {
            addCriterion("efc_insure_underwriting not like", value, "efcInsureUnderwriting");
            return (Criteria) this;
        }

        public Criteria andEfcInsureUnderwritingIn(List<String> values) {
            addCriterion("efc_insure_underwriting in", values, "efcInsureUnderwriting");
            return (Criteria) this;
        }

        public Criteria andEfcInsureUnderwritingNotIn(List<String> values) {
            addCriterion("efc_insure_underwriting not in", values, "efcInsureUnderwriting");
            return (Criteria) this;
        }

        public Criteria andEfcInsureUnderwritingBetween(String value1, String value2) {
            addCriterion("efc_insure_underwriting between", value1, value2, "efcInsureUnderwriting");
            return (Criteria) this;
        }

        public Criteria andEfcInsureUnderwritingNotBetween(String value1, String value2) {
            addCriterion("efc_insure_underwriting not between", value1, value2, "efcInsureUnderwriting");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria implements Serializable {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion implements Serializable {
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