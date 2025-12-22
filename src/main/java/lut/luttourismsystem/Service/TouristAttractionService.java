package lut.luttourismsystem.Service;

import lut.luttourismsystem.Dao.TouristAttractionDao;

import lut.luttourismsystem.Entity.TouristAttraction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class TouristAttractionService {
    @Autowired
    TouristAttractionDao touristAttractionDao;


    public void addTouristattraction(TouristAttraction touristAttraction){
        touristAttractionDao.save(touristAttraction);
    }

    public void deleteTouristattraction(int userId){
        touristAttractionDao.deleteById(userId);
    }

    public void deleteAllTouristattraction(){
        touristAttractionDao.deleteAll();
    }

    public TouristAttraction findTouristattraction(int userId){
        return touristAttractionDao.findById(userId).get();
    }

    public Iterable<TouristAttraction> findAllTouristattractions(){
        return touristAttractionDao.findAll();
    }

    public void updateTouristattraction(TouristAttraction touristAttraction){
        touristAttractionDao.save(touristAttraction);
    }

}
