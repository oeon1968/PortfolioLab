<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%--@elvariable id="Donation" type="java"--%>
<form:form modelAttribute="Donation" method="post">
    category: <form:checkboxes path="categories"
                     items="${categories}" itemLabel="name" itemValue="id"/><br>
    institution: <form:select path="institution" items="${institutions}" itemValue="id" itemLabel="name"/><br>
    zipCode: <form:input path="zipCode" /><br>
    street: <form:input path="street" /><br>
    city: <form:input path="city"/><br>
    quantity: <form:input path="quantity"/><br>
    Comment: <form:textarea path="pickUpComment"/><br>
    pickUp Date: <form:input type="date" path="pickUpDate"/><br>
    pickUp Time: <form:input type="time" path="pickUpTime" /><br>
    <button type="submit"> Save</button>
</form:form>
