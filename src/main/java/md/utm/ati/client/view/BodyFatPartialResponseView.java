package md.utm.ati.client.view;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class BodyFatPartialResponseView {

    @JsonProperty("body_fat_partial")
    private Float bodyFatPartial;
}
