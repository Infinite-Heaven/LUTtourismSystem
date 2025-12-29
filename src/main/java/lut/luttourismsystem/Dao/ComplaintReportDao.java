package lut.luttourismsystem.Dao;
import lut.luttourismsystem.Entity.ComplaintReport;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComplaintReportDao extends CrudRepository<ComplaintReport, Integer> {
    List<ComplaintReport> findByStatus(String status);
    List<ComplaintReport> findByComplainedType(String complainedType);
    List<ComplaintReport> findByComplainedTypeAndComplainedId(String complainedType, int complainedId);
}
