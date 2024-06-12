<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Empleado.aspx.cs" Inherits="InterfacesTrabajoGrupal.Empleado" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
        <div>
             <h1>
                Registro de Empleado
            </h1>
            <style>
    .form-group {
        margin-bottom: 10px; /* Espacio entre cada grupo de etiqueta y textbox */
    }
</style>

<div class="form-group">
    <h3>
        <asp:Label ID="lblNombre" runat="server" Text="Nombre:"></asp:Label>
        <asp:TextBox ID="IngresaNombre" runat="server" OnTextChanged="IngresaNombre_TextChanged"></asp:TextBox>
    </h3>
</div>
<div class="form-group">
    <h3>
        <asp:Label ID="lblApellidoPaterno" runat="server" Text="Apellido Paterno:"></asp:Label>
        <asp:TextBox ID="IngresaAPellido" runat="server" OnTextChanged="IngresaApellidoPaternon"></asp:TextBox>
    </h3>
</div>
<div class="form-group">
    <h3>
        <asp:Label ID="Label1" runat="server" Text="Numero Telefonico:"></asp:Label>
        <asp:TextBox ID="TextBox1" runat="server" OnTextChanged="IngresaNumeroTelefonico"></asp:TextBox>
    </h3>
</div>
<div class="form-group">
    <h3>
        <asp:Label ID="Label2" runat="server" Text="Correo electronico:"></asp:Label>
        <asp:TextBox ID="TextBox2" runat="server" OnTextChanged="IngresaCorreoElectronico"></asp:TextBox>
    </h3>
</div>
<div class="form-group">
    <h3>
        <asp:Label ID="Label3" runat="server" Text="Tipo De Documento:"></asp:Label>
        <asp:TextBox ID="TextBox3" runat="server" OnTextChanged="IngresarTipoDocumento"></asp:TextBox>
    </h3>
</div>
<div class="form-group">
    <h3>
        <asp:Label ID="Label4" runat="server" Text="Numero Documento:"></asp:Label>
        <asp:TextBox ID="TextBox4" runat="server" OnTextChanged="IngresaNumeroDocumento"></asp:TextBox>
    </h3>
</div>
<div class="form-group">
    <h3>
        <asp:Label ID="Label5" runat="server" Text="Salario:"></asp:Label>
        <asp:TextBox ID="TextBox5" runat="server" OnTextChanged="Ingrese salario del empleado"></asp:TextBox>
    </h3>
</div>
            <div class="form-group">
    <h3>
        <asp:Label ID="Label6" runat="server" Text="Tipo de Contrato:"></asp:Label>
        <asp:TextBox ID="TextBox6" runat="server" OnTextChanged="Tipo de contrato que tiene el empleado"></asp:TextBox>
    </h3>
</div>
            <div class="form-group">
    <h3>
        <asp:Label ID="Label7" runat="server" Text="Fecha de Contratacion:"></asp:Label>
        <asp:TextBox ID="TextBox7" runat="server" OnTextChanged="Fecha en la que fue contratado el empleado"></asp:TextBox>
    </h3>
</div>
</div>
            <div class="form-group">
    <h3>
        <asp:Label ID="Label8" runat="server" Text="Turno de Horario:"></asp:Label>
        <asp:TextBox ID="TextBox8" runat="server" OnTextChanged="Hora a la que trabaja el empleado"></asp:TextBox>
    </h3>
</div>
            <!--Este codigo es para seleccionar si se quiere registrar empleado-->
                       <div style="text-align:center;">
                <asp:Button ID="Button1" runat="server" Text="Registrar Empleado" />
                <asp:Button ID="Button2" runat="server" Text="Cancelar" />
            </div>

        </div>
    </form>
</body>
</html>
