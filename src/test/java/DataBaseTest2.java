import java.sql.*;

public class DataBaseTest2 {
    public static void main(String[] args) {

        String url="jdbc:mysql://3.239.253.255:3306/syntaxhrm_mysql";
        String username="syntax_hrm";
        String password="syntaxhrm123";

        try {
            Connection conn = DriverManager.getConnection(url, username, password);

            Statement st=conn.createStatement();

            ResultSet rset=st.executeQuery("select * from ohrm_nationality;");

            while(rset.next()) {
                String id = rset.getString("id");
                String name = rset.getString("name");

                System.out.println(id + " " + name);

            }

        }catch(SQLException e){
            e.printStackTrace();
        }

    }


}
