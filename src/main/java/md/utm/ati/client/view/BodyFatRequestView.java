package md.utm.ati.client.view;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class BodyFatRequestView {

    @JsonProperty("Age")
    private Integer age;

    @JsonProperty("Weight")
    private Float weight;

    @JsonProperty("Height")
    private Float height;

    @JsonProperty("neck")
    private Float neck;

    @JsonProperty("Chest")
    private Float chest;

    @JsonProperty("Abdomen")
    private Float abdomen;

    @JsonProperty("Hip")
    private Float hip;

    @JsonProperty("Thigh")
    private Float thigh;

    @JsonProperty("Knee")
    private Float knee;

    @JsonProperty("Ankle")
    private Float ankle;

    @JsonProperty("Biceps")
    private Float biceps;

    @JsonProperty("Forearm")
    private Float forearm;

    @JsonProperty("Wrist")
    private Float wrist;
}
