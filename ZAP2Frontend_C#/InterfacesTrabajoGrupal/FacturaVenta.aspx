<%@ Page Title="" Language="C#" MasterPageFile="~/ZAP3WA.Master" AutoEventWireup="true" CodeBehind="FacturaVenta.aspx.cs" Inherits="InterfacesTrabajoGrupal.FacturaVenta" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphScripts" runat="server">
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="cphContenido" runat="server">
                   <div class="container">
    <div class="card">
        <h2>Registrar Factura de Venta</h2>
    </div>
         <br />
    <div class="card-body">
        <div class="mb-3 row">
            <asp:Label ID="lblNumeroFactura" runat="server" Text="Número de Factura:" CssClass="col-sm-2 col-form-label"/>
            <div class="col-sm-4">
                <asp:TextBox ID="txtNumeroFactura" runat="server" CssClass="form-control"/>
            </div>
        </div>

        <div class="mb-3 row">
            <asp:Label ID="lblFechaEmision" runat="server" Text="Fecha de Emisión:" CssClass="col-sm-2 col-form-label"/>
            <div class="col-sm-4">
                <input type="date" id="dtpFechaEmision" runat="server" class="form-control"/>
            </div>
        </div>

        <div class="mb-3 row">
            <asp:Label ID="lblRUC" runat="server" Text="RUC:" CssClass="col-sm-2 col-form-label"/>
            <div class="col-sm-4">
                <asp:TextBox ID="txtRUC" runat="server" CssClass="form-control"/>
            </div>
        </div>

        <div class="mb-3 row">
            <asp:Label ID="lblCliente" runat="server" Text="Cliente:" CssClass="col-sm-2 col-form-label"/>
            <div class="col-sm-8">
                <asp:TextBox ID="txtCliente" runat="server" CssClass="form-control"/>
            </div>
        </div>

        <!-- Inserción y listado de productos -->
        <div id="productList" runat="server" class="mt-4">
            <!-- Similar a la implementación de Boleta de Venta con botones para buscar y agregar productos -->
        </div>

    </div>
    <div class="card-footer clearfix">
        <asp:Button ID="btnRegresar" runat="server" Text="Regresar" CssClass="float-start btn btn-secondary" OnClick="btnRegresar_Click"/>
        <asp:Button ID="btnRegistrar" runat="server" Text="Registrar" CssClass="float-end btn btn-primary" OnClick="btnRegistrar_Click"/>
    </div>
</div>
</asp:Content>
