package lut.luttourismsystem.Service;
import lut.luttourismsystem.Dao.RestaurantDao;

import lut.luttourismsystem.Entity.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService {
    @Autowired
    RestaurantDao restaurantDao;

    public void addRestaurant(Restaurant restaurant){
        restaurantDao.save(restaurant);
    }

    public void deleteRestaurant(int restaurantId){
        restaurantDao.deleteById(restaurantId);
    }

    public void deleteAllRestaurant(){
        restaurantDao.deleteAll();
    }

    public Restaurant findRestaurant(int restaurantId){
        return restaurantDao.findById(restaurantId).get();
    }

    public Iterable<Restaurant> findAllRestaurants(){
        return restaurantDao.findAll();
    }

    public void updateRestaurant(Restaurant restaurant){
        restaurantDao.save(restaurant);
    }
}
