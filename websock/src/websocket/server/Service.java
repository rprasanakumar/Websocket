package websocket.server;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;



public class Service {
	
	private String zookeeperAddress;
	
	private String serviceUrl;
	
	private String serviceName;
	
	private String serviceType;
	
	private String serviceVersion;
	
	private String serviceAPI;
	
	private String apiGatewayAddress;
	
	private String serviceImage;
	
	public String getServiceImage() {
		return serviceImage;
	}
	public void setServiceImage(String serviceImage) {
		this.serviceImage = serviceImage;
	}
	
	public String getApiGatewayAddress() {
		return apiGatewayAddress;
	}
	public void setApiGatewayAddress(String apiGatewayAddress) {
		this.apiGatewayAddress = apiGatewayAddress;
	}
	public String getZookeeperAddress() {
		return zookeeperAddress;
	}
	public void setZookeeperAddress(String zookeeperAddress) {
		this.zookeeperAddress = zookeeperAddress;
	}
	public String getServiceUrl() {
		return serviceUrl;
	}
	public void setServiceUrl(String serviceUrl) {
		this.serviceUrl = serviceUrl;
	}
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
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

}
