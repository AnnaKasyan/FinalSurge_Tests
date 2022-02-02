package models;

import enums.DistTypeForCalculator;
import enums.GenderType;
import enums.HeightType;
import enums.WeightType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CaloricNeeds {
    String weight;
    String height;
    String age;
    String distance;
    WeightType weightType;
    HeightType heightType;
    DistTypeForCalculator distTypeForCalculator;
    GenderType genderType;
}
