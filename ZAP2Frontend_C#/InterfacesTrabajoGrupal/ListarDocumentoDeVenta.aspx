<%@ Page Title="" Language="C#" MasterPageFile="~/ZAP3WA.Master" AutoEventWireup="true" CodeBehind="ListarDocumentoDeVenta.aspx.cs" Inherits="InterfacesTrabajoGrupal.ListarDocumentoDeVenta" %>

<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphScripts" runat="server">
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="cphContenido" runat="server">
   <h2 class="mb-4 text-center">Listado de Documentos de Venta</h2>

    <!-- Sección de Boletas de Venta -->
    <div class="mb-4">
        <h3>Boletas de Venta</h3>
        <div class="text-end mb-3">
            <asp:LinkButton ID="lbRegistrarBoletaDeVenta" runat="server" CssClass="btn btn-success"
                Text="<i class='fa-solid fa-plus pe-2'></i> Registrar Boleta de Venta" OnClick="lbRegistrarBoletaDeVenta_Click" />
        </div>
        <asp:GridView ID="gvBoletasDeVenta" runat="server" AutoGenerateColumns="False" CssClass="table table-hover table-responsive"
            AllowPaging="True" PageSize="5" OnPageIndexChanging="gvBoletasDeVenta_PageIndexChanging">
            <Columns>
                <asp:BoundField HeaderText="Id Documento" DataField="id_documento" />
                <asp:BoundField HeaderText="Fecha de Emisión" DataField="fecha_emision" />
                <asp:BoundField HeaderText="Monto Total" DataField="monto_total" />
                <asp:BoundField HeaderText="Moneda" DataField="moneda" />
             
            </Columns>
        </asp:GridView>
    </div>

    <!-- Sección de Facturas de Venta -->
    <div class="mb-4">
        <h3>Facturas de Venta</h3>
        <div class="text-end mb-3">
            <asp:LinkButton ID="lbRegistrarFacturaDeVenta" runat="server" CssClass="btn btn-success"
                Text="<i class='fa-solid fa-plus pe-2'></i> Registrar Factura de Venta" OnClick="lbRegistrarFacturaDeVenta_Click" />
        </div>
        <asp:GridView ID="gvFacturasDeVenta" runat="server" AutoGenerateColumns="False" CssClass="table table-hover table-responsive"
            AllowPaging="True" PageSize="5" OnPageIndexChanging="gvFacturasDeVenta_PageIndexChanging">
            <Columns>
                <asp:BoundField HeaderText="Id Documento" DataField="id_documento" />
                <asp:BoundField HeaderText="Fecha de Emisión" DataField="fecha_emision" />
                <asp:BoundField HeaderText="Monto Total" DataField="monto_total" />
                <asp:BoundField HeaderText="Moneda" DataField="moneda" />
  
            </Columns>
        </asp:GridView>
    </div>
</asp:Content>
