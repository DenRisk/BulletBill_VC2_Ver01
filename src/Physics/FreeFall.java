package Physics;

import Sprite.Sphere;

public class FreeFall {


    public static boolean level = true;
    public static boolean change = true;

    public FreeFall(Sphere Sphere, double secondpassed) {
        if (change){
            Time.curTime = System.currentTimeMillis();
            change = false;
        }

        Time.updateTime();
        if (level == true) {
            movingBall(Sphere, secondpassed);
        }
    }

    private void movingBall (Sphere sphere, double secondpassed) {
                    move(sphere);
                if (secondpassed == 200) {
                    level = false;
                }
        }


    private void move(Sphere sphere) {

        double a = 100;

        double vy = sphere.getVy() + (9.81 * Time.timeFraction);
        sphere.updateVelocity(0, vy, 0);

        double newPos_y = sphere.getY0() + Time.timeFraction * sphere.getVy() + 0.5 * a * (Time.timeFraction * Time.timeFraction);

        sphere.updatePos(sphere.getX0(), newPos_y, sphere.getZ0());
    }




}
