<%@ Page Title="" Language="C#" MasterPageFile="~/ZAP3WA.Master" AutoEventWireup="true" CodeBehind="GestionarFacturaVenta.aspx.cs" Inherits="InterfacesTrabajoGrupal.FacturaVenta" %>

<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphScripts" runat="server">
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="cphContenido" runat="server">
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Registrar Factura de Venta</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet" />
</head>
<body>
    <form id="form1">
      <asp:ScriptManager ID="ScriptManager1" runat="server" />

        <div class="container mt-4">
            <div class="card">
                <div class="card-header">
                    <h2>Registrar Factura de Venta</h2>
                </div>
                <div class="card-body">
                    <div class="mb-3 row">
                        <asp:Label ID="lblNumeroFactura" runat="server" Text="Factura de Venta:" CssClass="col-sm-2 col-form-label" />
                        <div class="col-sm-4">
                        </div>
                    </div>
                    <div class="mb-3 row">
                        <asp:Label ID="lblFechaEmision" runat="server" Text="Fecha de Emisión:" CssClass="col-sm-2 col-form-label" />
                        <div class="col-sm-4">
                            <asp:TextBox ID="dtpFechaEmision" runat="server" CssClass="form-control" TextMode="Date" />
                        </div>
                    </div>
                   
                 <div class="mb-3 row">
                        <asp:Label ID="lblBuscarPersonaJuridica" runat="server" Text="Buscar Persona Jurídica:" CssClass="col-sm-2 col-form-label" />
                        <div class="col-sm-6">
                            <asp:TextBox ID="txtNombrePersonaJuridica" runat="server" CssClass="form-control" />
                        </div>
                        <div class="col-sm-4">
                            <asp:Button ID="btnBuscarPersonaJuridica" runat="server" Text="Buscar" CssClass="btn btn-info" OnClick="btnBuscarPersonaJuridica_Click" />
                        </div>
                    </div>
                    <div class="mb-3 row">
                        <asp:Label ID="lblPersonaJuridica" runat="server" Text="Persona Jurídica:" CssClass="col-sm-2 col-form-label" />
                        <div class="col-sm-8">
                            <asp:DropDownList ID="ddlPersonaJuridica" runat="server" CssClass="form-control" AutoPostBack="true" OnSelectedIndexChanged="ddlPersonaJuridica_SelectedIndexChanged">
                            </asp:DropDownList>
                        </div>
                    </div>
                  


                    <div class="mb-3 row">
                        <asp:Label ID="lblSucursal" runat="server" Text="Sucursal:" CssClass="col-sm-2 col-form-label" />
                        <div class="col-sm-8">
                            <asp:DropDownList ID="ddlSucursal" runat="server" CssClass="form-control" AutoPostBack="true" OnSelectedIndexChanged="ddlSucursal_SelectedIndexChanged">
                            </asp:DropDownList>
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
                           <asp:Label ID="lblTarjeta" runat="server" Text="Tarjeta:" CssClass="col-sm-2 col-form-label" />
                           <div class="col-sm-6">
                               <asp:DropDownList ID="ddlTarjetas" runat="server" CssClass="form-control" />
                           </div>
                       </div>


                            <asp:UpdatePanel ID="UpdatePanel1" runat="server">
                                    <ContentTemplate>
                    <div class="mb-3 row">
                        <asp:Label ID="lblProducto" runat="server" Text="Producto:" CssClass="col-sm-2 col-form-label" />
                        <div class="col-sm-8">
                            <asp:DropDownList ID="ddlProducto" runat="server" CssClass="form-control">
                            </asp:DropDownList>
                        </div>
                    </div>
                    <div class="mb-3 row">
                        <asp:Label ID="lblCantidad" runat="server" Text="Cantidad:" CssClass="col-sm-2 col-form-label" />
                        <div class="col-sm-4">
                            <asp:TextBox ID="txtCantidad" runat="server" CssClass="form-control" />
                        </div>
                        <div class="col-sm-4">
                            <asp:Button ID="btnAgregarProducto" runat="server" Text="Agregar Producto" CssClass="btn btn-success" OnClick="btnAgregarProducto_Click" />
                        </div>
                    </div>
            
             
                    <h3>Productos Agregados</h3>
                    <asp:GridView ID="gvProductosSeleccionados" runat="server" AutoGenerateColumns="False" CssClass="table table-striped">
                        <Columns>
                            <asp:BoundField DataField="idProducto" HeaderText="Producto" />
                            <asp:BoundField DataField="descripcion" HeaderText="Descripción" />
                            <asp:BoundField DataField="cantidadComprada" HeaderText="Cantidad" />
                            <asp:BoundField DataField="prodPrecio.precio" HeaderText="Precio Unitario" DataFormatString="{0:C}" />
                            <asp:TemplateField>
                                <ItemTemplate>
                                    <asp:Button ID="btnEliminarProducto" runat="server" Text="Eliminar" CommandArgument='<%# Container.DataItemIndex %>' OnClick="btnEliminarProducto_Click" CssClass="btn btn-danger" />
                                </ItemTemplate>
                            </asp:TemplateField>
                        </Columns>
                    </asp:GridView>

                    <div class="mb-3 row">
                        <asp:Label ID="lblTotalTexto" runat="server" Text="Total:" CssClass="col-sm-2 col-form-label" />
                        <div class="col-sm-4">
                            <asp:Label ID="lblTotal" runat="server" CssClass="form-control-plaintext" />
                        </div>
                    </div>
                </div>
                                            </ContentTemplate>
 
            </asp:UpdatePanel>

                <div class="card-footer">
                    <asp:Button ID="btnRegistrar" runat="server" Text="Registrar Factura" CssClass="btn btn-primary float-right" OnClick="btnRegistrar_Click" />
                    <asp:Button ID="btnRegresar" runat="server" Text="Regresar" CssClass="btn btn-secondary float-left" OnClick="btnRegresar_Click" />
                </div>
            </div>
        </div>
    </form>
</body>
</html>

</asp:Content>
