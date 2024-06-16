<%@ Page Title="" Language="C#" MasterPageFile="~/ZAP3WA.Master" AutoEventWireup="true" CodeBehind="GestionarEmpleadoArea.aspx.cs" Inherits="InterfacesTrabajoGrupal.EmpleadoArea" %>

<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphScripts" runat="server">
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="cphContenido" runat="server">
    <div class="card-header">
        <h2>Empleado de Area</h2>
    </div>
    <hr />
    <div class="card-body">

        <div class="mb-3 row">
            <asp:Label ID="lblIdEmpleado" runat="server" Text="Id Empleado:" CssClass="col-sm-2 col-form-label" />
            <div class="col-sm-4">
                <asp:TextBox ID="txtIdEmpleado" runat="server" Enabled="false" CssClass="form-control" />
            </div>
        </div>

        <div class="mb-3 row">
            <asp:Label ID="lblNombre" runat="server" Text="Nombre:" CssClass="col-sm-2 col-form-label" />
            <div class="col-sm-8">
                <asp:TextBox ID="txtNombre" runat="server" CssClass="form-control" />
            </div>
        </div>

        <div class="mb-3 row">
            <asp:Label ID="LblApellido_Paterno" runat="server" Text="Apellido Paterno:" CssClass="col-sm-2 col-form-label" />
            <div class="col-sm-8">
                <asp:TextBox ID="txtApellido_Paterno" runat="server" CssClass="form-control" />
            </div>
        </div>

        <div class="mb-3 row">
            <asp:Label ID="LblApellido_Materno" runat="server" Text="Apellido Materno:" CssClass="col-sm-2 col-form-label" />
            <div class="col-sm-8">
                <asp:TextBox ID="txtApellido_Materno" runat="server" CssClass="form-control" />
            </div>
        </div>

        <div class="mb-3 row">
            <asp:Label ID="lblTelefono" runat="server" Text="Telefono:" CssClass="col-sm-2 col-form-label" />
            <div class="col-sm-8">
                <asp:TextBox ID="txtTelefono" runat="server" CssClass="form-control" />
            </div>
        </div>

        <div class="mb-3 row">
            <asp:Label ID="lblEmail" runat="server" Text="Email:" CssClass="col-sm-2 col-form-label" />
            <div class="col-sm-8">
                <asp:TextBox ID="txtEmail" runat="server" CssClass="form-control" />
            </div>
        </div>

        <div class="mb-3 row">
            <asp:Label ID="lblTipoDocumento" runat="server" Text="Tipo de Documento:" CssClass="col-sm-2 col-form-label" />
            <div class="col-sm-8">
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" id="rbDni" runat="server" value="DNI" name="tipoDoc">
                    <label class="form-check-label" for="rbDni" runat="server">DNI</label>
                </div>
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" id="rbCarnet_Extranjeria" runat="server" value="CARNET DE EXTRANJERIA" name="tipoDoc">
                    <label class="form-check-label" for="rbCarnet_Extranjeria" runat="server">CARNET</label>
                </div>
            </div>
        </div>

        <div class="mb-3 row">
            <asp:Label ID="lblNumeroDocumento" runat="server" Text="Numero de Documento:" CssClass="col-sm-2 col-form-label" />
            <div class="col-sm-8">
                <asp:TextBox ID="txtNumeroDocumento" runat="server" CssClass="form-control" />
            </div>
        </div>

        <div class="mb-3 row">
            <asp:Label ID="lblGenero" runat="server" Text="Genero:" CssClass="col-sm-2 col-form-label" />
            <div class="col-sm-8">
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" id="rbMasculino" runat="server" value="M">
                    <label class="form-check-label" for="rbMasculino" runat="server">Masculino</label>
                </div>
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" id="rbFemenino" runat="server" value="F">
                    <label class="form-check-label" for="rbFemenino" runat="server">Femenino</label>
                </div>
            </div>
        </div>

        <div class="mb-3 row">
            <asp:Label ID="lblDireccion" runat="server" Text="Direccion del empleado:" CssClass="col-sm-2 col-form-label" />
            <div class="col-sm-8">
                <asp:TextBox ID="txtDireccion" runat="server" CssClass="form-control" />
            </div>
        </div>

        <div class="mb-3 row">
            <asp:Label ID="lblSalario" runat="server" Text="Salario del Empleado:" CssClass="col-sm-2 col-form-label" />
            <div class="col-sm-8">
                <asp:TextBox ID="txtSalario" runat="server" CssClass="form-control" />
            </div>
        </div>
        <div class="mb-3 row">
            <asp:Label ID="lblFechaContratacion" runat="server" Text="Fecha de Contratacion:" CssClass="col-sm-2 col-form-label" />
            <div class="col-sm-8">
                <input class="form-control" type="date" id="dtpFechaContratacion" runat="server">
            </div>
        </div>
        
        <div class="mb-3 row">
            <asp:Label ID="lblHorario" runat="server" Text="Horario:" CssClass="col-sm-2 col-form-label" />
            <div class="col-sm-8">
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" id="rbMañana" runat="server" value="MAÑANA" name="Horario">
                    <label class="form-check-label" for="rbMañana" runat="server">Mañana</label>
                </div>
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" id="rbNoche" runat="server" value="NOCHE" name="Horario">
                    <label class="form-check-label" for="rbNoche" runat="server">Noche</label>
                </div>
            </div>
        </div>

        <div class="mb-3 row">
            <asp:Label ID="lblContrato" runat="server" Text="Tipo de Contrato:" CssClass="col-sm-2 col-form-label" />
            <div class="col-sm-8">
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" id="rbTiempoParcial" runat="server" value="TiempoParcial" name="Contrato">
                    <label class="form-check-label" for="rbTiempoParcial" runat="server">TiempoParcial</label>
                </div>
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" id="rbTiempoCompleto" runat="server" value="TiempoCompleto" name="Contrato">
                    <label class="form-check-label" for="rbTiempoCompleto" runat="server">TiempoCompleto</label>
                </div>
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" id="rbContratoEspecial" runat="server" value="ContratoEspecial" name="Contrato">
                    <label class="form-check-label" for="rbContratoEspecial" runat="server">ContratoEspecial</label>
                </div>
            </div>
        </div>

        <div class="mb-3 row">
            <asp:Label ID="lblPuesto" runat="server" Text="Tipo de Puesto:" CssClass="col-sm-2 col-form-label" />
            <div class="col-sm-8">
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" id="rbEmpacador" runat="server" value="Empacador" name="Puesto">
                    <label class="form-check-label" for="rbEmpacador" runat="server">Empacador</label>
                </div>
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" id="rbConsultor" runat="server" value="Consultor" name="Puesto">
                    <label class="form-check-label" for="rbConsultor" runat="server">Consultor</label>
                </div>
            </div>
        </div>

        <div class="mb-3 row">
            <asp:Label ID="lblIdSupervisor" runat="server" Text="Supervisor:" CssClass="col-sm-2 col-form-label" />
            <div class="col-sm-8">
                <asp:TextBox ID="txtIdSupervisor" runat="server" CssClass="form-control" />
            </div>
        </div>
        <hr />

        <hr />
        <div class="card-footer clearfix">

            <asp:Button ID="btnRegresar" runat="server" Text="Regresar"
                CssClass="float-start btn btn-secondary" OnClick="btnRegresar_Click" />
            <asp:Button ID="btnRegistrar" runat="server" Text="Registrar"
                CssClass="float-end btn btn-primary" OnClick="btnRegistrar_Click" />
        </div>

    </div>
</asp:Content>
