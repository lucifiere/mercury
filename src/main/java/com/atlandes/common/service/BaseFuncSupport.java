package com.atlandes.common.service;

import com.atlandes.common.component.MercuryFrameException;
import com.atlandes.common.constant.DefaultPageConfig;
import com.atlandes.common.util.ApplicationContextHolder;
import com.atlandes.common.pojo.Pagination;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.IncorrectResultSetColumnCountException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by XD.Wang on 2017/6/19.
 * func 1：桥接Mybatis和JDBC，将分页给JDBC
 */
@SuppressWarnings("unchecked")
public class BaseFuncSupport<T> extends SqlSessionDaoSupport {

    private static final Logger LOG = LoggerFactory.getLogger(BaseFuncSupport.class);

    private String namespace;

    @Resource
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    public BaseFuncSupport() {
        try {
            Type genericClazz = this.getClass().getGenericSuperclass();
            if (genericClazz instanceof ParameterizedType) {
                Class<T> entityClass = (Class<T>) ((ParameterizedType) genericClazz).getActualTypeArguments()[0];
                this.namespace = entityClass.getPackage().getName() + "." + entityClass.getSimpleName();
            }
        } catch (Exception e) {
            this.namespace = null;
        }
    }

    protected <R> Pagination<R> exePaging(String statementId, Pagination paging, Class<R> clazz) {
        return exePaging(statementId, this.namespace, paging, clazz);
    }

    protected <R> Pagination<R> exePaging(String statementId, String namespace, Pagination paging, Class<R> clazz) {
        String statementFullName = namespace + "." + statementId;
        Configuration configuration = this.getSqlSession().getConfiguration();
        BoundSql boundSql = configuration.getMappedStatement(statementFullName).getBoundSql(paging);
        String sourceSql = boundSql.getSql();
        String limitSql = appendLimitSql(paging.getOffset(), paging.getPageSize());
        String pageSql = sourceSql + limitSql;

        JdbcTemplate jdbcTemplate = ApplicationContextHolder.getBean("jdbcTemplate", JdbcTemplate.class);
        RowMapper<R> rowMapper = new BeanPropertyRowMapper<>(clazz);
        List<R> list = jdbcTemplate.query(pageSql, rowMapper);
        paging.setResult(list);
        Integer count = jdbcTemplate.queryForObject(appendCountSql(sourceSql), Integer.class);
        paging.setPageTotalCount(count);
        return paging;
    }

    private String appendCountSql(String sourceSql) {
        sourceSql = sourceSql.trim();
        if (sourceSql.endsWith(";")) {
            sourceSql = sourceSql.substring(0, sourceSql.length() - 1
                    - ";".length());
        }
        return ("SELECT COUNT(1) AS " + DefaultPageConfig.COUNT_COLUMN + " FROM  ( ") + sourceSql + ")a";
    }

    private String appendLimitSql(Integer offset, Integer pageSize) {
        return String.format(" limit %s , %s ", offset, pageSize);
    }

}
