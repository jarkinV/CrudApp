<div class="container">
    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" href="/user">${user.name == null ? "User" : user.name}</a>
            </div>
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    ${user == null ? "" : "<li><a href=\"/items\">Items</a></li>"}
                    ${user == null ? "<li><a href=\"/login\">Sign in</a></li>" : ""}
                    ${user == null ? "<li><a href=\"/signup\">Sign up</a></li>" : ""}
                    ${user.role == "Role_admin" ? "<li><a href=\"/manage\">Users</a></li>" : ""}
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    ${user == null ? "" : "<li><a href=\"/logout\">Log out</a></li>"}
                </ul>
            </div>
        </div>
    </nav>
</div>