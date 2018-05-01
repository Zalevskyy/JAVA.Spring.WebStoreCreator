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
        <title>List of departments</title>
    </head>
    <body>
        <h2>Store ${store.name} Information</h2>
        
      <table>
            <caption><h2>Departments list:</h2></caption>
            
			<tr>
				<th>ID</th> 
				<th>Name department</th>
				<th>Type department</th>
                                <th>Action</th>
                                <th></th>
			</tr>
                        <c:forEach var="item" items="${departments}">
                                <tr>
				<th>${item.id}</th> 
				<th>${item.name}</th>
				<th>${item.type}</th>
                                <th><a href="/WebStoreCreator/deletedepartment?id=${item.id}">Delete department</a></th>
                                <th><a href="/WebStoreCreator/sellers?id=${item.id}">Show seller</a></th>
                                </tr>                                                                                                  
			</c:forEach>                                                              
        </table>
      <div></div>     
      <div>
          <a href="/WebStoreCreator/adddepartment?id=${store.id}">Add department</a>        
      </div>
      <div>
          <a href="/WebStoreCreator/home">Home</a>        
      </div>
    </body>
</html>