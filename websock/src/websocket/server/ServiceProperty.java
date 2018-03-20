package websocket.server;




/**
 * 
 * @author ryo.yokoohji , prasanna.rajendran
 * 
 * This class holds the field values for the service from the znode
 * 
 */

public class ServiceProperty {
	
	// commented for making use of the exact field names of the znode properties.
	
	/*private String url;
	private String date;
	private String name;
	private String id;
	private int version;
	private String type;
	private String api;*/
	
	
	private String serviceUrl;
	public String getServiceUrl() {
		return serviceUrl;
	}

	public void setServiceUrl(String serviceUrl) {
		this.serviceUrl = serviceUrl;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getServiceID() {
		return serviceID;
	}

	public void setServiceID(String serviceID) {
		this.serviceID = serviceID;
	}

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public String getServiceVersion() {
		return serviceVersion;
	}

	public void setServiceVersion(String serviceVersion) {
		this.serviceVersion = serviceVersion;
	}

	public String getServiceAPI() {
		return serviceAPI;
	}

	public void setServiceAPI(String serviceAPI) {
		this.serviceAPI = serviceAPI;
	}

	public String getApiGatewayAddress() {
		return apiGatewayAddress;
	}

	public void setApiGatewayAddress(String apiGatewayAddress) {
		this.apiGatewayAddress = apiGatewayAddress;
	}

	private String date;
	private String serviceName;
	private String serviceID;
	private String serviceType;
	private String serviceVersion;
	private String serviceAPI;
	private String apiGatewayAddress;
	
	
	
	
	public ServiceProperty(){}
	
	public ServiceProperty(String serviceUrl,
			String date,
			String serviceName,
			String serviceID,
			String serviceVersion,
			String serviceType,
			String serviceAPI){
		this.serviceUrl = serviceUrl;
		this.date = date;
		this.serviceName = serviceName;
		this.serviceID = serviceID;
		this.serviceVersion = serviceVersion;
		this.serviceType = serviceType;
		this.serviceAPI = serviceAPI;
	}
	
/*	public ServiceProperty(String jsonData){
		JSONObject obj = new JSONObject(jsonData);
		
		this.setUrl(obj.getString("url"));
		this.setDate(obj.getString("registrationDate"));
		this.setName(obj.getString("name"));
		this.setId(obj.getString("id"));
		this.setVersion(obj.getInt("version"));
		this.setType(obj.getString("type"));
		this.setApi(obj.getString("api"));
	}*/
	
	
	

/*	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getApi() {
		return api;
	}

	public void setApi(String api) {
		this.api = api;
	}*/
}
