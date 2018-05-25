
public class Event {
private int eventNumber = 0;
private int camera = 0;
private int take = 0;
private int scene = 0;
private TimeCode start = null;
private TimeCode end = null;
private String description = "";

/*Initializes all the values for Event.
 * even, camera, scene, take, ending and starting time codes, and description
 * 
 * 
 * */
	public Event(int event,int cam, int tak, int scen, TimeCode s, TimeCode e, String desc){
		this.eventNumber = event;
		this.camera = cam;
		this.take = tak;
		this.scene = scen;
		this.start = s;
		this.end = e;
		this.description = desc;
	}
	/*getters for all the fields
	 * 
	 * */
	public int getEvent(){
		return this.eventNumber;
	}
	public int getCamera(){
		return this.camera;
	}
	public int getTake(){
		return this.take;
	}
	public int getScene(){
		return this.scene;
	}
	public TimeCode getStart(){
		return this.start;
	}
	public TimeCode getEnd(){
		return this.end;
	}
	public String getDescription(){
		return this.description;
	}
	/*returns even, scene,  take, caerma, start, end, desc in that order
	 * spaces inbetween each section.
	 * */
	public String toString(){
		return this.eventNumber + " " + this.scene + " " + this.take + " " + this.camera + " " + this.start.toString() + " " + this.end.toString() + " " + this.description; 
	}
}
