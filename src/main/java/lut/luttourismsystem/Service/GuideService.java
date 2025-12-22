package lut.luttourismsystem.Service;
import lut.luttourismsystem.Dao.GuideDao;
import lut.luttourismsystem.Entity.Guide;
import lut.luttourismsystem.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GuideService {
    @Autowired
    GuideDao guideDao;
    public void addGuide(Guide guide){
        guideDao.save(guide);
    }

    public void deleteGuide(int guideId){
        guideDao.deleteById(guideId);
    }

    public void deleteAllGuides(){
        guideDao.deleteAll();
    }

    public Guide findGuide(int guideId){
        return guideDao.findById(guideId).get();
    }

    public Iterable<Guide> findAllGuides(){
        return guideDao.findAll();
    }

    public void updateGuide(Guide guide){
        guideDao.save(guide);
    }

}
