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

                    <#--<div class="col m2">-->
                        <#--<p>-->
                            <#--<input type="checkbox" name="${key}ejdls" id="${key}ejdls" />-->
                            <#--<label for="${key}ejdls">二级代理商</label>-->
                        <#--</p>-->
                    <#--</div>-->
                    <#--<div class="col m2">-->
                        <#--<p>-->
                            <#--<input type="checkbox" name="${key}yjdls" id="${key}yjdls" />-->
                            <#--<label for="${key}yjdls">一级代理商</label>-->
                        <#--</p>-->
                    <#--</div>-->
                    <#--<div class="col m2">-->
                        <#--<p>-->
                            <#--<input type="checkbox" name="${key}qgzdls" id="${key}qgzdls" />-->
                            <#--<label for="${key}qgzdls">全国总代理商</label>-->
                        <#--</p>-->
                    <#--</div>-->
                    <#--<div class="col m2">-->
                        <#--<p>-->
                            <#--<input type="checkbox" name="${key}zlhzhb" id="${key}zlhzhb" />-->
                            <#--<label for="${key}zlhzhb">战略合作伙伴</label>-->
                        <#--</p>-->
                    <#--</div>-->
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









