package lut.luttourismsystem.Dao;

import lut.luttourismsystem.Entity.AlertReport;
import lut.luttourismsystem.Entity.ComplaintReport;
import org.springframework.data.repository.CrudRepository;

public interface AlertReportDao extends CrudRepository<AlertReport, Integer> {

}
