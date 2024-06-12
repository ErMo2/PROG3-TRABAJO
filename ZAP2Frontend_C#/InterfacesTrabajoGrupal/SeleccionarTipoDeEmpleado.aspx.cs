using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace InterfacesTrabajoGrupal
{
    public partial class SeleccionarTipoDeEmpleado : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }


        protected void lblGerente_Click(object sender, EventArgs e)
        {
            Response.Redirect("Gerente.aspx");
        }

        protected void lblEmpleadoArea_Click(object sender, EventArgs e)
        {
            Response.Redirect("EmpleadoArea.aspx");

        }

        protected void lblCajero_Click(object sender, EventArgs e)
        {
            Response.Redirect("Cajero.aspx");

        }
    }
}