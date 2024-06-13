<%@ Page Title="" Language="C#" MasterPageFile="~/ZAP3WA.Master" AutoEventWireup="true" CodeBehind="ListarEmpleados.aspx.cs" Inherits="InterfacesTrabajoGrupal.ListarEmpleados" %>

<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphScripts" runat="server">
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
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
                                    <asp:LinkButton ID="lbVerArea" runat="server" CommandName="VerArea" CommandArgument='<%# Eval("idempleado") %>' Text="Ver" CssClass="btn btn-info btn-sm" />
                                    <asp:LinkButton ID="lbModificarArea" runat="server" CommandName="ModificarArea" CommandArgument='<%# Eval("idempleado") %>' Text="Modificar" CssClass="btn btn-primary btn-sm" />
                                    <asp:LinkButton ID="lbEliminarArea" runat="server" CommandName="EliminarArea" CommandArgument='<%# Eval("idempleado") %>' Text="Eliminar" CssClass="btn btn-danger btn-sm" OnClientClick="return confirm('¿Está seguro de que desea eliminar este empleado?');" />
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
                                    <asp:LinkButton ID="lbVerCajero" runat="server" CommandName="VerCajero" CommandArgument='<%# Eval("idempleado") %>' Text="Ver" CssClass="btn btn-info btn-sm" />
                                    <asp:LinkButton ID="lbModificarCajero" runat="server" CommandName="ModificarCajero" CommandArgument='<%# Eval("idempleado") %>' Text="Modificar" CssClass="btn btn-primary btn-sm" />
                                    <asp:LinkButton ID="lbEliminarCajero" runat="server" CommandName="EliminarCajero" CommandArgument='<%# Eval("idempleado") %>' Text="Eliminar" CssClass="btn btn-danger btn-sm" OnClientClick="return confirm('¿Está seguro de que desea eliminar este cajero?');" />
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
                                    <asp:LinkButton ID="lbVerSupervisor" runat="server" CommandName="VerSupervisor" CommandArgument='<%# Eval("idempleado") %>' Text="Ver" CssClass="btn btn-info btn-sm" />
                                    <asp:LinkButton ID="lbModificarSupervisor" runat="server" CommandName="ModificarSupervisor" CommandArgument='<%# Eval("idempleado") %>' Text="Modificar" CssClass="btn btn-primary btn-sm" />
                                    <asp:LinkButton ID="lbEliminarSupervisor" runat="server" CommandName="EliminarSupervisor" CommandArgument='<%# Eval("idempleado") %>' Text="Eliminar" CssClass="btn btn-danger btn-sm" OnClientClick="return confirm('¿Está seguro de que desea eliminar este supervisor?');" />
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
</asp:Content>
