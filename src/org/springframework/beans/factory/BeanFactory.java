package org.springframework.beans.factory;

import org.springframework.beans.BeansException;

/**
 *����Spring bean �����ĸ��ӿ� 
 *����������ͻ����ܹ۲쵽��bean����
 *����һ���Ľӿڣ���{@link ListableBeanFactory} and
 * {@link org.springframework.beans.factory.config.ConfigurableBeanFactory}
 * �������������;
 * 
 * ����ӿڱ���Щ֧�ֶ��bean����Ķ���ʵ��
 * ̫����д��
 */
public interface BeanFactory {
	/**
	 * �����Ҫ�õ�����Bean������Ҫʹ��ת�����������IOC��������
	 * ���磺���һ��Bean����myJndiObject��һ��FactoryBean,��&myJndiObject
	 * ���᷵�����������
	 */
	 
	String FACTORY_BEAN_PREFIX = "&";
	
	
	/**
	 * ����һ��ʵ���������Ƿ�����߶�����ָ����bean
	 * ������
	 * ѯ�ʸ������Ƿ����bean���ܱ����ʵ�������ҵ�
	 * @param name
	 * @return
	 * @throws BeansException
	 */
	Object getBean(String name) throws BeansException;
	
	/**
	 * ���ָ�{@link #getBean(String)}���ƣ������ṩһ���������ͣ����bean����������͵�
	 * ���ᱨ��ʲô��
	 * @param <T>
	 * @param name
	 * @param requiredType
	 * @return
	 * @throws BeansException
	 */
	<T> T getBean(String name, Class<T> requiredType) throws BeansException;
	
	<T> T getBean(Class<T> requiredType)throws BeansException;
	
	/**
	 * ��������ָ���Ĺ��췽������/������������
	 * ��ȡIoC������ָ�����ƺͲ�����Bean 
	 * @param name
	 * @param args
	 * @return
	 * @throws BeansException
	 */
	Object getBean(String name, Object...args) throws BeansException;
	
	
	/**
	 * ���bean���������������name��bean�𣿸������˵��{@link #getBean}���õ�һ������
	 * name��beanʵ����
	 * @param name
	 * @return
	 */
	boolean containsBean(String name);
	
	
	/**
	 * ���bean��һ�������Singleton������ǵĻ���{@link #getBean}�᷵��һ����ͬ��ʵ����
	 * @param name
	 * @return
	 * @throws NoSuchBeanDefinitionException
	 */
	boolean isSingleton(String name) throws NoSuchBeanDefinitionException;
	
	
	/**
	 * ���bean��prototype������ǵĻ���{@link #getBean}�᷵��һ����ͬ��ʵ����
	 * @param name
	 * @return
	 * @throws NoSuchBeanDefinitionException
	 */
	boolean isPrototype(String name) throws NoSuchBeanDefinitionException;
	
	
	/**
	 * ����Ƿ�������ֵ�bean�������������Ƿ�һ�¡�
	 * �������˵������Ƿ�{@link #getBean}����������name��bean�������ǿ��϶��������Ŀ������
	 * @param name
	 * @param targetType
	 * @return
	 * @throws NoSuchBeanDefinitionException
	 */
	boolean isTypeMatch(String name, Class<?> targetType) throws NoSuchBeanDefinitionException;
	
	/**
	 * ȷ���õ�������name�õ���bean�����͡����������˵��ȷ�������������{@link #getBean}
	 * �ܷ������е����֡�
	 * @param name
	 * @return
	 * @throws NoSuchBeanDefinitionException
	 */
	Class<?> getType(String name) throws NoSuchBeanDefinitionException;
	
	/**
	 * �Ϫɳ ��Է��̨��¶�� ���� ����
	 * ��Է��̨��¶�� ������˼������ �����ٱ�ǿ����
	 * �º����ɹ����� �����յ���ü�� ��ʱ�����ڷ���
	 */
	
	/**
	 * ��������name��bean�ı���������еĻ�
	 * @param name
	 * @return
	 */
	String[] getAliases(String name);
	
}
