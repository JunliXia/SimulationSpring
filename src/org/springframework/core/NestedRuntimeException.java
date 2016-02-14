package org.springframework.core;
/**
 * ������������װ�������쳣�͸���ԭ��
 * �������abstract��ǿ�ȳ���Աȥ�̳С�getMessage�������Ƕ�׵��쳣��Ϣ��
 * printStackTrace������ͬ���ķ�������ί�и�װ�ε��쳣������еĻ�
 * 
 * ������ {@link NestedCheckedException}�����Ƶ��ǲ��ɱ���ġ�Java��ʹ������������ͬ�ĳ���
 
 * 
 */
public class NestedRuntimeException extends RuntimeException{

	/**
	 * ʹ������Spring 1.2��serialVersionUIDΪ�˻�������
	 */
	private static final long serialVersionUID = 4166832980268113964L;
	
	static{
		//���еļ���NestedExceptionUtils�����������������
		//���������OSGi������getMessage()
		NestedExceptionUtils.class.getName();
	}
	
	public NestedRuntimeException(String msg){
		super(msg);
	}
	
	public NestedRuntimeException(String msg, Throwable cause) {
		super(msg, cause);
	}
	
	/**
	 * ������ϸ����Ϣ����������Ϣ���Ե�Ƕ���쳣
	 * ����еĻ�
	 */
	@Override
	public String getMessage(){
		return NestedExceptionUtils.buildMessage(super.getMessage(), getCause());
	}
	
	/**
	 * ��������쳣�������ԭ������еĻ� 
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
