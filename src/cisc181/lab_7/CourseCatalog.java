package cisc181.lab_7;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

/**
 * a class for catalog
 */
public class CourseCatalog {
    private ArrayList<CollegeCourse> collegeCourses;

    /**
     * a constructor that accepts no parameters and sets no parameters but allocates space for the ArrayList of CollegeCourses
     */
    public CourseCatalog() {
        collegeCourses = new ArrayList<>();

    }

    /**
     * accepts a CollegeCourse and returns true if the course already exists in the CourseCatalog
     * @param collegeCourse a collegeCourse object
     * @return true if exist
     */
    public boolean courseExists(CollegeCourse collegeCourse) {
        return collegeCourses.contains(collegeCourse);
    }

    /**
     * a getAllCourses that returns the ArrayList of courses
     * @return the ArrayList of courses
     */
    public ArrayList<CollegeCourse> getAllCourses() {
        return collegeCourses;
    }

    /**
     * adds the course to the ArrayList (in sorted order).  addCourse only adds the course if it doesn’t already exist and returns a boolean true if the course was added.
     * @param collegeCourse a collegecourse
     * @return whether add successfully
     */
    public boolean addCourse(CollegeCourse collegeCourse) {
        if (collegeCourses.contains(collegeCourse)) {
            return false;
        } else {
            collegeCourses.add(collegeCourse);
            collegeCourses.sort(CollegeCourse::compareTo);
            return true;
        }
    }

    /**
     *  removes the course from the CourseCatalog if it exists and returns a boolean true if the course was removed.
     * @param collegeCourse a college course
     * @return whether delete successfully
     */
    public boolean removeCourse(CollegeCourse collegeCourse) {
        if (!collegeCourses.contains(collegeCourse)) {
            return false;
        } else {
            collegeCourses.remove(collegeCourse);
            return true;
        }
    }

    /**
     * prints the catalog displaying each CollegeCourse on its own line in the order that the courses are stored in the ArrayList
     */
    public void printCourseCatalog() {
        ListIterator<CollegeCourse> iterator = collegeCourses.listIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());

        }
    }
}
