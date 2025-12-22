package lut.luttourismsystem.Dao;
import lut.luttourismsystem.Entity.ComplaintReport;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ComplaintReportDao extends CrudRepository<ComplaintReport, Integer> {
}
