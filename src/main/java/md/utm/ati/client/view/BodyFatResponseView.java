package md.utm.ati.client.view;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class BodyFatResponseView {

    @JsonProperty("body_fat")
    private Float bodyFat;
}
