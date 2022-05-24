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
}
