package service;

import javax.servlet.http.HttpServletRequest;

import common.ActionForward;

public interface BookService {
  public ActionForward getBookList(HttpServletRequest request);
  public ActionForward bookAdd(HttpServletRequest request);
  public ActionForward bookDetail(HttpServletRequest request);
  public ActionForward edit(HttpServletRequest request);
  public ActionForward modify(HttpServletRequest request);
  public ActionForward bookDelete(HttpServletRequest request);
  public ActionForward bookCheckDelete(HttpServletRequest request);
}
