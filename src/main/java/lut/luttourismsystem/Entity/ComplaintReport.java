package lut.luttourismsystem.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Table(name="complaint_report")
@Entity
@Data
public class ComplaintReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int ReportId;

    String Content;
    String ComplaintChannel;
    String Date;



}