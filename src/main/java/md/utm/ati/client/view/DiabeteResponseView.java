package md.utm.ati.client.view;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class DiabeteResponseView {

    @JsonProperty("risk_diabetes")
    private Float riskDiabetes;
}
