package service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import common.ActionForward;
import domain.StudentDto;
import repository.StudentDao;

public class StudentServiceImpl implements StudentService {
  
  StudentDao dao = StudentDao.getDao();
  
  @Override
  public ActionForward studentList(HttpServletRequest request) throws IOException {
    
    List<StudentDto> list = dao.studentList();
    List<StudentDto> topList = dao.studentTopList();
    int studentCount = dao.studentCount();
    
    
    request.setAttribute("studentList", list);
    request.setAttribute("studentTopList", topList);
    request.setAttribute("studentCount", studentCount);
    
    return new ActionForward("/student/list.jsp", false);
  }
  
  @Override
  public ActionForward studentAdd(HttpServletRequest request) throws IOException {
    
    String name= request.getParameter("name");
    int kor = Integer.parseInt(request.getParameter("kor"));
    int eng = Integer.parseInt(request.getParameter("eng"));
    int math = Integer.parseInt(request.getParameter("math"));
    double ave = Math.round((((double)(kor + eng + math)) / 3) * 100.0) / 100.0;
    String grade = null;
    if(ave >= 90) {
      grade = "A";
    } else if(ave >= 80) {
      grade = "B";
    } else if(ave >= 70) {
      grade = "C";
    } else if(ave >= 60) {
      grade = "D";
    } else {
      grade = "F";
    }
    
    StudentDto dto = StudentDto.builder()
                        .name(name)
                        .kor(kor)
                        .eng(eng)
                        .math(math)
                        .ave(ave)
                        .grade(grade)
                        .build();
    int addResult = dao.studentAdd(dto);
    String path = null;
    if(addResult == 1) {
      path = request.getContextPath() + "/student/list.do";
    } else if(addResult == 0) {
      path = request.getContextPath() + "/index.jsp";
    }
    
    return new ActionForward(path, true);
  }
  
  @Override
  public ActionForward studentRangeList(HttpServletRequest request) throws IOException {
    String begin = request.getParameter("begin");
    String end = request.getParameter("end");
    Map<String, Object> map = new HashMap<String, Object>();
    map.put("begin", begin);
    map.put("end", end);
    
    List<StudentDto> studentRangeList = dao.studentRangeList(map);
    int rangeCount = dao.studentRangeCount(map);
    
    request.setAttribute("studentRangeList", studentRangeList);
    request.setAttribute("rangeCount", rangeCount);
        
    return new ActionForward("/student/list.jsp", false);
  }
  
  @Override
  public ActionForward studentDetail(HttpServletRequest request) throws IOException {
    int stuNo = Integer.parseInt(request.getParameter("stuNo"));
    System.out.println(stuNo);
    StudentDto student = dao.studentDetail(stuNo);
    
    request.setAttribute("student", student);
    
    return new ActionForward("/student/modify.jsp", false);
  }
  
  @Override
  public ActionForward studentModify(HttpServletRequest request) throws IOException {
    int stuNo = Integer.parseInt(request.getParameter("stuNo"));
    String name= request.getParameter("name");
    int kor = Integer.parseInt(request.getParameter("kor"));
    int eng = Integer.parseInt(request.getParameter("eng"));
    int math = Integer.parseInt(request.getParameter("math"));
    double ave = Math.round((((double)(kor + eng + math)) / 3) * 100.0) / 100.0;
    String grade = null;
    if(ave >= 90) {
      grade = "A";
    } else if(ave >= 80) {
      grade = "B";
    } else if(ave >= 70) {
      grade = "C";
    } else if(ave >= 60) {
      grade = "D";
    } else {
      grade = "F";
    }
    
    StudentDto dto = StudentDto.builder()
        .stuNo(stuNo)
        .name(name)
        .kor(kor)
        .eng(eng)
        .math(math)
        .ave(ave)
        .grade(grade)
        .build();
    
    int modifyResult = dao.studentModify(dto);
    String path = null;
    if(modifyResult == 1) {
      
      path = request.getContextPath() + "/student/detail.do?stuNo=" + stuNo;
    } else if (modifyResult == 0) {
      path = request.getContextPath() + "/index.jsp";
    }
    
    return new ActionForward(path, true);
  }
  
  @Override
  public ActionForward studentDelete(HttpServletRequest request) throws IOException {
    int stuNo = Integer.parseInt(request.getParameter("stuNo"));
    
    int deleteResult = dao.studentDelete(stuNo);
    String path = null;
    if(deleteResult == 1) {
      path = request.getContextPath() + "/student/list.do";
    } else if(deleteResult == 0) {
      path = request.getContextPath() + "/index.jsp";
    }
    return new ActionForward(path, true);
  }
  
}
