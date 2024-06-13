<%@ Page Title="" Language="C#" MasterPageFile="~/ZAP3WA.Master" AutoEventWireup="true" CodeBehind="GestionarClientes.aspx.cs" Inherits="InterfacesTrabajoGrupal.GestionarClientes" %>

<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphScripts" runat="server">
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="cphContenido" runat="server">
    <div class="container mt-4">
        <div class="card">
            <div class="card-header">
                <h2>Registrar Cliente</h2>
            </div>
            <div class="card-body">
                <div class="mb-3 row">
                    <asp:Label ID="lblIdCliente" runat="server" Text="Id Cliente:" CssClass="col-sm-2 col-form-label" />
                    <div class="col-sm-4">
                        <asp:TextBox ID="txtIdCliente" runat="server" Enabled="false" CssClass="form-control" />
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
                        <asp:TextBox ID="txtApellidoPaterno" runat="server" CssClass="form-control" />
                    </div>
                </div>

                <div class="mb-3 row">
                    <asp:Label ID="Label1" runat="server" Text="Apellido Materno:" CssClass="col-sm-2 col-form-label" />
                    <div class="col-sm-8">
                        <asp:TextBox ID="txtApellidoMaterno" runat="server" CssClass="form-control" />
                    </div>
                </div>

                <div class="mb-3 row">
                    <asp:Label ID="lblTelefono" runat="server" Text="Teléfono:" CssClass="col-sm-2 col-form-label" />
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
                        <asp:DropDownList ID="ddlTipoDocumento" runat="server" CssClass="form-control">
                            <asp:ListItem Text="DNI" Value="DNI"></asp:ListItem>
                            <asp:ListItem Text="Carnet de Extranjería" Value="CARNET_EXTRANJERIA"></asp:ListItem>
                        </asp:DropDownList>
                    </div>
                </div>

                <div class="mb-3 row">
                    <asp:Label ID="lblDni" runat="server" Text="DNI:" CssClass="col-sm-2 col-form-label" />
                    <div class="col-sm-8">
                        <asp:TextBox ID="txtDNI" runat="server" CssClass="form-control" />
                    </div>
                </div>

                <div class="mb-3 row">
                    <asp:Label ID="lblNumeroDocumento" runat="server" Text="Número de Documento:" CssClass="col-sm-2 col-form-label" />
                    <div class="col-sm-8">
                        <asp:TextBox ID="txtNumeroDocumento" runat="server" CssClass="form-control" />
                    </div>
                </div>

                <div class="mb-3 row">
                    <asp:Label ID="lblGenero" runat="server" Text="Género:" CssClass="col-sm-2 col-form-label" />
                    <div class="col-sm-8">
                        <asp:DropDownList ID="ddlGenero" runat="server" CssClass="form-control">
                            <asp:ListItem Text="Masculino" Value="M"></asp:ListItem>
                            <asp:ListItem Text="Femenino" Value="F"></asp:ListItem>
                        </asp:DropDownList>
                    </div>
                </div>

                <div class="mb-3 row">
                    <asp:Label ID="lblDireccion" runat="server" Text="Dirección del Cliente:" CssClass="col-sm-2 col-form-label" />
                    <div class="col-sm-8">
                        <asp:TextBox ID="txtDireccion" runat="server" CssClass="form-control" />
                    </div>
                </div>
            </div>

            <div class="card-footer clearfix">
                <asp:Button ID="btnRegresar" runat="server" Text="Regresar" CssClass="float-start btn btn-secondary" OnClick="btnRegresar_Click" />
                <asp:Button ID="btnRegistrar" runat="server" Text="Registrar" CssClass="float-end btn btn-primary" OnClick="btnRegistrar_Click" />
            </div>
        </div>
    </div>
</asp:Content>

