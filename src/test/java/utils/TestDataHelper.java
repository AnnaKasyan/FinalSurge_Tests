package utils;

import enums.DistanceType;
import enums.Feeling;
import enums.PerceivedEffort;
import enums.PaceType;
import models.Bike;
import models.PrintWorkouts;
import models.Workout;

public class TestDataHelper {

    public static Workout getCrossTrainingWithAllData() {
        return Workout.builder()
                .timeOfDay("11:00 AM")
                .name("WorkoutName")
                .description("WorkoutDescription")
                .distance("5.00")
                .distanceType(DistanceType.KM)
                .duration("20:39")
                .paceType(PaceType.MIN_KM)
                .feeling(Feeling.GOOD)
                .perceivedEffort(PerceivedEffort.MODERATE5)
                .minHR("80")
                .avgHR("120")
                .maxHR("140")
                .caloriesBurned("300")
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
                  .bikeName("MyBike")
                 // .bikeBrand("BMC")
                  .model("Live")
                  .cost("500.75")
                  .date("1/20/2022")
                  .distance("60.15")
                  .build();
    }

}
