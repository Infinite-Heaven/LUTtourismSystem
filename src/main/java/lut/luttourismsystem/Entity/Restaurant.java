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
    int MaxReception;
    int ParkingTotal;
    double OccupancyRate;
    String managerName;
    String managerPhone;
    double Longitude;
    double Latitude;
}