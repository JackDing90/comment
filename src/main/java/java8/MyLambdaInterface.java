package java8;

@FunctionalInterface
public interface MyLambdaInterface<T,R> {
	
	public R getValue(T t1,T t2);
	
	default public void printLog(){
		System.out.println("打印日志啦！");
	}

}
