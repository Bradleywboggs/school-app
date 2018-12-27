package exercises.school;

import java.util.HashMap;

public class Course {

    private int classSize;
    private boolean full;
    private final int courseId;
    private String courseTitle;
    private int courseCredits;
    private HashMap<Student, Integer> roster;
    private String department;


    public Course(String courseTitle, int courseId, String department, int courseCredits, HashMap<Student, Integer>  roster) {
        this.courseTitle = courseTitle;
        this.courseId = courseId;
        this.department = department;
        this.classSize = 25;
        this.roster = roster;
        this.full = false;


    }

    public Course(String courseTitle, int courseId) {
        this.courseTitle = courseTitle;
        this.courseId = courseId;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public int getCourseId() {
        return courseId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String aDepartment) {
        this.department = aDepartment;
    }

    public HashMap<Student, Integer> getRoster() {
        return roster;
    }

    public void setRoster(HashMap<Student, Integer>  aRoster) {
        if (aRoster.size() > this.classSize) {
            throw new IllegalArgumentException("Class size is exceeded.");
        } else if (aRoster.size() == this.classSize) {
            this.full = true;
            this.roster = aRoster;
        } else {
            this.full = false;
            this.roster = aRoster;
        }
    }

    public int getClassSize() {
        return classSize;
    }

    public void setClassSize(int aClassSize) {
        if (classSize <= 0) {
            throw new IllegalArgumentException("Class size must be greater than 0 ");
        } else if (classSize < this.roster.size()) {
            throw new IllegalArgumentException("Current roster exceeds class size");
        } else if (classSize == this.roster.size()) {
            this.full = true;
            this.classSize = aClassSize;
        } else {
            this.full = false;
            this.classSize = aClassSize;
        }
    }

    public boolean isFull() {
        return full;
    }

    public void setFull(boolean trueOrFalse) {
        this.full = trueOrFalse;
    }

    public int getCourseCredits() {
        return courseCredits;
    }

    public void setCourseCredits(int courseCredits) {
        this.courseCredits = courseCredits;
    }
}
