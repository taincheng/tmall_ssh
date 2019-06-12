<%--
  Created by IntelliJ IDEA.
  User: Old_man
  Date: 2019/6/12
  Time: 16:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<script>
    $(function(){
        $("div.productsAsideCategorys div.row a").each(function(){
            var v = Math.round(Math.random() *6);
            if(v == 1)
                $(this).css("color","#87CEFA");
        });
    });

</script>
<c:forEach items="${categorys}" var="c">
    <div cid="${c.id}" class="productsAsideCategorys">
        <c:forEach items="${c.productsByRow}" var="ps">
            <div class="row ">
                <c:forEach items="${ps}" var="p">
                    <c:if test="${!empty p.subTitle}">
                        <a href="foreproduct?product.id=${p.id}">
                            <c:forEach items="${fn:split(p.subTitle, ' ')}" var="title" varStatus="st">
                                <c:if test="${st.index==0}">
                                    ${title}
                                </c:if>
                            </c:forEach>
                        </a>
                    </c:if>
                </c:forEach>
                <div class="seperator"></div>
            </div>
        </c:forEach>
    </div>
</c:forEach>


