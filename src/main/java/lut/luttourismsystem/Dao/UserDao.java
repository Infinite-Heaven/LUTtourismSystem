package lut.luttourismsystem.Dao;

import lut.luttourismsystem.Entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDao extends CrudRepository<User, Integer> {
    // 根据用户名和密码查找用户
    Optional<User> findByNameAndPsw(String name, String psw);
    
    // 根据用户名查找用户（用于检查用户名是否已存在）
    Optional<User> findByName(String name);
}
