package md.utm.ati.client.view;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class BodyFatPartialRequestView {

    @JsonProperty("Abdomen")
    private Float abdomen;

    @JsonProperty("Height")
    private Float height;

    @JsonProperty("Wrist")
    private Float wrist;
}
