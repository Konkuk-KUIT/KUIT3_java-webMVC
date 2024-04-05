<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html lang="ko">
  <%@ include file="../include/header.jspf" %>
  <body>
    <%@ include file="../include/navigation.jspf" %>

    <div class="container" id="main">
      <div class="col-md-12 col-sm-12 col-lg-10 col-lg-offset-1">
         <div class="panel panel-default content-main">
             <form name="question" method="post" action="">
                 <div class="form-group">
                     <label for="writer">글쓴이</label>
                     <input class="form-control" id="writer" name="writer" placeholder="글쓴이"/>
                 </div>
                 <div class="form-group">
                     <label for="title">제목</label>
                     <input type="text" class="form-control" id="title" name="title" placeholder="제목"/>
                 </div>
                 <div class="form-group">
                     <label for="contents">내용</label>
                     <textarea name="contents" id="contents" rows="5" class="form-control"></textarea>
                 </div>
                 <button type="submit" class="btn btn-primary clearfix pull-right" style="margin-top:10px;">질문하기</button>
                 <div class="clearfix" />
             </form>
           </div>
       </div>
   </div>
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
    <script src="../js/scripts.js"></script>
  </body>
</html>