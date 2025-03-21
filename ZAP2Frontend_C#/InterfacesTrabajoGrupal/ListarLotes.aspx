﻿<%@ Page Title="" Language="C#" MasterPageFile="~/ZAP3WA.Master" AutoEventWireup="true" CodeBehind="ListarLotes.aspx.cs" Inherits="InterfacesTrabajoGrupal.ListarLotes" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphScripts" runat="server">
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="cphContenido" runat="server">
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
    <link href="design/estilosPersonalizados.css" rel="stylesheet" />
    <link href="design/bancoEstilo.css" rel="stylesheet" />
    <div class="container mt-5">
        <div class="card shadow-lg">
            <div class="card-header bg-primary text-white text-center">
                <h2>Listado de Lotes</h2>
            </div>
            <div class="card-body">
                <div class="text-right mb-3">
                    <asp:LinkButton ID="lbRegistrarLote" runat="server" CssClass="btn btn-success"
                        Text="<i class='fa-solid fa-plus pe-2'></i> Registrar Lote" OnClick="lbRegistrarLote_Click" />
                </div>

                <asp:GridView ID="gvLotes" runat="server"
                    AutoGenerateColumns="false"
                    CssClass="table table-hover table-responsive-sm table-striped"
                    AllowPaging="true"
                    PageSize="5"
                    OnPageIndexChanging="gvLotes_PageIndexChanging"
                    OnRowCommand="gvLotes_RowCommand">
                    <Columns>
                        <asp:BoundField HeaderText="Id" DataField="idLote" />
                        <asp:BoundField HeaderText="Stock Inicial" DataField="stockInicial" />
                        <asp:BoundField HeaderText="Stock Actual" DataField="stockActual" />
                        <asp:BoundField HeaderText="Sucursal" DataField="almacen.sucursal.nombre" />
                        <asp:TemplateField>
                            <ItemTemplate>
                                <div class="btn-group" role="group">
                                    <asp:LinkButton ID="lbVer" runat="server" CommandName="Ver" CommandArgument='<%# Eval("idLote") %>' Text="Ver" CssClass="btn btn-primary btn-sm"  />
                                    <asp:LinkButton ID="lbEliminar" runat="server" CommandName="Eliminar" CommandArgument='<%# Eval("idLote") %>' Text="Eliminar" CssClass="btn btn-danger btn-sm" OnClientClick="return confirm('¿Está seguro de que desea eliminar este lote?');" />
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
