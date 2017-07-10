<html>
<head>
    <title>index</title>
    <link rel="stylesheet" href="/css/materialize.min.css">

    <script type="text/javascript">
        function get(arg0) {
            htmlobj=$.ajax({url:"/"+arg0,async:false});
            $("#content").html(htmlobj.responseText);
        }
    </script>

</head>
<body>

<#include "header.ftl">

<ul id="nav-mobile" class="side-nav fixed" >

    <li class="logo red lighten-2"><a class="brand-logo" id="logo-container" style="height: 64px;" href="/" >XY</a></li>

<#--profile-->
    <li class="grey lighten-3">
        <div class="row" style="padding: 8px;">
            <div class="col m6" style="height: 90px;width: 110px;">
                <img style="width: 90px;" src="/images/${roleName}.png"/>
            </div>

            <div class="col m6">
                <strong><@shiro.principal/></strong><br>
                ${roleName}
            </div>

        </div>
    </li>

    <@shiro.hasPermission name="support:agent">
         <li class="bold"><a class="collapsible-header waves-effect waves-teal" href="javascript:get('developAgent');">开发代理</a>
    </@shiro.hasPermission>

    <li class="bold"><a class="collapsible-header waves-effect waves-teal" href="javascript:get('authBook');">查看授权书</a>

    <li class="no-padding">
        <ul class="collapsible collapsible-accordion">
            <li class="bold"><a class="collapsible-header waves-effect waves-teal">代理查询</a>
                <div class="collapsible-body">
                    <ul>
                        <#list allRoles as role>
                            <li><a href="javascript:get('agentQuery?role=${role.role}&roleName=${role.description}')" >${role.description}</a></li>
                        </#list>
                    </ul>
                </div>
            </li>
            <@shiro.hasRole name="admin">
            <li class="bold"><a class="collapsible-header waves-effect waves-teal">系统管理</a>
                <div class="collapsible-body">
                    <ul>
                        <li><a href="javascript:get('admin/createUser');">添加用户</a></li>
                        <li><a href="javascript:void(0);">管理用户</a></li>
                        <li><a href="javascript:get('admin/createRole');">添加角色</a></li>
                        <li><a href="javascript:get('admin/manageRoles');">管理角色</a></li>
                        <li><a href="javascript:get('admin/updatePermission');">权限变更<span class="new badge"></span></a></li>
                    </ul>
                </div>
            </li>
            </@shiro.hasRole>

        </ul>
    </li>




</ul>

<main style="padding-left: 300px;">
    <div id="content">
        <h5 style="padding-left: 50px;">欢迎</h5>
    </div>

</main>










<script src="/js/jquery-3.2.1.min.js"></script>
<script src="/js/materialize.min.js"></script>

</body>


</html>