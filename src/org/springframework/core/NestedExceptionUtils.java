package org.springframework.core;
/**
 * 助手类来帮助实现那些能够支持嵌套异常的异常类的类。
 * 必要的，因为我们不能分享一个基础的类在不同的异常类型之间
 * 
 *  主要是在框架内使用
 *
 */
public abstract class NestedExceptionUtils {

	
	/**
	 * 创建一条消息来给上基本的消息和主要的原因
	 * @param message
	 * @param cause
	 * @return
	 */
	public static String buildMessage(String message,Throwable cause){
		if(cause != null) {
			StringBuilder sb = new StringBuilder();
			if (message != null){
				sb.append(message).append("; ");
			}
			sb.append("nested exception is ").append(cause);
			return sb.toString();
		}
		else {
			return message;
		}
	}
	
	
}
