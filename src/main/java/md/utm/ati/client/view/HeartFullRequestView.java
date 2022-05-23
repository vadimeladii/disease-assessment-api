package md.utm.ati.client.view;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class HeartFullRequestView {

    @JsonProperty("Age")
    private Integer age;

    @JsonProperty("Sex")
    private Integer sex;

    @JsonProperty("RestingBP")
    private Integer restingBp;

    @JsonProperty("Cholesterol")
    private Integer cholesterol;

    @JsonProperty("FastingBS")
    private Integer fastingBs;

    @JsonProperty("MaxHR")
    private Integer maxHr;

    @JsonProperty("ExerciseAngina")
    private Integer exerciseAngina;

    @JsonProperty("Oldpeak")
    private Double oldpeak;

    @JsonProperty("ChestPainType_ATA")
    private Integer chestPainTypeAta;

    @JsonProperty("ChestPainType_NAP")
    private Integer chestPainTypeNap;

    @JsonProperty("ChestPainType_TA")
    private Integer chestPainTypeTa;

    @JsonProperty("RestingECG_Normal")
    private Integer restingEcgNormal;

    @JsonProperty("RestingECG_ST")
    private Integer restingEcgSt;

    @JsonProperty("ST_Slope_Flat")
    private Integer stSlopeFlat;

    @JsonProperty("ST_Slope_Up")
    private Integer stSlopeUp;
}
