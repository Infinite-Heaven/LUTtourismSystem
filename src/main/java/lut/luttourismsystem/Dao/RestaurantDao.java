package lut.luttourismsystem.Dao;
import lut.luttourismsystem.Entity.Restaurant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantDao extends CrudRepository<Restaurant, Integer> {
}
