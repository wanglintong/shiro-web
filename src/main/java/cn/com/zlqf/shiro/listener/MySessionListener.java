package cn.com.zlqf.shiro.listener;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListener;

public class MySessionListener implements SessionListener{

	@Override
	public void onExpiration(Session session) {
		System.out.println("session��" + session.getId() + " ����");
	}

	@Override
	public void onStart(Session session) {
		System.out.println("session��" + session.getId() + " ����");
	}

	@Override
	public void onStop(Session session) {
		System.out.println("session��" + session.getId() + " ֹͣ");
	}

}
