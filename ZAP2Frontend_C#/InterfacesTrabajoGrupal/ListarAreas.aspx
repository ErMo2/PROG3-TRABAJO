<%@ Page Title="" Language="C#" MasterPageFile="~/ZAP3WA.Master" AutoEventWireup="true" CodeBehind="ListarAreas.aspx.cs" Inherits="InterfacesTrabajoGrupal.GestionAreas" %>

<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphScripts" runat="server">
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="cphContenido" runat="server">
    <div class="container">
        <h2>Listado de Areas</h2>
        <hr />
        <hr />
        <div class="container row">
            <div class="text-end p-3">
                <asp:LinkButton ID="lbRegistrarArea" runat="server" CssClass="btn btn-success"
                    Text="<i class='fa-solid fa-plus pe-2'></i> Registrar Area" OnClick="lbRegistrarArea_Click" />
            </div>
        </div>

        <div class="container row">
            <asp:GridView ID="gvAreas" runat="server"
                AutoGenerateColumns="false" CssClass="table table-hover table-responsive"
                AllowPaging="true" PageSize="3" OnPageIndexChanging="gvAreas_PageIndexChanging">

                <Columns>
                    <asp:BoundField HeaderText="IdAmbiente" DataField="idArea" />
                    <asp:BoundField HeaderText="NombreAmbiente" DataField="nombre" />

                    <asp:TemplateField>
                        <ItemTemplate>
                            <asp:LinkButton runat="server" Text="<i class='fa-solid fa-edit ps-2'></i>" CommandArgument='<%# Eval("idArea") %>' OnClick="lbEditarArea_Click" />
                            <asp:LinkButton runat="server" Text="<i class='fa-solid fa-trash ps-2'></i>" CommandArgument='<%# Eval("idArea") %>' OnClick="lbEliminarArea_Cick" />
                        </ItemTemplate>
                    </asp:TemplateField>
                </Columns>
            </asp:GridView>
        </div>
    </div>
</asp:Content>
