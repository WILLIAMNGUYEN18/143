/*
project name: WillLab3
filename: TimeCode
authors' last name: William Nguyen
last modification date: 4/13/2016
program description:
Creating a time code that holds different amounts of time, and is
also class invariant.
Hours cannot be more than 23, Minutes cannot be more than
59, Seconds cannot be more than 59, 
and frames cannot be more than 23.
No field
should have a negative number.

*/
import java.util.*;
import java.io.*;

public class TimeCode {
private int hours = 0;//<=23
private int minutes = 0;//<=59
private int seconds = 0;//<=59
private int frames = 0;//<=29

/*Applies the addTo which also enforces the class invariant
 * 
 * */
	public TimeCode(int hour, int min, int sec, int frame){

		this.addTo(hour, min, sec, frame);
		
	}	
	/*returns true if anything is negative
	 * otherwise, returns false.
	 * Used for class invariant
	 * 
	 * */
	public boolean checkNegative(int hour, int min, int sec, int frame){
		if(hour <0){
			return true;
		}
		if(min< 0){
			return true;
		}
		if(sec < 0){
			return true;
		}
		if(frame < 0){
			return true;
		}
		return false;
	}
/*Checks for negatives
 * then converts hours into minutes
 * minutes to seconds
 * seconds to frames, adding frames to get all the frames
 * then limits and converts frames to seconds,
 * seconds to minutes, minutes to hours
 * and caps them off at 59,59, 23 respectively
 * 
 * */
	public void addTo(int hour, int min, int sec, int frame){
		if(this.checkNegative(hour, min, sec, frame)){
			throw new InputMismatchException("You aren't allowed to have negative values");
			
		}
		
		//converting hours to minutes and adding it to minutes
		this.minutes += (this.hours + hour) * 60;
		//converting from minutes to seconds
		this.seconds += (this.minutes + min) * 60;
		//seconds to frames
		this.frames += ((this.seconds + sec) * 30) + frame;
		
		//limiting frames, seconds, minutes, and hours.
		if(this.frames > 29){
			this.seconds = this.frames/30;
			this.frames = this.frames%30;
		
		
		}
		if(this.seconds > 59){
			this.minutes = this.seconds/60;
			this.seconds = this.seconds%60;
		
		
		}
		if(this.minutes > 59){
			this.hours = this.minutes / 60;
			this.minutes = this.minutes%60;
		
		}
		//throw an exception if it surpasses 23hours
		if(this.hours > 23){
			throw new InputMismatchException("the time you have used has surpassed 23 hours, please reduce the time.");
		}
		
	}
	
	/*Applies the addTo method for addition, using getters for the hours through frames values
	 * return the TimeCode result.
	 * 
	 * */
	public TimeCode addition(TimeCode other){
		
		this.addTo(other.getHour(), other.getMinute(), other.getSecond(), other.getFrame());
		TimeCode store = this;
		return store;
	}
	/*
	 * 
	 * 
	 * 
	 * creates a set of variables for other timecode and this one
	 * Uses them to convert both this instance of time and the other to frames
	 * subtracts this timecode from the other, checks for negativity before creating a timecode.
	 * return ths resulting time code*/
	public TimeCode subtractFrom(TimeCode other){
		int hour = 0, min = 0, sec = 0, frame = 0;
		int hours2 = 0, minutes2 = 0,seconds2 = 0,frames2 = 0;
		//taking in the other Timecode
		hours2 = other.getHour();
		minutes2 = other.getMinute();
		seconds2 = other.getSecond();
		frames2 = other.getFrame();
		//converting the timecode from hours into frames2, ruining all involved variables besides frames 2 in the process.
		minutes2 += (hours2 * 60);
		seconds2 += minutes2 * 60;
		frames2 += seconds2 * 60;
		
		
		//converting hours to minutes and adding it to minutes for original.
		min= (this.hours) * 60;
		//converting from minutes to seconds
		sec= (this.minutes + min) * 60;
		//seconds to frames
		frame = (this.seconds + sec) * 60;
		//do subtraction of frames2 from frame
		frames2 = frames2 - frame;
		//check for negative, then convert back into a timecode.
		if(this.checkNegative(0,0,0,frames2)){
			throw new InputMismatchException("You have subtracted more time than the TimeCode has.");
		}
		//creating a new timecode goes through the addTo method which would work with the 0s for sec, min, hour
		//and the high frames and converts the frames into the rest of it.
		TimeCode store = new TimeCode(0,0,0,frames2);
		return store;
	}
	/*returns string of hours through frames in same format as EDL example.
	 * 
	 * */
	public String toString(){
		
		return this.hours + ":" + this.minutes + ":" + this.seconds + ":" + this.frames;
	}
	
	
	/*returns each field
	 * 
	 * */
	public int getHour(){
		return this.hours;
		
	}
	
	public int getMinute(){
		return this.minutes;
		
	}
	
	public int getSecond(){
		return this.seconds;
		
	}
	
	public int getFrame(){
		return this.frames;
		
	}
}
