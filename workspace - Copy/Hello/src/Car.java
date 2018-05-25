import java.awt.*;
public class Car { 
	public static void main(String[] args) {
		DrawingPanel panel = new DrawingPanel(500, 500); 
		panel.setBackground(Color.LIGHT_GRAY); 
		Graphics g = panel.getGraphics();
		//spotLight(g,panel);
	drawCar(g,panel);
	
		
	} 
	public static void drawCar(Graphics g, DrawingPanel panel){
		for(int i = 0; i < 1000; i++){
			panel.clear();
			//g.fillRect(10 + i/2, 10 + i/2, 100, 100);
		
		g.setColor(Color.BLACK); 
		g.fillRect(10 + i, 30, 100, 50);
		g.setColor(Color.RED); 
		g.fillOval(20 + i, 70, 20, 20); 
		g.fillOval(80 + i, 70, 20, 20);
		g.setColor(Color.CYAN); 
	g.fillRect(80+ i, 40 , 30, 20); 
		}
	}
	/*
	public static void spotLight(Graphics g, DrawingPanel panel){
		int n = 0;
		
			while(n > -100 || n < 100){
				n--;
				if(n >= 99){
					n--;
				}
				if(n<= -99){
					n+=2;
				}
				for(int i = 0; i< 400; i++){
			g.drawOval(175,25 + i,25 + (i/2) + n,25);
				}
		}
	}
	*/
	public static void spotLight(Graphics g){
		int x= 10;
		int y = 1;
		int n = 1;
		g.drawLine(250, 0 + y, x, 300);
		for(int i = 0; i< 400; i++){
			while(n > -100 && n < 100){
			g.drawOval(175,25 + i,25 + (i/2),25);
			}
		}
		
	}
}