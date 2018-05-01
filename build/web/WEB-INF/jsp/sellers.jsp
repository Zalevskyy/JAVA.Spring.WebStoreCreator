<%-- 
    Document   : allstores
    Created on : 27.04.2018, 18:20:25
    Author     : lv270669zia
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List of sellers</title>
    </head>
    <body>
        <h2>Store Information</h2>
        
      <table>
            <caption><h2>Sellers of ${department.name} department:</h2></caption>
            
			<tr>
				<th>ID</th> 
				<th>Name seller</th>
				<th>Surname seller</th>
                                <th>Birthday</th>
                                <th>Salary</th>
                                <th>Action</th>
			</tr>
                        <c:forEach var="item" items="${sellers}">
                                <tr>
				<th>${item.id}</th> 
				<th>${item.name}</th>
				<th>${item.surname}</th>
                                <th>${item.birthday}</th>
                                <th>${item.salary}</th>
                                <th><a href="/WebStoreCreator/deleteseller?id=${item.id}">Delete seller</a></th>
                                
                                </tr>                                                                                                  
			</c:forEach>                                                              
        </table>
      <div></div>     
      <div>
          <a href="/WebStoreCreator/addseller?id=${department.id}">Add seller</a>        
      </div>
      <div>
          <a href="/WebStoreCreator/home">Home</a>        
      </div>
    </body>
</html>