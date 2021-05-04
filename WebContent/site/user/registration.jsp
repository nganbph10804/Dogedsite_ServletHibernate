<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="col-8 offset-2">
	<form action="" method="post">
	${Routes.SITE_REGISTRTION_SHOW }
		<div class="card">
			<div class="card-header">
				<b>Registration</b>
			</div>
			<div class="card-body">
			<jsp:include page="/common/inform.jsp"></jsp:include>
				<div class="row">
					<div class="col">
						<div class="form-group">
							<label for="username">usename</label> <input type="text"
								class="form-control" value="${user.username }" name="username"
								id="username" aria-describedby="usernameHid"
								placeholder="username"> <small id="usernameHid"
								class="form-text text-muted">*Username is Required</small>
						</div>
						<div class="form-group">
							<label for="fullname">Fullname</label> <input type="text"
								class="form-control" value="${user.fullname}" name="fullname"
								id="fullname" aria-describedby="fullnameHid"
								placeholder="fullname"> <small id="fullnameHid"
								class="form-text text-muted">*Fullname is Required</small>
						</div>

					</div>
					<div class="col">
						<div class="form-group">
							<label for="password">Password</label> <input type="password"
								class="form-control" name="password" id="password"
								placeholder="password">
						</div>
						<div class="form-group">
							<label for="email">Email</label> <input type="text"
								class="form-control" value="${user.email }" name="email"
								id="email" aria-describedby="emailHid" placeholder="email">
							<small id="emailHid" class="form-text text-muted">*Email
								is Required</small>
						</div>

					</div>
				</div>
			</div>
			<div class="card-footer text-muted">
				<button class="btn btn-success">Sign Up</button>
			</div>
		</div>
	</form>
</div>