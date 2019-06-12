<%--
  Created by IntelliJ IDEA.
  User: Old_man
  Date: 2019/6/12
  Time: 16:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="categoryMenu">
    <c:forEach items="${categorys}" var="c">
        <div cid="${c.id}" class="eachCategory">
            <span class="glyphicon glyphicon-link"></span>
            <a href="forecategory?category.id=${c.id}">
                    ${c.name}
            </a>
        </div>
    </c:forEach>
</div>
