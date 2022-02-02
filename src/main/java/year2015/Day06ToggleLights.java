package year2015;

import java.io.BufferedReader;

public class Day06ToggleLights extends Day06Lights {

    public Day06ToggleLights(BufferedReader bufferedReader) {
        super(bufferedReader);
    }

    @Override
    public int setNewLightValue(String instruction, int light) {
        return instruction.equals(TOGGLE) ? toggleLight(light) :
                instruction.equals(ON) ? onLight() : offLight();
    }

    private int toggleLight(int light) {
        return light == 1 ? 0 : 1;
    }

    private int onLight() {
        return 1;
    }

    private int offLight() {
        return 0;
    }
}
