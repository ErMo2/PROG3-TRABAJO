<%@ Page Title="" Language="C#" MasterPageFile="~/ZAP3WA.Master" AutoEventWireup="true" CodeBehind="ListarPedidos.aspx.cs" Inherits="InterfacesTrabajoGrupal.GestionPedidos" %>

<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphScripts" runat="server">
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="cphContenido" runat="server">
      <div class="container">
    <h2>Listado de Documentos de Compra</h2>
    <div class="container row">
        <div class="text-end p-3">
            <asp:LinkButton ID="lbRegistrarDocumentoDeCompra" runat="server" CssClass="btn btn-success"
                Text="<i class='fa-solid fa-plus pe-2'></i> Registrar Documento De Compra" OnClick="lbRegistrarDocumentoDeCompra_Click" />
        </div>
    </div>

    <div class="container row">
        <asp:GridView ID="gvListaDocumentoDeCompra" runat="server" AutoGenerateColumns="false" CssClass="table table-hover table-responsive"
            AllowPaging="True" PageSize="5" OnPageIndexChanging="gvListaDocumentoDeCompra_PageIndexChanging">
            <Columns>
                <asp:BoundField HeaderText="Id" DataField="id_doc_compra" />
                <asp:BoundField HeaderText="Fecha Emisión" DataField="fecha_emision" />
                <asp:BoundField HeaderText="Monto Total" DataField="monto_total" />
                <asp:BoundField HeaderText="Moneda" DataField="moneda" />
                <asp:BoundField HeaderText="Abreviación" DataField="abreviacion" />
            </Columns>
        </asp:GridView>
    </div>
</div>
</asp:Content>
