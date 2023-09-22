package repository;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import domain.StudentDto;

public class StudentDao {
  
  private SqlSessionFactory factory;
  
  private static StudentDao dao = new StudentDao();
  
  private StudentDao() {
    try {
      String resource = "config/mybatis-config.xml";
      InputStream in = Resources.getResourceAsStream(resource);
      factory = new SqlSessionFactoryBuilder().build(in);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  public static StudentDao getDao() {
    return dao;
  }
  
  private final String NS = "repository.student.";
  
  public List<StudentDto> studentList() {
    SqlSession ss = factory.openSession();
    List<StudentDto> list = ss.selectList(NS + "studentList");
    ss.close();
    return list;
  }
  
  public int studentCount() {
    SqlSession ss = factory.openSession();
    int studentCount = ss.selectOne(NS + "studentCount");
    ss.close();
    return studentCount;
  }
  
  
  
  
  
  
  
}
