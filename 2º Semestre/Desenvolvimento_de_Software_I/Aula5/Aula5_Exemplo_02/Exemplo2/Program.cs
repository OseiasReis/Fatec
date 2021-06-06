using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace ConsoleApplication1
{
    class Program
    {
        public struct Data
        {
            public int dia, mes, ano;
        }

        static void Main(string[] args)
        {
            Data dataNasc;

            Console.WriteLine("Data do seu nascimento");
            Console.Write("Dia: ");
            dataNasc.dia = int.Parse(Console.ReadLine());
            Console.Write("Mês: ");
            dataNasc.mes = int.Parse(Console.ReadLine());
            Console.Write("Ano: ");
            dataNasc.ano = int.Parse(Console.ReadLine());

            Console.Write("\n\nData de nascimento informada: ");
            Console.WriteLine("{0}/{1}/{2} \n\n", dataNasc.dia, dataNasc.mes, dataNasc.ano);

            Console.ReadKey();
        }
    }
}
