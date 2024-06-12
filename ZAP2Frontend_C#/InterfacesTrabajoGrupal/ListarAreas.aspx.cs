using InterfacesTrabajoGrupal.ServicioWS;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace InterfacesTrabajoGrupal
{
    public partial class GestionAreas : System.Web.UI.Page
    {
        private AreaWSClient daoArea;
        private BindingList<area> areas;
        protected void Page_Load(object sender, EventArgs e)
        {
            daoArea = new AreaWSClient();
            area[] ArregloAreas = daoArea.listarArea();
            if(ArregloAreas!=null)
                areas=new BindingList<area>(ArregloAreas);
            gvAreas.DataSource = areas;
            gvAreas.DataBind();
        }
        protected void lbRegistrarArea_Click(object sender,EventArgs e)
        {
            Response.Redirect("GestionarAreas.aspx");
        }
        
        protected void lbEliminarArea_Cick(object sender,EventArgs e)
        {
            Response.Redirect("GestionarAreas.aspx");
        }
         protected void gvAreas_PageIndexChanging(object sender, GridViewPageEventArgs e)
        {
            gvAreas.PageIndex = e.NewPageIndex;
            gvAreas.DataBind();
        }

        protected void lbEditarArea_Click(object sender, EventArgs e)
        {
            int idArea = Int32.Parse(((LinkButton)sender).CommandArgument);
            area area=areas.SingleOrDefault(x=>x.idArea == idArea);
            Session["area"] = area;
            Response.Redirect("GestionarAreas.aspx");

        }
    }
}