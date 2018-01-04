package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;

public class TestTransaction {
	
	List<Transaction> transactions = null;
	
	@Before
	public void before(){
		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario", "Milan");
		Trader alan = new Trader("Alan", "Cambridge");
		Trader brian = new Trader("Brian", "Cambridge");
		
		transactions = Arrays.asList(
				new Transaction(brian, 2011, 300),
				new Transaction(raoul, 2012, 1000),
				new Transaction(raoul, 2011, 400),
				new Transaction(mario, 2012, 710),
				new Transaction(mario, 2012, 700),
				new Transaction(alan, 2012, 950)
		);
	}
	
	
	@Test
	public void test1(){
		transactions.stream()
					.filter((t)->t.getYear()==2011)
					.sorted((x,y)->Integer.compare(x.getValue(), y.getValue()))
					.forEach(System.out::println);
	}
	
	@Test
	public void test2(){
		transactions.stream()
					.map(Transaction::getTrader)
					.map(Trader::getCity)
					.collect(Collectors.toSet())
					.forEach(System.out::println);
	}
	
	@Test
	public void test3(){
		transactions.stream()
					.map(Transaction::getTrader)
					.filter((t)->t.getCity().equals("Cambridge"))
					.sorted((x,y)->x.getName().compareTo(y.getName()))
					.distinct()
					.forEach(System.out::println);
	}
	
	@Test
	public void test4(){
		String reduce = transactions.stream()
					.map(Transaction::getTrader)
					.map(Trader::getName)
					.sorted()
					.reduce("",String::concat);
		System.out.println(reduce);
		System.out.println("----------------------");
		
		String reduce2 = transactions.stream()
									 .map(Transaction::getTrader)
									 .map(Trader::getName)
									 .flatMap(TestTransaction::getStreamStr)
									 .sorted((x,y)->x.compareToIgnoreCase(y))
									 .reduce("",String::concat);
		System.out.println(reduce2);

					
	}
	
	public static Stream<String> getStreamStr(String str){
		List list = new ArrayList();
		for(Character c:str.toCharArray()){
			list.add(c.toString());
		}
		return list.stream();
	}
	
	@Test
	public void test5(){
		boolean anyMatch = 
				transactions.stream()
							.anyMatch((e)->e.getTrader().getCity().equals("Milan"));
		System.out.println(anyMatch);
	}
	
	
	@Test
	public void test6(){
				transactions.stream()
							.filter((e)->e.getTrader().getCity().equals("Cambridge"))
							.map(Transaction::getValue)
							.distinct()
							.forEach(System.out::println);
	}
	
	
	@Test
	public void test7(){
				Optional<Transaction> max = 
						transactions.stream()
									.max((x,y)->(((Integer)x.getValue()).compareTo((Integer)y.getValue())));
				System.out.println(max.get().getValue());
	}
	
	@Test
	public void test8(){
				Optional<Transaction> min = 
						transactions.stream()
									.min((x,y)->(((Integer)x.getValue()).compareTo((Integer)y.getValue())));
				System.out.println(min.get().getValue());
	}
	
	
}
	