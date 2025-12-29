package lut.luttourismsystem.Dao;

import lut.luttourismsystem.Entity.OutboundTour;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OutboundTourDao extends CrudRepository<OutboundTour, Integer> {
    List<OutboundTour> findByAgencyId(int agencyId);
    List<OutboundTour> findByVisaStatus(String visaStatus);
}

