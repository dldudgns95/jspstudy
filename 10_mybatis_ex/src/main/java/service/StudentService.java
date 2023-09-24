package service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;

public interface StudentService {
  public ActionForward studentList(HttpServletRequest request) throws IOException;
  public ActionForward studentAdd(HttpServletRequest request) throws IOException;
  public ActionForward studentRangeList(HttpServletRequest request) throws IOException;
  public ActionForward studentDetail(HttpServletRequest request) throws IOException;
  public ActionForward studentModify(HttpServletRequest request) throws IOException;
  public ActionForward studentDelete(HttpServletRequest request) throws IOException;
}
