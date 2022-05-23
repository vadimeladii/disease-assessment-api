package md.utm.ati.client.view;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class HeartPartialResponseView {

    @JsonProperty("risk_heart_partial")
    private Float riskHeartPartial;
}
