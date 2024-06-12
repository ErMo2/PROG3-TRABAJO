<%@ Page Title="" Language="C#" MasterPageFile="~/SoftProg.Master" AutoEventWireup="true" CodeBehind="ListarDocumentoDeVenta.aspx.cs" Inherits="InterfacesTrabajoGrupal.ListarDocumentoDeVenta" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphScripts" runat="server">
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="cphContenido" runat="server">
        <div class="container">
    <h2>Listado de Documentos de Venta</h2>
    <div class="container row">
        <div class="text-end p-3">
            <asp:LinkButton ID="lbRegistrarDocumentoDeCompra" runat="server" CssClass="btn btn-success"
                Text="<i class='fa-solid fa-plus pe-2'></i> Registrar Documento De Venta" OnClick="lbRegistrarDocumentoDeCompra_Click"/>
        </div>
    </div>


    <div class="container row">
        <asp:GridView ID="gvListaDocumentoDeVenta" runat="server"
            AutoGenerateColumns="false" CssClass="table table-hover table-responsive">
            
             <Columns>
            <asp:BoundField HeaderText="Id" DataField="Id Documento de Compra"/>
             <asp:BoundField HeaderText="FechaEmision" DataField="Fecha de Emision" />
            <asp:BoundField HeaderText="MontoTotal" DataField="Monto Total"/>
           <asp:BoundField HeaderText="Moneda" DataField="nombre"/>
             <asp:BoundField HeaderText="Abreviacion" DataField="abrebiacion"/>
           <asp:BoundField HeaderText="FechaEmision" DataField="fecha_emision" />
         <asp:BoundField HeaderText="Tipo de Tarjeta" DataField="TipoTarjeta"/>
        <asp:BoundField HeaderText="Nombre del Banco" DataField="nombreBanco"/>
          <asp:BoundField HeaderText="Numero de Cuenta" DataField="numCuenta"/>

            </Columns>
        </asp:GridView>
    </div>
</div>
</asp:Content>
