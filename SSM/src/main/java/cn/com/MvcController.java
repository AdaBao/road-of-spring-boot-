package cn.com;



import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.enterprise.inject.Model;
import javax.print.CancelablePrintJob;
import javax.servlet.http.HttpServletRequest;
import javax.swing.text.html.HTMLDocument.HTMLReader.ParagraphAction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes(value="name")
public class MvcController {
	@Autowired
	private StudentUtil studentUtil;
	@RequestMapping("/showAllInfo")
	public String getAllStudents(HttpServletRequest request) {
		List<Student> list=studentUtil.getAllStudents();
		request.setAttribute("students", list);
		return "showAll";
	}
	
	@RequestMapping(value="/showLink",produces="text/plain;charset=UTF-8")
	public @ResponseBody String showLink(HttpServletRequest request) {
		return request.getRequestURL()+"  "+"can access";
	}
	
	@RequestMapping(value="/getJson",produces= {"application/json;charset=UTF-8"})
    public @ResponseBody Student getJson(int id) throws CustomException {
		if(id<=0)
			throw new CustomException("id not exist");
		return studentUtil.selectOne(id);
	}
	
	@RequestMapping(value="/getJson1/{str}",produces="text/plain;charset=UTF-8")
	public @ResponseBody String returnPara(@PathVariable String str) {
		return  "para is "+str; 
	}
	
	//重定向
	@RequestMapping(value="/baidu")
	public String testBaidu() {
		return "redirect:http://www.baidu.com";
	}
	
	//转发
	@RequestMapping(value="/index")
	public String jumpToDefaultPage() {
		return "forward:showAllInfo";
	}
	
	//显示表单
	@RequestMapping(value="test2")
	public String showForm() {
		return "test2";
	}
	
	//接收表单
	@RequestMapping(value="/formOp")
	public String formOp(HttpServletRequest request) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String name=request.getParameter("name");
		System.out.println(name);
		request.setAttribute("name", name);
		return "responseForm";
	}
	
	//第一种方法捕获异常
	/*@ExceptionHandler(CustomException.class)
	@ResponseBody
	public String handleRRException(CustomException e){
		System.out.println(e.getMessage());
		return e.getMessage();
	}*/
	
	//下面两种方法用来设置拦截的方法
	@RequestMapping(value="/testMethod",method=RequestMethod.POST)
	public @ResponseBody String getParam(@RequestParam String param) {
		return "POST "+param;
	}
	
	@RequestMapping(value="/testMethod",method=RequestMethod.GET)
	public @ResponseBody String getParam1(@RequestParam String param) {
		return "GET "+param;
	}
	
	//传进来的参数被包装成对象
	@RequestMapping(value="/testObjectParam")
	public @ResponseBody String printAndReturn(Student student) {
		int id=student.getId();
		String name=student.getName();
		int age=student.getAge();
		System.out.println("id: "+id+";name: "+name+";age: "+age);
		return "id: "+id+";name: "+name+";age: "+age;
	}
	
	
	//测试ModelMap
	@RequestMapping(value="/testModelMap")
	public  String testModel(ModelMap modelMap) {
		modelMap.put("key1", "value1");
		modelMap.put("key2", "value2");
		return "test3";
	}
	
	
	//下面两个方法测试sessionAttributes,sessionAttributes可以在多个request中共享数据
	@RequestMapping(value="/testSessionAttributes")
	public String testSessionAttributes(ModelMap map) {
		map.put("name", "namenamename");
		return "test4";
	}
	@RequestMapping(value="/testSessionAttributes1")
	public String testSessionAttributes1() {
		return "test4";
	}
	
}
