package loginPage;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import project6.DBConnection; 

public class MemberDao {

	Connection conn = null; 
	PreparedStatement pstm = null; 
	ResultSet rs = null;  
	
	// 회원가입
	 public boolean register(Member m) {
		  String[] ids = m.getEmail().split("@");
	      boolean flag = false;
	      java.util.Date utilDate = new java.util.Date();
	      Date sqlDate = new java.sql.Date(utilDate.getTime());
	      try {
	         String sql = "insert into scrollbook_mem(id,pass,phone,name,mdate)\r\n"
	               + "values(?,?,?,?,?)";
	         conn = DBConnection.getConnection();
	         conn.setAutoCommit(false);
	         pstm = conn.prepareStatement(sql);
	         pstm.setString(1, m.getEmail());
	         pstm.setString(2, m.getPass());
	         pstm.setString(3, m.getPhone());
	         pstm.setString(4, m.getName());
	         pstm.setDate(5, (java.sql.Date)m.getMdate());
	         if(pstm.executeUpdate() == 1) { flag = true;}
	         sql = "create sequence seq_"+ids[0]+
	        		 " increment by 1 start with 1 minvalue 1 maxvalue 999999";
	         conn.setAutoCommit(false);
	         pstm = conn.prepareStatement(sql);
	         pstm.executeUpdate();
	      } catch (SQLException e1) {
	         System.out.println("예외발생");
	         e1.printStackTrace();
	      } finally{
	         try {
	            if (rs != null) {
	               rs.close();
	            }
	            if (pstm != null) {
	               pstm.close();
	            }
	            
	            if (conn != null) {
	               conn.close();
	            }
	         } catch (Exception e1) {
	            throw new RuntimeException(e1.getMessage());
	         }
	      }
	      return flag;
	   }
	 
	 // 중복된 아이디 확인 
	 public boolean crtId(Member m){
		   boolean flag = false;
		   try {
			   String sql = "SELECT * FROM scrollbook_mem where id = ?";
			   conn = DBConnection.getConnection();
			   pstm = conn.prepareStatement(sql);
			   pstm.setString(1, m.getEmail());
			   rs = pstm.executeQuery();
			   flag = rs.next(); //true면 중복, false면 중복되는 정보 없음
		   } catch (SQLException e1) {
			   System.out.println("예외발생");
			   e1.printStackTrace();
		   } finally{
			   try {
				   if (rs != null) {
					   rs.close();
				   }
				   if (pstm != null) {
					   pstm.close();
				   }
				   if (conn != null) {
					   conn.close();
				   }
			   } catch (Exception e1) {
				   throw new RuntimeException(e1.getMessage());
			   }
		   }
		   return flag;
	   }
	 
	 // 중복된 휴대전화 확인
	 public boolean crtPhone(Member m) {
		 boolean flag =false;
		 try {
			 String sql = "SELECT * FROM scrollbook_mem where phone = ?";
			   conn = DBConnection.getConnection();
			   pstm = conn.prepareStatement(sql);
			   pstm.setString(1, m.getPhone());
			   rs = pstm.executeQuery();
			   flag = rs.next(); //true면 중복, false면 중복되는 정보 없음
		   } catch (SQLException e1) {
			   System.out.println("예외발생");
			   e1.printStackTrace();
		   } finally{
			   try {
				   if (rs != null) {
					   rs.close();
				   }
				   if (pstm != null) {
					   pstm.close();
				   }
				   if (conn != null) {
					   conn.close();
				   }
			   } catch (Exception e1) {
				   throw new RuntimeException(e1.getMessage());
			   }
		   }
		 
		 return flag;
	 }
	 
	 // 로그인   
	   public boolean login(Member m){
	      boolean flag = false;
	      try {
	         String sql = "SELECT * FROM SCROLLBOOK_MEM WHERE ID = ? AND PASS = ?";
	         conn = DBConnection.getConnection();
	         pstm = conn.prepareStatement(sql);
	         pstm.setString(1, m.getEmail());
	         pstm.setString(2, m.getPass());
	         rs = pstm.executeQuery();
	         flag = rs.next(); //true면 로그인 성공, false 면 로그인 실패
	      } catch (SQLException e1) {
	         System.out.println("예외발생");
	         e1.printStackTrace();
	      } finally{
	         try {
	            if (rs != null) {
	               rs.close();
	            }
	            if (pstm != null) {
	               pstm.close();
	            }
	            if (conn != null) {
	               conn.close();
	            }
	         } catch (Exception e1) {
	            throw new RuntimeException(e1.getMessage());
	         }
	      }
	      return flag;
	   }
	   
	   public Member getMember(String id, String pass) {
		   Member m = null;
		   boolean flag = false; 
		   try {
		         String sql = "SELECT * FROM SCROLLBOOK_MEM WHERE ID = ? AND PASS = ?";
		         conn = DBConnection.getConnection();
		         pstm = conn.prepareStatement(sql);
		         pstm.setString(1, m.getEmail());
		         pstm.setString(2, m.getPass());
		         rs = pstm.executeQuery();
		         flag = rs.next(); //true면 로그인 성공, false 면 로그인 실패
		      } catch (SQLException e1) {
		         System.out.println("예외발생");
		         e1.printStackTrace();
		      } finally{
		         try {
		            if (rs != null) {
		               rs.close();
		            }
		            if (pstm != null) {
		               pstm.close();
		            }
		            if (conn != null) {
		               conn.close();
		            }
		         } catch (Exception e1) {
		            throw new RuntimeException(e1.getMessage());
		         }
		      }
		   
		   return m;
	   }
	   
	   // 회원탈퇴 
	   public boolean deleteMember(Member m) {
		   String[] ids = m.getEmail().split("@");
		   boolean flag = false;
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = null;
			try {
				con = DBConnection.getConnection();
				sql = "delete from scrollbook_mem where id=?";	// 아이디 삭제 sql
				pstmt = con.prepareStatement(sql);
				conn.setAutoCommit(false);
				pstmt.setString(1, m.getEmail());
				if(pstmt.executeUpdate()==1) {flag = true;} 
				 sql = "drop sequence seq_"+ids[0];		// 해당 시퀀스 삭제 sql
				 conn.setAutoCommit(false);
		         pstm = conn.prepareStatement(sql);
		         pstm.executeUpdate();
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
				 if (rs != null) {
		               rs.close();
		            }
		            if (pstm != null) {
		               pstm.close();
		            }
		            if (conn != null) {
		               conn.close();
		            }
		         } catch (Exception e1) {
		            throw new RuntimeException(e1.getMessage());
		         }
			}
			return flag;
		}
}

