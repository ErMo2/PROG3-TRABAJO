using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace InterfacesTrabajoGrupal
{
    public partial class GestionarProductos : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }
        protected void btnRegistrar_Click(object sender, EventArgs e)
        {
            Response.Redirect("ListarProductos.aspx");
        }
        protected void btnRegresar_Click(object senmder, EventArgs e)
        {
            Response.Redirect("ListarProductos.aspx");
        }
        protected void btnRegPP_Click(object sender, EventArgs e)
        {
            Response.Redirect("ProdPerecible.aspx");
        }
        protected void btnRegPCPH_Click(object senmder, EventArgs e)
        {
            Response.Redirect("ProductoPersonalYHogar.aspx");
        }
        protected void btnRegRopa_Click(object sender, EventArgs e)
        {
            Response.Redirect("Ropa.aspx");
        }
        protected void btnRegELec_Click(object senmder, EventArgs e)
        {
            Response.Redirect("Electrodomestico.aspx");
        }
    }
}