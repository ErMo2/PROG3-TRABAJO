<%@ Page Title="" Language="C#" MasterPageFile="~/SoftProg.Master" AutoEventWireup="true" CodeBehind="GestionarProductos.aspx.cs" Inherits="InterfacesTrabajoGrupal.GestionarProductos" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphScripts" runat="server">
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="cphContenido" runat="server">
     <div class="container">
     <div class="card">
         <h2>
             Registrar Producto
         </h2>
     </div>
         <hr />
     <div class="card-body">
      <div class="mb-3 row">
         <asp:Label ID="lblIdProducto" runat="server" Text="Id Producto:" CssClass="col-sm-2 col-form-label"/>
         <div class="col-sm-4">
             <asp:TextBox ID="txtIdProducto" runat="server" Enabled="false" CssClass="form-control"/>
         </div>
     </div>

     <div class="mb-3 row">
         <asp:Label ID="lblNombreProducto" runat="server" Text="Nombre del Prodcuto:" CssClass="col-sm-2 col-form-label"/>
         <div class="col-sm-8">
             <asp:TextBox ID="txtNombreProducto" runat="server" CssClass="form-control"/>
         </div>
     </div>

         <div class="mb-3 row">
 <asp:Label ID="lblDescripcion" runat="server" Text="Descripcion del Producto:" CssClass="col-sm-2 col-form-label"/>
 <div class="col-sm-8">
     <asp:TextBox ID="txtDescripcionProducto" runat="server" CssClass="form-control"/>
 </div>
     </div>

     <div class="mb-3 row">
     <asp:Label ID="lblPrecio" runat="server" Text="Precio del Producto:" CssClass="col-sm-2 col-form-label"/>
     <div class="col-sm-8">
         <asp:TextBox ID="txtPrecioProducto" runat="server" CssClass="form-control"/>
     </div>
 </div>

     <div class="mb-3 row">
     <asp:Label ID="lblStock" runat="server" Text="Stock del Producto:" CssClass="col-sm-2 col-form-label"/>
     <div class="col-sm-8">
         <asp:TextBox ID="txtStock" runat="server" CssClass="form-control"/>
     </div>
         </div>
         <h2>
             Seleccionar Tipo de Producto:
         </h2>
              <div class="card-footer clearfix">
            <asp:Button ID="Button1" runat="server" Text="Producto Perecible" OnClick="btnRegPP_Click"/>
                  <hr />
            <asp:Button ID="Button2" runat="server" Text="Producto para el cuidado personal y del hogar"  OnClick="btnRegPCPH_Click"/>
             <hr />
                  <asp:Button ID="Button3" runat="server" Text="Ropa" OnClick="btnRegRopa_Click"/>
            <hr />
                  <asp:Button ID="Button4" runat="server" Text="Electrodomestico" OnClick="btnRegELec_Click"/>

                </div>


 </div>

             <div class="card-footer clearfix">
                  <hr />
                 <hr />
                 <asp:Button ID="btnRegresar" runat="server" Text="Regresar" 
            CssClass="float-start btn btn-secondary" OnClick="btnRegresar_Click"/>
       <!--<asp:Button ID="btnRegistrar" runat="server" Text="Siguiente" 
            CssClass="float-end btn btn-primary" OnClick="btnRegistrar_Click"/>
            </div>
        -->
 </div>
         </div>
</asp:Content>
