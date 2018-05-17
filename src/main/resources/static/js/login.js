$(document).ready(
    function(){
        $("#submitForm").click(
            function(event) {
                event.preventDefault();
                $.ajax({
                    type : "GET",
                    url : "/login",
                    data : {
                        "nombreUsuario":$("#nombreUsr").val(),
                        "password":$.md5($("#pass").val()),
                        "authPassword":$.md5($("#Authpass").val())},
                    success : function() {
                        $("#resLogin").html(
                            "<div>Login correcto</div>");
                        //window.location.href = "/Admin.html";
                    },
                    error : function(){
                        $("#resLogin").html(
                            "<div>"
                            +"Login incorrecto"
                            +"</div>");
                    }
                });
            });
        $("#nuevaCuenta").click(
            function (event) {
                event.preventDefault();
                $.ajax({
                    type : "POST",
                    url: "/register",
                    contentType: "application/json",
                    data : JSON.stringify({"nombreUsuario":$("#nombreUsr").val(),
                        "password":$.md5($("#pass").val()),
                        "authPassword":$.md5($("#Authpass").val())}),
                    success : function() {
                        $("#resLogin").html(
                            "<div>Login correcto</div>");
                        //window.location.href = "/Admin.html";
                    },
                    error : function(){
                        $("#resLogin").html(
                            "<div>"
                            +"Login incorrecto"
                            +"</div>");
                    }
                });
        });
    });