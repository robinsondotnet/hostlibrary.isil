<%-- 
    Document   : pruebaAjaX
    Created on : 29-nov-2018, 20:08:54
    Author     : Alumno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="https://code.jquery.com/jquery-3.3.1.js"
                integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60="
        crossorigin="anonymous"></script>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form action="action">
            <input type="text" class="valor" onkeyup="cambiarEstado()">
        </form>
      <!--  <button onkeypress="cambiarEstado()" >Cambiar</button> -->
        <div class="resultado"></div>
    </body>
    <script>      
        function cambiarEstado() {
            var valor=parseInt($(".valor").val());
            $.ajax({
                url: "controladorcambiarestado",
                data: {
                    estado:valor
                },
                success: function (result) {
                    console.log(result);
                    console.log(valor);
                    $(".resultado").html("<strong> Resultado :" + result + "</strong> degrees");
                }
            });
        }
    </script>

</html>
