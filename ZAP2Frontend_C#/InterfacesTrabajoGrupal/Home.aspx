<%@ Page Title="" Language="C#" MasterPageFile="~/ZAP3WA.Master" AutoEventWireup="true" CodeBehind="Home.aspx.cs" Inherits="InterfacesTrabajoGrupal.Home" %>

<asp:Content ID="cTitulo" ContentPlaceHolderID="cphTitulo" runat="server">
    Home
</asp:Content>

<asp:Content ID="cScripts" ContentPlaceHolderID="cphScripts" runat="server">
</asp:Content>

<asp:Content ID="Content3" ContentPlaceHolderID="cphContenido" runat="server">
    <!--<h1>Contenido de la pagina</h1>-->
    <h1 style="background-color: darkblue;">
        <br />
        <br />
        <div>
            <img src="Imagenes/WhatsApp Image 2024-04-16 at 21.43.57.jpeg" alt="Imagen de Ejemplo" width="300" height="300">
        </div>
        <br />
        <br />
    </h1>

    <div class="container" style="background-color: darkcyan">
        <h2>Nuestros Servicios</h2>
        <p>Descubre todo lo que tenemos para ti:</p>
        <style>
            ul {
                list-style-type: none; /* Eliminar viñetas de la lista */
                margin: 0;
                padding: 0;
                overflow: hidden; /* Evitar que los elementos se desborden */
                white-space: nowrap; /* Evitar el salto de línea */
            }

            li {
                display: inline-block; /* Mostrar elementos en línea */
                vertical-align: top; /* Alinear elementos verticalmente en la parte superior */
                margin-right: 20px; /* Espacio entre elementos */
            }

            img {
                display: block;
                margin: 0 auto; /* Centrar la imagen horizontalmente */
            }
        </style>

        <ul>
            <li>
                <p>Productos Frescos</p>
                <img src="Imagenes/Piramide-de-alimentos-Blog-Bienestar-y-Nutricion-Alqueria.jpg" alt="Imagen de Ejemplo" width="300" height="300">
            </li>
            <li>
                <p>Electrodomésticos</p>
                <img src="Imagenes/images.jpeg" alt="Imagen de Ejemplo" width="300" height="300">
            </li>
            <li>
                <p>Ropa y Accesorios</p>
                <img src="Imagenes/images2.jpeg" alt="Imagen de Ejemplo" width="300" height="300">
            </li>
            <li>
                <p>Tecnología</p>
                <img src="Imagenes/images (1).jpeg" alt="Imagen de Ejemplo" width="300" height="300">
            </li>
            <li>
                <p>y mucho más...</p>
                <img src="Imagenes/WhatsApp Image 2024-04-16 at 21.43.57.jpeg" alt="Imagen de Ejemplo" width="300" height="300">
            </li>
        </ul>

    </div>
</asp:Content>

