package org.springframework.core;
/**
 * 便利的类来分装运行期异常和根本原因
 * 这个类是abstract来强迫程序员去继承。getMessage将会包括嵌套的异常信息。
 * printStackTrace和其他同样的方法将会委托给装饰的异常，如果有的话
 * 
 * 这个类和 {@link NestedCheckedException}的相似点是不可避免的。Java迫使它们有两个不同的超类
 
 * 
 */
public class NestedRuntimeException extends RuntimeException{

	/**
	 * 使用来自Spring 1.2的serialVersionUID为了互操作性
	 */
	private static final long serialVersionUID = 4166832980268113964L;
	
	static{
		//急切的加载NestedExceptionUtils类来避免类加载死锁
		//问题产生于OSGi当调用getMessage()
		NestedExceptionUtils.class.getName();
	}
	
	public NestedRuntimeException(String msg){
		super(msg);
	}
	
	public NestedRuntimeException(String msg, Throwable cause) {
		super(msg, cause);
	}
	
	/**
	 * 返回详细的消息，包括该消息来自的嵌套异常
	 * 如果有的话
	 */
	@Override
	public String getMessage(){
		return NestedExceptionUtils.buildMessage(super.getMessage(), getCause());
	}
	
	/**
	 * 检索这个异常最里面的原因，如果有的话 
	 */
	public Throwable getRootCause(){
		Throwable rootCause = null;
		Throwable cause = getCause();
		while(cause != null && cause != rootCause){
			rootCause = cause;
			cause = cause.getCause();
		}
		return rootCause;
	}
	
	
}
