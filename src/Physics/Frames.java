package Physics;

import javafx.scene.control.Label;

public class Frames {
    private static final long[] frameTimes = new long[100];
    private static int frameTimeIndex = 0 ;
    private static boolean arrayFilled = false ;

    public static void showFPS02(long now, Label label) {
        long oldFrameTime = frameTimes[frameTimeIndex] ;
        frameTimes[frameTimeIndex] = now ;
        frameTimeIndex = (frameTimeIndex + 1) % frameTimes.length ;
        if (frameTimeIndex == 0) {
            arrayFilled = true ;
        }
        if (arrayFilled) {
            long elapsedNanos = now - oldFrameTime ;
            long elapsedNanosPerFrame = elapsedNanos / frameTimes.length ;
            double frameRate = (int) 1_000_000_000.0 / elapsedNanosPerFrame ;
            label.setText(String.valueOf(frameRate));
        }
    }


}
