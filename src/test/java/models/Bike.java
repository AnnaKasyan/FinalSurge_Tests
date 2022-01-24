package models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Bike {
    String bikeName;
    String model;
    String cost;
    String date;
    String distance;
    String bikeBrand;


}
