using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace InterfacesTrabajoGrupal
{
    public partial class SeleccionarTipoDeDocumentoDeVenta : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }
        protected void Page_Init(object sender, EventArgs e)
        {

        }
        protected void btnBoletaVenta_Click(object sender, EventArgs e)
        {
            Response.Redirect("GestionarBoletaVenta.aspx");
        }
        protected void btnFacturaVenta_Click(object sender, EventArgs e)
        {
            Response.Redirect("GestionarFacturaVenta.aspx");
        }
    }
}