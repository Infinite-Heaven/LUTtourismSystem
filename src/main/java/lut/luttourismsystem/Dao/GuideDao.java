package lut.luttourismsystem.Dao;
import lut.luttourismsystem.Entity.Guide;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuideDao  extends CrudRepository<Guide,Integer> {
}
