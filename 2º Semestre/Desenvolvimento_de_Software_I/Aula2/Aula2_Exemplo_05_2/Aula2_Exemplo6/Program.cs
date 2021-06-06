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
            char opcao;
            int i = 1;

            do{

            Console.WriteLine("I. Inclusão");
            Console.WriteLine("A. Alteração");
            Console.WriteLine("E. Exclusão");

            Console.Write("\nDigite sua opção:");
            opcao = char.Parse(Console.ReadLine());

            switch (opcao)   // inicio do switch
            {
                case 'I': Console.WriteLine("\nVocê escolheu Inclusão");
                    break;

                case 'A': Console.WriteLine("\nVocê escolheu Alteração");
                    break;

                case 'E': Console.WriteLine("\nVocê escolheu Exclusão");
                    break;

                default:
                    Console.WriteLine("\nOpção invalida");
                    Console.Clear();
                    break;
                    
            }

            }while (i == 0);

            Console.ReadKey();
        }
    }
}