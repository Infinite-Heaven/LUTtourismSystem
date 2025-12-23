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
    //资质审验状态
    boolean QualificationReview;
    //经纬度
    double Longitude;
    double Latitude;
    //当前团队人数
    int TeamMembersNumber;


}