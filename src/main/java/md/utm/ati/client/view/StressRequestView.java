package md.utm.ati.client.view;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class StressRequestView {

    @JsonProperty("Humidity")
    private Float humidity;

    @JsonProperty("Temperature")
    private Float temperature;

    @JsonProperty("Step count")
    private Integer stepCount;
}
