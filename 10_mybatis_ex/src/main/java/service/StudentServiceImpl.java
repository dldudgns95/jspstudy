package service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import common.ActionForward;
import domain.StudentDto;
import repository.StudentDao;

public class StudentServiceImpl implements StudentService {
  
  StudentDao dao = StudentDao.getDao();
  
  @Override
  public ActionForward studentList(HttpServletRequest request) throws IOException {
    
    List<StudentDto> list = dao.studentList();
    int studentCount = dao.studentCount();
    
    request.setAttribute("studentList", list);
    request.setAttribute("studentCount", studentCount);
    
    return new ActionForward("/student/list.jsp", false);
  }
  
}
