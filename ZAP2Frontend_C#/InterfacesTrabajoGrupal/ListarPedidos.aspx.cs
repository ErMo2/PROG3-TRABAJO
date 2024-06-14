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
    public partial class GestionPedidos : System.Web.UI.Page
    {
        private Documento_de_CompraWSClient documentoCompraDAO;
        private BindingList<documentoDeCompra> listarDocumentosDeCompra;

        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                CargarDatos();
            }
        }

        private void CargarDatos()
        {
            try
            {
                documentoCompraDAO = new Documento_de_CompraWSClient();
                documentoDeCompra[] arregloDocumentos = documentoCompraDAO.listarDocumentosCompras();
                if (arregloDocumentos != null)
                    listarDocumentosDeCompra = new BindingList<documentoDeCompra>(arregloDocumentos);

                gvListaDocumentoDeCompra.DataSource = listarDocumentosDeCompra;
                gvListaDocumentoDeCompra.DataBind();
                ViewState["DocumentosDeCompra"] = listarDocumentosDeCompra; // Guardar en ViewState
            }
            catch (Exception ex)
            {
                // Manejo de errores
                //lblError.Text = "Error al cargar datos: " + ex.Message;
            }
        }

        protected void gvListaDocumentoDeCompra_PageIndexChanging(object sender, GridViewPageEventArgs e)
        {
            gvListaDocumentoDeCompra.PageIndex = e.NewPageIndex;
            CargarDatos();
        }

        protected void lbRegistrarDocumentoDeCompra_Click(object sender, EventArgs e)
        {
            Response.Redirect("RegistrarDocumentoDeCompra.aspx");
        }

    }
}