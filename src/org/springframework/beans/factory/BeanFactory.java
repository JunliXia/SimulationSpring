package org.springframework.beans.factory;

import org.springframework.beans.BeansException;

/**
 *访问Spring bean 容器的根接口 
 *这是最基本客户所能观察到的bean容器
 *更进一步的接口，如{@link ListableBeanFactory} and
 * {@link org.springframework.beans.factory.config.ConfigurableBeanFactory}
 * 是有其特殊的用途
 * 
 * 这个接口被那些支持多个bean定义的对象实现
 * 太长不写了
 */
public interface BeanFactory {
	/**
	 * 如果需要得到工厂Bean本身，需要使用转义的名字来向IOC容器检索
	 * 例如：如果一个Bean叫做myJndiObject是一个FactoryBean,用&myJndiObject
	 * 将会返回这个工厂。
	 */
	 
	String FACTORY_BEAN_PREFIX = "&";
	
	
	/**
	 * 返回一个实例，可能是分享或者独立，指定的bean
	 * 。。。
	 * 询问父工厂是否这个bean不能被这个实例工厂找到
	 * @param name
	 * @return
	 * @throws BeansException
	 */
	Object getBean(String name) throws BeansException;
	
	/**
	 * 表现跟{@link #getBean(String)}相似，但是提供一个测量类型，如果bean不是这个类型的
	 * 将会报错什么的
	 * @param <T>
	 * @param name
	 * @param requiredType
	 * @return
	 * @throws BeansException
	 */
	<T> T getBean(String name, Class<T> requiredType) throws BeansException;
	
	<T> T getBean(Class<T> requiredType)throws BeansException;
	
	/**
	 * 允许特殊指定的构造方法参数/工厂方法参数
	 * 获取IoC容器中指定名称和参数的Bean 
	 * @param name
	 * @param args
	 * @return
	 * @throws BeansException
	 */
	Object getBean(String name, Object...args) throws BeansException;
	
	
	/**
	 * 这个bean工厂包含所给予的name的bean吗？更具体的说是{@link #getBean}能拿到一个这样
	 * name的bean实例吗？
	 * @param name
	 * @return
	 */
	boolean containsBean(String name);
	
	
	/**
	 * 这个bean是一个共享的Singleton吗？如果是的话，{@link #getBean}会返回一个相同的实例吗？
	 * @param name
	 * @return
	 * @throws NoSuchBeanDefinitionException
	 */
	boolean isSingleton(String name) throws NoSuchBeanDefinitionException;
	
	
	/**
	 * 这个bean是prototype吗？如果是的话，{@link #getBean}会返回一个相同的实例吗？
	 * @param name
	 * @return
	 * @throws NoSuchBeanDefinitionException
	 */
	boolean isPrototype(String name) throws NoSuchBeanDefinitionException;
	
	
	/**
	 * 检查是否这个名字的bean跟给定的类型是否一致。
	 * 更具体的说，检查是否{@link #getBean}返回所给定name的bean的类型是可认定与给定的目标类型
	 * @param name
	 * @param targetType
	 * @return
	 * @throws NoSuchBeanDefinitionException
	 */
	boolean isTypeMatch(String name, Class<?> targetType) throws NoSuchBeanDefinitionException;
	
	/**
	 * 确定得到的所给name得到的bean的类型。更具体的来说，确定对象的类型是{@link #getBean}
	 * 能返回所有的名字。
	 * @param name
	 * @return
	 * @throws NoSuchBeanDefinitionException
	 */
	Class<?> getType(String name) throws NoSuchBeanDefinitionException;
	
	/**
	 * 浣溪沙 阆苑瑶台风露秋 北宋 晏殊
	 * 阆苑瑶台风露秋 整鬟凝思捧觥筹 欲归临别强迟留
	 * 月好漫成孤枕梦 酒澜空得两眉愁 此时情绪悔风流
	 */
	
	/**
	 * 返回所给name的bean的别名。如果有的话
	 * @param name
	 * @return
	 */
	String[] getAliases(String name);
	
}
