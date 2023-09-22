package service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import domain.MemberDto;
import repository.MemberDao;

public class MemberSerivceImpl implements MemberService {
  
  private MemberDao dao = MemberDao.getDao();
  
  @Override
  public void getMemberList(HttpServletResponse response) throws IOException {
    List<MemberDto> memberList = dao.memberList();
    int memberCount = dao.memberCount();
    
    JSONObject obj = new JSONObject();    // { }
    obj.put("memberList", memberList);    // {"memberList": [{}, {}, {}, ...]}
    obj.put("memberCount", memberCount);  // {"memberList": [{}, {}, {}, ...], "memberCount": 5}
    
    PrintWriter out = response.getWriter();
    out.println(obj.toString());  // $.ajax({sucess: function(resData){}})
    out.flush();
    out.close();
  }
  
  @Override
  public void memberAdd(HttpServletRequest request, HttpServletResponse response) throws IOException {
    
    MemberDto dto = MemberDto.builder()
                      .email(request.getParameter("email"))
                      .name(request.getParameter("name"))
                      .gender(request.getParameter("gender"))
                      .address(request.getParameter("address"))
                      .build();
    int addResult = dao.memberAdd(dto);
    
    JSONObject obj = new JSONObject();  // { }
    obj.put("addResult", addResult);    // {"addResult":1}
    
    PrintWriter out = response.getWriter();
    out.print(obj.toString());
    out.flush();
    out.close();
  }
  
  @Override
  public void memberEmailCheck(HttpServletRequest request, HttpServletResponse response) throws IOException {
    
    String email = request.getParameter("email");
    
    MemberDto dto = dao.getMemberByEmail(email);
    
    JSONObject obj = new JSONObject();  // { }
    obj.put("ableEmail", dto == null);  // {"ableEmail":true}
    
    PrintWriter out = response.getWriter();
    out.println(obj.toString());
    out.flush();
    out.close();
    
  }

}
