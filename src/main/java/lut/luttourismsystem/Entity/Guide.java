package lut.luttourismsystem.Entity;


import jakarta.persistence.*;
import lombok.Data;

@Table(name="guide")
@Entity
@Data
public class Guide {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int  GuideId;
    String name;
    int year;
    String sex;
    boolean QualificationReview;
    double Longitude;
    double Latitude;
    int TeamMembersNumber;


}