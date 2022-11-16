import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {
	
	public static final String DriverClass="com.mysql.jdbc.Driver";
	public static final String DbURL="jdbc:mysql://localhost:3306/db1";
	public static final String Username="root";
	public static final String Password="Lanasri@26";
	
	public static Connection dbConn() throws ClassNotFoundException, SQLException {
		
		Class.forName(DriverClass);
		
		Connection con=DriverManager.getConnection(DbURL,Username,Password);
		
		return con;
		
		
	}
	

}
