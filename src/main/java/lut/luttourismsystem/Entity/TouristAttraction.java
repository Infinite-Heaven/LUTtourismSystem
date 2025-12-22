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
    int maxCapacity;
    int CurrentCapacity;
    int parkingTotal;
    int parkingRemaining;
    String managerName;
    String managerPhone;
    String emergencyPerson;
    String electronicMapUrl;



}