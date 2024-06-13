<%@ Page Title="" Language="C#" MasterPageFile="~/ZAP3WA.Master" AutoEventWireup="true" CodeBehind="ListarBancos.aspx.cs" Inherits="InterfacesTrabajoGrupal.ListarBancos" %>

<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphScripts" runat="server">
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="cphContenido" runat="server">
   <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
   <link href="design/estilosPersonalizados.css" rel="stylesheet" />
   <link href="design/bancoEstilo.css" rel="stylesheet" />
   <div class="container mt-5">
       <div class="card shadow-lg">
           <div class="card-header bg-primary text-white text-center">
               <h2>Listado de Bancos</h2>
           </div>
           <div class="card-body">
               <div class="text-right mb-3">
                   <asp:LinkButton ID="lbRegistrarBanco" runat="server" CssClass="btn btn-success"
                       Text="<i class='fa-solid fa-plus pe-2'></i> Registrar Banco" OnClick="lbRegistrarBanco_Click"/>
               </div>

               <asp:GridView ID="gvBancos" runat="server"
                   AutoGenerateColumns="false" 
                   CssClass="table table-hover table-responsive-sm table-striped"
                   AllowPaging="true"
                   PageSize="5"
                   OnPageIndexChanging="gvBancos_PageIndexChanging"
                   OnRowCommand="gvBancos_RowCommand">
                   <Columns>
                       <asp:BoundField HeaderText="Id Banco" DataField="idBanco"/>
                       <asp:BoundField HeaderText="Nombre" DataField="nombre" />
                       <asp:TemplateField>
                           <ItemTemplate>
                               <div class="btn-group" role="group">
                                   <asp:LinkButton ID="lbModificar" runat="server" CommandName="Modificar" CommandArgument='<%# Eval("idBanco") %>' Text="Modificar" CssClass="btn btn-primary btn-sm" />
                                   <asp:LinkButton ID="lbEliminar" runat="server" CommandName="Eliminar" CommandArgument='<%# Eval("idBanco") %>' Text="Eliminar" CssClass="btn btn-danger btn-sm" OnClientClick="return confirm('¿Está seguro de que desea eliminar este banco?');" />
                               </div>
                           </ItemTemplate>
                       </asp:TemplateField>
                   </Columns>
                   <PagerSettings Mode="NumericFirstLast" FirstPageText="Primero" LastPageText="Último" PageButtonCount="5" />
                   <PagerStyle CssClass="pagination justify-content-center" />
               </asp:GridView>
           </div>
       </div>
   </div>
</asp:Content>
