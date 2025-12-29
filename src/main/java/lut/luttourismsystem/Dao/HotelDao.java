package lut.luttourismsystem.Dao;

import lut.luttourismsystem.Entity.Hotel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelDao extends CrudRepository<Hotel, Integer> {
}

