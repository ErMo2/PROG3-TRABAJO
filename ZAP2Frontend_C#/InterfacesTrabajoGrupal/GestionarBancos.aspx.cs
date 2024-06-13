using InterfacesTrabajoGrupal.ServicioWS;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace InterfacesTrabajoGrupal
{
    public partial class GestionarBancos : System.Web.UI.Page
    {
        private BancoWSClient bancoDao;
        private banco banco;

        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                bancoDao = new BancoWSClient();
                int idBanco;
                if (int.TryParse(Request.QueryString["id"], out idBanco))
                {
                    CargarBanco(idBanco);
                    lblTitulo.Text = "Modificar Banco";
                }
                else
                {
                    lblTitulo.Text = "Registrar Banco";
                }
            }
        }

        private void CargarBanco(int idBanco)
        {
            bancoDao = new BancoWSClient();
            banco[] bancos = bancoDao.listarBancosTodos();

            // Buscar el banco con el ID especificado
            banco banco = Array.Find(bancos, b => b.idBanco == idBanco);

            if (banco != null)
            {
                txtIdBanco.Text = banco.idBanco.ToString();
                txtNombreBanco.Text = banco.nombre;
            }
            else
            {
                // Manejar el caso en que no se encuentre el banco
                ClientScript.RegisterStartupScript(this.GetType(), "alert", "alert('Banco no encontrado.');", true);
                Response.Redirect("ListarBancos.aspx");
            }
        }

        protected void btnRegresar_Click(object sender, EventArgs e)
        {
            Response.Redirect("ListarBancos.aspx");
        }

        protected void btnGuardar_Click(object sender, EventArgs e)
        {
            bancoDao = new BancoWSClient();
            if (Page.IsValid)
            {
                banco = new banco();
                banco.idBanco = string.IsNullOrEmpty(txtIdBanco.Text) ? 0 : int.Parse(txtIdBanco.Text);
                banco.nombre = txtNombreBanco.Text;


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