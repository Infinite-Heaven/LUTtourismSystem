package lut.luttourismsystem.Service;

import lut.luttourismsystem.Dao.OutboundTourDao;
import lut.luttourismsystem.Entity.OutboundTour;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class OutboundTourService {
    @Autowired
    OutboundTourDao outboundTourDao;

    public void addOutboundTour(OutboundTour outboundTour) {
        if (outboundTour.getApplicationTime() == null || outboundTour.getApplicationTime().isEmpty()) {
            outboundTour.setApplicationTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        }
        outboundTour.setUpdateTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        outboundTourDao.save(outboundTour);
    }

    public void deleteOutboundTour(int outboundTourId) {
        outboundTourDao.deleteById(outboundTourId);
    }

    public OutboundTour findOutboundTour(int outboundTourId) {
        return outboundTourDao.findById(outboundTourId).orElse(null);
    }

    public Iterable<OutboundTour> findAllOutboundTours() {
        return outboundTourDao.findAll();
    }

    public List<OutboundTour> findOutboundToursByAgency(int agencyId) {
        return outboundTourDao.findByAgencyId(agencyId);
    }

    public List<OutboundTour> findOutboundToursByVisaStatus(String visaStatus) {
        return outboundTourDao.findByVisaStatus(visaStatus);
    }

    public void updateOutboundTour(OutboundTour outboundTour) {
        outboundTour.setUpdateTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        outboundTourDao.save(outboundTour);
    }
}

