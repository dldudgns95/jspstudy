package service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface MemberService {
  // 직접 응답하기 때문에 반환값이 없다. 
  public void getMemberList(HttpServletResponse response) throws IOException;
  public void memberAdd(HttpServletRequest request, HttpServletResponse response) throws IOException;
  public void memberEmailCheck(HttpServletRequest request, HttpServletResponse response) throws IOException;
}
