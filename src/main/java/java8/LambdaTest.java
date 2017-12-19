package java8;

import org.junit.Test;

public class LambdaTest {
	
	@Test
	public void test(){
		op(100L,200L,(x,y)->x*y);
	}
	
	public void op(Long l1,Long l2,MyLambdaInterface<Long,Long> mf){
		System.out.println(mf.getValue(l1, l2));
	}
}
