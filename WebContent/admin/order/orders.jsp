<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


 <div class="col mt-4">
                <ul class="nav nav-tabs" id="myTab" role="tablist">
                    <li class="nav-item" role="presentation">
                        <a class="nav-link active" id="VideoEditing-tab" data-toggle="tab" href="#VideoEditing"
                            role="tab" aria-controls="VideoEditing" aria-selected="true"> Orders</a>
                    </li>
                   
                </ul>

               
                    <div class="tab-pane fade" id="VideoList" role="tabpanel" aria-labelledby="VideoList-tab">
                        <form action="" method="get">
                            <div class="row mt-3">
                                <div class="col">
                                    <div class="form-inline">
                                        <div class="form-group">
                                            <label>Video Title
                                                <select name="videoUserId" id="videoUserId" class="form-control">
                                                <c:forEach var="item" items="${vidList }">
                                                    <option value="${item.videoId }"
                                                     ${item.videoId == videoUserId? 'selected':'' }>${item.title }</option>
                                                    </c:forEach>
                                                </select>
                                            </label>
                                            <button class="btn btn-info ml-2">Report</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col mt-3">
                                    <table class="table table-bordered">
                                        <tr>
                                            <td>Username</td>
                                            <td>Fullname</td>
                                            <td>Email</td>
                                            <td>Order Date</td>
                                        </tr>
                                        <c:forEach var="item" items="${favUsers }">
                                        <tr>
                                            <td>${item.id}</td>
                                            <td>${item.productId }</td>
                                            <td>${item.userId }</td>
                                            <td>${item.Date }</td>
                                            <td>${item.totalPrice }</td>
                                        </tr>
                                        </c:forEach>
                                    </table>
                                </div>
                            </div>
                        </form>
                    </div>
                    
                </div>
                
            </div>