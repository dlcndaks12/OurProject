<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<script type="text/javascript">

</script>
</head>
<body>
    <a href="/sendMail.do">메일 발송</a>
    
    <form action="/fileUpload.do" method="post">
    	<input type="file" name="file" id="file" />
    	<button type="submit">파일업로드</button>
    </form>
    
</body>
</html>