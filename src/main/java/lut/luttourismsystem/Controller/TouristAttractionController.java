package lut.luttourismsystem.Controller;
import lut.luttourismsystem.Entity.TouristAttraction;

import lut.luttourismsystem.Service.TouristAttractionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tourist")
public class TouristAttractionController {

    @Autowired
    private  TouristAttractionService touristAttractionService;

    @RequestMapping
    public ResponseEntity<Iterable<TouristAttraction>> getAllTouristAttractions() {
        Iterable<TouristAttraction> touristAttractions = touristAttractionService.findAllTouristattractions();
        return ResponseEntity.ok(touristAttractions);
    }

    /**
     * 根据ID获取单个用户
     * GET /users/{id}
     */
    @GetMapping("/{id}")
    public ResponseEntity<TouristAttraction> getTouristAttractionById(@PathVariable int id) {
        try {
            TouristAttraction touristAttractions = touristAttractionService.findTouristattraction(id);
            return ResponseEntity.ok(touristAttractions);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * 创建新用户
     * POST /users
     */
    @PostMapping
    public ResponseEntity<TouristAttraction> createTouristAttraction(@RequestBody TouristAttraction touristAttraction) {
        touristAttractionService.addTouristattraction(touristAttraction);
        return ResponseEntity.status(HttpStatus.CREATED).body(touristAttraction);
    }

    /**
     * 更新用户信息
     * PUT /users/{id}
     */
    @PutMapping("/{id}")
    public ResponseEntity<TouristAttraction> updateUser(@PathVariable int id, @RequestBody TouristAttraction touristAttraction) {
        try {
            // 检查用户是否存在
            touristAttractionService.findTouristattraction(id);
            // 设置ID确保更新的是正确的用户
            touristAttraction.setTouristAttractionId(id);
            touristAttractionService.updateTouristattraction(touristAttraction);
            return ResponseEntity.ok(touristAttraction);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * 删除用户
     * DELETE /users/{id}
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable int id) {
        try {
            // 检查用户是否存在
            touristAttractionService.findTouristattraction(id);
            touristAttractionService.deleteTouristattraction(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }



}
