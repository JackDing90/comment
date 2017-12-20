package java8;

import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import org.junit.Test;

public class CoreInterfaceTest {
	
	/*
	 * Java8 内置的四大核心函数式接口
	 * 
	 * Consumer<T> : 消费型接口
	 * 		void accept(T t);
	 * 
	 * Supplier<T> : 供给型接口
	 * 		T get(); 
	 * 
	 * Function<T, R> : 函数型接口
	 * 		R apply(T t);
	 * 
	 * Predicate<T> : 断言型接口
	 * 		boolean test(T t);
	 * 
	 */
	
	@Test
	public void test1(){
		//形式一：
		Consumer<String> consumer = (x)->System.out.println(x);
		consumer.accept("aaabbb");
		
		//形式二：
		//方法引用       对象::实例方法名   
		Consumer<String> consumer2 = System.out::println;
		consumer2.accept("cccddd");
	}
	
	
	@Test
	public void test2(){
		//形式一：
		Supplier<Long> supplier = ()->System.currentTimeMillis();
		Long long1 = supplier.get();
		System.out.println(long1);
		
		//形式二：
		//方法引用       对象::实例方法名   
		Supplier<Long> supplier2 = System::currentTimeMillis;
		Long long2 = supplier2.get();
		System.out.println(long2);

	}
	
	@Test
	public void test3(){
		//形式一：
		Function<String,String> function = (x)->x.substring(0, 1);
		function.apply("abcd");
		System.out.println(function);
		
		//形式二：
		//方法引用       对象::实例方法名   
		Function<String,String> function2 = (x)->x.substring(0, 1);
		function.apply("abcd");
		System.out.println(function);

	}
	
	@Test
	public void test4(){
		//形式一：
		Predicate<String> predicate = (x)->x.equals("2");
		System.out.println(predicate.test("2"));
		
		//形式二：
		//方法引用       对象::实例方法名   
		BiPredicate<String,String> bipredicate = String::equals;
		System.out.println(bipredicate.test("1", "2"));
		
		
		//形式一：
		Comparator<Integer> comparator = (x,y)->Integer.compare(x, y);
		System.out.println(comparator.compare(2, 3));
		
		//形式二：
		//方法引用       对象::实例方法名  
		Comparator<Integer> comparator2 = Integer::compare;
		System.out.println(comparator.compare(2, 3));
		
	}
}
