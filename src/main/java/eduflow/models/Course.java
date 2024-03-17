package eduflow.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_ID")
    private long CourseId;
    @Column(name = "course_Name")
    private String CourseName;
    @Column(name = "course_Data")
    private String CourseData;
    @ManyToOne(fetch = FetchType.LAZY)
    @Transient
    private User CourseAuthor;

    public Course() {
    }

    public Course(long CourseId, String CourseName, User CourseAuthor, String CourseData) {
        this.CourseId = CourseId;
        this.CourseName = CourseName;
        this.CourseData = CourseData;
        this.CourseAuthor = CourseAuthor;
    }
}
