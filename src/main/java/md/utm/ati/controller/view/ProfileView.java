package md.utm.ati.controller.view;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProfileView {

    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private int age;
    private int sex;
    private int restingBp;
    private int cholesterol;
    private int fastingBs;
    private int maxHr;
    private int exerciseAngina;
    private double oldpeak;
    private int chestPainTypeAta;
    private int chestPainTypeNap;
    private int chestPainTypeTa;
    private int restingEcgNormal;
    private int restingEcgSt;
    private int stSlopeFlat;
    private int stSlopeUp;
    private int polyuria;
    private int polydipsia;
    private int suddenWeightLoss;
    private int weakness;
    private int polyphagia;
    private int genitalThrush;
    private int visualBlurring;
    private int itching;
    private int irritability;
    private int delayedHealing;
    private int partialParesis;
    private int muscleStiffness;
    private int alopecia;
    private int obesity;
    private float weight;
    private float height;
    private float neck;
    private float chest;
    private float abdomen;
    private float hip;
    private float thigh;
    private float knee;
    private float ankle;
    private float biceps;
    private float forearm;
    private float wrist;
    private float humidity;
    private float temperature;
    private int stepCount;
}
