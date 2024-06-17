<%@ Page Title="" Language="C#" MasterPageFile="~/ZAP3WA.Master" AutoEventWireup="true" CodeBehind="VerProductoPersonalYHogar.aspx.cs" Inherits="InterfacesTrabajoGrupal.VerProductoPersonalYHogar" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphScripts" runat="server">
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="cphContenido" runat="server">
    <div class="container">
    <div class="card">
        <h2>Ver Producto Para el cuidado Personal y del Hogar:
        </h2>
    </div>
    <br />
    <div class="card-body">

        <div class="mb-3 row">
            <asp:Label ID="lblIdProducto" runat="server" Text="Id Producto:" CssClass="col-sm-2 col-form-label" />
            <div class="col-sm-4">
                <asp:TextBox ID="txtIdProducto" runat="server" Enabled="false" CssClass="form-control" />
            </div>
        </div>

        <div class="mb-3 row">
            <asp:Label ID="lblNombreProducto" runat="server" Text="Nombre del Prodcuto:" CssClass="col-sm-2 col-form-label" />
            <div class="col-sm-8">
                <asp:TextBox ID="txtNombreProducto" runat="server" Enabled="false" CssClass="form-control" />
            </div>
        </div>

        <div class="mb-3 row">
            <asp:Label ID="lblDescripcion" runat="server" Text="Descripcion del Producto:" CssClass="col-sm-2 col-form-label" />
            <div class="col-sm-8">
                <asp:TextBox ID="txtDescripcionProducto" runat="server" Enabled="false" CssClass="form-control" />
            </div>
        </div>

        <div class="mb-3 row">
            <asp:Label ID="lblUnidadMedida" runat="server" Text="Unidad de Medida:" CssClass="col-sm-2 col-form-label" />
            <div class="col-sm-4">
                <asp:DropDownList ID="ddlUnidadMedida" runat="server" Enabled="false" CssClass="form-control">
                    <asp:ListItem Text="Unidad" Value="Unidad"></asp:ListItem>
                    <asp:ListItem Text="Paquete" Value="Paquete"></asp:ListItem>
                    <asp:ListItem Text="KG" Value="KG"></asp:ListItem>
                    <asp:ListItem Text="LT" Value="LT"></asp:ListItem>
                    <asp:ListItem Text="NA" Value="NA"></asp:ListItem>
                </asp:DropDownList>
            </div>
        </div>

        <div class="mb-3 row">
            <asp:Label ID="lblTipo" runat="server" Text="Tipo:" CssClass="col-sm-2 col-form-label" />
            <div class="col-sm-4">
                <asp:TextBox ID="txtTipo" runat="server" Enabled="false" CssClass="form-control" />
            </div>
        </div>

    </div>

        <h3>Lista de Precios en distintas sucursales</h3>
        <div class="text-center containermt-3 mt-5 row">
            <asp:GridView ID="gvSucursales" runat="server"
                AutoGenerateColumns="false"
                CssClass="table table-hover table-responsive table-bordered center-container gridview-wrapper"
                AllowPaging="true"
                PageSize="5"
                OnPageIndexChanging="gvSucursales_PageIndexChanging"
                OnRowDataBound="gvSucursales_RowDataBound">
                <Columns>
                    <asp:BoundField HeaderText="Id" DataField="idProductoPrecio" />
                    <asp:BoundField HeaderText="Nombre" DataField="sucursal.nombre" />
                    <asp:BoundField HeaderText="Precio" DataField="precio" />
                    <asp:TemplateField>
                        <ItemTemplate>
                            <asp:LinkButton ID="lbEliminar" runat="server" CommandName="Eliminar" CommandArgument='<%# Eval("idProductoPrecio") %>' Text="Eliminar" CssClass="btn btn-danger btn-sm" OnClientClick="return confirm('¿Está seguro de que desea eliminar esta sucursal?');" OnClick="btnEliminar_Click" />
                        </ItemTemplate>
                    </asp:TemplateField>
                </Columns>
            </asp:GridView>
        </div>
        <div class="mb-3 row">
            <asp:Label ID="lblSucursal" runat="server" Text="Sucursal:" CssClass="col-sm-2 col-form-label" />
            <div class="col-sm-4">
                <asp:DropDownList ID="ddlSucursal" runat="server" CssClass="form-control"></asp:DropDownList>

            </div>
        </div>
        <div class="mb-3 row">
            <asp:Label ID="lblNuevoPrecio" runat="server" Text="Nuevo Precio:" CssClass="col-sm-2 col-form-label" />
            <div class="col-sm-8">
                <asp:TextBox ID="txtNuevoPrecio" runat="server" CssClass="form-control" />
            </div>
        </div>
        <div class="card-footer clearfix">
            <asp:Button ID="BtnInsertarProductoPrecio" runat="server" Text="Registrar Sucursal" CssClass="btn btn-primary" OnClick="btnRegistrarProductoPrecio_Click" />
        </div>
        <div class="card-footer clearfix">
            <asp:Button ID="btnRegresar" runat="server" Text="Regresar"
                CssClass="float-start btn btn-secondary" OnClick="btnRegresar_Click" />
        </div>
    </div>
</asp:Content>
