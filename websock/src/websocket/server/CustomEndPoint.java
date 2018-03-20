package websocket.server;

import java.text.DecimalFormat;
import java.util.*;
import java.util.concurrent.*;
import javax.websocket.*;
import javax.websocket.server.*;

import com.google.gson.Gson;

@ServerEndpoint("/getregisteredservice")
public class CustomEndPoint {
	
 private static Queue<Session> userQueue = new ConcurrentLinkedQueue<Session>();
 private static Thread serviceThread ;
 static
 {
	 TreeCacheWatcher.main();
	 
 }

 @OnMessage
 public void onMessage(Session session, String msg) {
//provided for completeness, in out scenario clients don't send any msg.
  try {   
	  if(!msg.equals("Message Received"))
		  sendAll(msg);
   System.out.println("received msg "+msg+" from "+session.getId());
  } catch (Exception e) {
   e.printStackTrace();
  }
 }

@OnOpen
 public void open(Session session) {
	userQueue.add(session);
	sendAll("New Connection added");  
  System.out.println("New session opened: "+session.getId());
 }

  @OnError
 public void error(Session session, Throwable t) {
	  userQueue.remove(session);
  System.err.println("Error on session "+session.getId());  
 }

 @OnClose
 public void closedConnection(Session session) { 
	 userQueue.remove(session);
  System.out.println("session closed: "+session.getId());
 }

 public static void sendAll(String s) {
  try {
   /* Send the new rate to all open WebSocket sessions */  
   ArrayList<Session > closedSessions= new ArrayList<>();
   for (Session session : userQueue) {
    if(!session.isOpen())
    {
     System.err.println("Closed session: "+session.getId());
     closedSessions.add(session);
    }
    else
    {
    	//Gson gson=new Gson();
    	//session.getBasicRemote().sendText(gson.toJson(Services.getInstance()));
    	session.getBasicRemote().sendText(s);
    }    
   }
   userQueue.removeAll(closedSessions);
  } catch (Throwable e) {
   e.printStackTrace();
  }
 }
}