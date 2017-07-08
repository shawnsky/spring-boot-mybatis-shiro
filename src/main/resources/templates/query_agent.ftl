
<div class="card" style="height: 500px;padding: 16px;margin: 16px;">

    <h4 class="header">${roleName}</h4>


    <div class="collection">
    <#list agents as agent>
        <a href="#" class="collection-item"><span class="badge">1</span>${agent.username}</a>
    </#list>
    </div>


</div>







