package lut.luttourismsystem.Dao;

import lut.luttourismsystem.Entity.ElectronicItinerary;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ElectronicItineraryDao extends CrudRepository<ElectronicItinerary, Integer> {
    List<ElectronicItinerary> findByAgencyId(int agencyId);
    List<ElectronicItinerary> findByIsDeviated(boolean isDeviated);
    List<ElectronicItinerary> findByStatus(String status);
}

