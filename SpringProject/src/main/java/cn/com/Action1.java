package cn.com;

public class Action1 {
	private IDao dao;
	public void execute() {
		dao.sayHello();
	}
	
	public Action1(IDao dao) {
		this.dao=dao;
	}
}
