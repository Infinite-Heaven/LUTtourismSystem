package lut.luttourismsystem.Service;

import lut.luttourismsystem.Dao.AlertReportDao;
import lut.luttourismsystem.Entity.AlertReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class AlertReportService {
    @Autowired
    AlertReportDao alertReportDao;

    public void add(AlertReport alertReport){
        if (alertReport.getCreateTime() == null || alertReport.getCreateTime().isEmpty()) {
            alertReport.setCreateTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        }
        alertReport.setUpdateTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        alertReportDao.save(alertReport);
    }

    public void delete(int Id){
        alertReportDao.deleteById(Id);
    }

    public void deleteAll(){
        alertReportDao.deleteAll();
    }

    public AlertReport find(int Id){
        return alertReportDao.findById(Id).orElse(null);
    }

    public Iterable<AlertReport> findAll(){
        return alertReportDao.findAll();
    }
    
    public List<AlertReport> findByStatus(String status) {
        return alertReportDao.findByStatus(status);
    }
    
    public List<AlertReport> findByAlertType(String alertType) {
        return alertReportDao.findByAlertType(alertType);
    }

    public void update(AlertReport alertReport){
        alertReport.setUpdateTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        alertReportDao.save(alertReport);
    }
}
