package md.utm.ati.client.view;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class DiabeteRequestView {

    @JsonProperty("Age")
    private Integer age;

    @JsonProperty("Gender")
    private Integer sex;

    @JsonProperty("Polyuria")
    private Integer polyuria;

    @JsonProperty("Polydipsia")
    private Integer polydipsia;

    @JsonProperty("sudden weight loss")
    private Integer suddenWeightLoss;

    @JsonProperty("weakness")
    private Integer weakness;

    @JsonProperty("Polyphagia")
    private Integer polyphagia;

    @JsonProperty("Genital thrush")
    private Integer genitalThrush;

    @JsonProperty("visual blurring")
    private Integer visualBlurring;

    @JsonProperty("Itching")
    private Integer itching;

    @JsonProperty("Irritability")
    private Integer irritability;

    @JsonProperty("delayed healing")
    private Integer delayedHealing;

    @JsonProperty("partial paresis")
    private Integer partialParesis;

    @JsonProperty("muscle stiffness")
    private Integer muscleStiffness;

    @JsonProperty("Alopecia")
    private Integer alopecia;

    @JsonProperty("Obesity")
    private Integer obesity;
}
