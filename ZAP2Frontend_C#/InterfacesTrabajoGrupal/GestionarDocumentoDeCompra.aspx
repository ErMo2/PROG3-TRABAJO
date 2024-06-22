<%@ Page Title="" Language="C#" MasterPageFile="~/ZAP3WA.Master" AutoEventWireup="true" CodeBehind="GestionarDocumentoDeCompra.aspx.cs" Inherits="InterfacesTrabajoGrupal.GestionarDocumentoDeCompra" %>

<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphScripts" runat="server">
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="cphContenido" runat="server">
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Registrar Documento de Compra</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet" />
</head>
<body>
    <div class="container mt-5">
        <div class="card">
            <div class="card-header">
                <h2>Registrar Documento de Compra</h2>
            </div>
            <div class="card-body">
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label" for="txtDocumentoDeCompra">ID Documento:</label>
                    <div class="col-sm-10">
                        <asp:TextBox ID="txtDocumentoDeCompra" runat="server" Enabled="false" CssClass="form-control" />
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label" for="txtFechaEmision">Fecha de Emisión:</label>
                    <div class="col-sm-10">
                        <input type="date" id="txtFechaEmision" runat="server" class="form-control" />
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label" for="txtTotal">Total:</label>
                    <div class="col-sm-10">
                        <asp:TextBox ID="txtTotal" runat="server" CssClass="form-control" />
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label" for="txtSaldo">Saldo:</label>
                    <div class="col-sm-10">
                        <asp:TextBox ID="txtSaldo" runat="server" CssClass="form-control" />
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label" for="ddlMoneda">Moneda:</label>
                    <div class="col-sm-10">
                        <asp:DropDownList ID="ddlMoneda" runat="server" CssClass="form-control">
                            <asp:ListItem Text="Soles" Value="PEN"></asp:ListItem>
                            <asp:ListItem Text="Dólares" Value="USD"></asp:ListItem>
                        </asp:DropDownList>
                    </div>
                </div>
            </div>
            <div class="card-footer text-right">
                <asp:Button ID="btnGenerarPDF" runat="server" Text="Generar PDF" OnClick="btnGenerarPDF_Click" CssClass="btn btn-primary" />
                <asp:Button ID="btnRegistrar" runat="server" Text="Registrar" CssClass="btn btn-primary" OnClick="btnRegistrar_Click" />
                <asp:Button ID="btnRegresar" runat="server" Text="Regresar" CssClass="btn btn-secondary" OnClick="btnRegresar_Click" />
            </div>
        </div>
    </div>
</body>
</html>
</asp:Content>
