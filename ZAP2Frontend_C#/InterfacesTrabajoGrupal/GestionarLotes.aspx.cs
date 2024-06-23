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
        private AreaWSClient areaDao;

        protected void Page_Load(object sender, EventArgs e)
        {
            lblTitulo.Text = "Registrar lote";
            CargarBanco();
        }

        private void CargarBanco()
        {
            areaDao = new AreaWSClient();
            var areas = areaDao.listarAreaConSucursales();
            ddlSucursal.Items.Clear();
            foreach (var area in areas)
            {
                ddlSucursal.Items.Add(new ListItem(area.nombre, area.sucursal.id_sucursal.ToString()));

            }
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
                banco.idLote = string.IsNullOrEmpty(txtIdLote.Text) ? 0 : int.Parse(txtIdLote.Text);
                banco.stockInicial = Int32.Parse(txtStockInicial.Text);
                banco.stockActual = Int32.Parse(txtStockFinal.Text);
                banco.almacen = new almacen();
                banco.almacen.id_almacen = Int32.Parse(ddlSucursal.SelectedValue);

                try
                {
                    if (banco.idLote > 0)
                    {
                        bancoDao.modificarLote(banco);
                    }
                    else
                    {
                        banco.idLote = bancoDao.insertarLote(banco);
                    }
                    Response.Redirect("ListarLotes.aspx");
                }
                catch (Exception ex)
                {
                    // Manejar la excepción y mostrar un mensaje de error
                    ClientScript.RegisterStartupScript(this.GetType(), "alert", $"alert('Error al guardar el lote: {ex.Message}');", true);
                }
            }
        }
    }
}