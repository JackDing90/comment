package java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Test;

public class StreamTest {
	
	//生成stream的四种方式：
	@Test
	public void test1(){
		//1.第一种:通过collection集合提供的stream方法生成
		List<String> list = Arrays.asList("1","2","3","4");
		Stream<String> stream = list.stream();
		stream.forEach(System.out::print);
		
		//2.第二种:通过Arrays提供的stream方法生成
		String[] s = new String[]{"1","2","3","4"};
		Stream<String> stream2 = Arrays.stream(s);
		stream2.forEach(System.out::print);
		
		//3.第三种：利用steam的静态方法of
		Stream<String> stream3 = Stream.of("1","2","3","4");
		stream3.forEach(System.out::print);
		
		//4.第四种：创建无限流
		//选代流
		Stream<Integer> stream4 = Stream.iterate(0,(x)->x+2);
		stream4.forEach(System.out::print);
		
		//生成
		Stream<Double> stream5 = Stream.generate(Math::random);
		stream5.limit(5).forEach(System.out::print);

	}
	
	
	/*
	  筛选与切片
		filter——接收 Lambda ， 从流中排除某些元素。
		limit——截断流，使其元素不超过给定数量。
		skip(n) —— 跳过元素，返回一个扔掉了前 n 个元素的流。若流中元素不足 n 个，则返回一个空流。与 limit(n) 互补
		distinct——筛选，通过流所生成元素的 hashCode() 和 equals() 去除重复元素
	 */
	@Test
	public void test2(){
		List<Integer> list = Arrays.asList(1,2,3,4);
		Stream<Integer> stream = list.stream().filter((e)->(e>2));
		stream.forEach(System.out::print);
		
		System.out.println();
		
		List<Integer> list2 = Arrays.asList(1,2,3,4);
		Stream<Integer> stream2 = list2.stream().limit(2);
		stream2.forEach(System.out::print);
		
		System.out.println();
		
		List<Integer> list3 = Arrays.asList(1,2,3,4);
		Stream<Integer> stream3 = list3.stream().skip(2);
		stream3.forEach(System.out::print);
		
		System.out.println();
		
		List<Integer> list4 = Arrays.asList(1,2,3,4,4,3);
		Stream<Integer> stream4 = list4.stream().distinct();
		stream4.forEach(System.out::print);
		
	}
}
