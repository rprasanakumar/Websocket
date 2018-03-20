package websocket.server;

public class Job {
	
	public int getJobID() {
		return jobID;
	}
	public void setJobID(int jobID) {
		this.jobID = jobID;
	}
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	/*public String getEstimatedTime() {
		return estimatedTime;
	}
	public void setEstimatedTime(String estimatedTime) {
		this.estimatedTime = estimatedTime;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getFont() {
		return font;
	}
	public void setFont(String font) {
		this.font = font;
	}*/
	
	private int jobID;
	private String jobName;
/*	private String estimatedTime;
	private String category;
	private String font;
*/
}
