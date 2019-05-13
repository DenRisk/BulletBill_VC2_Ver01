package Collision;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Circle_Circle_Collision {

    public static double getDistance(double aC_x, double aC_y, double cC_x, double cC_y) {
        double xDistance = cC_x - aC_x;
        double yDistance = cC_y - aC_y;
        return Math.sqrt(Math.pow(xDistance, 2) + Math.pow(yDistance, 2));
    }

    public static void cicleDetection(Circle aC, Circle cC) {
        if ( getDistance(aC.getCenterX(), aC.getCenterY(), cC.getCenterX(), cC.getCenterY()) < aC.getRadius() + cC.getRadius()) {
            cC.setFill(Color.RED);
        }
        else {
            cC.setFill(Color.BLACK);
        }
    }

}
