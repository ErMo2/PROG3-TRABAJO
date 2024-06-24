<%@ Page Title="" Language="C#" MasterPageFile="~/ZAP3WA.Master" AutoEventWireup="true" CodeBehind="VerArea.aspx.cs" Inherits="InterfacesTrabajoGrupal.VerArea" %>
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
                <asp:TextBox ID="txtNombreArea" runat="server" Enabled="false" CssClass="form-control" />
            </div>
            <div class="col-sm-8">
                <asp:Label ID="lblSucursal" runat="server" Text="Sucursal:" CssClass="col-sm-2 col-form-label" />
                <asp:DropDownList ID="ddlSucursal" runat="server" Enabled="false" CssClass="form-control"></asp:DropDownList>
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
                    <asp:BoundField HeaderText="ID" DataField="IdAreaProducto" />
                    <asp:BoundField HeaderText="Nombre" DataField="nombre" />
                    <asp:BoundField HeaderText="Precio" DataField="prodPrecio.precio" />
                    <asp:TemplateField>
                        <ItemTemplate>
                            <asp:LinkButton ID="lbEliminar" runat="server" CommandName="Eliminar" CommandArgument='<%# Eval("IdAreaProducto") %>' Text="Eliminar" CssClass="btn btn-danger btn-sm" OnClientClick="return confirm('¿Está seguro de que desea eliminar esta sucursal?');" OnClick="btnEliminar_Click" />
                        </ItemTemplate>
                    </asp:TemplateField>
                </Columns>
            </asp:GridView>
        </div>
        <div class="mb-3 row">
            <asp:Label ID="Label1" runat="server" Text="Sucursal:" CssClass="col-sm-2 col-form-label" />
            <div class="col-sm-4">
                <asp:DropDownList ID="DropDownList1" runat="server" CssClass="form-control"></asp:DropDownList>

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
</asp:Content>
