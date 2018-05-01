<%-- 
    Document   : allstores
    Created on : 27.04.2018, 17:20:25
    Author     : lv270669zia
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List of stores</title>
    </head>
    <body>
        <h2>Store Information</h2>
      <table>
            <caption><h2>Store list:</h2></caption>
			<tr>
				<th>ID</th> 
				<th>Name Store</th>
				<th>Type Store</th>
                                <th>Action</th>
                                <th></th>
			</tr>
                        <c:forEach var="item" items="${list}">
                                <tr>
				<th>${item.id}</th> 
				<th>${item.name}</th>
				<th>${item.type}</th>
                                <th><a href="/WebStoreCreator/deletestore?id=${item.id}">Delete store</a></th>
                                <th><a href="/WebStoreCreator/departments?id=${item.id}">Show departments</a></th>
                                </tr>
                        </c:forEach>
        </table>
      <div></div>     
      <div>
          <a href="/WebStoreCreator/addstore">Add store</a>
      </div>
    </body>
</html>
