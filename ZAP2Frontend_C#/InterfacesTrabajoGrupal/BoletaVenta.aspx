<%@ Page Title="" Language="C#" MasterPageFile="~/SoftProg.Master" AutoEventWireup="true" CodeBehind="BoletaVenta.aspx.cs" Inherits="InterfacesTrabajoGrupal.BoletaVenta" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphScripts" runat="server">
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="cphContenido" runat="server">
          <div class="container">
    <div class="card">
        <h2>Registrar Boleta de Venta</h2>
    </div>
              <br />
    <div class="card-body">
        <div class="mb-3 row">
            <asp:Label ID="lblBoletaId" runat="server" Text="ID Boleta:" CssClass="col-sm-2 col-form-label"/>
            <div class="col-sm-4">
                <asp:TextBox ID="txtBoletaId" runat="server" CssClass="form-control" Enabled="false"/>
            </div>
        </div>

        <div class="mb-3 row">
            <asp:Label ID="lblFechaEmision" runat="server" Text="Fecha de Emisión:" CssClass="col-sm-2 col-form-label"/>
            <div class="col-sm-4">
                <asp:TextBox ID="txtFechaEmision" runat="server" TextMode="Date" CssClass="form-control"/>
            </div>
        </div>

        <div class="mb-3 row">
            <asp:Label ID="lblCliente" runat="server" Text="Cliente:" CssClass="col-sm-2 col-form-label"/>
            <div class="col-sm-6">
                <asp:TextBox ID="txtCliente" runat="server" CssClass="form-control"/>
            </div>
            <div class="col-sm-2">
                <asp:Button ID="btnBuscarCliente" runat="server" Text="Buscar" CssClass="btn btn-info" OnClick="btnBuscarCliente_Click"/>
            </div>
        </div>
         <!-- Búsqueda de Producto -->
        <div class="mb-3 row">
            <asp:Label ID="lblBuscarProducto" runat="server" Text="Buscar Producto:" CssClass="col-sm-2 col-form-label"/>
            <div class="col-sm-6">
                <asp:TextBox ID="txtBuscarProducto" runat="server" CssClass="form-control"/>
            </div>
            <div class="col-sm-2">
                <asp:Button ID="btnBuscarProducto" runat="server" Text="Buscar" CssClass="btn btn-primary" OnClick="btnBuscarProducto_Click"/>
            </div>
        </div>

         <!-- Productos seleccionados para la compra -->
        <div class="mb-3 row">
            <asp:Label ID="lblListaProductos" runat="server" Text="Productos Seleccionados:" CssClass="col-sm-2 col-form-label"/>
            <div class="col-sm-10">
                <asp:GridView ID="gvProductos" runat="server" CssClass="table table-striped" AutoGenerateColumns="false">
                    <Columns>
                        <asp:BoundField DataField="ProductoId" HeaderText="ID" />
                        <asp:BoundField DataField="Nombre" HeaderText="Nombre" />
                        <asp:BoundField DataField="Cantidad" HeaderText="Cantidad" />
                        <asp:BoundField DataField="Precio" HeaderText="Precio" />
                        <asp:TemplateField>
                            <ItemTemplate>
                                <asp:Button ID="btnEliminar" runat="server" Text="Eliminar" CommandArgument='<%# Eval("ProductoId") %>' OnClick="btnEliminarProducto_Click" CssClass="btn btn-danger"/>
                            </ItemTemplate>
                        </asp:TemplateField>
                    </Columns>
                </asp:GridView>
            </div>
        </div>
    </div>

    <div class="card-footer clearfix">
        <asp:Button ID="btnRegresar" runat="server" Text="Regresar" CssClass="float-start btn btn-secondary" OnClick="btnRegresar_Click"/>
        <asp:Button ID="btnRegistrar" runat="server" Text="Registrar" CssClass="float-end btn btn-primary" OnClick="btnRegistrar_Click"/>
    </div>
</div>
</asp:Content>
