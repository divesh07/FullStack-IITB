import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class test {
    @Test
    public void SpeedTest() {

        int speed_of_light = 3*(10^8);

        int particle_speed = 2*(10^8);

        assertTrue(particle_speed > speed_of_light, "Assertion failed.");

        System.out.println("Done");


    }

}

