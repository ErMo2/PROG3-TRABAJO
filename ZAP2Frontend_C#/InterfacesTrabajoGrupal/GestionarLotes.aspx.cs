using InterfacesTrabajoGrupal.ServicioWS;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace InterfacesTrabajoGrupal
{
    public partial class GestionarLotes : System.Web.UI.Page
    {
        private LoteWSClient bancoDao;
        private lote banco;

        protected void Page_Load(object sender, EventArgs e)
        {
            lblTitulo.Text = "Registrar lote";
        }

        private void CargarBanco()
        {
            
        }

        protected void btnRegresar_Click(object sender, EventArgs e)
        {
            Response.Redirect("ListarLotes.aspx");
        }

        protected void btnGuardar_Click(object sender, EventArgs e)
        {
            bancoDao = new LoteWSClient();
            if (Page.IsValid)
            {
                banco = new lote();
                banco.idLote = string.IsNullOrEmpty(txtIdBanco.Text) ? 0 : int.Parse(txtIdBanco.Text);
                banco.stockInicial = txtNombreBanco.Text;
                banco.stockActual = 
            

                try
                {
                    if (banco.idBanco > 0)
                    {
                        bancoDao.modificarBanco(banco);
                    }
                    else
                    {
                        banco.idBanco = bancoDao.insertarBanco(banco);
                    }
                    Response.Redirect("ListarBancos.aspx");
                }
                catch (Exception ex)
                {
                    // Manejar la excepción y mostrar un mensaje de error
                    ClientScript.RegisterStartupScript(this.GetType(), "alert", $"alert('Error al guardar el banco: {ex.Message}');", true);
                }
            }
        }
    }
}