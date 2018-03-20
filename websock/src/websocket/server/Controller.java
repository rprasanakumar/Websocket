package websocket.server;

import java.util.concurrent.ConcurrentHashMap;




import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

//import Response;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.JsonArray;

//@RequestMapping("/service")

@RestController
public class Controller {

	ConcurrentHashMap<Integer, Job> table= new ConcurrentHashMap<Integer, Job>();
	Integer jobId=0;
    
    @RequestMapping(value="/status", method = RequestMethod.GET)
   	public String deviceStatus()
       {

       	ResponseEntity<String> returnResponse = new ResponseEntity<>("Hello from label printing. My status", HttpStatus.OK);
       	
       	return returnResponse.toString();
       }
    
    @RequestMapping(value="/home", method = RequestMethod.GET)
   	public String deviceHome()
       {

       	ResponseEntity<String> returnResponse = new ResponseEntity<>("Hello from label printing. My status", HttpStatus.OK);
       	
       	return "<html><body><h3>Home Page of Label Printing</h3></body></html>";
       }
    
    
    @RequestMapping(value = "/job",
            method = RequestMethod.POST,
            consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.CREATED)
    public void createJob(@RequestBody Job job,
                                 HttpServletRequest request, HttpServletResponse response) {
    	
       table.put(++jobId, job);
    }
    
    @RequestMapping(value = "/jobs",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    public
    @ResponseBody
    String getAllJob() {
    	JsonArray array= new JsonArray();
    	for(int key:table.keySet()){
    		Gson jsonObj =new Gson();
    		array.add(jsonObj.toJson(table.get(key), Job.class));
    		break;
    	}
		return array.getAsString();    	
    }

    
}
