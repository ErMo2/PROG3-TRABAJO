<%@ Page Title="" Language="C#" MasterPageFile="~/ZAP3WA.Master" AutoEventWireup="true" CodeBehind="ListarProductos.aspx.cs" Inherits="InterfacesTrabajoGrupal.GestionProducto" MaintainScrollPositionOnPostBack="true" %>

<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphScripts" runat="server">
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="cphContenido" runat="server">
    <link href="Diseño/DiseñoListarProductos.css" rel="stylesheet" />
    <div class="container mt-4">
        <h2 class="mb-4 text-center">Listado de Productos</h2>

        <div class="text-end mb-3">
            <asp:LinkButton ID="lbRegistrarProducto" runat="server" CssClass="btn btn-success"
                Text="<i class='fa-solid fa-plus pe-2'></i> Registrar Producto" OnClick="lbRegistrarProducto_Click" />
        </div>

        <h3>Productos Perecibles</h3>
        <asp:GridView ID="gvProductosPerecibles" runat="server" AutoGenerateColumns="false" CssClass="table table-hover table-responsive" AllowPaging="true" OnPageIndexChanging="gvProductosPerecibles_PageIndexChanging" PageSize="5">
            <Columns>
                <asp:BoundField HeaderText="Id" DataField="idProducto" />
                <asp:BoundField HeaderText="Nombre" DataField="nombre" />
                <asp:BoundField HeaderText="Descripcion" DataField="descripcion" />
                <asp:BoundField HeaderText="Fecha Vencimiento" DataField="fechVencimiento" />
                <asp:BoundField HeaderText="Tipo de Producto" DataField="tipo_producto_perecible" />
                <asp:TemplateField HeaderText="Acciones">
                    <ItemTemplate>
                        <asp:LinkButton ID="btnEdit" runat="server" CommandArgument='<%# Eval("idProducto") %>' Text="Editar" OnClick="EditProductPerecible_Click" CssClass="btn btn-primary" />
                        <asp:LinkButton ID="btnDelete" runat="server" CommandArgument='<%# Eval("idProducto") %>' Text="Eliminar" OnClick="DeleteProductPerecible_Click" CssClass="btn btn-danger" />
                        <asp:LinkButton ID="btnVer" runat="server" CommandArgument='<%# Eval("idProducto") %>' Text="Ver" OnClick="VerProductPerecible_Click" CssClass="btn btn-info" />
                    </ItemTemplate>
                </asp:TemplateField>
            </Columns>
        </asp:GridView>

        <h3>Electrodomésticos</h3>
        <asp:GridView ID="gvElectrodomesticos" runat="server" AutoGenerateColumns="false" CssClass="table table-hover table-responsive" AllowPaging="true" OnPageIndexChanging="gvElectrodomesticos_PageIndexChanging" PageSize="5">
            <Columns>
                <asp:BoundField HeaderText="Id" DataField="idProducto" />
                <asp:BoundField HeaderText="Nombre" DataField="nombre" />
                <asp:BoundField HeaderText="Descripcion" DataField="descripcion" />
                <asp:BoundField HeaderText="Tiene Garantia" DataField="tieneGarantia" />
                <asp:BoundField HeaderText="Tiempo Garantia" DataField="tiempoGarantia" />
                <asp:TemplateField HeaderText="Acciones">
                    <ItemTemplate>
                        <asp:LinkButton ID="btnEdit" runat="server" CommandArgument='<%# Eval("idProducto") %>' Text="Editar" OnClick="EditProductElectrodomestico_Click" CssClass="btn btn-primary" />
                        <asp:LinkButton ID="btnDelete" runat="server" CommandArgument='<%# Eval("idProducto") %>' Text="Eliminar" OnClick="DeleteProductElectrodomestico_Click" CssClass="btn btn-danger" />
                        <asp:LinkButton ID="btnVer" runat="server" CommandArgument='<%# Eval("idProducto") %>' Text="Ver" OnClick="VerProductElectrodomestico_Click" CssClass="btn btn-info" />
                    </ItemTemplate>
                </asp:TemplateField>
            </Columns>
        </asp:GridView>

        <h3>Limpieza y Hogar</h3>
        <asp:GridView ID="gvLimpiezayHogar" runat="server" AutoGenerateColumns="false" CssClass="table table-hover table-responsive" AllowPaging="true" OnPageIndexChanging="gvLimpieza_PageIndexChanging" PageSize="5">
            <Columns>
                <asp:BoundField HeaderText="Id" DataField="idProducto" />
                <asp:BoundField HeaderText="Nombre" DataField="nombre" />
                <asp:BoundField HeaderText="Descripcion" DataField="descripcion" />
                <asp:BoundField HeaderText="Unidad de Medida" DataField="unidadMedida" />
                <asp:BoundField HeaderText="Tipo de Producto" DataField="tipo" />
                <asp:TemplateField HeaderText="Acciones">
                    <ItemTemplate>
                        <asp:LinkButton ID="btnEdit" runat="server" CommandArgument='<%# Eval("idProducto") %>' Text="Editar" OnClick="EditProductLimpiezaHogar_Click" CssClass="btn btn-primary" />
                        <asp:LinkButton ID="btnDelete" runat="server" CommandArgument='<%# Eval("idProducto") %>' Text="Eliminar" OnClick="DeleteProductLimpiezaHogar_Click" CssClass="btn btn-danger" />
                        <asp:LinkButton ID="btnVer" runat="server" CommandArgument='<%# Eval("idProducto") %>' Text="Ver" OnClick="VerProductLimpiezaHogar_Click" CssClass="btn btn-info" />
                    </ItemTemplate>
                </asp:TemplateField>
            </Columns>
        </asp:GridView>
        <h3>Ropa</h3>
        <asp:GridView ID="gvRopa" runat="server" AutoGenerateColumns="false"
            CssClass="table table-hover table-responsive" AllowPaging="true"
            OnPageIndexChanging="gvRopa_PageIndexChanging" PageSize="5">
            <Columns>
                <asp:BoundField HeaderText="Id" DataField="idProducto" />
                <asp:BoundField HeaderText="Nombre" DataField="nombre" />
                <asp:BoundField HeaderText="Descripcion" DataField="descripcion" />
                <asp:BoundField HeaderText="Material" DataField="material" />
                <asp:TemplateField HeaderText="Acciones">
                    <ItemTemplate>
                        <asp:LinkButton ID="btnEdit" runat="server" CommandArgument='<%# Eval("idProducto") %>' Text="Editar" OnClick="EditProductRopa_Click" CssClass="btn btn-primary" />
                        <asp:LinkButton ID="btnDelete" runat="server" CommandArgument='<%# Eval("idProducto") %>' Text="Eliminar" OnClick="DeleteProductRopa_Click" CssClass="btn btn-danger" />
                        <asp:LinkButton ID="btnVer" runat="server" CommandArgument='<%# Eval("idProducto") %>' Text="Ver" OnClick="VerProductRopa_Click" CssClass="btn btn-info" />
                    </ItemTemplate>
                </asp:TemplateField>
            </Columns>
        </asp:GridView>
    </div>

    <!-- Modal for viewing product details -->
    <div class="modal fade" id="productModal" tabindex="-1" role="dialog" aria-labelledby="productModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="productModalLabel">Detalles del Producto</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <asp:Label ID="lblDetalles" runat="server" Text=""></asp:Label>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
                </div>
            </div>
        </div>
    </div>
</asp:Content>
