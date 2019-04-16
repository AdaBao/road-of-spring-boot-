package cn.com;

public class DaoFactory1 {
	public  IDao createDaoInstance() {
		return new DaoImpl();
	}
}
