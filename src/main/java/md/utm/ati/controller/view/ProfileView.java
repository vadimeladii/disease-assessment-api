package md.utm.ati.controller.view;

import lombok.Data;

@Data
public class ProfileView {

    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private Integer age;
    private Integer sex;
    private Integer restingBp;
    private Integer cholesterol;
    private Integer fastingBs;
    private Integer maxHr;
    private Integer exerciseAngina;
    private Double oldpeak;
    private Integer chestPainTypeAta;
    private Integer chestPainTypeNap;
    private Integer chestPainTypeTa;
    private Integer restingEcgNormal;
    private Integer restingEcgSt;
    private Integer stSlopeFlat;
    private Integer stSlopeUp;
}
