package wyw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import wyw.dbc.DatabaseConnection;
import wyw.vo.User;

public class UserDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	public UserDAO() throws Exception{
		DatabaseConnection dbc= new DatabaseConnection();
		this.conn = dbc.getConnection();
	}
	public boolean insertUser(User user) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		try{
			String sql = "INSERT INTO rank(username,score) values(?,?)";
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setString(1,user.getUsername());
			this.pstmt.setString(2,user.getScore());
			if(this.pstmt.executeUpdate()>0){
				flag = true;
			}
		}catch(Exception e){
			throw e;
		}finally{
			if(this.pstmt != null){
				try{
					this.pstmt.close();
//					this.conn.close();
				}catch(Exception e){
					throw e;
				}
			}
		}
		return flag;
	}
	
	public List<User> findAll()throws Exception{
		List<User> all=new ArrayList<User>();
		String sql = "SELECT username,score from rank ORDER BY score desc";
		this.pstmt = this.conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		ResultSet rs = this.pstmt.executeQuery();
		User user=null;
		while(rs.next()){
			user=new User();
			user.setUsername(rs.getString(1));
			user.setScore(rs.getString(2));
			all.add(user);
			}
		this.pstmt.close();
		return all;
	}
}
