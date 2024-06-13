<%@ Page Title="" Language="C#" MasterPageFile="~/ZAP3WA.Master" AutoEventWireup="true" CodeBehind="CambiarContrasenia.aspx.cs" Inherits="InterfacesTrabajoGrupal.CambiarContraseña" %>

<asp:Content ID="Content1" ContentPlaceHolderID="cphTitulo" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="cphScripts" runat="server">
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .form-group {
            margin-bottom: 20px;
        }

            .form-group label {
                display: block;
                font-weight: bold;
                margin-bottom: 5px;
            }

            .form-group input[type="password"] {
                width: 100%;
                padding: 10px;
                font-size: 16px;
                border: 1px solid #ccc;
                border-radius: 4px;
            }

            .form-group input[type="submit"], .form-group input[type="button"] {
                padding: 10px 20px;
                font-size: 16px;
                background-color: #007bff;
                color: #fff;
                border: none;
                border-radius: 4px;
                cursor: pointer;
            }

                .form-group input[type="submit"]:hover, .form-group input[type="button"]:hover {
                    background-color: #0056b3;
                }
    </style>
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="cphContenido" runat="server">
    <div class="container">
        <div class="row">
            <div class="col-md-6 offset-md-3">
                <h1 class="text-center">Cambiar Contraseña</h1>
                <div class="form-group">
                    <label for="txtContraseniaActual">Contraseña actual:</label>
                    <input id="txtContraseniaActual" runat="server" type="password" class="form-control" placeholder="Contraseña actual" />
                </div>
                <div class="form-group">
                    <label for="txtNuevaContrasenia">Nueva contraseña:</label>
                    <input id="txtNuevaContrasenia" runat="server" type="password" class="form-control" placeholder="Nueva contraseña" />
                </div>
                <div class="form-group">
                    <label for="txtConfirmarContrasenia">Confirmar nueva contraseña:</label>
                    <input id="txtConfirmarContrasenia" runat="server" type="password" class="form-control" placeholder="Confirmar nueva contraseña" />
                </div>
                <div class="form-group text-center">
                    <asp:Button ID="btnConfirmar" runat="server" Text="Confirmar" OnClick="btnConfirmar_Click" CssClass="btn btn-primary" />
                    <asp:Button ID="btnCancelar" runat="server" Text="Cancelar" OnClick="btnCancelar_Click" CssClass="btn btn-secondary" />
                </div>
            </div>
        </div>
    </div>
</asp:Content>
