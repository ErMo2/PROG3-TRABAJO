<%@ Page Title="" Language="C#" MasterPageFile="~/ZAP3WA.Master" AutoEventWireup="true" CodeBehind="GestionarBancos.aspx.cs" Inherits="InterfacesTrabajoGrupal.GestionarBancos" %>

<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphScripts" runat="server">
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="cphContenido" runat="server">
    <div class="container">
        <div class="card">
            <h2>Registrar Banco
            </h2>
        </div>
        <hr />

        <div class="card-body">
            <div class="mb-3 row">
                <asp:Label ID="lblIdBanco" runat="server" Text="Id Banco:" CssClass="col-sm-2 col-form-label" />
                <div class="col-sm-4">
                    <asp:TextBox ID="txtIdBanco" runat="server" Enabled="false" CssClass="form-control" />
                </div>
            </div>

            <div class="mb-3 row">
                <asp:Label ID="lblNombreBanco" runat="server" Text="Nombre del Banco:" CssClass="col-sm-2 col-form-label" />
                <div class="col-sm-8">
                    <asp:TextBox ID="txtNombreBanco" runat="server" CssClass="form-control" />
                </div>
            </div>



            <div class="card-footer clearfix">
                <asp:Button ID="btnRegresar" runat="server" Text="Regresar"
                    CssClass="float-start btn btn-secondary" OnClick="btnRegresar_Click" />
                <asp:Button ID="btnRegistrar" runat="server" Text="Registrar"
                    CssClass="float-end btn btn-primary" OnClick="btnRegistrar_Click" />
            </div>

        </div>
    </div>
</asp:Content>
