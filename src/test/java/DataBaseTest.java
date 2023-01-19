import java.sql.*;

public class DataBaseTest {
    public static void main(String[] args) {

        String url="jdbc:mysql://3.239.253.255:3306/syntaxhrm_mysql";
        String username="syntax_hrm";
        String password="syntaxhrm123";

        try {
            //1. connecting to the data base
            Connection conn = DriverManager.getConnection(url, username, password);


            //2. create a statement object to send sql queries
            Statement st=conn.createStatement();

            //3.using statement objwct we are sending query and database return
            //an oblect of result
            ResultSet rset=st.executeQuery("select FirstName, LastName from person;");

            rset.next();
            String fName=rset.getString("FirstName");
            String lName=rset.getString("LastName");

            System.out.println(fName+" "+lName);
            rset.next();
            fName=rset.getString("FirstName");
            lName=rset.getString("LastName");
            System.out.println(fName+" "+lName);

            System.out.println("Extracting data from resultset uing loop");

           while(rset.next()){
               fName=rset.getString("FirstName");
               lName=rset.getString("LastName");
               System.out.println(fName+" "+lName);
           }

        }catch (SQLException e){
            e.printStackTrace();
        }
        }
}
