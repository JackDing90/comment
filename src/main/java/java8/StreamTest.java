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
}
