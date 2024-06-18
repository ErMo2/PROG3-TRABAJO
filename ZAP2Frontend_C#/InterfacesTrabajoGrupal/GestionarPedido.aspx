<%@ Page Title="" Language="C#" MasterPageFile="~/ZAP3WA.Master" AutoEventWireup="true" CodeBehind="GestionarPedido.aspx.cs" Inherits="InterfacesTrabajoGrupal.GestionarPedido" %>

<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphScripts" runat="server">
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <script src="Scripts/ZAP2PROG/gestionarPedidos.js"></script>
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="cphContenido" runat="server">
    <div class="container">
        <div class="card">
            <div class="card-header">
                <h2>Registrar Pedido</h2>
            </div>
            <div class="card-body">
                <%--Información General--%>
                <div class="card border">
                    <div class="card-header bg-light">
                        <h5 class="card-title mb-0">Información General</h5>
                    </div>
                    <div class="card-body">
                        <div class="mb-3 row">
                            <asp:Label ID="lblIdPedido" runat="server" Text="Id del pedido:" CssClass="col-sm-2 col-form-label" />
                            <div class="col-sm-3">
                                <asp:TextBox ID="txtIdPedido" runat="server" Enabled="false" CssClass="form-control" />
                            </div>
                        </div>
                        <div class="mb-3 row">
                            <asp:Label ID="lblFecha" runat="server" Text="Fecha del Pedido:" CssClass="col-sm-2 col-form-label" />
                            <div class="col-sm-8">
                                <asp:TextBox ID="TextFechaPedido" runat="server" CssClass="form-control" TextMode="Date" Enabled="false"/>
                            </div>
                        </div>
                    </div>
                </div>

                <%--Detalle del Pedido--%>
                <div class="card border">
                    <div class="card-header bg-light">
                        <h5 class="card-title mb-0">Detalle del Pedido</h5>
                    </div>
                    <div class="card-body">
                        <div class="mb-3 row">
                            <asp:Label ID="lblIDProducto" runat="server" Text="ID del Producto:" CssClass="col-sm-2 col-form-label" />
                            <div class="col-sm-3">
                                <asp:TextBox ID="txtIDProducto" runat="server" Enabled="false" CssClass="form-control" />
                            </div>
                            <asp:Button ID="btnBuscarProducto" CssClass="btn btn-primary col-sm-2" runat="server" Text="Buscar Producto" OnClick="btnBuscarProducto_Click" />
                        </div>
                        <div class="mb-3 row">
                            <asp:Label ID="lblNombreProducto" runat="server" Text="Nombre:" CssClass="col-sm-2 col-form-label" />
                            <div class="col-sm-5">
                                <asp:TextBox ID="txtNombreProducto" runat="server" Enabled="false" CssClass="form-control" />
                            </div>
                        </div>
                        <div class="mb-3 row">
                            <asp:Label ID="lblPrecioUnitProducto" runat="server" Text="Precio Unitario(S/):" CssClass="col-sm-2 col-form-label" />
                            <div class="col-sm-3">
                                <asp:TextBox ID="txtPrecioUnitProducto" runat="server" CssClass="form-control" />
                            </div>
                        </div>
                        <div class="mb-3 row">
                            <asp:Label ID="lblCantidadUnidades" runat="server" Text="Cantidad:" CssClass="col-sm-2 col-form-label" />
                            <div class="col-sm-3">
                                <asp:TextBox ID="txtCantidadUnidades" runat="server" CssClass="form-control" />
                            </div>
                            <div class="col-sm-3">
                                <asp:LinkButton ID="lbAgregarLOV" CssClass="btn btn-success" runat="server" Text=" Agregar" OnClick="lbAgregarDetPed_Click" />
                            </div>
                        </div>
                        <div class="row">
                            <asp:GridView ID="gvDetallesPedidos" runat="server" AllowPaging="true" PageSize="5" AutoGenerateColumns="false" CssClass="table table-hover table-responsive table-striped" OnRowDataBound="gvDetallePedido_RowDataBound">
                                <Columns>
                                    <asp:BoundField HeaderText="Nombre Producto"/>
                                    <asp:BoundField HeaderText="Precio Unit." />
                                    <asp:BoundField HeaderText="Cant"/>
                                    <asp:BoundField HeaderText="precioTotal" />
                                    <asp:BoundField HeaderText="subtotal" />
                                    <asp:TemplateField>
                                        <ItemTemplate>
                                            <asp:LinkButton runat="server" Text="<i class='fa-solid fa-trash ps-2'></i>" OnClick="btnEliminarProducto_Click" CommandArgument='<%# Eval("id_DetallePedido") %>' />
                                        </ItemTemplate>
                                    </asp:TemplateField>
                                </Columns>
                            </asp:GridView>
                        </div>
                        <div class="row align-items-center justify-content-end">
                            <asp:Label ID="lblTotal" runat="server" Text="Total:" CssClass="col-form-label col-sm-2 text-end" />
                            <div class="col-sm-2">
                                <asp:TextBox ID="txtTotal" CssClass="form-control col-sm-2" Enabled="false" runat="server"></asp:TextBox>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="card-footer clearfix">
                <asp:Button ID="btnRegresar" runat="server" Text="Regresar"
                    CssClass="float-start btn btn-secondary" OnClick="btnRegresar_Click"/>
                <asp:Button ID="btnGuardar" runat="server" Text="Guardar"
                    CssClass="float-end btn btn-primary" OnClick="btnGuardar_Click" />
            </div>
        </div>
    </div>

    <asp:ScriptManager runat="server"></asp:ScriptManager>

    <div class="modal" id="form-modal-producto">
        <div class="modal-dialog modal-xl">
            <div class="modal-content">

                <div class="modal-header">
                    <h5 class="modal-title">Búsqueda de Productos</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>

                <div class="modal-body">
                    <asp:UpdatePanel runat="server">
                        <ContentTemplate>
                            <div class="container row pb-3 pt-3">
                                <div class="row align-items-center">
                                    <div class="col-auto">
                                        <asp:Label CssClass="form-label" runat="server" Text="Ingresar nombre del producto:"></asp:Label>
                                    </div>
                                    <div class="col-sm-3">
                                        <asp:TextBox CssClass="form-control" ID="txtNombreProductoModal" runat="server"></asp:TextBox>
                                    </div>
                                    <div class="col-sm-2">
                                        <asp:LinkButton ID="lbBusquedaProductoModal" runat="server" CssClass="btn btn-info" 
                                            Text="<i class='fa-solid fa-magnifying-glass pe-2'></i> Buscar" OnClick="lbBusquedaProductoModal_Click" />
                                    </div>
                                </div>
                            </div>
                            <div class="container row">
                                <asp:GridView ID="gvProductos" runat="server" AllowPaging="true" PageSize="5" AutoGenerateColumns="false"
                                    CssClass="table table-hover table-responsive table-striped" OnRowDataBound="gvProductos_RowDataBound">
                                    <Columns>
                                        <asp:BoundField HeaderText="Nombre del Producto"/>
                                        <asp:BoundField HeaderText="Descripción"/>
                                        <asp:TemplateField>
                                            <ItemTemplate>
                                                <asp:LinkButton class="btn btn-success" runat="server" Text="<i class='fa-solid fa-check ps-2'></i> Seleccionar" OnClick="btnSeleccionarProductoModal_Click" CommandArgument='<%# Eval("IdProducto") %>' />
                                            </ItemTemplate>
                                        </asp:TemplateField>
                                    </Columns>
                                </asp:GridView>
                            </div>
                        </ContentTemplate>
                    </asp:UpdatePanel>
                </div>
            </div>
        </div>
    </div>

</asp:Content>
