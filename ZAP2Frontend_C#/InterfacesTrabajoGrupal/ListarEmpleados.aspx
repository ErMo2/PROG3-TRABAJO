<%@ Page Title="" Language="C#" MasterPageFile="~/ZAP3WA.Master" AutoEventWireup="true" CodeBehind="ListarEmpleados.aspx.cs" Inherits="InterfacesTrabajoGrupal.ListarEmpleados" %>

<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphScripts" runat="server">
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="cphContenido" runat="server">
    <div class="container mt-4">
        <h2 class="mb-4 text-center">Listado de Empleados</h2>

        <div class="text-end mb-3">
            <asp:LinkButton ID="lbRegistrarEmpleado" runat="server" CssClass="btn btn-success"
                Text="<i class='fa-solid fa-plus pe-2'></i> Registrar Empleado" OnClick="lbRegistrarEmpleado_Click" />
        </div>

        <div class="card mb-4">
            <div class="card-header bg-info text-white">
                <h3 class="card-title">Empleados de Área</h3>
            </div>
            <div class="card-body">
                <asp:GridView ID="gvEmpleadosArea" runat="server" AutoGenerateColumns="False" CssClass="table table-hover table-responsive-sm table-striped">
                    <Columns>
                        <asp:BoundField DataField="idempleado" HeaderText="Id Empleado" />
                        <asp:BoundField DataField="nombre" HeaderText="Nombre" />
                        <asp:BoundField DataField="telefono" HeaderText="Teléfono" />
                        <asp:BoundField DataField="email" HeaderText="Email" />
                        <asp:BoundField DataField="sexo" HeaderText="Sexo" />
                        <asp:BoundField DataField="salario" HeaderText="Salario" />
                        <asp:BoundField DataField="horario" HeaderText="Horario" />
                        <asp:TemplateField>
                            <ItemTemplate>
                                <div class="btn-group" role="group">
                                    <asp:LinkButton ID="lbVerEmpleadoArea" runat="server" CommandName="VerEmpleadoArea" CommandArgument='<%# Eval("idempleado") %>' Text="Ver" CssClass="btn btn-info btn-sm" OnClick="VerArea_Click"/>
                                    <asp:LinkButton ID="lbModificarEmpleadoArea" runat="server" CommandName="ModificarEmpleadoArea" CommandArgument='<%# Eval("idempleado") %>' Text="Modificar" CssClass="btn btn-primary btn-sm" OnClick="lbModificarEmpleadoArea_Click"/>
                                    <asp:LinkButton ID="lbEliminarEmpleadoArea" runat="server" CommandName="EliminarEmpleadoArea" CommandArgument='<%# Eval("idempleado") %>' Text="Eliminar" CssClass="btn btn-danger btn-sm" OnClientClick="return confirm('¿Está seguro de que desea eliminar este empleado?');" OnClick="lbEliminarEmpleadoArea_Click"/>
                                </div>
                            </ItemTemplate>
                        </asp:TemplateField>
                    </Columns>
                </asp:GridView>
                <div id="detallesArea" runat="server" visible="false">
                    <h4>Detalles del Empleado de Área</h4>
                    <p><strong>Nombre:</strong>
                        <asp:Label ID="lblNombreArea" runat="server" /></p>
                    <p><strong>Teléfono:</strong>
                        <asp:Label ID="lblTelefonoArea" runat="server" /></p>
                    <p><strong>Email:</strong>
                        <asp:Label ID="lblEmailArea" runat="server" /></p>
                    <p><strong>Sexo:</strong>
                        <asp:Label ID="lblSexoArea" runat="server" /></p>
                    <p><strong>Salario:</strong>
                        <asp:Label ID="lblSalarioArea" runat="server" /></p>
                    <p><strong>Horario:</strong>
                        <asp:Label ID="lblHorarioArea" runat="server" /></p>
                </div>
            </div>
        </div>

        <div class="card mb-4">
            <div class="card-header bg-info text-white">
                <h3 class="card-title">Cajeros</h3>
            </div>
            <div class="card-body">
                <asp:GridView ID="gvCajeros" runat="server" AutoGenerateColumns="False" CssClass="table table-hover table-responsive-sm table-striped">
                    <Columns>
                        <asp:BoundField DataField="idempleado" HeaderText="Id Empleado" />
                        <asp:BoundField DataField="nombre" HeaderText="Nombre" />
                        <asp:BoundField DataField="telefono" HeaderText="Teléfono" />
                        <asp:BoundField DataField="email" HeaderText="Email" />
                        <asp:BoundField DataField="sexo" HeaderText="Sexo" />
                        <asp:BoundField DataField="salario" HeaderText="Salario" />
                        <asp:BoundField DataField="horario" HeaderText="Horario" />
                        <asp:TemplateField>
                            <ItemTemplate>
                                <div class="btn-group" role="group">
                                    <asp:LinkButton ID="lbVerEmpleadoCajero" runat="server" CommandName="VerCajero" CommandArgument='<%# Eval("idempleado") %>' Text="Ver" CssClass="btn btn-info btn-sm" OnClick="VerCajero_Click"/>
                                    <asp:LinkButton ID="lbModificarEmpleadoCajero" runat="server" CommandName="ModificarCajero" CommandArgument='<%# Eval("idempleado") %>' Text="Modificar" CssClass="btn btn-primary btn-sm" OnClick="lbModificarEmpleadoCajero_Click"/>
                                    <asp:LinkButton ID="lbEliminarEmpleadoCajero" runat="server" CommandName="EliminarCajero" CommandArgument='<%# Eval("idempleado") %>' Text="Eliminar" CssClass="btn btn-danger btn-sm" OnClientClick="return confirm('¿Está seguro de que desea eliminar este cajero?');" />
                                </div>
                            </ItemTemplate>
                        </asp:TemplateField>
                    </Columns>
                </asp:GridView>
                <div id="detallesCajero" runat="server" visible="false">
                    <h4>Detalles del Cajero</h4>
                    <p><strong>Nombre:</strong>
                        <asp:Label ID="lblNombreCajero" runat="server" /></p>
                    <p><strong>Teléfono:</strong>
                        <asp:Label ID="lblTelefonoCajero" runat="server" /></p>
                    <p><strong>Email:</strong>
                        <asp:Label ID="lblEmailCajero" runat="server" /></p>
                    <p><strong>Sexo:</strong>
                        <asp:Label ID="lblSexoCajero" runat="server" /></p>
                    <p><strong>Salario:</strong>
                        <asp:Label ID="lblSalarioCajero" runat="server" /></p>
                    <p><strong>Horario:</strong>
                        <asp:Label ID="lblHorarioCajero" runat="server" /></p>
                </div>
            </div>
        </div>

        <div class="card mb-4">
            <div class="card-header bg-info text-white">
                <h3 class="card-title">Supervisores</h3>
            </div>
            <div class="card-body">
                <asp:GridView ID="gvSupervisores" runat="server" AutoGenerateColumns="False" CssClass="table table-hover table-responsive-sm table-striped">
                    <Columns>
                        <asp:BoundField DataField="idempleado" HeaderText="Id Empleado" />
                        <asp:BoundField DataField="nombre" HeaderText="Nombre" />
                        <asp:BoundField DataField="telefono" HeaderText="Teléfono" />
                        <asp:BoundField DataField="email" HeaderText="Email" />
                        <asp:BoundField DataField="sexo" HeaderText="Sexo" />
                        <asp:BoundField DataField="salario" HeaderText="Salario" />
                        <asp:BoundField DataField="horario" HeaderText="Horario" />
                        <asp:TemplateField>
                            <ItemTemplate>
                                <div class="btn-group" role="group">
                                    <asp:LinkButton ID="lbVerEmpleadoSupervisor" runat="server" CommandName="VerSupervisor" CommandArgument='<%# Eval("idempleado") %>' Text="Ver" CssClass="btn btn-info btn-sm" OnClick="VerSupervisor_Click"/>
                                    <asp:LinkButton ID="lbModificarEmpleadoSupervisor" runat="server" CommandName="ModificarSupervisor" CommandArgument='<%# Eval("idempleado") %>' Text="Modificar" CssClass="btn btn-primary btn-sm" OnClick="lbModificarEmpleadoSupervisor_Click"/>
                                    <asp:LinkButton ID="lbEliminarEmpleadoSupervisor" runat="server" CommandName="EliminarSupervisor" CommandArgument='<%# Eval("idempleado") %>' Text="Eliminar" CssClass="btn btn-danger btn-sm" OnClientClick="return confirm('¿Está seguro de que desea eliminar este supervisor?');" />
                                </div>
                            </ItemTemplate>
                        </asp:TemplateField>
                    </Columns>
                </asp:GridView>
                <div id="detallesSupervisor" runat="server" visible="false">
                    <h4>Detalles del Supervisor</h4>
                    <p><strong>Nombre:</strong>
                        <asp:Label ID="lblNombreSupervisor" runat="server" /></p>
                    <p><strong>Teléfono:</strong>
                        <asp:Label ID="lblTelefonoSupervisor" runat="server" /></p>
                    <p><strong>Email:</strong>
                        <asp:Label ID="lblEmailSupervisor" runat="server" /></p>
                    <p><strong>Sexo:</strong>
                        <asp:Label ID="lblSexoSupervisor" runat="server" /></p>
                    <p><strong>Salario:</strong>
                        <asp:Label ID="lblSalarioSupervisor" runat="server" /></p>
                    <p><strong>Horario:</strong>
                        <asp:Label ID="lblHorarioSupervisor" runat="server" /></p>
                </div>
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
</asp:Content>
