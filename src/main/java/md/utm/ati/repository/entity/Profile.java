package md.utm.ati.repository.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
@Table(name = "profile")
public class Profile {

    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
    @Column(length = 36, nullable = false, updatable = false)
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
}
