using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace InterfacesTrabajoGrupal
{
    public partial class SeleccionarTipoDeProducto : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }
        protected void lblRopa_Click(object sender, EventArgs e)
        {
            Response.Redirect("GestionarRopa.aspx");
        }
        protected void lblElectrodomestico_Click(object sender, EventArgs e)
        {
            Response.Redirect("GestionarElectrodomestico.aspx");

        }
        protected void lblLimpieza_Click(object sender, EventArgs e)
        {
            Response.Redirect("GestionarProductoPersonalYHogar.aspx");
        }
        protected void lblPerecible_Click(object sender, EventArgs e)
        {
            Response.Redirect("GestionarProdPerecible.aspx");
        }

    }
}