package org.springframework.beans.factory.config;
//Î´Íê
public interface SingletonBeanRegistry {
	
	
	
	void registerSingleton(String beanName, Object singletonObject);
	
	Object getSingleton(String beanName);
	
	boolean containsSingleton(String beanName);
	
	String[] getSingletonNames();
	
	int getSingletonCount();

}
