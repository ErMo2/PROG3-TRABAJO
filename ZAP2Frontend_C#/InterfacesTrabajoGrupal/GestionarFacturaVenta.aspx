<%@ Page Title="" Language="C#" MasterPageFile="~/ZAP3WA.Master" AutoEventWireup="true" CodeBehind="GestionarFacturaVenta.aspx.cs" Inherits="InterfacesTrabajoGrupal.FacturaVenta" %>

<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphScripts" runat="server">
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="cphContenido" runat="server">

 <!
 <!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head >
    <title>Registrar Factura de Venta</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet" />
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
    <form id="form1">
        <div class="container mt-4">
            <div class="card">
                <div class="card-header">
                    <h2>Registrar Factura de Venta</h2>
                </div>
                <div class="card-body">
                    <div class="mb-3 row">
                        <asp:Label ID="Label1" runat="server" Text="Número de Factura:" CssClass="col-sm-2 col-form-label" />
                        <div class="col-sm-4">
                            <asp:TextBox ID="TextBox1" runat="server" CssClass="form-control" />
                        </div>
                    </div>

                    <div class="mb-3 row">
                        <asp:Label ID="Label2" runat="server" Text="Fecha de Emisión:" CssClass="col-sm-2 col-form-label" />
                        <div class="col-sm-4">
                            <input type="date" id="Date1" runat="server" class="form-control" />
                        </div>
                    </div>

                    <div class="mb-3 row">
                        <asp:Label ID="Label3" runat="server" Text="RUC:" CssClass="col-sm-2 col-form-label" />
                        <div class="col-sm-4">
                            <asp:TextBox ID="txtRUC" runat="server" CssClass="form-control" />
                        </div>
                    </div>

                    <div class="mb-3 row">
                        <asp:Label ID="lblPersonaJuridica" runat="server" Text="Persona Jurídica:" CssClass="col-sm-2 col-form-label" />
                        <div class="col-sm-8">
                            <asp:DropDownList ID="ddlPersonaJuridica" runat="server" CssClass="form-control">
                            </asp:DropDownList>
                        </div>
                    </div>

                    <div class="mb-3 row">
                        <asp:Label ID="lblProducto" runat="server" Text="Producto:" CssClass="col-sm-2 col-form-label" />
                        <div class="col-sm-4">
                            <asp:DropDownList ID="ddlProducto" runat="server" CssClass="form-control">
                            </asp:DropDownList>
                        </div>
                        <div class="col-sm-2">
                            <asp:TextBox ID="txtCantidad" runat="server" CssClass="form-control" placeholder="Cantidad" />
                        </div>
                        <div class="col-sm-2">
                            <asp:Button ID="btnAgregarProducto" runat="server" Text="Agregar" CssClass="btn btn-primary" OnClick="btnAgregarProducto_Click" />
                        </div>
                    </div>

                    <div class="mb-3 row">
                        <asp:Label ID="lblSucursal" runat="server" Text="Sucursal:" CssClass="col-sm-2 col-form-label" />
                        <div class="col-sm-8">
                            <asp:DropDownList ID="ddlSucursal" runat="server" CssClass="form-control">
                            </asp:DropDownList>
                        </div>
                    </div>

                  <h3>Productos Agregados</h3>
                    <asp:GridView ID="gvProductosSeleccionados" runat="server" AutoGenerateColumns="False" CssClass="table table-striped mt-4">
                        <Columns>
                            <asp:BoundField DataField="Nombre" HeaderText="Producto" />
                            <asp:BoundField DataField="Cantidad" HeaderText="Cantidad" />
                            <asp:BoundField DataField="Precio" HeaderText="Precio Unitario" DataFormatString="{0:C}" />
                            <asp:BoundField DataField="Total" HeaderText="Total" DataFormatString="{0:C}" />
                            <asp:TemplateField>
                                <ItemTemplate>
                                    <asp:Button ID="btnEliminarProducto" runat="server" CommandArgument='<%# Container.DataItemIndex %>' Text="Eliminar" CssClass="btn btn-danger btn-sm" OnClick="btnEliminarProducto_Click" />
                                </ItemTemplate>
                            </asp:TemplateField>
                        </Columns>
                    </asp:GridView>
                </div>
                </div>

                <div class="card-footer clearfix">
                    <asp:Button ID="btnRegresar" runat="server" Text="Regresar" CssClass="float-start btn btn-secondary" OnClick="btnRegresar_Click" />
                    <asp:Button ID="btnRegistrar" runat="server" Text="Registrar" CssClass="float-end btn btn-primary" OnClick="btnRegistrar_Click" />
                </div>
            </div>
        </div>
    </form>
</body>
</html>
</asp:Content>
