package com.dyafysis.gmail.com.dyafysis.gmail;

public class FactoryTest {



/*private FactoryTest(T data) {
	instance=null;
	this.data=data;
}

private FactoryTest() {
	instance=null;
	this.data=null;
}*/

public static <T> T instaceWithDriver(final Class<T> data) throws InstantiationException, IllegalAccessException{
	return data.newInstance();
}
}
