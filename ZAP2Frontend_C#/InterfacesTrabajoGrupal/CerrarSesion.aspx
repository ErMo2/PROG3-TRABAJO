<%@ Page Title="" Language="C#" MasterPageFile="~/SoftProg.Master" AutoEventWireup="true" CodeBehind="CerrarSesion.aspx.cs" Inherits="InterfacesTrabajoGrupal.CerrarSesion" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphScripts" runat="server">
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="cphContenido" runat="server">
    <div class="container mt-5">
        <div class="alert alert-success" role="alert">
            ¿Está seguro de que desea cerrar sesión?
        </div>
        <asp:Button ID="btnCerrarSesion" runat="server" Text="Cerrar sesión" CssClass="btn btn-primary" OnClick="btnCerrarSesion_Click" />
    </div>
</asp:Content>
