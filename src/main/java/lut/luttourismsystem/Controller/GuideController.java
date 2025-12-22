package lut.luttourismsystem.Controller;

import lut.luttourismsystem.Entity.Guide;
import lut.luttourismsystem.Service.GuideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/guides")
public class GuideController {



    @Autowired
     GuideService guideService;

        /**
         * 获取所有用户
         * GET /users
         */
        @GetMapping
        public ResponseEntity<Iterable<Guide>> getAllUsers() {
            Iterable<Guide> guides = guideService.findAllGuides();
            return ResponseEntity.ok(guides);
        }

        /**
         * 根据ID获取单个用户
         * GET /users/{id}
         */
        @GetMapping("/{id}")
        public ResponseEntity<Guide> getGuideById(@PathVariable int id) {
            try {
                Guide guide = guideService.findGuide(id);
                return ResponseEntity.ok(guide);
            } catch (Exception e) {
                return ResponseEntity.notFound().build();
            }
        }

        /**
         * 创建新用户
         * POST /users
         */
        @PostMapping
        public ResponseEntity<Guide> createGuide(@RequestBody Guide guide) {
            guideService.addGuide(guide);
            return ResponseEntity.status(HttpStatus.CREATED).body(guide);
        }

        /**
         * 更新用户信息
         * PUT /users/{id}
         */
        @PutMapping("/{id}")
        public ResponseEntity<Guide> updateGuide(@PathVariable int id, @RequestBody Guide guide) {
            try {
                // 检查用户是否存在
                guideService.findGuide(id);
                // 设置ID确保更新的是正确的用户
                guide.setGuideId(id);
                guideService.updateGuide(guide);
                return ResponseEntity.ok(guide);
            } catch (Exception e) {
                return ResponseEntity.notFound().build();
            }
        }

        /**
         * 删除用户
         * DELETE /users/{id}
         */
        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteGuide(@PathVariable int id) {
            try {
                // 检查用户是否存在
                guideService.findGuide(id);
                guideService.deleteGuide(id);
                return ResponseEntity.noContent().build();
            } catch (Exception e) {
                return ResponseEntity.notFound().build();
            }
        }
}

