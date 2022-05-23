package md.utm.ati.client.view;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class HeartPartialRequestView {

    @JsonProperty("Age")
    private Integer age;

    @JsonProperty("Sex")
    private Integer sex;

    @JsonProperty("MaxHR")
    private Integer maxHR;

    @JsonProperty("ExerciseAngina")
    private Integer exerciseAngina;

    @JsonProperty("ChestPainType_ATA")
    private Integer chestPainTypeAta;

    @JsonProperty("ChestPainType_NAP")
    private Integer chestPainTypeNap;

    @JsonProperty("ChestPainType_TA")
    private Integer chestPainTypeTa;
}
