package java8;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

import org.junit.Test;

public class TestForkJoinCalucate {
	
	@Test
	public void test1(){
		Instant now = Instant.now();
		ForkJoinPool pool = new ForkJoinPool();
		ForkJoinTask<Long> task = new ForkJoinCalucate(0L,80000000000L);
		Long invoke = pool.invoke(task);
		Instant now2 = Instant.now();
		System.out.println(Duration.between(now, now2).toMillis()); //41861
	}
	
	@Test
	public void test2(){
		Instant now = Instant.now();
		long sum = 0;
		for(long i = 0;i<80000000000L;i++){
			sum+=i;
		}
		Instant now2 = Instant.now();
		System.out.println(Duration.between(now, now2).toMillis());//5220
	}
	
	@Test
	public void test3(){
		Instant now = Instant.now();
		long sum = LongStream.rangeClosed(0, 80000000000L).parallel().sum();
		Instant now2 = Instant.now();
		System.out.println(Duration.between(now, now2).toMillis());//33955

	}
}
