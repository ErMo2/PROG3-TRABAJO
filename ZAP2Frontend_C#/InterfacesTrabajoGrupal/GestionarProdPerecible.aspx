﻿<%@ Page Title="" Language="C#" MasterPageFile="~/ZAP3WA.Master" AutoEventWireup="true" CodeBehind="GestionarProdPerecible.aspx.cs" Inherits="InterfacesTrabajoGrupal.ProdPerecible" %>

<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphScripts" runat="server">
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="cphContenido" runat="server">
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet" />
    <link href="Diseño/CustomSuccess.css" rel="stylesheet" />
    <div class="container">
        <div class="card shadow">
            <div class="card-header bg-success text-white">
                <h2>Registrar Producto Perecible</h2>
            </div>
            <div class="card-body">
                <div class="form-group row">
                    <label for="txtIdProducto" class="col-sm-2 col-form-label">ID del Producto:</label>
                    <div class="col-sm-10">
                        <asp:TextBox ID="txtIdProducto" runat="server" Enabled="false" CssClass="form-control" />
                    </div>
                </div>
                <div class="form-group row">
                    <label for="txtNombreProducto" class="col-sm-2 col-form-label">Nombre del Producto:</label>
                    <div class="col-sm-10">
                        <asp:TextBox ID="txtNombreProducto" runat="server" CssClass="form-control" />
                    </div>
                </div>
                <div class="form-group row">
                    <label for="txtDescripcionProducto" class="col-sm-2 col-form-label">Descripción:</label>
                    <div class="col-sm-10">
                        <asp:TextBox ID="txtDescripcionProducto" runat="server" CssClass="form-control" />
                    </div>
                </div>
                <div class="form-group row">
                    <label for="dtpFechaNacimiento" class="col-sm-2 col-form-label">Fecha de Vencimiento:</label>
                    <div class="col-sm-10">
                        <input class="form-control" type="date" id="dtpFechaNacimiento" runat="server" />
                    </div>
                </div>
                <div class="form-group row">
                    <label for="ddlTipoProductoPerecible" class="col-sm-2 col-form-label">Tipo de Producto:</label>
                    <div class="col-sm-10">
                        <asp:DropDownList ID="ddlTipoProductoPerecible" runat="server" CssClass="form-control">
                            <asp:ListItem Text="Cereales" Value="Cereales"></asp:ListItem>
                            <asp:ListItem Text="Lácteos" Value="Lacteos"></asp:ListItem>
                            <asp:ListItem Text="Frutas" Value="Frutas"></asp:ListItem>
                            <asp:ListItem Text="Verduras" Value="Verduras"></asp:ListItem>
                            <asp:ListItem Text="Congelados" Value="Congelados"></asp:ListItem>
                            <asp:ListItem Text="Despensa" Value="Despensa"></asp:ListItem>
                        </asp:DropDownList>
                    </div>
                </div>
                <div class="form-group row">
                    <label for="ddlUnidadMedida" class="col-sm-2 col-form-label">Unidad de Medida:</label>
                    <div class="col-sm-10">
                        <asp:DropDownList ID="ddlUnidadMedida" runat="server" CssClass="form-control">
                            <asp:ListItem Text="Unidad" Value="Unidad"></asp:ListItem>
                            <asp:ListItem Text="Paquete" Value="Paquete"></asp:ListItem>
                            <asp:ListItem Text="KG" Value="KG"></asp:ListItem>
                            <asp:ListItem Text="LT" Value="LT"></asp:ListItem>
                            <asp:ListItem Text="NA" Value="NA"></asp:ListItem>
                        </asp:DropDownList>
                    </div>
                </div>
            </div>
            <div class="card-footer text-right">
                <asp:Button ID="btnRegistrar" runat="server" Text="Registrar" CssClass="btn btn-success" OnClick="btnRegistrar_Click" />
                <asp:Button ID="btnRegresar" runat="server" Text="Regresar" CssClass="btn btn-secondary" OnClick="btnRegresar_Click" />
            </div>
        </div>
    </div>
</asp:Content>
