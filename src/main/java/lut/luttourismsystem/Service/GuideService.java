package lut.luttourismsystem.Service;
import lut.luttourismsystem.Dao.GuideDao;
import lut.luttourismsystem.Entity.Guide;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class GuideService {
    @Autowired
    GuideDao guideDao;
    
    public void addGuide(Guide guide){
        if (guide.getCreateTime() == null || guide.getCreateTime().isEmpty()) {
            guide.setCreateTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        }
        guide.setUpdateTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        guideDao.save(guide);
    }

    public void deleteGuide(int guideId){
        guideDao.deleteById(guideId);
    }

    public void deleteAllGuides(){
        guideDao.deleteAll();
    }

    public Guide findGuide(int guideId){
        return guideDao.findById(guideId).orElse(null);
    }

    public Iterable<Guide> findAllGuides(){
        return guideDao.findAll();
    }

    public void updateGuide(Guide guide){
        guide.setUpdateTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        guideDao.save(guide);
    }
}
