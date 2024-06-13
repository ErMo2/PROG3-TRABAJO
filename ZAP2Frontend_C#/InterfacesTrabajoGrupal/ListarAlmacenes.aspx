<%@ Page Title="" Language="C#" MasterPageFile="~/ZAP3WA.Master" AutoEventWireup="true" CodeBehind="ListarAlmacenes.aspx.cs" Inherits="InterfacesTrabajoGrupal.ListarSucursal" %>

<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphScripts" runat="server">
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="cphContenido" runat="server">
 
    <!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Listado de Almacenes</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet" />
    <style>
        .container {
            margin-top: 20px;
        }
        .header-line {
            height: 2px;
            background-color: #ccc;
            margin: 10px 0;
        }
        .pagination a {
            margin: 0 2px;
            border-radius: 5px !important;
            border: 1px solid #007bff;
        }
        .pagination a:hover {
            background-color: #007bff;
            color: white;
        }
        .pagination .active a {
            background-color: #007bff !important;
            color: white !important;
        }
        .pagination .disabled a {
            color: grey;
            cursor: not-allowed;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Listado de Almacenes</h2>
        <div class="header-line"></div>
        <div class="container row">
            <div class="text-end p-3">
                <asp:LinkButton ID="lbRegistrarAlmacen" runat="server" CssClass="btn btn-success" Text="Registrar Almacén" OnClick="lbRegistrarAlmacen_Click"></asp:LinkButton>
            </div>
        </div>

        <div class="container row">
            <asp:GridView ID="gvAlmacenes" runat="server"
                AutoGenerateColumns="false"
                CssClass="table table-hover table-responsive"
                AllowPaging="true"
                PageSize="5"
                OnPageIndexChanging="gvAlmacenes_PageIndexChanging"
                OnRowCommand="gvAlmacenes_RowCommand">
                <Columns>
                    <asp:BoundField HeaderText="Id Almacén" DataField="id_almacen" />
                    <asp:BoundField HeaderText="Tipo de Almacén" DataField="tipoAlmacen" />
                    <asp:BoundField HeaderText="Capacidad Máxima de Productos" DataField="CapacidadMaximaProductos" />
                    <asp:BoundField HeaderText="Capacidad Actual de Productos" DataField="CapacidadActualProductos" />
                    <asp:BoundField HeaderText="Sucursal" DataField="sucursal.nombre" />
                    <asp:TemplateField HeaderText="Acciones">
                        <ItemTemplate>
                            <div class="btn-group" role="group">
                                <asp:LinkButton ID="lbVer" runat="server" CommandName="Ver" CommandArgument='<%# Eval("id_almacen") %>' Text="Ver" CssClass="btn btn-info btn-sm" />
                                <asp:LinkButton ID="lbModificar" runat="server" CommandName="Modificar" CommandArgument='<%# Eval("id_almacen") %>' Text="Modificar" CssClass="btn btn-primary btn-sm" />
                                <asp:LinkButton ID="lbEliminar" runat="server" CommandName="Eliminar" CommandArgument='<%# Eval("id_almacen") %>' Text="Eliminar" CssClass="btn btn-danger btn-sm" OnClientClick="return confirm('¿Está seguro de que desea eliminar este almacén?');" />
                            </div>
                        </ItemTemplate>
                    </asp:TemplateField>
                </Columns>
            </asp:GridView>
        </div>
    </div>

    <!-- Modal para mostrar los detalles del almacén -->
    <div class="modal fade" id="detallesAlmacenModal" tabindex="-1" role="dialog" aria-labelledby="detallesAlmacenLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="detallesAlmacenLabel">Detalles del Almacén</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <asp:Label ID="lblDetallesAlmacen" runat="server"></asp:Label>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
                </div>
            </div>
        </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
</asp:Content>
