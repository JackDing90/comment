package annotation;

public class AnnotationedClass {
	
	@MyAnnotation
	private Student student;
	
	public void test1(){
		System.out.println("test1");
	}
	
	@MyAnnotation(value="1122",description="aabb")
	public void test2(@MyAnnotation(description="ccdd") Student student){
		System.out.println("test2");
	}
	
}
