using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace InterfacesTrabajoGrupal
{
    public partial class BoletaVenta : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }
        protected void btnBuscarCliente_Click(object sender, EventArgs e)
        {

        }
        protected void btnBuscarProducto_Click(object sender, EventArgs e)
        {
        }
        protected void btnRegresar_Click(object sender, EventArgs e)
        {
            Response.Redirect("GestionarDocumentoDeVenta.aspx");
        }
        protected void btnRegistrar_Click(object sender, EventArgs e)
        {
            Response.Redirect("ListarDocumentoDeVenta.aspx");
        }
        protected void btnEliminarProducto_Click(object sender,EventArgs e)
        {

        }
    }
}