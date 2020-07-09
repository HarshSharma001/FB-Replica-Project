package Data_Processing_Units;

import java.sql.*;

public class SaveUserAccount
{
	public SaveUserAccount(String fname, String lname, String email, String uname, String pass) 
	{
		try {

            Class.forName("oracle.jdbc.driver.OracleDriver");

            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@DESKTOP-N6R0FO5:1521:XE", "system", "angiosperm");

            PreparedStatement pt = con.prepareStatement("insert into UserAccounts values(?,?,?,?,?)");
           
            
             pt.setString(1, fname);
			 pt.setString(2, lname);
			 pt.setString(3, email);
			 pt.setString(4, uname);
			 pt.setString(5, pass);

			 ResultSet rs = pt.executeQuery();
			 
			 con.close();
			 
        } catch (Exception e) {
            System.out.println(e);
        }
	}
}
