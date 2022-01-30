package utils;

import com.github.javafaker.Faker;
import enums.*;
import models.*;

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

    public static DatePeriod getDatePeriod() {
        return DatePeriod.builder()
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

    public static CaloricNeeds getCaloricNeedInform() {
        return CaloricNeeds.builder()
                .weightType(WeightType.KG)
                .heightType(HeightType.CENTIMETERS)
                .genderType(GenderType.MALE)
                .distTypeForCalculator(DistTypeForCalculator.KILOMETERS)
                .weight(String.valueOf(faker.number().numberBetween(30, 500)))
                .height(String.valueOf(faker.number().numberBetween(60, 240)))
                .age(String.valueOf(faker.number().numberBetween(5, 99)))
                .distance(String.valueOf(faker.number().numberBetween(1, 500)))
                .build();
    }

    public static PaceCalculator getPaceCalculatorInform() {
        return PaceCalculator.builder()
                .distanceType(DistanceType.KM)
                .distance(String.valueOf(faker.number().numberBetween(1, 9999)))
                .hours(String.valueOf(faker.number().numberBetween(0, 99)))
                .minutes(String.valueOf(faker.number().numberBetween(1, 59)))
                .seconds(String.valueOf(faker.number().numberBetween(1, 59)))
                .build();
    }

    public static Report getReportInform() {
        return Report.builder()
                .startDate("1/23/2022")
                .endDate("1/24/2022")
                .activityType(ActiveType.CROSS_TRAINING)
                .build();
    }

    public static WorkoutCalculator getIntesityInform() {
        return WorkoutCalculator.builder()
                .event(Event.HALFMAR)
                .hours(String.valueOf(faker.number().numberBetween(1, 3)))
                .minutes(String.valueOf(faker.number().numberBetween(1, 59)))
                .seconds(String.valueOf(faker.number().numberBetween(1, 59)))
                .build();
    }

    public static WorkoutCalculator getHansonsInform() {
        return WorkoutCalculator.builder()
                .event(Event.MARATHON)
                .hours(String.valueOf(faker.number().numberBetween(1, 8)))
                .minutes(String.valueOf(faker.number().numberBetween(1, 59)))
                .seconds(String.valueOf(faker.number().numberBetween(1, 59)))
                .temperature(String.valueOf(faker.number().numberBetween(-40, 150)))
                .temperatureType(TemperatureType.C)
                .humidity(String.valueOf(faker.number().numberBetween(0, 100)))
                .windSpeed(String.valueOf(faker.number().numberBetween(0, 99)))
                .windSpeedType(WindSpeedType.KPH)
                .build();
    }

    public static WorkoutCalculator getTinmanInform() {
        return WorkoutCalculator.builder()
                .raceDistance(RaceDistance.FIVE_KM)
                .hours(String.valueOf(faker.number().numberBetween(0, 5)))
                .minutes(String.valueOf(faker.number().numberBetween(1, 59)))
                .seconds(String.valueOf(faker.number().numberBetween(1, 59)))
                .genderType(GenderType.FEMALE)
                .build();
    }

}
