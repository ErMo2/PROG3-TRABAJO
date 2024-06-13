<%@ Page Title="" Language="C#" MasterPageFile="~/ZAP3WA.Master" AutoEventWireup="true" CodeBehind="GestionarProductoPersonalYHogar.aspx.cs" Inherits="InterfacesTrabajoGrupal.ProductoPersonalYHogar" %>

<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphScripts" runat="server">
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="cphContenido" runat="server">
    <div class="container">
        <div class="card">
            <h2>Registrar Producto Para el cuidado Personal y del Hogar:
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
                    <asp:TextBox ID="txtNombreProducto" runat="server" CssClass="form-control" />
                </div>
            </div>

            <div class="mb-3 row">
                <asp:Label ID="lblDescripcion" runat="server" Text="Descripcion del Producto:" CssClass="col-sm-2 col-form-label" />
                <div class="col-sm-8">
                    <asp:TextBox ID="txtDescripcionProducto" runat="server" CssClass="form-control" />
                </div>
            </div>

            <div class="mb-3 row">
                <asp:Label ID="lblPrecio" runat="server" Text="Precio del Producto:" CssClass="col-sm-2 col-form-label" />
                <div class="col-sm-8">
                    <asp:TextBox ID="txtPrecioProducto" runat="server" CssClass="form-control" />
                </div>
            </div>

            <div class="mb-3 row">
                <asp:Label ID="lblStock" runat="server" Text="Stock del Producto:" CssClass="col-sm-2 col-form-label" />
                <div class="col-sm-8">
                    <asp:TextBox ID="txtStock" runat="server" CssClass="form-control" />
                </div>
            </div>

            <div class="mb-3 row">
                <asp:Label ID="lblUnidadMedida" runat="server" Text="Unidad de Medida:" CssClass="col-sm-2 col-form-label" />
                <div class="col-sm-4">
                    <asp:DropDownList ID="ddlUnidadMedida" runat="server" CssClass="form-control">
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
                    <asp:TextBox ID="txtTipo" runat="server" CssClass="form-control" />
                </div>
            </div>
            <!-- New field for selecting a Sucursal -->
            <div class="form-group row">
                <label for="ddlSucursal" class="col-sm-2 col-form-label">Sucursal:</label>
                <div class="col-sm-10">
                    <asp:DropDownList ID="ddlSucursal" runat="server" CssClass="form-control">
                    </asp:DropDownList>
                </div>
            </div>
            <br />
            <!-- New field for applying a Discount -->
            <div class="form-group row">
                <label for="txtDescuento" class="col-sm-2 col-form-label">Descuento (%):</label>
                <div class="col-sm-10">
                    <asp:TextBox ID="txtDescuento" runat="server" CssClass="form-control" TextMode="Number" />
                </div>
            </div>


        </div>
        <hr />
        <div class="card-footer clearfix">
            <asp:Button ID="btnRegresar" runat="server" Text="Regresar"
                CssClass="float-start btn btn-secondary" OnClick="btnRegresar_Click" />
            <asp:Button ID="btnRegistrar" runat="server" Text="Registrar"
                CssClass="float-end btn btn-primary" OnClick="btnRegistrar_Click" />
        </div>

    </div>
</asp:Content>
