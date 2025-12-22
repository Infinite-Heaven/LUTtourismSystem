package lut.luttourismsystem.Service;
import lut.luttourismsystem.Dao.ComplaintReportDao;

import lut.luttourismsystem.Entity.ComplaintReport;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
@Service
public class ComplaintReportService {
    @Autowired
    ComplaintReportDao complaintReportDao;

    public void addComplaintReport(ComplaintReport complaintReport){
        complaintReportDao.save(complaintReport);
    }

    public void deleteComplaintReport(int complaintReportId){
        complaintReportDao.deleteById(complaintReportId);
    }

    public void deleteAllComplaintReport(){
        complaintReportDao.deleteAll();
    }

    public ComplaintReport findComplaintReport(int complaintReportId){
        return complaintReportDao.findById(complaintReportId).get();
    }

    public Iterable<ComplaintReport> findAllComplaintReport(){
        return complaintReportDao.findAll();
    }

    public void updateComplaintReport(ComplaintReport complaintReport){
        complaintReportDao.save(complaintReport);
    }
}
