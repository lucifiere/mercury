package com.atlandes.auth.shiro.listener;

import com.atlandes.auth.shiro.session.ShiroSessionRepository;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by XD.Wang on 2017/5/26.
 * 用户会话监听器
 */
public class MercurySessionListener implements SessionListener {

    private static final Logger log = LoggerFactory.getLogger(MercurySessionListener.class);

    private ShiroSessionRepository shiroSessionRepository;

    public ShiroSessionRepository getShiroSessionRepository() {
        return shiroSessionRepository;
    }

    public void setShiroSessionRepository(ShiroSessionRepository shiroSessionRepository) {
        this.shiroSessionRepository = shiroSessionRepository;
    }

    @Override
    public void onStart(Session session) {
        log.error("Mercury Session On Start");
    }

    @Override
    public void onStop(Session session) {
        log.error("Mercury Session On Stop");
    }

    @Override
    public void onExpiration(Session session) {
        shiroSessionRepository.deleteSession(session.getId());

    }

}
