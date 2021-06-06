using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Aula2_Exemplo5
{
    class Program
    {
        static void Main(string[] args)
        {
            int opcao;

            Console.WriteLine("1. Inclusão");
            Console.WriteLine("2. Alteração");
            Console.WriteLine("3. Exclusão");

            Console.Write("\nDigite sua opção:");
            opcao = int.Parse(Console.ReadLine());

            switch (opcao)   // inicio do switch
            {
                case 1: Console.WriteLine("\n Você escolheu Inclusão");
                    break;

                case 2: Console.WriteLine("\n Você escolheu Alteração");
                    break;

                case 3: Console.WriteLine("\n Você escolheu Exclusão");
                    break;

                default:
                    Console.WriteLine("\n Opção invalida");
                    break;
            }
            Console.ReadKey();
        }
    }
}