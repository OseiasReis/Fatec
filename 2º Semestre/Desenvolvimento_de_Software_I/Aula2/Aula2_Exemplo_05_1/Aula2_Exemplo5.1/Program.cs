using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Runtime.InteropServices;

namespace Aula2_Exemplo5
{
    class Program
    {
        static void Main(string[] args)
        {
            string opcao;
            int i = 1;

            do{
           
            Console.WriteLine("Inclusão");
            Console.WriteLine("Alteração");
            Console.WriteLine("Exclusão");

            Console.Write("\nDigite sua opção:");
            opcao = Console.ReadLine();

            switch (opcao)   // inicio do switch
            {
                case "Inclusão": Console.WriteLine("\nVocê escolheu Inclusão");
                    break;

                case "Alteração": Console.WriteLine("\nVocê escolheu Alteração");
                    break;

                case "Exclusão": Console.WriteLine("\nVocê escolheu Exclusão");
                    break;

                default:
                    Console.Clear();
                    Console.WriteLine("\nOpção invalida");
                    i = 0;
                    break;
            }

            }while (i == 0);

            Console.ReadKey();
        }
    }
}