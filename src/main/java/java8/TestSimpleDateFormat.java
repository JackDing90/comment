package java8;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class TestSimpleDateFormat {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd"); //java 8可用
		
		Callable<LocalDate> task = new Callable<LocalDate>() {

			@Override
			public LocalDate call() throws Exception {
				return LocalDate.parse("20180109", dtf); //java 8可用
//				return DateFormatThreadLocal.convert("20180109");
			}
			
		};
		
		List<Future<LocalDate>> list = new ArrayList<>();
		
		ExecutorService pool = Executors.newFixedThreadPool(10);
		
		for(int i=0;i<10;i++){
			list.add(pool.submit(task));
		}
		
		for(Future<LocalDate> future:list){
			System.out.println(future.get());
		}
		
		pool.shutdown();
	}
	
}
