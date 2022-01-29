package utils;

import com.github.javafaker.Faker;
import enums.*;
import models.Bike;
import models.PrintWorkouts;
import models.Workout;

public class TestDataHelper {

    static Faker faker = new Faker();

    public static Workout getCrossTrainingWithAllData() {
        return Workout.builder()
                .timeOfDay("11:00 AM")
                .name(faker.name().title())
                .description(faker.name().title())
                .distance("5.00")
                .distanceType(DistanceType.KM)
                .duration("20:39")
                .paceType(PaceType.MIN_KM)
                .feeling(Feeling.GOOD)
                .perceivedEffort(PerceivedEffort.MODERATE5)
                .minHR(String.valueOf(faker.number().numberBetween(40, 100)))
                .avgHR(String.valueOf(faker.number().numberBetween(60, 140)))
                .maxHR(String.valueOf(faker.number().numberBetween(90, 200)))
                .caloriesBurned(String.valueOf(faker.number().numberBetween(10, 1000)))
                .build();
    }

    public static PrintWorkouts getPeriodPrintWorkouts() {
        return PrintWorkouts.builder()
                .startDate("1/5/2022")
                .endDate("1/19/2022")
                .build();
    }

    public static Bike getBikeWithAllData() {
        return Bike.builder()
                .bikeName(faker.name().title())
                .bikeBrand(BikeBrand.CUBE)
                .model(String.valueOf(faker.number().randomNumber()))
                .cost("500.75")
                .date("1/20/2022")
                .distance("60.15")
                .build();
    }

}
