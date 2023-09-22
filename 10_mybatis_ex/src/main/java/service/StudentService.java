package service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import common.ActionForward;

public interface StudentService {
  public ActionForward studentList(HttpServletRequest request) throws IOException;
}
