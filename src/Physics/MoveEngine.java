package Physics;

public class MoveEngine {

    private double gravity = 200;
    private static boolean getCurrentTime = true;

    public MoveEngine(long now) {

        if (getCurrentTime) {
            Time.curTime = System.currentTimeMillis();
            getCurrentTime = false;
        }
        Time.updateTime();
        buildSum();
        changeBulletCoordinates();

    }

    private void buildSum() {

        /**
         * Die Gravitation ("Schwerkraft", "Massenanziehung") ist eine Eigenschaft von Körpern, sich gegenseitig anzuziehen.
         * Voraussetzung für das Wirken dieser Kraft ist eine Masse.
         *
         * Erdanziehungskraft der Erde = 9,807 m/s²
         */

        // Der Ball fällt nach unten, deswegen wird sich die Gravitation nur auf die y-Achse aus
        // Die Fall-Geschwindigkeit wird erhöht

        double vx = Velocity.getStartVx() + (0 * Time.timeFraction);
        double vy = Velocity.getStartVy() + (gravity * Time.timeFraction);

        // Simuliert die Reibung/gegen wirkende Kraft am Boden/Luft, wodurch die Geschwindigkeit in x-Richtung abnimmt
        double drag = 1.0 - (Time.timeFraction * 0.4);

        //Wert muss aktualisiert werden, um damit weiterzuarbeiten --> Flüssige Bewegung

        Velocity.setStartVx(vx * drag);
        Velocity.setStartVy(vy);
    }

    private void changeBulletCoordinates() {

        double oldX = Coordinates.getStartX();
        double oldY = Coordinates.getStartY();

        double newX = oldX + (Velocity.getStartVx() * Time.timeFraction);
        double newY = oldY + (Velocity.getStartVy() * Time.timeFraction);

        Coordinates.setStartX((float) newX);
        Coordinates.setStartY((float) newY);

        checkGround(newY);
        checkWall(newX);
    }

    private void checkGround(double groundY){
        if (groundY > 570){
            Coordinates.setStartY(570);

            // Wichtige Formel
            Velocity.setStartVy(-Velocity.getStartVy() * 0.6);
        }
    }

    private void checkWall(double wallX){
        if (wallX > 570){
            Coordinates.setStartX(570);
            Velocity.setStartVx(-Velocity.getStartVx() * 0.6);
        }
        if (wallX < 30){
            Coordinates.setStartX(30);
            Velocity.setStartVx(-Velocity.getStartVx() * 0.6);
        }
    }






}
