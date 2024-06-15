<%@ Page Title="" Language="C#" MasterPageFile="~/ZAP3WA.Master" AutoEventWireup="true" CodeBehind="VerProductosPerecibles.aspx.cs" Inherits="InterfacesTrabajoGrupal.VerProductosPerecibles" %>
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
            <h2>Visualizar Datos de Producto Perecible</h2>
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
                    <asp:TextBox ID="txtNombreProducto" runat="server" Enabled="false" CssClass="form-control" />
                </div>
            </div>
            <div class="form-group row">
                <label for="txtDescripcionProducto" class="col-sm-2 col-form-label">Descripción:</label>
                <div class="col-sm-10">
                    <asp:TextBox ID="txtDescripcionProducto" runat="server" Enabled="false" CssClass="form-control" />
                </div>
            </div>
            <div class="form-group row">
                <label for="dtpFechaNacimiento" Enabled="false" class="col-sm-2 col-form-label">Fecha de Vencimiento:</label>
                <div class="col-sm-10">
                    <asp:TextBox id="dtpFechaNacimiento" Enabled ="false" runat="server" class="form-control"/>
                    
                </div>
            </div>
            <div class="form-group row">
                <label for="ddlTipoProductoPerecible" Enabled="false" class="col-sm-2 col-form-label">Tipo de Producto:</label>
                <div class="col-sm-10">
                    <asp:DropDownList ID="ddlTipoProductoPerecible" Enabled="false" runat="server" CssClass="form-control">
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
                <label for="ddlUnidadMedida" Enabled="false" class="col-sm-2 col-form-label">Unidad de Medida:</label>
                <div class="col-sm-10">
                    <asp:DropDownList ID="ddlUnidadMedida" Enabled="false" runat="server" CssClass="form-control">
                        <asp:ListItem Text="Unidad" Value="Unidad"></asp:ListItem>
                        <asp:ListItem Text="Paquete" Value="Paquete"></asp:ListItem>
                        <asp:ListItem Text="KG" Value="KG"></asp:ListItem>
                        <asp:ListItem Text="LT" Value="LT"></asp:ListItem>
                        <asp:ListItem Text="NA" Value="NA"></asp:ListItem>
                    </asp:DropDownList>
                </div>
            </div>
        </div>
        <h3>Lista de Precios en distintas sucursales</h3>
        <div class="text-center containermt-3 mt-5 row">
            <asp:GridView ID="gvSucursales" runat="server"
                AutoGenerateColumns="false"
                CssClass="table table-hover table-responsive table-bordered center-container gridview-wrapper"
                AllowPaging="true"
                PageSize="5"
                OnPageIndexChanging="gvSucursales_PageIndexChanging"
                OnRowDataBound="gvSucursales_RowDataBound">
                <Columns>
                    <asp:BoundField HeaderText="Id" DataField="idProductoPrecio" />
                    <asp:BoundField HeaderText="Nombre" DataField="sucursal.nombre" />
                    <asp:BoundField HeaderText="Precio" DataField="precio" />
                    <asp:TemplateField>
                        <ItemTemplate>
                            <asp:LinkButton ID="lbEliminar" runat="server" CommandName="Eliminar" CommandArgument='<%# Eval("idProductoPrecio") %>' Text="Eliminar" CssClass="btn btn-danger btn-sm" OnClientClick="return confirm('¿Está seguro de que desea eliminar esta sucursal?');" OnClick="btnEliminar_Click"/>
                        </ItemTemplate>
                    </asp:TemplateField>
                </Columns>
            </asp:GridView>
        </div>
        <div class="mb-3 row">
            <asp:Label ID="lblSucursal" runat="server" Text="Sucursal:" CssClass="col-sm-2 col-form-label" />
            <div class="col-sm-8">
                <asp:DropDownList ID="ddlSucursal" runat="server" CssClass="form-control"></asp:DropDownList>
                <asp:TextBox ID="txtNuevoPrecio" runat="server" CssClass="form-control" />
                <asp:Button ID="BtnInsertarProductoPrecio" runat="server" Text="Registrar Sucursal" CssClass="btn btn-primary" OnClick="btnRegistrarProductoPrecio_Click" />
            </div>
        </div>

        <div class="card-footer text-right">
            <asp:Button ID="btnRegresar" runat="server" Text="Regresar" CssClass="btn btn-secondary" OnClick="btnRegresar_Click" />
        </div>
    </div>
</div>
</asp:Content>
