<%@ Page Title="" Language="C#" MasterPageFile="~/ZAP3WA.Master" AutoEventWireup="true" CodeBehind="ListarLotes.aspx.cs" Inherits="InterfacesTrabajoGrupal.ListarLotes" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphScripts" runat="server">
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">

    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>

</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="cphContenido" runat="server">
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
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

                    <div class="container mt-5">
            <asp:Button ID="btnShowPopup" runat="server" CssClass="btn btn-primary" Text="Mostrar Popup" OnClientClick="$('#popupModal').modal('show'); return false;" />
        </div>

                <!-- Modal de Bootstrap -->
                <div class="modal fade" id="popupModal" tabindex="-1" role="dialog" aria-labelledby="popupModalLabel" aria-hidden="true">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="popupModalLabel">Popup con Dos Botones</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                <!-- Aquí puedes colocar el mensaje que desees -->
                                <p>Modo de visualización:</p>
                            </div>
                            <div class="modal-footer">
                                <asp:Button ID="btnOption1" runat="server" CssClass="btn btn-secondary" Text="Descargar" OnClick="btnOption1_Click" />
                                <asp:Button ID="btnOption2" runat="server" CssClass="btn btn-secondary" Text="Correo" OnClick="btnOption2_Click" />
                            </div>
                        </div>
                    </div>
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
                        <asp:BoundField HeaderText="Producto" DataField="producto.nombre" />
                        <asp:BoundField HeaderText="Sucursal" DataField="almacen.sucursal.nombre" />
                        <asp:BoundField HeaderText="Almacen" DataField="almacen.tipoAlmacen" />
                        <asp:TemplateField>
                            <ItemTemplate>
                                <div class="btn-group" role="group">
                                    <asp:LinkButton ID="lbModificarLote" runat="server" CommandName="ModificarLote" CommandArgument='<%# Eval("idLote") %>' Text="Modificar" CssClass="btn btn-primary btn-sm" />
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
