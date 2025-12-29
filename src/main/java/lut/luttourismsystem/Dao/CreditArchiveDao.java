package lut.luttourismsystem.Dao;

import lut.luttourismsystem.Entity.CreditArchive;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CreditArchiveDao extends CrudRepository<CreditArchive, Integer> {
    List<CreditArchive> findByEntityType(String entityType);
    List<CreditArchive> findByEntityTypeAndEntityId(String entityType, int entityId);
    List<CreditArchive> findByCreditLevel(String creditLevel);
}

