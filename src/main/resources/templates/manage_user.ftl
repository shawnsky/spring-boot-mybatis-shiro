


<script type="text/javascript">
    $(document).ready(function() {
        $('select').material_select();
    });
    



</script>

<div class="card" style="height: 700px;padding: 16px;margin: 16px;">
    <h4 class="header">所有用户</h4>

    <#--角色分类查询-->
    <#--<div class="row">-->
        <#--<div class="col m4">-->
            <#--<select id="role">-->
                <#--<option value="" disabled selected>选择用户角色</option>-->
            <#--<#list roles as role>-->
                <#--<option value="${role.role}">${role.description}</option>-->
            <#--</#list>-->
            <#--</select>-->
        <#--</div>-->
        <#--<div class="col m2">-->
            <#--<button type="button" class="btn" onclick="get();">查询</button>-->
        <#--</div>-->
    <#--</div>-->

    <div class="collection">
    <#list users as user>
        <a href="#" class="collection-item"><span class="badge"></span>${user.username}</a>
    </#list>
    </div>





</div>












