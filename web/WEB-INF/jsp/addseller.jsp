<%-- 
    Document   : addseller
    Created on : 30.04.2018, 12:43:14
    Author     : lv270669zia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ADD SELLER</title>
        <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.2/themes/smoothness/jquery-ui.css" />
  <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
  <script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>
  <link rel="stylesheet" href="/resources/demos/style.css" />
        <style>
    .datepicker{    
    }
  </style>
  <script>
  $(function() {
    $( ".datepicker" ).datepicker();
  });
  </script>

    </head>
    <body>
        <h1>Add Seller:</h1>
        <form:form method = "POST" action = "/WebStoreCreator/addseller">
         <table>
            <tr>
               <td><form:label path = "name">Name</form:label></td>
               <td><form:input path = "name" /></td>
            </tr>
            <tr>
               <td><form:label path = "surname">Surname</form:label></td>
               <td><form:input path = "surname" /></td>
            </tr>
            <tr>
               <td><form:label path = "salary">Salary</form:label></td>
               <td><form:input path = "salary" /></td>
            </tr>
            <tr>
               <td><form:label path = "birthday">Birthday</form:label></td>
               <td><form:input type="text" path = "birthday" class="datepicker"/></td>
            </tr>
            <tr>
               <td><form:label path = "department_id">Department id</form:label></td>
               <td><form:input path = "department_id" value="${departmentId}"/></td>
            </tr>
            <tr>
               <td colspan = "2">
                  <input type = "submit" value = "Add saller"/>
               </td>
            </tr>
         </table>  
      </form:form>
      <div>
          <a href="/WebStoreCreator/home">Home</a>
      </div>
    </body>
</html>