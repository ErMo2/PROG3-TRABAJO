<%@ Page Title="" Language="C#" MasterPageFile="~/ZAP3WA.Master" AutoEventWireup="true" CodeBehind="GestionarDocumentoDeVenta.aspx.cs" Inherits="InterfacesTrabajoGrupal.GestionarDocumentoDeVenta" %>

<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphScripts" runat="server">
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="cphContenido" runat="server">

    <!DOCTYPE html>
    <html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <title>Documento de Ventas</title>
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet" />
        <style>
            body {
                background-color: #f4f4f4;
                font-family: 'Arial', sans-serif;
            }

            .container {
                background-color: white;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
                border-radius: 5px;
                padding: 20px;
                margin-top: 50px;
            }

            h2 {
                color: #333;
                margin-bottom: 30px;
            }

            .btn {
                padding: 10px 20px;
                font-size: 18px;
            }

            .btn-primary, .btn-secondary {
                display: flex;
                align-items: center;
                justify-content: center;
            }

            .btn img {
                margin-right: 10px; /* Space between image and text */
                height: 50px; /* Fixed height for all images */
            }

            .btn-primary {
                background-color: #007bff;
                border-color: #007bff;
            }

            .btn-secondary {
                background-color: #6c757d;
                border-color: #6c757d;
            }

            .col-md-6 {
                margin-bottom: 20px; /* Space between buttons */
            }
        </style>
    </head>
    <body>
        <div class="container">
            <h2>Documento de Ventas</h2>
            <div class="row">

                <div class="col-md-6">
                    <asp:LinkButton ID="btnBoletaVenta" runat="server" CssClass="btn btn-primary w-100" OnClick="btnBoletaVenta_Click">
                <img src="Imagenes/boletaVenta.png" style="height: 100px; width: auto; vertical-align: middle; margin-right: 10px;" />
                Boleta de Venta
                    </asp:LinkButton>
                </div>
                <div class="col-md-6">
                    <asp:LinkButton ID="btnFacturaVenta" runat="server" CssClass="btn btn-secondary w-100" OnClick="btnFacturaVenta_Click">
                <img src="Imagenes/facturaVenta.jpg" style="height: 100px; width: auto; vertical-align: middle; margin-right: 10px;" />
                Factura de Venta
                    </asp:LinkButton>
                </div>


            </div>
        </div>
    </body>
    </html>





</asp:Content>
