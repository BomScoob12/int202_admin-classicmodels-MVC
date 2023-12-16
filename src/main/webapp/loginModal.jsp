<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="bg-overlay"></div>

<div class="modal-container">
    <div class="modal-content">
        <form action="login" method="post" class="form-container">
            <div class="form-header">Login account</div>

            <div class="error-msg-container" id="error-msg" name="error-msg">
                <c:choose>
                    <c:when test="${requestScope.loginError == null}">
                        No error
                    </c:when>
                    <c:otherwise>
                        ${requestScope.loginError}
                    </c:otherwise>
                </c:choose>
            </div>

            <div>
                <input type="text" name="username" id="username" autocomplete="username" class="form-input" placeholder="Enter your username">
                <input type="password" name="password" id="password" class="form-input" placeholder="Enter your password">
            </div>

            <div class="flex mt-3">
                <button type="submit" class="form-button primary-button">Login</button>
            </div>
        </form>
    </div>
</div>
