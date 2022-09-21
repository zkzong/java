package org.example.lombok;

import org.junit.Test;

import java.time.LocalDate;
import java.util.Arrays;

public class CarTest {

    @Test
    public void build() {
        Car muscleCar = Car.builder().make("Ford")
                .model("mustang")
                .bodyType("coupe")
                .build();
        System.out.println(muscleCar);
    }

    @Test
    public void build2() {
        Car muscleCar = Car.builder().make("Ford")
                .model("mustang")
                .serviceDate(Arrays.asList(LocalDate.of(2016, 5, 4)))
                .build();
        System.out.println(muscleCar);
    }

    @Test
    public void singular() {
        Car muscleCar = Car.builder()
                .make("Ford")
                .model("mustang")
                .serviceDate(LocalDate.of(2016, 5, 4))
                .build();
        System.out.println(muscleCar);
    }

}