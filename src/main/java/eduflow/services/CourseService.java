package eduflow.services;

import eduflow.DTO.CourseDTO;
import eduflow.models.Course;
import eduflow.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import eduflow.repository.CourseRepository;
import eduflow.repository.UserRepository;

import java.util.List;

@Service
public class CourseService {
    private final CourseRepository CourseRepository;
    private final UserRepository UserRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository, UserRepository userRepository) {
        this.CourseRepository = courseRepository;
        this.UserRepository = userRepository;
    }

    public void deleteById(long id) {
        CourseRepository.deleteById(id);
    }

    public Course getCourse(long id) {
        return CourseRepository.findById(id).orElseThrow();
    }

    public Page<Course> getCourses(int pageNum, int count) {
        return CourseRepository.findAll(PageRequest.of(pageNum, count));
    }

    public List<Course> getAllCourses() {
        return CourseRepository.findAll();
    }

    public void updateCourse(long id, CourseDTO courseDTO) {
        Course courseToChange = getCourse(id);
        courseToChange.setCourseAuthor(courseDTO.getModel().getCourseAuthor());
        courseToChange.setCourseName(courseDTO.getModel().getCourseName());
        courseToChange.setCourseData(courseDTO.getModel().getCourseData());
    }

    public User addCourse(long userId, CourseDTO course) {
        User user = UserRepository.findById(userId).orElseThrow();
        user.addCourse(course.getModel());
        return UserRepository.save(user);
    }

    public Course saveCourse(Course course) {
        return CourseRepository.save(course);
    }
}
