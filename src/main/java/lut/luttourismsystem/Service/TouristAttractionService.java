package lut.luttourismsystem.Service;

import lut.luttourismsystem.Dao.TouristAttractionDao;

import lut.luttourismsystem.Entity.TouristAttraction;

import lut.luttourismsystem.Util.Alert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class TouristAttractionService {
    @Autowired
    TouristAttractionDao touristAttractionDao;

    Alert alert;

    public void addTouristattraction(TouristAttraction touristAttraction){
        if (touristAttraction.getCreateTime() == null || touristAttraction.getCreateTime().isEmpty()) {
            touristAttraction.setCreateTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        }
        touristAttraction.setUpdateTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        touristAttractionDao.save(touristAttraction);
        if (alert != null) {
            alert.caution(touristAttraction);
        }
    }

    public void deleteTouristattraction(int userId){
        touristAttractionDao.deleteById(userId);
    }

    public void deleteAllTouristattraction(){
        touristAttractionDao.deleteAll();
    }

    public TouristAttraction findTouristattraction(int userId){
        return touristAttractionDao.findById(userId).orElse(null);
    }

    public Iterable<TouristAttraction> findAllTouristattractions(){
        return touristAttractionDao.findAll();
    }

    public void updateTouristattraction(TouristAttraction touristAttraction){
        touristAttraction.setUpdateTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        touristAttractionDao.save(touristAttraction);
    }
}
