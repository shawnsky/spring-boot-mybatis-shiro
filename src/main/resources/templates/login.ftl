<html>
<head>
    <title>登录</title>
    <link rel="stylesheet" href="/css/materialize.min.css">


    <script type="text/javascript">

    </script>

</head>
<body>




<div class="row" style="margin-top: 100px;">
    <div class="col m4 offset-m4">
        <div class="card ">
            <div class="card-content ">
                <span class="card-title">登录</span>
                <p>${error}</p>
            </div>
            <form id="loginForm" action="" method="post">
                <div style="padding: 16px">

                    <div class="input-field">
                        <input id="username" name="username" type="text" class="validate">
                        <label for="username">用户名</label>
                    </div>

                    <div class="input-field">
                        <input id="password" name="password" type="password" class="validate">
                        <label for="password">密码</label>
                    </div>

                    <input type="checkbox" class="filled-in" id="rememberMe" name="rememberMe" checked="checked" />
                    <label for="rememberMe">记住我</label>

                </div>
                <div class="card-action">
                    <button class="btn waves-effect waves-light" type="reset">重置</button>
                    <button class="btn waves-effect waves-light" type="submit">登录</button>
                </div>

            </form>
        </div>
    </div>
</div>



<script src="/js/jquery-3.2.1.min.js"></script>
<script src="/js/materialize.min.js"></script>



</body>
</html>