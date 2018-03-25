<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Backup</title>
</head>
<body>
 <%@ include file="menu.jsp" %>
<form method="post" > 
           <input type="submit" style="position:fixed; top: 10px; right: 10px;" />
	    <table>
	        <c:forEach items="${ traductions }" var="line" varStatus="status">
	       
	        	<tr>
	        	
	        		<td style="text-align:right;"--><c:out value="${ line.champ }" /></td>
	        		       		
	        		<td><input type="text" name="champCache" type="hidden" value="${ line.champ }"  size="35" /></td>
	        	
	        	</tr>
	        	<tr>
	        	
	        		<td style="text-align:right;"--><c:out value="${ line.time }" /></td>
	        		       		
	        		<td><input type="text" name="champCache" type="hidden" value="${ line.time }"   size="35" /></td>
	        	
	        	</tr>
	        	<tr>
	        	
	        		<td style="text-align:right;"--><c:out value="${ line.texteori1 }" /></td>
	        		       		
	        		<td><input type="text" name="champCache" type="hidden" value="${ line.textetrad1 }" size="35" /></td>
	        	
	        	</tr>
	        	<tr>
	        	
	        		<td style="text-align:right;"--><c:out value="${ line.texteori2 }" /></td>
	        		       		
	        		<td><input type="text" name="champCache" type="hidden" value="${ line.textetrad2 }"  size="35" /></td>
	        	
	        	</tr>
	        	
	        	
	    	</c:forEach>
	    </table>
	   
    </form>
    

</body>
</html>