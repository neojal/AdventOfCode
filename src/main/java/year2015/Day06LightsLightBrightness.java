package year2015;

import java.io.BufferedReader;

public class Day06LightsLightBrightness extends Day06Lights implements Day06LightBrightnessControl {

    public Day06LightsLightBrightness(BufferedReader bufferedReader) {
        super(bufferedReader);
    }

    @Override
    public int setNewLightValue(String instruction, int light) {
        return instruction.equals(TOGGLE) ? toggleLight(light) :
                instruction.equals(ON) ? onLight(light) : offLight(light);
    }

    @Override
    public int toggleLight(int light) {
        return light + 2;
    }

    @Override
    public int onLight(int light) {
        return light + 1;
    }

    @Override
    public int offLight(int light) {
        return light > 0 ? light - 1 : light;
    }
}
