<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
    
    <div class="offset-3 col-6 mt-4">
                  <form action="ChangePassword" method="post">
                      <div class="card">
                          <div class="card-header">
                             Change Password
                          </div>
                          <div class="card-body">
                          <jsp:include page="/common/inform.jsp"></jsp:include>
                              <div class="row">
                                  <div class="col">
                                      <div class="form-group">
                                        <label for="userId">userId</label>
                                        <input type="text" value="${userId }" class="form-control" name="userId" id="userId" aria-describedby="userIdHid" placeholder="userId">
                                        <small id="userIdHid" class="form-text text-muted">*userId is Required</small>
                                      </div>
                                      <div class="form-group">
                                        <label for="password">Password</label>
                                        <input type="password" class="form-control" name="password" id="password" placeholder="Password">
                                      </div>

                                  </div>
                                  <div class="col">
                                      <div class="form-group">
                                        <label for="currentPassword">Current Password</label>
                                        <input type="password" class="form-control" name="currentPassword" id="currentPassword" placeholder="CurrentPassword">
                                      </div>
                                      <div class="form-group">
                                        <label for="conformPassword">Confirm Password</label>
                                        <input type="password" class="form-control" name="confirmPassword" id="conformPassword" placeholder="ConfirmPassword">
                                      </div>
                                  </div>
                              </div>
                          </div>
                          <div class="card-footer text-muted">
                             <button class="btn btn-success">Change Password</button>
                          </div>
                      </div>
                  </form>
              </div>