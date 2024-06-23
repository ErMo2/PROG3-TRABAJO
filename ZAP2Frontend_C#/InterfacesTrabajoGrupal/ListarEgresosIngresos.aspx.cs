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
    public partial class ListarEgresosIngresos : System.Web.UI.Page
    {
        private Documento_de_CompraWSClient daoEmpleadoArea;
        private Documento_de_VentaWSClient daoCajero;
        private SupervisorWSClient daoSupervisor;

        private BindingList<documentoDeCompra> empleadosArea;
        private BindingList<documentoDeVenta> cajeros;
        private BindingList<supervisor> supervisores;

        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                DateTime inicio = new DateTime(2000, 5, 10);
                DateTime final = new DateTime(2500, 5, 10);
                CargarDatosEgresos(inicio, final);
                CargarDatosIngresos(inicio, final);
            }
        }

        private void CargarDatosEgresos(DateTime ini, DateTime fin)
        {
            daoEmpleadoArea = new Documento_de_CompraWSClient();

            documentoDeCompra[] listaEmpleadosArea = daoEmpleadoArea.listarEgresos(ini, fin);

            if (listaEmpleadosArea != null)
                empleadosArea = new BindingList<documentoDeCompra>(listaEmpleadosArea);
            else
                empleadosArea = new BindingList<documentoDeCompra>(); // Inicializa aunque esté vacío

            gvEmpleadosArea.DataSource = empleadosArea;

            gvEmpleadosArea.DataBind();

            ViewState["EmpleadosArea"] = empleadosArea;
        }
        protected void CargarDatosIngresos(DateTime ini, DateTime fin)
        {
            daoCajero = new Documento_de_VentaWSClient();
            documentoDeVenta[] listaCajeros =daoCajero.listarIngresos(ini, fin);
            if (listaCajeros != null)
                cajeros = new BindingList<documentoDeVenta>(listaCajeros);
            else
                cajeros = new BindingList<documentoDeVenta>(); // Inicializa aunque esté vacío
            gvCajeros.DataSource = cajeros;
            gvCajeros.DataBind();
            ViewState["Cajeros"] = cajeros;
        }


        protected void lbRegistrarEmpleado_Click(object sender, EventArgs e)
        {
            DateTime fechaIni;
            DateTime fechaFin;
            DateTime.TryParse(dtpFechaIni.Value, out fechaIni);
            DateTime.TryParse(dtpFechaFin.Value, out fechaFin);
            CargarDatosEgresos(fechaIni, fechaFin);
        }

        protected void lbRegistrarEmpleado2_Click(object sender, EventArgs e)
        {
            DateTime fechaIni;
            DateTime fechaFin;
            DateTime.TryParse(dtpFechaIni2.Value, out fechaIni);
            DateTime.TryParse(dtpFechaFin2.Value, out fechaFin);
            CargarDatosIngresos(fechaIni, fechaFin);
        }
        protected void gvEmpleadosArea_PageIndexChanging(object sender, GridViewPageEventArgs e)
        {
            gvEmpleadosArea.PageIndex = e.NewPageIndex;
            gvEmpleadosArea.DataSource = ViewState["EmpleadosArea"] as BindingList<documentoDeCompra>;
            gvEmpleadosArea.DataBind();
        }

        protected void gvEmpleadosArea_RowCommand(object sender, GridViewCommandEventArgs e)
        {
            daoEmpleadoArea = new Documento_de_CompraWSClient();
            int idEmpleadoArea = Convert.ToInt32(e.CommandArgument);
            if (e.CommandName == "VerEmpleadoArea")
            {
                VerEmpleadoArea(idEmpleadoArea);
            }
        }

        protected void gvCajeros_PageIndexChanging(object sender, GridViewPageEventArgs e)
        {
            gvCajeros.PageIndex = e.NewPageIndex;
            gvCajeros.DataSource = ViewState["Cajeros"] as BindingList<documentoDeVenta>;
            gvCajeros.DataBind();
        }

        protected void gvCajeros_RowCommand(object sender, GridViewCommandEventArgs e)
        {
            daoCajero = new Documento_de_VentaWSClient();
            int idCajero = Convert.ToInt32(e.CommandArgument);
            if (e.CommandName == "VerCajero")
            {
                VerCajero(idCajero);
            }
        }



        private void VerEmpleadoArea(int idEmpleadoArea)
        {
            BindingList<empleadoDeArea> empleados = ViewState["EmpleadosArea"] as BindingList<empleadoDeArea>;
            var empleado = empleados.FirstOrDefault(x => x.idEmpleado == idEmpleadoArea);
            if (empleado != null)
            {
                lblDetallesEmpleado.Text = $"<strong>Nombre:</strong> {empleado.nombre}<br/>" +
                                           $"<strong>Teléfono:</strong> {empleado.telefono}<br/>" +
                                           $"<strong>Email:</strong> {empleado.email}<br/>" +
                                           $"<strong>Sexo:</strong> {empleado.sexo}<br/>" +
                                           $"<strong>Salario:</strong> {empleado.salario}<br/>" +
                                           $"<strong>Horario:</strong> {empleado.horario}<br/>";
                ScriptManager.RegisterStartupScript(this, this.GetType(), "ShowModal", "$('#verEmpleadoModal').modal('show');", true);
            }
        }

        private void VerCajero(int idCajero)
        {
            BindingList<cajero> empleados = ViewState["Cajeros"] as BindingList<cajero>;
            var empleado = empleados.FirstOrDefault(x => x.idEmpleado == idCajero);
            if (empleado != null)
            {
                lblDetallesEmpleado.Text = $"<strong>Nombre:</strong> {empleado.nombre}<br/>" +
                                           $"<strong>Teléfono:</strong> {empleado.telefono}<br/>" +
                                           $"<strong>Email:</strong> {empleado.email}<br/>" +
                                           $"<strong>Sexo:</strong> {empleado.sexo}<br/>" +
                                           $"<strong>Salario:</strong> {empleado.salario}<br/>" +
                                           $"<strong>Horario:</strong> {empleado.horario}<br/>";
                ScriptManager.RegisterStartupScript(this, this.GetType(), "ShowModal", "$('#verEmpleadoModal').modal('show');", true);
            }
        }

        private void VerSupervisor(int idSupervisor)
        {
            BindingList<supervisor> empleados = ViewState["Supervisores"] as BindingList<supervisor>;
            var empleado = empleados.FirstOrDefault(x => x.idEmpleado == idSupervisor);
            if (empleado != null)
            {
                lblDetallesEmpleado.Text = $"<strong>Nombre:</strong> {empleado.nombre}<br/>" +
                                           $"<strong>Teléfono:</strong> {empleado.telefono}<br/>" +
                                           $"<strong>Email:</strong> {empleado.email}<br/>" +
                                           $"<strong>Sexo:</strong> {empleado.sexo}<br/>" +
                                           $"<strong>Salario:</strong> {empleado.salario}<br/>" +
                                           $"<strong>Horario:</strong> {empleado.horario}<br/>";
                ScriptManager.RegisterStartupScript(this, this.GetType(), "ShowModal", "$('#verEmpleadoModal').modal('show');", true);
            }
        }



        protected void gvEmpleadosArea_RowDataBound(object sender, GridViewRowEventArgs e)
        {

        }

        protected void gvCajeros_RowDataBound(object sender, GridViewRowEventArgs e)
        {

        }

        protected void gvSupervisores_RowDataBound(object sender, GridViewRowEventArgs e)
        {
            if (e.Row.RowType == DataControlRowType.DataRow)
            {
                e.Row.Cells[4].Text = Convert.ToChar(DataBinder.Eval(e.Row.DataItem, "sexo")).ToString();
            }
        }
    }
}