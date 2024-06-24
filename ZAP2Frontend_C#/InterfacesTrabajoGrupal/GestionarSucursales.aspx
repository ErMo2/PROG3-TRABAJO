<%@ Page Title="" Language="C#" MasterPageFile="~/ZAP3WA.Master" AutoEventWireup="true" CodeBehind="GestionarSucursales.aspx.cs" Inherits="InterfacesTrabajoGrupal.GestionarSucursales" %>

<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphScripts" runat="server">
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="cphContenido" runat="server">
     <!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Registrar Sucursal</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet" />
    <style>
        .container {
            margin-top: 20px;
        }
        .card-header {
            background-color: #007bff;
            color: white;
        }
        .card-footer {
            background-color: #f8f9fa;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="card">
            <div class="card-header">
                <h2>Registrar Sucursal</h2>
            </div>
            <div class="card-body">
                <div class="mb-3 row">
                    <asp:Label ID="lblIdSucursal" runat="server" Text="Id Sucursal:" CssClass="col-sm-2 col-form-label" />
                    <div class="col-sm-4">
                        <asp:TextBox ID="txtIdSucursal" runat="server" Enabled="false" CssClass="form-control" />
                    </div>
                </div>
                <div class="mb-3 row">
                    <asp:Label ID="lblNombreSucursal" runat="server" Text="Nombre:" CssClass="col-sm-2 col-form-label" />
                    <div class="col-sm-8">
                        <asp:TextBox ID="txtNombreSucursal" runat="server" CssClass="form-control" />
                    </div>
                </div>
                <div class="mb-3 row">
                    <asp:Label ID="lblUbicacionSucursal" runat="server" Text="Ubicación de la Sucursal:" CssClass="col-sm-2 col-form-label" />
                    <div class="col-sm-8">
                        <asp:TextBox ID="txtUbicacionSucursal" runat="server" CssClass="form-control" />
                    </div>
                </div>
                <div class="mb-3 row">
                    <asp:Label ID="lblTamanio" runat="server" Text="Tamaño en metros cuadrados:" CssClass="col-sm-2 col-form-label" />
                    <div class="col-sm-8">
                        <asp:TextBox ID="txtTamanio" runat="server" CssClass="form-control" placeholder="Metros cuadrados" />
                    </div>
                </div>
            </div>
            <div class="card-footer clearfix">
                <asp:Button ID="btnRegresar" runat="server" Text="Regresar" CssClass="float-start btn btn-secondary" OnClick="btnRegresar_Click" />
                <asp:Button ID="btnRegistrar" runat="server" Text="Registrar" CssClass="float-end btn btn-primary" OnClick="btnRegistrar_Click" />
            </div>
        </div>
    </div>
</body>
</html>
</asp:Content>
