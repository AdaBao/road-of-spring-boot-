package cn.com;

public class Action {
	private IDao dao;
	public void execute() {
		dao.sayHello();
	}
	public IDao getDao() {
		return dao;
	}
	public void setDao(IDao dao) {
		this.dao = dao;
	}
	
	

}
