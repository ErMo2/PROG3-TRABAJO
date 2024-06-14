using InterfacesTrabajoGrupal.ServicioWS;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace InterfacesTrabajoGrupal
{
    public partial class EmpleadoArea : System.Web.UI.Page
    {
        private EmpleadoDeAreaWSClient daoEmpleado;
        private empleadoDeArea empleado;
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                int idEmpleadoArea;
                if (int.TryParse(Request.QueryString["id"], out idEmpleadoArea))
                {
                    CargarEmpleadoArea(idEmpleadoArea);
                }
            }
        }
        private void CargarEmpleadoArea(int idEmpleadoArea)
        {
            daoEmpleado = new EmpleadoDeAreaWSClient();

            empleado = daoEmpleado.buscarEmpleadoArea(idEmpleadoArea);

            if (empleado != null)
            {
                txtIdEmpleado.Text = empleado.idEmpleado.ToString();
                txtNombre.Text = empleado.nombre;
                txtApellido_Paterno.Text = empleado.apellido_paterno;
                txtApellido_Materno.Text = empleado.apellido_materno;
                txtTelefono.Text = empleado.telefono.ToString();
                txtEmail.Text = empleado.email;
                TxtTipoDocumento.Text = empleado.tipo_documento.ToString();
                txtNumeroDocumento.Text = empleado.nro_documento.ToString();
                if (empleado.sexo == 'F')
                    rbFemenino.Checked = true;
                else
                    rbMasculino.Checked = true;
                txtDireccion.Text = empleado.direccion.ToString();
                txtSalario.Text = empleado.salario.ToString();
                dtpFechaContratacion.Value = empleado.fechaContratacion.ToString("yyyy-MM-dd");
                txtTurno.Text = empleado.horario.ToString();
                txtContrato.Text = empleado.tipoContrato.ToString();
            }

        }
        protected void btnRegresar_Click(object sender, EventArgs e)
        {
            Response.Redirect("GestionarEmpleados.aspx");
        }
        protected void btnRegistrar_Click(object sender, EventArgs e)
        {
            Response.Redirect("ListarEmpleados.aspx");
        }
    }
}