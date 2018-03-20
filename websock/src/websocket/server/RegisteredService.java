package websocket.server;




import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import com.google.gson.Gson;

/**
 * Stores all registered services to zookeeper.
 * @author ryo.yokoohji
 */
public class RegisteredService {
	private String apiName;
	private ConcurrentMap<String, Service> serviceMap;
	private static RegisteredService service;
	
	
/*	public RegisteredService(){
		this.serviceMap = new ConcurrentHashMap<String, ServiceProperty>();
	}*/
/*	
	public RegisteredService(String apiName){
		this();  // call default constructor
		// set api name.
		this.apiName = apiName;
	}*/
	
	private RegisteredService() {
		this.serviceMap = new ConcurrentHashMap<String, Service>();
	}
	public static RegisteredService getInstance() {
		if(service==null) {
			service=new RegisteredService();
		}
		return service;
	}
	
	// parser the given data to require POJO(ServiceProperty.class) type
	private Service parseData(String data){
		Gson gson = new Gson(); 
		return gson.fromJson(data, Service.class);
	}
	
	public void addService(String uuid, String data){
		if(data==null||data.isEmpty()) {
			return;
		}
		//Service service =parseData(data);
		/*Service storedServcie=null;
		if(serviceMap.containsKey(service.getServiceName())) {
			storedServcie= serviceMap.get(service.getServiceName());
			ArrayList<String> apiList= storedServcie.getServiceAPI();
			apiList.add(service.getServiceAPI().get(0));
			storedServcie.setServiceAPI(apiList);	
		}else {
			storedServcie=service;
		}*/
		this.serviceMap.put(uuid, parseData(data));
	}
	
	public void removeService(String uuid) {
		this.serviceMap.remove(uuid);
	}
	
	public Service getData(String uuid) {
		return this.serviceMap.get(uuid);
	}
	
	public String getApiName(){
		return this.apiName;
	}
	
	public void setApiName(String apiName){
		this.apiName = apiName;
	}
	
	public ConcurrentMap<String, Service> getServiceMap(){
		return this.serviceMap;
	}
}
