package org.springframework.beans.factory;

//Î´Íê
public interface HierarchicalBeanFactory extends BeanFactory{
	
	BeanFactory getParentBeanFactory();
	
	boolean containsLocalBean(String name);
}
