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
