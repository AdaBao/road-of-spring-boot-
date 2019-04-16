package cn.com;


import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Service;

@Service
public class StudentUtil {
	private  String resource ;
	private  InputStream is;
	private SqlSessionFactory sessionFactory;
	
	public StudentUtil() {
		resource = "conf.xml";
		is = StudentUtil.class.getClassLoader().getResourceAsStream(resource);
		sessionFactory = new SqlSessionFactoryBuilder().build(is);
	}
	public void addStudent(Student student) {
		SqlSession session=sessionFactory.openSession();
		String statement="studentMapper.addStudent";
		session.insert(statement, student);
		session.commit();
		session.close();
	}
	
	public void deleteStudent(int id) {
		SqlSession session=sessionFactory.openSession();
		String statement="studentMapper.deleteStudent";
		session.delete(statement,id);
		session.commit();
		session.close();
	}
	
	public void updateStudent(Student student) {
		SqlSession session=sessionFactory.openSession();
		String statement="studentMapper.updateStudent";
		session.update(statement,student);
		session.commit();
		session.close();
	}
	
	
	
	public Student selectOne(int id) {
		SqlSession session=sessionFactory.openSession();
		String statement="studentMapper.getStudentById";
		Student student=session.selectOne(statement,id);
		session.close();
		return student;
	}
	
	@Action(name="before")
	@Action1(name="after")
	@Action2(name="around")
	public  List<Student> getAllStudents(){
		SqlSession session=sessionFactory.openSession();
		String statement="studentMapper.getAllStudents";
		List<Student> list=session.selectList(statement);
		session.close();
		return list;
		
	}
	
	public List<Student> getSomeStudents(HashMap<String, Integer> map ){
		SqlSession session=sessionFactory.openSession();
		String statement="studentMapper.getSomeStudents";
		List<Student> list=session.selectList(statement,map);
		session.close();
		return list;
	}
	
	public List<Student> findByCondition(HashMap<String, String> map){
		SqlSession session=sessionFactory.openSession();
		String statement="studentMapper.findByCondition";
		List<Student> list=session.selectList(statement,map);
		session.close();
		return list;
	}
	
	public void deleteByCondition(int...arr) {
		SqlSession session=sessionFactory.openSession();
		String statement="studentMapper.deleteByCondition";
		session.delete(statement,arr);
		session.commit();
		session.close();
	}
	
	public void insertByCondition(Student student) {
		SqlSession session=sessionFactory.openSession();
		String statement="studentMapper.insertByCondition";		
		session.insert(statement,student);
		session.commit();
		session.close();
	}

}
