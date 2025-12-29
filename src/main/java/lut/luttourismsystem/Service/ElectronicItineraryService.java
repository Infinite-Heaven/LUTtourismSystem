package lut.luttourismsystem.Service;

import lut.luttourismsystem.Dao.ElectronicItineraryDao;
import lut.luttourismsystem.Entity.ElectronicItinerary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class ElectronicItineraryService {
    @Autowired
    ElectronicItineraryDao electronicItineraryDao;

    public void addElectronicItinerary(ElectronicItinerary itinerary) {
        if (itinerary.getCreateTime() == null || itinerary.getCreateTime().isEmpty()) {
            itinerary.setCreateTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        }
        itinerary.setUpdateTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        electronicItineraryDao.save(itinerary);
    }

    public void deleteElectronicItinerary(int itineraryId) {
        electronicItineraryDao.deleteById(itineraryId);
    }

    public ElectronicItinerary findElectronicItinerary(int itineraryId) {
        return electronicItineraryDao.findById(itineraryId).orElse(null);
    }

    public Iterable<ElectronicItinerary> findAllElectronicItineraries() {
        return electronicItineraryDao.findAll();
    }

    public List<ElectronicItinerary> findItinerariesByAgency(int agencyId) {
        return electronicItineraryDao.findByAgencyId(agencyId);
    }

    public List<ElectronicItinerary> findDeviatedItineraries() {
        return electronicItineraryDao.findByIsDeviated(true);
    }

    public List<ElectronicItinerary> findItinerariesByStatus(String status) {
        return electronicItineraryDao.findByStatus(status);
    }

    public void updateElectronicItinerary(ElectronicItinerary itinerary) {
        itinerary.setUpdateTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        electronicItineraryDao.save(itinerary);
    }
}

