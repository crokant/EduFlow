package eduflow.controllers;

import eduflow.DTO.CourseDTO;
import eduflow.DTO.UserDTO;
import eduflow.models.User;
import eduflow.services.CourseService;
import eduflow.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final CourseService courseService;
    private final UserService userService;

    @Autowired
    public UserController(UserService userService, CourseService courseService) {
        this.userService = userService;
        this.courseService = courseService;
    }

    @PostMapping("/person")
    public User create(@RequestBody UserDTO user) {
        return userService.saveUser(user.getModel());
    }

    @GetMapping("/person/{id}")
    public User get(@PathVariable(name = "id") long id) {
        return userService.getUser(id);
    }

    @GetMapping("/person")
    public List<User> getAll() {
        return userService.getUsers();
    }

    @PutMapping("/person/{id}/cats")
    public User addCourse(@PathVariable(name = "id") long id, @RequestBody CourseDTO course) {
        return courseService.addCourse(id, course);
    }
}
