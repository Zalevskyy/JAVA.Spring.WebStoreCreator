<%-- 
    Document   : adddepartment
    Created on : 28.04.2018, 12:11:19
    Author     : lv270669zia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ADD DEPARTMENT</title>
    </head>
    <body>
        <h1>Add Department:</h1>
        <form:form method = "POST" action = "/WebStoreCreator/adddepartment">
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
               <td><form:label path = "store_id">Store id</form:label></td>
               <td><form:input path = "store_id" value="${storeId}"/></td>
            </tr>
            <tr>
               <td colspan = "2">
                  <input type = "submit" value = "Add department"/>
               </td>
            </tr>
         </table>  
      </form:form>
    <div>
          <a href="/WebStoreCreator/addseller">Add seller</a>
      </div>
      <div>
          <a href="/WebStoreCreator/home">Home</a>
      </div>
    </body>
</html>
