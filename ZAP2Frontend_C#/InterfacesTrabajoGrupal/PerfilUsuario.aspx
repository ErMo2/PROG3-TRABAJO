<%@ Page Title="" Language="C#" MasterPageFile="~/ZAP3WA.Master" AutoEventWireup="true" CodeBehind="PerfilUsuario.aspx.cs" Inherits="InterfacesTrabajoGrupal.PerfilUsuario" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphScripts" runat="server">
     <style>
         body {
             font-family: Arial, sans-serif;
             background-color: #f8f9fa;
             margin: 0;
             padding: 0;
         }

         .container {
             max-width: 800px;
             margin: 50px auto;
             padding: 20px;
             background-color: #fff;
             border-radius: 5px;
             box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
         }

         h1 {
             font-size: 24px;
             color: #333;
             margin-bottom: 20px;
         }

         .info-group {
             margin-bottom: 15px;
         }

         .info-label {
             font-weight: bold;
             color: #555;
             width: 150px;
             display: inline-block;
         }

         .info-value {
             color: #333;
             display: inline-block;
         }
     </style>
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="cphContenido" runat="server">
      <div class="container">
        <h1>Perfil de Usuario</h1>
        <div class="info-group">
            <span class="info-label">Nombre Usuario:</span>
            <span class="info-value">Ronnie Cueva Moscoso</span>
        </div>
        <div class="info-group">
            <span class="info-label">DNI:</span>
            <span class="info-value">12345678</span>
        </div>
        <div class="info-group">
            <span class="info-label">Sexo:</span>
            <span class="info-value">Masculino</span>
        </div>
          <img src="Imagenes/FotoPerfil.png" alt="Foto de perfil" class="profile-image" 
    </div>
</asp:Content>
