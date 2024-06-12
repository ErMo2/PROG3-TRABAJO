<%@ Page Title="" Language="C#" MasterPageFile="~/ZAP3WA.Master" AutoEventWireup="true" CodeBehind="ListarClientes.aspx.cs" Inherits="InterfacesTrabajoGrupal.ListarClientes" %>
<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphScripts" runat="server">
          <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="cphContenido" runat="server">
    <div class="container mt-4">
        <h2 class="mb-4 text-center">Listado de Clientes</h2>
        
        <div class="text-end mb-3">
            <asp:LinkButton ID="lbRegistrarCliente" runat="server" CssClass="btn btn-success"
                Text="<i class='fa-solid fa-plus pe-2'></i> Registrar Cliente" OnClick="lbRegistrarCliente_Click"/>
        </div>

        <asp:GridView ID="gvClientes" runat="server" AutoGenerateColumns="False" CssClass="table table-hover table-responsive">
            <Columns>
                <asp:BoundField DataField="id_cliente" HeaderText="Id Cliente" />
                <asp:BoundField DataField="nombre" HeaderText="Nombre" />
                <asp:BoundField DataField="apellido_paterno" HeaderText="Apellido Paterno" />
                <asp:BoundField DataField="apellido_materno" HeaderText="Apellido Materno" />
                <asp:BoundField DataField="telefono" HeaderText="Telefono" />
                <asp:BoundField DataField="email" HeaderText="Email" />
                <asp:TemplateField>
                    <HeaderTemplate>
                        Acciones
                    </HeaderTemplate>
                    <ItemTemplate>
                        <asp:Button ID="btnModificar" runat="server" Text="Modificar" CommandArgument='<%# Container.DataItemIndex %>' CssClass="btn btn-primary btn-sm" OnClick="btnModificar_Click" />
                        <asp:Button ID="btnEliminar" runat="server" Text="Eliminar" CommandArgument='<%# Container.DataItemIndex %>' CssClass="btn btn-danger btn-sm" OnClick="btnEliminar_Click" />
                        <asp:Button ID="btnVer" runat="server" Text="Ver" CommandArgument='<%# Container.DataItemIndex %>' CssClass="btn btn-info btn-sm" OnClick="btnVer_Click" data-toggle="modal" data-target="#verClienteModal" />
                    </ItemTemplate>
                </asp:TemplateField>
            </Columns>
        </asp:GridView>
       <div class="mt-3">
            <asp:Button ID="btnRegresar" runat="server" Text="Regresar" CssClass="btn btn-secondary" OnClick="btnRegresar_Click" />
            <asp:Button ID="btnRegistrar" runat="server" Text="Registrar" CssClass="btn btn-primary" OnClick="btnRegistrar_Click" />
        </div>
    </div>

    <!-- Modal for viewing client details -->
    <div class="modal fade" id="verClienteModal" tabindex="-1" aria-labelledby="verClienteModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="verClienteModalLabel">Detalles del Cliente</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <asp:Label ID="lblDetallesCliente" runat="server" Text=""></asp:Label>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
                </div>
            </div>
        </div>
    </div>
</asp:Content>
