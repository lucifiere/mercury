package com.atlandes.auth.shiro.dao;

import com.atlandes.auth.dao.SessionMapper;
import com.atlandes.auth.util.SerializeUtils;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.ValidatingSession;
import org.apache.shiro.session.mgt.eis.CachingSessionDAO;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by XD.Wang on 2017/6/26.
 * 数据库中缓存session
 */
public class SessionDao extends CachingSessionDAO {

    @Resource
    private SessionMapper sessionMapper;

    @Override
    protected Serializable doCreate(Session session) {
        Serializable sessionId = generateSessionId(session);
        assignSessionId(session, sessionId);
        Map<String, Object> sMap = new HashMap<>();
        sMap.put("id", sessionId);
        sMap.put("session", SerializeUtils.serialize(session));
        sessionMapper.insertSession(sMap);
        return session.getId();
    }

    @Override
    protected void doUpdate(Session session) {
        if (session instanceof ValidatingSession && !((ValidatingSession) session).isValid()) {
            return;
        }
        Map<String, Object> sMap = new HashMap<>();
        sMap.put("id", session.getId());
        sMap.put("session", SerializeUtils.serialize(session));
        sessionMapper.updateSession(sMap);
    }

    @Override
    protected void doDelete(Session session) {
        sessionMapper.deleteSession(session.getId());
    }

    @Override
    protected Session doReadSession(Serializable sessionId) {
        List<String> sessionStrList = sessionMapper.getSessionById(sessionId);
        if (sessionStrList.size() == 0) return null;
        return (Session) SerializeUtils.deserialize(Base64.decode(sessionStrList.get(0)));
    }

}
