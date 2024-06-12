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
    public partial class ListarEmpleados : System.Web.UI.Page
    {
        private EmpleadoDeAreaWSClient daoEmpleadoArea;
        private CajeroWSClient daoCajero;
        private SupervisorWSClient daoSupervisor;

        private BindingList<empleadoDeArea> empleadosArea;
        private BindingList<cajero> cajeros;
        private BindingList<supervisor> supervisores;

        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                CargarDatos();
            }
        }

        private void CargarDatos()
        {
            daoEmpleadoArea = new EmpleadoDeAreaWSClient();
            daoCajero = new CajeroWSClient();
            daoSupervisor = new SupervisorWSClient();

            empleadoDeArea[] listaEmpleadosArea = daoEmpleadoArea.listarEmpleadoArea();
            cajero[] listaCajeros = daoCajero.listarCajeros();
            supervisor[] listaSupervisores = daoSupervisor.listarSupervisores();

            if (listaEmpleadosArea != null)
                empleadosArea = new BindingList<empleadoDeArea>(listaEmpleadosArea);
            if (listaCajeros != null)
                cajeros = new BindingList<cajero>(listaCajeros);
            if (listaSupervisores != null)
                supervisores = new BindingList<supervisor>(listaSupervisores);

            gvEmpleadosArea.DataSource = empleadosArea;
            gvCajeros.DataSource = cajeros;
            gvSupervisores.DataSource = supervisores;

            gvEmpleadosArea.DataBind();
            gvCajeros.DataBind();
            gvSupervisores.DataBind();

            ViewState["EmpleadosArea"] = empleadosArea;
            ViewState["Cajeros"] = cajeros;
            ViewState["Supervisores"] = supervisores;
        }

        protected void lbRegistrarEmpleado_Click(object sender, EventArgs e)
        {
            Response.Redirect("SeleccionarTipoDeEmpleado.aspx");
        }

        protected void VerArea_Click(object sender, EventArgs e)
        {
            int idEmpleado = Int32.Parse(((LinkButton)sender).CommandArgument);
            BindingList<empleadoDeArea> empleados = ViewState["EmpleadosArea"] as BindingList<empleadoDeArea>;
            var empleado = empleados.FirstOrDefault(x => x.idEmpleado == idEmpleado);
            if (empleado != null)
            {
                lblNombreArea.Text = empleado.nombre;
                lblTelefonoArea.Text = empleado.telefono.ToString();
                lblEmailArea.Text = empleado.email;
                lblSexoArea.Text = empleado.sexo.ToString();
                lblSalarioArea.Text = empleado.salario.ToString();
                lblHorarioArea.Text = empleado.horario.ToString();

                ScriptManager.RegisterStartupScript(this, this.GetType(), "ShowModal", "$('#detallesArea').modal('show');", true);
            }
        }

        protected void VerCajero_Click(object sender, EventArgs e)
        {
            int idEmpleado = Int32.Parse(((LinkButton)sender).CommandArgument);
            BindingList<cajero> empleados = ViewState["Cajeros"] as BindingList<cajero>;
            var empleado = empleados.FirstOrDefault(x => x.idEmpleado == idEmpleado);
            if (empleado != null)
            {
                lblNombreCajero.Text = empleado.nombre;
                lblTelefonoCajero.Text = empleado.telefono.ToString();
                lblEmailCajero.Text = empleado.email.ToString();
                lblSexoCajero.Text = empleado.sexo.ToString();
                lblSalarioCajero.Text = empleado.salario.ToString();
                lblHorarioCajero.Text = empleado.horario.ToString();

                ScriptManager.RegisterStartupScript(this, this.GetType(), "ShowModal", "$('#detallesCajero').modal('show');", true);
            }
        }

        protected void VerSupervisor_Click(object sender, EventArgs e)
        {
            int idEmpleado = Int32.Parse(((LinkButton)sender).CommandArgument);
            BindingList<supervisor> empleados = ViewState["Supervisores"] as BindingList<supervisor>;
            var empleado = empleados.FirstOrDefault(x => x.idEmpleado == idEmpleado);
            if (empleado != null)
            {
                lblNombreSupervisor.Text = empleado.nombre;
                lblTelefonoSupervisor.Text = empleado.telefono.ToString();
                lblEmailSupervisor.Text = empleado.email;
                lblSexoSupervisor.Text = empleado.sexo.ToString();
                lblSalarioSupervisor.Text = empleado.salario.ToString();
                lblHorarioSupervisor.Text = empleado.horario.ToString();

                ScriptManager.RegisterStartupScript(this, this.GetType(), "ShowModal", "$('#detallesSupervisor').modal('show');", true);
            }
        }
    }
}