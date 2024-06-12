using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace InterfacesTrabajoGrupal
{
	public partial class GestionarDocumentoDeVenta : System.Web.UI.Page
	{
		protected void Page_Load(object sender, EventArgs e)
		{

		}

        protected void btnFacturaVenta_Click(object sender, EventArgs e)
        {
            Response.Redirect("FacturaVenta.aspx");
        }
        protected void btnRegresar_Click(object sender, EventArgs e)
        {
            Response.Redirect("ListarDocumentoDeVenta.aspx");
        }

        protected void btnBoletaVenta_Click(object sender, EventArgs e)
        {
            Response.Redirect("BoletaVenta.aspx");

        }

        protected void btnBuscarCliente_Click1(object sender, EventArgs e)
        {

        }

        protected void btnBuscarProducto_Click(object sender, EventArgs e)
        {

        }

        protected void btnEliminarProducto_Click(object sender, EventArgs e)
        {

        }

        protected void lbAgregarLOV_Click(object sender, EventArgs e)
        {

        }

        protected void btnGuardar_Click(object sender, EventArgs e)
        {

        }

        protected void lbBuscar_Click(object sender, EventArgs e)
        {

        }

        protected void gvLineasOrdenVenta_SelectedIndexChanged(object sender, EventArgs e)
        {

        }
    }
}