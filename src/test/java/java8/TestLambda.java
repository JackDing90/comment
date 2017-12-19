package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class TestLambda {
	
	List<Employee> employees = Arrays.asList(
		new Employee("张三","18","8000"),
		new Employee("李四","28","9000"),
		new Employee("王五","38","10000")
	);
	
	
	public List<Employee> filterEmployee(List<Employee> employees,MyPredict<Employee> mp){
		List<Employee> list = new ArrayList<>();
		for(Employee emps:employees){
			if(mp.test(emps)){
				list.add(emps);
			}
		}
		return list;
	}
	
		
	@Test
	public void test1(){
		List <Employee> list = filterEmployee( employees,new MyPredict<Employee>() {
			@Override
			public boolean test(Employee t) {
				return "28".equals(t.getAge());
			}
		});
		for(Employee emp:list){
			System.out.println(emp);
		}
	}
	
	/**
	 * 使用lambda表达式
	 */
	@Test
	public void test2(){
		List <Employee> list = filterEmployee( employees, (e)->e.getAge().equals("38"));
		list.forEach(System.out::println);
	}
	
	/**
	 * 使用steam api
	 */
	@Test
	public void test3(){
		employees.stream()
				 .filter((e)->e.getSalary().equals("8000"))
				 .forEach(System.out::println);
	}
}
