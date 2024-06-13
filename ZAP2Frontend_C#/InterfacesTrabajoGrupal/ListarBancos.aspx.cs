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
    public partial class ListarBancos : System.Web.UI.Page
    {
        private BancoWSClient daoBanco;
        private BindingList<banco> bancos;

        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                CargarBancos();
            }
        }

        private void CargarBancos()
        {
            daoBanco = new BancoWSClient();
            banco[] arregloBancos = daoBanco.listarBancosTodos();
            if (arregloBancos != null)
            {
                bancos = new BindingList<banco>(arregloBancos);
                gvBancos.DataSource = bancos;
                gvBancos.DataBind();
            }
        }

        protected void gvBancos_PageIndexChanging(object sender, GridViewPageEventArgs e)
        {
            gvBancos.PageIndex = e.NewPageIndex;
            CargarBancos();
        }

        /*protected void gvBancos_RowCommand(object sender, GridViewCommandEventArgs e)
        {
            
            int idBanco = Convert.ToInt32(e.CommandArgument);
            if (e.CommandName == "Modificar")
            {
                Response.Redirect($"ModificarBanco.aspx?id={idBanco}");
            }
            else if (e.CommandName == "Eliminar")
            {

                daoBanco.eliminarBanco(idBanco);
                CargarBancos();
            }
        }*/
       

        protected void lbRegistrarBanco_Click(object sender, EventArgs e)
        {
            Response.Redirect("RegistrarBanco.aspx");
        }
    }
}