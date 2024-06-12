using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace InterfacesTrabajoGrupal
{
    public partial class GestionarEmpleados1 : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }
        protected void btnRegistrar_Click(object sender, EventArgs e)
        {
            Response.Redirect("ListarAreas.aspx");
        }
        protected void btnRegresar_Click(object senmder, EventArgs e)
        {
            Response.Redirect("ListarEmpleados.aspx");
        }
        protected void btnCajero_Click(object senmder, EventArgs e)
        {
            Response.Redirect("Cajero.aspx");
        }
        protected void btnGerente_Click(object senmder, EventArgs e)
        {
            Response.Redirect("Gerente.aspx");
        }
        protected void btnEmpleadoDeArea_Click(object senmder, EventArgs e)
        {
            Response.Redirect("EmpleadoArea.aspx");
        }
    }
}