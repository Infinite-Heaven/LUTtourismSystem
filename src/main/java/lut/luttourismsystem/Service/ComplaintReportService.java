package lut.luttourismsystem.Service;
import lut.luttourismsystem.Dao.ComplaintReportDao;

import lut.luttourismsystem.Entity.ComplaintReport;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class ComplaintReportService {
    @Autowired
    ComplaintReportDao complaintReportDao;

    public void addComplaintReport(ComplaintReport complaintReport){
        if (complaintReport.getCreateTime() == null || complaintReport.getCreateTime().isEmpty()) {
            complaintReport.setCreateTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        }
        if (complaintReport.getComplaintDate() == null || complaintReport.getComplaintDate().isEmpty()) {
            complaintReport.setComplaintDate(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        }
        // 首问负责制：设置首问负责人和处理时间
        if (complaintReport.getFirstHandler() != null && !complaintReport.getFirstHandler().isEmpty()) {
            complaintReport.setFirstHandleTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        }
        complaintReport.setUpdateTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        complaintReportDao.save(complaintReport);
    }

    public void deleteComplaintReport(int complaintReportId){
        complaintReportDao.deleteById(complaintReportId);
    }

    public void deleteAllComplaintReport(){
        complaintReportDao.deleteAll();
    }

    public ComplaintReport findComplaintReport(int complaintReportId){
        return complaintReportDao.findById(complaintReportId).orElse(null);
    }

    public Iterable<ComplaintReport> findAllComplaintReport(){
        return complaintReportDao.findAll();
    }
    
    public List<ComplaintReport> findComplaintReportsByStatus(String status) {
        return complaintReportDao.findByStatus(status);
    }
    
    public List<ComplaintReport> findComplaintReportsByComplainedType(String complainedType) {
        return complaintReportDao.findByComplainedType(complainedType);
    }
    
    public List<ComplaintReport> findComplaintReportsByComplainedEntity(String complainedType, int complainedId) {
        return complaintReportDao.findByComplainedTypeAndComplainedId(complainedType, complainedId);
    }

    public void updateComplaintReport(ComplaintReport complaintReport){
        complaintReport.setUpdateTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        complaintReportDao.save(complaintReport);
    }
}
