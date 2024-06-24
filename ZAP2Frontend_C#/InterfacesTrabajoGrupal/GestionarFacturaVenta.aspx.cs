using InterfacesTrabajoGrupal.ServicioWS;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing.Printing;
using System.Linq;
using System.ServiceModel.Channels;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace InterfacesTrabajoGrupal
{
    public partial class FacturaVenta : System.Web.UI.Page
    {
        private PersonaJuridicaWSClient personaJuridicaDAO;
        private SucursalWSClient sucursalDAO;
        private ProductoPrecioWSClient productoPrecioDAO;

        private BindingList<personaJuridica> listaPersonasJuridicas;
        private BindingList<producto> listaProductos;
        private BindingList<sucursal> listaSucursales;
        private BindingList<producto> productosSeleccionados;
        private productoPrecio[] arregloProductoPrecios;
        //Listado de monedas
        private MonedaWSClient monedaDAO;
        private BindingList<moneda> listarMonedas;

        //Listar Cajeros
        private CajeroWSClient cajeroDAO;
        private BindingList<cajero> listarCajeros;
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                productosSeleccionados = new BindingList<producto>();
                Session["ProductosSeleccionados"] = productosSeleccionados;
                dtpFechaEmision.Text = DateTime.Now.ToString("yyyy-MM-dd");

                CargarMonedas();
                CargarPersonasJuridicas();
                CargarSucursales();
                // CargarCajeros();
                CargarTarjetas();
            }
            else
            {
                productosSeleccionados = Session["ProductosSeleccionados"] as BindingList<producto>;
            }
        }
        private void CargarCajerosPorSucursal(int idSucursal)
        {
            cajeroDAO = new CajeroWSClient();
            listarCajeros = new BindingList<cajero>(cajeroDAO.listarCajerosPorSucursal(idSucursal));
            if (listarCajeros != null)
            {
                ddlCajeros.DataSource = listarCajeros;

                ddlCajeros.DataTextField = "nombre";
                ddlCajeros.DataValueField = "id_Persona";
                ddlCajeros.DataBind();
            }
        }



        private TarjetaWSClient tarjetaDAO;
        private BindingList<tarjeta> listarTarjetas;

        private void CargarTarjetas()
        {
            tarjetaDAO = new TarjetaWSClient();
            listarTarjetas = new BindingList<tarjeta>(tarjetaDAO.listarTarjeta());
            ddlTarjetas.DataSource = listarTarjetas;
            ddlTarjetas.DataTextField = "tipoTarjeta";
            ddlTarjetas.DataValueField = "idTarjeta";
            ddlTarjetas.DataBind();
        }
        protected void btnBuscarPersonaJuridica_Click(object sender, EventArgs e)
        {
            string nombre = txtNombrePersonaJuridica.Text.Trim();
            CargarPersonasJuridicas(nombre);
        }

        private BindingList<personaJuridica> todasLasPersonasJuridicas;
        private void CargarPersonasJuridicas(string nombre = "")
        {

            personaJuridicaDAO = new PersonaJuridicaWSClient();
            todasLasPersonasJuridicas = new BindingList<personaJuridica>(personaJuridicaDAO.listarPersonasJuridicas());

            BindingList<personaJuridica> personasFiltradas;
            if (string.IsNullOrEmpty(nombre))
            {
                personasFiltradas = todasLasPersonasJuridicas;
            }
            else
            {
                personasFiltradas = new BindingList<personaJuridica>(todasLasPersonasJuridicas
                          .Where(p => p.nombre.IndexOf(nombre, StringComparison.OrdinalIgnoreCase) >= 0)
                          .ToList());
            }

            listaPersonasJuridicas = personasFiltradas;

            var personasJuridicasConRUC = listaPersonasJuridicas.Select(p => new
            {
                id_persona = p.id_Persona,
                nombreConRUC = $"{p.nombre} - {p.RUC}"
            }).ToList();

            ddlPersonaJuridica.DataSource = personasJuridicasConRUC;
            ddlPersonaJuridica.DataTextField = "nombreConRUC";
            ddlPersonaJuridica.DataValueField = "id_persona";
            ddlPersonaJuridica.DataBind();
        }

        protected void ddlPersonaJuridica_SelectedIndexChanged(object sender, EventArgs e)
        {
            int idPersonaSeleccionada = int.Parse(ddlPersonaJuridica.SelectedValue);
            var personaSeleccionada = listaPersonasJuridicas.FirstOrDefault(p => p.id_Persona == idPersonaSeleccionada);

            /* if (personaSeleccionada != null)
             {
                 txtRUC.Text = personaSeleccionada.RUC;
             }*/
        }

        private void CargarSucursales()
        {
            sucursalDAO = new SucursalWSClient();
            sucursal[] arregloSucursales = sucursalDAO.listarSucursal();
            listaSucursales = new BindingList<sucursal>(arregloSucursales);
            ddlSucursal.DataSource = listaSucursales;
            ddlSucursal.DataTextField = "nombre";
            ddlSucursal.DataValueField = "id_sucursal";
            ddlSucursal.DataBind();
        }

        private void CargarProductosPorSucursal()
        {
            int idSucursal = int.Parse(ddlSucursal.SelectedValue);
            productoPrecioDAO = new ProductoPrecioWSClient();
            arregloProductoPrecios = productoPrecioDAO.listarProductoPrecioProductoDeUnaSucursal(idSucursal);
            if (arregloProductoPrecios != null)
            {
                listaProductos = new BindingList<producto>(
                arregloProductoPrecios.Select(pp => pp.producto).Where(p => p != null).ToList()
            );

                ddlProducto.DataSource = listaProductos;
                ddlProducto.DataTextField = "nombre";
                ddlProducto.DataValueField = "idProducto";
                ddlProducto.DataBind();
            }
            CargarCajerosPorSucursal(idSucursal);

        }

        protected void ddlSucursal_SelectedIndexChanged(object sender, EventArgs e)
        {
            CargarProductosPorSucursal();
        }

        protected void btnAgregarProducto_Click(object sender, EventArgs e)
        {
            int idProducto = int.Parse(ddlProducto.SelectedValue);
            int cantidad = int.Parse(txtCantidad.Text);
            int idSucursal = int.Parse(ddlSucursal.SelectedValue);
            productoPrecioDAO = new ProductoPrecioWSClient();
            arregloProductoPrecios = productoPrecioDAO.listarProductoPrecioProductoDeUnaSucursal(idSucursal);

            productoPrecio prodPrecio = arregloProductoPrecios.FirstOrDefault(pp => pp.producto.idProducto == idProducto);
            producto prod = prodPrecio.producto;



            if (prod != null)
            {

                producto prodSel = new producto
                {
                    nombre = prod.nombre,
                    idProducto = prod.idProducto,
                    descripcion = prod.descripcion,
                    prodPrecio = new productoPrecio
                    {
                        idProductoPrecio = prodPrecio.idProductoPrecio,
                        precio = prodPrecio.precio
                    },
                    cantidadComprada = cantidad
                };

                productosSeleccionados.Add(prodSel);

                gvProductosSeleccionados.DataSource = productosSeleccionados;
                gvProductosSeleccionados.DataBind();

                CalcularTotal();
            }
        }

        protected void btnEliminarProducto_Click(object sender, EventArgs e)
        {
            Button btn = (Button)sender;
            int index = int.Parse(btn.CommandArgument);
            productosSeleccionados.RemoveAt(index);

            gvProductosSeleccionados.DataSource = productosSeleccionados;
            gvProductosSeleccionados.DataBind();

            CalcularTotal();
        }

        protected void btnRegresar_Click(object sender, EventArgs e)
        {
            Response.Redirect("GestionarDocumentoDeVenta.aspx");
        }
        private void CargarMonedas()
        {
            // Asume que existe un método en monedaDAO para listar las monedas
            monedaDAO = new MonedaWSClient();
            listarMonedas = new BindingList<moneda>(monedaDAO.listarMoneda());
            ddlMonedas.DataSource = listarMonedas;
            ddlMonedas.DataTextField = "nombre";
            ddlMonedas.DataValueField = "idMoneda";
            ddlMonedas.DataBind();
        }
        protected void btnRegistrar_Click(object sender, EventArgs e)
        {
            // Validar si los campos obligatorios están llenos
            if (string.IsNullOrEmpty(dtpFechaEmision.Text) ||
                ddlPersonaJuridica.SelectedValue == "" ||
                ddlSucursal.SelectedValue == "" ||
                ddlCajeros.SelectedValue == "" ||
                ddlMonedas.SelectedValue == "" ||
                ddlTarjetas.SelectedValue == "" ||
                productosSeleccionados.Count == 0)
            {
                // Mostrar mensaje de error
                ClientScript.RegisterStartupScript(this.GetType(), "alert", "alert('Por favor, complete todos los campos obligatorios y agregue al menos un producto.');", true);
                return;
            }

            Factura_VentaWSClient facturaVentaDAO;
            personaJuridica persona = new personaJuridica();
            persona.id_Persona = Int32.Parse(ddlPersonaJuridica.SelectedValue);

            //Ingresar moneda
            moneda moneda = new moneda();
            moneda.idMoneda = Int32.Parse(ddlMonedas.SelectedValue);
            //Ingresar cajero
            cajero cajero = new cajero();
            cajero.idEmpleado = int.Parse(ddlCajeros.SelectedValue);
            //Ingresar tarjeta
            tarjeta tarjeta = new tarjeta();
            tarjeta.idTarjeta = int.Parse(ddlTarjetas.SelectedValue);

            //Llenar linea documento de venta
            // Crear las líneas de documento de venta a partir de los productos seleccionados
            var lineasDocVenta = new BindingList<lineaDoc>();
            foreach (var producto in productosSeleccionados)
            {
                var linea = new lineaDoc
                {
                    producto = new productoPrecio { idProductoPrecio = producto.prodPrecio.idProductoPrecio },
                    documento = new facturaVenta(),
                    precioUnitario = producto.prodPrecio.precio, // Asumiendo que 'precio' es el precio unitario del producto
                    cantidad = producto.cantidadComprada, // Ajusta esto según cómo obtienes la cantidad del producto
                    precioTotal = producto.prodPrecio.precio * producto.cantidadComprada,
                    subTotal = producto.prodPrecio.precio * producto.cantidadComprada, // Puedes ajustar esto si tienes un cálculo diferente para el subtotal
                };
                lineasDocVenta.Add(linea);
            }

            //Llenar factura de Ventas
            facturaVenta facturaVenta = new facturaVenta();

            facturaVenta.fechaVencSpecified = true;
            facturaVenta.fecha_emisionSpecified = true;
            facturaVenta.fecha_emision = DateTime.Parse(dtpFechaEmision.Text);
            facturaVenta.fechaVenc = DateTime.Parse(dtpFechaEmision.Text).AddDays(30);
            facturaVenta.moneda = new moneda { idMoneda = moneda.idMoneda };
            facturaVenta.empleado = new cajero { idEmpleado = cajero.idEmpleado };
            facturaVenta.detalles = "Compra realizada por persona juridica";
            facturaVenta.personaJuridica = persona;
            facturaVenta.lineasDocVenta = lineasDocVenta.ToArray();
            facturaVenta.total = devuelve();
            facturaVenta.montoTotal = devuelve() * 1.18;
            facturaVenta.tarjeta = new tarjeta { idTarjeta = tarjeta.idTarjeta };

            facturaVentaDAO = new Factura_VentaWSClient();
            int resultado = facturaVentaDAO.insertarFacturaVenta(facturaVenta);
            // Insertar líneas de documento de venta
            LineaDocWSClient lineaDocDAO = new LineaDocWSClient();
            int result;
            foreach (var linea in lineasDocVenta)
            {
                linea.documento = new documento();
                linea.documento.id_documento = resultado;
                result = lineaDocDAO.insertarLineaDoc(linea);
            }

            // Limpiar la sesión y redirigir a la página de listado
            Session["ProductosSeleccionados"] = null;
            Response.Redirect("ListarDocumentoDeVenta.aspx");
        }

        private void CalcularTotal()
        {
            double total = productosSeleccionados.Sum(p => p.prodPrecio.precio * p.cantidadComprada);
            lblTotal.Text = total.ToString("C");
        }
        private double devuelve()
        {
            return productosSeleccionados.Sum(p => p.prodPrecio.precio * p.cantidadComprada);
        }
    }
}