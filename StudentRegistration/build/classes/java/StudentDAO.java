import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
	
	public int Insert(Student s) throws ClassNotFoundException, SQLException{
		
		Connection con=DbUtil.dbConn();
		
		String sql= "insert into Student values(?,?,?,?)";
		
		PreparedStatement ps= con.prepareStatement(sql);
		
		ps.setString(1, s.getSname());
		ps.setString(2, s.getSemail());
		ps.setLong(3, s.getSphono());
		ps.setString(4, s.getSpassword());
		
		return ps.executeUpdate();
		
	}
	
  public int Update(Student s) throws ClassNotFoundException, SQLException{
		
		Connection con=DbUtil.dbConn();
		
		String sql= "update Student set semail= ? where sname= ?";
		
		PreparedStatement ps= con.prepareStatement(sql);
		
		ps.setString(1, s.getSemail());
		ps.setString(2, s.getSname());
		
		return ps.executeUpdate();
		
	}
	
  public int Delete(Student s) throws ClassNotFoundException, SQLException{
		
		Connection con=DbUtil.dbConn();
		
		String sql= "Delete from Student where sname= ?" ;
		
		PreparedStatement ps= con.prepareStatement(sql);
		
		ps.setString(1, s.getSname());
		
		return ps.executeUpdate();
		
	}
	


    public List<Student> getall() throws ClassNotFoundException, SQLException{
    	
	   List<Student> list=new ArrayList<Student>();
	   
 	   Connection con=DbUtil.dbConn();
 	   
	   String sql="select * from student";
	   
	  PreparedStatement ps=con.prepareStatement(sql);
	  ResultSet rs=ps.executeQuery();
	  
	  while(rs.next()) {
		  Student s=new Student();
		  s.setSname(rs.getString(1));
		  s.setSemail(rs.getString(2));
		  s.setSphono(rs.getInt(3));
		  s.setSpassword(rs.getString(4));
		  list.add(s);
	    }
	  
	return list;
  }
}
