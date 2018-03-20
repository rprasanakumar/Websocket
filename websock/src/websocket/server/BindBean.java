package websocket.server;

import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;

/**
 * Annotation for binding the value from the properties file with the bean class {@link Znode, LogProperties} .
 * 
 * @author prasanna.rajendran
 *
 */

@Retention(RetentionPolicy.RUNTIME)
public @interface BindBean {
	
	/**
	 * This is the binding value of the Properties file with the bean class({@link Znode, LogProperties}) 
	 * 
	 * @return String
	 */
	
	String value();

}
