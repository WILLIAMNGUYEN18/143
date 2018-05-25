import java.util.*;

public class Section {
	private List<Item> zoneItems;
	private List<Entity> zoneEnemies;
	private List<Item> zoneObjects;
	private List<Boolean> zoneRequirements;
	//private List<Story> zoneStory
	
	public Section(List<Item> zoneItem,List<Entity> zoneEnemy,List<Item> zoneObject,List<Boolean> zoneReqs){
		this.zoneItems = zoneItem;
		this.zoneEnemies = zoneEnemy;
		this.zoneObjects = zoneObject;
		this.zoneRequirements = zoneReqs;
		
	}
	
	
	public Item getItem(int index){
		return zoneItems.get(index);
	}
	public Entity getEnemy(int index){
		return zoneEnemies.get(index);
	}
	public Item getObjects(int index){
		return zoneObjects.get(index);
	}
	public Boolean getReqs(int index){
		return this.zoneRequirements.get(index);
	}
	public void setReqs(int index){
		zoneRequirements.set(index, true);
	}
	

}
