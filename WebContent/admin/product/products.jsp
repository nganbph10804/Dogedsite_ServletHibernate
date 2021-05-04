<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="col mt-4">
<jsp:include page="/common/inform.jsp"></jsp:include>
	<ul class="nav nav-tabs" id="myTab" role="tablist">
		<li class="nav-item" role="presentation"><a
			class="nav-link active" id="productEditing-tab" data-toggle="tab"
			href="#productEditing" role="tab" aria-controls="productEditing"
			aria-selected="true"> Product Editing</a></li>
		<li class="nav-item" role="presentation"><a class="nav-link"
			id="productList-tab" data-toggle="tab" href="#productList" role="tab"
			aria-controls="productList" aria-selected="false">Product list</a></li>
	</ul>

	<div class="tab-content" id="myTabContent">
		<div class="tab-pane fade show active" id="productEditing"
			role="tabpanel" aria-labelledby="productEditing-tab">
			<form action="" method="post" enctype="multipart/form-data">
				<div class="card">
					<div class="card-body">
						<div class="row">
							<div class="col-3">
								<div class="border p-3">
									<img src="${ product.img!=null? product.img:'images/dq.jpg' }" alt=""
										class="img-fluid">
									
								</div>
							</div>
							<div class="col-9">
								<div class="form-group">
									<label for="ProductId">ProductID</label> <input type="text"
										class="form-control" value="${product.productId }" name="productId" id="productId"
										aria-describedby="ProductHid" placeholder="ProductID">
									<small id="ProductHid" class="form-text text-muted">*ProductId
										is Required!</small>
								</div>
								<div class="form-group">
									<label for="productTitle">Product Name</label> <input type="text"
										class="form-control" name="name" value="${product.name }" id="productTitle"
										aria-describedby="productTitleHid" placeholder="Productname">
									<small id="productTitleHid" class="form-text text-muted">*Product
										name is Required!</small>
								</div>
								<div class="form-group">
									<label for="price">Product Price</label> <input type="text"
										class="form-control" name="price" value="${product.price }" id="price"
										aria-describedby="priceId" placeholder="Product price">
									<small id="priceHid" class="form-text text-muted">Product
										Price is Required</small>
								</div>
								
							</div>
						</div>
					
					<div class="card-footer text-muted">
						<button class="btn btn-primary" formaction="Admin/ProductManagement/create">Create</button>
						<button class="btn btn-warning" formaction="Admin/ProductManagement/update">Update</button>
						<button class="btn btn-danger" formaction="Admin/ProductManagement/delete">Delete</button>
						<button class="btn btn-info" formaction="Admin/ProductManagement/reset">Reset</button>
					</div>
				</div>
			</form>
		</div>
		<div class="tab-pane fade" id="productList" role="tabpanel"
			aria-labelledby="productList-tab">
			<table class="table table-stripe">
				<tr>
					<td>Product ID</td>
					<td>product Name</td>
					<td>Price</td>
					<td>&nbsp;</td>
				</tr>
				<c:forEach var="item" items="${ products}">
				<tr>
					<td>${ item.productId }</td>
					<td>${ item.name }</td>
					<td>${ item.price }</td>
					<td><a href="Admin/ProductManagement/edit?productId=${item.productId }"><i class="fa fa-edit" aria-hidden="true"></i>Edit</a>
						<a href="Admin/ProductManagement/delete?productId=${item.productId }"><i class="fa fa-trash" aria-hidden="true"></i>Delete</a>
					</td>
				</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</div>