
<script type="text/javascript">
    function deleteRole(role) {
        alert("hey");
        $('#'+role+'Form').submit();
    }
</script>

<div class="card" style="height: 700px;padding: 16px;margin: 16px;">
    <h4 class="header">所有角色</h4>

    <div class="collection">
    <#list roles as role>
        <form id="Form${role.role}" action="/admin/deleteRoleSubmit">
            <input type="hidden" name="role" value="${role.role}">
            <a href="javascript:void(0);"  onclick="$('#Form${role.role}').submit();return false;" class="collection-item"><span class="badge">删除</span>${role.description}</a>
        </form>
    </#list>
    </div>




</div>












