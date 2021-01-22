package app.model;

import java.sql.*;

public class JavaMySql {

   static String url = "url";
   static String username = "uname";
   static String password = "uPSS";

    public static int JAVASQLLength() {
        int length = 0;
        try {

            Connection connection = DriverManager.getConnection(url,username,password);
            System.out.println("Connection success!");
            String sql = "SELECT * FROM students";

            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while (result.next()){
                length++;
            }
            connection.close();
        } catch (SQLException throwables) {
            System.out.println("Connection failed!");
            throwables.printStackTrace();
        }
        return length;
    }
    public static String[][] DatabaseInfo(int length) {

        String[][] data;

        String[][] IDARRAY = new String[length][5];;

        String[] ID = new String[5];
        int i = 0;
        String Student [] = new String[length];

        try {


            Connection connection = DriverManager.getConnection(url,username,password);
            String sql = "SELECT * FROM students";

            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while (result.next()){

                String id_student = result.getString(1);
                String fullname = result.getString(2);
                String MathScore = result.getString(3);
                String EngScore = result.getString(4);
                String PhysScore = result.getString(5);
//                Student[i] = (fullname + "   " + MathScore + "   " + EngScore + "   "  + PhysScore);
                ID[0] = id_student;
                ID[1] = fullname;
                ID[2] = MathScore;
                ID[3] = EngScore;
                ID[4] = PhysScore;
                IDARRAY[i][0]= ID[0];
                IDARRAY[i][1]= ID[1];
                IDARRAY[i][2]= ID[2];
                IDARRAY[i][3]= ID[3];
                IDARRAY[i][4]= ID[4];
                i++;

            }

            connection.close();

        } catch (Exception throwables) {
            System.out.println("Connection failed!");
            throwables.printStackTrace();
        }
        data = IDARRAY;
        return data;
//        return Student;
    }
    public static void NewData(String FullName,int MathSc,int EngSc,int PhysSc){
        try {


            Connection connection = DriverManager.getConnection(url,username,password);
            String sql = "INSERT INTO students (Full_name,MathScore,EngScore,PhysScore) VALUES (?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1 ,FullName);
            statement.setString(2 ,Integer.toString(MathSc));
            statement.setString(3 ,Integer.toString(EngSc));
            statement.setString(4 ,Integer.toString(PhysSc));
            int rows = statement.executeUpdate();

            if (rows>0){
                System.out.println("Inserted!");
            }
            statement.close();
            connection.close();

        } catch (Exception throwables) {
            System.out.println("Connection failed!");
            throwables.printStackTrace();
        }

    }

    public static void DeleteRow(String RowId){
        try {

            Connection connection = DriverManager.getConnection(url,username,password);
            String sql = "DELETE FROM students WHERE idStudents=" + RowId;


            PreparedStatement statement = connection.prepareStatement(sql);
            statement.executeUpdate(sql);
            int rows = statement.executeUpdate();

            System.out.println("Deleted!");

            statement.close();
            connection.close();

        } catch (Exception throwables) {
            System.out.println("Connection failed!");
            throwables.printStackTrace();
        }
    }
}
