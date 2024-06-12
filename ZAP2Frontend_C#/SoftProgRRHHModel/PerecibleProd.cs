using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SoftProgRRHHModel
{
    public class PerecibleProd:Producto
    {
        private UnidadMedida unidadMedida;
        private TipoPerecible tipoPerecible;
        private DateTime fechaVencimiento;

        public UnidadMedida UnidadMedida { get => unidadMedida; set => unidadMedida = value; }
        public TipoPerecible TipoPerecible { get => tipoPerecible; set => tipoPerecible = value; }
        public DateTime FechaVencimiento { get => fechaVencimiento; set => fechaVencimiento = value; }
    }
}
