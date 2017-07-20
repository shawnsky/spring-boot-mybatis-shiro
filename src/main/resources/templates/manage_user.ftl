<script type="text/javascript">
    $(document).ready(function() {
        $('select').material_select();
    });

    function getPage(arg0) {
        htmlobj=$.ajax({url:"/"+arg0,async:false});
        $("#innerContent").html(htmlobj.responseText);
    }

    var totalPageNum = ${totalPageNum};
    var currentPage = ${currentPage};
    var pageBegin = $("#chevron");
    for (var i=1;i<=totalPageNum;i++){
            pageBegin.append("<li class='waves-effect'><a href='/'>"+i+"</a></li>");
    }






</script>


<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

<div id="innerContent">

    <div class="card" style="height: 700px;padding: 16px;margin: 16px;">
        <h4 class="header">所有用户</h4>

        <#--角色分类查询-->
        <div class="row">
        <div class="col m4">
            <select id="role">
                <option value="" disabled selected>选择用户角色</option>
            <#list roles as role>
                <option value="${role.role}">${role.description}</option>
            </#list>
            </select>
        </div>
        <div class="col m2">
            <button type="button" class="btn" onclick="get();">查询</button>
        </div>
    </div>


        <div class="collection">
            <#list users as user>
                <a href="#" class="collection-item"><span class="badge"></span>${user.username}</a>
            </#list>
        </div>


        <ul id="pagination" class="pagination">
            <li id="chevron" class="disabled"><a href="#!"><i class="material-icons">chevron_left</i></a></li>
            <#--<li class="waves-effect"><a href="#!">5</a></li>-->
            <li class="waves-effect"><a href="#!"><i class="material-icons">chevron_right</i></a></li>
        </ul>
    </div>


</div>









