<%@ Page Title="" Language="C#" MasterPageFile="~/ZAP3WA.Master" AutoEventWireup="true" CodeBehind="ListarEgresosIngresos.aspx.cs" Inherits="InterfacesTrabajoGrupal.ListarEgresosIngresos" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphScripts" runat="server">
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="cphContenido" runat="server">
    <!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Listado de Empleados</title>

    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet" />
      <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet" />
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <style>
        .custom-background {
            background-color: antiquewhite; /* Cambia este valor al color que desees */
            height: 100vh; /* Asegúrate de que cubra toda la altura de la ventana */
            margin: 5000;
            padding: 1000;
        }
    </style>
</head>
<body>
    <form id="form1">
        <div class="container mt-4">
            <h2 class="mb-4 text-center">Listado de Empleados</h2>

            <div class="form-group row">
                <label for="dtpFechaIni" class="col-sm-2 col-form-label">Desde:</label>
                <div class="col-sm-10">
                    <input class="form-control" type="date" id="dtpFechaIni" runat="server">
                </div>
                <label for="dtpFechaFin" class="col-sm-2 col-form-label">Hasta:</label>
                <div class="col-sm-10">
                    <input class="form-control" type="date" id="dtpFechaFin" runat="server">
                </div>
            </div
            <div class="text-end mb-3">
                <asp:LinkButton ID="lbRegistrarEmpleado" runat="server" CssClass="btn btn-success"
                    Text="<i class='fa-solid fa-plus pe-2'></i> Registrar Empleado" OnClick="lbRegistrarEmpleado_Click" />
            </div>

            <!-- Empleados de Área -->
            <div class="card mb-4">
                <div class="card-header bg-info text-white">
                    <h3 class="card-title">Empleados de Área</h3>
                </div>
                <div class="card-body">
                    <asp:GridView ID="gvEmpleadosArea" runat="server"
                        AutoGenerateColumns="False"
                        CssClass="table table-hover table-responsive-sm table-striped"
                        AllowPaging="true"
                        PageSize="4"
                        OnPageIndexChanging="gvEmpleadosArea_PageIndexChanging"
                        OnRowCommand="gvEmpleadosArea_RowCommand"
                        OnRowDataBound="gvEmpleadosArea_RowDataBound">
                        <Columns>
                            <asp:BoundField DataField="id_documento" HeaderText="Id Documento" />
                            <asp:BoundField DataField="fecha_emision" HeaderText="Fecha" />
                            <asp:BoundField DataField="total" HeaderText="Total" />
                            <asp:TemplateField>
                                <ItemTemplate>
                                    <div class="btn-group" role="group">
                                        <asp:LinkButton ID="lbVerEmpleadoArea" runat="server" CommandName="VerEmpleadoArea" CommandArgument='<%# Eval("id_documento") %>' Text="Ver" CssClass="btn btn-info btn-sm" />
                                    </div>
                                </ItemTemplate>
                            </asp:TemplateField>
                        </Columns>
                    </asp:GridView>
                </div>
            </div>

            <!-- Cajeros -->
            <div class="card mb-4">
                <div class="card-header bg-info text-white">
                    <h3 class="card-title">Cajeros</h3>
                </div>
                <div class="card-body">
                    <asp:GridView ID="gvCajeros" runat="server"
                        AutoGenerateColumns="False"
                        CssClass="table table-hover table-responsive-sm table-striped"
                        AllowPaging="true"
                        PageSize="4"
                        OnPageIndexChanging="gvCajeros_PageIndexChanging"
                        OnRowCommand="gvCajeros_RowCommand"
                        OnRowDataBound="gvCajeros_RowDataBound">
                        <Columns>
                            <asp:BoundField DataField="idEmpleado" HeaderText="Id Empleado" />
                            <asp:BoundField DataField="nombre" HeaderText="Nombre" />
                            <asp:BoundField DataField="telefono" HeaderText="Teléfono" />
                            <asp:BoundField DataField="email" HeaderText="Email" />
                            <asp:BoundField HeaderText="Sexo" />
                            <asp:BoundField DataField="salario" HeaderText="Salario" />
                            <asp:BoundField DataField="horario" HeaderText="Horario" />
                            <asp:TemplateField>
                                <ItemTemplate>
                                    <div class="btn-group" role="group">
                                        <asp:LinkButton ID="lbVerEmpleadoCajero" runat="server" CommandName="VerCajero" CommandArgument='<%# Eval("idEmpleado") %>' Text="Ver" CssClass="btn btn-info btn-sm" />
                                        <asp:LinkButton ID="lbModificarEmpleadoCajero" runat="server" CommandName="ModificarCajero" CommandArgument='<%# Eval("idEmpleado") %>' Text="Modificar" CssClass="btn btn-primary btn-sm" />
                                        <asp:LinkButton ID="lbEliminarEmpleadoCajero" runat="server" CommandName="EliminarCajero" CommandArgument='<%# Eval("idEmpleado") %>' Text="Eliminar" CssClass="btn btn-danger btn-sm" OnClientClick="return confirm('¿Está seguro de que desea eliminar este cajero?');" />
                                    </div>
                                </ItemTemplate>
                            </asp:TemplateField>
                        </Columns>
                    </asp:GridView>
                </div>
            </div>

            <!-- Supervisores -->
            <div class="card mb-4">
                <div class="card-header bg-info text-white">
                    <h3 class="card-title">Supervisores</h3>
                </div>
                <div class="card-body">
                    <asp:GridView ID="gvSupervisores" runat="server"
                        AutoGenerateColumns="False"
                        CssClass="table table-hover table-responsive-sm table-striped"
                        AllowPaging="true"
                        PageSize="4"
                        OnPageIndexChanging="gvSupervisores_PageIndexChanging"
                        OnRowCommand="gvSupervisores_RowCommand"
                        OnRowDataBound="gvSupervisores_RowDataBound">
                        <Columns>
                            <asp:BoundField DataField="idEmpleado" HeaderText="Id Empleado" />
                            <asp:BoundField DataField="nombre" HeaderText="Nombre" />
                            <asp:BoundField DataField="telefono" HeaderText="Teléfono" />
                            <asp:BoundField DataField="email" HeaderText="Email" />
                            <asp:BoundField HeaderText="Sexo" />
                            <asp:BoundField DataField="salario" HeaderText="Salario" />
                            <asp:BoundField DataField="horario" HeaderText="Horario" />
                            <asp:TemplateField>
                                <ItemTemplate>
                                    <div class="btn-group" role="group">
                                        <asp:LinkButton ID="lbVerEmpleadoSupervisor" runat="server" CommandName="VerSupervisor" CommandArgument='<%# Eval("idEmpleado") %>' Text="Ver" CssClass="btn btn-info btn-sm" />
                                        <asp:LinkButton ID="lbModificarEmpleadoSupervisor" runat="server" CommandName="ModificarSupervisor" CommandArgument='<%# Eval("idEmpleado") %>' Text="Modificar" CssClass="btn btn-primary btn-sm" />
                                        <asp:LinkButton ID="lbEliminarEmpleadoSupervisor" runat="server" CommandName="EliminarSupervisor" CommandArgument='<%# Eval("idEmpleado") %>' Text="Eliminar" CssClass="btn btn-danger btn-sm" OnClientClick="return confirm('¿Está seguro de que desea eliminar este supervisor?');" />
                                    </div>
                                </ItemTemplate>
                            </asp:TemplateField>
                        </Columns>
                    </asp:GridView>
                </div>
            </div>
        </div>

        <!-- Modal para ver los datos en una pantalla -->
        <div class="modal fade" id="verEmpleadoModal" tabindex="-1" aria-labelledby="verEmpleadoModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="verEmpleadoModalLabel">Detalles del Empleado</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <asp:Label ID="lblDetallesEmpleado" runat="server" Text=""></asp:Label>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
                    </div>
                </div>
            </div>
        </div>
    </form>
</body>
    </html>
</asp:Content>
