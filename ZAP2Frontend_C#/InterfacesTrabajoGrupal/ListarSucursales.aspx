<%@ Page Title="" Language="C#" MasterPageFile="~/SoftProg.Master" AutoEventWireup="true" CodeBehind="ListarSucursales.aspx.cs" Inherits="InterfacesTrabajoGrupal.ListarSucursales" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphScripts" runat="server">
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="cphContenido" runat="server">
     <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
    <link href="Scripts/EstiloSucursales.css" rel="stylesheet" />
    <div class="container">
        <h2>Listado de Sucursales</h2>

        <div class="container row">
            <div class="text-end p-3">
                <asp:LinkButton ID="lbRegistrarSucursal" runat="server" CssClass="btn btn-success"
                    Text="<i class='fa-solid fa-plus pe-2'></i> Registrar Sucursal" OnClick="lbRegistrarSucursal_Click"/>
            </div>
        </div>

        <div class="container row">
            <asp:GridView ID="gvSucursales" runat="server"
                AutoGenerateColumns="false"
                CssClass="table table-hover table-responsive-sm table-striped"
                AllowPaging="true"
                PageSize="7"
                OnPageIndexChanging="gvSucursales_PageIndexChanging"
                OnRowCommand="gvSucursales_RowCommand">
                <Columns>
                    <asp:BoundField HeaderText="Id" DataField="id_sucursal" />
                    <asp:BoundField HeaderText="Dirección" DataField="direccion" />
                    <asp:BoundField DataField="tam_metros" HeaderText="Tamaño <br/> (Metros Cuadrados)" HtmlEncode="False" />

                    <asp:TemplateField>
                        <ItemTemplate>
                            <asp:LinkButton ID="lbModificar" runat="server" CommandName="Modificar" CommandArgument='<%# Eval("id_sucursal") %>' Text="Modificar" CssClass="btn btn-primary btn-sm" />
                            <asp:LinkButton ID="lbEliminar" runat="server" CommandName="Eliminar" CommandArgument='<%# Eval("id_sucursal") %>' Text="Eliminar" CssClass="btn btn-danger btn-sm" OnClientClick="return confirm('¿Está seguro de que desea eliminar esta sucursal?');" />
                        </ItemTemplate>
                    </asp:TemplateField>
                </Columns>
                <PagerSettings Mode="NumericFirstLast" FirstPageText="Primero" LastPageText="Último" PageButtonCount="5" />
                <PagerStyle CssClass="pagination justify-content-center" />
            </asp:GridView>
        </div>
    </div>
</asp:Content>
