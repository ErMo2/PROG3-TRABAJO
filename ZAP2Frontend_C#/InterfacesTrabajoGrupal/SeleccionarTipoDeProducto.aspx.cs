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
            Response.Redirect("Ropa.aspx");
        }
        protected void lblElectrodomestico_Click(object sender, EventArgs e)
        {
            Response.Redirect("Electrodomestico.aspx");

        }
        protected void lblLimpieza_Click(object sender, EventArgs e)
        {
            Response.Redirect("ProductoPersonalYHogar.aspx");
        }
        protected void lblPerecible_Click(object sender, EventArgs e)
        {
            Response.Redirect("ProdPerecible.aspx");
        }

    }
}