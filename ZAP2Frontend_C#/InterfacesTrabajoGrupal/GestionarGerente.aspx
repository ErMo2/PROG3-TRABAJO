<%@ Page Title="" Language="C#" MasterPageFile="~/ZAP3WA.Master" AutoEventWireup="true" CodeBehind="GestionarGerente.aspx.cs" Inherits="InterfacesTrabajoGrupal.Gerente" %>

<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphScripts" runat="server">
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="cphContenido" runat="server">
    <div class="card-header">
        <h2>Gerente</h2>
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
            <asp:Label ID="LblApellidos" runat="server" Text="Apellido Paterno:" CssClass="col-sm-2 col-form-label" />
            <div class="col-sm-8">
                <asp:TextBox ID="txtApellidos" runat="server" CssClass="form-control" />
            </div>
        </div>

        <div class="mb-3 row">
            <asp:Label ID="Label1" runat="server" Text="Apellido Materno:" CssClass="col-sm-2 col-form-label" />
            <div class="col-sm-8">
                <asp:TextBox ID="TextBox1" runat="server" CssClass="form-control" />
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
                <asp:TextBox ID="TxtTipoDocumento" runat="server" CssClass="form-control" />
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
                <input class="form-control" type="date" id="dtpFechaNacimiento" runat="server">
            </div>
        </div>
        <div class="mb-3 row">
            <asp:Label ID="lblTurno" runat="server" Text="Turno del Empleado:" CssClass="col-sm-2 col-form-label" />
            <div class="col-sm-8">
                <asp:TextBox ID="txtTurno" runat="server" CssClass="form-control" />
            </div>
        </div>

        <div class="mb-3 row">
            <asp:Label ID="lblContrato" runat="server" Text="Contrato del Empleado:" CssClass="col-sm-2 col-form-label" />
            <div class="col-sm-8">
                <asp:TextBox ID="txtContrato" runat="server" CssClass="form-control" />
            </div>
        </div>
        <hr />

        <hr />
        <div class="card-footer clearfix">

            <asp:Button ID="Button1" runat="server" Text="Regresar"
                CssClass="float-start btn btn-secondary" OnClick="btnRegresar_Click" />
            <asp:Button ID="Button2" runat="server" Text="Registrar"
                CssClass="float-end btn btn-primary" OnClick="btnRegistrar_Click" />
        </div>

    </div>
</asp:Content>
