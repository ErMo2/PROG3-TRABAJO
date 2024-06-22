<%@ Page Title="" Language="C#" MasterPageFile="~/ZAP3WA.Master" AutoEventWireup="true" CodeBehind="VerElectrodomesticos.aspx.cs" Inherits="InterfacesTrabajoGrupal.VerElectrodomesticos" %>
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
            <h2>Visualizar Datos de Electrodoméstico</h2>
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
                    <asp:TextBox ID="txtNombreProducto" runat="server" Enabled="false" CssClass="form-control"></asp:TextBox>
                </div>
            </div>

            <div class="form-group row">
                <label for="txtDescripcionProducto" class="col-sm-2 col-form-label">Descripción del Producto:</label>
                <div class="col-sm-10">
                    <asp:TextBox ID="txtDescripcionProducto" Enabled="false" runat="server" CssClass="form-control"></asp:TextBox>
                </div>
            </div>


            <div class="form-group row">
                <label for="txtModelo" class="col-sm-2 col-form-label">Modelo:</label>
                <div class="col-sm-10">
                    <asp:TextBox ID="txtModelo" runat="server" Enabled="false" CssClass="form-control"></asp:TextBox>
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label">Tiene Garantía:</label>
                <div class="col-sm-10">
                    <asp:RadioButtonList ID="rblGarantia" runat="server" Enabled="false" RepeatDirection="Horizontal" CssClass="btn-group" data-toggle="buttons">
                        <asp:ListItem Text="Sí" Value="True"></asp:ListItem>
                        <asp:ListItem Text="No" Value="False"></asp:ListItem>
                    </asp:RadioButtonList>
                </div>
            </div>

            <div class="form-group row">
                <label for="dtpTiempoGarantia" class="col-sm-2 col-form-label">Duración de la Garantía:</label>
                <div class="col-sm-10">
                    <asp:TextBox id="dtpTiempoGarantia2" Enabled ="false" runat="server" class="form-control"/>
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
                                <asp:LinkButton ID="lbEliminar" runat="server" CommandName="Eliminar" CommandArgument='<%# Eval("idProductoPrecio") %>' Text="Eliminar" CssClass="btn btn-danger btn-sm" OnClientClick="return confirm('¿Está seguro de que desea eliminar esta sucursal?');" OnClick="btnEliminar_Click" />
                            </ItemTemplate>
                        </asp:TemplateField>
                    </Columns>
                </asp:GridView>
            </div>
            <div class="mb-3 row">
                <asp:Label ID="lblSucursal" runat="server" Text="Sucursal:" CssClass="col-sm-2 col-form-label" />
                <div class="col-sm-4">
                    <asp:DropDownList ID="ddlSucursal" runat="server" CssClass="form-control"></asp:DropDownList>

                </div>
            </div>
            <div class="mb-3 row">
                <asp:Label ID="lblNuevoPrecio" runat="server" Text="Nuevo Precio:" CssClass="col-sm-2 col-form-label" />
                <div class="col-sm-8">
                    <asp:TextBox ID="txtNuevoPrecio" runat="server" CssClass="form-control" />
                </div>
            </div>
            <div class="card-footer clearfix">
                <asp:Button ID="BtnInsertarProductoPrecio" runat="server" Text="Registrar Sucursal" CssClass="btn btn-primary" OnClick="btnRegistrarProductoPrecio_Click" />
            </div>
            <div class="card-footer clearfix">
                <asp:Button ID="btnRegresar" runat="server" Text="Regresar"
                    CssClass="float-start btn btn-secondary" OnClick="btnRegresar_Click" />
            </div>
        </div>
    </div>
    </div>
</asp:Content>
