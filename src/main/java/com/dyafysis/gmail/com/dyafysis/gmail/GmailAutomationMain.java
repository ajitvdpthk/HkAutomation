package com.dyafysis.gmail.com.dyafysis.gmail;

public class GmailAutomationMain<T> implements AppPages<T>{
T instance=null;
private Class<T> obj;

//public T getInstanceOFClass(Class<T> clazz) throws IllegalAccessException, InstantiationException {
//    if (instance == null) {
//        this.instance = clazz.newInstance();
//    }
//    return instance;
//}

public T getInstance(Class<T> obj) throws IllegalAccessException, InstantiationException {
	
	 if (instance == null) {
	        this.instance = obj.newInstance();
	    }
	    return instance;

}

//public Class<T> getInstance(Class<T> obj) throws IllegalAccessException, InstantiationException {
//    if (instance == null) {
//        this.instance = (T) obj.newInstance();
//    }
//    return (Class<T>) instance;
//}







	
	

/*	public T getInstance(Class<T> clazz) throws IllegalAccessException, InstantiationException {
		if (instance == null) {
			instance=new T;
			this.instance = clazz.newInstance();
		}
		return instance;
	}*/



}
