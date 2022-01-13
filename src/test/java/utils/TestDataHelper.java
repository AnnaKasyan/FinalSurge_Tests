package utils;

import enums.DistanceType;
import enums.Feeling;
import enums.PerceivedEffort;
import enums.PaceType;
import models.Workout;

public class TestDataHelper {

    public static Workout getCrossTrainingWithAllData() {
        Workout crossTraining = Workout.builder()
                .timeOfDay("11:00 AM")
                .name("WorkoutName")
                .description("WorkoutDescription")
                .distance("5,000.00")
                .distanceType(DistanceType.ME)
                .duration("20:39")
                .paceType(PaceType.MIN_100M)
                .feeling(Feeling.GOOD)
                .perceivedEffort(PerceivedEffort.MODERATE5)
                .minHR("80")
                .avgHR("120")
                .maxHR("140")
                .caloriesBurned("300")
                .build();
        return crossTraining;
    }
}
