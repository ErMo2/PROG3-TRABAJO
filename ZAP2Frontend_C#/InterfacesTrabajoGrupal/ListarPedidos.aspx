<%@ Page Title="" Language="C#" MasterPageFile="~/ZAP3WA.Master" AutoEventWireup="true" CodeBehind="ListarPedidos.aspx.cs" Inherits="InterfacesTrabajoGrupal.ListarPedidos" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphScripts" runat="server">
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="cphContenido" runat="server">
    <div class="container">
        <h2>Listado de Pedidos</h2>
        <div class="container row">
            <div class="text-end p-3">
                <asp:LinkButton ID="lbRegistrarPedido" runat="server" CssClass="btn btn-success"
                    Text="<i class='fa-solid fa-plus pe-2'></i> Registrar Pedido" OnClick="lbRegistrarPedido_Click" />
            </div>
        </div>

        <div class="container row">
            <asp:GridView ID="gvPedidos" runat="server" AutoGenerateColumns="false" CssClass="table table-hover table-responsive"
                AllowPaging="True" PageSize="5" OnPageIndexChanging="gvPedidos_PageIndexChanging">
                <Columns>
                    <asp:BoundField HeaderText="Id" DataField="id_pedido" />
                    <asp:BoundField HeaderText="Saldo" DataField="saldo" />
                    <asp:BoundField HeaderText="Estado" DataField="estado" />
                    <asp:BoundField HeaderText="Fecha" DataField="fecha_Pedido" />
                    <asp:BoundField HeaderText="Total" DataField="total" />

                    <asp:TemplateField>
                        <HeaderTemplate>
                            Acciones
                        </HeaderTemplate>
                        <ItemTemplate>
                            <asp:Button ID="btnModificar" runat="server" Text="Modificar" CommandArgument='<%# Eval("id_pedido") %>' CssClass="btn btn-primary btn-sm" OnClick="btnModificar_Click" />
                            <asp:Button ID="btnEliminar" runat="server" Text="Eliminar" CommandArgument='<%# Eval("id_pedido") %>' CssClass="btn btn-danger btn-sm" OnClick="btnEliminar_Click" />
                        </ItemTemplate>
                    </asp:TemplateField>

                </Columns>
            </asp:GridView>
        </div>
    </div>
</asp:Content>
