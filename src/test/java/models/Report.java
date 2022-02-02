package models;

import enums.ActiveType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Report {
    String startDate;
    String endDate;
    ActiveType activityType;
}
