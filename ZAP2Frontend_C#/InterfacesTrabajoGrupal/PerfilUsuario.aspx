﻿<%@ Page Title="" Language="C#" MasterPageFile="~/ZAP3WA.Master" AutoEventWireup="true" CodeBehind="PerfilUsuario.aspx.cs" Inherits="InterfacesTrabajoGrupal.PerfilUsuario" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphScripts" runat="server">
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
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
            <span class="info-label">Usuario:</span>
            <asp:Label ID="lblNombreUsuario" runat="server" />
        </div>
        <div class="info-group">
            <span class="info-label">Nombre:</span>
            <asp:Label ID="lblNombreReal" runat="server" />
        </div>
        <div class="info-group">
            <span class="info-label">Apellidos:</span>
            <asp:Label ID="lblApellidos" runat="server" />
        </div>
        <div class="info-group">
            <span class="info-label">Sexo:</span>
            <asp:Label ID="lblSexo" runat="server" />
        </div>
        <div class="info-group">
            <span class="info-label">Tipo documento:</span>
            <asp:Label ID="lblTipoDocumento" runat="server" />
        </div>
        <div class="info-group">
            <span class="info-label">Número documento:</span>
            <asp:Label ID="lblNumeroDocumento" runat="server" />
        </div>
        <div class="info-group">
            <span class="info-label">Email:</span>
            <asp:Label ID="lblEmail" runat="server" />
        </div>
        <div class="info-group">
            <span class="info-label">Telefono:</span>
            <asp:Label ID="lblTelefono" runat="server" />
        </div>
        <img src="Imagenes/FotoPerfil.png" alt="Foto de perfil" class="profile-image" />

        <div class="modal-footer">
            <asp:Button ID="btnCerrarSesion" runat="server" Text="Cerrar sesión" CssClass="btn btn-primary" OnClick="btnCerrarSesion_Click" />
        </div>

    </div>

</asp:Content>
