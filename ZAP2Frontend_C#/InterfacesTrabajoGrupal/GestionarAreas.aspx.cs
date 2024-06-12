using SoftProgRRHHModel;
using System;
using System.Collections.Generic;
using System.Diagnostics.Eventing.Reader;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace InterfacesTrabajoGrupal
{
    public partial class GestionarAreas : System.Web.UI.Page
    {
        private AreaDAO daoArea;
        private Area area;
        private Estado estado;
        protected void Page_Load(object sender, EventArgs e)
        {

        }
        protected void Page_Init(object sender, EventArgs e)
        {
            daoArea = new AreaMySQL();
            area = (Area)Session["area"];
            String accion = Request.QueryString["accion"];
           /* if(accion!=null && accion == "modificar")
            {
                estado = Estado.Modificar;
                if (!IsPostBack)
                   // cargarDatos();
                else
                    estado = Estado.Nuevo;
            }
            */
        }
        protected void btnRegistrar_Click(object sender, EventArgs e)
        {
            Response.Redirect("ListarAreas.aspx");
        }
        protected void btnRegresar_Click(object senmder,EventArgs e)
        {
            Response.Redirect("ListarAreas.aspx");
        }
    }
}