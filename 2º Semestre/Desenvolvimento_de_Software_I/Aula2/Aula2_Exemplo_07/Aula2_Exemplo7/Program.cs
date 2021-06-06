using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Aula2_Exemplo7
{
    class Program
    {
        static void Main(string[] args)
        {
            int x;

            for (x = 99999999; x > -1; x--)
            {
                Console.WriteLine("{0}{0}{0}{0}{0}{0}{0}{0}{0}", x);
            }

            Console.ReadKey();
        }
    }
}
