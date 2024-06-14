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
    public partial class GestionarSucursal : System.Web.UI.Page
    {
        private AlmacenWSClient almacenDAO;
        private SucursalWSClient sucursalDAO;
        private MovimientoLoteWSClient movimientoLoteDAO;
        private LoteWSClient loteDAO;
        private BindingList<movimientoLote> movimientosLoteList;
        private BindingList<lote> lotesList;
        private BindingList<almacen> listaAlmacenes;

        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                almacenDAO = new AlmacenWSClient();
                sucursalDAO = new SucursalWSClient();
                movimientoLoteDAO = new MovimientoLoteWSClient();
                loteDAO = new LoteWSClient();

                CargarTiposDeAlmacen();
                CargarSucursales();
                CargarMovimientosDeLote();
                CargarLotes();

                if (Request.QueryString["id"] != null)
                {
                    int idAlmacen = int.Parse(Request.QueryString["id"]);
                    CargarDatosAlmacen(idAlmacen);
                }
            }
        }

        private void CargarDatosAlmacen(int idAlmacen)
        {
            almacen[] arregloAlmacenes = almacenDAO.listarAlmacen();
            if (arregloAlmacenes != null)
                listaAlmacenes = new BindingList<almacen>(arregloAlmacenes);

            almacen almacen = listaAlmacenes.SingleOrDefault(a => a.id_almacen == idAlmacen);
            if (almacen != null)
            {
                // Asigna los valores del almacén a los controles
                txtIdAlmacen.Text = almacen.id_almacen.ToString();
                ddlTipoAlmacen.SelectedValue = almacen.tipoAlmacen.ToString();
                txtCapacidadMaxima.Text = almacen.capacidadMaximaProductos.ToString();
                txtCapacidadActual.Text = almacen.capacidadActualProductos.ToString();
                ddlSucursal.SelectedValue = almacen.sucursal.id_sucursal.ToString();
                // Completa los demás campos según sea necesario
            }
        }

        private void CargarTiposDeAlmacen()
        {
            ddlTipoAlmacen.Items.Add(new ListItem("AlmacenComún", "AlmacenComun"));
            ddlTipoAlmacen.Items.Add(new ListItem("Congeladora", "Congeladora"));
            ddlTipoAlmacen.Items.Add(new ListItem("Refrigeradora", "Refrigeradora"));
            ddlTipoAlmacen.Items.Add(new ListItem("AlmacenSeco", "AlmacenSeco"));
            ddlTipoAlmacen.Items.Add(new ListItem("AlmacenDeProductosQuimicos", "AlmacenDeProductosQuimicos"));
            ddlTipoAlmacen.Items.Add(new ListItem("AlmacenElectronicos", "AlmacenElectronicos"));
        }

        private void CargarSucursales()
        {
            var sucursales = sucursalDAO.listarSucursal();
            ddlSucursal.Items.Clear();
            foreach (var sucursal in sucursales)
            {
                ddlSucursal.Items.Add(new ListItem(sucursal.nombre, sucursal.id_sucursal.ToString()));
            }
        }

        private void CargarMovimientosDeLote()
        {
            movimientosLoteList = new BindingList<movimientoLote>(movimientoLoteDAO.listarMovimientoLote());
            ddlMovimientoLote.Items.Clear();
            foreach (var movimiento in movimientosLoteList)
            {
                ddlMovimientoLote.Items.Add(new ListItem(movimiento.motivo.ToString(), movimiento.idMovimientoLote.ToString()));
            }
        }

        private void CargarLotes()
        {
            lotesList = new BindingList<lote>(loteDAO.listarLote());
            ddlLote.Items.Clear();
            foreach (lote lote in lotesList)
            {
                // Verificar si movLote no es null antes de agregarlo a la lista
                string movLoteText = lote.movLote != null ? lote.movLote.ToString() : "N/A";
                ddlLote.Items.Add(new ListItem(movLoteText, lote.idLote.ToString()));
            }
        }

        protected void btnRegistrar_Click(object sender, EventArgs e)
        {
            almacenDAO = new AlmacenWSClient();
            almacen almacen = new almacen();

            // Asignar el tipo de almacén utilizando un switch o if-else
            switch (ddlTipoAlmacen.SelectedValue)
            {
                case "AlmacenComun":
                    almacen.tipoAlmacen = tipoAlmacen.AlmacenComun;
                    break;
                case "Congeladora":
                    almacen.tipoAlmacen = tipoAlmacen.Congeladora;
                    break;
                case "Refrigeradora":
                    almacen.tipoAlmacen = tipoAlmacen.Refrigeradora;
                    break;
                case "AlmacenSeco":
                    almacen.tipoAlmacen = tipoAlmacen.AlmacenSeco;
                    break;
                case "AlmacenDeProductosQuimicos":
                    almacen.tipoAlmacen = tipoAlmacen.AlmacenDeProductosQuimicos;
                    break;
                case "AlmacenElectronicos":
                    almacen.tipoAlmacen = tipoAlmacen.AlmacenElectronicos;
                    break;
                default:
                    break;
            }
            almacen.tipoAlmacenSpecified = true;
            almacen.activo = true;
            almacen.sucursal = new sucursal { id_sucursal = int.Parse(ddlSucursal.SelectedValue) };

            almacen.capacidadActualProductos = double.Parse(txtCapacidadActual.Text);
            almacen.capacidadMaximaProductos = double.Parse(txtCapacidadMaxima.Text);

            if (Request.QueryString["id"] != null)
            {
                // Modificar el almacén existente
                almacen.id_almacen = int.Parse(txtIdAlmacen.Text);
                almacenDAO.modificarAlmacen(almacen);
            }
            else
            {
                // Insertar un nuevo almacén
                almacen.id_almacen = almacenDAO.insertarAlmacen(almacen);
            }

            // Redireccionar a la página de listado
            Response.Redirect("ListarAlmacenes.aspx");
        }

        protected void btnRegresar_Click(object sender, EventArgs e)
        {
            Response.Redirect("ListarAlmacenes.aspx");
        }
    }
}