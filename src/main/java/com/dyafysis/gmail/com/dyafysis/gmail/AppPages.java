package com.dyafysis.gmail.com.dyafysis.gmail;

public interface AppPages<T> {
    /**
     * Returns the object of a class of type T
     * @param <T>
     * @param obj
     * @return
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
	
    T getInstance(Class<T> obj) throws IllegalAccessException, InstantiationException;

}
