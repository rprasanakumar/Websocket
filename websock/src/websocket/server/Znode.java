package websocket.server;

import java.util.Properties;

import javax.enterprise.context.ApplicationScoped;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.lang.reflect.Field;

/**
 * A serializable bean class for holding the private parameters of the Znode.
 * 
 * @author prasanna.rajendran
 *
 */



@ApplicationScoped
public class Znode implements Serializable{
	
	private static final long serialVersionUID = 127423123407582193L;
	
	private static Znode znode=null;
	
	private Znode() {}
	

	@BindBean("zookeeper_address")
	private String zookeeperAddress;
	
	 @JsonProperty("Address")
	@BindBean("service_url")
	private String serviceUrl;
	
	@BindBean("service_description")
	@JsonProperty("Name")
	private String serviceName;
	
	@JsonProperty("Id")
	@BindBean("service_type")
	private String serviceType;
	
	@BindBean("service_version")
	private String serviceVersion;
	
	@BindBean("service_api")
	private String serviceAPI;
	
	@BindBean("api_gateway_url")
	private String apiGatewayAddress;
	
	@BindBean("service_image")
	private String serviceImage;
	
	@BindBean("service_port")
	@JsonProperty("Port")
	private String servicePort;
	
	public String getServicePort() {
		return servicePort;
	}
	public void setServicePort(String servicePort) {
		this.servicePort = servicePort;
	}
	public String getServiceImage() {
		return serviceImage;
	}
	public void setServiceImage(String serviceImage) {
		this.serviceImage = "data:image/gif;base64,"+serviceImage;
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
	
	public static Znode getInstance() {
		if(znode==null) {
			return new Znode();
		}
		
		return znode;
	}
	
	public void setZnode(Znode znode) {
		Znode.znode=znode;
	}
	
	
	
	
	
	/**
	 * Helper method which can set the properties value from the service properties file to the {@link Znode}
	 * 
	 * @param properties
	 * @param znode
	 */
	public void beanPropertiesBinder(Properties properties, Znode znode) {
		
		for(Field field: znode.getClass().getDeclaredFields()) {
			
			if(field.isAnnotationPresent(BindBean.class)) {
				BindBean bindbean=field.getAnnotation(BindBean.class);
				String fieldName=bindbean.value();
				String propertiesValue=properties.getProperty(fieldName);
				try {
					field.set(znode, propertiesValue);
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
			
		}
		
	}

}
