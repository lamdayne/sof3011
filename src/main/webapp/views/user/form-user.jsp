<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Form User</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI"
	crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">
		<div class="row justify-content-center">
			<div class="col-xl-6 col-sm-12">
				<h3 class="text-info">${message}</h3>
				<c:url var="path" value="/user"/>
				<form method="POST">
					<div class="col-12">
						<label for="" class="form-label">Username</label>
						<input id="" type="text" value="${user.id}" name="id" class="form-control">
					</div>
					<div class="col-12">
						<label for="" class="form-label">Mật khẩu</label>
						<input id="" type="password" value="${user.passWord}" name="passWord" class="form-control">
					</div>
					<div class="col-12">
						<label for="" class="form-label">Họ và tên</label>
						<input id="" type="text" value="${user.fullName}" name="fullName" class="form-control">
					</div>
					<div class="col-12">
						<label for="" class="form-label">Email</label>
						<input id="" type="email" value="${user.email}" name="email" class="form-control">
					</div>
					<div class="col-12 mt-3">
						<label for="" class="form-label">Admin</label> 
						<input type="radio" class="form-check-input ms-3" ${user.admin ? 'checked': '' } value="true" name="admin" id="">Yes 
						<input type="radio" class="form-check-input ms-3" ${!user.admin ? 'checked': '' } value="false" name="admin" id="">No
					</div>
					<hr>
					<button formaction="${path}/create" class="btn btn-success">Create</button>
					<button formaction="${path}/update" class="btn btn-warning">Update</button>
					<button formaction="${path}/delete" class="btn btn-danger">Delete</button>
					<button formaction="${path}/reset" class="btn btn-primary">Reset</button>
				</form>
			</div>
		</div>
		<table class="table table-bordered mt-3">
			<thead>
				<tr>
					<th>Id</th>
					<th>Password</th>
					<th>Fullname</th>
					<th>Email</th>
					<th>Role</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${pageList}">
					<tr>
						<td>${item.id}</td>
						<td>${item.passWord}</td>
						<td>${item.fullName}</td>
						<td>${item.email}</td>
						<td>${item.admin ? 'Admin' : 'Staff'}</td>
						<td>
							<a class="btn btn-warning" href="${path}/edit/${item.id}">Edit</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<ul class="pagination pagination-sm justify-content-center">
    		<c:forEach var="i" begin="1" end="${totalPage}">
        		<li class="page-item ${i == currentPage ? 'active' : ''}">
            		<a class="page-link" href="${path}/index?page=${i}">${i}</a>
        		</li>
    		</c:forEach>
		</ul>
	</div>
</body>
</html>