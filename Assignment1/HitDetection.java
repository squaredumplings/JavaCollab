/**
 * Detects if a point hits any of two circles.
 * 
 * Usage:
 * The Circle Hit Detection Program is designed to determine whether a given point in a 2D
 * Cartesian coordinate system hits one or both of two circles. 
 * In this context, "hitting" means that
 * the point is either inside the circle or on its border.
 * 
 * This program is useful for various applications, including graphical user interfaces, games,
 * and simulations, where you need to check if a point intersects with certain shapes.
 * 
 * Input Specification:
 * The program uses the following inputs, all double floating-point values, read from the console:
 *     The x-coordinate of the center of the first circle.
 *     The y-coordinate of the center of the first circle.
 *     The radius of the first circle.
 *     The x-coordinate of the center of the second circle.
 *     The y-coordinate of the center of the second circle.
 *     The radius of the second circle.
 *     The x-coordinate of the point.
 *     The y-coordinate of the point.
 * 
 * Example:
 * input       : 0 0 3.1 0.25 0.13 1 2.1 2.03
 * output      : The point hits the first circle
 * 
 * @author Eusebiu Pusca
 * @ID 1947079
 * @author Mihnea Buzoiu
 * @ID 1923552
 * 
 */
import java.util.Scanner;

class HitDetection {
    public void run() {
        // initialize variables
        double circlex1 = 0;
        double circley1 = 0;
        double circler1 = 0;

        double circlex2 = 0; 
        double circley2 = 0;
        double circler2 = 0;

        double pointx = 0; 
        double pointy = 0;

        Scanner scanner = new Scanner(System.in);
        
        for (int i = 0; i < 8; i++) {
            boolean inside1 = false;
            boolean inside2 = false;
            
            // read variables
            circlex1 = scanner.nextDouble();
            circley1 = scanner.nextDouble();
            circler1 = scanner.nextDouble();

            circlex2 = scanner.nextDouble();
            circley2 = scanner.nextDouble();
            circler2 = scanner.nextDouble();

            pointx = scanner.nextDouble();
            pointy = scanner.nextDouble();


            // distance from the center of the circle to point followed by comparison with radius
            double distance1 = Math.sqrt((pointx - circlex1) * (pointx - circlex1)
                                       + (pointy - circley1) * (pointy - circley1));

            if (distance1 <= circler1) {
                inside1 = true;
            }

            double distance2 = Math.sqrt((pointx - circlex2) * (pointx - circlex2)
                                       + (pointy - circley2) * (pointy - circley2));

            if (distance2 <= circler2) {
                inside2 = true;
            }


            //test if the radius of both circles is positive; if not, print input error
            if(circler1 < 0 || circler2 < 0) {
                System.out.println("input error");
            }

            else if (inside1 && inside2) {
                System.out.println("The point hits both circles");
            } 

            else if (inside1 && !inside2) {
                System.out.println("The point hits the first circle");
            } 
            
            else if (!inside1 && inside2) {
                System.out.println("The point hits the second circle");
            }

            else if (!inside1 && !inside2) {
                System.out.println("The point does not hit either circle");
            }


        }
    }
    public static void main(String[] args) {
        new HitDetection().run();
    }
}

