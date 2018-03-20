<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Editer les sous-titres</title>
</head>
<body>
    <form method="post" > 
           <input type="submit" style="position:fixed; top: 10px; right: 10px;" />
	    <table>
	        <c:forEach items="${ subtitles }" var="line" varStatus="status">
	       
	        	<tr>
	        	
	        		<td style="text-align:right;"><c:out value="${ line }" /></td>
	        		<!-- >td><input type="text" name="line${ status.index }" id="line${ status.index }" size="35" /><c:out value="${ status.index  }" /></td-->
	        		
	        		<td><input type="text" name="champCache" type="hidden"   size="35" /><c:out value="${ status.index  }" /></td>
	        	
	        	</tr>
	        	
	    	</c:forEach>
	    </table>
	   
    </form>
    
    <p><c:out value="${ message }" /> </p>
    
    <c:forEach var="traducteur" items="${ traducteur }" >
	     <ul>
	     <li><c:out value="${ traducteur.champ }" /></li>
	     </ul>
	     
	     
	 </c:forEach>
	    
</body>
</html>