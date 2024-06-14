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

        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                CargarDatos();
            }
        }

        private void CargarDatos()
        {
            AlmacenDao = new AlmacenWSClient();
            almacen[] arregloAlmacenes = AlmacenDao.listarAlmacen();
            if (arregloAlmacenes != null)
                listaAlmacenes = new BindingList<almacen>(arregloAlmacenes);

            gvAlmacenes.DataSource = listaAlmacenes;
            gvAlmacenes.DataBind();
        }

        protected void lbRegistrarAlmacen_Click(object sender, EventArgs e)
        {
            Response.Redirect("GestionarAlmacenes.aspx");
        }

        protected void gvAlmacenes_PageIndexChanging(object sender, GridViewPageEventArgs e)
        {
            gvAlmacenes.PageIndex = e.NewPageIndex;
            CargarDatos();
        }

        protected void gvAlmacenes_RowCommand(object sender, GridViewCommandEventArgs e)
        {
            AlmacenDao = new AlmacenWSClient();
            int idAlmacen = int.Parse(e.CommandArgument.ToString());
            if (e.CommandName == "Ver")
            {
                AlmacenDao = new AlmacenWSClient();
                almacen[] arregloAlmacenes = AlmacenDao.listarAlmacen();
                if (arregloAlmacenes != null)
                    listaAlmacenes = new BindingList<almacen>(arregloAlmacenes);

                gvAlmacenes.DataSource = listaAlmacenes;
                gvAlmacenes.DataBind();

                almacen almacenSeleccionado = listaAlmacenes.Where(a => a.id_almacen == idAlmacen).SingleOrDefault();
                if (almacenSeleccionado != null)
                {
                    lblDetallesAlmacen.Text = $@"
                        <strong>Id Almacén:</strong> {almacenSeleccionado.id_almacen}<br />
                        <strong>Tipo de Almacén:</strong> {almacenSeleccionado.tipoAlmacen}<br />
                        <strong>Capacidad Máxima de Productos:</strong> {almacenSeleccionado.capacidadMaximaProductos}<br />
                        <strong>Capacidad Actual de Productos:</strong> {almacenSeleccionado.capacidadActualProductos}<br />
                        <strong>Id Sucursal:</strong> {almacenSeleccionado.sucursal.id_sucursal}<br/>
                        <strong>Direccion Sucursal:</strong> {almacenSeleccionado.sucursal.direccion}<br/>
                       <strong>Tamaño metros cuadrados Sucursal:</strong> {almacenSeleccionado.sucursal.tam_metros}

                    ";
                    ScriptManager.RegisterStartupScript(this, this.GetType(), "ShowModal", "$('#detallesAlmacenModal').modal('show');", true);
                }
            }
            else if (e.CommandName == "Modificar")
            {
                Response.Redirect($"GestionarAlmacenes.aspx?id={idAlmacen}");
            }
            else if (e.CommandName == "Eliminar")
            {
                AlmacenDao.eliminarAlmacen(idAlmacen);
                CargarDatos();
            }
        }
    }
}