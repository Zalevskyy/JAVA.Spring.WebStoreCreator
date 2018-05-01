<%-- 
    Document   : addstore
    Created on : 28.04.2018, 15:32:19
    Author     : lv270669zia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Store</title>
    </head>
    <body>
        <h1>Add Store:</h1>
        <form:form method = "POST" action = "/WebStoreCreator/addstore">
         <table>
            <tr>
               <td><form:label path = "name">Name</form:label></td>
               <td><form:input path = "name" /></td>
            </tr>
            <tr>
               <td><form:label path = "type">Type</form:label></td>
               <td><form:input path = "type" /></td>
            </tr>

            <tr>
               <td colspan = "2">
                  <input type = "submit" value = "Add Store"/>
               </td>
            </tr>
         </table>  
      </form:form>
    <div>
          <a href="/WebStoreCreator/adddepartment">Add department</a>
      </div>
      <div>
          <a href="/WebStoreCreator/home">All stores</a>
      </div>
    </body>
</html>
