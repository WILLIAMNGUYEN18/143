import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;

public class KochSnowflake {
	//private static int iterations;
	
	
	public static void main(String[] args){
		DrawingPanel panel = new DrawingPanel(1000,1000);
		Graphics g = panel.getGraphics();
		Snowflake(1, g);
	}
	public static void Snowflake(int n, Graphics g){
		//this.iterations = n;
		//Point p1 = new Point(500,900);
		//Point p2 = new Point(900,900);
		//Point p3 = new Point(100,100);
		//Snowflake(n, p1,p2);
		  Point p1 = new Point(420,680);
	      Point p2 = new Point(680,680);
	      Point p3 = new Point(550,420);
	        drawSnowFlake(g,n,p1,p2);
	        //Right third of the recursive snowflake triangle
	        drawSnowFlake(g,n,p2,p3);
	        //left third of the recursive snowflake triangle
	        drawSnowFlake(g,n,p3,p1);
		
	}
	/*Does a sierpinski recursive triangle. 775-778
	 * public static void drawFigure(int level, Graphics g, Point p1, Point p2, Point p3){
	 * 		if(level == 1){
	 *			polygon p = new Polygon();
	 *			p.addPoint(p1.x, p1.y);
	 * 			p.addPoint(p2.x, p2.y);
	 * 			p.addPoint(p3.x, p3.y);
	 * 			g.fillPolygon(p);
	 * 		}
	 * 		else{
	 * 			Point p4 = midpoint(p1, p2);
	 *  		Point p4 = midpoint(p2, p3);
	 * 			Point p6 = midpoint(p1, p3);
	 * 			DrawFigure(level - 1,g, p1, p4, p6);
	 * 			DrawFigure(level - 1,g, p4, p2, p5);
	 * 			DrawFigure(level - 1,g, p6, p5, p3);
	 * 		}
	 * }
	 * */
	private static void drawSnowFlake (Graphics g, int lev, Point p1, Point p2){
        int deltaX, deltaY;
        Point p3 = new Point();
        Point p4 = new Point();
        Point p5 = new Point();

        if (lev == 0){

            g.drawLine((int)p1.getX(),(int)p1.getY(), (int)p2.getX(),(int) p2.getY());
        }
        else{
              //deltaX = x5 - x1;
              //deltaY = y5 - y1;
        	//finding difference of 2 points
        	deltaX = (int) (p2.getX() - p1.getX());
        	deltaY = (int) (p2.getY() - p1.getY());
              //x2 = x1 + deltaX / 3;
              //y2 = y1 + deltaY / 3;
        	//
        	p3.setLocation((int)p1.getX() + deltaX/3,(int) p1.getY() + deltaY/3);
              //x3 = (int) (0.5 * (p1.getX()+ p2.getX()) + Math.sqrt(3) * (p1.getY()-p2.getY())/6);
              //y3 = (int) (0.5 * (p1.getY()+p2.getY()) + Math.sqrt(3) * (p2.getX()-p1.getX())/6);
              //setting x,y to be the third point that extends out between p1 and p2
              //half is from 30/60/90 triangle, the hyp being 2x, 30 side being x, and the longer leg being x*sqrt(3) 
              p4.setLocation((int) (0.5 * (p1.getX()+ p2.getX()) + Math.sqrt(3) * (p1.getY()-p2.getY())/6), 
            		  (int) (0.5 * (p1.getY()+p2.getY()) + Math.sqrt(3) * (p2.getX()-p1.getX())/6));
              //x4 = x1 + 2 * deltaX /3;
              //y4 = y1 + 2 * deltaY /3;
              p5.setLocation((int)p1.getX() + 2 * deltaX/3,(int) p1.getY() + 2 * deltaY/3);

              drawSnowFlake(g,lev-1, p1, p3);
              
              
              drawSnowFlake(g,lev-1, p3, p4);
              
              
              drawSnowFlake(g,lev-1, p4,p5);
              
              
              drawSnowFlake(g,lev-1, p3, p2);
          }
      }
}
