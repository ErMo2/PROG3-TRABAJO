<%@ Page Title="" Language="C#" MasterPageFile="~/ZAP3WA.Master" AutoEventWireup="true" CodeBehind="GestionarSucursales.aspx.cs" Inherits="InterfacesTrabajoGrupal.GestionarSucursales" %>

<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphScripts" runat="server">
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="cphContenido" runat="server">
    <div class="container">
        <div class="card">
            <h2>Registrar Sucursal
            </h2>
        </div>
        <hr />

        <div class="card-body">
            <div class="mb-3 row">
                <asp:Label ID="lblIdSucursal" runat="server" Text="Id Sucursal:" CssClass="col-sm-2 col-form-label" />
                <div class="col-sm-4">
                    <asp:TextBox ID="txtSucursal" runat="server" Enabled="false" CssClass="form-control" />
                </div>
            </div>

            <div class="mb-3 row">
                <asp:Label ID="lblUbicacionSucursal" runat="server" Text="Ubicacion de la Sucursal:" CssClass="col-sm-2 col-form-label" />
                <div class="col-sm-8">
                    <asp:TextBox ID="txtUbicacionSucursal" runat="server" CssClass="form-control" />
                </div>
            </div>


            <div class="mb-3 row">
                <asp:Label ID="lblTamanio" runat="server" Text="Tamanio en metros cuadrados:" CssClass="col-sm-2 col-form-label" />
                <div class="col-sm-8">
                    <asp:TextBox ID="txtTamanio" runat="server" CssClass="form-control" />
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
