import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
public class Book { 
	public static void main(String[] args) { //Create Drawing Panel
	DrawingPanel panel = new DrawingPanel(500,500);
	Color x = new Color(150,0,254);
	panel.setBackground(Color.WHITE);
	Graphics g = panel.getGraphics();
	stairs(g,20,35, 0.8);
	stairs(g, 150, 300,1.5);
	stairs(g,400,400, 0.5);
	stairs(g,100,100, 2.0);
	}
	public static void stairs(Graphics g, int x, int y, double scale){
		g.setColor(Color.CYAN);
		g.fillRect(x, y, (int)(100 * scale), (int)(100 * scale));
		g.setColor(new Color(191,118,73));
		for(int i = 0; i < 10; i++){
			g.fillRect(x , (int)(y + (i + i*10) * scale), (int)(scale*(10 + (i * 10))), (int)(scale*9));
		}
		g.setColor(Color.RED);
		g.setFont(new Font("Serif", Font.ITALIC, (int)(10 * scale) ));
		g.drawString("BJP", (x + (int)(50 * scale)), (y + (int)(20 * scale)));
	}
}