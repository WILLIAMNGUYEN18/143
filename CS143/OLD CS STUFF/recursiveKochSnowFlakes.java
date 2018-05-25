import java.awt.Graphics;
import java.awt.Point;
import java.util.Scanner;
/*project name: WillLab7
filename: recursiveKochSnowflake
authors names: William Nguyen
last modification date: 5/18/2016
program description:
takes input of number and creates a snowflake image out of triangles, triangles being made out of lines, 
 recursively. 
 * */
public class recursiveKochSnowFlakes {
	
	/*We ask the user for an integer input, create a drawing panel
	 * and graphics and apply the integer as the level/complexity
	 * of the drawSnow algorithm that actually draws
	 * all the lines involved in drawSnow
	 * */
	public static void main(String[] args){

		System.out.println("Please input a number");
		Scanner input = new Scanner(System.in);
		
		int level = input.nextInt();
		DrawingPanel panel = new DrawingPanel(1000,1000);
		Graphics g = panel.getGraphics();
        Point p1 = new Point(420,680);
        Point p2 = new Point(680,680);
        Point p3 = new Point(550,420);
        //bottom third of the recursive snowflake triangle
        drawSnowFlake(g,level,420,680,680,680);
        //Right third of the recursive snowflake triangle
        drawSnowFlake(g,level,680,680,550,420);
        //left third of the recursive snowflake triangle
        drawSnowFlake(g,level,550,420,420,680);
        

	}
    
	/*The recursive coding to do a koch snowflake. It breaks down the points into 4 int values
	 * and uses them. If the level is at the base case it actually draws the line, otherwise
	 * it creates the 3 sets of x and y values between each of the larger triangles.
	 * It is based off of how the equilateral triangle is built off of 2 30/60/90 triangles
	 * It then draws 4 separate parts from that point on that provides the splits between the
	 * 3 sides. Since it fractals, it requires more lines
	 * And since it recurs like this, it doesn't need to erase the base side
	 * of the triangle because it creates the lines corresponding to the complexity of the triangle.
	 * */
    private static void drawSnowFlake (Graphics g, int lev, int x1, int y1, int x5, int y5){
        int deltaX, deltaY, x2, y2, x3, y3, x4, y4;

        if (lev == 0){
        	//base case to draw a line of the triangles
            g.drawLine(x1, y1, x5, y5);
        }
        else{
        	//find the change between the two points
              deltaX = x5 - x1;
              deltaY = y5 - y1;
              //set the 2nd to 1/3 between the first and 5th point
              x2 = x1 + deltaX / 3;
              y2 = y1 + deltaY / 3;
              //setting x,y to be the third point that extends out between p1 and p2
              //values are from 30/60/90 triangle, the hyp being 2x, 30 side being x, and the longer leg being x*sqrt(3)
              x3 = (int) (0.5 * (x1+x5) + Math.sqrt(3) * (y1-y5)/6);
              y3 = (int) (0.5 * (y1+y5) + Math.sqrt(3) * (x5-x1)/6);
              //finding the 3rd point which is 2/3rd between the first and 5th point
              x4 = x1 + 2 * deltaX /3;
              y4 = y1 + 2 * deltaY /3;

              
              /*
               * Breaking the spread into multiple different layers.
               * This, I got a bit of help on, and it's partially beyond me
               * to explain how it works, but it spreads out the snowflake
               * into different layers with each snowflake so that
               * each drawSnowflake covers multiple separate lines across
               * multiple sides.
               * 
               * */
              drawSnowFlake(g,lev-1, x1, y1, x2, y2);
              
              
              drawSnowFlake(g,lev-1, x2, y2, x3, y3);
              
              
              drawSnowFlake(g,lev-1, x3, y3, x4, y4);
              
              
              drawSnowFlake(g,lev-1, x4, y4, x5, y5);
          }
      }

}
