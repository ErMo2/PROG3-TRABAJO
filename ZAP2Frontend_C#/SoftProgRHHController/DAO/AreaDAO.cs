using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SoftProgRRHHModel
{
    public interface AreaDAO
    {
        int insertar(Area area);
        BindingList<Area> listarAreas();
    }
}
