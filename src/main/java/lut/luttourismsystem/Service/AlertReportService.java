package lut.luttourismsystem.Service;

import lut.luttourismsystem.Dao.AlertReportDao;
import lut.luttourismsystem.Dao.GuideDao;
import lut.luttourismsystem.Entity.AlertReport;
import lut.luttourismsystem.Entity.Guide;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlertReportService {
    @Autowired
    AlertReportDao alertReportDao;

    public void add(AlertReport alertReport){
        alertReportDao.save(alertReport);
    }

    public void delete(int Id){
        alertReportDao.deleteById(Id);
    }

    public void deleteAll(){
        alertReportDao.deleteAll();
    }

    public AlertReport find(int Id){
        return alertReportDao.findById(Id).get();
    }

    public Iterable<AlertReport> findAll(){
        return alertReportDao.findAll();
    }

    public void update(AlertReport alertReport){
        alertReportDao.save(alertReport);
    }
}
