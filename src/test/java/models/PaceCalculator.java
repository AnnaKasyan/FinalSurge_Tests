package models;

import enums.DistanceType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaceCalculator {
    String distance;
    String hours;
    String minutes;
    String seconds;
    DistanceType distanceType;
}
