/**
 * This class is used to launch all the tests
 */

package model;

import java.lang.reflect.*;


public class TestLauncher{
    
    public static void main(String[] args) throws Exception{
	Class[] cls = new Class[args.length];

	for (int i=0; i < cls.length; ++i){
		cls[i] = Class.forName(args[i]);
	    }
	for (int j=0; j < cls.length; ++j){	    
		launch(cls[j]);
	    }
    }

static private void launch(Class c) throws Exception{
        
	Method[] m = c.getDeclaredMethods();
	Object test;
	int nbTest = 0;

	System.out.print(c.getName() + " ");

	for (int i=0; i < m.length; ++i) {
	    if (m[i].getName().startsWith("test")){
		test = c.newInstance();
		m[i].invoke(test); 
		System.out.print("."); nbTest++;
	    }
	}
	System.out.println("OK, "+nbTest+" valide(s)");
    }
}
