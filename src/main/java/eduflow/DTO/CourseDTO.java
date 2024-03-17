package eduflow.DTO;

import jakarta.validation.constraints.NotBlank;
import eduflow.models.Course;
import eduflow.models.User;

public record CourseDTO(@NotBlank String name, @NotBlank User author, @NotBlank String data) {
    public Course getModel() {
        Course course = new Course();
        course.setCourseName(name);
        course.setCourseAuthor(author);
        course.setCourseData(data);
        return course;
    }
}

