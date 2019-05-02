package cisc181.lab_7;

/**
 * a class for college course message
 */
public class CollegeCourse implements Comparable<CollegeCourse>{
    private String department;
    private int courseNum;
    private int sectionNum;
    private int capacity;

    /**
     * a constructor that accepts and sets these 4 properties
     * @param department department message
     * @param courseNum number of courses
     * @param sectionNum number of section
     * @param capacity max number of student
     */
    public CollegeCourse(String department, int courseNum, int sectionNum, int capacity) {
        this.department = department.toUpperCase();
        this.courseNum = courseNum;
        this.sectionNum = sectionNum;
        this.capacity = capacity;
    }

    /**
     * getter for department
     * @return department
     */
    public String getDepartment() {
        return department;
    }

    /**
     * getter for course
     * @return number of course
     */
    public int getCourseNum() {
        return courseNum;
    }

    /**
     * getter for section
     * @return section number
     */
    public int getSectionNum() {
        return sectionNum;
    }

    /**
     * getter for capacity
     * @return max number of department
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Override the toString method to represent the course
     * @return department + courseNum + "-" + sectionNum
     */
    @Override
    public String toString() {
        return department + courseNum + "-" + sectionNum;
    }

    /**
     * Override the equals method to return true if the courses department, course number and section number are equal
     * @param obj another CollegeCurse
     * @return whether equal
     */
    @Override
    public boolean equals(Object obj) {
        CollegeCourse collegeCourse = (CollegeCourse) obj;
        return department.equals(collegeCourse.department) && courseNum == collegeCourse.courseNum && sectionNum == collegeCourse.sectionNum;
    }

    /**
     * Define the compareTo method by first comparing the department, then the course number and lastly the section number.
     * @param o another CollegeCourse
     * @return first comparing the department, then the course number and lastly the section number.
     */
    @Override
    public int compareTo(CollegeCourse o) {
        if (department.compareTo(o.department) == 0) {
            if (courseNum > o.courseNum) return 1;
            else if (courseNum < o.courseNum) {
                return -1;
            } else {
                return Integer.compare(sectionNum, o.sectionNum);
            }
        } else {

            return department.compareTo(o.department);
        }
    }
}
