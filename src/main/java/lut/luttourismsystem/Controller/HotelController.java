package lut.luttourismsystem.Controller;

import lut.luttourismsystem.Entity.Hotel;
import lut.luttourismsystem.Service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hotel")
@CrossOrigin(origins = "*")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @GetMapping
    public ResponseEntity<Iterable<Hotel>> getAllHotels() {
        Iterable<Hotel> hotels = hotelService.findAllHotels();
        return ResponseEntity.ok(hotels);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable int id) {
        try {
            Hotel hotel = hotelService.findHotel(id);
            if (hotel != null) {
                return ResponseEntity.ok(hotel);
            }
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel) {
        hotelService.addHotel(hotel);
        return ResponseEntity.status(HttpStatus.CREATED).body(hotel);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Hotel> updateHotel(@PathVariable int id, @RequestBody Hotel hotel) {
        try {
            Hotel existingHotel = hotelService.findHotel(id);
            if (existingHotel == null) {
                return ResponseEntity.notFound().build();
            }
            hotel.setHotelId(id);
            hotelService.updateHotel(hotel);
            return ResponseEntity.ok(hotel);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHotel(@PathVariable int id) {
        try {
            Hotel hotel = hotelService.findHotel(id);
            if (hotel == null) {
                return ResponseEntity.notFound().build();
            }
            hotelService.deleteHotel(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}

