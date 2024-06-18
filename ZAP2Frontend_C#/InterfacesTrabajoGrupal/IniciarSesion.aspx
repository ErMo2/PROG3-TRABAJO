<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="IniciarSesion.aspx.cs" Inherits="InterfacesTrabajoGrupal.IniciarSesion" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Iniciar sesión</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet" />
    <style>
        body {
            background-color: #f8f9fa;
        }
        .form-signin {
            width: 100%;
            max-width: 360px;
            padding: 15px;
            margin: auto;
        }
        .form-signin .form-control {
            position: relative;
            box-sizing: border-box;
            height: auto;
            padding: 10px;
            font-size: 16px;
        }
        .form-signin .form-control:focus {
            z-index: 2;
        }
        .form-signin input[type="email"] {
            margin-bottom: -1px;
            border-bottom-right-radius: 0;
            border-bottom-left-radius: 0;
        }
        .form-signin input[type="password"] {
            margin-bottom: 10px;
            border-top-left-radius: 0;
            border-top-right-radius: 0;
        }
        .form-signin .checkbox {
            font-weight: 400;
        }
        .form-signin img {
            margin-bottom: 20px;
        }
    </style>
</head>
<body>
    <form id="form1" runat="server" class="form-signin">
        <div class="text-center">
            <img class="mb-4" src="Imagenes/WhatsApp%20Image%202024-04-16%20at%2021.43.57.jpeg" alt="" width="72" height="72">
            <h1 class="h3 mb-3 font-weight-normal">Iniciar sesión</h1>
        </div>

        <asp:Label ID="lblErrorMessage" runat="server" CssClass="text-danger" EnableViewState="false"></asp:Label>
        
        <div class="form-group">
            <asp:TextBox ID="txtUsername" runat="server" CssClass="form-control" placeholder="Nombre de usuario" required></asp:TextBox>
        </div>
        
        <div class="form-group">
            <asp:TextBox ID="txtPassword" runat="server" CssClass="form-control" TextMode="Password" placeholder="Contraseña" required></asp:TextBox>
        </div>

        <asp:Button ID="btnLogin" runat="server" Text="Iniciar sesión" CssClass="btn btn-lg btn-primary btn-block" OnClick="btnLogin_Click" />

        <p class="mt-5 mb-3 text-muted text-center">&copy; 2024</p>
    </form>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
