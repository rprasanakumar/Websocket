package websocket.server;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.Gson;

@XmlRootElement(name="services")

public class Services {

	@XmlElement
	private List<Znode> services;
	private static Services servicesObj;
	private Services() {
		
	}
	public List<Znode> getServices() {
		return services;
	}

	public void setServices(List<Znode> services) {
		this.services = services;
	}
	
	public String toString() {
		Gson gSon=new Gson();
		return gSon.toJson(services);
		
	}
	
	public static Services  getInstance() {
		if(servicesObj==null) {
			servicesObj =new Services();
		}
		return servicesObj;
	}

}
