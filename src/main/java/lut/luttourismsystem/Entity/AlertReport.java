package lut.luttourismsystem.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Table(name="alert_report")
@Entity
@Data
public class AlertReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int AlertId;

    String Content;
}
