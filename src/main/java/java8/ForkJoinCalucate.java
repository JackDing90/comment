package java8;

import java.util.concurrent.RecursiveTask;

public class ForkJoinCalucate extends RecursiveTask<Long>{

	private static final long serialVersionUID = -3721782306321167804L;

	private Long start;
	private Long end;
	
	private final Long THRESHOLD = 10000L;
	
	
	
	public ForkJoinCalucate() {
		super();
	}

	public ForkJoinCalucate(Long start, Long end) {
		super();
		this.start = start;
		this.end = end;
	}


	@Override
	protected Long compute() {
		Long length = start-end;
		if(length<=THRESHOLD){
			long sum = 0;
			for(long i = start; i<end; i++){
				sum+=i;
			}
			return sum;
		}else{
			long middle = (start+end)/2;
			ForkJoinCalucate fc = new ForkJoinCalucate(start,middle);
			fc.fork();
			ForkJoinCalucate fc2 = new ForkJoinCalucate(middle+1,end);
			fc2.fork();
			return fc.join()+fc2.join();
		}
	}
	
	

}
