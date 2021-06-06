using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Exercicio01
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

            Console.WriteLine("Data:");
            Console.Write("Dia: ");
            dataNasc.dia = int.Parse(Console.ReadLine());
            Console.Write("Mês: ");
            dataNasc.mes = int.Parse(Console.ReadLine());
            Console.Write("Ano: ");
            dataNasc.ano = int.Parse(Console.ReadLine());
            Console.Write("Data inválida, digite novamente");
            Console.Clear();

            if (dataNasc.dia <= 31 && dataNasc.dia >= 1 && dataNasc.mes <= 12 && dataNasc.mes >= 1)
            {
                Console.Write("\n\nData informada: ");
                Console.WriteLine("{0}/{1}/{2} \n\n", dataNasc.dia, dataNasc.mes, dataNasc.ano);
            }

            else
                Console.Write("\n\nData incorreta");

            Console.ReadKey();
        }
    }
}
