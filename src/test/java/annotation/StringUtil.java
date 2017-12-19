package annotation;

public class StringUtil {
	
	public static String toUpperFirstCase(String str){
		char[] charArray = str.toCharArray();
		charArray[0]-=32;
		return String.valueOf(charArray);
	}
}
