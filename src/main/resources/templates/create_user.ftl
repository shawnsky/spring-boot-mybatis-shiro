

<script>
    $(document).ready(function() {
        $('select').material_select();
    });
</script>

<div class="card" style="height: 700px;padding: 16px;margin: 16px;">
    <h4 class="header">用户信息</h4>
    <form action="/admin/createUserSubmit" method="post">
        <div class="row">
        <form class="col m10">
            <div class="row">
                <div class="input-field col m5">
                    <input id="name" type="text" class="validate">
                    <label for="name">姓名</label>
                </div>

                <div class="input-field col m5">
                    <select name="role">
                        <option value="" disabled selected>用户角色</option>
                        <#list roles as role>
                            <option value="${role.role}">${role.description}</option>
                        </#list>
                    </select>
                </div>
            </div>

            <div class="row">
                <div class="input-field col m5">
                    <input id="username" name="username" type="text" class="validate">
                    <label for="username">新建账号</label>
                </div>
                <div class="input-field col m5">
                    <input id="password" name="password" type="text" class="validate">
                    <label for="password">设置密码</label>
                </div>
            </div>

            <div class="row">
                <div class="input-field col m10">
                    <input id="tel" type="text" class="validate">
                    <label for="tel">联系方式</label>
                </div>
            </div>

            <div class="col m10">
                <button class="btn right" type="submit">提交</button>

            </div>

        </form>
    </div>
    </form>






</div>












