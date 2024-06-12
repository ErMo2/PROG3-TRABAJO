<%@ Page Title="" Language="C#" MasterPageFile="~/SoftProg.Master" AutoEventWireup="true" CodeBehind="SeleccionarTipoDeEmpleado.aspx.cs" Inherits="InterfacesTrabajoGrupal.SeleccionarTipoDeEmpleado" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphScripts" runat="server">
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="cphContenido" runat="server">
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">

      <div class="container text-center mt-5">
        <h2>Seleccionar Tipo de Empleado</h2>
        <div class="row justify-content-center mt-4">
            <div class="col-md-4 mb-3">
                <asp:Button ID="lblGerente" class="btn btn-outline-primary btn-lg w-100"  runat="server" Text="Gerente" OnClick="lblGerente_Click"/>
            </div>
            <div class="col-md-4 mb-3">
                <asp:Button ID="lblEmpleadoArea" class="btn btn-outline-primary btn-lg w-100"  runat="server" Text="Empleado de Area" OnClick="lblEmpleadoArea_Click"/>

            </div>
            <div class="col-md-4 mb-3">
                    <asp:Button ID="lblCajero" class="btn btn-outline-primary btn-lg w-100"  runat="server" Text="Cajero" OnClick="lblCajero_Click"/>
            </div>
        </div>
    </div>
</asp:Content>
