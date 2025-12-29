package lut.luttourismsystem.Dao;

import lut.luttourismsystem.Entity.TravelAgency;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TravelAgencyDao extends CrudRepository<TravelAgency, Integer> {
}

