package annotation;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

import org.junit.Test;

public class AnnotationLogic {

	@Test
	public void getAnnotation() throws ClassNotFoundException, InstantiationException, IllegalAccessException,
			NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		Class clazz = AnnotationedClass.class;
		Method[] methods = clazz.getMethods();
		for (Method method : methods) {
			Parameter[] parameters = method.getParameters();
			for (Parameter parameter : parameters) {
				MyAnnotation annotation = parameter.getAnnotation(MyAnnotation.class);
				if (annotation != null) {
					Class<?> paramClass = Class.forName(parameter.getParameterizedType().getTypeName());
					Object newInstance = paramClass.newInstance();
					Field[] fields = paramClass.getDeclaredFields();
					for (Field field : fields) {
						Method[] paramMethods = paramClass.getMethods();
						for (Method paramMethod : paramMethods) {
							if (paramMethod.getName().equals("set" + StringUtil.toUpperFirstCase(field.getName()))) {
								String value = "18";
								Class<?>[] parameterTypes = paramMethod.getParameterTypes();
								Method setterMethod = paramClass.getMethod(paramMethod.getName(), parameterTypes[0]);
								setterMethod.invoke(newInstance, value);
							}
						}
					}
					method.invoke(clazz.newInstance(), newInstance);
				}
			}
		}
	}
}
