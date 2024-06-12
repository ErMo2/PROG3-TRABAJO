using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SoftProgRRHHModel
{
    public class HogarProd:Producto
    {
        private UnidadMedida unidadMedida;
        private string tipo;

        public UnidadMedida UnidadMedida { get => unidadMedida; set => unidadMedida = value; }
        public string Tipo { get => tipo; set => tipo = value; }
    }
}
