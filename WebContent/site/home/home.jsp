<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="row m-4 p-4 ">
<div class="col">
		<c:forEach var="item" items="${products }">
          <div class="col-lg-4 col-md-6 mb-4 ">
            <div class="card  h-50 w-50">
             <img class="card-img-top img-fluid " src="images/${item.img }" alt="">
              <div class="card-body">
                <h4 class="card-title">
                  <b>${item.name }</b>
                </h4>
                <h5>${item.price }</h5>
              </div>
              <div class="p-2">
              <a href="OrderProduct"><i class="fas fa-shopping-cart fa-3x"></i></a>
              </div>
              <div class="card-footer">
                <small class="text-muted">&#9733; &#9733; &#9733; &#9733; &#9734;</small>
              </div>
            </div>
          </div>
		</c:forEach>
         </div>

        </div>