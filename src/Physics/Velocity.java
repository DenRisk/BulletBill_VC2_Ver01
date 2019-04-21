package Physics;

import Controller.GameScreenController;

public class Velocity {

    public static double startVx = GameScreenController.startVx;
    public static double startVy = GameScreenController.startVy;

    public static double getStartVx() {
        return startVx;
    }

    public static void setStartVx(double startVx) {
        Velocity.startVx = startVx;
    }

    public static double getStartVy() {
        return startVy;
    }

    public static void setStartVy(double startVy) {
        Velocity.startVy = startVy;
    }

}
