<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title>List Customers</title>
	<!--  reference our style sheet -->
	
	<link type="text/css"
	      rel="stylesheet"
	      href="${pageContext.request.contextPath}/resources/css/style.css" />
	      
</head>

<body>
  <div id="wrapper">
      <div id="header">
          <h2> CRM - Customer Relationship Manager</h2>
      </div>
  </div>
  
  <div id="container">
     <div id="content">
     
     <!--  put new button: Add Customer -->
     <input type="button" value="Add Customer"
            onClick="window.location.href='showFormForAdd'; return false;"
            class="add-button"
     />
     
        <!--  add html table here -->
        
        <table>
           <tr>
              <th>First Name</th>
              <th>Last Name</th>
              <th>Primary Email</th>
              <th>Action</th>
           </tr>
       <!--  loop over and print our customers -->
       
       
       <c:forEach var="tempCustomer" items="${customers}">
       
       <!--  create an update link with customer id -->
       <c:url var="updateLink" value="/customer/showFormForUpdate">
       		<c:param name="customerId" value="${tempCustomer.id}" />
       </c:url>
       
         <!--  create a delete link with customer id -->
       <c:url var="deleteLink" value="/customer/delete">
       		<c:param name="customerId" value="${tempCustomer.id}" />
       </c:url>
       
       
         
       		<tr>
       			<td>${tempCustomer.firstName}</td>
       			<td>${tempCustomer.lastName}</td>
       			<td>${tempCustomer.primaryEmail}</td>
       			<td>
       			<!--  display the update link -->
       			<a href="${updateLink }">Update</a>
       			<!-- javascript to prompt user -->
       			<a href="${deleteLink }"
       			onClick="if(!(confirm('Are You Sure You Want To Delete This Customer?')))return false">Delete</a>
       			</td>
       		</tr>
       
       </c:forEach>    
        
        </table>
     </div>
  </div>
  
</body>

</html>