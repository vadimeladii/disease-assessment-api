package md.utm.ati.client.view;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class StressResponseView {

    @JsonProperty("high_stess")
    private Float highStess;

    @JsonProperty("low_stress")
    private Float lowStress;

    @JsonProperty("normal_stress")
    private Float normalStress;
}
