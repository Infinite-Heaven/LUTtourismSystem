package lut.luttourismsystem.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Table(name="restaurant")
@Entity
@Data
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int RestaurantId;

    String name;
    //最大接待人数
    int MaxReception;
    //最大停车容量
    int ParkingTotal;
    //入住率
    double OccupancyRate;
    //经理名称，电话
    String managerName;
    String managerPhone;
    //经纬度
    double Longitude;
    double Latitude;
}