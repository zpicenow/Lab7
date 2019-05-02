package cisc181.lab_7;

/**
 * a class for course
 */
public class CoursesWithLab extends CollegeCourse{
    public static final int LAB_SESSION_CAPACITY = 20;
    private CollegeCourse[] labSessions;


    /**
     * a constructor that accepts and sets these 4 properties
     *
     * @param department department message
     * @param courseNum  number of courses
     * @param sectionNum number of section
     * @param capacity   max number of student
     */
    public CoursesWithLab(String department, int courseNum, int sectionNum, int capacity) {
        super(department, courseNum, sectionNum, capacity);
        labSessions = new CollegeCourse[(int) Math.ceil(capacity * 1.0 / LAB_SESSION_CAPACITY)];
        for (int i = 0; i < labSessions.length; i++) {
            labSessions[i] = new CollegeCourse(department, courseNum, 100+i, LAB_SESSION_CAPACITY);
        }
    }

    /**
     * getLabSessions that returns the lab sessions array
     * @return the lab sessions array
     */
    public CollegeCourse[] getLabSessions() {
        return labSessions;
    }

    /**
     * calling the base class’ toString and then concatenating the Lab Sessions one per line but indented with one tab
     * @return base class’ toString and then concatenating the Lab Sessions one per line but indented with one tab
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(super.toString());
        for (CollegeCourse collegeCourse :
                labSessions) {
            stringBuilder.append("\n\t" + collegeCourse.getDepartment() + collegeCourse.getCourseNum() + "-" + collegeCourse.getSectionNum());
        }

        System.out.println(stringBuilder.toString());
        return stringBuilder.toString();
    }
}

