package cisc181.lab_7;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class CollegeCourseTest {
    @Test
    public void test_CollegeCourse() {
        System.out.println("Testing CollegeCourse getters");
        CollegeCourse engl00_10 = new CollegeCourse("engl", 100, 10, 80);
        CollegeCourse math243_10 = new CollegeCourse("Math", 243, 10, 100);
        CollegeCourse math243_11 = new CollegeCourse("mAth", 243, 11, 100);

        assertEquals(engl00_10.getDepartment(), "ENGL");
        assertEquals(engl00_10.getSectionNum(), 10);
        assertEquals(engl00_10.getCourseNum(), 100);
        assertEquals(engl00_10.getCapacity(), 80);
        assertEquals(math243_10.getDepartment(), "MATH");
        assertEquals(math243_11.getDepartment(), "MATH");

    }


    @Test
    public void test_toString() {
        System.out.println("Testing CollegeCourse toString");
        CollegeCourse engl220_10 = new CollegeCourse("engl", 220, 10, 60);
        assertEquals(engl220_10.toString().equals("ENGL220-10".toString()), true);
    }

    @Test
    public void test_equals() {
        System.out.println("Testing CollegeCourse equals");
        CollegeCourse engl00_10 = new CollegeCourse("engl", 100, 10, 80);
        CollegeCourse engl00_10dup = new CollegeCourse("engl", 100, 10, 80);
        CollegeCourse engl00_12 = new CollegeCourse("engl", 100, 12, 80);
        CollegeCourse math243_10 = new CollegeCourse("Math", 243, 10, 100);

        assertEquals(engl00_10.equals(engl00_12), false);
        assertEquals(engl00_10.equals(math243_10), false);
        assertEquals(engl00_10.equals(engl00_10dup), true);

    }

    @Test
    public void test_compareTo() {
        System.out.println("Testing CollegeCourse compareTo");
        CollegeCourse engl00_10 = new CollegeCourse("engl", 100, 10, 80);
        CollegeCourse engl00_10dup = new CollegeCourse("engl", 100, 10, 80);
        CollegeCourse engl00_12 = new CollegeCourse("engl", 100, 12, 80);
        CollegeCourse engl220_10 = new CollegeCourse("engl", 220, 10, 60);
        CollegeCourse math243_10 = new CollegeCourse("Math", 243, 10, 100);

        assertEquals(engl00_10.compareTo(engl00_12) < 0, true);
        assertEquals(engl00_10.compareTo(math243_10) < 0, true);
        assertEquals(engl00_10.compareTo(engl00_10dup), 0);
        assertEquals(engl220_10.compareTo(engl00_10) > 0, true);
        assertEquals(engl00_12.compareTo(engl00_10) > 0, true);
    }


    @Test
    public void test_CourseWithLab() {
        System.out.println("Testing CourseWithLab");
        CoursesWithLab cisc181_10 = new CoursesWithLab("cisc", 181, 10, 80);

        CollegeCourse[] labs = cisc181_10.getLabSessions();
        // Testing number of lab sessions
        assertEquals(labs.length == 4, true);
        //testing values of lab session objects
        for (int i = 0; i < labs.length; i++) {
            assertEquals(labs[i].getDepartment().equals(cisc181_10.getDepartment()), true);
            assertEquals(labs[i].getCourseNum() == cisc181_10.getCourseNum(), true);
            assertEquals(labs[i].getSectionNum() == 100 + i, true);
            assertEquals(labs[i].getCapacity(), 20);
        }

        CoursesWithLab cisc220_12 = new CoursesWithLab("cisc", 220, 12, 65);

        labs = cisc220_12.getLabSessions();
        // Testing number of lab sessions
        System.out.println(labs.length);
        assertEquals(labs.length == 4, true);
        //testing values of lab session objects
        for (int i = 0; i < labs.length; i++) {
            assertEquals(labs[i].getDepartment().equals(cisc220_12.getDepartment()), true);
            assertEquals(labs[i].getCourseNum() == cisc220_12.getCourseNum(), true);
            assertEquals(labs[i].getSectionNum() == 100 + i, true);
            assertEquals(labs[i].getCapacity(), 20);
        }
    }


    @Test
    public void test_CourseWithLab_toString() {
        System.out.println("Testing CourseWithLab toString");
        CoursesWithLab cisc181_10 = new CoursesWithLab("cisc", 181, 10, 80);

        CollegeCourse[] labs = cisc181_10.getLabSessions();
        String courseString = "CISC181-10\n\tCISC181-100\n\tCISC181-101\n\tCISC181-102\n\tCISC181-103";
        assertEquals(cisc181_10.toString().trim().equals(courseString.toString()), true);

    }


    @Test
    public void test_CourseCatalogAdd() {
        System.out.println("Testing CourseCatalog Add");
        CourseCatalog UDCatalog = new CourseCatalog();

        CollegeCourse engl00_10 = new CollegeCourse("engl", 100, 10, 80);
        UDCatalog.addCourse(engl00_10);

        CoursesWithLab cisc181_12 = new CoursesWithLab("cisc", 181, 12, 80);
        UDCatalog.addCourse(cisc181_12);

        CollegeCourse math243_10 = new CollegeCourse("Math", 243, 10, 100);
        UDCatalog.addCourse(math243_10);


        CollegeCourse math243_11 = new CollegeCourse("mAth", 243, 11, 100);
        UDCatalog.addCourse(math243_11);

        CoursesWithLab cisc181_10 = new CoursesWithLab("cisc", 181, 10, 80);
        UDCatalog.addCourse(cisc181_10);

        CoursesWithLab cisc220_12 = new CoursesWithLab("cisc", 220, 12, 65);
        UDCatalog.addCourse(cisc220_12);

        CollegeCourse engl01_10 = new CollegeCourse("engl", 101, 10, 80);
        UDCatalog.addCourse(engl01_10);


        //check that courses are in sorted order

        ArrayList<CollegeCourse> compareCatalog = UDCatalog.getAllCourses();

        assertEquals(compareCatalog.get(0).equals(cisc181_10), true);
        assertEquals(compareCatalog.get(1).equals(cisc181_12), true);
        assertEquals(compareCatalog.get(2).equals(cisc220_12), true);
        assertEquals(compareCatalog.get(3).equals(engl00_10), true);
        assertEquals(compareCatalog.get(4).equals(engl01_10), true);
        assertEquals(compareCatalog.get(5).equals(math243_10), true);
        assertEquals(compareCatalog.get(6).equals(math243_11), true);

        //try adding a course that already exists
        CollegeCourse engl01_10dup = new CollegeCourse("engl", 101, 10, 80);
        assertEquals(UDCatalog.addCourse(engl01_10dup), false);

        //test remove course

        UDCatalog.removeCourse(math243_10);
        compareCatalog = UDCatalog.getAllCourses();


        assertEquals(compareCatalog.get(0).equals(cisc181_10), true);
        assertEquals(compareCatalog.get(1).equals(cisc181_12), true);
        assertEquals(compareCatalog.get(2).equals(cisc220_12), true);
        assertEquals(compareCatalog.get(3).equals(engl00_10), true);
        assertEquals(compareCatalog.get(4).equals(engl01_10), true);
        assertEquals(compareCatalog.get(5).equals(math243_11), true);

        // print the catalog
        UDCatalog.printCourseCatalog();

    }

}