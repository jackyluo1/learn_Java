
// Problem1 [30 pts]
// Design a class called "Course" which represents a university course.
// It has a name and an id. You should provide equals(), toString(), constructors, setters and getters.
// Next, design a Student class. Each student has a name, an id, and a list of courses they have taken.
// For simplicity, assume 100 as the maximum number of courses a student can take.
// Other than the normal methods, you need to provide the following:
// -> A method for adding a course to a Student object.
// -> A method for searching if a student has taken a particular course. Two methods should be provided.
//    One searches by id, one searches by name.
// -> A method for removing a course. Again, two method should be provided.
class Student {
    private String name;
    private String id;
    private Course[] courses;

    public Student(String name, String id, Course[] courses) {
        this.name = name;
        this.id = id;
        this.courses = courses;
        if (this.courses.length > 100) {
            System.err.println("The maximum number of courses a student can take is 100!");
            System.exit(0);
        }
    }

    public Student() {
        this.name = null;
        this.id = null;
        this.courses = null;
    }

    public String getName() {
        return this.name;
    }

    public String getId() {
        return this.id;
    }

    public int numOfCourse() {
        return this.courses.length;
    }

    public String toString() {
        StringBuilder courses = new StringBuilder();
        for (int i = 0; i < this.courses.length; i++) {
            if (this.courses[i] != null) {
                courses.append(" " + this.courses[i].toString() + "; ");
            }
        }
        return " " + this.name + " " + this.id + " " + courses.toString();
    }

    public Student addCourse(Course A) {
        if (A == null) {
            System.exit(0);
        }
        int n = this.courses.length;
        Course[] newcourse = new Course[n + 1];
        newcourse[n] = A;
        for (int i = 0; i < n; i++) {
            newcourse[i] = this.courses[i];
        }
        Student another = new Student(this.name, this.id, newcourse);
        return another;
    }

    public Course searchCoursesByName(String name) {
        int n = this.courses.length;
        for (int i = 0; i < n; i++) {
            if (this.courses[i].getName().equals(name)) {
                return this.courses[i];
            }
        }
        return null;
    }

    public int searchCoursesByName_index(String name) {
        int n = this.courses.length;
        for (int i = 0; i < n; i++) {
            if (this.courses[i].getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public Course searchCoursesByID(String id) {
        int n = this.courses.length;
        for (int i = 0; i < n; i++) {
            if (this.courses[i].getId().equals(id)) {
                return this.courses[i];
            }
        }
        return null;
    }

    public int searchCoursesByID_index(String id) {
        int n = this.courses.length;
        for (int i = 0; i < n; i++) {
            if (this.courses[i].getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }

    public Student deleteCoursesById(String id) {
        int n = this.courses.length;
        int index = this.searchCoursesByID_index(id);
        if (index == -1) {
            System.err.println("No such a course!");
            System.exit(0);
        }
        Course[] newcourses = new Course[n - 1];
        for (int i = 0; i < index; i++) {
            newcourses[i] = this.courses[i];
        }
        for (int i = index + 1; i < n; i++) {
            newcourses[i - 1] = this.courses[i];
        }
        Student newstudent = new Student(this.name, this.id, newcourses);
        return newstudent;
    }

    public Student deleteCoursesByName(String name) {
        int n = this.courses.length;
        int index = this.searchCoursesByName_index(name);
        if (index == -1) {
            System.err.println("No such a course!");
            System.exit(0);
        }
        Course[] newcourses = new Course[n - 1];
        for (int i = 0; i < index; i++) {
            newcourses[i] = this.courses[i];
        }
        for (int i = index + 1; i < n; i++) {
            newcourses[i - 1] = this.courses[i];
        }
        Student newstudent = new Student(this.name, this.id, newcourses);
        return newstudent;
    }

    public static void main(String[] args) {
        Course python = new Course("Python", "5001");
        Course java = new Course("Java", "5004");
        Course C = new Course("C", "5008");
        Course[] AB = new Course[2];
        AB[0] = python;
        AB[1] = java;
        Student Jing = new Student("Jing", "2020101", AB);

        System.out.println(Jing);
        System.out.println("Search for java course: " + Jing.searchCoursesByName(java.getName()));
        System.out.println("Search for C course: " + Jing.searchCoursesByName(C.getName()));

        Student Jing_copy = Jing.addCourse(C);
        System.out.println("after add C course:" + Jing_copy);

        System.out.println("del python by ID: " + Jing_copy.deleteCoursesById(python.getId()));
        System.out.println("del C by ID: " + Jing_copy.deleteCoursesById(C.getId()));
        System.out.println("del python by name: " + Jing_copy.deleteCoursesByName(python.getName()));
        System.out.println("del C by name: " + Jing_copy.deleteCoursesByName(C.getName()));
    }

}

class Course {
    private String name;
    private String id;

    public Course(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public Course() {
        this.name = null;
        this.id = null;
    }

    public Course(Course another) {
        this(another.name, another.id);
    }

    public String getName() {
        return this.name;
    }

    public String getId() {
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String toString() {
        return "" + this.name + "-" + this.id;
    }

    public Boolean equals(Course another) {
        if (another == null)
            return false;
        return this.name.equals(another.name) && this.id.equals(another.id);
    }

    public static void main(String[] args) {
        Course A = new Course();
        System.out.println(A);
        A.setName("Python");
        A.setId("5001");

        Course B = new Course("Python", "5001");
        System.out.println(B);
        System.out.println(A.equals(B));
    }
}