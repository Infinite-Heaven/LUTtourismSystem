package lut.luttourismsystem.Dao;

import lut.luttourismsystem.Entity.AlertReport;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlertReportDao extends CrudRepository<AlertReport, Integer> {
    List<AlertReport> findByStatus(String status);
    List<AlertReport> findByAlertType(String alertType);
    List<AlertReport> findByNeedPublish(boolean needPublish);
}
