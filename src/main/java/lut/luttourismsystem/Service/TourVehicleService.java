package lut.luttourismsystem.Service;

import lut.luttourismsystem.Dao.TourVehicleDao;
import lut.luttourismsystem.Entity.TourVehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class TourVehicleService {
    @Autowired
    TourVehicleDao tourVehicleDao;

    public void addTourVehicle(TourVehicle tourVehicle) {
        if (tourVehicle.getCreateTime() == null || tourVehicle.getCreateTime().isEmpty()) {
            tourVehicle.setCreateTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        }
        tourVehicle.setLastUpdateTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        tourVehicleDao.save(tourVehicle);
    }

    public void deleteTourVehicle(int vehicleId) {
        tourVehicleDao.deleteById(vehicleId);
    }

    public TourVehicle findTourVehicle(int vehicleId) {
        return tourVehicleDao.findById(vehicleId).orElse(null);
    }

    public Iterable<TourVehicle> findAllTourVehicles() {
        return tourVehicleDao.findAll();
    }

    public List<TourVehicle> findVehiclesByAgency(int agencyId) {
        return tourVehicleDao.findByAgencyId(agencyId);
    }

    public List<TourVehicle> findVehiclesByStatus(String status) {
        return tourVehicleDao.findByStatus(status);
    }

    public void updateTourVehicle(TourVehicle tourVehicle) {
        tourVehicle.setLastUpdateTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        tourVehicleDao.save(tourVehicle);
    }
}

