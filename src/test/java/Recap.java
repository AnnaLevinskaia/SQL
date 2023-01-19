import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Recap {
    public static void main(String[] args) {
        String url = "jdbc:mysql://3.239.253.255:3306/syntaxhrm_mysql";
        String username = "syntax_hrm";
        String password = "syntaxhrm123";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);

            Statement st=connection.createStatement();
            String query="select * from person order by FirstName";
            ResultSet rst=st.executeQuery(query);

            ResultSetMetaData rsmdata=rst.getMetaData(); //gives the info about resultset object,
            //to dynamically have the name of the column
            System.out.println(rsmdata);

            //extract data from resultSet and store it
            List<Map<String, String>> listFromRset=new ArrayList<>();

            //iterate over rows
            while (rst.next()){
                Map<String, String> map=new LinkedHashMap<>();
                //iterate over columns
                for (int i = 1; i <= rsmdata.getColumnCount(); i++) {
                    //store value
                    String key=rsmdata.getColumnName(i); //get key
                    String value= rst.getString(key); //get value of i column
                    map.put(key,value);
                }
                System.out.println(map);
                listFromRset.add(map);
            }


        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
