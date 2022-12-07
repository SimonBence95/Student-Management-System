package hu.nye.progtech;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * Controls Database flows.
 */
public class Main {

    /**
     * Entry point of students class manager programme.
     *
     * @param args proper argumentums needed by the programme.
     *
     * @throws SQLException thorws exception if there are database problems.
     */
    public static void main(String[] args) throws SQLException {

        Scanner scanner = new Scanner(System.in);

        System.out.println("1. Print Student table");
        System.out.println("2. Add new class to the database");
        System.out.println("3. Register for the class");
        System.out.println("4. Add grade to person through ID");
        System.out.println("5. Delete course from database");
        System.out.println("6. Print the list of command on console");
        System.out.println("0. Exit");

        while (true) {
            int option;
            System.out.println("Enter Command!");
            option = scanner.nextInt();
            if (option == 1) {

                System.out.println("Printing current database to console!");
                Connection connection = DriverManager.getConnection("jdbc:h2:tcp://localhost/./miniNeptun", "sa", "password");
                Statement statement = connection.createStatement();


                ResultSet resultSet = statement.executeQuery("SELECT * FROM LESSONS");

                while (resultSet.next()) {
                    int id = resultSet.getInt("ID");
                    String lesson = resultSet.getString("LESSON");
                    int start = resultSet.getInt("START");
                    int finish = resultSet.getInt("FINISH");
                    String student = resultSet.getString("STUDENT");
                    int grade = resultSet.getInt("GRADE");

                    Lessons lessons = new Lessons(id, lesson, start, finish, student, grade);
                    System.out.println(lessons);
                }
                resultSet.close();
                statement.close();
                connection.close();

            } else if (option == 2) {
                {
                    Scanner scanner2 = new Scanner(System.in);

                    System.out.println("Please write in Lessons name, Lessons [start and end] you want to store in the database:" +
                            "([LESSON]),([START]),([FINISH])");
                    System.out.println("U can delete it afterwards and store it again (if needed)");
                    System.out.println("***");

                    Connection connection2 = DriverManager.getConnection("jdbc:h2:tcp://localhost/./miniNeptun", "sa", "password");

                    System.out.println("Pls enter subjects name!");
                    String LESSON_NAME = scanner2.nextLine();
                    System.out.println("Pls enter lessons Start-time!");
                    int LESSON_START = scanner2.nextInt();
                    System.out.println("Pls enter lessons End-time!");
                    int LESSON_FINISH = scanner2.nextInt();

                    String insertQuery = "INSERT INTO LESSONS (LESSON, START, FINISH) VALUES (?, ?, ?)";
                    PreparedStatement preparedStatement2 = connection2.prepareStatement(insertQuery);
                    preparedStatement2.setString(1, LESSON_NAME);
                    preparedStatement2.setInt(2, LESSON_START);
                    preparedStatement2.setInt(3, LESSON_FINISH);

                    int i1 = preparedStatement2.executeUpdate();
                    System.out.println("Affected rows: " + i1);

                    preparedStatement2.close();
                    connection2.close();
                }
            } else if (option == 3) {

                Scanner scanner3 = new Scanner(System.in);

                System.out.println("Please write in the students name, ID of lesson-s name of row you want to store in the database:" +
                        "([STUDENT]),([ID])");
                System.out.println("U can modify it afterwards using the same command");
                System.out.println("***");

                Connection connection3 = DriverManager.getConnection("jdbc:h2:tcp://localhost/./miniNeptun", "sa", "password");

                System.out.println("Pls enter students name!");
                String STUDENT_NAME = scanner3.nextLine();
                System.out.println("Pls enter the ID of lessons line you want to add the user to!");
                int ID_OF_LINE = scanner3.nextInt();

                String updateQuery = "UPDATE LESSONS SET STUDENT= ? WHERE ID = ?";
                PreparedStatement preparedStatement3 = connection3.prepareStatement(updateQuery);
                preparedStatement3.setString(1, STUDENT_NAME);
                preparedStatement3.setInt(2, ID_OF_LINE);

                int i2 = preparedStatement3.executeUpdate();
                System.out.println("Affected rows: " + i2);

                preparedStatement3.close();
                connection3.close();

            } else if (option == 4) {
                {
                    Scanner scannerGrade = new Scanner(System.in);

                    System.out.println("Please write in grade of student and ID of that students ROW you want to store in the database:" +
                            "([GRADE]),([ID])");
                    System.out.println("U can modify it afterwards using the same command");
                    System.out.println("***");

                    Connection connectionGrade = DriverManager.getConnection("jdbc:h2:tcp://localhost/./miniNeptun", "sa", "password");
                    System.out.println("Pls enter grade!");
                    int GRADE_TO_ADD = scannerGrade.nextInt();
                    System.out.println("Pls enter the ID of students line you want to add the grade to!");
                    int ID_OF_GRADE = scannerGrade.nextInt();

                    String updateQuery = "UPDATE LESSONS SET GRADE = ? WHERE ID = ?";
                    PreparedStatement preparedStatementGrade = connectionGrade.prepareStatement(updateQuery);
                    preparedStatementGrade.setInt(1, GRADE_TO_ADD);
                    preparedStatementGrade.setInt(2, ID_OF_GRADE);

                    int iG = preparedStatementGrade.executeUpdate();
                    System.out.println("Affected rows: " + iG);

                    preparedStatementGrade.close();
                    connectionGrade.close();
                }

            } else if (option == 5) {

                Scanner scanner4 = new Scanner(System.in);

                System.out.println("Please write in ID of row you want to delete from database:([ID])");
                System.out.println("***");

                Connection connection4 = DriverManager.getConnection("jdbc:h2:tcp://localhost/./miniNeptun", "sa", "password");

                System.out.println("Pls enter the ID of row (LESSON) u want to delete from database!");

                System.out.println("Pls write in ID of row of course u want to delete from database");
                int ID_TO_DELETE = scanner4.nextInt();

                String deleteQuery = "DELETE FROM LESSONS WHERE ID = ?";
                PreparedStatement preparedStatement = connection4.prepareStatement(deleteQuery);
                preparedStatement.setInt(1, ID_TO_DELETE);

                int i3 = preparedStatement.executeUpdate();
                System.out.println("Affected rows: " + i3);

            } else if (option == 6) {
                System.out.println("The list of commands!");
                System.out.println("1. Print Student table");
                System.out.println("2. Add new class to the database");
                System.out.println("3. Register for the class");
                System.out.println("4. Add grade to person through ID");
                System.out.println("5. Delete course from database");
                System.out.println("6. Print the list of command on console");
                System.out.println("0. Exit");
            } else if (option == 0) {
                System.out.println("Exiting...");
                System.exit(0);
            }

        }

    }
}