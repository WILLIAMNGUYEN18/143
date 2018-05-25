import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
public class DrawLine1 { 
	public static void main(String[] args) { //Create Drawing Panel
	DrawingPanel panel = new DrawingPanel(500,500);
	Color x = new Color(150,0,254);
	panel.setBackground(x);
//draw a line on the panel using the 
// the Graphics paintbruch 
	Graphics g = panel.getGraphics(); 
	
	g.setColor(Color.CYAN);
//draws a line starting at (25,75) and ending at (175,25) 
	g.drawLine(25, 75, 185, 30);
	g.setColor(Color.YELLOW);
	g.setFont(new Font("Serif", Font.ITALIC, 50));
		for(int i = 0; i < 500; i+=50){
			g.drawString("KEKEKEKEKE", 250  + (i/2),0+ i );
		}
//draws a circle in a bounded box 25x25 
//   the upper corner of which is located at(170,25) 
		for(int i = 0; i< 400; i++){
			g.drawOval(175,25 + i,25 + (i/2),25);
		}
		g.fillRect(10, 10, 75, 75);
		g.drawRect(10, 10, 75, 75);
		
		
	}
	
}