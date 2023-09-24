package repository;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

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
  
  public double studentTotalAve() {
    SqlSession ss = factory.openSession();
    double studentTotalAve = ss.selectOne(NS + "studentTotalAve");
    ss.close();
    return studentTotalAve;
  }
  
  public List<StudentDto> studentTopList() {
    SqlSession ss = factory.openSession();
    List<StudentDto> list = ss.selectList(NS + "studentTopList");
    ss.close();
    return list;
  }
  
  public int studentAdd(StudentDto dto) {
    SqlSession ss = factory.openSession(false);
    int addResult = ss.insert(NS + "studentAdd", dto);
    if(addResult == 1) {
      ss.commit();
    }
    ss.close();
    return addResult;
  }
  
  public List<StudentDto> studentRangeList(Map<String, Object> map) {
    SqlSession ss = factory.openSession();
    List<StudentDto> list = ss.selectList(NS + "studentRangeList", map);
    ss.close();
    return list;
  }
  
  public int studentRangeCount(Map<String, Object> map) {
    SqlSession ss = factory.openSession();
    int rangeCount = ss.selectOne(NS + "studentRangeCount", map);
    ss.close();
    return rangeCount;
  }
  
  public double studentRangeAve(Map<String, Object> map) {
    SqlSession ss = factory.openSession();
    double studentRangeAve = ss.selectOne(NS + "studentRangeAve", map);
    ss.close();
    return studentRangeAve;
  }
  
  public StudentDto studentDetail(int stuNo) {
    SqlSession ss = factory.openSession();
    StudentDto dto = ss.selectOne(NS + "studentDetail", stuNo);
    ss.close();
    return dto;
  }
  
  public int studentModify(StudentDto dto) {
    SqlSession ss = factory.openSession(false);
    int modifyResult = ss.update(NS + "studentModify", dto);
    if(modifyResult == 1) {
      ss.commit();
    }
    ss.close();
    return modifyResult;
  }
  
  public int studentDelete(int stuNo) {
    SqlSession ss = factory.openSession(false);
    int deleteResult = ss.delete(NS + "studentDelete", stuNo);
    if(deleteResult == 1) {
      ss.commit();
    }
    ss.close();
    return deleteResult;
  }
  
  
  
  
}
