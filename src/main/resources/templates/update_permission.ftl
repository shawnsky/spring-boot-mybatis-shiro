<div id="innerContent">
    <div id="card" class="card" style="padding: 16px;margin: 16px;">

        <h4 class="header">权限变更</h4>

        <form action="/admin/updatePermissionSubmit" method="post" id="updateForm">

            <#assign keys=prMap?keys/>

            <#list keys as key>
                <div class="row">
                    ${key}
                    <div class="row">
                        <#list roles as role>
                            <div class="col m2">
                                <p>
                                    <input type="checkbox" name="${key}${role.role}" id="${key}${role.role}" />
                                    <label for="${key}${role.role}">${role.description}</label>
                                </p>
                            </div>
                        </#list>
                    </div>
                    <hr>
                    <#list prMap[key] as val>
                        <script type="text/javascript">
                            $("#${key}${val}").attr("checked",true);
                        </script>
                    </#list>
                </div>
            </#list>
            <button class="btn" type="submit">提交</button>
        </form>

    </div>
</div>









