using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Exercicio1_Quest6
{
    class Program
    {
        static void Main(string[] args)
        {
            double real, val, dol; 

            Console.WriteLine("Digite o valor em Reais (Sem R$ e com .)");
            real = double.Parse (Console.ReadLine());

            Console.WriteLine("Digite a cotação do Dolar (Sem R$ e com .)");
            dol = double.Parse (Console.ReadLine());

            val = real * dol;

            Console.WriteLine("R$" + real + " convertido para Dolar fica " + val);
            Console.ReadKey();
        }
    }
}
