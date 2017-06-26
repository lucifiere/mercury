package com.atlandes.auth.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by XD.Wang on 2017/6/26.
 * Session管理
 */
public interface SessionMapper {

    Integer insertSession(Map sMap);

    void updateSession(Map sMap);

    void deleteSession(Serializable sId);

    List<String> getSessionById(Serializable id);

}
