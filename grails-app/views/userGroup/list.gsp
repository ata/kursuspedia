<%@ page import="com.kursuspedia.domain.UserGroup" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>UserGroup List</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${resource(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="create" action="create">New UserGroup</g:link></span>
        </div>
        <div class="body">
            <h1>UserGroup List</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                   	        <g:sortableColumn property="id" title="Id" />
                        
                   	        <g:sortableColumn property="name" title="Name" />
                        
                   	        <g:sortableColumn property="users" title="Users" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${userGroupInstanceList}" status="i" var="userGroupInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${userGroupInstance.id}">${fieldValue(bean:userGroupInstance, field:'id')}</g:link></td>
                        
                            <td>${fieldValue(bean:userGroupInstance, field:'name')}</td>
                        
                            <td>${fieldValue(bean:userGroupInstance, field:'users')}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${userGroupInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
