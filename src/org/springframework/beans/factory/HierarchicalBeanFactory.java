package org.springframework.beans.factory;

//δ��
public interface HierarchicalBeanFactory extends BeanFactory{
	
	BeanFactory getParentBeanFactory();
	
	boolean containsLocalBean(String name);
}
