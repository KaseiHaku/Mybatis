package kasei.mybatis.module2.a03dao.b01paramAndReturn;

import com.kasei.mybatis.module2.a01entity.A01User;

public class NestJavaBean {
	private A01User user;

	public A01User getUser() {
		return user;
	}

	public void setUser(A01User user) {
		this.user = user;
	}
	
}
