package lut.luttourismsystem.Service;

import lut.luttourismsystem.Dao.HotelDao;
import lut.luttourismsystem.Entity.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class HotelService {
    @Autowired
    HotelDao hotelDao;

    public void addHotel(Hotel hotel) {
        if (hotel.getCreateTime() == null || hotel.getCreateTime().isEmpty()) {
            hotel.setCreateTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        }
        hotel.setUpdateTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        hotelDao.save(hotel);
    }

    public void deleteHotel(int hotelId) {
        hotelDao.deleteById(hotelId);
    }

    public void deleteAllHotel() {
        hotelDao.deleteAll();
    }

    public Hotel findHotel(int hotelId) {
        return hotelDao.findById(hotelId).orElse(null);
    }

    public Iterable<Hotel> findAllHotels() {
        return hotelDao.findAll();
    }

    public void updateHotel(Hotel hotel) {
        hotel.setUpdateTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        hotelDao.save(hotel);
    }
}

