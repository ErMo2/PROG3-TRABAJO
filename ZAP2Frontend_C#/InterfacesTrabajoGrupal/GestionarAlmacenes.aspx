<%@ Page Title="" Language="C#" MasterPageFile="~/SoftProg.Master" AutoEventWireup="true" CodeBehind="GestionarAlmacenes.aspx.cs" Inherits="InterfacesTrabajoGrupal.GestionarSucursal" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphScripts" runat="server">
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="cphContenido" runat="server">
        <div class="container">
    <div class="card">
        <h2>
            Registrar Almacen
        </h2>
    </div>
        <hr />

    <div class="card-body">
     <div class="mb-3 row">
        <asp:Label ID="lblIdAlmacen" runat="server" Text="Id Almacen:" CssClass="col-sm-2 col-form-label"/>
        <div class="col-sm-4">
            <asp:TextBox ID="txtIdAlmacen" runat="server" Enabled="false" CssClass="form-control"/>
        </div>
    </div>

    <div class="mb-3 row">
        <asp:Label ID="lblTipoAlmacen" runat="server" Text="Tipo de Almacen:" CssClass="col-sm-2 col-form-label"/>
        <div class="col-sm-8">
            <asp:TextBox ID="txtTipoAlmacen" runat="server" CssClass="form-control"/>
        </div>
    </div>

        
    <div class="card-body">
     <div class="mb-3 row">
        <asp:Label ID="lblCapacidadMaxima" runat="server" Text="Capacidad maxima de productos:" CssClass="col-sm-2 col-form-label"/>
        <div class="col-sm-4">
            <asp:TextBox ID="txtCapacidadMaxima" runat="server" CssClass="form-control"/>
        </div>
    </div>

    <div class="mb-3 row">
        <asp:Label ID="lblCapacidadActual" runat="server" Text="Capacidad actual de productos:" CssClass="col-sm-2 col-form-label"/>
        <div class="col-sm-8">
            <asp:TextBox ID="txtCapacidadActual" runat="server" CssClass="form-control"/>
        </div>
    </div>

        
    <div class="mb-3 row">
        <asp:Label ID="lblSucursal" runat="server" Text="Sucursal:" CssClass="col-sm-2 col-form-label"/>
        <div class="col-sm-8">
            <asp:TextBox ID="txtSucursal" runat="server" CssClass="form-control"/>
        </div>
    </div>

</div>

         <div class="card-footer clearfix">
    <asp:Button ID="btnRegresar" runat="server" Text="Regresar" 
        CssClass="float-start btn btn-secondary" OnClick="btnRegresar_Click"/>
    <asp:Button ID="btnRegistrar" runat="server" Text="Registrar" 
        CssClass="float-end btn btn-primary" OnClick="btnRegistrar_Click"/>
        </div>

</div>
</asp:Content>
