<%@ Page Title="" Language="C#" MasterPageFile="~/ZAP3WA.Master" AutoEventWireup="true" CodeBehind="GestionarRopa.aspx.cs" Inherits="InterfacesTrabajoGrupal.Ropa" %>

<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphScripts" runat="server">
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="cphContenido" runat="server">

    <div class="container">
        <div class="card">
            <h2>Registrar Ropa:
            </h2>
        </div>
        <div class="card-body">
            <br />
            <div class="mb-3 row">
                <asp:Label ID="lblIdProducto" runat="server" Text="Id Producto:" CssClass="col-sm-2 col-form-label" />
                <div class="col-sm-4">
                    <asp:TextBox ID="txtIdProducto" runat="server" Enabled="false" CssClass="form-control" />
                </div>
            </div>

            <div class="mb-3 row">
                <asp:Label ID="lblNombreProducto" runat="server" Text="Nombre del Prodcuto:" CssClass="col-sm-2 col-form-label" />
                <div class="col-sm-8">
                    <asp:TextBox ID="txtNombreProducto" runat="server" CssClass="form-control" />
                </div>
            </div>

            <div class="mb-3 row">
                <asp:Label ID="lblDescripcion" runat="server" Text="Descripcion del Producto:" CssClass="col-sm-2 col-form-label" />
                <div class="col-sm-8">
                    <asp:TextBox ID="txtDescripcionProducto" runat="server" CssClass="form-control" />
                </div>
            </div>

            <div class="mb-3 row">
                <asp:Label ID="lblPrecio" runat="server" Text="Precio del Producto:" CssClass="col-sm-2 col-form-label" />
                <div class="col-sm-8">
                    <asp:TextBox ID="txtPrecioProducto" runat="server" CssClass="form-control" />
                </div>
            </div>

            <div class="mb-3 row">
                <asp:Label ID="lblStock" runat="server" Text="Stock del Producto:" CssClass="col-sm-2 col-form-label" />
                <div class="col-sm-8">
                    <asp:TextBox ID="txtStock" runat="server" CssClass="form-control" />
                </div>
            </div>



            <div class="mb-3 row">
                <asp:Label ID="lblTemporada" runat="server" Text="Temporada:" CssClass="col-sm-2 col-form-label" />
                <div class="col-sm-4">
                    <asp:DropDownList ID="ddlTemporada" runat="server" CssClass="form-control">
                        <asp:ListItem Text="Verano" Value="Verano"></asp:ListItem>
                        <asp:ListItem Text="Otoño" Value="Otoño"></asp:ListItem>
                        <asp:ListItem Text="Invierno" Value="Invierno"></asp:ListItem>
                        <asp:ListItem Text="Primavera" Value="Primavera"></asp:ListItem>
                    </asp:DropDownList>
                </div>
            </div>


            <div class="mb-3 row">
                <asp:Label ID="lblTiempoGarantia" runat="server" Text="Material:" CssClass="col-sm-2 col-form-label" />
                <div class="col-sm-4">
                    <asp:DropDownList ID="ddlMaterial" runat="server" CssClass="form-control">
                        <asp:ListItem Text="Algodón" Value="Algodón"></asp:ListItem>
                        <asp:ListItem Text="Lino" Value="Lino"></asp:ListItem>
                        <asp:ListItem Text="Seda" Value="Seda"></asp:ListItem>
                        <asp:ListItem Text="Lana" Value="Lana"></asp:ListItem>
                        <asp:ListItem Text="Cachemira" Value="Cachemira"></asp:ListItem>
                        <asp:ListItem Text="Cáñamo" Value="Cáñamo"></asp:ListItem>
                        <asp:ListItem Text="Yute" Value="Yute"></asp:ListItem>
                    </asp:DropDownList>
                </div>
            </div>

            <div class="mb-3 row">
                <asp:Label ID="lblTipoRopa" runat="server" Text="Tipo de Ropa:" CssClass="col-sm-2 col-form-label" />
                <div class="col-sm-4">
                    <asp:DropDownList ID="ddlTipoRopa" runat="server" CssClass="form-control" OnSelectedIndexChanged="ddlTipoRopa_SelectedIndexChanged">
                        <asp:ListItem Text="Ropa Hombre" Value="RopaHombre"></asp:ListItem>
                        <asp:ListItem Text="Ropa Mujer" Value="RopaMujer"></asp:ListItem>
                        <asp:ListItem Text="Calzado" Value="Calzado"></asp:ListItem>
                    </asp:DropDownList>
                </div>
            </div>
            <!-- New field for selecting a Sucursal -->
            <div class="form-group row">
                <label for="ddlSucursal" class="col-sm-2 col-form-label">Sucursal:</label>
                <div class="col-sm-10">
                    <asp:DropDownList ID="ddlSucursal" runat="server" CssClass="form-control">
                    </asp:DropDownList>
                </div>
            </div>
            <br />
            <!-- New field for applying a Discount -->
            <div class="form-group row">
                <label for="txtDescuento" class="col-sm-2 col-form-label">Descuento (%):</label>
                <div class="col-sm-10">
                    <asp:TextBox ID="txtDescuento" runat="server" CssClass="form-control" TextMode="Number" />
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
