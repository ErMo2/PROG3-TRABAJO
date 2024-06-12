using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SoftProgRRHHModel
{
    public class RopaProd:Producto
    {
        private string temporada;
        private string material;
        private TipoRopa tipo;

        public string Temporada { get => temporada; set => temporada = value; }
        public string Material { get => material; set => material = value; }
        public TipoRopa Tipo { get => tipo; set => tipo = value; }
    }
}
