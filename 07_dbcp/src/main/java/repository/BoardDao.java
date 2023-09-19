package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import domain.BoardDto;

public class BoardDao {
  
  // 모든 메소드가 공동으로 사용할 객체 선언
  private Connection con;
  private PreparedStatement ps;
  private ResultSet rs;
  
  // Connection Pool 관리 DataSource 객체 선언
  private DataSource dataSource;
  
  // Singleton Pattern으로 BoardDao 객체 생성 (DB를 사용하기 위해서는 singleton이 필요하다.)
  private static BoardDao dao = new BoardDao();
  private BoardDao() {
    // META-INF/context.xml에 있는 <Resource name="jdbc/oraclexe" /> 태그 내용을 읽어서 DataSource 객체 생성하기
    try {
      Context context = new InitialContext();
      Context env = (Context)context.lookup("java:comp/env"); 
      dataSource = (DataSource)env.lookup("jdbc/oraclexe");
    } catch (Exception e) {
      e.printStackTrace();  
    }
  }
  public static BoardDao getDao() {
    return dao;
  }
  
  // 자원 반납 메소드
  public void close() {
    try {
      if(rs != null) rs.close();
      if(ps != null) ps.close();
      if(con != null) con.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  // 게시글 등록 메소드
  public int register(BoardDto dto) {
    
    // 등록 결과 선언 (insert 실행 결과는 삽입된 행의 갯수이다.)
    int insertResult = 0;
    
    try {
      
      // Connection Pool에서 connection을 하나 받아온다.
      // Connection Pool 관리는 DataSource 객체가 수행한다.
      
      con = dataSource.getConnection();
      
      // 쿼리문 작성
      String sql = "INSERT INTO BOARD_T(BOARD_NO, TITLE, CONTENT, MODIFIED_AT, CREATED_AT) VALUES(BOARD_SEQ.NEXTVAL, ?, ?, SYSDATE, SYSDATE)";
      
      // ps 객체 생성 (쿼리문 실행을 담당하는 객체)
      ps = con.prepareStatement(sql);
      
      // 쿼리문의 변수 (?로 처리된 부분)에 값을 전달
      ps.setString(1, dto.getTitle());    // 1번째 물음표(?)에 dto.getTitle() 전달하기
      ps.setString(2, dto.getContent());  // 2번째 물음표(?)에 dto.getContent() 전달하기
      
      // 쿼리문의 실행
      insertResult = ps.executeUpdate();
      
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      close();
    }
    
    // 등록 결과 반환
    return insertResult;
    
  }
  
  /*
  SELECT A.BOARD_NO, A.TITLE, A.CONTENT, A.MODEFIED_AT, A.CREATED_AT
  FROM (SELECT ROW_NUMBER() OVER (ORDER BY BOARD_NO DESC) AS RN, BOARD_NO, TITLE, CONTENT, MODEFIED_AT, CREATED_AT
          FROM BOARD_T) A
 WHERE A.RN BETWEEN 1 AND 20;
  */
  
  
  
  
  
  
}
