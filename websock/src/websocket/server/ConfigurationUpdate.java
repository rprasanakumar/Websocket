package websocket.server;



import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;

import com.google.common.io.Files;
import com.google.gson.Gson;


/**
 * This class uses the Configuration map for constructing the configuration file.
 * @author prasanna.rajendran
 *
 */

public class ConfigurationUpdate {
	
	private static ConfigurationUpdate configurationUpdate;
	
	private ConfigurationUpdate() {
		
	}
	
	/**
	 * Method adds the registered service's UUID and Data to the {@link RegisteredService}
	 * @param uuid
	 * @param data
	 * @return {@link ConfigurationUpdate configurationUpdate}
	 */
	
	public static ConfigurationUpdate add(String uuid,String data) {
		System.out.println("Adding service");
		if(uuid==null||uuid.isEmpty()) {
			return configurationUpdate;
		}
		 RegisteredService.getInstance().addService(uuid, data);
		if(configurationUpdate==null) {
			configurationUpdate = new ConfigurationUpdate();
		}
		
		return configurationUpdate;
	}
	
	
	/**
	 * Method removes the uuid from the RegisteredService
	 * @param uuid
	 * @return {@link ConfigurationUpdate configurationUpdate} 
	 */
	
	public static ConfigurationUpdate remove(String uuid) {
		
		if(uuid==null||uuid.isEmpty()) {
			return configurationUpdate;
		}
		 RegisteredService.getInstance().removeService(uuid);
	
		if(configurationUpdate==null) {
			configurationUpdate = new ConfigurationUpdate();
		}
		return configurationUpdate;
	}

	/**
	 * this method performs Nginx conf update operation
	 * 1. {@link #writeFile()}
	 * 2. {@link #runBackUpNreLoad()}
	 */
	/*public Services update() {
		ConcurrentMap<String, Service> regService=RegisteredService.getInstance().getServiceMap();
		List<Znode>output=new ArrayList<>();
		Services services=null;
		for(String key:regService.keySet()) {
			Znode sp=RegisteredService.getInstance().getData(key);
			output.add(sp);
		}
		services=Services.getInstance();
		services.setServices(output);
			
		return services;
	}*/
	
}
