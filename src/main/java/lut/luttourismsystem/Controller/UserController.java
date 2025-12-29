package lut.luttourismsystem.Controller;

import lut.luttourismsystem.Entity.User;
import lut.luttourismsystem.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping
    public ResponseEntity<Iterable<User>> getAllUsers() {
        Iterable<User> users = userService.findAllUsers();
        return ResponseEntity.ok(users);
    }


    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id) {
        try {
            User user = userService.findUser(id);
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        userService.addUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }


    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable int id, @RequestBody User user) {
        try {
            // 检查用户是否存在
            userService.findUser(id);
            // 设置ID确保更新的是正确的用户
            user.setUserId(id);
            userService.updateUser(user);
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable int id) {
        try {
            // 检查用户是否存在
            userService.findUser(id);
            userService.deleteUser(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    // 用户登录接口
    @GetMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestParam String name, @RequestParam String psw) {
        Map<String, Object> response = new HashMap<>();
        try {
            User user = userService.login(name, psw);
            if (user != null) {
                response.put("success", true);
                response.put("message", "登录成功");
                response.put("userId", user.getUserId());
                response.put("username", user.getName());
                return ResponseEntity.ok(response);
            } else {
                response.put("success", false);
                response.put("message", "用户名或密码错误");
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
            }
        } catch (Exception e) {
            response.put("success", false);
            response.put("message", "登录失败：" + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    // 检查用户名是否已存在
    @GetMapping("/check-username")
    public ResponseEntity<Map<String, Object>> checkUsername(@RequestParam String name) {
        Map<String, Object> response = new HashMap<>();
        boolean exists = userService.isUsernameExists(name);
        response.put("exists", exists);
        return ResponseEntity.ok(response);
    }
}
