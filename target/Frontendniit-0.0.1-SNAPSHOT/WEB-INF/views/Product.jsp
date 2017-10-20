 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Page</title>
 <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="resources/css/Pretty-Footer.css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
	<jsp:include page="header.jsp" /> 

	<div class="container">
	      <form:form commandName="product" method="post" action="addProduct">
				<p><font color="red">${errorMessage}</font></p>				
				<h5>
				<strong>
			     <c:choose>
			     	<c:when test="${product.product_id==0}">  Add New Item </c:when>
			     	<c:when test="${!empty product.product_id}">Update Product for Id: <c:out value="${product.product_id}"/></c:when>
			     </c:choose>
			     </strong>
			     </h5>
			    		     
				<div class="form-group row">
				 <div class="col-xs-4">
				   <c:if test="${product.product_id!= 0}">
				   <form:input type="hidden" class="form-control" path="product_id"  placeholder="Product Id" name = "id"/>
				   </c:if>					
				</div>
				</div>
				<br/>
				<div class="form-group row">
					<label for="product_Name" class="col-xs-4 control-label">Product Name</label>
					<div class="col-xs-4">
						<form:input name="productName" path="product_Name" placeholder="Product Name" class="form-control" />
					</div>
				</div>
				<div class="form-group row">
					<label for="product_Description" class="col-xs-4 control-label">Product description</label>
					<div class="col-xs-4">
						<form:input name="productDescription"  path="product_Description" placeholder="Product Description" class="form-control" />
						 
					</div>
				</div>
				<br/>
				<div class="form-group row">
					<label for="code" class="col-xs-4 control-label"></label>
						
						<div class="col-xs-4">
						
							
						<c:if test="${product.product_id==0}">
						<input type="submit" value="Add Product" id="btn-add" class="btn btn-primary" >
						
						</c:if> <c:if test="${product.product_id!=0}">
						
					   <input type="submit" value="Update Product" id="btn-update" class="btn btn-primary" >
					  </c:if>
						
						
						</div>
					</div>
						
		</form:form><br/>
		,
		<table class="table table-striped table-bordered" style="width:80%">
			<thead>
			<tr>
				<th>S. No.</th>
				<th>Product Id</th>
				<th>Product Name</th>
				<th>Product Description</th>
				<th>Product Action</th>
			</tr>	
			</thead>
			<tbody>
			   <c:forEach items="${ProductList}" var="product" varStatus="loopCounter">
			   		<tr>
			   			<td><c:out value="${loopCounter.count}"></c:out></td>
			   			<td><c:out value="${product.product_id}"></c:out></td>
			   			<td><c:out value="${product.product_Name}"></c:out></td>
			   			<td><c:out value="${product.product_Description}"></c:out></td>
			   			<td><nobr>
<a class="btn btn-primary" href="editcategory/${product.product_id}"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span> Edit</a>

<a class="btn btn-primary"  href="removecategory/${product.product_id}"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span> Delete
								</a>

							</nobr></td>
			   		</tr>
			   </c:forEach>
			</tbody>
		</table>
	</div>
	</body>
	<jsp:include page="footer.jsp" /> 

</html>
