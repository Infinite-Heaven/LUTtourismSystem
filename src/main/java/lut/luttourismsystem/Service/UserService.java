package lut.luttourismsystem.Service;

import lut.luttourismsystem.Dao.UserDao;
import lut.luttourismsystem.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    //依赖注入
    @Autowired
    UserDao userDao;

    public void addUser(User user){
        userDao.save(user);
    }

    public void deleteUser(int userId){
        userDao.deleteById(userId);
    }

    public void deleteAllUser(){
        userDao.deleteAll();
    }

    public User findUser(int userId){
        return userDao.findById(userId).get();
    }

    public Iterable<User> findAllUsers(){
        return userDao.findAll();
    }

    public void updateUser(User user){
        userDao.save(user);
    }

    // 根据用户名和密码验证登录
    public User login(String name, String psw) {
        Optional<User> user = userDao.findByNameAndPsw(name, psw);
        return user.orElse(null);
    }

    // 检查用户名是否已存在
    public boolean isUsernameExists(String name) {
        return userDao.findByName(name).isPresent();
    }

}
