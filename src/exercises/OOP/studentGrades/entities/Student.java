package exercises.OOP.studentGrades.entities;

public class Student {
    public String name;
    public double grade1;
    public double grade2;
    public double grade3;
    double minimum = 60.0;

    public double finalGrade() {
        return (grade1 + grade2 + grade3);
    }

    public String approved() {
        if (finalGrade() >= minimum) {
            return "Pass";
        } else {
            return "Failed";
        }
    }

    public double missingPoints() {
        return minimum - finalGrade();
    }

    public String toString() {
        if (approved() == "Pass") {
            return "Final Grade: " + finalGrade()
            + "\n" + approved();
        }
        else {
            return "Final Grade: " + finalGrade()
            + "\n" + approved()
            + "\nMissing Points: " + missingPoints();
        }

    }
}