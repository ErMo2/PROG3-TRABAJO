using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace InterfacesTrabajoGrupal
{
    public partial class SeleccionarTipoDeDocumento : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }
        protected void lblDocumentoVenta_Click(object sender,EventArgs e)
        {
            Response.Redirect("listarDocumentoDeVenta.aspx");
        }
        protected void lblDocumentoCompra_Click(object sender,EventArgs e)
        {
            Response.Redirect("GestionarDocumentoDeCompra.aspx");
        }
    }
}