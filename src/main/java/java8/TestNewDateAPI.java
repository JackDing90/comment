package java8;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

import org.junit.Test;

public class TestNewDateAPI {
	
	@Test
	public void test3(){
		DateTimeFormatter dtf =  DateTimeFormatter.ofPattern("yyyyMMdd");
		LocalDateTime now = LocalDateTime.now();
		LocalDateTime with = now.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
		String format = with.format(dtf);
		System.out.println(format);
	}
	
	@Test
	public void test2(){
		Instant ins = Instant.now();
		OffsetDateTime atOffset = ins.atOffset(ZoneOffset.ofHours(8));
		System.out.println(atOffset);
		
		Instant ofEpochSecond = ins.ofEpochSecond(5);
		System.out.println(ofEpochSecond);
	}
	
	@Test
	public void test1(){
		LocalDateTime now = LocalDateTime.now();
		System.out.println(now);
		
		LocalDateTime of = LocalDateTime.of(2018,01,11,22,32,10);
		System.out.println(of);
		
		LocalDateTime plusYears = of.plusYears(10);
		System.out.println(plusYears);
		
		LocalDateTime minusMonths = of.minusMonths(2);
		System.out.println(minusMonths);
	}
	
	
}
