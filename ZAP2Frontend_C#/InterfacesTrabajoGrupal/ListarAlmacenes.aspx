<%@ Page Title="" Language="C#" MasterPageFile="~/ZAP3WA.Master" AutoEventWireup="true" CodeBehind="ListarAlmacenes.aspx.cs" Inherits="InterfacesTrabajoGrupal.ListarSucursal" %>

<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphScripts" runat="server">
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="cphContenido" runat="server">
    <!DOCTYPE html>
    <html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <title>Listado de Almacenes</title>

        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
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
                    <asp:LinkButton ID="lbRegistrarAlmacen" runat="server" CssClass="btn btn-success" Text="Registrar Almacen" OnClick="lbRegistrarAlmacen_Click"></asp:LinkButton>
                </div>
            </div>

            <div class="container row">
                <asp:GridView ID="gvAlmacenes" runat="server"
                    AutoGenerateColumns="false"
                    CssClass="table table-hover table-responsive"
                    AllowPaging="true"
                    PageSize="5"
                    OnPageIndexChanging="gvAlmacenes_PageIndexChanging">
                    <Columns>
                        <asp:BoundField HeaderText="IdAlmacen" DataField="id_almacen" />
                        <asp:BoundField HeaderText="Tipo de Almacen" DataField="tipoAlmacen" />
                        <asp:BoundField HeaderText="Capacidad maxima de Productos" DataField="CapacidadMaximaProductos" />
                        <asp:BoundField HeaderText="Capacidad actual de Productos" DataField="CapacidadActualProductos" />
                        <asp:BoundField HeaderText="Sucursal" DataField="sucursal.id_sucursal" />
                    </Columns>
                </asp:GridView>
            </div>
        </div>
    </body>
    </html>
</asp:Content>
