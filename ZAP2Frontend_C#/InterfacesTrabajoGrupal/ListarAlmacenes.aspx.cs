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
    public partial class ListarSucursal : System.Web.UI.Page
    {
        private AlmacenWSClient AlmacenDao;
        private BindingList<almacen> listaAlmacenes;
        private almacen almacen;
        protected void Page_Load(object sender, EventArgs e)
        {
            AlmacenDao = new AlmacenWSClient();
            almacen[] arregloAlmacenes = AlmacenDao.listarAlmacen();
            if (arregloAlmacenes != null)
                listaAlmacenes = new BindingList<almacen>(arregloAlmacenes);

            gvAlmacenes.DataSource = listaAlmacenes;
            gvAlmacenes.DataBind();
        }
        protected void Page_init(object sender, EventArgs e)
        {

        }
        protected void lbRegistrarAlmacen_Click(object sender, EventArgs e)
        {

            Response.Redirect("GestionarAlmacenes.aspx");
        }
        protected void gvAlmacenes_PageIndexChanging(object sender, GridViewPageEventArgs e)
        {
            gvAlmacenes.PageIndex = e.NewPageIndex;
        }

    }
}