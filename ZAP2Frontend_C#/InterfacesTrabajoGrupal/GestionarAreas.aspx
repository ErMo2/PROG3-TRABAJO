<%@ Page Title="" Language="C#" MasterPageFile="~/ZAP3WA.Master" AutoEventWireup="true" CodeBehind="GestionarAreas.aspx.cs" Inherits="InterfacesTrabajoGrupal.GestionarAreas" %>

<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphScripts" runat="server">
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="cphContenido" runat="server">
    <div class="container">
        <div class="card">
            <h2>Registrar Area
            </h2>
        </div>

        <hr />

        <div class="card-body">
            <div class="mb-3 row">
                <asp:Label ID="lblIdArea" runat="server" Text="Id Area:" CssClass="col-sm-2 col-form-label" />
                <div class="col-sm-4">
                    <asp:TextBox ID="txtIdArea" runat="server" Enabled="false" CssClass="form-control" />
                </div>
            </div>

            <div class="mb-3 row">
                <asp:Label ID="lblNombreArea" runat="server" Text="Nombre del Area:" CssClass="col-sm-2 col-form-label" />
                <div class="col-sm-8">
                    <asp:TextBox ID="txtNombreArea" runat="server" CssClass="form-control" />
                </div>
                <div class="col-sm-8">
                    <asp:Label ID="lblSucursal" runat="server" Text="Sucursal:" CssClass="col-sm-2 col-form-label" />
                    <asp:DropDownList ID="ddlSucursal" runat="server" CssClass="form-control"></asp:DropDownList>
                </div>
            </div>



        </div>

        <div class="card-footer clearfix">
            <asp:Button ID="btnRegresar" runat="server" Text="Regresar"
                CssClass="float-start btn btn-secondary" OnClick="btnRegresar_Click" />
            <asp:Button ID="btnRegistrar" runat="server" Text="Registrar"
                CssClass="float-end btn btn-primary" OnClick="btnRegistrar_Click" />
        </div>

    </div>

</asp:Content>
