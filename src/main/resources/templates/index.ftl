<html>
<head>
    <title>index</title>
    <link rel="stylesheet" href="/css/materialize.min.css">

    <script type="text/javascript">
        function geta(arg0,arg1) {
            htmlobj=$.ajax({url:"/agentQuery?role="+arg0+"&roleName="+arg1,async:false});
            $("#content").html(htmlobj.responseText);
        }

        function dev() {
            htmlobj=$.ajax({url:"/developAgent",async:false});
            $("#content").html(htmlobj.responseText);
        }

        function book() {
            htmlobj=$.ajax({url:"/authBook",async:false});
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
            <div class="col m6 grey lighten-5" style="height: 90px;width: 90px;"></div>
            <div class="col m6">
            <@shiro.principal/><br>
            <#list roleNames as roleName>${roleName}<br></#list>
            </div>

        </div>
    </li>

    <@shiro.hasPermission name="support:agent">
         <li class="bold"><a class="collapsible-header waves-effect waves-teal" href="javascript:dev();">开发代理</a>
    </@shiro.hasPermission>

    <li class="bold"><a class="collapsible-header waves-effect waves-teal" href="javascript:book();">查看授权书</a>

    <li class="no-padding">
        <ul class="collapsible collapsible-accordion">
            <li class="bold"><a class="collapsible-header waves-effect waves-teal">代理查询</a>
                <div class="collapsible-body">
                    <ul>
                        <#list allRoles as role>
                            <li><a href="javascript:geta('${role.role}','${role.description}')" >${role.description}</a></li>
                        </#list>
                    </ul>
                </div>
            </li>
            <@shiro.hasRole name="admin">
            <li class="bold"><a class="collapsible-header waves-effect waves-teal">系统管理</a>
                <div class="collapsible-body">
                    <ul>
                        <li><a href="badges.html">添加代理</a></li>
                        <li><a href="buttons.html">管理代理</a></li>
                        <li><a href="breadcrumbs.html">权限变更<span class="new badge"></span></a></li>
                    </ul>
                </div>
            </li>
            </@shiro.hasRole>

        </ul>
    </li>




</ul>

<main style="padding-left: 300px;">
    <div id="content">

    </div>

</main>










<script src="/js/jquery-3.2.1.min.js"></script>
<script src="/js/materialize.min.js"></script>

</body>


</html>