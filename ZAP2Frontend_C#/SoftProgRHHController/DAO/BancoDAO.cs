using SoftProgRRHHModel;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SoftProgRHHController.DAO
{
    public interface BancoDAO
    {
        int insertar(BancoAfiliado banco);
    }
}
