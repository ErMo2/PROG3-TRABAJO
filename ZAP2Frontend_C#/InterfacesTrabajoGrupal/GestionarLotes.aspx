﻿<%@ Page Title="" Language="C#" MasterPageFile="~/ZAP3WA.Master" AutoEventWireup="true" CodeBehind="GestionarLotes.aspx.cs" Inherits="InterfacesTrabajoGrupal.GestionarLotes" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphScripts" runat="server">
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="cphContenido" runat="server">
    <!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head >
    <title>Gestionar Banco</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet" />
    <link href="design/estilosPersonalizados.css" rel="stylesheet" />
    <link href="design/bancoEstilo.css" rel="stylesheet" />
</head>
<body>
    <form id="form1">
        <div class="container mt-5">
            <div class="card shadow-lg">
                <div class="card-header bg-primary text-white text-center">
                    <h2>
                        <asp:Label ID="lblTitulo" runat="server" /></h2>
                </div>
                <div class="card-body">
                    <div class="mb-3 row">
                        <asp:Label ID="lblIdLote" runat="server" Text="Id Lote:" CssClass="col-sm-2 col-form-label" />
                        <div class="col-sm-4">
                            <asp:TextBox ID="txtIdLote" runat="server" CssClass="form-control" Enabled="false" />
                        </div>
                    </div>
                    <div class="mb-3 row">
                        <asp:Label ID="lblStockInicial" runat="server" Text="Stock Inicial:" CssClass="col-sm-2 col-form-label" />
                        <div class="col-sm-8">
                            <asp:TextBox ID="txtStockInicial" runat="server" CssClass="form-control" />
                        </div>
                    </div>

                    <div class="mb-3 row">
                        <asp:Label ID="lblStockFinal" runat="server" Text="Stock Final:" CssClass="col-sm-2 col-form-label" />
                        <div class="col-sm-8">
                            <asp:TextBox ID="txtStockFinal" runat="server" CssClass="form-control" />
                        </div>
                    </div>

                    <div class="card-footer clearfix">
                        <asp:Button ID="btnRegresar" runat="server" Text="Regresar" CssClass="float-start btn btn-secondary" OnClick="btnRegresar_Click" />
                        <asp:Button ID="btnGuardar" runat="server" Text="Guardar" CssClass="float-end btn btn-primary" OnClick="btnGuardar_Click" />
                    </div>
                </div>
            </div>
        </div>
    </form>
</body>
    </html>
</asp:Content>
