<%@ Page Title="" Language="C#" MasterPageFile="~/ZAP3WA.Master" AutoEventWireup="true" CodeBehind="ListarPedidos.aspx.cs" Inherits="InterfacesTrabajoGrupal.GestionPedidos" %>

<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphScripts" runat="server">
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="cphContenido" runat="server">
    <!DOCTYPE html>
    <html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <title>Listado de Pedidos</title>
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
        <link href="tuEstilo.css" rel="stylesheet">
    </head>
    <body>
        <div class="container mt-5">
            <h2 class="mb-4">Listado de Pedidos</h2>
            <div class="text-end mb-3">
                <asp:LinkButton ID="lbRegistrarPedido" runat="server" CssClass="btn btn-success"
                    Text="<i class='fa-solid fa-plus pe-2'></i> Registrar Pedido" OnClick="lbRegistrarPedido_Click" />
            </div>

            <asp:GridView ID="gvPedidos" runat="server" AutoGenerateColumns="false"
                CssClass="table table-hover table-responsive-md table-striped" GridLines="None"
                AllowPaging="True" PageSize="5" OnPageIndexChanging="gvPedidos_PageIndexChanging">
                <Columns>
                    <asp:BoundField HeaderText="Codigo del Pedido" DataField="id_pedido" />
                    <asp:BoundField HeaderText="Saldo del Pedido" DataField="saldo" />
                    <asp:BoundField HeaderText="Estado" DataField="estado" />
                    <asp:BoundField HeaderText="Fecha de Registro" DataField="fecha_pedido" />
                    <asp:BoundField HeaderText="Total" DataField="total" />
                </Columns>
                <PagerStyle CssClass="pagination-justified" />
            </asp:GridView>
        </div>
    </body>
    </html>
</asp:Content>
