<%@ Page Title="" Language="C#" MasterPageFile="~/ZAP3WA.Master" AutoEventWireup="true" CodeBehind="SeleccionarTipoDeProducto.aspx.cs" Inherits="InterfacesTrabajoGrupal.SeleccionarTipoDeProducto" %>

<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphScripts" runat="server">
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="cphContenido" runat="server">

    <style>
        .custom-btn {
            position: relative;
            padding-top: 75px; /* Espacio para la imagen */
            overflow: hidden; /* Asegura que la imagen no desborde el botón */
        }

            .custom-btn img {
                position: absolute;
                top: 10px; /* Espacio desde el top del botón */
                left: 50%;
                transform: translateX(-50%); /* Centra la imagen */
                width: 50px; /* Tamaño de la imagen */
                height: 50px; /* Tamaño de la imagen */
            }
    </style>
    <div class="container text-center mt-5">
        <h2>Seleccionar Tipo de Producto</h2>
        <div class="d-flex flex-column align-items-center mt-4">
            <div class="w-100 mb-3" style="max-width: 300px;">
                <asp:LinkButton ID="lblRopa" CssClass="btn btn-primary btn-lg w-100 custom-btn" runat="server" OnClick="lblRopa_Click">
                <img src="Imagenes/Ropa.jpg" />
                Ropa
                </asp:LinkButton>
            </div>
            <div class="w-100 mb-3" style="max-width: 300px;">
                <asp:LinkButton ID="lblElectrodomestico" CssClass="btn btn-success btn-lg w-100 custom-btn" runat="server" OnClick="lblElectrodomestico_Click">
                <img src="Imagenes/electrodomesticos.jpeg"  />
                Electrodoméstico
                </asp:LinkButton>
            </div>
            <div class="w-100 mb-3" style="max-width: 300px;">
                <asp:LinkButton ID="lblCuidadoPersonal" CssClass="btn btn-info btn-lg w-100 custom-btn" runat="server" OnClick="lblLimpieza_Click">
                <img src="Imagenes/PorductosHigiene.jpeg" />
                Limpieza y Cuidado Personal
                </asp:LinkButton>
            </div>
            <div class="w-100 mb-3" style="max-width: 300px;">
                <asp:LinkButton ID="lblProductoPerecible" CssClass="btn btn-warning btn-lg w-100 custom-btn" runat="server" OnClick="lblPerecible_Click">
                <img src="Imagenes/ProductosPerecibles.jpeg" />
                Producto Perecible
                </asp:LinkButton>
            </div>
        </div>
        <div class="card-footer text-right">
            <asp:Button ID="btnRegresar" runat="server" Text="Regresar" CssClass="btn btn-secondary" OnClick="btnRegresar_Click" />
        </div>
    </div>
    </div>

</asp:Content>
