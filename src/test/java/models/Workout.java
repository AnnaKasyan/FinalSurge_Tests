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
public class Workout {
    private String data;
    private String name;
    private String description;
    private String distance;
    private String duration;
    private String pace;
    private String minHR;
    private String avgHR;
    private String maxHR;
    private String caloriesBurned;
    private String timeOfDay;
    private DistanceType distanceType;
    private PaceType paceType;
    private Feeling feeling;
    private PerceivedEffort perceivedEffort;

}
