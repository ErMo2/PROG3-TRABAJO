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
            <asp:BoundField HeaderText="Monto Total" DataField="total" />
          
            <asp:TemplateField>
                <HeaderTemplate>Acciones</HeaderTemplate>
                <ItemTemplate>
                    <asp:Button ID="btnVerBoleta" runat="server" Text="Ver" CommandArgument='<%# Container.DataItemIndex %>' CssClass="btn btn-info btn-sm" OnClick="btnVerBoleta_Click" data-toggle="modal" data-target="#verBoletaModal" />
                </ItemTemplate>
            </asp:TemplateField>
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
            <asp:BoundField HeaderText="Tipo de tarjeta" DataField="tarjeta.tipoTarjeta" />
            <asp:BoundField HeaderText="Fecha de Vencimiento" DataField="fechaVenc" />
            <asp:BoundField HeaderText="Monto Total" DataField="total" />
                     
            <asp:TemplateField>
                <HeaderTemplate>Acciones</HeaderTemplate>
                <ItemTemplate>
                    <asp:Button ID="btnVerFactura" runat="server" Text="Ver" CommandArgument='<%# Container.DataItemIndex %>' CssClass="btn btn-info btn-sm" OnClick="btnVerFactura_Click" data-toggle="modal" data-target="#verFacturaModal" />
                </ItemTemplate>
            </asp:TemplateField>
        </Columns>
    </asp:GridView>
</div>

<!-- Modal para ver detalles de Boleta de Venta -->
<div class="modal fade" id="verBoletaModal" tabindex="-1" aria-labelledby="verBoletaModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="verBoletaModalLabel">Detalles de Boleta de Venta</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <asp:Label ID="lblDetallesBoleta" runat="server" Text=""></asp:Label>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
            </div>
        </div>
    </div>
</div>

<!-- Modal para ver detalles de Factura de Venta -->
<div class="modal fade" id="verFacturaModal" tabindex="-1" aria-labelledby="verFacturaModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="verFacturaModalLabel">Detalles de Factura de Venta</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <asp:Label ID="lblDetallesFactura" runat="server" Text=""></asp:Label>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
            </div>
        </div>
    </div>
</div>
</asp:Content>
