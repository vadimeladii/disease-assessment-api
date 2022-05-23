package md.utm.ati.client.view;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class HeartFullResponseView {

    @JsonProperty("risk_heart_full")
    private Float riskHeartFull;
}
