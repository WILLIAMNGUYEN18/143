
public class ItemConstruction {
	public static void main(String args){
		//melee
		Weapon club = new Weapon("Club",5,"Simple. Effective. Satisfying.",true,10,false);
		Weapon boxingGloves = new Weapon("Boxing Gloves",15,"Float like a bloatfly, sting like a Beedrill",true,5,false);
		Weapon knife = new Weapon("Knife",5,"Knife to meet ya.",true,7,false);
		Weapon sword = new Weapon("Sword",10,"Glorified Toothpick",true,20,false);
		Weapon mace = new Weapon("Mace",10,"Nothing like a little mace to face",true,20,false);
		Weapon longSword= new Weapon("Long Sword",15,"Helps get your point across",true,20,false);
		Weapon lightSaber = new Weapon("Light Saber",10,"Who needs skill when you have a sword made of light?",true,100,false);
		
		
		//ranged
		//Weapon knife = new Weapon("knife",5,"Knife to meet ya.",true,7,true);
		
		//Potions
		Consumables healthPoultice = new Consumables("Health Poultice", 0, "Cures everything besides the sniffles",25);
		Consumables intelligencePotion = new Consumables("Intelligence Potion", 25, "Wish you had this in school",0);
		Consumables strengthPotion = new Consumables("Strength Potion", 25, "Side Effect: you won't be able to reach that itch on your back", 0);
		Consumables agilityPoiton = new Consumables("Agility Potion", 25, "You totally won't feel any repercussions in 4-6 hours", 0);
		
		//Armor sets
		//Armor(String nam, int bon, String desc, String part, int armor)
		Armor leatherHelm = new Armor("Leather Helm", 5, "For the bedroom and the battlefield","helmet", 10);
		Armor leatherTorso = new Armor("Leather Torso", 5, "For the bedroom and the battlefield","torso", 10);
		Armor leatherPants = new Armor("Leather Pants", 5, "For the bedroom and the battlefield","pants", 10);
		Armor leatherBoots = new Armor("Leather Boots", 5, "For the bedroom and the battlefield","boots", 10);
		Armor leatherGloves = new Armor("Leather Gloves", 5, "For the bedroom and the battlefield","gloves", 10);
				
		Armor chainMailHelm = new Armor("Chainmail Helm", 10, "Really effective against sharks, bullets, and bullet sharks.", "helmet", 30);
		Armor chainMailTorso = new Armor("Chainmail Torso", 10, "Really effective against sharks, bullets, and bullet sharks.", "torso", 30);
		Armor chainMailPants = new Armor("Chainmail Pants", 10, "Really effective against sharks, bullets, and bullet sharks.", "pants", 30);
		Armor chainMailBoots = new Armor("Chainmail Boots", 10, "Really effective against sharks, bullets, and bullet sharks.", "boots", 30);
		Armor chainMailGloves = new Armor("Chainmail Gloves", 10, "Really effective against sharks, bullets, and bullet sharks.", "gloves", 30);
		
		Armor kevlarHelm = new Armor("Kevlar Helmet",20, "Very high quality stuff", "helmet", 50);
		Armor kevlarTorso = new Armor("Kevlar Torso",20, "Very high quality stuff", "torso", 50);
		Armor kevlarPants = new Armor("Kevlar Pants",20, "Very high quality stuff", "pants", 50);
		Armor kevlarBoots = new Armor("Kevlar Boots",20, "Very high quality stuff", "boots", 50);
		Armor kevlarGloves = new Armor("Kevlar Gloves",20, "Very high quality stuff", "gloves", 50);
		
		Armor hazmatHelmet = new Armor("Hazmat Helmet", 100, "Not the greatest in protection, but there's something special about it...", "helmet", 5);
		Armor hazmatTorso = new Armor("Hazmat Torso", 100, "Not the greatest in protection, but there's something special about it...", "torso", 5);
		Armor hazmatPants = new Armor("Hazmat Pants", 100, "Not the greatest in protection, but there's something special about it...", "pants", 5);
		Armor hazmatBoots = new Armor("Hazmat Boots", 100, "Not the greatest in protection, but there's something special about it...", "boots", 5);
		Armor hazmatGloves = new Armor("Hazmat Gloves", 100, "Not the greatest in protection, but there's something special about it...", "gloves", 5);
		
		Armor plateHelmet = new Armor("Plate Helmet", 5, "Very burdensome, and yet very protective", "helmet", 100);
		Armor plateTorso = new Armor("Plate Torso", 5, "Very burdensome, and yet very protective", "torso", 100);
		Armor platePants = new Armor("Plate Pants", 5, "Very burdensome, and yet very protective", "pants", 100);
		Armor plateBoots = new Armor("Plate Boots", 5, "Very burdensome, and yet very protective", "boots", 100);
		Armor plateGloves = new Armor("Plate Gloves", 5, "Very burdensome, and yet very protective", "gloves", 100);
		
	
	}
}
/**
 * 
Health poultice
Intelligence Potion
Strength Potion
Agility Potion

Club
Boxing Gloves
Knife
Sword
Mace
Longsword
Lightsaber

Leather Armor
Chain Mail
Kevlar Armor
HAZMAT Suit
Plate Armor

Flashlight
Torch/
 */