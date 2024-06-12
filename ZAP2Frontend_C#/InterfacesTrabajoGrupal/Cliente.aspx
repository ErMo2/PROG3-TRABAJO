<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="WebForm1.aspx.cs" Inherits="InterfacesTrabajoGrupal.WebForm1" %>

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
                <asp:Label ID="Label5" runat="server" Text="Registrar Cliente"></asp:Label>

            </h1>
            <h3>
            <asp:Label ID="lblNombre" runat="server" Text="Nombre:"></asp:Label>
            <asp:TextBox ID="IngresaNombre" runat="server" OnTextChanged="IngresaNombre_TextChanged"></asp:TextBox>
                </h3>
 
            <h3>
            <asp:Label ID="Label6" runat="server" Text="Dni:"></asp:Label>
            <asp:TextBox ID="TextBox5" runat="server" OnTextChanged="IngresaNombre_TextChanged"></asp:TextBox>
            </h3>

            <h3>
            <asp:Label ID="lblApellidoPaterno" runat="server" Text="Apellido Paterno:"></asp:Label>
            <asp:TextBox ID="IngresaAPellido" runat="server" OnTextChanged="IngresaApellidoPaternon"></asp:TextBox>

                </h3>
            <h3>
            <asp:Label ID="Label1" runat="server" Text="Numero Telefonico:"></asp:Label>
            <asp:TextBox ID="TextBox1" runat="server" OnTextChanged="IngresaNumeroTelefonico"></asp:TextBox>
          
                </h3>
            <h3>
            <asp:Label ID="Label2" runat="server" Text="Correo electronico:"></asp:Label>
            <asp:TextBox ID="TextBox2" runat="server" OnTextChanged="IngresaCorreoElectronico"></asp:TextBox>

            </h3>
            <h3>

            <asp:Label ID="Label3" runat="server" Text="Tipo De Documento:"></asp:Label>
            <asp:TextBox ID="TextBox3" runat="server" OnTextChanged="IngresarTipoDocumento"></asp:TextBox

                </h3>
            <h3>
            <asp:Label ID="Label4" runat="server" Text="Numero Documento:"></asp:Label>
            <asp:TextBox ID="TextBox4" runat="server" OnTextChanged="IngresaNumeroDocumento"></asp:TextBox>
            </h3>
           <!--Aqui se solocan la opciones que deseo guardar--> 
            <div style="text-align:center;">
                <div style="display:inline-block;">
                    <asp:Button ID="Button2" runat="server" Text="Registrar Cliente"/>
                </div>
                <div style="display:inline-block;">
                    <asp:Button ID="Button3" runat="server" Text="Cancelar"/>
                </div>
            </div>

            </div>
    </form>
</body>
</html>
