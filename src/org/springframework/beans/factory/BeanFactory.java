package org.springframework.beans.factory;

import org.springframework.beans.BeansException;

/**
 *访问Spring bean 容器的根接口 
 *这是最基本客户所能观察到的bean容器
 *更进一步的接口，如{@link ListableBeanFactory} and
 * {@link org.springframework.beans.factory.config.ConfigurableBeanFactory}
 * 是有其特殊的用途
 */
public interface BeanFactory {
	/**
	 * 如果需要得到工厂Bean本身，需要使用转义的名字来向IOC容器检索
	 * 例如：如果一个Bean叫做myJndiObject是一个FactoryBean,用&myJndiObject
	 * 将会返回这个工厂。
	 */
	 
	String FACTORY_BEAN_PREFIX = "&";
	
	Object getBean(String name) throws BeansException;
	

}
