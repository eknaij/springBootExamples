<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>

<div style="margin:0px auto; width:500px">

    <form action="updateCategory" method="post">

        name: <input name="name" value="${c.name}"> <br>

        <input name="id" type="hidden" value="${c.id}">
        <button type="submit">提交</button>

    </form>
</div>