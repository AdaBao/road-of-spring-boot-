package cn.com;

public class DaoFactory {
	public static IDao createDaoInstance() {
		return new DaoImpl();
	}

}
