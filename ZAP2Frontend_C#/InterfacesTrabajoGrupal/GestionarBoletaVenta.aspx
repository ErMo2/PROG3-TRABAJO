<%@ Page Title="" Language="C#" MasterPageFile="~/ZAP3WA.Master" AutoEventWireup="true" CodeBehind="GestionarBoletaVenta.aspx.cs" Inherits="InterfacesTrabajoGrupal.BoletaVenta" %>

<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphScripts" runat="server">
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="cphContenido" runat="server">
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Registrar Boleta de Venta</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet" />
</head>
<body>
    <form id="form1">
        <div class="container">
            <div class="card">
                <div class="card-header">
                    <h2>Registrar Boleta de Venta</h2>
                </div>
                <div class="card-body">
                    <div class="mb-3 row">
                        <asp:Label ID="lblBoletaId" runat="server" Text="ID Boleta:" CssClass="col-sm-2 col-form-label" />
                        <div class="col-sm-4">
                            <asp:TextBox ID="txtBoletaId" runat="server" CssClass="form-control" Enabled="false" />
                        </div>
                    </div>
                    
                    <div class="mb-3 row">
                        <asp:Label ID="lblNumeroSerie" runat="server" Text="Numero de Serie:" CssClass="col-sm-2 col-form-label" />
                        <div class="col-sm-4">
                            <asp:TextBox ID="txtNumeroSerie" runat="server" CssClass="form-control" />
                        </div>
                    </div>
                    <div class="mb-3 row">
                        <asp:Label ID="lblFechaEmision" runat="server" Text="Fecha de Emisión:" CssClass="col-sm-2 col-form-label" />
                        <div class="col-sm-4">
                            <asp:TextBox ID="txtFechaEmision" runat="server" TextMode="Date" CssClass="form-control" />
                        </div>
                    </div>

                  <div class="mb-3 row">
                    <asp:Label ID="lblNombreCliente" runat="server" Text="Nombre Cliente:" CssClass="col-sm-2 col-form-label" />
                    <div class="col-sm-4">
                        <asp:TextBox ID="txtNombreCliente" runat="server" CssClass="form-control" />
                    </div>
                    <div class="col-sm-2">
                        <asp:Button ID="btnBuscarCliente" runat="server" Text="Buscar" CssClass="btn btn-info" OnClick="btnBuscarCliente_Click" />
                    </div>
                </div>
                <div class="mb-3 row">
                    <asp:Label ID="lblClientes" runat="server" Text="Seleccionar Cliente:" CssClass="col-sm-2 col-form-label" />
                    <div class="col-sm-4">
                        <asp:DropDownList ID="ddlClientes" runat="server" CssClass="form-control">
                        </asp:DropDownList>
                    </div>
                </div>


                    <div class="mb-3 row">
                        <asp:Label ID="lblSucursal" runat="server" Text="Sucursal:" CssClass="col-sm-2 col-form-label" />
                        <div class="col-sm-6">
                            <asp:DropDownList ID="ddlSucursales" runat="server" CssClass="form-control" AutoPostBack="true" OnSelectedIndexChanged="ddlSucursales_SelectedIndexChanged" />
                        </div>
                    </div>

                    <div class="mb-3 row">
                        <asp:Label ID="lblCajero" runat="server" Text="Cajero:" CssClass="col-sm-2 col-form-label" />
                        <div class="col-sm-8">
                            <asp:DropDownList ID="ddlCajeros" runat="server" CssClass="form-control">
                            </asp:DropDownList>
                        </div>
                    </div>
                    
                    <div class="mb-3 row">
                        <asp:Label ID="lblMoneda" runat="server" Text="Moneda:" CssClass="col-sm-2 col-form-label" />
                        <div class="col-sm-6">
                            <asp:DropDownList ID="ddlMonedas" runat="server" CssClass="form-control" />
                        </div>
                    </div>

                    <div class="mb-3 row">
                        <asp:Label ID="lblProducto" runat="server" Text="Producto:" CssClass="col-sm-2 col-form-label" />
                        <div class="col-sm-6">
                            <asp:DropDownList ID="ddlProducto" runat="server" CssClass="form-control" />
                        </div>
                        <div class="col-sm-2">
                            <asp:TextBox ID="txtCantidad" runat="server" CssClass="form-control" placeholder="Cantidad" />
                        </div>
                        <div class="col-sm-2">
                            <asp:Button ID="btnBuscarProducto" runat="server" Text="Agregar" CssClass="btn btn-primary" OnClick="btnBuscarProducto_Click" />
                        </div>
                    </div>

                    <div class="mb-3 row">
                        <asp:Label ID="lblListaProductos" runat="server" Text="Productos Seleccionados:" CssClass="col-sm-2 col-form-label" />
                        <div class="col-sm-10">
                            <asp:GridView ID="gvProductos" runat="server" CssClass="table table-striped" AutoGenerateColumns="false">
                                <Columns>
                                    <asp:BoundField DataField="producto.idProducto" HeaderText="ID" />
                                    <asp:BoundField DataField="producto.nombre" HeaderText="Nombre" />
                                    <asp:BoundField DataField="producto.cantidadComprada" HeaderText="Cantidad" />
                                    <asp:BoundField DataField="precio" HeaderText="Precio" />
                                    <asp:TemplateField>
                                        <ItemTemplate>
                                            <asp:Button ID="btnEliminar" runat="server" Text="Eliminar" CommandArgument='<%# Eval("producto.idProducto") %>' OnClick="btnEliminarProducto_Click" CssClass="btn btn-danger" />
                                        </ItemTemplate>
                                    </asp:TemplateField>
                                </Columns>
                            </asp:GridView>
                        </div>
                    </div>
                    <div class="mb-3 row">
                        <asp:Label ID="lblTotal" runat="server" Text="Total: $" CssClass="col-sm-2 col-form-label" />
                        <div class="col-sm-10">
                            <asp:Label ID="lblTotalValue" runat="server" CssClass="form-control" />
                        </div>
                    </div>
                </div>

                <div class="card-footer clearfix">
                    <asp:Button ID="btnRegresar" runat="server" Text="Regresar" CssClass="float-start btn btn-secondary" OnClick="btnRegresar_Click" />
                    <asp:Button ID="btnRegistrar" runat="server" Text="Registrar" CssClass="float-end btn btn-primary" OnClick="btnRegistrar_Click" />
                </div>

                <asp:Label ID="lblMensaje" runat="server" CssClass="text-danger" />
            </div>
        </div>
    </form>
</body>
</html>
</asp:Content>
