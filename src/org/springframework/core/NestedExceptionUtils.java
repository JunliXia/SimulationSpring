package org.springframework.core;
/**
 * ������������ʵ����Щ�ܹ�֧��Ƕ���쳣���쳣����ࡣ
 * ��Ҫ�ģ���Ϊ���ǲ��ܷ���һ�����������ڲ�ͬ���쳣����֮��
 * 
 *  ��Ҫ���ڿ����ʹ��
 *
 */
public abstract class NestedExceptionUtils {

	
	/**
	 * ����һ����Ϣ�����ϻ�������Ϣ����Ҫ��ԭ��
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
