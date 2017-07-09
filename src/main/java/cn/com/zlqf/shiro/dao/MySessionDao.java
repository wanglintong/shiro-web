package cn.com.zlqf.shiro.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.eis.MemorySessionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import cn.com.zlqf.shiro.utils.DateUtil;

public class MySessionDao extends MemorySessionDAO{
	@Autowired
	private RedisTemplate<String,Map<Serializable,Session>> redisTemplate;
	
	@Override
	public void delete(Session session) {
		Map<Serializable, Session> sessionMap = redisTemplate.opsForValue().get("sessionMap");
		if(sessionMap==null || sessionMap.size()==0) return;
		sessionMap.remove(session.getId());
		redisTemplate.opsForValue().set("sessionMap", sessionMap);
	}

	@Override
	protected Serializable doCreate(Session session) {
		Serializable sessionId = generateSessionId(session);  
		assignSessionId(session, sessionId);
		
		Map<Serializable, Session> sessionMap = redisTemplate.opsForValue().get("sessionMap");
		if(sessionMap==null) {
			sessionMap = new HashMap<Serializable,Session>();
		}
		sessionMap.put(sessionId, session);
		redisTemplate.opsForValue().set("sessionMap", sessionMap);
		
		return session.getId();
	}

	@Override
	protected Session doReadSession(Serializable sessionId) {
		Map<Serializable, Session> sessionMap = redisTemplate.opsForValue().get("sessionMap");
		if(sessionMap==null || sessionMap.size()==0) return null;
		return sessionMap.get(sessionId);
	}

	@Override
	public void update(Session session) throws UnknownSessionException {
		Map<Serializable, Session> sessionMap = redisTemplate.opsForValue().get("sessionMap");
		if(sessionMap==null || sessionMap.size()==0) return;
		sessionMap.put(session.getId(), session);
		redisTemplate.opsForValue().set("sessionMap", sessionMap);
	}

	@Override
	public Collection<Session> getActiveSessions() {
		List<Session> list = new ArrayList<>();
		Map<Serializable, Session> sessionMap = redisTemplate.opsForValue().get("sessionMap");
		for(Serializable sid:sessionMap.keySet()) {
			list.add(sessionMap.get(sid));
		}
		return list;
	}
	
}
