package lut.luttourismsystem.Service;

import lut.luttourismsystem.Dao.TravelAgencyDao;
import lut.luttourismsystem.Entity.TravelAgency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class TravelAgencyService {
    @Autowired
    TravelAgencyDao travelAgencyDao;

    public void addTravelAgency(TravelAgency travelAgency) {
        if (travelAgency.getCreateTime() == null || travelAgency.getCreateTime().isEmpty()) {
            travelAgency.setCreateTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        }
        travelAgency.setUpdateTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        travelAgencyDao.save(travelAgency);
    }

    public void deleteTravelAgency(int agencyId) {
        travelAgencyDao.deleteById(agencyId);
    }

    public TravelAgency findTravelAgency(int agencyId) {
        return travelAgencyDao.findById(agencyId).orElse(null);
    }

    public Iterable<TravelAgency> findAllTravelAgencies() {
        return travelAgencyDao.findAll();
    }

    public void updateTravelAgency(TravelAgency travelAgency) {
        travelAgency.setUpdateTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        travelAgencyDao.save(travelAgency);
    }
}

