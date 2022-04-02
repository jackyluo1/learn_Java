
/**
 * Problem2 [40 pts]
 * Let's design a class Transcript that contains a Student and an array of
 * CourseWithScore.
 * - You could just use the class 'Student' in Problem1 here.
 * - CourseWithScore is similar to the class 'Course' in Question 1, but it has
 * one more variable 'score'(double). So, you should consider using inheritance
 * here.
 * - Transcript
 * > Transcript only has one constructor. You just need to name the student.
 * The number of courses in the transcript cannot exceed the number of courses
 * the student has taken.
 * > A method called 'addCourse', add a course to this transcript. You should
 * check whether
 * this student has taken this course or not. And you cannot add duplicate
 * courses to the transcript.
 * > A method called 'removeCourse', remove by id. If such id doesn't exist,
 * throw an IllegalArgumentException.
 * > A method called 'editCourse', edit score by course id. If such id doesn't
 * exist, or the score is invalid, throw an IllegalArgumentException.
 * > A method called 'getFinalScore', which will return the average score of all
 * courses in this transcript.
 */

class CourseWithScore extends Course {
    private double score;

    public CourseWithScore(String name, String id, double score) {
        super(name, id);
        if (score < 0 || score > 100) {
            System.err.println("The score is invalid");
            score = 0;
        }
        this.score = score;
    }

    public double getScore() {
        return this.score;
    }

    public String getCoursename(String id) {
        return super.getName();
    }

    public void setScore(double score1) {
        this.score = score1;
    }

    public String toString() {
        return super.toString() + " : " + this.score + "; ";
    }

    public static void main(String[] args) {
        CourseWithScore Python = new CourseWithScore("Python", "5001", 98);
        System.out.println(Python);
        Python.setScore(100);
        System.out.println(Python);
    }
}

class Transcript {
    private Student student;
    private CourseWithScore[] courseWithScore;

    public Transcript(Student student, CourseWithScore[] courseWithScore) {
        this.student = student;
        this.courseWithScore = courseWithScore;
        if (this.courseWithScore.length > this.student.numOfCourse()) {
            System.err.println(
                    "The number of courses in the transcript cannot exceed the number of courses the student has taken!");
            System.exit(0);
        }
    }

    public Transcript() {
        this.student = null;
        this.courseWithScore = null;
    }

    public double getFinalScore() {
        int n = this.courseWithScore.length;
        double score = 0;
        for (int i = 0; i < n; i++) {
            score += this.courseWithScore[i].getScore();
        }
        double avg = (double) score / n;
        return avg;
    }

    public void editCourse(String ID, double scoreA) {
        Course courseToDel = this.student.searchCoursesByID(ID);

        if (courseToDel == null) {
            System.err.println("No such a course!");
            System.exit(0);
        }
        if (scoreA < 0 || scoreA > 100) {
            System.err.println("The score is invalid!");
            System.exit(0);
        }

        for (int i = 0; i < courseWithScore.length; i++) {
            if (this.courseWithScore[i].getName() == courseToDel.getName()) {
                this.courseWithScore[i].setScore(scoreA);
            }
        }
    }

    public int searchCoursesByID_index(String id) {
        int n = this.courseWithScore.length;
        for (int i = 0; i < n; i++) {
            if (this.courseWithScore[i].getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }

    public Transcript removeCourse(String ID) {
        int index = this.searchCoursesByID_index(ID);
        if (index == -1) {
            System.err.println("No such a course!");
            System.exit(0);
        }
        int n = this.courseWithScore.length;
        CourseWithScore[] newCourses = new CourseWithScore[n - 1];
        for (int i = 0; i < index; i++) {
            newCourses[i] = this.courseWithScore[i];
        }
        for (int i = index + 1; i < n; i++) {
            newCourses[i - 1] = this.courseWithScore[i];
        }
        this.student = this.student.deleteCoursesById(ID); // Keep course data compatible
        Transcript another = new Transcript(this.student, newCourses);
        return another;
    }

    public Transcript addCourse(Course A, double scoreA) {
        if (this.student.searchCoursesByID(A.getId()) != null) {
            System.err.println("This student has taken this course!");
            System.exit(0);
        }
        if (scoreA < 0 || scoreA > 100) {
            System.err.println("Your score is invalid for the " + A.toString() + " course!");
            System.exit(0);
        }

        this.student = this.student.addCourse(A); // Keep course data compatible
        int n = this.courseWithScore.length;
        CourseWithScore[] newCourses = new CourseWithScore[n + 1];
        Transcript another = new Transcript(this.student, newCourses);
        another.courseWithScore[n] = new CourseWithScore(A.getName(), A.getId(), scoreA);
        for (int i = 0; i < n; i++) {
            another.courseWithScore[i] = this.courseWithScore[i];
        }
        return another;
    }

    public String toString() {
        StringBuilder courses = new StringBuilder();
        for (int i = 0; i < this.courseWithScore.length; i++) {
            if (this.courseWithScore[i] != null) {
                courses.append(this.courseWithScore[i].toString());
            }
        }
        return "" + this.student.getName() + "-" + this.student.getId() + ": " + courses.toString();
    }

    public static void main(String[] args) {
        CourseWithScore Python = new CourseWithScore("Python", "5001", 97);
        CourseWithScore Java = new CourseWithScore("Java", "5004", 98);
        CourseWithScore[] mycourses = new CourseWithScore[2];

        Course python = new Course("Python", "5001");
        Course java = new Course("Java", "5004");
        Course C1 = new Course("C", "5008");
        Course[] AB = new Course[2];
        AB[0] = python;
        AB[1] = java;

        mycourses[0] = Python;
        mycourses[1] = Java;

        Student Jing = new Student("Jing", "2020101", AB);
        Transcript mytranscript = new Transcript(Jing, mycourses);
        System.out.println(mytranscript);

        Transcript mynewtranscript = mytranscript.addCourse(C1, 100);
        System.out.println("add Course 5008: " + mynewtranscript);

        Transcript mynewtranscript1 = mynewtranscript.removeCourse("5008");
        System.out.println("removeCourse 5008: " + mynewtranscript1);

        mynewtranscript.editCourse("5001", 98.88);
        System.out.println("set 5001 score from 98 to 98.88: " + mynewtranscript);

        System.out.println("MY AVG SCORES: " + mynewtranscript.getFinalScore());
    }

}
