package eduflow.controllers;

import eduflow.DTO.CourseDTO;
import eduflow.services.CourseService;
import jakarta.validation.Valid;
import eduflow.models.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {
    private final CourseService courseService;

    @Autowired
    public CourseController(final CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/{id}")
    public Course getCourse(@PathVariable("id") Long id) {
        return courseService.getCourse(id);
    }


    @GetMapping("/{page}")
    public List<Course> getAllCoursesInPages(@PathVariable(name = "page") int page) {
        return courseService.getCourses(page, 25).getContent();
    }

    @GetMapping("/filter")
    public List<Course> getCourseByTitlePrefix(String prefix) {
        return courseService.getAllCourses().stream()
                .filter(course -> course.getCourseName().startsWith(prefix))
                .toList();
    }

    @PutMapping("")
    public void addCourse(@PathVariable("id") long userId, @Valid @RequestBody CourseDTO course) {
        courseService.addCourse(userId, course);
    }

    @PutMapping("/{id}")
    public void updateCourse(@PathVariable("id") long id, @Valid @RequestBody CourseDTO courseDTO) {
        courseService.updateCourse(id, courseDTO);

    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable("id") long id) {
        courseService.deleteById(id);
    }

}
