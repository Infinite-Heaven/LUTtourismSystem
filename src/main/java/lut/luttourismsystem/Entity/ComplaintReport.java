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
    //投诉内容
    String Content;
    //投诉渠道
    String ComplaintChannel;
    //投诉日期
    String Date;



}