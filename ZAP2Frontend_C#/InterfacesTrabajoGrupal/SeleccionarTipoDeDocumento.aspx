<%@ Page Title="" Language="C#" MasterPageFile="~/SoftProg.Master" AutoEventWireup="true" CodeBehind="SeleccionarTipoDeDocumento.aspx.cs" Inherits="InterfacesTrabajoGrupal.SeleccionarTipoDeDocumento" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphScripts" runat="server">
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="cphContenido" runat="server">
            <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
<div>
        <h2>Seleccionar Tipo de Documento</h2>
    <div class="d-flex flex-column align-items-center mt-4">
        <div class="w-100 mb-3" style="max-width: 300px;">
            <asp:Button ID="lblDocumentoVenta" CssClass="btn btn-primary btn-lg w-100 custom-btn" runat="server" Text="Documento de Venta" OnClick="lblDocumentoVenta_Click" />
        </div>
        <div class="w-100 mb-3" style="max-width: 300px;">
            <asp:Button ID="lblDocumentoCompra" CssClass="btn btn-success btn-lg w-100 custom-btn" runat="server" Text="Documento de Compra" OnClick="lblDocumentoCompra_Click" />
        </div>
        
    </div>
    </div>
</asp:Content>
