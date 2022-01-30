package models;

import enums.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WorkoutCalculator {
    String hours;
    String minutes;
    String seconds;
    String temperature;
    String humidity;
    String windSpeed;
    Event event;
    TemperatureType temperatureType;
    WindSpeedType windSpeedType;
    GenderType genderType;
    RaceDistance raceDistance;


}
