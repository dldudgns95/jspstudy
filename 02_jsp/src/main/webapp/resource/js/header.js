/**
 * 본문을 모두 읽은 뒤, JavaScript를 수행할 수 있도록 load 이벤트 처리한다.
 * 방법1. window.onload = function(){}
 * 방법2. $(document).ready(function(){})
 * 방법3. $(function(){})
 */

$(function(){
  $('.gnb a').mouseover(function() {
    $(this).css('background-color', 'silver');
  })
  $('.gnb a').mouseout(function() {
    $(this).css('background-color', '');
  })  
  var img = new Image();
  $(img).attr('src', '/jsp/resource/image/naver.png').css('width', '150px');
  var link = $('<a>').attr('href','/jsp/ex03_layout/header.jsp').css('width', '150px').css('height', '30px');
  link.html(img);
  $('.logo').html(link);
  
})
