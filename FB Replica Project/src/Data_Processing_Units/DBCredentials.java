package Data_Processing_Units;

import java.sql.*;

public class DBCredentials
{
	private boolean status;
	
	public DBCredentials(String uname, String pass) 
	{
		try {

            Class.forName("oracle.jdbc.driver.OracleDriver");

            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@DESKTOP-N6R0FO5:1521:XE", "system", "angiosperm");

            Statement st = con.createStatement();
            
            ResultSet rs = st.executeQuery("select Username, Password from UserAccounts");
			
            while(rs.next())
            {
            	if(uname.equals(rs.getString("Username")) && pass.equals(rs.getString("Password")))
            	{
            		setStatus(true);
            		break;
            	}
            	
            	else
            	{
            		setStatus(false);
            	}
            }
            
			 con.close();
			 
        } catch (Exception e) {
            System.out.println(e);
        }
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
}
