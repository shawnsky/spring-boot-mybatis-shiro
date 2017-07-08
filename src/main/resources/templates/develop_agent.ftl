

<#--<html>-->
<#--<head>-->
    <#--<link rel="stylesheet" href="/css/materialize.min.css">-->
<#--</head>-->

<#--<body>-->
<script>
    $(document).ready(function() {
        $('select').material_select();
    });
</script>

<div class="card" style="height: 700px;padding: 16px;margin: 16px;">
    <h4 class="header">代理信息</h4>

    <div class="row">
        <form class="col m10">
            <div class="row">
                <div class="input-field col m5">
                    <input id="name" type="text" class="validate">
                    <label for="name">姓名</label>
                </div>

                <div class="input-field col m5">
                    <select>
                        <option value="" disabled selected>代理等级</option>
                        <option value="1">一级代理商</option>
                        <option value="2">二级代理商</option>
                        <option value="3">战略合作伙伴</option>
                    </select>
                </div>
            </div>

            <div class="row">
                <div class="input-field col m5">
                    <input id="username" name="username" type="text" class="validate">
                    <label for="username">新建账号</label>
                </div>
                <div class="input-field col m5">
                    <input id="password" type="text" class="validate">
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
                <button class="btn right" type="button">提交</button>

            </div>

        </form>
    </div>






</div>



<#--<script src="/js/jquery-3.2.1.min.js"></script>-->
<#--<script src="/js/materialize.min.js"></script>-->
<#--</body>-->
<#--</html>-->









