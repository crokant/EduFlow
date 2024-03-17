package eduflow.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_ID")
    private long UserId;
    @Column(name = "user_Name")
    private String UserName;
    @Column(name = "user_Email")
    private String UserEmail;
    @OneToMany(mappedBy = "CourseAuthor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Course> Courses = new ArrayList<>();

    public User() {
    }

    public User(String UserName, String UserEmail, List<Course> Courses) {
        this.UserEmail = UserEmail;
        this.UserName = UserName;
        this.Courses = Courses;
    }
    public void addCourse(Course course) {
        Courses.add(course);
        course.setCourseAuthor(this);
    }
}
