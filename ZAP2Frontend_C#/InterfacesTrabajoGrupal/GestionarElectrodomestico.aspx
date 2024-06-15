<%@ Page Title="" Language="C#" MasterPageFile="~/ZAP3WA.Master" AutoEventWireup="true" CodeBehind="GestionarElectrodomestico.aspx.cs" Inherits="InterfacesTrabajoGrupal.Electrodomestico" %>

<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphScripts" runat="server">
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="cphContenido" runat="server">
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">

    <div class="container">
        <div class="card">
            <div class="card-header bg-primary text-white">
                <h2>Registrar Electrodoméstico</h2>
            </div>
            <div class="card-body">
                <div class="form-group row">
                    <label for="txtIdProducto" class="col-sm-2 col-form-label">Id Producto:</label>
                    <div class="col-sm-10">
                        <asp:TextBox ID="txtIdProducto" runat="server" CssClass="form-control" Enabled="false"></asp:TextBox>
                    </div>
                </div>

                <div class="form-group row">
                    <label for="txtNombreProducto" class="col-sm-2 col-form-label">Nombre del Producto:</label>
                    <div class="col-sm-10">
                        <asp:TextBox ID="txtNombreProducto" runat="server" CssClass="form-control"></asp:TextBox>
                    </div>
                </div>

                <div class="form-group row">
                    <label for="txtDescripcionProducto" class="col-sm-2 col-form-label">Descripción del Producto:</label>
                    <div class="col-sm-10">
                        <asp:TextBox ID="txtDescripcionProducto" runat="server" CssClass="form-control"></asp:TextBox>
                    </div>
                </div>


                <div class="form-group row">
                    <label for="txtModelo" class="col-sm-2 col-form-label">Modelo:</label>
                    <div class="col-sm-10">
                        <asp:TextBox ID="txtModelo" runat="server" CssClass="form-control"></asp:TextBox>
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label">Tiene Garantía:</label>
                    <div class="col-sm-10">
                        <asp:RadioButtonList ID="rblGarantia" runat="server" RepeatDirection="Horizontal" CssClass="btn-group" data-toggle="buttons">
                            <asp:ListItem Text="Sí" Value="True"></asp:ListItem>
                            <asp:ListItem Text="No" Value="False"></asp:ListItem>
                        </asp:RadioButtonList>
                    </div>
                </div>

                <div class="form-group row">
                    <label for="dtpTiempoGarantia" class="col-sm-2 col-form-label">Duración de la Garantía:</label>
                    <div class="col-sm-10">
                        Ignorar en caso no tener garantía
        <input class="form-control" type="date" id="dtpTiempoGarantia" runat="server">
                    </div>
                </div>

                <div class="form-group row">
                    <div class="col-sm-10 offset-sm-2">
                        <asp:Button ID="btnRegistrar" runat="server" Text="Registrar" CssClass="btn btn-success" OnClick="btnRegistrar_Click" />
                        <asp:Button ID="btnRegresar" runat="server" Text="Regresar" CssClass="btn btn-secondary" OnClick="btnRegresar_Click" />
                    </div>
                </div>
            </div>
        </div>
    </div>
</asp:Content>
