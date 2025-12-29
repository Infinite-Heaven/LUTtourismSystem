package lut.luttourismsystem.Dao;

import lut.luttourismsystem.Entity.TourVehicle;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TourVehicleDao extends CrudRepository<TourVehicle, Integer> {
    List<TourVehicle> findByAgencyId(int agencyId);
    List<TourVehicle> findByStatus(String status);
}

