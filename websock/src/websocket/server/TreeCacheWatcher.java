package websocket.server;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


import com.google.common.base.Optional;
import com.google.gson.Gson;
import com.orbitz.consul.AgentClient;
import com.orbitz.consul.Consul;
import com.orbitz.consul.KeyValueClient;
import com.orbitz.consul.model.kv.Value;

/**
 * The watcher class responsible for looking for node addition, deletion and update
 * in the Znode tree hierarchy
 * 
 * Implements runnable. The main thread waits until a event is notified in the tree hierarchy
 * 
 * @author prasanna.rajendran
 *
 */

public class TreeCacheWatcher implements Runnable{
	 
	 
	 private static final String PATH = "/services";
	 private static  boolean running;
	  private static Consul agent;
	 private static final int THREAD_COUNT=1;
	 private static final ExecutorService executor= Executors.newFixedThreadPool(THREAD_COUNT);
	 private static int initial_size=0;
	public static void main() {
		Consul consul = null;
		try {
			consul = Consul.builder().withUrl(new URL("http://150.16.239.108:8500/")).build();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 running=true;
		 agent = consul;
		 
		 for(int i=0; i<THREAD_COUNT;i++) {
			 TreeCacheWatcher worker=new TreeCacheWatcher();
			 executor.submit(worker);
		 }
	}
	
	/**
	 *  Tree listener
	 * @param cache
	 */
/*	 private static void addListener( final TreeCache cache)
	    {
	     
		 TreeCacheListener listener = new TreeCacheListener() 
	        {
	            public void childEvent(CuratorFramework client,
	            		TreeCacheEvent event) throws Exception
	            {
	                switch ( event.getType() )
	                {
	                    case NODE_ADDED:
	                    {
	                        ConfigurationUpdate.add(event.getData().getPath(), new String(event.getData().getData())).update();
	                        CustomEndPoint.sendAll();
	                        break;
	                    }
	                    
	                    case NODE_REMOVED:
	                    {
	                        ConfigurationUpdate.remove(event.getData().getPath()).update();
	                        CustomEndPoint.sendAll();
	                        break;
	                    }
	                    
	                    case NODE_UPDATED:
	                    {
	                        ConfigurationUpdate.add(event.getData().getPath(), new String(event.getData().getData())).update();
	                        CustomEndPoint.sendAll();
	                        break;
	                    }
	              
					case CONNECTION_LOST:
						break;
					case CONNECTION_RECONNECTED:
						break;
					case CONNECTION_SUSPENDED:
						break;
					case INITIALIZED:
						break;
					default:
						break;	
	                }
	            }
	        };
	        cache.getListenable().addListener(listener);
	    }*/


	public void run() {

		 try {
			 
			synchronized(this){
				while (TreeCacheWatcher.running){
					agent.agentClient().getServices().size();
					 
					 if(initial_size!=agent.agentClient().getServices().size()) {
								List<Znode>output=new ArrayList<>();
								Services services=null;
								for(String key:agent.agentClient().getServices().keySet()) {
									Gson gson=new Gson();
									List<String> sp=agent.keyValueClient().getValuesAsString(key);
									if(sp==null||sp.isEmpty()) {
										continue;
									}
									output.add(gson.fromJson(sp.get(0).toString(), Znode.class));
								}
								services=Services.getInstance();
								services.setServices(output);
							}
					 
						 //CustomEndPoint.sendAll();
						 
						// Thread.sleep(500);
					 }
					
			}
			}
		 catch (Exception e) {
			e.printStackTrace();
		}
		
	}


}
