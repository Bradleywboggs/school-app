package exercises.school;

import java.util.Objects;

public class Student {

    enum GradeLevel {

        FRESHMAN ("Freshman"),
        SOPHOMORE ("Sophomore"),
        JUNIOR("Junior"),
        SENIOR("Senior");

        private String classStanding;

         GradeLevel(String classStanding) {
            this.classStanding = classStanding;
        }
    }

    private static int nextStudentId = 1;
    private String name;
    private final int studentId;
    private int numberOfCredits;
    private double gpa;
    private double qualityScore;
    private GradeLevel classStanding;

    public Student(String name, int studentId, int numberOfCredits, double gpa) {
        this.name = name;
        this.studentId = nextStudentId; nextStudentId++;
        this.numberOfCredits = numberOfCredits;
        this.gpa = gpa;
        this.qualityScore = gpa * numberOfCredits;
        this.classStanding = determineClassStanding();

    }

    public Student(String name) {
        this(name, nextStudentId, 0, 0 );
             nextStudentId++;
        this.qualityScore = 0;
        this.classStanding = GradeLevel.FRESHMAN;

    }

    public String getName() {
        return name;

    }

    public void setName(String aName) {
        name = aName;

    }

    public int getStudentId() {
        return studentId;
    }

    public int getNumberOfCredits() {
        return numberOfCredits;
    }


    private void setNumberOfCredits(int aNumberOfCredits) {
        if (numberOfCredits < 0) {
            throw new IllegalArgumentException("Number of credits cannot be negative");
        } else {
            numberOfCredits = aNumberOfCredits;
        }

    }


    public double getGpa() {
        return gpa;
    }

    private void setGpa(double aGpa) {
        if (aGpa < 0 || aGpa > 5) {
            throw new IllegalArgumentException("GPA must be between 0 and 5");
        } else {
            gpa = aGpa;
        }
    }

    public double getQualityScore() {
        return qualityScore;
    }

    private void setQualityScore(double qualityScore) {
        this.qualityScore = qualityScore;
    }

    public GradeLevel getClassStanding() {
        return classStanding;
    }

    public void setClassStanding(GradeLevel classStanding) {
        this.classStanding = classStanding;
    }

    private GradeLevel determineClassStanding() {
        if (this.numberOfCredits >= 0 && this.numberOfCredits <= 29) {
            GradeLevel classStanding = GradeLevel.FRESHMAN;
            return classStanding;
        } else if (this.numberOfCredits >= 30 && this.numberOfCredits <= 59) {
            GradeLevel classStanding = GradeLevel.SOPHOMORE;
            return classStanding;
        } else if (this.numberOfCredits >= 60 && this.numberOfCredits <= 89) {
            GradeLevel classStanding = GradeLevel.JUNIOR;
            return classStanding;
        } else {
            GradeLevel classStanding = GradeLevel.SENIOR;
            return classStanding;
        }
    }


        public double getCourseQualityScore(double courseCreditHours, double courseGpa) {
        double courseQualityScore = courseCreditHours * courseGpa;
        return courseQualityScore;
    }

    public double updateTotalQualityScore(double courseCreditHours, double courseGpa) {
        this.qualityScore += getCourseQualityScore(courseCreditHours, courseGpa);
        return this.qualityScore;
    }

    public double updateNumberOfCredits(double courseCreditHours) {
        this.numberOfCredits += courseCreditHours;
        return this.numberOfCredits;
    }

    public double updateGpa(double courseCreditHours, double courseGpa) {
        this.gpa = updateTotalQualityScore(courseCreditHours, courseGpa) / updateNumberOfCredits(courseCreditHours);
        return this.gpa;
    }

    @Override
    public String toString() {
        return this.name + "(" + this.classStanding + ", " + this.gpa + ", " + this.studentId + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return studentId == student.studentId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId);
    }





    }







