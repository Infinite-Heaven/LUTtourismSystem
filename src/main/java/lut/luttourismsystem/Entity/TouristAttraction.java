package lut.luttourismsystem.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Table(name="tourist_attraction")
@Entity
@Data
public class TouristAttraction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int touristAttractionId;

    String Name;
    //最大容量
    int maxCapacity;
    //当前人数
    int CurrentCapacity;
    //最大停车容量
    int parkingTotal;
    //停车位剩余
    int parkingRemaining;

    String managerName;
    String managerPhone;
    //紧急联系人
    String emergencyPerson;
    //电子地图网址
    String electronicMapUrl;



}