package lut.luttourismsystem.Dao;
import lut.luttourismsystem.Entity.TouristAttraction;
import lut.luttourismsystem.Entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TouristAttractionDao extends CrudRepository<TouristAttraction, Integer> {

}
