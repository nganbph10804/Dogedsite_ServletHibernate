<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="col mt-4">
<jsp:include page="/common/inform.jsp"></jsp:include>
	<ul class="nav nav-tabs" id="myTab" role="tablist">
		<li class="nav-item" role="presentation"><a
			class="nav-link active" id="UserEditing-tab" data-toggle="tab"
			href="#UserEditing" role="tab" aria-controls="UserEditing"
			aria-selected="true"> User Editing</a></li>
		<li class="nav-item" role="presentation"><a class="nav-link"
			id="UserList-tab" data-toggle="tab" href="#UserList" role="tab"
			aria-controls="UserList" aria-selected="false">User list</a></li>
	</ul>

	<div class="tab-content" id="myTabContent">
		<div class="tab-pane fade show active" id="UserEditing"
			role="tabpanel" aria-labelledby="UserEditing-tab">
			<form action="" method="post"  enctype="multipart/form-data">
				<div class="card">

					<div class="card-body">
						<div class="row">
							<div class="col">
								<div class="form-group">
									<label for="userId">userId</label> <input type="text"
										class="form-control" name="userId" id="userId" value="${user.userId }"
										aria-describedby="userIdHid" placeholder="userId">
									<small id="userIdHid" class="form-text text-muted">*userId
										is Required</small>
								</div>
								<div class="form-group">
									<label for="fullname">Fullname</label> <input type="text" value="${user.fullname }"
										class="form-control" name="fullname" id="fullname"
										aria-describedby="fullnameHid" placeholder="Fullname">
									<small id="fullnameHid" class="form-text text-muted">*Fullname
										is Required</small>
								</div>
							</div>
							<div class="col">
								<div class="form-group">
									<label for="password">Password</label> <input type="password"
										class="form-control" name="password" id="password"
										aria-describedby="passwordHid" placeholder="Password">
									<small id="passwordHid" class="form-text text-muted">*Password
										is Required</small>
								</div>
								<div class="form-group">
									<label for="email">Email</label> <input type="text"
										class="form-control" name="email" id="email" value="${user.email }"
										aria-describedby="emailHid" placeholder="Email"> <small
										id="emailHid" class="form-text text-muted">*Email is
										Required</small>
								</div>
							</div>
						</div>
					</div>
					<div class="card-footer text-muted">
						<button class="btn btn-primary" formaction="UserManagementServlet/create">Create</button>
						<button class="btn btn-warning" formaction="UserManagementServlet/update" >Update</button>
						<button class="btn btn-danger" formaction="UserManagementServlet/delete">Delete</button>
						<button class="btn btn-info" formaction="UserManagementServlet/reset">Reset</button>
					</div>
				</div>
			</form>
		</div>
		<div class="tab-pane fade" id="UserList" role="tabpanel"
			aria-labelledby="UserList-tab">
			<table class="table table-stripe">
				<tr>
					<td>userId</td>
					<td>Fullname</td>
					<td>Email</td>
					<td>Role</td>
					<td>&nbsp;</td>
				</tr>
				<c:forEach var="item" items="${ users}">
				<tr>
					<td>${ item.userId }</td>
					<td>${ item.fullname }</td>
					<td>${ item.email }</td>
					<td>${ item.admin?'Admin':'user' }</td>
					<td><a href="UserManagementServlet/edit?userId=${item.userId }"><i class="fa fa-edit" aria-hidden="true"></i>Edit</a>
						<a href="UserManagementServlet/delete?userId=${item.userId }"><i class="fa fa-trash" aria-hidden="true"></i>Delete</a>
					</td>
				</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</div>