<%@ Page Title="" Language="C#" MasterPageFile="~/ZAP3WA.Master" AutoEventWireup="true" CodeBehind="SeleccionarTipoDeDocumentoDeVenta.aspx.cs" Inherits="InterfacesTrabajoGrupal.SeleccionarTipoDeDocumentoDeVenta" %>

<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphScripts" runat="server">
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="cphContenido" runat="server">
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <div>
        <h2>Seleccionar Tipo de Documento de Venta</h2>
        <div class="d-flex flex-column align-items-center mt-4">
            <div class="w-100 mb-3" style="max-width: 300px;">
                <asp:Button ID="lblFacturaVenta" CssClass="btn btn-primary btn-lg w-100 custom-btn" runat="server" Text="Factura de Venta" OnClick="btnFacturaVenta_Click" />
            </div>
            <div class="w-100 mb-3" style="max-width: 300px;">
                <asp:Button ID="lblBoletaVenta" CssClass="btn btn-success btn-lg w-100 custom-btn" runat="server" Text="Boleta de Venta" OnClick="btnBoletaVenta_Click" />
            </div>

        </div>
    </div>
</asp:Content>
