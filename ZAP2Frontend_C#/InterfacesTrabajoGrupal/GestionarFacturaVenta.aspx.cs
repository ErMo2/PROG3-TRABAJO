using InterfacesTrabajoGrupal.ServicioWS;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.ServiceModel.Channels;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace InterfacesTrabajoGrupal
{
    public partial class FacturaVenta : System.Web.UI.Page
    {
        private FacturaVenta facturaVenta;
        private Factura_VentaWSClient facturaVentaDAO;
        private PersonaJuridicaWSClient personaJuridicaDAO;
        private SucursalWSClient sucursalDAO;
        private BindingList<personaJuridica> listaPersonasJuridicas;
        private BindingList<producto> listaProductos;
        private BindingList<sucursal> listaSucursales;

        // Productos DAO
        private ProductoPerecibleWSClient productoPerDAO;
        private ProductosParaElCuidadoPersonalYDelHogarWSClient productoPHDAO;
        private RopaWSClient ropaDAO;
        private ElectrodomesticosWSClient electrodomesticoDAO;

        private BindingList<producto> productosSeleccionados;

        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                productosSeleccionados = new BindingList<producto>();
                Session["ProductosSeleccionados"] = productosSeleccionados;

                CargarPersonasJuridicas();
                CargarProductos();
                CargarSucursales();
            }
            else
            {
                productosSeleccionados = Session["ProductosSeleccionados"] as BindingList<producto>;
            }
        }

        private void CargarPersonasJuridicas()
        {
            personaJuridicaDAO = new PersonaJuridicaWSClient();
            personaJuridica[] arregloPersonasJuridicas = personaJuridicaDAO.listarPersonasJuridicas();
            if (arregloPersonasJuridicas != null)
            {
                listaPersonasJuridicas = new BindingList<personaJuridica>(arregloPersonasJuridicas);
                ddlPersonaJuridica.DataSource = listaPersonasJuridicas;
                ddlPersonaJuridica.DataTextField = "nombre";
                ddlPersonaJuridica.DataValueField = "id_persona";
                ddlPersonaJuridica.DataBind();
            }
        }

        private void CargarProductos()
        {
            listaProductos = new BindingList<producto>();

            // Producto Perecible
            productoPerDAO = new ProductoPerecibleWSClient();
            producto[] arregloProductoPerecible = productoPerDAO.listarProductoPerecible();
            if (arregloProductoPerecible != null)
            {
                foreach (var producto in arregloProductoPerecible)
                {
                    listaProductos.Add(producto);
                }
            }

            // Producto Personal y Hogar
            productoPHDAO = new ProductosParaElCuidadoPersonalYDelHogarWSClient();
            producto[] arregloProductoPH = productoPHDAO.listarPCH();
            if (arregloProductoPH != null)
            {
                foreach (var producto in arregloProductoPH)
                {
                    listaProductos.Add(producto);
                }
            }

            // Ropa
            ropaDAO = new RopaWSClient();
            producto[] arregloRopa = ropaDAO.listarRopa();
            if (arregloRopa != null)
            {
                foreach (var producto in arregloRopa)
                {
                    listaProductos.Add(producto);
                }
            }

            // Electrodoméstico
            electrodomesticoDAO = new ElectrodomesticosWSClient();
            producto[] arregloElectrodomestico = electrodomesticoDAO.listarElectrodomesticos();
            if (arregloElectrodomestico != null)
            {
                foreach (var producto in arregloElectrodomestico)
                {
                    listaProductos.Add(producto);
                }
            }

            ddlProducto.DataSource = listaProductos;
            ddlProducto.DataTextField = "nombre";
            ddlProducto.DataValueField = "idProducto";

            ddlProducto.DataBind();
        }

        private void CargarSucursales()
        {
            sucursalDAO = new SucursalWSClient();
            sucursal[] arregloSucursales = sucursalDAO.listarSucursal();
            if (arregloSucursales != null)
            {
                listaSucursales = new BindingList<sucursal>(arregloSucursales);
                ddlSucursal.DataSource = listaSucursales;
                ddlSucursal.DataTextField = "nombre";
                ddlSucursal.DataValueField = "id_sucursal";
                ddlSucursal.DataBind();
            }
        }

        protected void btnAgregarProducto_Click(object sender, EventArgs e)
        {
            int idProducto = int.Parse(ddlProducto.SelectedValue);
            int cantidad = int.Parse(txtCantidad.Text);

            producto prod = listaProductos.FirstOrDefault(p => p.idProducto == idProducto);
            if (prod != null)
            {
                producto prodSel = new producto();
                prodSel.nombre = prod.nombre;
                prodSel.cantidadComprada = cantidad;
                prodSel.prodPrecio.precio = prod.prodPrecio.precio;

                //Total = prod.precio * cantidad
                productosSeleccionados.Add(prodSel);

                gvProductosSeleccionados.DataSource = productosSeleccionados;
                gvProductosSeleccionados.DataBind();
            }
        }

        protected void btnEliminarProducto_Click(object sender, EventArgs e)
        {
            Button btn = (Button)sender;
            int index = int.Parse(btn.CommandArgument);
            productosSeleccionados.RemoveAt(index);

            gvProductosSeleccionados.DataSource = productosSeleccionados;
            gvProductosSeleccionados.DataBind();
        }

        protected void btnRegresar_Click(object sender, EventArgs e)
        {
            Response.Redirect("GestionarDocumentoDeVenta.aspx");
        }

        protected void btnRegistrar_Click(object sender, EventArgs e)
        {
            // Lógica de registro aquí

            Response.Redirect("ListarDocumentoDeVenta.aspx");
        }
    }
}