package lut.luttourismsystem.Controller;
import lut.luttourismsystem.Entity.Restaurant;
import lut.luttourismsystem.Entity.User;
import lut.luttourismsystem.Service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController("/restaurant")
public class RestaurantController {
    @Autowired
    private RestaurantService restaurantService;

    /**
     * 获取所有用户
     * GET /users
     */
    @GetMapping
    public ResponseEntity<Iterable<Restaurant>> getAllRestaurants() {
        Iterable<Restaurant> restaurant = restaurantService.findAllRestaurants();
        return ResponseEntity.ok(restaurant);
    }

    /**
     * 根据ID获取单个用户
     * GET /users/{id}
     */
    @GetMapping("/{id}")
    public ResponseEntity<Restaurant> getRestaurantById(@PathVariable int id) {
        try {
            Restaurant restaurant = restaurantService.findRestaurant(id);
            return ResponseEntity.ok(restaurant);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * 创建新用户
     * POST /users
     */
    @PostMapping
    public ResponseEntity<Restaurant> createRestaurant(@RequestBody Restaurant restaurant) {
        restaurantService.addRestaurant(restaurant);
        return ResponseEntity.status(HttpStatus.CREATED).body(restaurant);
    }

    /**
     * 更新用户信息
     * PUT /users/{id}
     */
    @PutMapping("/{id}")
    public ResponseEntity<Restaurant> updateRestaurant(@PathVariable int id, @RequestBody Restaurant restaurant) {
        try {
            // 检查用户是否存在
            restaurantService.findRestaurant(id);
            // 设置ID确保更新的是正确的用户
            restaurant.setRestaurantId(id);
            restaurantService.updateRestaurant(restaurant);
            return ResponseEntity.ok(restaurant);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * 删除用户
     * DELETE /users/{id}
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRestaurant(@PathVariable int id) {
        try {
            // 检查用户是否存在
            restaurantService.findRestaurant(id);
            restaurantService.deleteRestaurant(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
