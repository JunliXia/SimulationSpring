package org.springframework.beans.factory;

import org.springframework.beans.BeansException;

/**
 *����Spring bean �����ĸ��ӿ� 
 *����������ͻ����ܹ۲쵽��bean����
 *����һ���Ľӿڣ���{@link ListableBeanFactory} and
 * {@link org.springframework.beans.factory.config.ConfigurableBeanFactory}
 * �������������;
 */
public interface BeanFactory {
	/**
	 * �����Ҫ�õ�����Bean������Ҫʹ��ת�����������IOC��������
	 * ���磺���һ��Bean����myJndiObject��һ��FactoryBean,��&myJndiObject
	 * ���᷵�����������
	 */
	 
	String FACTORY_BEAN_PREFIX = "&";
	
	Object getBean(String name) throws BeansException;
	

}
